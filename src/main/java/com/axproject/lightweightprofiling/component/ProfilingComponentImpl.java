package com.axproject.lightweightprofiling.component;

import com.axproject.lightweightprofiling.utils.lib.profiling.annotation.ProfileClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@ProfileClass
@Component
public class ProfilingComponentImpl implements Profiling {

    @Value("${profile.low}")
    private long low;

    @Value("${profile.medium}")
    private long medium;

    @Value("${profile.hard}")
    private long hard;

    @Override
    public void lowProfiling() throws Exception{
        Thread.sleep(low);
    }

    @Override
    public void mediumProfiling() throws Exception {
        Thread.sleep(medium);
    }

    @Override
    public void hardProfiling() throws Exception {
        Thread.sleep(hard);
    }

}
