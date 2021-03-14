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
package com.github.wasiqb.coteafs.appium.android.vodqa.actions;

import com.github.wasiqb.coteafs.appium.android.AndroidActivityActions;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.SliderActivity;
import com.github.wasiqb.coteafs.appium.config.enums.SwipeDirection;
import com.github.wasiqb.coteafs.appium.config.enums.SwipeStartPosition;

public class SliderActivityAction extends AndroidActivityActions {
    /**
     * @param device
     *
     * @author wasiq.bhamla
     * @since Oct 23, 2017 11:05:14 PM
     */
    public SliderActivityAction (final AndroidDevice device) {
        super (device);
    }

    @Override
    public void perform () {
        final SliderActivity slide = new SliderActivity (getDevice ());
        slide.onElement ("Slider")
            .swipe (SwipeDirection.RIGHT, SwipeStartPosition.LEFT, 75);
        slide.onElement ("Slider")
            .swipe (SwipeDirection.LEFT, SwipeStartPosition.RIGHT, 75);
        slide.onElement ("Slider1")
            .swipe (SwipeDirection.RIGHT, SwipeStartPosition.LEFT, 25);
    }
}