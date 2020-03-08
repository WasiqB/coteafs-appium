/*
 * Copyright (c) 2017-2020, Wasiq Bhamla.
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

import io.appium.java_client.clipboard.ClipboardContentType;

/**
 * @author wasiqb
 * @since Nov 2, 2018
 */
public enum ClipboardType {
    /**
     * Image.
     */
    IMAGE(ClipboardContentType.IMAGE),
    /**
     * Text.
     */
    TEXT(ClipboardContentType.PLAINTEXT),
    /**
     * URL.
     */
    URL(ClipboardContentType.URL);

    private final ClipboardContentType type;

    ClipboardType(final ClipboardContentType type) {
        this.type = type;
    }

    /**
     * @return the type
     * @author wasiqb
     * @since Nov 2, 2018
     */
    public ClipboardContentType getType() {
        return this.type;
    }
}