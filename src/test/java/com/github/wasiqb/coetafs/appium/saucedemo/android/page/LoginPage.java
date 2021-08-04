/*
 *
 *  Copyright (c) 2021, Wasiq Bhamla.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.github.wasiqb.coetafs.appium.saucedemo.android.page;

import static com.github.wasiqb.coteafs.appium.config.enums.WaitStrategy.VISIBLE;
import static com.github.wasiqb.coteafs.appium.device.DeviceElement.create;
import static io.appium.java_client.MobileBy.AccessibilityId;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

public class LoginPage extends AndroidActivity {
    public static final String LOGIN_BTN = "Login button";
    public static final String PASSWORD  = "Password";
    public static final String USER_NAME = "User Name";

    public LoginPage (final AndroidDevice device) {
        super (device);
    }

    @Override
    protected DeviceElement prepare () {
        final DeviceElement page = create ("Login Form").forAndroid (AccessibilityId ("test-Login"));

        create (USER_NAME).parent (page)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("test-Username"));
        create (PASSWORD).parent (page)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("test-Password"));
        create (LOGIN_BTN).parent (page)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("test-LOGIN"));

        return page;
    }
}