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

import lombok.Data;

/**
 * @author wasiq.bhamla
 * @since Jan 18, 2018 9:32:14 PM
 */
@Data
public class PlaybackSetting {
    private DelaySetting       delay      = new DelaySetting ();
    private RecordSetting      record     = new RecordSetting ();
    private ScreenshotSetting  screenshot = new ScreenshotSetting ();
    private VideoStreamSetting stream     = new VideoStreamSetting ();
}