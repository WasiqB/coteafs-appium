package com.github.wasiqb.coteafs.appium.ios.webdriverioapp.activities;

import com.github.wasiqb.coteafs.appium.device.DeviceElement;
import com.github.wasiqb.coteafs.appium.ios.IOSActivity;
import com.github.wasiqb.coteafs.appium.ios.IOSDevice;
import io.appium.java_client.MobileBy;

/**
 * @author Faisal Khatri
 * @since Feb 16, 2021
 */
public class BaseActivity extends IOSActivity {
    /**
     * @param device
     *
     * @author Faisal Khatri
     */
    public BaseActivity (final IOSDevice device) {
        super (device);
    }

    @Override
    protected DeviceElement prepare () {
        final DeviceElement main = DeviceElement.create ("Form")
            .forIos (MobileBy.iOSNsPredicateString ("type == 'XCUIElementTypeWindow'"));

        DeviceElement.create ("HomeTab")
            .parent (main)
            .forIos (MobileBy.AccessibilityId ("Home"));
        DeviceElement.create ("WebViewTab")
            .parent (main)
            .forIos (MobileBy.AccessibilityId ("WebView"));
        DeviceElement.create ("LoginTab")
            .parent (main)
            .forIos (MobileBy.iOSNsPredicateString ("label == \"Login\""));
        DeviceElement.create ("FormsTab")
            .parent (main)
            .forIos (MobileBy.AccessibilityId ("Forms"));
        DeviceElement.create ("SwipeTab")
            .parent (main)
            .forIos (MobileBy.AccessibilityId ("Swipe"));

        return main;
    }
}