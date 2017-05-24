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
package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 06-May-2017 4:17:32 PM
 */
public class DeviceElementFindTimedOutException extends BaseAppiumException {
	private static final long serialVersionUID = 4342518976798681279L;

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 4:17:32 PM
	 * @param message
	 */
	public DeviceElementFindTimedOutException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 4:17:32 PM
	 * @param message
	 * @param cause
	 */
	public DeviceElementFindTimedOutException (final String message, final Throwable cause) {
		super (message, cause);
	}
}