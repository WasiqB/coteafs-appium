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
package com.github.wasiqb.coteafs.appium.device;

import static com.github.wasiqb.coteafs.appium.config.enums.AutomationType.APPIUM;
import static com.github.wasiqb.coteafs.appium.config.enums.PlatformType.ANDROID;
import static com.github.wasiqb.coteafs.appium.constants.ErrorMessage.SERVER_STOPPED;
import static com.github.wasiqb.coteafs.appium.utils.CapabilityUtils.setCapability;
import static com.github.wasiqb.coteafs.appium.utils.ScreenRecorder.getVideoStreamArgs;
import static com.github.wasiqb.coteafs.appium.utils.ScreenRecorder.saveRecording;
import static com.github.wasiqb.coteafs.error.util.ErrorUtil.fail;
import static io.appium.java_client.Setting.IGNORE_UNIMPORTANT_VIEWS;
import static io.appium.java_client.Setting.NATIVE_WEB_TAP;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.ADB_EXEC_TIMEOUT;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.ADB_PORT;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_WAIT_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_WAIT_DURATION;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_WAIT_PACKAGE;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.AVD;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.AVD_ARGS;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.AVD_READY_TIMEOUT;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.CHROME_OPTIONS;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.DISABLE_WINDOW_ANIMATION;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.DONT_STOP_APP_ON_RESET;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.IS_HEADLESS;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.NATIVE_WEB_SCREENSHOT;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.NETWORK_SPEED;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.REMOTE_ADB_HOST;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.SKIP_DEVICE_INITIALIZATION;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.SKIP_UNLOCK;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.SYSTEM_PORT;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.UNLOCK_KEY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.UNLOCK_TYPE;
import static io.appium.java_client.remote.IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS;
import static io.appium.java_client.remote.IOSMobileCapabilityType.BUNDLE_ID;
import static io.appium.java_client.remote.IOSMobileCapabilityType.LAUNCH_TIMEOUT;
import static io.appium.java_client.remote.IOSMobileCapabilityType.SAFARI_ALLOW_POPUPS;
import static io.appium.java_client.remote.IOSMobileCapabilityType.SAFARI_INITIAL_URL;
import static io.appium.java_client.remote.IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID;
import static io.appium.java_client.remote.IOSMobileCapabilityType.USE_NEW_WDA;
import static io.appium.java_client.remote.IOSMobileCapabilityType.USE_PREBUILT_WDA;
import static io.appium.java_client.remote.IOSMobileCapabilityType.WDA_CONNECTION_TIMEOUT;
import static io.appium.java_client.remote.IOSMobileCapabilityType.WDA_LAUNCH_TIMEOUT;
import static io.appium.java_client.remote.IOSMobileCapabilityType.WDA_LOCAL_PORT;
import static io.appium.java_client.remote.IOSMobileCapabilityType.WDA_STARTUP_RETRIES;
import static io.appium.java_client.remote.IOSMobileCapabilityType.WDA_STARTUP_RETRY_INTERVAL;
import static io.appium.java_client.remote.IOSMobileCapabilityType.XCODE_ORG_ID;
import static io.appium.java_client.remote.IOSMobileCapabilityType.XCODE_SIGNING_ID;
import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.AUTO_WEBVIEW;
import static io.appium.java_client.remote.MobileCapabilityType.CLEAR_SYSTEM_FILES;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.FULL_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.LANGUAGE;
import static io.appium.java_client.remote.MobileCapabilityType.LOCALE;
import static io.appium.java_client.remote.MobileCapabilityType.NEW_COMMAND_TIMEOUT;
import static io.appium.java_client.remote.MobileCapabilityType.NO_RESET;
import static io.appium.java_client.remote.MobileCapabilityType.OTHER_APPS;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static java.lang.System.getProperty;
import static java.text.MessageFormat.format;
import static java.time.Duration.ofMinutes;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.openqa.selenium.remote.CapabilityType.ACCEPT_SSL_CERTS;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.github.wasiqb.coteafs.appium.checker.ServerChecker;
import com.github.wasiqb.coteafs.appium.config.AppiumSetting;
import com.github.wasiqb.coteafs.appium.config.device.DeviceSetting;
import com.github.wasiqb.coteafs.appium.config.device.OtherSetting;
import com.github.wasiqb.coteafs.appium.config.device.RecordSetting;
import com.github.wasiqb.coteafs.appium.config.device.VideoStreamSetting;
import com.github.wasiqb.coteafs.appium.config.device.android.AdbSetting;
import com.github.wasiqb.coteafs.appium.config.device.android.AndroidAppSetting;
import com.github.wasiqb.coteafs.appium.config.device.android.AndroidDeviceSetting;
import com.github.wasiqb.coteafs.appium.config.device.android.AndroidWebSetting;
import com.github.wasiqb.coteafs.appium.config.device.android.AvdSetting;
import com.github.wasiqb.coteafs.appium.config.device.android.WebOptions;
import com.github.wasiqb.coteafs.appium.config.device.ios.IOSAppSetting;
import com.github.wasiqb.coteafs.appium.config.device.ios.IOSDeviceSetting;
import com.github.wasiqb.coteafs.appium.config.device.ios.IOSWebSetting;
import com.github.wasiqb.coteafs.appium.config.device.ios.WDASetting;
import com.github.wasiqb.coteafs.appium.config.enums.ApplicationType;
import com.github.wasiqb.coteafs.appium.config.enums.DeviceType;
import com.github.wasiqb.coteafs.appium.config.enums.PlatformType;
import com.github.wasiqb.coteafs.appium.error.AppiumServerStoppedError;
import com.github.wasiqb.coteafs.appium.error.DeviceDriverDefaultWaitError;
import com.github.wasiqb.coteafs.appium.error.DeviceDriverInitializationFailedError;
import com.github.wasiqb.coteafs.appium.error.DeviceDriverNotStartingError;
import com.github.wasiqb.coteafs.appium.error.DeviceDriverNotStoppingError;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;
import com.github.wasiqb.coteafs.datasource.DataSource;
import com.github.wasiqb.coteafs.error.OperationNotSupportedError;
import com.google.common.reflect.TypeToken;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.NetworkSpeed;
import io.appium.java_client.screenrecording.BaseStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.BaseStopScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @param <D>
 * @param <T>
 *
 * @author wasiq.bhamla
 * @since 12-Apr-2017 9:38:38 PM
 */
