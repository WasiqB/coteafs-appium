package com.github.wasiqb.coteafs.appium.ios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.wasiqb.coteafs.appium.service.AppiumServer;
import com.github.wasiqb.coteafs.appium.service.Device;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 5:33:35 PM
 */
public class IosDevice extends Device {
	private static final Logger log;

	static {
		log = LogManager.getLogger (IosDevice.class);
	}

	private IOSDriver <IOSElement> driver;

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 9:12:09 PM
	 * @param server
	 * @param name
	 */
	public IosDevice (final AppiumServer server, final String name) {
		super (server, name);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 3:34:29 PM
	 * @return iOS Device
	 */
	public IOSDriver <IOSElement> getIosDevice () {
		if (this.driver == null) {
			log.trace ("Preparing iOS device driver...");
			this.driver = new IOSDriver <IOSElement> (this.server.getServiceUrl (), this.capabilities);
		}
		else {
			log.trace ("Getting iOS device driver...");
		}
		return this.driver;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 5:37:34 PM
	 */
	public void quit () {
		log.trace ("Quitting iOS device driver...");
		this.driver.quit ();
	}
}