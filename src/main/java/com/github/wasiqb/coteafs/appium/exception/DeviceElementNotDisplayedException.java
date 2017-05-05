package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 10:11:47 PM
 */
public class DeviceElementNotDisplayedException extends BaseAppiumException {
	private static final long serialVersionUID = -2632375399231145369L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:05:48 PM
	 * @param message
	 */
	public DeviceElementNotDisplayedException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 10:11:47 PM
	 * @param message
	 * @param cause
	 */
	public DeviceElementNotDisplayedException (final String message, final Throwable cause) {
		super (message, cause);
	}
}