public abstract class Device<D extends AppiumDriver<MobileElement>, T extends TouchAction<T>> {
    private static final Logger LOG = LogManager.getLogger ();

    protected       DesiredCapabilities capabilities;
    protected       D                   driver;
    protected final AppiumServer        server;
    protected final DeviceSetting       setting;
    private final   PlatformType        platform;

    /**
     * @param server Server instance
     * @param name Device name in Config
     *
     * @author wasiq.bhamla
     * @since 13-Apr-2017 9:10:11 PM
     */
    protected Device (final AppiumServer server, final String name) {
        this.server = server;
        this.setting = DataSource.parse (AppiumSetting.class)
            .getDevice (name);
        this.platform = this.setting.getOs ();
        buildCapabilities ();
    }

    /**
     * @author wasiq.bhamla
     * @since 27-Nov-2020
     */
    public void checkServerRunning () {
        ServerChecker.checkServerRunning (this.server);
    }

    /**
     * @param command Command to execute
     * @param args Command args
     *
     * @author wasiqb
     * @since 27-Nov-2020
     */
    public void executeCommand (final String command, final Map<String, Object> args) {
        this.driver.executeScript (command, args);
    }

    /**
     * @param command Command to execute
     *
     * @author Wasiq Bhamla
     * @since 11-Mar-2021
     */
    public void executeCommand (final String command) {
        this.driver.executeScript (command);
    }

    /**
     * @return driver
     *
     * @author wasiq.bhamla
     * @since 27-Nov-2020
     */
    public D getDriver () {
        LOG.trace ("Getting [{}] device driver...", this.platform);
        return this.driver;
    }

