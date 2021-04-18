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

import java.util.Locale;

/**
 * @author Wasiq Bhamla
 * @since 18-Apr-2021
 */
public enum Language {
    /**
     * French.
     */
    FRANCE (Locale.FRANCE),
    /**
     * Japanese.
     */
    JAPAN (Locale.JAPAN),
    /**
     * English UK.
     */
    UK (Locale.UK),
    /**
     * English US.
     */
    US (Locale.US);

    private final Locale locale;

    Language (final Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale () {
        return this.locale;
    }
}
