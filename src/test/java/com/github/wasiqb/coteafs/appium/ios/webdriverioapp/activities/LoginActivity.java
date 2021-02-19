package com.github.wasiqb.coteafs.appium.ios.webdriverioapp.activities;

import com.github.wasiqb.coteafs.appium.device.DeviceElement;
import com.github.wasiqb.coteafs.appium.ios.IOSDevice;
import io.appium.java_client.MobileBy;

/**
 * @author Faisal Khatri
 * @since Feb 16, 2021
 */
public class LoginActivity extends BaseActivity {

    /**
     * @author Faisal Khatri
     * @param device
     */
    public LoginActivity (IOSDevice device) {
        super (device);
    }

    @Override
    protected DeviceElement prepare () {
        final DeviceElement loginForm = super.prepare ();
        DeviceElement.create ("Username")
            .parent (loginForm)
            .forIos (MobileBy.AccessibilityId ("input-email"));
        DeviceElement.create ("Password")
            .parent (loginForm)
            .forIos (MobileBy.AccessibilityId ("input-password"));
        DeviceElement.create ("LoginBtn")
            .parent (loginForm)
            .forIos (MobileBy.AccessibilityId ("button-LOGIN"));
        return loginForm;
    }
}
