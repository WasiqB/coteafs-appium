package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 06-May-2017 4:03:58 PM
 */
public class DeviceAppNotFoundException extends BaseAppiumException {
	private static final long serialVersionUID = 1403120362024067556L;

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 4:03:58 PM
	 * @param message
	 */
	public DeviceAppNotFoundException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 4:03:58 PM
	 * @param message
	 * @param cause
	 */
	public DeviceAppNotFoundException (final String message, final Throwable cause) {
		super (message, cause);
	}
}