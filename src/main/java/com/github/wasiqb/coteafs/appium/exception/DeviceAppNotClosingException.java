package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 9:55:17 PM
 */
public class DeviceAppNotClosingException extends BaseAppiumException {
	private static final long serialVersionUID = -911705055646490050L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:16:42 PM
	 * @param message
	 */
	public DeviceAppNotClosingException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 9:55:17 PM
	 * @param message
	 * @param cause
	 */
	public DeviceAppNotClosingException (final String message, final Throwable cause) {
		super (message, cause);
	}
}