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
package com.github.wasiqb.coteafs.appium.service;

import static com.github.wasiqb.coteafs.appium.checker.ServerChecker.checkServerConfigParams;
import static com.github.wasiqb.coteafs.appium.utils.CapabilityUtils.setCapability;
import static com.github.wasiqb.coteafs.appium.utils.ErrorUtils.fail;
import static io.appium.java_client.service.local.flags.AndroidServerFlag.BOOTSTRAP_PORT_NUMBER;
import static io.appium.java_client.service.local.flags.AndroidServerFlag.CHROME_DRIVER_EXECUTABLE;
import static io.appium.java_client.service.local.flags.AndroidServerFlag.CHROME_DRIVER_PORT;
import static io.appium.java_client.service.local.flags.AndroidServerFlag.SUPPRESS_ADB_KILL_SERVER;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.CALLBACK_ADDRESS;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.CALLBACK_PORT;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.CONFIGURATION_FILE;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.LOCAL_TIMEZONE;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.LOG_LEVEL;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.LOG_TIMESTAMP;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.SESSION_OVERRIDE;
import static io.appium.java_client.service.local.flags.IOSServerFlag.BACK_END_RETRIES;
import static io.appium.java_client.service.local.flags.IOSServerFlag.IPA_ABSOLUTE_PATH;
import static io.appium.java_client.service.local.flags.IOSServerFlag.SAFARI;
import static io.appium.java_client.service.local.flags.IOSServerFlag.WEBKIT_DEBUG_PROXY_PORT;
import static org.apache.commons.lang3.StringUtils.isNoneEmpty;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

import com.github.wasiqb.coteafs.appium.config.AppiumSetting;
import com.github.wasiqb.coteafs.appium.config.ServerArgumentSetting;
import com.github.wasiqb.coteafs.appium.config.ServerSetting;
import com.github.wasiqb.coteafs.appium.config.android.AndroidArgumentSetting;
import com.github.wasiqb.coteafs.appium.config.ios.IOSArgumentSetting;
import com.github.wasiqb.coteafs.appium.error.AppiumServerAlreadyRunningError;
import com.github.wasiqb.coteafs.appium.error.AppiumServerLogFileError;
import com.github.wasiqb.coteafs.appium.error.AppiumServerNotRunningError;
import com.github.wasiqb.coteafs.appium.error.AppiumServerNotStartingError;
import com.github.wasiqb.coteafs.appium.error.AppiumServerNotStoppingError;
import com.github.wasiqb.coteafs.datasource.DataSource;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.ServerArgument;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 5:17:22 PM
 */
public final class AppiumServer {
    private static final Logger log = LogManager.getLogger (AppiumServer.class);

    private       AppiumServiceBuilder     builder;
    private       DesiredCapabilities      capabilities;
    private       AppiumDriverLocalService service;
    private final ServerSetting            setting;

    /**
     * @param name
     *
     * @author wasiq.bhamla
     * @since 13-Apr-2017 7:33:24 PM
     */
    public AppiumServer (final String name) {
        this.setting = DataSource.parse (AppiumSetting.class)
            .getServer (name);
        if (!this.setting.isExternal () && !this.setting.isCloud ()) {
            initService ();
            buildCapabilities ();
            buildService ();
        }
    }

    /**
     * @return url
     *
     * @author wasiq.bhamla
     * @since 13-Apr-2017 3:28:14 PM
     */
    public URL getServiceUrl () {
        log.trace ("Fetching Appium Service URL...");
        if (!this.setting.isExternal () && !this.setting.isCloud ()) {
            return this.service.getUrl ();
        }
        final String url = String.format ("%s/wd/hub", getUrl ());
        try {
            return new URL (url);
        } catch (final MalformedURLException e) {
            log.error ("Error occurred while getting service url...");
            log.catching (e);
        }
        return null;
    }

