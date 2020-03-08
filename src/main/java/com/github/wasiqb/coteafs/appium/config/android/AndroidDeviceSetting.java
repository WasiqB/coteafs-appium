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
package com.github.wasiqb.coteafs.appium.config.android;

/**
 * @author wasiq.bhamla
 * @since Jan 18, 2018 9:05:52 PM
 */
public class AndroidDeviceSetting {
    private int     adbPort;
    private long    apkInstallTimeout;
    private String  appActivity;
    private String  appPackage;
    private String  appWaitActivity;
    private String  appWaitPackage;
    private long    appWaitTimeout;
    private boolean autoGrantPermissions;
    private String  avd;
    private String  avdArgs;
    private long    avdLaunchTimeout;
    private long    avdReadyTimeout;
    private String  chromeDriverPath;
    private int     deviceReadyTimeout;
    private int     systemPort;

    /**
     * @author wasiqb
     * @since Oct 30, 2018
     */
    public AndroidDeviceSetting() {
        this.avdLaunchTimeout = 60000;
        this.avdReadyTimeout = 60000;
    }

    /**
     * @return the adbPort
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public int getAdbPort() {
        return this.adbPort;
    }

    /**
     * @return the apkInstallTimeout
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public long getApkInstallTimeout() {
        return this.apkInstallTimeout;
    }

    /**
     * @return the appActivity
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public String getAppActivity() {
        return this.appActivity;
    }

    /**
     * @return the appPackage
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public String getAppPackage() {
        return this.appPackage;
    }

    /**
     * @return the appWaitActivity
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public String getAppWaitActivity() {
        return this.appWaitActivity;
    }

    /**
     * @return the appWaitPackage
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public String getAppWaitPackage() {
        return this.appWaitPackage;
    }

    /**
     * @return the appWaitTimeout
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public long getAppWaitTimeout() {
        return this.appWaitTimeout;
    }

    /**
     * @return the avd
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public String getAvd() {
        return this.avd;
    }

    /**
     * @return the avdArgs
     * @author wasiqb
     * @since Nov 27, 2018
     */
    public String getAvdArgs() {
        return this.avdArgs;
    }

    /**
     * @return the avdLaunchTimeout
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public long getAvdLaunchTimeout() {
        return this.avdLaunchTimeout;
    }

    /**
     * @return the avdReadyTimeout
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public long getAvdReadyTimeout() {
        return this.avdReadyTimeout;
    }

    /**
     * @return the chromeDriverPath
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public String getChromeDriverPath() {
        return this.chromeDriverPath;
    }

    /**
     * @return the deviceReadyTimeout
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public int getDeviceReadyTimeout() {
        return this.deviceReadyTimeout;
    }

    /**
     * @return the systemPort
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public int getSystemPort() {
        return this.systemPort;
    }

    /**
     * @return the autoGrantPermissions
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public boolean isAutoGrantPermissions() {
        return this.autoGrantPermissions;
    }

    /**
     * @param adbPort the adbPort to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setAdbPort(final int adbPort) {
        this.adbPort = adbPort;
    }

    /**
     * @param apkInstallTimeout the apkInstallTimeout to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setApkInstallTimeout(final long apkInstallTimeout) {
        this.apkInstallTimeout = apkInstallTimeout;
    }

    /**
     * @param appActivity the appActivity to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setAppActivity(final String appActivity) {
        this.appActivity = appActivity;
    }

    /**
     * @param appPackage the appPackage to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setAppPackage(final String appPackage) {
        this.appPackage = appPackage;
    }

    /**
     * @param appWaitActivity the appWaitActivity to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setAppWaitActivity(final String appWaitActivity) {
        this.appWaitActivity = appWaitActivity;
    }

    /**
     * @param appWaitPackage the appWaitPackage to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setAppWaitPackage(final String appWaitPackage) {
        this.appWaitPackage = appWaitPackage;
    }

    /**
     * @param appWaitTimeout the appWaitTimeout to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setAppWaitTimeout(final long appWaitTimeout) {
        this.appWaitTimeout = appWaitTimeout;
    }

    /**
     * @param autoGrantPermissions the autoGrantPermissions to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setAutoGrantPermissions(final boolean autoGrantPermissions) {
        this.autoGrantPermissions = autoGrantPermissions;
    }

    /**
     * @param avd the avd to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setAvd(final String avd) {
        this.avd = avd;
    }

    /**
     * @param avdArgs the avdArgs to set
     * @author wasiqb
     * @since Nov 27, 2018
     */
    public void setAvdArgs(final String avdArgs) {
        this.avdArgs = avdArgs;
    }

    /**
     * @param avdLaunchTimeout the avdLaunchTimeout to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setAvdLaunchTimeout(final long avdLaunchTimeout) {
        this.avdLaunchTimeout = avdLaunchTimeout;
    }

    /**
     * @param avdReadyTimeout the avdReadyTimeout to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setAvdReadyTimeout(final long avdReadyTimeout) {
        this.avdReadyTimeout = avdReadyTimeout;
    }

    /**
     * @param chromeDriverPath the chromeDriverPath to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setChromeDriverPath(final String chromeDriverPath) {
        this.chromeDriverPath = chromeDriverPath;
    }

    /**
     * @param deviceReadyTimeout the deviceReadyTimeout to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setDeviceReadyTimeout(final int deviceReadyTimeout) {
        this.deviceReadyTimeout = deviceReadyTimeout;
    }

    /**
     * @param systemPort the systemPort to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:44:20 PM
     */
    public void setSystemPort(final int systemPort) {
        this.systemPort = systemPort;
    }
}