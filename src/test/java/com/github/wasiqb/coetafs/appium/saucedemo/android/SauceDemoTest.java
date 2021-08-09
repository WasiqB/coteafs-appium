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
package com.github.wasiqb.coetafs.appium.saucedemo.android;

import static com.github.wasiqb.coetafs.appium.saucedemo.android.page.LoginPage.PASSWORD;
import static com.github.wasiqb.coetafs.appium.saucedemo.android.page.LoginPage.USER_NAME;

import com.github.wasiqb.coetafs.appium.saucedemo.android.actions.SuccessLoginAction;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SauceDemoTest {
    private AndroidDevice device;
    private AppiumServer  server;

    @BeforeTest
    @Parameters ({ "server", "device" })
    public void setupTest (@Optional final String serverName, @Optional final String deviceName) {
        this.server = new AppiumServer (serverName);
        this.server.start ();

        this.device = new AndroidDevice (this.server, deviceName);
        this.device.start ();
    }

    @AfterTest
    public void tearDownTest () {
        this.device.stop ();
        this.server.stop ();
    }

    @Test
    public void testLogin () {
        final SuccessLoginAction loginAction = new SuccessLoginAction (this.device);
        loginAction.addInputValue (USER_NAME, "standard_user")
            .addInputValue (PASSWORD, "secret_sauce")
            .perform ();
    }
}