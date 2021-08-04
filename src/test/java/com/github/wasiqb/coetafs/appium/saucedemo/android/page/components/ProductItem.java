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
package com.github.wasiqb.coetafs.appium.saucedemo.android.page.components;

import static com.github.wasiqb.coteafs.appium.config.enums.WaitStrategy.VISIBLE;
import static com.github.wasiqb.coteafs.appium.device.DeviceElement.create;
import static io.appium.java_client.MobileBy.AccessibilityId;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

public class ProductItem extends AndroidActivity {
    public static final String ADD_CART    = "Add to Cart";
    public static final String DESCRIPTION = "Product Description";
    public static final String DRAG_HANDLE = "Product Drag handle";
    public static final String PRICE       = "Product Price";
    public static final String TITLE       = "Product Title";

    protected ProductItem (final AndroidDevice device) {
        super (device);
    }

    @Override
    protected DeviceElement prepare () {
        final DeviceElement item = create ("Product Item").forAndroid (AccessibilityId ("test-Item"));

        create (TITLE).parent (item)
            .forAndroid (AccessibilityId ("test-Item title"))
            .waitStrategy (VISIBLE);
        create (DESCRIPTION).parent (item)
            .forAndroid (AccessibilityId ("test-Item description"))
            .waitStrategy (VISIBLE);
        create (PRICE).parent (item)
            .forAndroid (AccessibilityId ("test-Price"))
            .waitStrategy (VISIBLE);
        create (DRAG_HANDLE).parent (item)
            .forAndroid (AccessibilityId ("test-Drag Handle"))
            .waitStrategy (VISIBLE);
        create (ADD_CART).parent (item)
            .forAndroid (AccessibilityId ("test-ADD TO CART"))
            .waitStrategy (VISIBLE);

        return item;
    }
}
