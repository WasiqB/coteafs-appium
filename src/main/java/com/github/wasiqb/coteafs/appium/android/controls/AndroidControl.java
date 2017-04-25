package com.github.wasiqb.coteafs.appium.android.controls;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.wasiqb.coteafs.appium.android.AndroidDevice;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 5:56:28 PM
 */
public class AndroidControl {
	private static final Logger log;

	static {
		log = LogManager.getLogger (AndroidControl.class);
	}

	private MobileElement			currentElement;
	private final AndroidDevice		device;
	private final int				index;
	private final LocatorStrategy	locator;
	private final String			name;
	private AndroidControl			parent;

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 6:03:17 PM
	 * @param device
	 * @param name
	 * @param index
	 * @param locator
	 */
	public AndroidControl (final AndroidDevice device, final String name, final int index,
			final LocatorStrategy locator) {
		this.device = device;
		this.name = name;
		this.index = index;
		this.locator = locator;
	}

	/**
	 * @author wasiq.bhamla
	 * @param device
	 * @param name
	 * @param index
	 * @param locator
	 * @param parent
	 * @since 12-Apr-2017 6:05:43 PM
	 */
	public AndroidControl (final AndroidDevice device, final String name, final int index,
			final LocatorStrategy locator, final AndroidControl parent) {
		this (device, name, index, locator);
		this.parent = parent;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 5:34:38 PM
	 * @param device
	 * @param name
	 * @param locator
	 */
	public AndroidControl (final AndroidDevice device, final String name, final LocatorStrategy locator) {
		this (device, name, 0, locator);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 5:35:10 PM
	 * @param device
	 * @param name
	 * @param locator
	 * @param parent
	 */
	public AndroidControl (final AndroidDevice device, final String name, final LocatorStrategy locator,
			final AndroidControl parent) {
		this (device, name, 0, locator, parent);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 6:19:20 PM
	 * @return element
	 */
	public MobileElement element () {
		return this.currentElement;
	}

	protected void find () {
		log.trace (String.format ("Finding [%s] control using locator %s", this.name, this.locator));
		this.currentElement = null;
		List <MobileElement> list = new ArrayList <> ();
		final AndroidDriver <MobileElement> driver = this.device.getAndroidDriver ();
		if (this.parent == null) {
			switch (this.locator.getBy ()) {
				case ACCESSIBILITY_ID:
					list = driver.findElementsByAccessibilityId (this.locator.getLocator ());
					break;
				case CLASS_NAME:
					list = driver.findElementsByClassName (this.locator.getLocator ());
					break;
				case CSS:
					list = driver.findElementsByCssSelector (this.locator.getLocator ());
					break;
				case ID:
					list = driver.findElementsById (this.locator.getLocator ());
					break;
				case LINK_TEXT:
					list = driver.findElementsByLinkText (this.locator.getLocator ());
					break;
				case NAME:
					list = driver.findElementsByName (this.locator.getLocator ());
					break;
				case PARTIAL_LINK:
					list = driver.findElementsByPartialLinkText (this.locator.getLocator ());
					break;
				case TAG:
					list = driver.findElementsByTagName (this.locator.getLocator ());
					break;
				case XPATH:
					list = driver.findElementsByXPath (this.locator.getLocator ());
					break;
				default:
					log.error ("Incorrect FindBy value: " + this.locator);
					break;
			}
		}
		else {
			switch (this.locator.getBy ()) {
				case ACCESSIBILITY_ID:
					list = this.parent.element ()
						.findElementsByAccessibilityId (this.locator.getLocator ());
					break;
				case CLASS_NAME:
					list = this.parent.element ()
						.findElementsByClassName (this.locator.getLocator ());
					break;
				case CSS:
					list = this.parent.element ()
						.findElementsByCssSelector (this.locator.getLocator ());
					break;
				case ID:
					list = this.parent.element ()
						.findElementsById (this.locator.getLocator ());
					break;
				case LINK_TEXT:
					list = this.parent.element ()
						.findElementsByLinkText (this.locator.getLocator ());
					break;
				case NAME:
					list = this.parent.element ()
						.findElementsByName (this.locator.getLocator ());
					break;
				case PARTIAL_LINK:
					list = this.parent.element ()
						.findElementsByPartialLinkText (this.locator.getLocator ());
					break;
				case TAG:
					list = this.parent.element ()
						.findElementsByTagName (this.locator.getLocator ());
					break;
				case XPATH:
					list = this.parent.element ()
						.findElementsByXPath (this.locator.getLocator ());
					break;
				default:
					log.error ("Incorrect FindBy value: " + this.locator);
					break;
			}
		}
		this.currentElement = list.get (this.index);
		Objects.requireNonNull (this.currentElement, this.name + " cannot be found.");
	}
}