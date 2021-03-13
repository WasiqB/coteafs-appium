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
package com.github.wasiqb.coteafs.appium.config.enums;

/**
 * @author Wasiq Bhamla
 * @since Mar 13, 2021
 */
public enum VideoQuality {
    HD (100),
    HIGH (75),
    LOW (25),
    MEDIUM (50);

    private final int quality;

    VideoQuality (final int quality) {
        this.quality = quality;
    }

    public int getQuality () {
        return this.quality;
    }
}