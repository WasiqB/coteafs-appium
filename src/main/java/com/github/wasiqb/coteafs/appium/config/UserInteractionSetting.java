package com.github.wasiqb.coteafs.appium.config;

/**
 * @author wasiq.bhamla
 * @since 06-May-2017 3:57:02 PM
 */
public class UserInteractionSetting {
	private int	defaultWait;
	private int	waitForElementUntil;

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 3:57:02 PM
	 */
	public UserInteractionSetting () {
		this.defaultWait = 30;
		this.waitForElementUntil = 30;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 3:57:54 PM
	 * @return the defaultWait
	 */
	public int getDefaultWait () {
		return this.defaultWait;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 3:57:54 PM
	 * @return the waitForElementUntil
	 */
	public int getWaitForElementUntil () {
		return this.waitForElementUntil;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 3:57:54 PM
	 * @param defaultWait
	 *            the defaultWait to set
	 */
	public void setDefaultWait (final int defaultWait) {
		this.defaultWait = defaultWait;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 3:57:55 PM
	 * @param waitForElementUntil
	 *            the waitForElementUntil to set
	 */
	public void setWaitForElementUntil (final int waitForElementUntil) {
		this.waitForElementUntil = waitForElementUntil;
	}
}