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

import static com.github.wasiqb.coteafs.appium.utils.StringUtil.replaceSystemProperty;

import java.util.HashMap;
import java.util.Map;

import com.github.wasiqb.coteafs.appium.config.enums.Protocol;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:43:22 PM
 */
public class ServerSetting {
    private static int countInstance = 0;

    private String                appiumJsPath;
    private ServerArgumentSetting arguments;
    private boolean               cloud;
    private Map<String, String>   environmentVariables;
    private boolean               external;
    private boolean               fullReset;
    private String                host;
    private String                logFilePath;
    private boolean               noReset;
    private String                nodePath;
    private String                password;
    private int                   port;
    private Protocol              protocol;
    private int                   sessionTimeout;
    private long                  startUpTimeOutSeconds;
    private String                userName;

    /**
     * @author wasiq.bhamla
     * @since 08-May-2017 7:49:49 PM
     */
    public ServerSetting() {
        countInstance++;
        this.cloud = false;
        this.external = false;
        this.noReset = false;
        this.fullReset = false;
        this.sessionTimeout = 120;
        this.startUpTimeOutSeconds = 60;
        this.environmentVariables = new HashMap<>();
        this.protocol = Protocol.HTTP;
        this.logFilePath = String.format("%s/logs/server-%d.log", System.getProperty("user.dir"), countInstance);
        this.arguments = new ServerArgumentSetting();
    }

    /**
     * @return the appiumJsPath
     * @author wasiq.bhamla
     * @since 09-May-2017 3:46:11 PM
     */
    public String getAppiumJsPath() {
        return this.appiumJsPath;
    }

    /**
     * @return the arguments
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:28:09 PM
     */
    public ServerArgumentSetting getArguments() {
        return this.arguments;
    }

    /**
     * @return the environmentVariables
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:28:09 PM
     */
    public Map<String, String> getEnvironmentVariables() {
        return this.environmentVariables;
    }

    /**
     * @return the host
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:51:26 PM
     */
    public String getHost() {
        return this.host;
    }

    /**
     * @return the logFilePath
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:28:09 PM
     */
    public String getLogFilePath() {
        return this.logFilePath;
    }

    /**
     * @return the nodePath
     * @author wasiq.bhamla
     * @since Jan 23, 2018 11:18:22 PM
     */
    public String getNodePath() {
        return this.nodePath;
    }

    /**
     * @return the password
     * @author wasiqb
     * @since Sep 29, 2018
     */
    public String getPassword() {
        return replaceSystemProperty(this.password);
    }

    /**
     * @return the port
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:51:26 PM
     */
    public int getPort() {
        return this.port;
    }

    /**
     * @return the protocol
     * @author wasiqb
     * @since Sep 29, 2018
     */
    public Protocol getProtocol() {
        return this.protocol;
    }

    /**
     * @return the sessionTimeout
     * @author wasiq.bhamla
     * @since 08-May-2017 7:49:31 PM
     */
    public int getSessionTimeout() {
        return this.sessionTimeout;
    }

    /**
     * @return the startUpTimeOutSeconds
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:51:26 PM
     */
    public long getStartUpTimeOutSeconds() {
        return this.startUpTimeOutSeconds;
    }

    /**
     * @return the userName
     * @author wasiqb
     * @since Sep 29, 2018
     */
    public String getUserName() {
        return replaceSystemProperty(this.userName);
    }

    /**
     * @return the cloud
     * @author wasiqb
     * @since Sep 29, 2018
     */
    public boolean isCloud() {
        return this.cloud;
    }

    /**
     * @return the external
     * @author wasiq.bhamla
     * @since 21-Apr-2017 5:06:22 PM
     */
    public boolean isExternal() {
        return this.external;
    }

    /**
     * @return the fullReset
     * @author wasiq.bhamla
     * @since 08-May-2017 7:56:41 PM
     */
    public boolean isFullReset() {
        return this.fullReset;
    }

    /**
     * @return the noReset
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:51:26 PM
     */
    public boolean isNoReset() {
        return this.noReset;
    }

    /**
     * @param appiumJsPath the appiumJsPath to set
     * @author wasiq.bhamla
     * @since 09-May-2017 3:46:11 PM
     */
    public void setAppiumJsPath(final String appiumJsPath) {
        this.appiumJsPath = appiumJsPath;
    }

    /**
     * @param arguments the arguments to set
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:28:09 PM
     */
    public void setArguments(final ServerArgumentSetting arguments) {
        this.arguments = arguments;
    }

    /**
     * @param cloud the cloud to set
     * @author wasiqb
     * @since Sep 29, 2018
     */
    public void setCloud(final boolean cloud) {
        this.cloud = cloud;
    }

    /**
     * @param environmentVariables the environmentVariables to set
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:28:09 PM
     */
    public void setEnvironmentVariables(final Map<String, String> environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    /**
     * @param external the external to set
     * @author wasiq.bhamla
     * @since 21-Apr-2017 5:06:22 PM
     */
    public void setExternal(final boolean external) {
        this.external = external;
    }

    /**
     * @param fullReset the fullReset to set
     * @author wasiq.bhamla
     * @since 08-May-2017 7:56:52 PM
     */
    public void setFullReset(final boolean fullReset) {
        this.fullReset = fullReset;
    }

    /**
     * @param host the host to set
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:51:26 PM
     */
    public void setHost(final String host) {
        this.host = host;
    }

    /**
     * @param logFilePath the logFilePath to set
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:28:09 PM
     */
    public void setLogFilePath(final String logFilePath) {
        this.logFilePath = logFilePath;
    }

    /**
     * @param noReset the noReset to set
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:51:26 PM
     */
    public void setNoReset(final boolean noReset) {
        this.noReset = noReset;
    }

    /**
     * @param nodePath the nodePath to set
     * @author wasiq.bhamla
     * @since Jan 23, 2018 11:18:22 PM
     */
    public void setNodePath(final String nodePath) {
        this.nodePath = nodePath;
    }

    /**
     * @param password the password to set
     * @author wasiqb
     * @since Sep 29, 2018
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @param port the port to set
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:51:26 PM
     */
    public void setPort(final int port) {
        this.port = port;
    }

    /**
     * @param protocol the protocol to set
     * @author wasiqb
     * @since Sep 29, 2018
     */
    public void setProtocol(final Protocol protocol) {
        this.protocol = protocol;
    }

    /**
     * @param sessionTimeout the sessionTimeout to set
     * @author wasiq.bhamla
     * @since 08-May-2017 7:49:31 PM
     */
    public void setSessionTimeout(final int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    /**
     * @param startUpTimeOutSeconds the startUpTimeOutSeconds to set
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:51:26 PM
     */
    public void setStartUpTimeOutSeconds(final long startUpTimeOutSeconds) {
        this.startUpTimeOutSeconds = startUpTimeOutSeconds;
    }

    /**
     * @param userName the userName to set
     * @author wasiqb
     * @since Sep 29, 2018
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }
}