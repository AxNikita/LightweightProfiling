package com.axproject.lightweightprofiling.component;

import com.axproject.lightweightprofiling.utils.lib.profiling.annotation.ProfileMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProfilingMethodsComponentImpl implements ProfilingMethods {

    @Value("${profile.low}")
    private long low;

    @Value("${profile.medium}")
    private long medium;

    @Value("${profile.hard}")
    private long hard;

    @ProfileMethod
    @Override
    public void lowProfiling() throws Exception{
        Thread.sleep(low);
    }

    @ProfileMethod
    @Override
    public void mediumProfiling() throws Exception {
        Thread.sleep(medium);
    }

    @ProfileMethod
    @Override
    public void hardProfiling() throws Exception {
        Thread.sleep(hard);
    }

}
