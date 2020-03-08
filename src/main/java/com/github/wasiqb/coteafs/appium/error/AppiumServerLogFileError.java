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
 * @since Oct 31, 2017 9:24:59 PM
 */
public class AppiumServerLogFileError extends CoteafsAppiumError {
    private static final long serialVersionUID = -1270139515211883488L;

    /**
     * @param message
     * @author wasiq.bhamla
     * @since Oct 31, 2017 9:25:00 PM
     */
    public AppiumServerLogFileError(final String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     * @author wasiq.bhamla
     * @since Oct 31, 2017 9:25:00 PM
     */
    public AppiumServerLogFileError(final String message, final Throwable cause) {
        super(message, cause);
    }
}