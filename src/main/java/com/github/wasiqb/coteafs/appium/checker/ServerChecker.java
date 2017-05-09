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
	 * @since 09-May-2017 3:54:48 PM
	 * @param key
	 * @param value
	 */
	public static void checkServerConfigParams (final String key, final int value) {
		if (value == 0) {
			final String msg = "Server Config value for %s key not set.";
			throw new AppiumConfigParameterNotFoundException (String.format (msg, key));
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 09-May-2017 3:52:30 PM
	 * @param key
	 * @param value
	 */
	public static void checkServerConfigParams (final String key, final String value) {
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