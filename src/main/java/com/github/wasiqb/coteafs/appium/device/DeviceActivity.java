package com.github.wasiqb.coteafs.appium.device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author wasiq.bhamla
 * @param <TDriver>
 * @since 26-Apr-2017 4:31:24 PM
 */
public abstract class DeviceActivity <TDriver extends AppiumDriver <MobileElement>> {
	protected final TDriver						driver;
	private boolean								activityLoaded;
	private final Map <String, MobileElement>	elements;
	private final WebDriverWait					wait;

	/**
	 * @author wasiq.bhamla
	 * @param driver
	 * @since 26-Apr-2017 4:32:45 PM
	 */
	public DeviceActivity (final TDriver driver) {
		this.driver = driver;
		this.elements = new HashMap <> ();
		this.wait = new WebDriverWait (driver, 60);
		this.activityLoaded = false;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 11:31:02 PM
	 */
	public abstract void build ();

	/**
	 * @author wasiq.bhamla
	 * @since Apr 27, 2017 5:12:51 PM
	 * @return the activityLoaded
	 */
	public boolean isActivityLoaded () {
		return this.activityLoaded;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:41:07 PM
	 * @return device actions
	 */
	public DeviceActions <TDriver> onDevice () {
		return new DeviceActions <TDriver> (this.driver);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 6:45:09 PM
	 * @param name
	 * @return element actions
	 */
	public DeviceElementActions <TDriver> onElement (final String name) {
		return new DeviceElementActions <TDriver> (this.driver, name, getElement (name));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 4:34:30 PM
	 * @param rootElement
	 */
	protected void loadElements (final DeviceElement rootElement) {
		try {
			this.wait.until (ExpectedConditions.visibilityOfElementLocated (rootElement.locator ()));
			MobileElement element = null;
			if (rootElement.parent () == null) {
				element = find (this.driver, rootElement.locator (), rootElement.index ());
			}
			else {
				element = find (rootElement.parent (), rootElement.locator (), rootElement.index ());
			}
			this.elements.put (rootElement.name (), element);
			final List <DeviceElement> childs = rootElement.childs ();
			for (final DeviceElement child : childs) {
				loadElements (child);
			}
			this.activityLoaded = true;
		}
		catch (final Exception e) {
			this.activityLoaded = false;
		}
	}

	private MobileElement find (final DeviceElement deviceElement, final By locator, final int index) {
		final MobileElement mobileElement = getElement (deviceElement.name ());
		final List <MobileElement> result = mobileElement.findElements (locator);
		return result.get (index);
	}

	private MobileElement find (final TDriver deviceDriver, final By locator, final int index) {
		final List <MobileElement> result = deviceDriver.findElements (locator);
		return result.get (index);
	}

	private MobileElement getElement (final String name) {
		return this.elements.get (name);
	}
}