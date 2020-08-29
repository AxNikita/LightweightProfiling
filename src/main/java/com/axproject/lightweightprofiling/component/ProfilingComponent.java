package com.axproject.lightweightprofiling.component;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Profile
@Component
public class ProfilingComponent implements Profiling {

    private long low = 100;
    private long medium = 1000;
    private long hard = 10000;

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
