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

import java.util.Map;

import com.github.wasiqb.coteafs.appium.config.android.AndroidDeviceSetting;
import com.github.wasiqb.coteafs.appium.config.enums.ApplicationType;
import com.github.wasiqb.coteafs.appium.config.enums.AutomationType;
import com.github.wasiqb.coteafs.appium.config.enums.Browser;
import com.github.wasiqb.coteafs.appium.config.enums.DeviceType;
import com.github.wasiqb.coteafs.appium.config.enums.PlatformType;
import com.github.wasiqb.coteafs.appium.config.ios.IOSDeviceSetting;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:34:28 PM
 */
public class DeviceSetting {
    private AndroidDeviceSetting android;
    private String               appLocation;
    private ApplicationType      appType;
    private AutomationType       automationName;
    private Browser              browser;
    private Map<String, String>  capabilities;
    private boolean              clearSystemFiles;
    private boolean              cloudApp;
    private String               deviceName;
    private DeviceType           deviceType;
    private String               deviceVersion;
    private boolean              eventTimings;
    private boolean              externalApp;
    private boolean              fullReset;
    private IOSDeviceSetting     ios;
    private long                 keyTypingDelay;
    private boolean              noReset;
    private PlatformType         platformType;
    private PlaybackSetting      playback;
    private int                  sessionTimeout;
    private String               udid;

    /**
     * @author wasiq.bhamla
     * @since 24-Apr-2017 9:21:26 PM
     */
    public DeviceSetting () {
        this.automationName = AutomationType.APPIUM;
        this.platformType = PlatformType.ANDROID;
        this.appType = ApplicationType.NATIVE;
        this.deviceType = DeviceType.REAL;
        this.noReset = false;
        this.fullReset = false;
        this.externalApp = false;
        this.clearSystemFiles = false;
        this.sessionTimeout = 120;
        this.cloudApp = false;
        this.playback = new PlaybackSetting ();
    }

    /**
     * @return the android
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:45:15 PM
     */
    public AndroidDeviceSetting getAndroid () {
        return this.android;
    }

    /**
     * @return the appLocation
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:42:48 PM
     */
    public String getAppLocation () {
        return replaceSystemProperty (this.appLocation);
    }

    /**
     * @return the appType
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:42:49 PM
     */
    public ApplicationType getAppType () {
        return this.appType;
    }

    /**
     * @return the automationName
     * @author wasiq.bhamla
     * @since 24-Apr-2017 9:15:54 PM
     */
    public AutomationType getAutomationName () {
        return this.automationName;
    }

    /**
     * @return the browser
     * @author wasiq.bhamla
     * @since Jul 15, 2017 5:05:42 PM
     */
    public Browser getBrowser () {
        return this.browser;
    }

    /**
     * @return capabilities
     * @since 01-Oct-2020
     */
    public Map<String, String> getCapabilities () {
        return this.capabilities;
    }

    /**
     * @return the deviceName
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:42:49 PM
     */
    public String getDeviceName () {
        return this.deviceName;
    }

    /**
     * @return the deviceType
     * @author wasiq.bhamla
     * @since Aug 1, 2017 3:57:48 PM
     */
    public DeviceType getDeviceType () {
        return this.deviceType;
    }

    /**
     * @return the deviceVersion
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:42:49 PM
     */
    public String getDeviceVersion () {
        return this.deviceVersion;
    }

    /**
     * @return the ios
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:45:15 PM
     */
    public IOSDeviceSetting getIos () {
        return this.ios;
    }

    /**
     * @return the keyTypingDelay
     * @author wasiq.bhamla
     * @since Nov 19, 2017 9:54:14 PM
     */
    public long getKeyTypingDelay () {
        return this.keyTypingDelay;
    }

    /**
     * @return the deviceType
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:42:49 PM
     */
    public PlatformType getPlatformType () {
        return this.platformType;
    }

    /**
     * @return the playback
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:45:15 PM
     */
    public PlaybackSetting getPlayback () {
        return this.playback;
    }

    /**
     * @return the sessionTimeout
     * @author wasiq.bhamla
     * @since 08-May-2017 7:59:42 PM
     */
    public int getSessionTimeout () {
        return this.sessionTimeout;
    }

    /**
     * @return the udid
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:42:49 PM
     */
    public String getUdid () {
        return this.udid;
    }

    /**
     * @return the clearSystemFiles
     * @author wasiq.bhamla
     * @since 23-May-2017 4:45:23 PM
     */
    public boolean isClearSystemFiles () {
        return this.clearSystemFiles;
    }

    /**
     * @return the cloudApp
     * @author wasiqb
     * @since Sep 29, 2018
     */
    public boolean isCloudApp () {
        return this.cloudApp;
    }

    /**
     * @return the eventTimings
     * @author wasiq.bhamla
     * @since Nov 19, 2017 9:54:14 PM
     */
    public boolean isEventTimings () {
        return this.eventTimings;
    }

