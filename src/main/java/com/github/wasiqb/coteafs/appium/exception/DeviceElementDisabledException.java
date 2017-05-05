package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 11:07:35 PM
 */
public class DeviceElementDisabledException extends BaseAppiumException {
	private static final long serialVersionUID = -7319931622304889401L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:07:35 PM
	 * @param message
	 */
	public DeviceElementDisabledException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:07:35 PM
	 * @param message
	 * @param cause
	 */
	public DeviceElementDisabledException (final String message, final Throwable cause) {
		super (message, cause);
	}
}