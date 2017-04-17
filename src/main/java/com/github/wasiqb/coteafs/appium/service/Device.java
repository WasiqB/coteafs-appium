package com.github.wasiqb.coteafs.appium.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.github.wasiqb.coteafs.appium.config.ConfigLoader;
import com.github.wasiqb.coteafs.appium.config.DeviceSetting;

import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 9:38:38 PM
 */
public abstract class Device {
	private static final Logger log;

	static {
		log = LogManager.getLogger (Device.class);
	}

	protected DesiredCapabilities	capabilities;
	protected AppiumServer			server;
	protected DeviceSetting			setting;

	/**
	 * @author wasiq.bhamla
	 * @param server
	 * @param name
	 * @since 13-Apr-2017 9:10:11 PM
	 */
	public Device (final AppiumServer server, final String name) {
		this.server = server;
		this.setting = ConfigLoader.settings ()
			.getDevice (name);
		buildCapabilities ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-Apr-2017 4:46:12 PM
	 */
	public abstract void start ();

	/**
	 * @author wasiq.bhamla
	 * @since 17-Apr-2017 4:46:02 PM
	 */
	public abstract void stop ();

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 3:38:32 PM
	 */
	private void buildCapabilities () {
		log.trace ("Building Device capabilities...");
		this.capabilities = new DesiredCapabilities ();
		if (!StringUtils.isEmpty (this.setting.getDeviceName ())) {
			this.capabilities.setCapability (MobileCapabilityType.DEVICE_NAME, this.setting.getDeviceName ());
		}
		this.capabilities.setCapability (MobileCapabilityType.PLATFORM_NAME, this.setting.getDeviceType ());
		this.capabilities.setCapability (MobileCapabilityType.PLATFORM_VERSION, this.setting.getDeviceVersion ());
		this.capabilities.setCapability (MobileCapabilityType.BROWSER_NAME, MobilePlatform.ANDROID);

		final StringBuilder path = new StringBuilder (System.getProperty ("user.dir"));
		path.append (System.getProperty ("file.separator"))
			.append (this.setting.getAppLocation ());

		this.capabilities.setCapability (MobileCapabilityType.APP, path.toString ());
		this.capabilities.setCapability (MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
		if (!StringUtils.isEmpty (this.setting.getAppActivity ())) {
			this.capabilities.setCapability ("appActivity", this.setting.getAppActivity ());
		}
		if (!StringUtils.isEmpty (this.setting.getAppPackage ())) {
			this.capabilities.setCapability ("appPackage", this.setting.getAppPackage ());
		}
		if (!StringUtils.isEmpty (this.setting.getAppWaitActivity ())) {
			this.capabilities.setCapability ("appWaitActivity", this.setting.getAppWaitActivity ());
		}
		log.trace ("Building Device capabilities completed...");
	}
}