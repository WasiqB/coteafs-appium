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
package com.github.wasiqb.coteafs.appium.android.vodqa.activities;

import static com.github.wasiqb.coteafs.appium.config.enums.AutomationType.UIAUTOMATOR2;
import static com.github.wasiqb.coteafs.appium.config.enums.WaitStrategy.PRESENT;
import static com.github.wasiqb.coteafs.appium.device.DeviceElement.create;
import static io.appium.java_client.MobileBy.AndroidUIAutomator;
import static org.openqa.selenium.By.id;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

/**
 * @author wasiq.bhamla
 * @since Jan 24, 2018 5:22:20 PM
 */
public class DefaultActivity extends AndroidActivity {
    /**
     * @param device
     *
     * @author wasiq.bhamla
     * @since Jan 24, 2018 5:22:20 PM
     */
    public DefaultActivity (final AndroidDevice device) {
        super (device);
    }

    /*
     * (non-Javadoc)
     * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#prepare()
     */
    @Override
    protected DeviceElement prepare () {
        final DeviceElement main = create ("Main").waitStrategy (PRESENT)
            .forAndroid (id ("android:id/content"));
        create ("Back").parent (main)
            .waitStrategy (PRESENT)
            .forAndroid (UIAUTOMATOR2, AndroidUIAutomator ("new UiSelector ().text (\"Back\");"));
        return main;
    }
}