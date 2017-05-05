package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 9:47:27 PM
 */
public class AppiumServerNotStoppingException extends BaseAppiumException {
	private static final long serialVersionUID = 5886144403365923036L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:15:21 PM
	 * @param message
	 */
	public AppiumServerNotStoppingException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 9:47:27 PM
	 * @param message
	 * @param cause
	 */
	public AppiumServerNotStoppingException (final String message, final Throwable cause) {
		super (message, cause);
	}
}