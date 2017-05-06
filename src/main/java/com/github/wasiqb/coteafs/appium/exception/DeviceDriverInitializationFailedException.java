package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 06-May-2017 4:07:48 PM
 */
public class DeviceDriverInitializationFailedException extends BaseAppiumException {
	private static final long serialVersionUID = -3202324172947020043L;

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 4:07:48 PM
	 * @param message
	 */
	public DeviceDriverInitializationFailedException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 4:07:48 PM
	 * @param message
	 * @param cause
	 */
	public DeviceDriverInitializationFailedException (final String message, final Throwable cause) {
		super (message, cause);
	}
}