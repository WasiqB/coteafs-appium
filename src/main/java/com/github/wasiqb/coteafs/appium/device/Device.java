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

import static com.github.wasiqb.coteafs.appium.utils.CapabilityUtils.setCapability;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_WAIT_ACTIVITY;
import static io.appium.java_client.remote.IOSMobileCapabilityType.APP_NAME;
import static io.appium.java_client.remote.IOSMobileCapabilityType.BUNDLE_ID;
import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.BROWSER_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.NEW_COMMAND_TIMEOUT;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;

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

import com.github.wasiqb.coteafs.appium.config.ApplicationType;
import com.github.wasiqb.coteafs.appium.config.ConfigLoader;
import com.github.wasiqb.coteafs.appium.config.DeviceSetting;
import com.github.wasiqb.coteafs.appium.exception.AppiumServerStoppedException;
import com.github.wasiqb.coteafs.appium.exception.DeviceAppNotClosingException;
import com.github.wasiqb.coteafs.appium.exception.DeviceAppNotFoundException;
import com.github.wasiqb.coteafs.appium.exception.DeviceDriverDefaultWaitException;
import com.github.wasiqb.coteafs.appium.exception.DeviceDriverInitializationFailedException;
import com.github.wasiqb.coteafs.appium.exception.DeviceDriverNotStartingException;
import com.github.wasiqb.coteafs.appium.exception.DeviceDriverNotStoppingException;
import com.github.wasiqb.coteafs.appium.exception.DeviceTypeNotSupportedException;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;
import com.google.common.reflect.TypeToken;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author wasiq.bhamla
 * @param <TDriver>
 * @since 12-Apr-2017 9:38:38 PM
 */
