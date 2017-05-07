package com.github.wasiqb.coteafs.appium.config;

import java.util.Map;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:58:57 PM
 */
public class AppiumSetting {
	private Map <String, DeviceSetting>	devices;
	private Map <String, ServerSetting>	servers;

	/**
	 * @author wasiq.bhamla
	 * @param key
	 * @since 12-Apr-2017 9:00:16 PM
	 * @return the device
	 */
	public DeviceSetting getDevice (final String key) {
		return this.devices.get (key);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 9:59:40 PM
	 * @return the devices
	 */
	public Map <String, DeviceSetting> getDevices () {
		return this.devices;
	}

	/**
	 * @author wasiq.bhamla
	 * @param key
	 * @since 12-Apr-2017 9:00:16 PM
	 * @return the server
	 */
	public ServerSetting getServer (final String key) {
		return this.servers.get (key);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 9:59:40 PM
	 * @return the servers
	 */
	public Map <String, ServerSetting> getServers () {
		return this.servers;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 9:59:40 PM
	 * @param devices
	 *            the devices to set
	 */
	public void setDevices (final Map <String, DeviceSetting> devices) {
		this.devices = devices;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 9:59:40 PM
	 * @param servers
	 *            the servers to set
	 */
	public void setServers (final Map <String, ServerSetting> servers) {
		this.servers = servers;
	}
}