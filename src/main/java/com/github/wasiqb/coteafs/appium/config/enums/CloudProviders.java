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
package com.github.wasiqb.coteafs.appium.config.enums;

/**
 * List of cloud providers.
 *
 * @author Wasiq Bhamla
 * @since 29-11-2020
 */
public enum CloudProviders {
    BROWSERSTACK ("hub-cloud.browserstack.com");

    private final String url;

    CloudProviders (final String url) {
        this.url = url;
    }

    /**
     * @return Server URL
     */
    public String getUrl () {
        return this.url;
    }
}