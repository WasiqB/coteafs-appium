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

import static com.github.wasiqb.coteafs.appium.constants.ErrorMessage.SERVER_STOPPED;
import static com.github.wasiqb.coteafs.appium.utils.ErrorUtils.fail;
import static java.text.MessageFormat.format;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.github.wasiqb.coteafs.appium.config.device.PlaybackSetting;
import com.github.wasiqb.coteafs.appium.config.device.ScreenshotSetting;
import com.github.wasiqb.coteafs.appium.config.enums.SwipeDirection;
import com.github.wasiqb.coteafs.appium.config.enums.SwipeStartPosition;
import com.github.wasiqb.coteafs.appium.error.AppiumServerStoppedError;
import com.github.wasiqb.coteafs.appium.utils.SwipeUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @param <D>
 * @param <E>
 * @param <T>
 *
 * @author wasiq.bhamla
 * @since 26-Apr-2017 8:39:17 PM
 */
public class DeviceActions<D extends AppiumDriver<MobileElement>, E extends Device<D, T>, T extends TouchAction<T>> {
    private static final Logger LOG = LogManager.getLogger ();

    /**
     * @param source File copy source
     * @param destination File copy destination
     *
     * @author wasiq.bhamla
     * @since Jul 22, 2017 11:03:48 PM
     */
    private static void copyFile (final File source, final String destination) {
        try {
            FileUtils.copyFile (source, new File (destination));
        } catch (final IOException e) {
            LOG.error ("Error occurred while capturing screenshot...");
            LOG.catching (e);
        }
    }

    protected final E               device;
    protected final D               driver;
    protected final WebDriverWait   wait;
    private final   T               actions;
    private final   PlaybackSetting setting;

    /**
     * @param device Device instance
     * @param actions Touch actions instance
     *
     * @author wasiq.bhamla
     * @since 26-Apr-2017 8:39:17 PM
     */
    public DeviceActions (final E device, final T actions) {
        this.device = device;
        this.actions = actions;
        this.driver = device.getDriver ();
        this.setting = device.getSetting ()
            .getPlayback ();
        this.wait = new WebDriverWait (this.driver, ofSeconds (this.setting.getDelay ()
            .getExplicit ()).getSeconds ());
    }

    /**
     * @author wasiq.bhamla
     * @since Oct 9, 2017 9:32:56 PM
     */
    public void captureScreenshot () {
        final ScreenshotSetting screenshotSetting = this.setting.getScreenshot ();
        final String path = screenshotSetting.getPath ();
        final String prefix = screenshotSetting.getPrefix ();
        final SimpleDateFormat date = new SimpleDateFormat ("yyyyMMdd-HHmmss");
        final String timeStamp = date.format (Calendar.getInstance ()
            .getTime ());
        final String fileName = "{0}/{1}-{2}.{3}";
        captureScreenshot (format (fileName, path, prefix, timeStamp, "jpeg"));
    }

    /**
     * @param url URL to navigate to.
     *
     * @author wasiq.bhamla
     * @since Jul 15, 2017 5:19:41 PM
     */
    public void navigateTo (final String url) {
        LOG.info ("Navigating to URL [{}]...", url);
        this.driver.get (url);
    }

    /**
     * @param distance Distance percent to pinch
     *
     * @author wasiq.bhamla
     * @since Oct 20, 2017 8:45:31 PM
     */
    public void pinch (final int distance) {
        LOG.info ("Pinching on device screen by [{}]% distance...", distance);
        doubleFingerGesture (SwipeDirection.DOWN, SwipeDirection.UP, SwipeStartPosition.TOP, SwipeStartPosition.BOTTOM,
            distance);
    }

    /**
     * @param devicePath File device path to pull
     *
     * @return Base64 decoded content of the file.
     *
     * @author Wasiq Bhamla
     * @since 19-Mar-2021
     */
    public byte[] pullFile (final String devicePath) {
        LOG.info ("Pulling file [{}] from Android device...", devicePath);
        return this.driver.pullFile (devicePath);
    }

    /**
     * @param devicePath Folder device path to pull
     *
     * @return Base64 decoded content of folder path.
     *
     * @author Wasiq Bhamla
     * @since 19-Mar-2021
     */
    public byte[] pullFolder (final String devicePath) {
        LOG.info ("Pulling folder [{}] from Android device...", devicePath);
        return this.driver.pullFolder (devicePath);
    }

    /**
     * @param type Screen orientation type
     *
     * @author wasiqb
     * @since Oct 20, 2018
     */
    public void rotate (final ScreenOrientation type) {
        LOG.info ("Rotating device screen as [{}]...", type);
        this.driver.rotate (type);
    }

    /**
     * @return rotation
     *
     * @author wasiqb
     * @since Oct 20, 2018
     */
    public ScreenOrientation rotation () {
        LOG.info ("Getting rotation type for device...");
        return this.driver.getOrientation ();
    }

    /**
     * @param direction Swipe direction
     * @param start Finger start position
     * @param distance Distance percent to swipe
     *
     * @author wasiq.bhamla
     * @since Oct 20, 2017 7:52:29 PM
     */
    public void swipe (final SwipeDirection direction, final SwipeStartPosition start, final int distance) {
        LOG.info ("Swiping [{}] on device screen by [{}] perc distance from [{}] of the screen...", direction, distance,
            start);
        swipeTo (direction, start, distance).perform ();
    }

    /**
     * @param distance Distance percent to zoom
     *
     * @author wasiq.bhamla
     * @since Oct 20, 2017 8:44:00 PM
     */
    public void zoom (final int distance) {
        LOG.info ("Zooming in device screen by [{}]% distance...", distance);
        doubleFingerGesture (SwipeDirection.UP, SwipeDirection.DOWN, SwipeStartPosition.CENTER,
            SwipeStartPosition.CENTER, distance);
    }

    private void captureScreenshot (final String path) {
        LOG.info ("Capturing screenshot and saving at [{}]...", path);
        try {
            final File srcFiler = this.driver.getScreenshotAs (OutputType.FILE);
            copyFile (srcFiler, path);
        } catch (final NoSuchSessionException e) {
            fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
        }
    }

    private void doubleFingerGesture (final SwipeDirection finger1, final SwipeDirection finger2,
        final SwipeStartPosition start1, final SwipeStartPosition start2, final int distancePercent) {
        final T firstFinger = swipeTo (finger1, start1, distancePercent);
        final T secondFinger = swipeTo (finger2, start2, distancePercent);
        final MultiTouchAction multiTouch = new MultiTouchAction (this.driver);
        multiTouch.add (firstFinger)
            .add (secondFinger)
            .perform ();
    }

    private T swipeTo (final SwipeDirection direction, final SwipeStartPosition start, final int distancePercent) {
        return SwipeUtils.<T>builder ().actions (this.actions)
            .setting (this.setting.getDelay ())
            .direction (direction)
            .startPosition (start)
            .distancePercent (distancePercent)
            .screenSize (this.driver.manage ()
                .window ()
                .getSize ())
            .build ()
            .swipe ();
    }
}