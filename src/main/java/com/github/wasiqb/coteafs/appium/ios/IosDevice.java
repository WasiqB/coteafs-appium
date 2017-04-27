package com.github.wasiqb.coteafs.appium.ios;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.wasiqb.coteafs.appium.device.Device;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

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
	 * @since 25-Apr-2017 4:47:04 PM
	 * @return iOS Driver
	 */
	public IOSDriver <IOSElement> getIOSDriver () {
		log.trace ("Getting iOS device driver...");
		return this.driver;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.service.Device#start()
	 */
	@Override
	public void start () {
		log.trace ("Starting iOS device driver...");
		this.driver = new IOSDriver <IOSElement> (this.server.getServiceUrl (), this.capabilities);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.service.Device#stop()
	 */
	@Override
	public void stop () {
		if (this.driver != null) {
			log.trace ("Closign app on iOS device...");
			this.driver.closeApp ();

			log.trace ("Quitting iOS device driver...");
			this.driver.quit ();
			this.driver = null;
		}
		else {
			log.trace ("iOS device driver already stopped...");
		}
	}
}