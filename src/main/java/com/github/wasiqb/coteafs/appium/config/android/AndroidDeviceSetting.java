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
package com.github.wasiqb.coteafs.appium.config.android;

/**
 * @author wasiq.bhamla
 * @since Jan 18, 2018 9:05:52 PM
 */
public class AndroidDeviceSetting {
	private int		adbPort;
	private long	apkInstallTimeout;
	private String	appActivity;
	private String	appPackage;
	private String	appWaitActivity;
	private String	appWaitPackage;
	private long	appWaitTimeout;
	private boolean	autoGrantPermissions;
	private String	avd;
	private long	avdLaunchTimeout;
	private long	avdReadyTimeout;
	private String	chromeDriverPath;
	private int		deviceReadyTimeout;
	private int		systemPort;

	/**
	 * @author wasiqb
	 * @since Oct 30, 2018
	 */
	public AndroidDeviceSetting () {
		this.avdLaunchTimeout = 60000;
		this.avdReadyTimeout = 60000;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the adbPort
	 */
	public int getAdbPort () {
		return this.adbPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the apkInstallTimeout
	 */
	public long getApkInstallTimeout () {
		return this.apkInstallTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the appActivity
	 */
	public String getAppActivity () {
		return this.appActivity;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the appPackage
	 */
	public String getAppPackage () {
		return this.appPackage;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the appWaitActivity
	 */
	public String getAppWaitActivity () {
		return this.appWaitActivity;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the appWaitPackage
	 */
	public String getAppWaitPackage () {
		return this.appWaitPackage;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the appWaitTimeout
	 */
	public long getAppWaitTimeout () {
		return this.appWaitTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the avd
	 */
	public String getAvd () {
		return this.avd;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the avdLaunchTimeout
	 */
	public long getAvdLaunchTimeout () {
		return this.avdLaunchTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the avdReadyTimeout
	 */
	public long getAvdReadyTimeout () {
		return this.avdReadyTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the chromeDriverPath
	 */
	public String getChromeDriverPath () {
		return this.chromeDriverPath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the deviceReadyTimeout
	 */
	public int getDeviceReadyTimeout () {
		return this.deviceReadyTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the systemPort
	 */
	public int getSystemPort () {
		return this.systemPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @return the autoGrantPermissions
	 */
	public boolean isAutoGrantPermissions () {
		return this.autoGrantPermissions;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param adbPort
	 *            the adbPort to set
	 */
	public void setAdbPort (final int adbPort) {
		this.adbPort = adbPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param apkInstallTimeout
	 *            the apkInstallTimeout to set
	 */
	public void setApkInstallTimeout (final long apkInstallTimeout) {
		this.apkInstallTimeout = apkInstallTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param appActivity
	 *            the appActivity to set
	 */
	public void setAppActivity (final String appActivity) {
		this.appActivity = appActivity;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param appPackage
	 *            the appPackage to set
	 */
	public void setAppPackage (final String appPackage) {
		this.appPackage = appPackage;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param appWaitActivity
	 *            the appWaitActivity to set
	 */
	public void setAppWaitActivity (final String appWaitActivity) {
		this.appWaitActivity = appWaitActivity;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param appWaitPackage
	 *            the appWaitPackage to set
	 */
	public void setAppWaitPackage (final String appWaitPackage) {
		this.appWaitPackage = appWaitPackage;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param appWaitTimeout
	 *            the appWaitTimeout to set
	 */
	public void setAppWaitTimeout (final long appWaitTimeout) {
		this.appWaitTimeout = appWaitTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param autoGrantPermissions
	 *            the autoGrantPermissions to set
	 */
	public void setAutoGrantPermissions (final boolean autoGrantPermissions) {
		this.autoGrantPermissions = autoGrantPermissions;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param avd
	 *            the avd to set
	 */
	public void setAvd (final String avd) {
		this.avd = avd;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param avdLaunchTimeout
	 *            the avdLaunchTimeout to set
	 */
	public void setAvdLaunchTimeout (final long avdLaunchTimeout) {
		this.avdLaunchTimeout = avdLaunchTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param avdReadyTimeout
	 *            the avdReadyTimeout to set
	 */
	public void setAvdReadyTimeout (final long avdReadyTimeout) {
		this.avdReadyTimeout = avdReadyTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param chromeDriverPath
	 *            the chromeDriverPath to set
	 */
	public void setChromeDriverPath (final String chromeDriverPath) {
		this.chromeDriverPath = chromeDriverPath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param deviceReadyTimeout
	 *            the deviceReadyTimeout to set
	 */
	public void setDeviceReadyTimeout (final int deviceReadyTimeout) {
		this.deviceReadyTimeout = deviceReadyTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:44:20 PM
	 * @param systemPort
	 *            the systemPort to set
	 */
	public void setSystemPort (final int systemPort) {
		this.systemPort = systemPort;
	}
}