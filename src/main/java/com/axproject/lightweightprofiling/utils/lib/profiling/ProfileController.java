package com.axproject.lightweightprofiling.utils.lib.profiling;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(
        objectName = "profiling:bean=ProfileController,type=service",
        description = "Description for profiling JMX"
)
public class ProfileController implements ProfileControllerMBean{

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    @ManagedOperation(description = "Operation JMX Profiling")
    @ManagedOperationParameters({@ManagedOperationParameter(name = "enabled", description = "Description for param")})
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
