package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 4:22:59 PM
 */
public class BaseAppiumException extends AssertionError {
	private static final long serialVersionUID = -1650843353543598942L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:05:28 PM
	 * @param message
	 */
	public BaseAppiumException (final String message) {
		super (message, null);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 4:22:59 PM
	 * @param message
	 * @param cause
	 */
	public BaseAppiumException (final String message, final Throwable cause) {
		super (message, cause);
	}
}