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
package com.github.wasiqb.coteafs.appium.android.system;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;
import org.openqa.selenium.By;

/**
 * @author wasiq.bhamla
 * @since Feb 8, 2018 3:44:36 PM
 */
public class AlertActivity extends AndroidActivity {
    /**
     * @param device Device instance
     *
     * @author wasiq.bhamla
     * @since Feb 8, 2018 3:44:36 PM
     */
    public AlertActivity (final AndroidDevice device) {
        super (device);
    }

    /*
     * (non-Javadoc)
     * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#prepare()
     */
    @Override
    protected DeviceElement prepare () {
        final DeviceElement alert = DeviceElement.create ("Alert")
            .forAndroid (By.id ("android:id/parentPanel"));

        DeviceElement.create ("Title")
            .parent (alert)
            .forAndroid (By.id ("android:id/alertTitle"));
        DeviceElement.create ("Message")
            .parent (alert)
            .forAndroid (By.id ("android:id/message"));
        DeviceElement.create ("OK")
            .parent (alert)
            .forAndroid (By.id ("android:id/button1"));

        return alert;
    }
}