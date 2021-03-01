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

import com.github.wasiqb.coteafs.appium.config.server.ServerSetting;
import com.github.wasiqb.coteafs.datasource.annotation.DataFile;
import lombok.Data;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:58:57 PM
 */
@Data
@DataFile (fileName = "appium-config.yaml")
public class AppiumSetting {
    private DeviceSetting              device;
    private Map<String, DeviceSetting> devices;
    private ServerSetting              server;
    private Map<String, ServerSetting> servers;

    /**
     * @param key Device key
     *
     * @return the device
     *
     * @author wasiq.bhamla
     * @since 12-Apr-2017 9:00:16 PM
     */
    public DeviceSetting getDevice (final String key) {
        return this.devices.get (key);
    }

    /**
     * @param key Server key
     *
     * @return the server
     *
     * @author wasiq.bhamla
     * @since 12-Apr-2017 9:00:16 PM
     */
    public ServerSetting getServer (final String key) {
        return this.servers.get (key);
    }
}