    /**
     * @return Appium server
     *
     * @since 29-11-2020
     */
    public AppiumServer getServer () {
        return this.server;
    }

    /**
     * @return the setting
     *
     * @author wasiq.bhamla
     * @since 27-Nov-2020
     */
    public DeviceSetting getSetting () {
        return this.setting;
    }

    /**
     * @author wasiq.bhamla
     * @since 27-Nov-2020
     */
    public void start () {
        startDriver ();
        setImplicitWait ();
        setSettings ();
    }

    /**
     * @author Wasiq Bhamla
     * @since 11-Mar-2021
     */
    public void startRecording () {
        startRecord ((CanRecordScreen) this.driver);
    }

    /**
     * @author Wasiq Bhamla
     * @since 11-Mar-2021
     */
    public void startStreaming () {
        final VideoStreamSetting streamSetting = this.setting.getPlayback ()
            .getStream ();
        if (streamSetting.isEnabled ()) {
            LOG.info ("Starting Video streaming...");
            final Map<String, Object> args = getVideoStreamArgs (streamSetting);
            executeCommand ("mobile: startScreenStreaming", args);
        }
    }

    /**
     * @author wasiq.bhamla
     * @since 27-Nov-2020
     */
    public void stop () {
        if (this.driver != null) {
            quitApp ();
            this.driver = null;
        } else {
            LOG.trace ("[{}] device driver already stopped...", this.platform);
        }
    }

    /**
     * @author Wasiq Bhamla
     * @since 11-Mar-2021
     */
    public void stopRecording () {
        stopRecord ((CanRecordScreen) this.driver);
    }

    /**
     * @author Wasiq Bhamla
     * @since 11-Mar-2021
     */
    public void stopStreaming () {
        if (this.setting.getPlayback ()
            .getStream ()
            .isEnabled ()) {
            LOG.info ("Stopping Video streaming...");
            executeCommand ("mobile: stopScreenStreaming");
        }
    }

    protected abstract <X extends BaseStartScreenRecordingOptions<X>> X startRecordSetting ();

    protected abstract <Y extends BaseStopScreenRecordingOptions<Y>> Y stopRecordSetting ();

    private void buildCapabilities () {
        LOG.trace ("Building Device capabilities...");
        this.capabilities = new DesiredCapabilities ();
        setLocalCapabilities ();
        setCloudCapabilities ();
        LOG.trace ("Building Device capabilities completed...");
    }

    private String getAppPath (final String path, final boolean isExternal) {
        if (isExternal) {
            return path;
        }
        final String appPath = "{0}/src/test/resources/{1}";
        return format (appPath, getProperty ("user.dir"), path);
    }

    @SuppressWarnings ("unchecked")
    private D init (final URL url, final Capabilities capability) {
        LOG.trace ("Initializing driver...");
        final TypeToken<D> token = new TypeToken<> (getClass ()) {
            private static final long serialVersionUID = 1562415938665085306L;
        };
        final Class<D> cls = (Class<D>) token.getRawType ();
        final Class<?>[] argTypes = new Class<?>[] { URL.class, Capabilities.class };
        try {
            final Constructor<D> ctor = cls.getDeclaredConstructor (argTypes);
            return ctor.newInstance (url, capability);
        } catch (final NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            fail (DeviceDriverInitializationFailedError.class, "Error occurred while initializing device driver.", e);
        }
        return null;
    }

    private void quitApp () {
        LOG.trace ("Closing & Quitting [{}] device driver...", this.platform);
        try {
            this.driver.closeApp ();
            this.driver.quit ();
        } catch (final NoSuchSessionException e) {
            fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
        } catch (final Exception e) {
            fail (DeviceDriverNotStoppingError.class, "Error occurred while stopping device driver.", e);
        }
    }

    private void setAdbSetting (final AdbSetting adb) {
        setCapability (ADB_PORT, adb.getPort (), 5037, this.capabilities);
        setCapability (REMOTE_ADB_HOST, adb.getHost (), EMPTY, this.capabilities);
        setCapability (ADB_EXEC_TIMEOUT, adb.getTimeout (), 20000, this.capabilities);
    }

