package com.axproject.lightweightprofiling.utils.lib.profiling.annotation;

import com.axproject.lightweightprofiling.utils.lib.profiling.ProfileController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class ProfilingClassHandlerAnnotationBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<>();
    private ProfileController controller = new ProfileController();

    public ProfilingClassHandlerAnnotationBeanPostProcessor() throws Exception{
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "profiling"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(ProfileClass.class)) {
            map.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class beanClass = map.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (controller.isEnabled()) {
                        System.out.println();
                        System.out.println("START PROFILING");
                        long before = System.nanoTime();
                        Object retVal = method.invoke(bean, args);
                        long after = System.nanoTime();
                        long sec = TimeUnit.SECONDS.convert(after-before, TimeUnit.NANOSECONDS);
                        System.out.println(sec + " sec");
                        System.out.println("END PROFILING");
                        return retVal;
                    } else {
                        return method.invoke(bean, args);
                    }
                }
            });
        }

        return bean;
    }
}
