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

import static com.github.wasiqb.coteafs.appium.config.enums.WaitStrategy.VISIBLE;
import static com.github.wasiqb.coteafs.appium.device.DeviceElement.create;
import static io.appium.java_client.MobileBy.AccessibilityId;

import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

/**
 * @author wasiq.bhamla
 * @since Jan 23, 2018 8:54:51 PM
 */
public class MainActivity extends DefaultActivity {
    /**
     * @param device Device instance
     *
     * @author wasiq.bhamla
     * @since Jan 23, 2018 8:54:51 PM
     */
    public MainActivity (final AndroidDevice device) {
        super (device);
    }

    /*
     * (non-Javadoc)
     * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#prepare()
     */
    @Override
    protected DeviceElement prepare () {
        final DeviceElement main = super.prepare ();

        final DeviceElement scroll = create ("ScrollView").parent (main)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("scrollView"));

        create ("ChainedView").parent (scroll)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("Chained View"));
        create ("Slider").parent (scroll)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("Slide your number"));
        create ("VerticalSwipe").parent (scroll)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("Demos vertical swiping"));
        create ("DragDrop").parent (scroll)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("Demo drag and drop"));
        create ("DoubleTap").parent (scroll)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("Demo double tap button"));
        create ("LongPress").parent (scroll)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("longPress"));
        create ("PhotoView").parent (scroll)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("Ping & Zoom"));
        create ("WebView").parent (scroll)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("View hacker news"));
        create ("HorizontalSwipe").parent (scroll)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("Demos swipe left & right"));
        create ("WheelPicker").parent (scroll)
            .waitStrategy (VISIBLE)
            .forAndroid (AccessibilityId ("Demos wheel picker color"));

        return main;
    }
}