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
import static org.openqa.selenium.By.id;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

public class DashboardPage extends AndroidActivity {
    public static final String CART      = "Cart";
    public static final String DROP_ZONE = "Drop zone";
    public static final String FILTER    = "Filter";
    public static final String MENU      = "Menu";
    public static final String PRODUCTS  = "Product list";
    public static final String TOGGLE    = "Toggle view";

    protected DashboardPage (final AndroidDevice device) {
        super (device);
    }

    @Override
    protected DeviceElement prepare () {
        final DeviceElement main = create ("Main").forAndroid (id ("android:id/content"));

        create (MENU).parent (main)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("test-Menu"));
        create (CART).parent (main)
            .forAndroid (AccessibilityId ("test-Cart"))
            .waitStrategy (VISIBLE);
        create (DROP_ZONE).parent (main)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("test-Cart drop zone"));
        create (TOGGLE).parent (main)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("test-Toggle"));
        create (FILTER).parent (main)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("test-Modal Selector Button"));
        create (PRODUCTS).parent (main)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("test-PRODUCTS"));

        return main;
    }
}
