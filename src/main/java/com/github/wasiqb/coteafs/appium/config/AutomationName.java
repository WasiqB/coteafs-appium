package com.github.wasiqb.coteafs.appium.config;

/**
 * @author wasiq.bhamla
 * @since 24-Apr-2017 9:11:30 PM
 */
public enum AutomationName {
	/**
	 * Appium.
	 */
	APPIUM ("Appium"),
	/**
	 * XCUITest.
	 */
	XCUI ("XCUITest");

	private final String name;

	private AutomationName (final String name) {
		this.name = name;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 24-Apr-2017 9:12:52 PM
	 * @return the name
	 */
	public String getName () {
		return this.name;
	}
}