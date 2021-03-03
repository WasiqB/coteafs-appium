/*
 * Copyright (c) 2017, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.wasiqb.coteafs.appium.android;

import com.github.wasiqb.coteafs.appium.config.enums.AutomationType;
import com.github.wasiqb.coteafs.appium.device.DeviceElementActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author wasiq.bhamla
 * @since 02-May-2017 6:31:57 PM
 */
public class AndroidDeviceElementActions
    extends DeviceElementActions<AndroidDriver<MobileElement>, AndroidDevice, AndroidTouchAction> {
    private static final Logger log = LogManager.getLogger (AndroidDeviceElementActions.class);

    /**
     * @param device
     * @param name
     * @param element
     *
     * @author wasiq.bhamla
     * @since 02-May-2017 6:32:14 PM
     */
    public AndroidDeviceElementActions (final AndroidDevice device, final String name, final MobileElement element) {
        super (device, name, element, new AndroidTouchAction (device.getDriver ()));
    }

    /*
     * (non-Javadoc)
     * @see com.github.wasiqb.coteafs.appium.device.DeviceElementActions#pinch(int)
     */
    @Override
    public void pinch (final int distance) {
        if (this.device.getSetting ()
            .getAutomation () == AutomationType.ESPRESSO) {
            super.pinch (distance);
        } else {
            log.warn ("Pinch is only available when Automation type is Espresso...");
        }
    }

    /*
     * (non-Javadoc)
     * @see com.github.wasiqb.coteafs.appium.device.DeviceElementActions#verifyThat()
     */
    @Override
    public AndroidElementVerify verifyThat () {
        return new AndroidElementVerify (this);
    }

    /*
     * (non-Javadoc)
     * @see com.github.wasiqb.coteafs.appium.device.DeviceElementActions#zoom(int)
     */
    @Override
    public void zoom (final int distance) {
        if (this.device.getSetting ()
            .getAutomation () == AutomationType.ESPRESSO) {
            super.zoom (distance);
        } else {
            log.warn ("Zoom is only available when Automation type is Espresso...");
        }
    }
}