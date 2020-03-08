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
package com.github.wasiqb.coteafs.appium.checker;

import static com.github.wasiqb.coteafs.appium.utils.ErrorUtils.fail;

import com.github.wasiqb.coteafs.appium.error.AppiumConfigParameterNotFoundError;
import com.github.wasiqb.coteafs.appium.error.AppiumServerNotRunningError;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

/**
 * @author wasiq.bhamla
 * @since 09-May-2017 3:49:21 PM
 */
public final class ServerChecker {
    /**
     * @param key
     * @param value
     * @author wasiq.bhamla
     * @since 09-May-2017 3:52:30 PM
     */
    public static void checkServerConfigParams(final String key, final Object value) {
        if (value == null) {
            final String msg = "Server Config value for %s key not set.";
            fail(AppiumConfigParameterNotFoundError.class, String.format(msg, key));
        }
    }

    /**
     * @param server
     * @author wasiq.bhamla
     * @since 04-May-2017 4:36:57 PM
     */
    public static void checkServerRunning(final AppiumServer server) {
        if (!server.isRunning()) {
            fail(AppiumServerNotRunningError.class, "Server not started yet.");
        }
    }

    private ServerChecker() {
        // Utility class.
    }
}