    private void setAndroidAppSetting (final AndroidAppSetting app) {
        setCapability (APP, getAppPath (app.getPath (), app.isExternal ()), EMPTY, this.capabilities);
        setCapability (ANDROID_INSTALL_TIMEOUT, app.getInstallTimeout (), 90000, this.capabilities);
        setCapability (APP_ACTIVITY, app.getActivityName (), EMPTY, this.capabilities);
        setCapability (APP_PACKAGE, app.getPackageName (), EMPTY, this.capabilities);
        setCapability (APP_WAIT_ACTIVITY, app.getWaitActivity (), EMPTY, this.capabilities);
        setCapability (APP_WAIT_PACKAGE, app.getWaitPackage (), EMPTY, this.capabilities);
        setCapability (APP_WAIT_DURATION, app.getWaitTimeout (), 20000, this.capabilities);
        setCapability (AUTO_GRANT_PERMISSIONS, app.isGrantPermission (), false, this.capabilities);
        setCapability (DONT_STOP_APP_ON_RESET, app.isNoStopOnReset (), false, this.capabilities);
        setCapability (OTHER_APPS, app.getOtherApps (), null, this.capabilities);
    }

    private void setAndroidCapabilities (final AndroidDeviceSetting android) {
        if (android != null) {
            setCapability (LOCALE, this.setting.getLanguage ()
                .getLocale ()
                .getCountry (), EMPTY, this.capabilities);
            if (android.getUnlockType () != null) {
                setCapability (UNLOCK_KEY, android.getUnlockKey (), EMPTY, this.capabilities);
                setCapability (UNLOCK_TYPE, android.getUnlockType ()
                    .name ()
                    .toLowerCase (), EMPTY, this.capabilities);
            }
            setCapability (SKIP_UNLOCK, android.isSkipUnlock (), false, this.capabilities);
            setCapability (SYSTEM_PORT, android.getSystemPort (), 8200, this.capabilities);
            setCapability (DISABLE_WINDOW_ANIMATION, android.isDisableAnimation (), false, this.capabilities);
            setCapability (SKIP_DEVICE_INITIALIZATION, android.isSkipDeviceInit (), false, this.capabilities);

            if (this.setting.getType () == DeviceType.SIMULATOR) {
                setAvdSetting (android.getAvd ());
            }
            setAdbSetting (android.getAdb ());
            if (android.getApp ()
                .getType () != ApplicationType.WEB) {
                setAndroidAppSetting (android.getApp ());
            } else {
                setAndroidWebSetting (android.getWeb ());
            }
        }
    }

    private void setAndroidWebSetting (final AndroidWebSetting web) {
        setCapability (CHROMEDRIVER_EXECUTABLE, web.getChromeDriverPath (), EMPTY, this.capabilities);
        setCapability (ACCEPT_SSL_CERTS, web.isAcceptSslCerts (), true, this.capabilities);
        setCapability (NATIVE_WEB_SCREENSHOT, web.isNativeScreenshot (), false, this.capabilities);
        setCapability ("showChromedriverLog", web.isShowBrowserLogs (), false, this.capabilities);
        setChromeOptions (web.getOptions ());
    }

    private void setAvdSetting (final AvdSetting avd) {
        setCapability (NETWORK_SPEED, avd.getNetworkSpeed (), NetworkSpeed.FULL, this.capabilities);
        setCapability (AVD, avd.getName (), EMPTY, this.capabilities);
        setCapability (AVD_READY_TIMEOUT, avd.getReadyTimeout (), 120000, this.capabilities);
        setCapability (AVD_LAUNCH_TIMEOUT, avd.getLaunchTimeout (), 120000, this.capabilities);
        setCapability (AVD_ARGS, avd.getArgs (), EMPTY, this.capabilities);
    }

