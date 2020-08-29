package com.axproject.lightweightprofiling.utils.lib.profiling.annotation;

import com.axproject.lightweightprofiling.utils.lib.profiling.ProfileController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

@Component
public class ProfilingMethodHandlerAnnotationBeanPostProcessor implements BeanPostProcessor {

    private ProfileController controller = new ProfileController();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class type = bean.getClass();
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ProfileMethod.class)) {
                Object proxy = Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (controller.isEnabled()) {
                            System.out.println();
                            System.out.println("START PROFILING");
                            long before = System.nanoTime();
                            Object retVal = method.invoke(bean, args);
                            long after = System.nanoTime();
                            long sec = TimeUnit.SECONDS.convert(after - before, TimeUnit.NANOSECONDS);
                            System.out.println(sec + " sec");
                            System.out.println("END PROFILING");
                            return retVal;
                        } else {
                            return method.invoke(bean, args);
                        }
                    }
                });
                return proxy;
            } else {
                return bean;
            }
        }

        return bean;
    }

}
