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
package com.github.wasiqb.coteafs.appium.config.device.ios;

import lombok.Data;

/**
 * @author wasiq.bhamla
 * @since Jan 18, 2018 9:11:11 PM
 */
@Data
public class IOSDeviceSetting {
    private IOSAppSetting app = new IOSAppSetting ();
    private boolean       autoAcceptAlerts;
    private WDASetting    wda = new WDASetting ();
    private IOSWebSetting web = new IOSWebSetting ();
}