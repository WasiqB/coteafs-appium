package com.github.wasiqb.coteafs.appium.android.controls;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 5:56:28 PM
 */
public class MobileControl {
	private static final Logger log;

	static {
		log = LogManager.getLogger (MobileControl.class);
	}

	private final AndroidDriver <MobileElement>	driver;
	private MobileElement						element;
	private By									locator;
	private final String						name;
	private MobileElement						parent;

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 6:10:38 PM
	 * @param driver
	 * @param name
	 */
	public MobileControl (final AndroidDriver <MobileElement> driver, final String name) {
		this.driver = driver;
		this.name = name;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 6:03:17 PM
	 * @param driver
	 * @param name
	 * @param locator
	 */
	public MobileControl (final AndroidDriver <MobileElement> driver, final String name, final By locator) {
		this (driver, name);
		this.locator = locator;
	}

	/**
	 * @author wasiq.bhamla
	 * @param driver
	 * @param name
	 * @param locator
	 * @param parent
	 * @since 12-Apr-2017 6:05:43 PM
	 */
	public MobileControl (final AndroidDriver <MobileElement> driver, final String name, final By locator,
			final MobileElement parent) {
		this (driver, name, locator);
		this.parent = parent;
	}

	protected void find () {
		log.trace ("Finding [" + this.name + "] control using locator [" + this.locator + "]");
		this.element = null;
		if (this.parent == null) {
			this.element = this.driver.findElement (this.locator);
		}
		else {
			this.element = this.parent.findElement (this.locator);
		}
		Objects.requireNonNull (this.element, this.name + " cannot be found.");
	}
}