    /**
     * @return isRunning
     *
     * @author wasiq.bhamla
     * @since 13-Apr-2017 5:30:12 PM
     */
    public boolean isRunning () {
        if (this.setting.isCloud ()) {
            return true;
        }
        if (!this.setting.isExternal ()) {
            log.trace ("Checking if Appium Service is running...");
            return this.service.isRunning ();
        }
        final SocketAddress addr = new InetSocketAddress (this.setting.getHost (), this.setting.getPort ());
        try (final Socket socket = new Socket ()) {
            socket.connect (addr, 2000);
        } catch (final IOException e) {
            fail (AppiumServerNotRunningError.class, "Error connecting to Server...", e);
        }
        return true;
    }

    /**
     * @author wasiq.bhamla
     * @since 12-Apr-2017 5:23:19 PM
     */
    public void start () {
        log.trace ("Starting Appium Service...");
        if (!this.setting.isExternal () && !this.setting.isCloud ()) {
            boolean failure = false;
            this.service = AppiumDriverLocalService.buildService (this.builder);
            try {
                this.service.start ();
            } catch (final AppiumServerHasNotBeenStartedLocallyException e) {
                failure = true;
                fail (AppiumServerNotStartingError.class, "Error occured while starting Appium server", e);
            } catch (final Exception e) {
                failure = true;
                fail (AppiumServerAlreadyRunningError.class, "Appium server is running already.", e);
            } finally {
                if (failure) {
                    stop ();
                }
            }
            log.trace ("Appium Service Started...");
        } else {
            if (isRunning ()) {
                log.trace ("Appium Service is already running...");
            }
        }
    }

    /**
     * @author wasiq.bhamla
     * @since 12-Apr-2017 5:23:39 PM
     */
    public void stop () {
        log.trace ("Trying to stop Appium Service...");
        if (!this.setting.isExternal () && !this.setting.isCloud ()) {
            try {
                this.service.stop ();
            } catch (final Exception e) {
                fail (AppiumServerNotStoppingError.class, "Error occured while stopping the server.", e);
            }
            this.service = null;
            log.trace ("Appium Service Stopped...");
        } else {
            log.trace ("Appium Service can only be stopped from the tool you started with...");
        }
    }

    /**
     * @author wasiq.bhamla
     * @since 12-Apr-2017 9:29:17 PM
     */
    private void buildCapabilities () {
        log.trace ("Building Appium Capabilities started...");
        setCapability (MobileCapabilityType.NO_RESET, Boolean.toString (this.setting.isNoReset ()), this.capabilities);
        setCapability (MobileCapabilityType.FULL_RESET, Boolean.toString (this.setting.isFullReset ()),
            this.capabilities);
        setCapability (MobileCapabilityType.NEW_COMMAND_TIMEOUT, Integer.toString (this.setting.getSessionTimeout ()),
            this.capabilities);
        log.trace ("Building Appium Capabilities completed...");
    }

    private void buildService () {
        log.trace ("Building Appium Service started...");
        checkServerConfigParams ("IP Host Address", this.setting.getHost ());
        this.builder.withIPAddress (this.setting.getHost ())
            .withStartUpTimeOut (this.setting.getStartUpTimeOutSeconds (), TimeUnit.SECONDS);
        setPort ();
        setLogFile ();
        setAppiumJS ();
        setNodeExe ();
        setCapabilities ();
        setArguments ();
        setEnvironmentVariables ();
        log.trace ("Building Appium Service done...");
    }

    private String getUrl () {
        final StringBuilder sb = new StringBuilder (this.setting.getProtocol ()
            .getName ()).append ("://");
        if (this.setting.isCloud ()) {
            checkServerConfigParams ("User Name", this.setting.getUserName ());
            checkServerConfigParams ("Password", this.setting.getPassword ());
            sb.append (this.setting.getUserName ())
                .append (":")
                .append (this.setting.getPassword ())
                .append ("@")
                .append (this.setting.getHost ());
        } else {
            sb.append (this.setting.getHost ());
        }
        if (this.setting.getPort () > 0) {
            sb.append (":")
                .append (this.setting.getPort ());
        }
        return sb.toString ();
    }

    private void initService () {
        log.trace ("Initializing Appium Service started...");
        this.builder = new AppiumServiceBuilder ();
        this.capabilities = new DesiredCapabilities ();
        log.trace ("Initializing Appium Service done...");
    }

