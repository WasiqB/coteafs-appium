/*
 *
 *  Copyright (c) 2020, Wasiq Bhamla.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.github.wasiqb.coteafs.appium.config.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.wasiqb.coteafs.appium.config.enums.CloudProviders;
import com.github.wasiqb.coteafs.appium.config.enums.Protocol;
import lombok.Data;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:43:22 PM
 */
@Data
public class ServerSetting {
    private boolean             allowCors;
    private List<String>        allowInsecure;
    private AndroidSetting      android        = new AndroidSetting ();
    private String              appiumPath;
    private String              callbackIp;
    private int                 callbackPort;
    private CloudProviders      cloud;
    private Map<String, String> environments   = new HashMap<> ();
    private boolean             external;
    private String              host;
    private IOSSetting          ios            = new IOSSetting ();
    private LogSetting          logs           = new LogSetting ();
    private String              nodeConfig;
    private String              nodePath;
    private String              password;
    private int                 port;
    private boolean             preLaunch;
    private Protocol            protocol       = Protocol.HTTP;
    private boolean             relaxedSecurity;
    private boolean             sessionOverride;
    private int                 startUpTimeout = 60;
    private boolean             strictCapabilities;
    private String              userName;
}