package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 11:22:34 PM
 */
public class AppiumConfigNotLoadedException extends BaseAppiumException {
	private static final long serialVersionUID = 3051298544062173848L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:22:34 PM
	 * @param message
	 */
	public AppiumConfigNotLoadedException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:22:34 PM
	 * @param message
	 * @param cause
	 */
	public AppiumConfigNotLoadedException (final String message, final Throwable cause) {
		super (message, cause);
	}
}