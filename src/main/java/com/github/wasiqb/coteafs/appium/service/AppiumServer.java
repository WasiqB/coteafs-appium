package com.github.wasiqb.coteafs.appium.service;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.github.wasiqb.coteafs.appium.config.ConfigLoader;
import com.github.wasiqb.coteafs.appium.config.ServerSetting;

import io.appium.java_client.service.local.AppiumDriverLocalService;
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
	private DesiredCapabilities			capabilites;
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
		initService ();
		buildCapabilities ();
		buildService ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 3:28:14 PM
	 * @return url
	 */
	public URL getServiceUrl () {
		log.trace ("Fetching Appium Service URL...");
		return this.service.getUrl ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 5:30:12 PM
	 * @return isRunning
	 */
	public boolean isRunning () {
		log.trace ("Checking if Appium Service is running...");
		return this.service.isRunning ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 5:23:19 PM
	 */
	public void start () {
		log.trace ("Starting Appium Service...");
		this.service = AppiumDriverLocalService.buildService (this.builder);
		this.service.addOutPutStream (System.err);
		this.service.start ();
		log.trace ("Appium Service Started...");
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 5:23:39 PM
	 */
	public void stop () {
		log.trace ("Stopping Appium Service...");
		this.service.stop ();
		log.trace ("Appium Service Stopped...");
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 9:29:17 PM
	 */
	private void buildCapabilities () {
		log.trace ("Building Appium Capabilities started...");
		this.capabilites.setCapability ("noReset", Boolean.toString (this.setting.isNoReset ()));
		log.trace ("Building Appium Capabilities completed...");
	}

	private void buildService () {
		log.trace ("Building Appium Service started...");
		this.builder.withIPAddress (this.setting.getIp ())
			.usingPort (this.setting.getPort ())
			.withCapabilities (this.capabilites)
			.withStartUpTimeOut (this.setting.getStartUpTimeOutSeconds (), TimeUnit.SECONDS)
			.withArgument (GeneralServerFlag.SESSION_OVERRIDE)
			.withArgument (GeneralServerFlag.LOG_LEVEL, "error");
		log.debug (this.builder.toString ());
		log.trace ("Building Appium Service done...");
	}

	private void initService () {
		log.trace ("Initializing Appium Service started...");
		this.builder = new AppiumServiceBuilder ();
		this.capabilites = new DesiredCapabilities ();
		log.trace ("Initializing Appium Service done...");
	}
}