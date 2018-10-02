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
package com.github.wasiqb.coteafs.appium.utils;

import static java.lang.String.format;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.wasiqb.coteafs.error.CoteafsError;
import com.github.wasiqb.coteafs.error.util.ErrorUtil;

/**
 * @author wasiq.bhamla
 * @since Nov 17, 2017 2:42:29 PM
 */
public final class ErrorUtils {
	private static final Logger log = LogManager.getLogger (ErrorUtils.class);

	/**
	 * @author wasiq.bhamla
	 * @since Nov 17, 2017 3:20:00 PM
	 * @param error
	 * @param message
	 */
	public static <E extends CoteafsError> void fail (final Class <E> error, final String message) {
		fail (error, message, null);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Nov 17, 2017 7:12:43 PM
	 * @param error
	 * @param message
	 * @param ex
	 */
	public static <E extends CoteafsError> void fail (final Class <E> error, final String message,
			final Throwable ex) {
		try {
			ErrorUtil.fail (error, message, ex);
		} catch (final CoteafsError err) {
			logError (err, message);
			throw err;
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since Nov 21, 2017 2:27:40 PM
	 * @param err
	 */
	private static void logError (final Throwable error, final String message) {
		log.error (error);
		final StackTraceElement [] traces = error.getStackTrace ();
		for (final StackTraceElement s : traces) {
			log.error (format ("\tat %s", s));
		}
		final Throwable root = error.getCause ();
		if (root != null) {
			log.error ("Caused by:");
			logError (root, message);
		}
	}

	private ErrorUtils () {
		// Utility class.
	}
}