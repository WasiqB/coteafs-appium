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
package com.github.wasiqb.coteafs.appium.error;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 10:11:47 PM
 */
public class DeviceElementNotDisplayedError extends CoteafsAppiumError {
    private static final long serialVersionUID = -2632375399231145369L;

    /**
     * @param message
     * @author wasiq.bhamla
     * @since 04-May-2017 11:05:48 PM
     */
    public DeviceElementNotDisplayedError(final String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     * @author wasiq.bhamla
     * @since 04-May-2017 10:11:47 PM
     */
    public DeviceElementNotDisplayedError(final String message, final Throwable cause) {
        super(message, cause);
    }
}