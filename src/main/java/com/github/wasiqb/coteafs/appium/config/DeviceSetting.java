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

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:34:28 PM
 */
public class DeviceSetting {
	private AndroidDeviceSetting	android;
	private String					appLocation;
	private ApplicationType			appType;
	private AutomationName			automationName;
	private Browser					browser;
	private boolean					clearSystemFiles;
	private String					deviceName;
	private DeviceType				deviceType;
	private String					deviceVersion;
	private boolean					eventTimings;
	private boolean					externalApp;
	private boolean					fullReset;
	private IOSDeviceSetting		ios;
	private long					keyTypingDelay;
	private boolean					noReset;
	private PlatformType			platformType;
	private PlaybackSetting			playback;
	private int						sessionTimeout;
	private String					udid;

	/**
	 * @author wasiq.bhamla
	 * @since 24-Apr-2017 9:21:26 PM
	 */
	public DeviceSetting () {
		this.automationName = AutomationName.APPIUM;
		this.platformType = PlatformType.ANDROID;
		this.appType = ApplicationType.NATIVE;
		this.deviceType = DeviceType.REAL;
		this.noReset = false;
		this.fullReset = false;
		this.externalApp = false;
		this.clearSystemFiles = false;
		this.sessionTimeout = 120;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:45:15 PM
	 * @return the android
	 */
	public AndroidDeviceSetting getAndroid () {
		return this.android;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:48 PM
	 * @return the appLocation
	 */
	public String getAppLocation () {
		return this.appLocation;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @return the appType
	 */
	public ApplicationType getAppType () {
		return this.appType;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 24-Apr-2017 9:15:54 PM
	 * @return the automationName
	 */
	public AutomationName getAutomationName () {
		return this.automationName;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jul 15, 2017 5:05:42 PM
	 * @return the browser
	 */
	public Browser getBrowser () {
		return this.browser;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @return the deviceName
	 */
	public String getDeviceName () {
		return this.deviceName;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Aug 1, 2017 3:57:48 PM
	 * @return the deviceType
	 */
	public DeviceType getDeviceType () {
		return this.deviceType;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @return the deviceVersion
	 */
	public String getDeviceVersion () {
		return this.deviceVersion;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:45:15 PM
	 * @return the ios
	 */
	public IOSDeviceSetting getIos () {
		return this.ios;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Nov 19, 2017 9:54:14 PM
	 * @return the keyTypingDelay
	 */
	public long getKeyTypingDelay () {
		return this.keyTypingDelay;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @return the deviceType
	 */
	public PlatformType getPlatformType () {
		return this.platformType;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:45:15 PM
	 * @return the playback
	 */
	public PlaybackSetting getPlayback () {
		return this.playback;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:59:42 PM
	 * @return the sessionTimeout
	 */
	public int getSessionTimeout () {
		return this.sessionTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @return the udid
	 */
	public String getUdid () {
		return this.udid;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 23-May-2017 4:45:23 PM
	 * @return the clearSystemFiles
	 */
	public boolean isClearSystemFiles () {
		return this.clearSystemFiles;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Nov 19, 2017 9:54:14 PM
	 * @return the eventTimings
	 */
	public boolean isEventTimings () {
		return this.eventTimings;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 30-Apr-2017 8:00:43 PM
	 * @return the externalApp
	 */
	public boolean isExternalApp () {
		return this.externalApp;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 3:16:16 PM
	 * @return the fullReset
	 */
	public boolean isFullReset () {
		return this.fullReset;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 3:16:16 PM
	 * @return the noReset
	 */
	public boolean isNoReset () {
		return this.noReset;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:45:15 PM
	 * @param android
	 *            the android to set
	 */
	public void setAndroid (final AndroidDeviceSetting android) {
		this.android = android;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param appLocation
	 *            the appLocation to set
	 */
	public void setAppLocation (final String appLocation) {
		this.appLocation = appLocation;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param appType
	 *            the appType to set
	 */
	public void setAppType (final ApplicationType appType) {
		this.appType = appType;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 24-Apr-2017 9:15:54 PM
	 * @param automationName
	 *            the automationName to set
	 */
	public void setAutomationName (final AutomationName automationName) {
		this.automationName = automationName;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jul 15, 2017 5:05:42 PM
	 * @param browser
	 *            the browser to set
	 */
	public void setBrowser (final Browser browser) {
		this.browser = browser;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 23-May-2017 4:45:23 PM
	 * @param clearSystemFiles
	 *            the clearSystemFiles to set
	 */
	public void setClearSystemFiles (final boolean clearSystemFiles) {
		this.clearSystemFiles = clearSystemFiles;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param deviceName
	 *            the deviceName to set
	 */
	public void setDeviceName (final String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Aug 1, 2017 3:57:48 PM
	 * @param deviceType
	 *            the deviceType to set
	 */
	public void setDeviceType (final DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param deviceVersion
	 *            the deviceVersion to set
	 */
	public void setDeviceVersion (final String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Nov 19, 2017 9:54:14 PM
	 * @param eventTimings
	 *            the eventTimings to set
	 */
	public void setEventTimings (final boolean eventTimings) {
		this.eventTimings = eventTimings;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 30-Apr-2017 8:00:43 PM
	 * @param externalApp
	 *            the externalApp to set
	 */
	public void setExternalApp (final boolean externalApp) {
		this.externalApp = externalApp;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 3:16:16 PM
	 * @param fullReset
	 *            the fullReset to set
	 */
	public void setFullReset (final boolean fullReset) {
		this.fullReset = fullReset;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:45:15 PM
	 * @param ios
	 *            the ios to set
	 */
	public void setIos (final IOSDeviceSetting ios) {
		this.ios = ios;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Nov 19, 2017 9:54:14 PM
	 * @param keyTypingDelay
	 *            the keyTypingDelay to set
	 */
	public void setKeyTypingDelay (final long keyTypingDelay) {
		this.keyTypingDelay = keyTypingDelay;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 3:16:16 PM
	 * @param noReset
	 *            the noReset to set
	 */
	public void setNoReset (final boolean noReset) {
		this.noReset = noReset;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param deviceType
	 *            the deviceType to set
	 */
	public void setPlatformType (final PlatformType deviceType) {
		this.platformType = deviceType;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:45:15 PM
	 * @param playback
	 *            the playback to set
	 */
	public void setPlayback (final PlaybackSetting playback) {
		this.playback = playback;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:59:42 PM
	 * @param sessionTimeout
	 *            the sessionTimeout to set
	 */
	public void setSessionTimeout (final int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param udid
	 *            the udid to set
	 */
	public void setUdid (final String udid) {
		this.udid = udid;
	}
}