    /**
     * @author wasiq.bhamla
     * @since Oct 27, 2017 12:39:17 PM
     */
    private void setAppiumJS () {
        if (this.setting.getAppiumJsPath () != null) {
            final File appJs = new File (this.setting.getAppiumJsPath ());
            this.builder.withAppiumJS (appJs);
        }
    }

    private void setArgument (final ServerArgument flag, final boolean value) {
        if (value) {
            this.builder.withArgument (flag);
        }
    }

    private void setArgument (final ServerArgument flag, final int value) {
        if (value > 0) {
            this.builder.withArgument (flag, Integer.toString (value));
        }
    }

    /**
     * @param flag
     * @param value
     *
     * @author wasiq.bhamla
     * @since Oct 27, 2017 3:15:05 PM
     */
    private void setArgument (final ServerArgument flag, final String value) {
        if (isNoneEmpty (value)) {
            this.builder.withArgument (flag, value);
        }
    }

    /**
     * @author wasiq.bhamla
     * @since Oct 27, 2017 12:43:53 PM
     */
    private void setArguments () {
        final ServerArgumentSetting args = this.setting.getArguments ();
        final IOSArgumentSetting ios = args.getIos ();
        final AndroidArgumentSetting android = args.getAndroid ();

        if (ios != null) {
            setArgument (BACK_END_RETRIES, ios.getBackendRetries ());
            setArgument (IPA_ABSOLUTE_PATH, ios.getIpaAbsolutePath ());
            setArgument (SAFARI, ios.isSafari ());
            setArgument (WEBKIT_DEBUG_PROXY_PORT, ios.getWebkitDebugProxyPort ());
        }
        if (android != null) {
            setArgument (BOOTSTRAP_PORT_NUMBER, android.getBootstrapPort ());
            setArgument (CHROME_DRIVER_PORT, android.getChromeDriverPort ());
            setArgument (CHROME_DRIVER_EXECUTABLE, android.getChromeDriverExePath ());
            setArgument (SUPPRESS_ADB_KILL_SERVER, android.isSuppressAdbKillServer ());
        }
        setArgument (LOG_LEVEL, args.getLogLevel ()
            .toString ());
        setArgument (SESSION_OVERRIDE, args.isSessionOverride ());
        setArgument (LOG_TIMESTAMP, args.isLogTimeStamp ());
        setArgument (LOCAL_TIMEZONE, args.isLocalTimeZone ());
        setArgument (CONFIGURATION_FILE, args.getNodeConfigFile ());
        setArgument (CALLBACK_ADDRESS, args.getCallbackIp ());
        setArgument (CALLBACK_PORT, args.getCallbackPort ());
    }

    /**
     * @author wasiq.bhamla
     * @since Oct 27, 2017 12:40:55 PM
     */
    private void setCapabilities () {
        this.builder.withCapabilities (this.capabilities);
    }

    /**
     * @author wasiq.bhamla
     * @since Oct 27, 2017 1:10:26 PM
     */
    private void setEnvironmentVariables () {
        this.builder = this.builder.withEnvironment (this.setting.getEnvironmentVariables ());
    }

    /**
     * @author wasiq.bhamla
     * @since Oct 27, 2017 3:00:49 PM
     */
    private void setLogFile () {
        final String logFilePath = this.setting.getLogFilePath ();
        if (logFilePath != null) {
            final File logFile = new File (logFilePath);
            try {
                if (logFile.exists ()) {
                    Files.delete (logFile.toPath ());
                }
            } catch (final IOException e) {
                fail (AppiumServerLogFileError.class, "Error while deleting log file!", e);
            }
            this.builder = this.builder.withLogFile (logFile);
        }
    }

    private void setNodeExe () {
        if (this.setting.getNodePath () != null) {
            final File nde = new File (this.setting.getNodePath ());
            this.builder = this.builder.usingDriverExecutable (nde);
        }
    }

    /**
     * @author wasiq.bhamla
     * @since Oct 27, 2017 12:42:30 PM
     */
    private void setPort () {
        if (this.setting.getPort () > 0) {
            this.builder = this.builder.usingPort (this.setting.getPort ());
        } else {
            this.builder = this.builder.usingAnyFreePort ();
        }
    }
}