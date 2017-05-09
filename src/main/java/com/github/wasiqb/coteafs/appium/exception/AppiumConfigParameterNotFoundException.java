package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 09-May-2017 3:46:59 PM
 */
public class AppiumConfigParameterNotFoundException extends BaseAppiumException {
	private static final long serialVersionUID = 8185078640460346377L;

	/**
	 * @author wasiq.bhamla
	 * @since 09-May-2017 3:46:59 PM
	 * @param message
	 */
	public AppiumConfigParameterNotFoundException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 09-May-2017 3:46:59 PM
	 * @param message
	 * @param cause
	 */
	public AppiumConfigParameterNotFoundException (final String message, final Throwable cause) {
		super (message, cause);
	}
}