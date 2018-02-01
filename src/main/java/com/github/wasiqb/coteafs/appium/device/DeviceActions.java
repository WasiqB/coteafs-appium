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
package com.github.wasiqb.coteafs.appium.device;

import static com.github.wasiqb.coteafs.appium.constants.ErrorMessage.SERVER_STOPPED;
import static com.github.wasiqb.coteafs.appium.utils.ErrorUtils.fail;
import static java.lang.String.format;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.wasiqb.coteafs.appium.config.PlaybackSetting;
import com.github.wasiqb.coteafs.appium.error.AppiumServerStoppedError;
import com.github.wasiqb.coteafs.appium.utils.SwipeUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;

/**
 * @author wasiq.bhamla
 * @param <D>
 * @param <E>
 * @since 26-Apr-2017 8:39:17 PM
 */
public class DeviceActions <D extends AppiumDriver <MobileElement>, E extends Device <D>> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (DeviceActions.class);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jul 22, 2017 11:03:48 PM
	 * @param srcFiler
	 * @param path
	 */
	private static void copyFile (final File source, final String destination) {
		try {
			FileUtils.copyFile (source, new File (destination));
		}
		catch (final IOException e) {
			log.error ("Error occurred while capturing screensshot...");
			log.catching (e);
		}
	}

	protected final E				device;
	protected final D				driver;
	protected final WebDriverWait	wait;
	private final MultiTouchAction	multiTouch;
	private final PlaybackSetting	setting;

	/**
	 * @author wasiq.bhamla
	 * @param device
	 * @since 26-Apr-2017 8:39:17 PM
	 */
	public DeviceActions (final E device) {
		this.device = device;
		this.driver = this.device.getDriver ();
		this.setting = device.setting.getPlayback ();
		this.wait = new WebDriverWait (this.driver, this.setting.getWaitForElementUntil ());
		this.multiTouch = new MultiTouchAction (this.driver);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 9, 2017 9:32:56 PM
	 */
	public void captureScreenshot () {
		final String path = this.setting.getScreenShotPath ();
		final String prefix = this.setting.getScreenShotPrefix ();
		final SimpleDateFormat date = new SimpleDateFormat ("yyyyMMdd-HHmmss");
		final String timeStamp = date.format (Calendar.getInstance ()
			.getTime ());
		final String fileName = "%s/%s-%s.%s";
		captureScreenshot (format (fileName, path, prefix, timeStamp, "jpeg"));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:34:05 PM
	 */
	public void hideKeyboard () {
		log.info ("Hiding the keyboard...");
		try {
			this.driver.hideKeyboard ();
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jul 15, 2017 5:19:41 PM
	 * @param url
	 */
	public void navigateTo (final String url) {
		log.info (format ("Navigating to URL [%S]...", url));
		this.driver.get (url);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 20, 2017 8:45:31 PM
	 * @param distance
	 */
	public void pinch (final int distance) {
		log.info (format ("Pinching on device screen by [%d]% distance...", distance));
		doubleFingerGesture (SwipeDirection.DOWN, SwipeDirection.UP, SwipeStartPosition.TOP, SwipeStartPosition.BOTTOM,
				distance);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 20, 2017 7:52:29 PM
	 * @param direction
	 * @param start
	 * @param distance
	 */
	public void swipe (final SwipeDirection direction, final SwipeStartPosition start, final int distance) {
		log.info (format ("Swiping [%s] on device screen by [%d] perc distance from [%s] of the screen...", direction,
				distance, start));
		swipeTo (direction, start, distance).perform ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 20, 2017 8:44:00 PM
	 * @param distance
	 */
	public void zoom (final int distance) {
		log.info (format ("Zooming in device screen by [%d]% distance...", distance));
		doubleFingerGesture (SwipeDirection.UP, SwipeDirection.DOWN, SwipeStartPosition.CENTER,
				SwipeStartPosition.CENTER, distance);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 01-May-2017 8:24:34 PM
	 * @param path
	 */
	private void captureScreenshot (final String path) {
		final String msg = "Capturing screenshot and saving at [%s]...";
		log.info (format (msg, path));
		try {
			final File srcFiler = this.driver.getScreenshotAs (OutputType.FILE);
			copyFile (srcFiler, path);
		}
		catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
	}

	private void doubleFingerGesture (final SwipeDirection finger1, final SwipeDirection finger2,
			final SwipeStartPosition start1, final SwipeStartPosition start2, final int distancePercent) {
		final TouchAction firstFinger = swipeTo (finger1, start1, distancePercent);
		final TouchAction secondFinger = swipeTo (finger2, start2, distancePercent);
		this.multiTouch.add (firstFinger)
			.add (secondFinger)
			.perform ();
	}

	private TouchAction swipeTo (final SwipeDirection direction, final SwipeStartPosition start,
			final int distancePercent) {
		final Dimension size = this.driver.manage ()
			.window ()
			.getSize ();
		final Point location = new Point (0, 0);

		return SwipeUtils.swipeTo (size, location, direction, start, distancePercent, this.setting, this.driver, null);
	}
}