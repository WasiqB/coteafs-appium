package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 9:44:46 PM
 */
public class AppiumServerAlreadyRunningException extends BaseAppiumException {
	private static final long serialVersionUID = 3122700421661631230L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:12:22 PM
	 * @param message
	 */
	public AppiumServerAlreadyRunningException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 9:44:46 PM
	 * @param message
	 * @param cause
	 */
	public AppiumServerAlreadyRunningException (final String message, final Throwable cause) {
		super (message, cause);
	}
}