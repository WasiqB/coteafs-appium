/**
 * Copyright (c) 2017, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.wasiqb.coteafs.appium.device;

import static com.github.wasiqb.coteafs.appium.constants.ConfigKeys.COTEAFS_CONFIG_DEFAULT_FILE;
import static com.github.wasiqb.coteafs.appium.constants.ConfigKeys.COTEAFS_CONFIG_KEY;
import static com.github.wasiqb.coteafs.appium.constants.ErrorMessage.SERVER_STOPPED;
import static com.github.wasiqb.coteafs.appium.utils.CapabilityUtils.setCapability;
import static com.github.wasiqb.coteafs.error.util.ErrorUtil.fail;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_WAIT_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.AVD;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.AVD_READY_TIMEOUT;
import static io.appium.java_client.remote.IOSMobileCapabilityType.APP_NAME;
import static io.appium.java_client.remote.IOSMobileCapabilityType.BUNDLE_ID;
import static io.appium.java_client.remote.IOSMobileCapabilityType.SHOW_XCODE_LOG;
import static io.appium.java_client.remote.IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID;
import static io.appium.java_client.remote.IOSMobileCapabilityType.USE_NEW_WDA;
import static io.appium.java_client.remote.IOSMobileCapabilityType.USE_PREBUILT_WDA;
import static io.appium.java_client.remote.IOSMobileCapabilityType.WDA_CONNECTION_TIMEOUT;
import static io.appium.java_client.remote.IOSMobileCapabilityType.XCODE_ORG_ID;
import static io.appium.java_client.remote.IOSMobileCapabilityType.XCODE_SIGNING_ID;
import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.BROWSER_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.CLEAR_SYSTEM_FILES;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NEW_COMMAND_TIMEOUT;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;
import static java.lang.System.getProperty;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.github.wasiqb.coteafs.appium.config.AppiumSetting;
import com.github.wasiqb.coteafs.appium.config.ApplicationType;
import com.github.wasiqb.coteafs.appium.config.DeviceSetting;
import com.github.wasiqb.coteafs.appium.config.DeviceType;
import com.github.wasiqb.coteafs.appium.error.AppiumServerStoppedError;
import com.github.wasiqb.coteafs.appium.error.DeviceAppNotClosingError;
import com.github.wasiqb.coteafs.appium.error.DeviceAppNotFoundError;
import com.github.wasiqb.coteafs.appium.error.DeviceDesiredCapabilitiesNotSetError;
import com.github.wasiqb.coteafs.appium.error.DeviceDriverDefaultWaitError;
import com.github.wasiqb.coteafs.appium.error.DeviceDriverInitializationFailedError;
import com.github.wasiqb.coteafs.appium.error.DeviceDriverNotStartingError;
import com.github.wasiqb.coteafs.appium.error.DeviceDriverNotStoppingError;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;
import com.github.wasiqb.coteafs.config.loader.ConfigLoader;
import com.google.common.reflect.TypeToken;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author wasiq.bhamla
 * @param <D>
 * @since 12-Apr-2017 9:38:38 PM
 */
