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

import static com.github.wasiqb.coteafs.appium.config.enums.SwipeDirection.DOWN;
import static com.github.wasiqb.coteafs.appium.config.enums.SwipeDirection.UP;
import static com.github.wasiqb.coteafs.appium.config.enums.SwipeStartPosition.CENTER;

import com.github.wasiqb.coteafs.appium.android.AndroidActivityActions;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.VerticleSwipeActivity;

/**
 * @author Wasiq Bhamla
 * @since 14-Mar-2021
 */
public class VerticalSwipeAction extends AndroidActivityActions {
    /**
     * @param device Device instance
     *
     * @author wasiq.bhamla
     * @since Oct 23, 2017 11:05:14 PM
     */
    public VerticalSwipeAction (final AndroidDevice device) {
        super (device);
    }

    @Override
    public void perform () {
        final VerticleSwipeActivity vs = new VerticleSwipeActivity (getDevice ());
        vs.onElement ("List")
            .swipe (UP, CENTER, 25);
        vs.onElement ("List")
            .swipe (DOWN, CENTER, 25);
    }
}
