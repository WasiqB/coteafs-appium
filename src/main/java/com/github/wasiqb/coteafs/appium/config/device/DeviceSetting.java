/*
 *
 *  Copyright (c) 2020, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.appium.config.device;

import java.util.HashMap;
import java.util.Map;

import com.github.wasiqb.coteafs.appium.config.device.android.AndroidDeviceSetting;
import com.github.wasiqb.coteafs.appium.config.device.ios.IOSDeviceSetting;
import com.github.wasiqb.coteafs.appium.config.enums.AutomationType;
import com.github.wasiqb.coteafs.appium.config.enums.Browser;
import com.github.wasiqb.coteafs.appium.config.enums.DeviceType;
import com.github.wasiqb.coteafs.appium.config.enums.PlatformType;
import lombok.Data;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:34:28 PM
 */
@Data
public class DeviceSetting {
    private AndroidDeviceSetting android;
    private boolean              autoWebView;
    private AutomationType       automation        = AutomationType.UIAUTOMATOR2;
    private Browser              browser;
    private Map<String, String>  cloudCapabilities = new HashMap<> ();
    private boolean              headless;
    private IOSDeviceSetting     ios;
    private long                 launchTimeout;
    private String               name;
    private PlatformType         os                = PlatformType.ANDROID;
    private OtherSetting         others            = new OtherSetting ();
    private PlaybackSetting      playback          = new PlaybackSetting ();
    private int                  sessionTimeout    = 60000;
    private DeviceType           type              = DeviceType.SIMULATOR;
    private String               version;

    public boolean isCloud () {
        return getCloudCapabilities ().size () > 0;
    }
}