    private void setChromeOptions (final WebOptions options) {
        final ChromeOptions chromeOptions = new ChromeOptions ();
        chromeOptions.addArguments (options.getArgs ());
        chromeOptions.setExperimentalOption ("enableNetwork", options.getPerformancePreferences ()
            .isNetwork ());
        chromeOptions.setExperimentalOption ("enablePage", options.getPerformancePreferences ()
            .isPage ());
        setCapability (CHROME_OPTIONS, chromeOptions.asMap ()
            .toString (), EMPTY, this.capabilities);
    }

    private void setCloudCapabilities () {
        if (this.setting.isCloud ()) {
            this.setting.getCloudCapabilities ()
                .forEach ((key, value) -> setCapability (key, value, this.capabilities));
        }
    }

    private void setDeviceCapabilities () {
        setCapability (DEVICE_NAME, this.setting.getName (), EMPTY, this.capabilities, true);
        setCapability (PLATFORM_NAME, this.platform, ANDROID, this.capabilities, true);
        setCapability (PLATFORM_VERSION, this.setting.getVersion (), EMPTY, this.capabilities);
        setCapability (NEW_COMMAND_TIMEOUT, this.setting.getSessionTimeout (), 60, this.capabilities);
        setCapability (LANGUAGE, this.setting.getLanguage ()
            .getLocale ()
            .getLanguage (), null, this.capabilities);
        setCapability (AUTOMATION_NAME, this.setting.getAutomation (), APPIUM, this.capabilities);
        setCapability (BROWSER_NAME, this.setting.getBrowser (), null, this.capabilities);
        setCapability (IS_HEADLESS, this.setting.isHeadless (), false, this.capabilities);
        setCapability (AUTO_WEBVIEW, this.setting.isAutoWebView (), false, this.capabilities);
        setOtherCapabilities (this.setting.getOthers ());
    }

    private void setDeviceSpecificCapabilities () {
        switch (this.platform) {
            case IOS:
                setIOSCapabilities (this.setting.getIos ());
                break;
            case ANDROID:
                setAndroidCapabilities (this.setting.getAndroid ());
                break;
            case WINDOWS:
            default:
                break;
        }
    }

    private void setIOSCapabilities (final IOSDeviceSetting ios) {
        if (ios != null) {
            setCapability (LOCALE, this.setting.getLanguage ()
                .getLocale ()
                .toLanguageTag (), null, this.capabilities);
            setCapability (AUTO_ACCEPT_ALERTS, this.setting.getIos ()
                .isAutoAcceptAlerts (), false, this.capabilities);
            if (ios.getApp ()
                .getType () != ApplicationType.WEB) {
                setIosAppCapabilities (ios.getApp ());
            } else {
                setIosWebCapabilities (ios.getWeb ());
            }
            setIosWdaCapabilities (ios.getWda ());
        }
    }

    private void setImplicitWait () {
        try {
            this.driver.manage ()
                .timeouts ()
                .implicitlyWait (this.setting.getPlayback ()
                    .getDelay ()
                    .getImplicit (), TimeUnit.SECONDS);
        } catch (final NoSuchSessionException e) {
            fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
        } catch (final Exception e) {
            fail (DeviceDriverDefaultWaitError.class, "Error occurred while setting device driver default wait.", e);
        }
    }

    private void setIosAppCapabilities (final IOSAppSetting app) {
        setCapability (APP, getAppPath (app.getPath (), app.isExternal ()), EMPTY, this.capabilities);
        setCapability (BUNDLE_ID, app.getBundleId (), EMPTY, this.capabilities);
        setCapability (LAUNCH_TIMEOUT, app.getLaunchTimeout (), 20000, this.capabilities);
    }

