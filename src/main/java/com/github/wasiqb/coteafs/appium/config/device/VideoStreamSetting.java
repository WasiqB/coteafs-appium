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
package com.github.wasiqb.coteafs.appium.config.device;

import com.github.wasiqb.coteafs.appium.config.enums.VideoQuality;
import lombok.Data;

/**
 * @author Wasiq Bhamla
 * @since Mar 13, 2021
 *
 */
@Data
public class VideoStreamSetting {
    private int          bitRate = 20;
    private boolean      enabled;
    private int          height  = 1024;
    private String       host    = "127.0.0.1";
    private int          port    = 8093;
    private VideoQuality quality = VideoQuality.MEDIUM;
    private int          width   = 700;
}