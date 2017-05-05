package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 4:27:12 PM
 */
public class AppiumServerNotRunningException extends BaseAppiumException {
	private static final long serialVersionUID = 8585241762112136560L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 4:36:48 PM
	 * @param message
	 */
	public AppiumServerNotRunningException (final String message) {
		super (message, null);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 4:27:12 PM
	 * @param message
	 * @param cause
	 */
	public AppiumServerNotRunningException (final String message, final Throwable cause) {
		super (message, cause);
	}
}