public class Device <D extends AppiumDriver <MobileElement>> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (Device.class);
	}

	protected DesiredCapabilities	capabilities;
	protected D						driver;
	protected final AppiumServer	server;
	protected final DeviceSetting	setting;

	/**
	 * @author wasiq.bhamla
	 * @param server
	 * @param name
	 * @since 13-Apr-2017 9:10:11 PM
	 */
	public Device (final AppiumServer server, final String name) {
		this.server = server;
		this.setting = ConfigLoader.settings ()
			.withKey (COTEAFS_CONFIG_KEY)
			.withDefault (COTEAFS_CONFIG_DEFAULT_FILE)
			.load (AppiumSetting.class)
			.getDevice (name);
		buildCapabilities ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 01-May-2017 7:08:10 PM
	 * @return driver
	 */
	public D getDriver () {
		final String platform = this.setting.getPlatformType ()
			.getName ();
		final String msg = "Getting [%s] device driver...";
		log.trace (String.format (msg, platform));
		return this.driver;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 9, 2017 4:36:02 PM
	 * @return the setting
	 */
	public DeviceSetting getSetting () {
		return this.setting;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-Apr-2017 4:46:12 PM
	 */
	public void start () {
		final String platform = this.setting.getPlatformType ()
			.getName ();
		startDriver (platform);
		setImplicitWait ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-Apr-2017 4:46:02 PM
	 */
	public void stop () {
		final String platform = this.setting.getPlatformType ()
			.getName ();
		if (this.driver != null) {
			closeApp (platform);
			quitApp (platform);
			this.driver = null;
		}
		else {
			final String message = "[%s] device driver already stopped...";
			log.trace (String.format (message, platform));
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 3:38:32 PM
	 */
	private void buildCapabilities () {
		log.trace ("Building Device capabilities...");
		this.capabilities = new DesiredCapabilities ();

		setCommonCapabilities ();
		setDeviceSpecificCapabilities ();

		if (this.setting.getAppType () == ApplicationType.WEB) {
			setCapability (BROWSER_NAME, this.setting.getBrowser ()
				.getBrowser (), this.capabilities, true);
		}
		else {
			final String appPath = this.setting.getAppLocation ();
			if (appPath != null) {
				String path = "%s/src/test/resources/%s";
				path = String.format (path, getProperty ("user.dir"), appPath);

				if (this.setting.isExternalApp ()) {
					path = this.setting.getAppLocation ();
				}

				final File file = new File (path);
				if (!file.exists ()) {
					final String msg = "App not found on mentioned location [%s]...";
					log.error (String.format (msg, path));
					fail (DeviceAppNotFoundError.class, String.format (msg, path));
				}
				setCapability (APP, path, this.capabilities, true);
			}
		}
		log.trace ("Building Device capabilities completed...");
	}

	/**
	 * @author wasiq.bhamla
	 * @param platform
	 * @since Oct 16, 2017 8:07:53 PM
	 */
	private void closeApp (final String platform) {
		final String message = "Closign app on [%s] device...";
		log.trace (String.format (message, platform));
		try {
			this.driver.closeApp ();
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
		catch (final Exception e) {
			fail (DeviceAppNotClosingError.class, "Error occured while closing app.", e);
		}
	}

	@SuppressWarnings ("unchecked")
	private D init (final URL url, final Capabilities capability) {
		log.trace ("Initializing driver...");
		final TypeToken <D> token = new TypeToken <D> (getClass ()) {
			private static final long serialVersionUID = 1562415938665085306L;
		};
		final Class <D> cls = (Class <D>) token.getRawType ();
		final Class <?> [] argTypes = new Class <?> [] { URL.class, Capabilities.class };
		try {
			final Constructor <D> ctor = cls.getDeclaredConstructor (argTypes);
			return ctor.newInstance (url, capability);
		}
		catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			fail (DeviceDriverInitializationFailedError.class, "Error occured while initializing device driver.", e);
		}
		return null;
	}

	/**
	 * @author wasiq.bhamla
	 * @param platform
	 * @since Oct 16, 2017 8:14:56 PM
	 */
	private void quitApp (final String platform) {
		final String message = "Quitting [%s] device driver...";
		log.trace (String.format (message, platform));
		try {
			this.driver.quit ();
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
		catch (final Exception e) {
			fail (DeviceDriverNotStoppingError.class, "Error occured while stopping device driver.", e);
		}
	}

	private void setAndroidCapabilities () {
		final String packageName = this.setting.getAppPackage ();
		final String app = this.setting.getAppLocation ();
		if (packageName == null && app == null) {
			fail (DeviceDesiredCapabilitiesNotSetError.class, "Either App or Package name is mandatory...");
		}

		if (this.setting.getDeviceType () == DeviceType.SIMULATOR) {
			setCapability (AVD, this.setting.getAvd (), this.capabilities, true);
			setCapability (AVD_READY_TIMEOUT, SECONDS.toMillis (this.setting.getAvdReadyTimeout ()), this.capabilities);
			setCapability (AVD_LAUNCH_TIMEOUT, SECONDS.toMillis (this.setting.getAvdLaunchTimeout ()),
					this.capabilities);
		}
		if (this.setting.getAppType () != ApplicationType.WEB) {
			setCapability (APP_ACTIVITY, this.setting.getAppActivity (), this.capabilities);
			setCapability (APP_PACKAGE, this.setting.getAppPackage (), this.capabilities);
			setCapability (APP_WAIT_ACTIVITY, this.setting.getAppWaitActivity (), this.capabilities);
		}
	}

	private void setCommonCapabilities () {
		setCapability (DEVICE_NAME, this.setting.getDeviceName (), this.capabilities, true);
		setCapability (PLATFORM_NAME, this.setting.getPlatformType ()
			.getName (), this.capabilities, true);
		setCapability (PLATFORM_VERSION, this.setting.getDeviceVersion (), this.capabilities);
		setCapability (NO_RESET, this.setting.isNoReset (), this.capabilities);
		setCapability (FULL_RESET, this.setting.isFullReset (), this.capabilities);
		setCapability (NEW_COMMAND_TIMEOUT, this.setting.getSessionTimeout (), this.capabilities);
		setCapability (CLEAR_SYSTEM_FILES, this.setting.isClearSystemFiles (), this.capabilities);
		setCapability (AUTOMATION_NAME, this.setting.getAutomationName ()
			.getName (), this.capabilities, true);
	}

	private void setDeviceSpecificCapabilities () {
		switch (this.setting.getPlatformType ()) {
			case IOS:
				setIOSCapabilities ();
				break;
			case ANDROID:
				setAndroidCapabilities ();
				break;
			case WINDOWS:
			default:
				break;
		}
	}

	private void setImplicitWait () {
		try {
			this.driver.manage ()
				.timeouts ()
				.implicitlyWait (this.setting.getDefaultWait (), TimeUnit.SECONDS);
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
		catch (final Exception e) {
			fail (DeviceDriverDefaultWaitError.class, "Error occured while setting device driver default wait.", e);
		}
	}

	private void setIOSCapabilities () {
		if (this.setting.getAppType () != ApplicationType.WEB) {
			setCapability (BUNDLE_ID, this.setting.getBundleId (), this.capabilities, true);
		}
		setCapability (XCODE_ORG_ID, this.setting.getTeamId (), this.capabilities, true);
		setCapability (XCODE_SIGNING_ID, this.setting.getSigningId (), this.capabilities, true);
		setCapability (APP_NAME, this.setting.getAppName (), this.capabilities, true);
		setCapability (UDID, this.setting.getUdid (), this.capabilities, true);
		setCapability (WDA_CONNECTION_TIMEOUT, this.setting.getWdaConnectionTimeout (), this.capabilities, true);
		setCapability ("bootstrapPath", this.setting.getBootstrapPath (), this.capabilities);
		setCapability ("agentPath", this.setting.getAgentPath (), this.capabilities);
		setCapability (UPDATE_WDA_BUNDLEID, this.setting.getUpdatedWdaBundleId (), this.capabilities);
		setCapability (USE_NEW_WDA, this.setting.isUseNewWda (), this.capabilities);
		setCapability (USE_PREBUILT_WDA, this.setting.isUsePrebuiltWda (), this.capabilities);
		setCapability (SHOW_XCODE_LOG, this.setting.isShowXcodeLog (), this.capabilities);
	}

	private void startDriver (final String platform) {
		final String msg = "Starting [%s] device driver...";
		log.trace (String.format (msg, platform));
		try {
			this.driver = init (this.server.getServiceUrl (), this.capabilities);
		}
		catch (final Exception e) {
			fail (DeviceDriverNotStartingError.class, "Error occured starting device driver", e);
		}
	}
}