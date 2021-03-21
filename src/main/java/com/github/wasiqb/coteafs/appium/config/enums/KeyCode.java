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

import io.appium.java_client.android.nativekey.AndroidKey;

/**
 * @author Wasiq Bhamla
 * @since 21-Mar-2021
 */
public enum KeyCode {
    HOME (AndroidKey.HOME),
    POWER (AndroidKey.POWER),
    VOLUME_UP (AndroidKey.VOLUME_UP),
    VOLUME_DOWN (AndroidKey.VOLUME_DOWN),
    BACK (AndroidKey.BACK),
    ENTER (AndroidKey.ENTER);

    private final AndroidKey key;

    KeyCode (final AndroidKey key) {
        this.key = key;
    }

    public AndroidKey getKey () {
        return this.key;
    }
}
