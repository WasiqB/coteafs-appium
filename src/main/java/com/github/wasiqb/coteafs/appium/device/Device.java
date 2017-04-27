package com.github.wasiqb.coteafs.appium.device;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.github.wasiqb.coteafs.appium.config.ConfigLoader;
import com.github.wasiqb.coteafs.appium.config.DeviceSetting;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

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
		Objects.requireNonNull (this.setting.getDeviceName ());
		Objects.requireNonNull (this.setting.getDeviceType ());
		Objects.requireNonNull (this.setting.getAppLocation ());
		this.capabilities = new DesiredCapabilities ();

		setCapability (MobileCapabilityType.DEVICE_NAME, this.setting.getDeviceName ());
		setCapability (MobileCapabilityType.PLATFORM_NAME, this.setting.getDeviceType ()
			.name ());
		setCapability (MobileCapabilityType.PLATFORM_VERSION, this.setting.getDeviceVersion ());
		setCapability (MobileCapabilityType.BROWSER_NAME, this.setting.getDeviceType ()
			.name ());

		final StringBuilder path = new StringBuilder (System.getProperty ("user.dir"));
		path.append (System.getProperty ("file.separator"))
			.append (this.setting.getAppLocation ());

		setCapability (MobileCapabilityType.APP, path.toString ());
		setCapability (MobileCapabilityType.AUTOMATION_NAME, this.setting.getAutomationName ()
			.name ());
		setCapability (AndroidMobileCapabilityType.APP_ACTIVITY, this.setting.getAppActivity ());
		setCapability (AndroidMobileCapabilityType.APP_PACKAGE, this.setting.getAppPackage ());
		setCapability (AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, this.setting.getAppWaitActivity ());

		setCapability (IOSMobileCapabilityType.APP_NAME, this.setting.getAppName ());
		setCapability (IOSMobileCapabilityType.BUNDLE_ID, this.setting.getBundleId ());
		setCapability ("udid", this.setting.getUdid ());
		setCapability ("bootstrapPath", this.setting.getBootstrapPath ());
		setCapability ("agentPath", this.setting.getAgentPath ());

		log.trace ("Building Device capabilities completed...");
	}

	private void setCapability (final String key, final String value) {
		if (!StringUtils.isEmpty (value)) {
			this.capabilities.setCapability (key, value);
		}
	}
}