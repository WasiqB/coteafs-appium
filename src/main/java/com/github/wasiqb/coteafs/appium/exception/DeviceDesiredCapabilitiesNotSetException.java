package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 12-May-2017 7:29:59 PM
 */
public class DeviceDesiredCapabilitiesNotSetException extends BaseAppiumException {
	private static final long serialVersionUID = 2603048064389553019L;

	/**
	 * @author wasiq.bhamla
	 * @since 12-May-2017 7:30:02 PM
	 * @param message
	 */
	public DeviceDesiredCapabilitiesNotSetException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-May-2017 7:30:02 PM
	 * @param message
	 * @param cause
	 */
	public DeviceDesiredCapabilitiesNotSetException (final String message, final Throwable cause) {
		super (message, cause);
	}
}