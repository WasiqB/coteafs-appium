package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 06-May-2017 4:11:39 PM
 */
public class DeviceDriverDefaultWaitException extends BaseAppiumException {
	private static final long serialVersionUID = 3213298782710610781L;

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 4:11:39 PM
	 * @param message
	 */
	public DeviceDriverDefaultWaitException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 4:11:39 PM
	 * @param message
	 * @param cause
	 */
	public DeviceDriverDefaultWaitException (final String message, final Throwable cause) {
		super (message, cause);
	}
}