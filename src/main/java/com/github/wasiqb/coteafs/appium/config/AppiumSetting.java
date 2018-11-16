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
package com.github.wasiqb.coteafs.appium.config;

import java.util.Map;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:58:57 PM
 */
public class AppiumSetting {
	private DeviceSetting				device;
	private Map <String, DeviceSetting>	devices;
	private ServerSetting				server;
	private Map <String, ServerSetting>	servers;

	/**
	 * @author wasiqb
	 * @since Oct 16, 2018
	 * @return the device
	 */
	public DeviceSetting getDevice () {
		return this.device;
	}

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
	 * @author wasiqb
	 * @since Oct 16, 2018
	 * @return the server
	 */
	public ServerSetting getServer () {
		return this.server;
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
	 * @author wasiqb
	 * @since Oct 16, 2018
	 * @param device
	 *            the device to set
	 */
	public void setDevice (final DeviceSetting device) {
		this.device = device;
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
	 * @author wasiqb
	 * @since Oct 16, 2018
	 * @param server
	 *            the server to set
	 */
	public void setServer (final ServerSetting server) {
		this.server = server;
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