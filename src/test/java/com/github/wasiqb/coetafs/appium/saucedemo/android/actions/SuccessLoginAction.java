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
package com.github.wasiqb.coetafs.appium.saucedemo.android.actions;

import static com.github.wasiqb.coetafs.appium.saucedemo.android.page.LoginPage.LOGIN_BTN;
import static com.github.wasiqb.coetafs.appium.saucedemo.android.page.LoginPage.PASSWORD;
import static com.github.wasiqb.coetafs.appium.saucedemo.android.page.LoginPage.USER_NAME;

import com.github.wasiqb.coetafs.appium.saucedemo.android.page.LoginPage;
import com.github.wasiqb.coteafs.appium.android.AndroidActivityActions;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;

public class SuccessLoginAction extends AndroidActivityActions {
    public SuccessLoginAction (final AndroidDevice device) {
        super (device);
    }

    @Override
    public void perform () {
        final LoginPage loginPage = new LoginPage (getDevice ());
        loginPage.onElement (USER_NAME)
            .enterText (value (USER_NAME));
        loginPage.onElement (PASSWORD)
            .enterText (PASSWORD);
        loginPage.onElement (LOGIN_BTN)
            .tap ();
    }
}