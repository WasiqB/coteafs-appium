package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 06-May-2017 4:17:32 PM
 */
public class DeviceElementFindTimedOutException extends BaseAppiumException {
	private static final long serialVersionUID = 4342518976798681279L;

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 4:17:32 PM
	 * @param message
	 */
	public DeviceElementFindTimedOutException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 4:17:32 PM
	 * @param message
	 * @param cause
	 */
	public DeviceElementFindTimedOutException (final String message, final Throwable cause) {
		super (message, cause);
	}
}