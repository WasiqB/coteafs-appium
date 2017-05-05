package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 9:52:46 PM
 */
public class DeviceDriverNotStartingException extends BaseAppiumException {
	private static final long serialVersionUID = 1786319114640601285L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:16:56 PM
	 * @param message
	 */
	public DeviceDriverNotStartingException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 9:52:46 PM
	 * @param message
	 * @param cause
	 */
	public DeviceDriverNotStartingException (final String message, final Throwable cause) {
		super (message, cause);
	}
}