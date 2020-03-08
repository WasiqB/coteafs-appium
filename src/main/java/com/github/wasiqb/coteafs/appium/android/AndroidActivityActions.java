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

import com.github.wasiqb.coteafs.appium.device.DeviceActivityActions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;

/**
 * @author wasiq.bhamla
 * @since Oct 23, 2017 11:04:31 PM
 */
public abstract class AndroidActivityActions
    extends DeviceActivityActions<AndroidDriver<MobileElement>, AndroidDevice, AndroidTouchAction> {
    /**
     * @param device
     * @author wasiq.bhamla
     * @since Oct 23, 2017 11:05:14 PM
     */
    public AndroidActivityActions(final AndroidDevice device) {
        super(device);
    }
}