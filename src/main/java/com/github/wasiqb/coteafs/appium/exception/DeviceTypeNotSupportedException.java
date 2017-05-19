package com.github.wasiqb.coteafs.appium.exception;

/**
 * @author wasiq.bhamla
 * @since 17-May-2017 7:41:49 PM
 */
public class DeviceTypeNotSupportedException extends BaseAppiumException {
	private static final long serialVersionUID = -675650350464360559L;

	/**
	 * @author wasiq.bhamla
	 * @since 17-May-2017 7:41:50 PM
	 * @param message
	 */
	public DeviceTypeNotSupportedException (final String message) {
		super (message);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-May-2017 7:41:50 PM
	 * @param message
	 * @param cause
	 */
	public DeviceTypeNotSupportedException (final String message, final Throwable cause) {
		super (message, cause);
	}
}