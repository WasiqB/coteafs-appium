/**
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

import com.github.wasiqb.coteafs.appium.exception.AppiumConfigParameterNotFoundException;
import com.github.wasiqb.coteafs.appium.exception.AppiumServerNotRunningException;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

/**
 * @author wasiq.bhamla
 * @since 09-May-2017 3:49:21 PM
 */
public final class ServerChecker {
	/**
	 * @author wasiq.bhamla
	 * @since 09-May-2017 3:52:30 PM
	 * @param key
	 * @param value
	 */
	public static void checkServerConfigParams (final String key, final Object value) {
		if (value == null) {
			final String msg = "Server Config value for %s key not set.";
			throw new AppiumConfigParameterNotFoundException (String.format (msg, key));
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 4:36:57 PM
	 * @param server
	 */
	public static void checkServerRunning (final AppiumServer server) {
		if (!server.isRunning ()) {
			throw new AppiumServerNotRunningException ("Server not started yet.");
		}
	}
}