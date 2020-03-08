/*
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
    private DeviceSetting              device;
    private Map<String, DeviceSetting> devices;
    private ServerSetting              server;
    private Map<String, ServerSetting> servers;

    /**
     * @return the device
     * @author wasiqb
     * @since Oct 16, 2018
     */
    public DeviceSetting getDevice() {
        return this.device;
    }

    /**
     * @param key
     * @return the device
     * @author wasiq.bhamla
     * @since 12-Apr-2017 9:00:16 PM
     */
    public DeviceSetting getDevice(final String key) {
        return this.devices.get(key);
    }

    /**
     * @return the devices
     * @author wasiq.bhamla
     * @since 13-Apr-2017 9:59:40 PM
     */
    public Map<String, DeviceSetting> getDevices() {
        return this.devices;
    }

    /**
     * @return the server
     * @author wasiqb
     * @since Oct 16, 2018
     */
    public ServerSetting getServer() {
        return this.server;
    }

    /**
     * @param key
     * @return the server
     * @author wasiq.bhamla
     * @since 12-Apr-2017 9:00:16 PM
     */
    public ServerSetting getServer(final String key) {
        return this.servers.get(key);
    }

    /**
     * @return the servers
     * @author wasiq.bhamla
     * @since 13-Apr-2017 9:59:40 PM
     */
    public Map<String, ServerSetting> getServers() {
        return this.servers;
    }

    /**
     * @param device the device to set
     * @author wasiqb
     * @since Oct 16, 2018
     */
    public void setDevice(final DeviceSetting device) {
        this.device = device;
    }

    /**
     * @param devices the devices to set
     * @author wasiq.bhamla
     * @since 13-Apr-2017 9:59:40 PM
     */
    public void setDevices(final Map<String, DeviceSetting> devices) {
        this.devices = devices;
    }

    /**
     * @param server the server to set
     * @author wasiqb
     * @since Oct 16, 2018
     */
    public void setServer(final ServerSetting server) {
        this.server = server;
    }

    /**
     * @param servers the servers to set
     * @author wasiq.bhamla
     * @since 13-Apr-2017 9:59:40 PM
     */
    public void setServers(final Map<String, ServerSetting> servers) {
        this.servers = servers;
    }
}