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

import static com.github.wasiqb.coteafs.appium.config.enums.AutomationType.UIAUTOMATOR2;
import static com.github.wasiqb.coteafs.appium.utils.BatteryHealth.check;

import com.github.wasiqb.coteafs.appium.device.DeviceActivity;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 6:19:46 PM
 */
public abstract class AndroidActivity
    extends DeviceActivity<AndroidDriver<MobileElement>, AndroidDevice, AndroidTouchAction> {
    private static final Logger LOG = LogManager.getLogger (AndroidActivity.class);

    /**
     * @param device
     *
     * @author wasiq.bhamla
     * @since 26-Apr-2017 6:20:08 PM
     */
    protected AndroidActivity (final AndroidDevice device) {
        super (device, new AndroidTouchAction (device.getDriver ()));
    }

    /*
     * (non-Javadoc)
     * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#onDevice()
     */
    @Override
    public AndroidDeviceActions onDevice () {
        checkBattery ();
        LOG.trace ("Preparing to perform actions on Android device...");
        return new AndroidDeviceActions (this.device);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.github.wasiqb.coteafs.appium.device.DeviceActivity#onElement(java.lang.
     * String)
     */
    @Override
    public AndroidDeviceElementActions onElement (final String name) {
        checkBattery ();
        LOG.trace ("Preparing to perform actions on Android device element [{}]...", name);
        return new AndroidDeviceElementActions (this.device, name, getElement (name));
    }

    private void checkBattery () {
        if (this.device.getSetting ()
            .getAutomation () == UIAUTOMATOR2 && !this.device.getSetting ()
            .isCloud ()) {
            final AndroidBatteryInfo battery = this.device.getDriver ()
                .getBatteryInfo ();
            check (battery.getState ()
                .name (), battery.getLevel ());
        }
    }
}