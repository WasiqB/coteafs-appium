package com.github.wasiqb.coteafs.appium.device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author wasiq.bhamla
 * @param <TDriver>
 * @param <TDevice>
 * @since 26-Apr-2017 4:31:24 PM
 */
public abstract class DeviceActivity <TDriver extends AppiumDriver <MobileElement>, TDevice extends Device <TDriver>> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (DeviceActivity.class);
	}

	protected final TDevice						device;
	private boolean								activityLoaded;
	private final Map <String, MobileElement>	elements;
	private final WebDriverWait					wait;

	/**
	 * @author wasiq.bhamla
	 * @param device
	 * @since 26-Apr-2017 4:32:45 PM
	 */
	public DeviceActivity (final TDevice device) {
		this.device = device;
		this.elements = new HashMap <> ();
		this.wait = new WebDriverWait (device.getDriver (), 60);
		this.activityLoaded = false;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Apr 27, 2017 5:12:51 PM
	 * @return the activityLoaded
	 */
	public boolean isActivityLoaded () {
		log.trace ("Checking if activity is loaded...");
		return this.activityLoaded;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 11:31:02 PM
	 */
	public abstract void load ();

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:41:07 PM
	 * @return device actions
	 */
	public DeviceActions <TDriver> onDevice () {
		log.info ("Preparing to perform actions on device...");
		return new DeviceActions <TDriver> (this.device.getDriver ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 6:45:09 PM
	 * @param name
	 * @return element actions
	 */
	public DeviceElementActions <TDriver> onElement (final String name) {
		final String msg = "Preparing to perform actions on device element %s...";
		log.info (String.format (msg, name));
		return new DeviceElementActions <TDriver> (this.device.getDriver (), name, getElement (name));
	}

	/**
	 * @author wasiq.bhamla
	 * @return element
	 * @since 02-May-2017 4:38:00 PM
	 */
	public abstract DeviceElement prepare ();

	protected MobileElement getElement (final String name) {
		final String msg = "Getting element with name %s...";
		log.trace (String.format (msg, name));
		return this.elements.get (name);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 4:34:30 PM
	 * @param rootElement
	 */
	protected void loadElements (final DeviceElement rootElement) {
		try {
			this.wait.until (d -> d.findElement (rootElement.locator ())
				.isDisplayed ());
			MobileElement element = null;
			if (rootElement.parent () == null) {
				log.trace ("Loading elements...");
				element = find (this.device.getDriver (), rootElement.locator (), rootElement.index ());
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
			log.error ("Error occurred while loading elements...");
			log.catching (e);
			this.activityLoaded = false;
		}
	}

	private MobileElement find (final DeviceElement deviceElement, final By locator, final int index) {
		final String msg = "Finding element using %s at index %d...";
		log.trace (String.format (msg, locator, index));
		final MobileElement mobileElement = getElement (deviceElement.name ());
		final List <MobileElement> result = mobileElement.findElements (locator);
		return result.get (index);
	}

	private MobileElement find (final TDriver deviceDriver, final By locator, final int index) {
		final String msg = "Finding element using %s at index %d...";
		log.trace (String.format (msg, locator, index));
		final List <MobileElement> result = deviceDriver.findElements (locator);
		return result.get (index);
	}
}