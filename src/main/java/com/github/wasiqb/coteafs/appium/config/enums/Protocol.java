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

/**
 * @author wasiqb
 * @since Sep 29, 2018
 */
public enum Protocol {
    /**
     * HTTP protocol.
     */
    HTTP("http"),
    /**
     * HTTPS protocol.
     */
    HTTPS("https");

    private final String name;

    Protocol(final String name) {
        this.name = name;
    }

    /**
     * @return the protocol name
     * @author wasiqb
     * @since Sep 29, 2018
     */
    public String getName() {
        return this.name;
    }
}