    /**
     * @return the externalApp
     * @author wasiq.bhamla
     * @since 30-Apr-2017 8:00:43 PM
     */
    public boolean isExternalApp () {
        return this.externalApp;
    }

    /**
     * @return the fullReset
     * @author wasiq.bhamla
     * @since 08-May-2017 3:16:16 PM
     */
    public boolean isFullReset () {
        return this.fullReset;
    }

    /**
     * @return the noReset
     * @author wasiq.bhamla
     * @since 08-May-2017 3:16:16 PM
     */
    public boolean isNoReset () {
        return this.noReset;
    }

    /**
     * @param android the android to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:45:15 PM
     */
    public void setAndroid (final AndroidDeviceSetting android) {
        this.android = android;
    }

    /**
     * @param appLocation the appLocation to set
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:42:49 PM
     */
    public void setAppLocation (final String appLocation) {
        this.appLocation = appLocation;
    }

    /**
     * @param appType the appType to set
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:42:49 PM
     */
    public void setAppType (final ApplicationType appType) {
        this.appType = appType;
    }

    /**
     * @param automationName the automationName to set
     * @author wasiq.bhamla
     * @since 24-Apr-2017 9:15:54 PM
     */
    public void setAutomationName (final AutomationType automationName) {
        this.automationName = automationName;
    }

    /**
     * @param browser the browser to set
     * @author wasiq.bhamla
     * @since Jul 15, 2017 5:05:42 PM
     */
    public void setBrowser (final Browser browser) {
        this.browser = browser;
    }

    /**
     * @param capabilities
     * @since 01-Oct-2020
     */
    public void setCapabilities (final Map<String, String> capabilities) {
        this.capabilities = capabilities;
    }

    /**
     * @param clearSystemFiles the clearSystemFiles to set
     * @author wasiq.bhamla
     * @since 23-May-2017 4:45:23 PM
     */
    public void setClearSystemFiles (final boolean clearSystemFiles) {
        this.clearSystemFiles = clearSystemFiles;
    }

    /**
     * @param cloudApp the cloudApp to set
     * @author wasiqb
     * @since Sep 29, 2018
     */
    public void setCloudApp (final boolean cloudApp) {
        this.cloudApp = cloudApp;
    }

    /**
     * @param deviceName the deviceName to set
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:42:49 PM
     */
    public void setDeviceName (final String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * @param deviceType the deviceType to set
     * @author wasiq.bhamla
     * @since Aug 1, 2017 3:57:48 PM
     */
    public void setDeviceType (final DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * @param deviceVersion the deviceVersion to set
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:42:49 PM
     */
    public void setDeviceVersion (final String deviceVersion) {
        this.deviceVersion = deviceVersion;
    }

    /**
     * @param eventTimings the eventTimings to set
     * @author wasiq.bhamla
     * @since Nov 19, 2017 9:54:14 PM
     */
    public void setEventTimings (final boolean eventTimings) {
        this.eventTimings = eventTimings;
    }

    /**
     * @param externalApp the externalApp to set
     * @author wasiq.bhamla
     * @since 30-Apr-2017 8:00:43 PM
     */
    public void setExternalApp (final boolean externalApp) {
        this.externalApp = externalApp;
    }

    /**
     * @param fullReset the fullReset to set
     * @author wasiq.bhamla
     * @since 08-May-2017 3:16:16 PM
     */
    public void setFullReset (final boolean fullReset) {
        this.fullReset = fullReset;
    }

    /**
     * @param ios the ios to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:45:15 PM
     */
    public void setIos (final IOSDeviceSetting ios) {
        this.ios = ios;
    }

    /**
     * @param keyTypingDelay the keyTypingDelay to set
     * @author wasiq.bhamla
     * @since Nov 19, 2017 9:54:14 PM
     */
    public void setKeyTypingDelay (final long keyTypingDelay) {
        this.keyTypingDelay = keyTypingDelay;
    }

    /**
     * @param noReset the noReset to set
     * @author wasiq.bhamla
     * @since 08-May-2017 3:16:16 PM
     */
    public void setNoReset (final boolean noReset) {
        this.noReset = noReset;
    }

    /**
     * @param deviceType the deviceType to set
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:42:49 PM
     */
    public void setPlatformType (final PlatformType deviceType) {
        this.platformType = deviceType;
    }

    /**
     * @param playback the playback to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:45:15 PM
     */
    public void setPlayback (final PlaybackSetting playback) {
        this.playback = playback;
    }

    /**
     * @param sessionTimeout the sessionTimeout to set
     * @author wasiq.bhamla
     * @since 08-May-2017 7:59:42 PM
     */
    public void setSessionTimeout (final int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    /**
     * @param udid the udid to set
     * @author wasiq.bhamla
     * @since 12-Apr-2017 8:42:49 PM
     */
    public void setUdid (final String udid) {
        this.udid = udid;
    }
}