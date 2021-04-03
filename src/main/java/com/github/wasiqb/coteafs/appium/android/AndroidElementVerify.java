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

import com.github.wasiqb.coteafs.appium.device.DeviceElementVerify;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;

/**
 * @author wasiq.bhamla
 * @since 20-May-2017 12:26:00 PM
 */
public class AndroidElementVerify
    extends DeviceElementVerify<AndroidDriver<MobileElement>, AndroidDevice, AndroidTouchAction> {
    /**
     * @param actions Actions instance
     *
     * @author wasiq.bhamla
     * @since 20-May-2017 12:26:38 PM
     */
    public AndroidElementVerify (final AndroidDeviceElementActions actions) {
        super (actions);
    }
}