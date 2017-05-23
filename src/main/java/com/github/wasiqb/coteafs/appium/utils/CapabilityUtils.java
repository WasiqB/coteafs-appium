package com.github.wasiqb.coteafs.appium.utils;

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
	public static <T> void setCapability (final String key, final T value, final DesiredCapabilities capabilities) {
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
	public static <T> void setCapability (final String key, final T value, final DesiredCapabilities capabilities,
			final boolean mandatory) {
		if (mandatory) {
			DeviceChecker.checkCapabilitiesParams (key, value);
		}
		if (value != null) {
			if (value instanceof Boolean && ! ((Boolean) value)) {
				return;
			}
			else if (value instanceof Integer && (Integer) value == 0) {
				return;
			}
			final String msg = "Setting capability [key: %s, value: %s]...";
			log.trace (String.format (msg, key, value));
			capabilities.setCapability (key, value);
		}
	}
}