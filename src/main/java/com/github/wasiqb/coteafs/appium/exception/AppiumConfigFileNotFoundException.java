package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 11:19:31 PM
 */
public class AppiumConfigFileNotFoundException extends BaseAppiumException {
	private static final long serialVersionUID = 7619491487630973407L;

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:19:31 PM
	 * @param message
	 */
	public AppiumConfigFileNotFoundException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 04-May-2017 11:19:31 PM
	 * @param message
	 * @param cause
	 */
	public AppiumConfigFileNotFoundException (final String message, final Throwable cause) {
		super (message, cause);
	}
}