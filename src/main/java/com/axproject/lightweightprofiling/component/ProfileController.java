package com.axproject.lightweightprofiling.component;

import org.springframework.stereotype.Component;

public class ProfileController implements ProfileControllerMBean{

    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
