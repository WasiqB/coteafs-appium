package com.github.wasiqb.coteafs.appium.device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.wasiqb.coteafs.appium.checker.ServerChecker;
import com.github.wasiqb.coteafs.appium.exception.AppiumServerStoppedException;
import com.github.wasiqb.coteafs.appium.exception.DeviceElementFindTimedOutException;
import com.github.wasiqb.coteafs.appium.exception.DeviceElementNotFoundException;

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
	protected final Map <String, DeviceElement>	deviceElements;
	private boolean								activityLoaded;
	private final WebDriverWait					wait;

	/**
	 * @author wasiq.bhamla
	 * @param device
	 * @since 26-Apr-2017 4:32:45 PM
	 */
	public DeviceActivity (final TDevice device) {
		this.device = device;
		this.deviceElements = new HashMap <> ();
		this.wait = new WebDriverWait (device.getDriver (), device.setting.getWaitForElementUntil ());
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
	 * @since 26-Apr-2017 8:41:07 PM
	 * @return device actions
	 */
	public DeviceActions <TDriver, TDevice> onDevice () {
		ServerChecker.checkServerRunning (this.device.server);
		log.info ("Preparing to perform actions on device...");
		return new DeviceActions <TDriver, TDevice> (this.device);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 6:45:09 PM
	 * @param name
	 * @return element actions
	 */
	public DeviceElementActions <TDriver, TDevice> onElement (final String name) {
		ServerChecker.checkServerRunning (this.device.server);
		load ();
		final String msg = "Preparing to perform actions on device element [%s]...";
		log.info (String.format (msg, name));
		return new DeviceElementActions <TDriver, TDevice> (this.device, name, getElement (name));
	}

	/**
	 * @author wasiq.bhamla
	 * @return element
	 * @since 02-May-2017 4:38:00 PM
	 */
	public abstract DeviceElement prepare ();

	protected MobileElement getElement (final String name) {
		final String msg = "Getting element with name [%s]...";
		log.trace (String.format (msg, name));
		return findElements (this.deviceElements.get (name));
	}

	private MobileElement find (final DeviceElement parent, final By locator, final int index) {
		String msg = "Finding child element of [%s] parent using [%s] at index [%d]...";
		log.trace (String.format (msg, parent.name (), locator, index));
		final MobileElement mobileElement = getElement (parent.name ());
		try {
			final List <MobileElement> result = mobileElement.findElements (locator);
			return result.get (index);
		}
		catch (final NoSuchSessionException e) {
			throw new AppiumServerStoppedException ("Server Session has been stopped.", e);
		}
		catch (final Exception e) {
			msg = "Error occured while finding device element with locator [%s] under parent %s.";
			throw new DeviceElementNotFoundException (String.format (msg, locator, parent.name ()), e);
		}
	}

	private MobileElement find (final TDriver deviceDriver, final By locator, final int index) {
		String msg = "Finding root element using [%s] at index [%d]...";
		log.trace (String.format (msg, locator, index));
		try {
			final List <MobileElement> result = deviceDriver.findElements (locator);
			return result.get (index);
		}
		catch (final NoSuchSessionException e) {
			throw new AppiumServerStoppedException ("Server Session has been stopped.", e);
		}
		catch (final Exception e) {
			msg = "Error occured while finding root device element with locator [%s].";
			throw new DeviceElementNotFoundException (String.format (msg, locator), e);
		}
	}

	private MobileElement findElements (final DeviceElement element) {
		final DeviceElement parent = element.parent ();
		final By locator = element.locator ();
		final int index = element.index ();
		waitForElement (locator);
		MobileElement elem = null;
		if (parent != null) {
			elem = find (parent, locator, index);
		}
		else {
			elem = find (this.device.getDriver (), locator, index);
		}
		this.activityLoaded = true;
		return elem;
	}

	private void load () {
		if (this.deviceElements.size () == 0) {
			final String platform = this.device.setting.getDeviceType ()
				.getName ();
			final String msg = "Loading elements on %s activity...";
			log.info (String.format (msg, platform));
			loadElements (prepare ());
		}
	}

	private void loadElements (final DeviceElement rootElement) {
		ServerChecker.checkServerRunning (this.device.server);
		if (!this.deviceElements.containsKey (rootElement.name ())) {
			this.deviceElements.put (rootElement.name (), rootElement);
		}
		final List <DeviceElement> childs = rootElement.childs ();
		for (final DeviceElement child : childs) {
			loadElements (child);
		}
	}

	private void waitForElement (final By locator) {
		try {
			this.wait.until (d -> d.findElement (locator)
				.isDisplayed ());
		}
		catch (final TimeoutException e) {
			final String msg = "[%s] locator timed out.";
			throw new DeviceElementFindTimedOutException (String.format (msg, locator), e);
		}
		catch (final NoSuchSessionException e) {
			throw new AppiumServerStoppedException ("Server Session has been stopped.", e);
		}
	}
}