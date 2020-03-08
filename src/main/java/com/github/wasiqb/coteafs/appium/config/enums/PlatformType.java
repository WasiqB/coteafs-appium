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
package com.github.wasiqb.coteafs.appium.config.enums;

import io.appium.java_client.remote.MobilePlatform;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:34:59 PM
 */
public enum PlatformType {
    /**
     * Android Device.
     */
    ANDROID(MobilePlatform.ANDROID),
    /**
     * iOS Device.
     */
    IOS(MobilePlatform.IOS),
    /**
     * Windows Device.
     */
    WINDOWS(MobilePlatform.WINDOWS);

    private final String name;

    PlatformType(final String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.name;
    }
}