    private void setIosWdaCapabilities (final WDASetting wda) {
        setCapability (XCODE_ORG_ID, wda.getTeamId (), EMPTY, this.capabilities);
        setCapability (XCODE_SIGNING_ID, wda.getSigningId (), EMPTY, this.capabilities);
        setCapability (WDA_CONNECTION_TIMEOUT, wda.getConnectionTimeout (), this.capabilities);
        setCapability ("bootstrapPath", wda.getBootstrapPath (), EMPTY, this.capabilities);
        setCapability ("agentPath", wda.getAgentPath (), EMPTY, this.capabilities);
        setCapability (UPDATE_WDA_BUNDLEID, wda.getUpdateBundleId (), EMPTY, this.capabilities);
        setCapability (USE_NEW_WDA, wda.isUseNew (), false, this.capabilities);
        setCapability (USE_PREBUILT_WDA, wda.isUsePrebuilt (), false, this.capabilities);
        setCapability (WDA_STARTUP_RETRIES, wda.getStartupRetries (), 2, this.capabilities);
        setCapability (WDA_STARTUP_RETRY_INTERVAL, wda.getStartupRetryInterval (), 10000, this.capabilities);
        setCapability (WDA_LOCAL_PORT, wda.getLocalPort (), 8100, this.capabilities);
        setCapability (WDA_LAUNCH_TIMEOUT, wda.getLaunchTimeout (), 60000, this.capabilities);
    }

    private void setIosWebCapabilities (final IOSWebSetting web) {
        setCapability (SAFARI_ALLOW_POPUPS, web.isAllowPopups (), false, this.capabilities);
        setCapability ("appium:showSafariConsoleLog", web.isConsoleLogs (), false, this.capabilities);
        setCapability ("appium:showSafariNetworkLog", web.isNetworkLogs (), false, this.capabilities);
        setCapability (SAFARI_INITIAL_URL, web.getInitialUrl (), EMPTY, this.capabilities);
    }

    private void setLocalCapabilities () {
        if (!this.setting.isCloud ()) {
            setDeviceCapabilities ();
            setDeviceSpecificCapabilities ();
        }
    }

    private void setOtherCapabilities (final OtherSetting others) {
        setCapability (CLEAR_SYSTEM_FILES, others.isClearFiles (), false, this.capabilities);
        setCapability (FULL_RESET, others.isFullReset (), false, this.capabilities);
        setCapability (NO_RESET, others.isNoReset (), false, this.capabilities);
    }

    private void setSettings () {
        LOG.trace ("Updating Appium settings...");
        switch (this.platform) {
            case ANDROID -> setSettings (IGNORE_UNIMPORTANT_VIEWS.toString (), this.setting.getAndroid ()
                .getApp ()
                .isIgnoreUnimportantViews ());
            case IOS -> {
                if (this.setting.getIos () != null) {
                    setSettings (NATIVE_WEB_TAP.toString (), this.setting.getIos ()
                        .getWeb ()
                        .isNativeTaps ());
                }
            }
            default -> fail (OperationNotSupportedError.class,
                format ("Appium setting is not supported for {0} platform.", this.platform));
        }
    }

    private void setSettings (final String name, final Object value) {
        LOG.trace ("{}: {}", name, value);
        this.driver.setSetting (name, value);
    }

    private void startDriver () {
        LOG.trace ("Starting [{}] device driver...", this.platform);
        try {
            this.driver = init (this.server.getServiceUrl (), this.capabilities);
        } catch (final Exception e) {
            fail (DeviceDriverNotStartingError.class, "Error occurred starting device driver", e);
        }
    }

    private <X extends BaseStartScreenRecordingOptions<X>> void startRecord (final CanRecordScreen screen) {
        final RecordSetting record = this.setting.getPlayback ()
            .getRecording ();
        if (record.isEnabled ()) {
            LOG.info ("Starting video recording...");
            final X option = startRecordSetting ();
            option.withTimeLimit (ofMinutes (record.getTimeLimit ()));
            screen.startRecordingScreen (option);
        }
    }

    private <X extends BaseStopScreenRecordingOptions<X>> void stopRecord (final CanRecordScreen screen) {
        final RecordSetting record = this.setting.getPlayback ()
            .getRecording ();
        if (record.isEnabled ()) {
            LOG.info ("Stopping video recording...");
            final String content = screen.<X>stopRecordingScreen (stopRecordSetting ());
            saveRecording (content, record);
        }
    }
}