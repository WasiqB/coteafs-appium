package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 12-May-2017 10:00:29 PM
 */
public class AppiumServerStoppedException extends BaseAppiumException {
	private static final long serialVersionUID = -16535073449188572L;

	/**
	 * @author wasiq.bhamla
	 * @since 12-May-2017 10:00:30 PM
	 * @param message
	 */
	public AppiumServerStoppedException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-May-2017 10:00:30 PM
	 * @param message
	 * @param cause
	 */
	public AppiumServerStoppedException (final String message, final Throwable cause) {
		super (message, cause);
	}
}