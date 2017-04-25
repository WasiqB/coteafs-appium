package com.github.wasiqb.coteafs.appium.android.controls;

/**
 * @author wasiq.bhamla
 * @since 25-Apr-2017 4:57:03 PM
 */
public class LocatorStrategy {
	private final FindBy	by;
	private final String	locator;

	/**
	 * @author wasiq.bhamla
	 * @param by
	 * @param locator
	 * @since 25-Apr-2017 4:57:31 PM
	 */
	public LocatorStrategy (final FindBy by, final String locator) {
		this.by = by;
		this.locator = locator;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 4:58:28 PM
	 * @return the by
	 */
	public FindBy getBy () {
		return this.by;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 4:58:28 PM
	 * @return the locator
	 */
	public String getLocator () {
		return this.locator;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		return String.format ("[By: %s, locator: %s]", this.by, this.locator);
	}
}