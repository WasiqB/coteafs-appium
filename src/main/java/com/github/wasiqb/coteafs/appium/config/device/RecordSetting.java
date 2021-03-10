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

import static java.lang.String.format;

import io.appium.java_client.ios.IOSStartScreenRecordingOptions.VideoQuality;
import lombok.Data;

/**
 * @author wasiqb
 * @since Oct 13, 2018
 */
@Data
public class RecordSetting {
    private int          bitRate  = 4;
    private int          duration = 3;
    private boolean      enabled;
    private String       path     = format ("%s/videos", System.getProperty ("user.dir"));
    private String       prefix   = "VID";
    private VideoQuality quality  = VideoQuality.MEDIUM;
    private String       size;
}