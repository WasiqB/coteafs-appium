package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 9:37:59 PM
 */
public class AppiumServerNotStartingException extends BaseAppiumException {
	private static final long serialVersionUID = 7896083001637597129L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:15:07 PM
	 * @param message
	 */
	public AppiumServerNotStartingException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 9:38:00 PM
	 * @param message
	 * @param cause
	 */
	public AppiumServerNotStartingException (final String message, final Throwable cause) {
		super (message, cause);
	}
}