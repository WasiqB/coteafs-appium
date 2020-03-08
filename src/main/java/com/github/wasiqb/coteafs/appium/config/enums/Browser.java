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

import io.appium.java_client.remote.MobileBrowserType;

/**
 * @author wasiq.bhamla
 * @since Jul 15, 2017 4:50:08 PM
 */
public enum Browser {
    /**
     * System browser.
     */
    BROWSER(MobileBrowserType.BROWSER),
    /**
     * Chrome browser.
     */
    CHROME(MobileBrowserType.CHROME),
    /**
     * Chromiuim browser.
     */
    CHROMIUM(MobileBrowserType.CHROMIUM),
    /**
     * Safari browser.
     */
    SAFARI(MobileBrowserType.SAFARI);

    private final String name;

    Browser(final String name) {
        this.name = name;
    }

    /**
     * @return the browser
     * @author wasiq.bhamla
     * @since Jul 15, 2017 5:04:12 PM
     */
    @Override
    public String toString() {
        return this.name;
    }
}