public class Device <TDriver extends AppiumDriver <MobileElement>> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (Device.class);
	}

	protected DesiredCapabilities	capabilities;
	protected TDriver				driver;
	protected final AppiumServer	server;
	protected final DeviceSetting	setting;
	private TypeToken <TDriver>		token;

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
	 * @since 01-May-2017 7:08:10 PM
	 * @return driver
	 */
	public TDriver getDriver () {
		final String platform = this.setting.getDeviceType ()
			.getName ();
		final String msg = "Getting %s device driver...";
		log.trace (String.format (msg, platform));
		return this.driver;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-Apr-2017 4:46:12 PM
	 */
	public void start () {
		final String platform = this.setting.getDeviceType ()
			.getName ();
		startDriver (platform);
		setImplicitWait ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-Apr-2017 4:46:02 PM
	 */
	public void stop () {
		String msg = null;
		final String platform = this.setting.getDeviceType ()
			.getName ();
		if (this.driver != null) {
			msg = "Closign app on %s device...";
			log.trace (String.format (msg, platform));
			try {
				this.driver.closeApp ();
			}
			catch (final NoSuchSessionException e) {
				throw new AppiumServerStoppedException ("Server Session has been stopped.", e);
			}
			catch (final Exception e) {
				throw new DeviceAppNotClosingException ("Error occured while closing app.", e);
			}

			msg = "Quitting %s device driver...";
			log.trace (String.format (msg, platform));
			try {
				this.driver.quit ();
			}
			catch (final NoSuchSessionException e) {
				throw new AppiumServerStoppedException ("Server Session has been stopped.", e);
			}
			catch (final Exception e) {
				throw new DeviceDriverNotStoppingException ("Error occured while stopping device driver.", e);
			}
			this.driver = null;
		}
		else {
			msg = "%s device driver already stopped...";
			log.trace (String.format (msg, platform));
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 3:38:32 PM
	 */
	private void buildCapabilities () {
		log.trace ("Building Device capabilities...");
		this.capabilities = new DesiredCapabilities ();

		setCapability (DEVICE_NAME, this.setting.getDeviceName (), this.capabilities, true);
		setCapability (PLATFORM_NAME, this.setting.getDeviceType ()
			.getName (), this.capabilities, true);
		setCapability (PLATFORM_VERSION, this.setting.getDeviceVersion (), this.capabilities);

		if (this.setting.getAppType () == ApplicationType.WEB) {
			setCapability (BROWSER_NAME, this.setting.getDeviceType ()
				.getName (), this.capabilities, true);
		}
		else {
			String path = System.getProperty ("user.dir") + "/src/test/resources/" + this.setting.getAppLocation ();

			if (this.setting.isExternalApp ()) {
				path = this.setting.getAppLocation ();
			}

			final File file = new File (path);
			if (!file.exists ()) {
				final String msg = "App not found on mentioned location [%s]...";
				log.error (String.format (msg, path));
				throw new DeviceAppNotFoundException (String.format (msg, path));
			}
			setCapability (APP, path, this.capabilities, true);
		}

		setDeviceSpecificCapabilities ();

		setCapability (NO_RESET, this.setting.isNoReset (), this.capabilities);
		setCapability (FULL_RESET, this.setting.isFullReset (), this.capabilities);
		setCapability (NEW_COMMAND_TIMEOUT, this.setting.getSessionTimeout (), this.capabilities);
		setCapability ("clearSystemFiles", this.setting.isClearSystemFiles (), this.capabilities);
		setCapability (AUTOMATION_NAME, this.setting.getAutomationName ()
			.getName (), this.capabilities, true);
		log.trace ("Building Device capabilities completed...");
	}

	@SuppressWarnings ("unchecked")
	private TDriver init (final URL url, final Capabilities capability) {
		log.trace ("Initializing driver...");
		this.token = new TypeToken <TDriver> (getClass ()) {
			private static final long serialVersionUID = 1562415938665085306L;
		};
		final Class <TDriver> cls = (Class <TDriver>) this.token.getRawType ();
		final Class <?> [] argTypes = new Class <?> [] { URL.class, Capabilities.class };
		try {
			final Constructor <TDriver> ctor = cls.getDeclaredConstructor (argTypes);
			return ctor.newInstance (url, capability);
		}
		catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			throw new DeviceDriverInitializationFailedException ("Error occured while initializing device driver.", e);
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 5:02:30 PM
	 */
	private void setAndroidCapabilities () {
		setCapability (APP_ACTIVITY, this.setting.getAppActivity (), this.capabilities, true);
		setCapability (APP_PACKAGE, this.setting.getAppPackage (), this.capabilities, true);
		setCapability (APP_WAIT_ACTIVITY, this.setting.getAppWaitActivity (), this.capabilities);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 5:03:30 PM
	 */
	private void setDeviceSpecificCapabilities () {
		switch (this.setting.getDeviceType ()) {
			case IOS:
				setIOSCapabilities ();
				break;
			case ANDROID:
				setAndroidCapabilities ();
				break;
			case WINDOWS:
				// No other setting needed for Windows. Only App is required.
				break;
			default:
				final String msg = "%s device type not supported.";
				throw new DeviceTypeNotSupportedException (String.format (msg, this.setting.getDeviceType ()));
		}
	}

	private void setImplicitWait () {
		try {
			this.driver.manage ()
				.timeouts ()
				.implicitlyWait (this.setting.getDefaultWait (), TimeUnit.SECONDS);
		}
		catch (final NoSuchSessionException e) {
			throw new AppiumServerStoppedException ("Server Session has been stopped.", e);
		}
		catch (final Exception e) {
			throw new DeviceDriverDefaultWaitException ("Error occured while setting device driver default wait.", e);
		}
	}

	private void setIOSCapabilities () {
		setCapability ("xcodeOrgId", this.setting.getTeamId (), this.capabilities, true);
		setCapability ("xcodeSigningId", this.setting.getSigningId (), this.capabilities, true);
		setCapability (APP_NAME, this.setting.getAppName (), this.capabilities, true);
		setCapability (BUNDLE_ID, this.setting.getBundleId (), this.capabilities, true);
		setCapability (UDID, this.setting.getUdid (), this.capabilities, true);
		setCapability ("wdaConnectionTimeout", this.setting.getWdaConnectionTimeout (), this.capabilities, true);
		setCapability ("bootstrapPath", this.setting.getBootstrapPath (), this.capabilities);
		setCapability ("agentPath", this.setting.getAgentPath (), this.capabilities);
		setCapability ("updatedWDABundleId", this.setting.getUpdatedWdaBundleId (), this.capabilities);
		setCapability ("useNewWDA", this.setting.isUseNewWda (), this.capabilities);
		setCapability ("usePrebuiltWDA", this.setting.isUsePrebuiltWda (), this.capabilities);
	}

	private void startDriver (final String platform) {
		final String msg = "Starting %s device driver...";
		log.trace (String.format (msg, platform));
		try {
			this.driver = init (this.server.getServiceUrl (), this.capabilities);
		}
		catch (final Exception e) {
			throw new DeviceDriverNotStartingException ("Error occured starting device driver", e);
		}
	}
}