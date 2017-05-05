package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 10:05:02 PM
 */
public class DeviceElementNotFoundException extends BaseAppiumException {
	private static final long serialVersionUID = 7290657595577298146L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:17:36 PM
	 * @param message
	 */
	public DeviceElementNotFoundException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 10:05:02 PM
	 * @param message
	 * @param cause
	 */
	public DeviceElementNotFoundException (final String message, final Throwable cause) {
		super (message, cause);
	}
}