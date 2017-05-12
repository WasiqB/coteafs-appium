package com.github.wasiqb.coteafs.appium.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.github.wasiqb.coteafs.appium.checker.DeviceChecker;

/**
 * @author wasiq.bhamla
 * @since 08-May-2017 7:51:42 PM
 */
public final class CapabilityUtils {
	private static final Logger log;

	static {
		log = LogManager.getLogger (CapabilityUtils.class);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-May-2017 9:54:46 PM
	 * @param key
	 * @param value
	 * @param capabilities
	 */
	public static void setCapability (final String key, final String value, final DesiredCapabilities capabilities) {
		setCapability (key, value, capabilities, false);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:53:28 PM
	 * @param key
	 * @param value
	 * @param capabilities
	 * @param mandatory
	 */
	public static void setCapability (final String key, final String value, final DesiredCapabilities capabilities,
			final boolean mandatory) {
		if (mandatory) {
			DeviceChecker.checkCapabilitiesParams (key, value);
		}
		if (!StringUtils.isEmpty (value)) {
			final String msg = "Setting capability [key: %s, value: %s]...";
			log.trace (String.format (msg, key, value));
			capabilities.setCapability (key, value);
		}
	}
}