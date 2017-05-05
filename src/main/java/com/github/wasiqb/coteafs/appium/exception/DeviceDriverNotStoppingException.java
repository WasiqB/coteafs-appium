package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 9:57:00 PM
 */
public class DeviceDriverNotStoppingException extends BaseAppiumException {
	private static final long serialVersionUID = 6550193998074883544L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:17:11 PM
	 * @param message
	 */
	public DeviceDriverNotStoppingException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 9:57:00 PM
	 * @param message
	 * @param cause
	 */
	public DeviceDriverNotStoppingException (final String message, final Throwable cause) {
		super (message, cause);
	}
}