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

import com.github.wasiqb.coteafs.appium.config.android.AndroidArgumentSetting;
import com.github.wasiqb.coteafs.appium.config.enums.LogLevel;
import com.github.wasiqb.coteafs.appium.config.ios.IOSArgumentSetting;

/**
 * @author wasiq.bhamla
 * @since Oct 27, 2017 1:26:27 PM
 */
public class ServerArgumentSetting {
    private AndroidArgumentSetting android;
    private String                 callbackIp;
    private int                    callbackPort;
    private IOSArgumentSetting     ios;
    private boolean                localTimeZone;
    private LogLevel               logLevel;
    private boolean                logTimeStamp;
    private String                 nodeConfigFile;
    private boolean                sessionOverride;

    /**
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:26:27 PM
     */
    public ServerArgumentSetting() {
        this.logLevel = LogLevel.ERROR;
        this.android = new AndroidArgumentSetting();
        this.ios = new IOSArgumentSetting();
    }

    /**
     * @return the android
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:02:13 PM
     */
    public AndroidArgumentSetting getAndroid() {
        return this.android;
    }

    /**
     * @return the callbackIp
     * @author wasiq.bhamla
     * @since Nov 20, 2017 11:26:54 PM
     */
    public String getCallbackIp() {
        return this.callbackIp;
    }

    /**
     * @return the callbackPort
     * @author wasiq.bhamla
     * @since Nov 20, 2017 11:26:54 PM
     */
    public int getCallbackPort() {
        return this.callbackPort;
    }

    /**
     * @return the ios
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:02:13 PM
     */
    public IOSArgumentSetting getIos() {
        return this.ios;
    }

    /**
     * @return the logLevel
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:37:02 PM
     */
    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    /**
     * @return the nodeConfigFile
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:37:02 PM
     */
    public String getNodeConfigFile() {
        return this.nodeConfigFile;
    }

    /**
     * @return the localTimeZone
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:37:02 PM
     */
    public boolean isLocalTimeZone() {
        return this.localTimeZone;
    }

    /**
     * @return the logTimeStamp
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:37:02 PM
     */
    public boolean isLogTimeStamp() {
        return this.logTimeStamp;
    }

    /**
     * @return the sessionOverride
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:37:02 PM
     */
    public boolean isSessionOverride() {
        return this.sessionOverride;
    }

    /**
     * @param android the android to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:02:13 PM
     */
    public void setAndroid(final AndroidArgumentSetting android) {
        this.android = android;
    }

    /**
     * @param callbackIp the callbackIp to set
     * @author wasiq.bhamla
     * @since Nov 20, 2017 11:26:54 PM
     */
    public void setCallbackIp(final String callbackIp) {
        this.callbackIp = callbackIp;
    }

    /**
     * @param callbackPort the callbackPort to set
     * @author wasiq.bhamla
     * @since Nov 20, 2017 11:26:54 PM
     */
    public void setCallbackPort(final int callbackPort) {
        this.callbackPort = callbackPort;
    }

    /**
     * @param ios the ios to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:02:13 PM
     */
    public void setIos(final IOSArgumentSetting ios) {
        this.ios = ios;
    }

    /**
     * @param localTimeZone the localTimeZone to set
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:37:02 PM
     */
    public void setLocalTimeZone(final boolean localTimeZone) {
        this.localTimeZone = localTimeZone;
    }

    /**
     * @param logLevel the logLevel to set
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:37:02 PM
     */
    public void setLogLevel(final LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * @param logTimeStamp the logTimeStamp to set
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:37:02 PM
     */
    public void setLogTimeStamp(final boolean logTimeStamp) {
        this.logTimeStamp = logTimeStamp;
    }

    /**
     * @param nodeConfigFile the nodeConfigFile to set
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:37:02 PM
     */
    public void setNodeConfigFile(final String nodeConfigFile) {
        this.nodeConfigFile = nodeConfigFile;
    }

    /**
     * @param sessionOverride the sessionOverride to set
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:37:02 PM
     */
    public void setSessionOverride(final boolean sessionOverride) {
        this.sessionOverride = sessionOverride;
    }
}