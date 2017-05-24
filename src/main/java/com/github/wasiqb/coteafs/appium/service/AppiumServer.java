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
package com.github.wasiqb.coteafs.appium.service;

import static com.github.wasiqb.coteafs.appium.utils.CapabilityUtils.setCapability;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.github.wasiqb.coteafs.appium.checker.ServerChecker;
import com.github.wasiqb.coteafs.appium.config.ConfigLoader;
import com.github.wasiqb.coteafs.appium.config.ServerSetting;
import com.github.wasiqb.coteafs.appium.exception.AppiumServerAlreadyRunningException;
import com.github.wasiqb.coteafs.appium.exception.AppiumServerNotRunningException;
import com.github.wasiqb.coteafs.appium.exception.AppiumServerNotStartingException;
import com.github.wasiqb.coteafs.appium.exception.AppiumServerNotStoppingException;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 5:17:22 PM
 */
public final class AppiumServer {
	private static final Logger log;

	static {
		log = LogManager.getLogger (AppiumServer.class);
	}

	private AppiumServiceBuilder		builder;
	private DesiredCapabilities			capabilities;
	private AppiumDriverLocalService	service;
	private final ServerSetting			setting;

	/**
	 * @author wasiq.bhamla
	 * @param name
	 * @since 13-Apr-2017 7:33:24 PM
	 */
	public AppiumServer (final String name) {
		this.setting = ConfigLoader.settings ()
			.getServer (name);
		if (!this.setting.isExternal ()) {
			initService ();
			buildCapabilities ();
			buildService ();
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 3:28:14 PM
	 * @return url
	 */
	public URL getServiceUrl () {
		log.trace ("Fetching Appium Service URL...");
		if (!this.setting.isExternal ()) {
			return this.service.getUrl ();
		}
		final String url = String.format ("http://%s:%d/wd/hub", this.setting.getIp (), this.setting.getPort ());
		try {
			return new URL (url);
		}
		catch (final MalformedURLException e) {
			log.error ("Error occurred while getting service url...");
			log.catching (e);
		}
		return null;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 5:30:12 PM
	 * @return isRunning
	 */
	public boolean isRunning () {
		if (!this.setting.isExternal ()) {
			log.trace ("Checking if Appium Service is running...");
			return this.service.isRunning ();
		}
		final SocketAddress addr = new InetSocketAddress (this.setting.getIp (), this.setting.getPort ());
		try (Socket socket = new Socket ()) {
			socket.connect (addr, 2000);
			socket.close ();
		}
		catch (final IOException e) {
			throw new AppiumServerNotRunningException ("Error connecting to Server...", e);
		}
		return true;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 5:23:19 PM
	 */
	public void start () {
		log.trace ("Starting Appium Service...");
		if (!this.setting.isExternal ()) {
			this.service = AppiumDriverLocalService.buildService (this.builder);
			try {
				this.service.start ();
			}
			catch (final AppiumServerHasNotBeenStartedLocallyException e) {
				throw new AppiumServerNotStartingException ("Error occured while starting Appium server", e);
			}
			catch (final Exception e) {
				throw new AppiumServerAlreadyRunningException ("Appium server is running already.", e);
			}
			log.trace ("Appium Service Started...");
		}
		else {
			if (isRunning ()) {
				log.trace ("Appium Service is already running...");
			}
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 5:23:39 PM
	 */
	public void stop () {
		log.trace ("Trying to stop Appium Service...");
		if (!this.setting.isExternal ()) {
			try {
				this.service.stop ();
			}
			catch (final Exception e) {
				throw new AppiumServerNotStoppingException ("Error occured while stopping the server.", e);
			}
			this.service = null;
			log.trace ("Appium Service Stopped...");
		}
		else {
			log.trace ("Appium Service can only be stopped from the tool you started with...");
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 9:29:17 PM
	 */
	private void buildCapabilities () {
		log.trace ("Building Appium Capabilities started...");
		setCapability (MobileCapabilityType.NO_RESET, Boolean.toString (this.setting.isNoReset ()), this.capabilities);
		setCapability (MobileCapabilityType.FULL_RESET, Boolean.toString (this.setting.isFullReset ()),
				this.capabilities);
		setCapability (MobileCapabilityType.NEW_COMMAND_TIMEOUT, Integer.toString (this.setting.getSessionTimeout ()),
				this.capabilities);
		log.trace ("Building Appium Capabilities completed...");
	}

	private void buildService () {
		log.trace ("Building Appium Service started...");
		ServerChecker.checkServerConfigParams ("IP Address", this.setting.getIp ());
		ServerChecker.checkServerConfigParams ("Port", this.setting.getPort ());
		ServerChecker.checkServerConfigParams ("AppiumJS Path", this.setting.getAppiumJsPath ());
		final File appJs = new File (this.setting.getAppiumJsPath ());
		this.builder.withIPAddress (this.setting.getIp ())
			.usingPort (this.setting.getPort ())
			.withAppiumJS (appJs)
			.withCapabilities (this.capabilities)
			.withStartUpTimeOut (this.setting.getStartUpTimeOutSeconds (), TimeUnit.SECONDS)
			.withArgument (GeneralServerFlag.SESSION_OVERRIDE)
			.withArgument (GeneralServerFlag.LOG_LEVEL, "error");
		log.trace ("Building Appium Service done...");
	}

	private void initService () {
		log.trace ("Initializing Appium Service started...");
		this.builder = new AppiumServiceBuilder ();
		this.capabilities = new DesiredCapabilities ();
		log.trace ("Initializing Appium Service done...");
	}
}