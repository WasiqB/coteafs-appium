package com.github.wasiqb.coteafs.appium.ios.webdriverioapp.activities;

import com.github.wasiqb.coteafs.appium.device.DeviceElement;
import com.github.wasiqb.coteafs.appium.ios.IOSActivity;
import com.github.wasiqb.coteafs.appium.ios.IOSDevice;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

/**
 * @author Faisal Khatri
 * @since Feb 16, 2021
 */
public class BaseActivity extends IOSActivity {

    /**
     * @author Faisal Khatri
     * @param device
     */
    public BaseActivity (IOSDevice device) {
        super (device);

    }

    @Override
    protected DeviceElement prepare () {

        final DeviceElement main = DeviceElement.create ("Form")
            .forIos (By.name ("Home WebView Login Forms Swipe"));

        DeviceElement.create ("Home")
            .parent (main)
            .forIos (MobileBy.iOSNsPredicateString ("name == 'Home'"));

        DeviceElement.create ("WebView")
            .parent (main)
            .forIos (MobileBy.iOSNsPredicateString ("name == 'WebView'"));

        DeviceElement.create ("Login")
            .parent (main)
            .forIos (MobileBy.iOSNsPredicateString ("name == 'Login'"));

        DeviceElement.create ("Forms")
            .parent (main)
            .forIos (MobileBy.iOSNsPredicateString ("name == 'Forms'"));

        DeviceElement.create ("Swipe")
            .parent (main)
            .forIos (MobileBy.iOSNsPredicateString ("name == 'Swipe'"));

        return main;
    }

}
