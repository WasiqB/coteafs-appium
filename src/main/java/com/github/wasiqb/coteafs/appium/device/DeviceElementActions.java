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
import static java.time.Duration.ofSeconds;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.interactions.Sequence;

import com.github.wasiqb.coteafs.appium.checker.DeviceChecker;
import com.github.wasiqb.coteafs.appium.config.PlaybackSetting;
import com.github.wasiqb.coteafs.appium.error.AppiumServerStoppedError;
import com.github.wasiqb.coteafs.appium.utils.SwipeUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

/**
 * @author wasiq.bhamla
 * @param <D>
 * @param <E>
 * @param <T>
 * @since 26-Apr-2017 6:39:03 PM
 */
public class DeviceElementActions <D extends AppiumDriver <MobileElement>, E extends Device <D>, T extends TouchAction <T>> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (DeviceElementActions.class);
	}

	private final int				afterTap;
	private final int				beforeTap;
	private final E					device;
	private final D					driver;
	private final MobileElement		element;
	private final String			name;
	private final PlaybackSetting	setting;
	private final T					touch;

	/**
	 * @author wasiq.bhamla
	 * @param device
	 * @param name
	 * @param element
	 * @param touch
	 * @since 26-Apr-2017 6:39:03 PM
	 */
	public DeviceElementActions (final E device, final String name, final MobileElement element,
			final T touch) {
		this.device = device;
		this.name = name;
		this.element = element;
		this.driver = this.device.getDriver ();
		this.touch = touch;
		this.setting = device.getSetting ()
				.getPlayback ();
		DeviceChecker.checkDeviceElementDisplayed (element, name);
		this.beforeTap = this.setting.getDelayBeforeTap ();
		this.afterTap = this.setting.getDelayAfterTap ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 21, 2017 5:22:04 PM
	 * @param text
	 */
	public void appendText (final String text) {
		tap ();
		final String actionType = String.format ("Appending text [%s] in", text);
		perform (actionType, e -> e.sendKeys (text));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:49:52 PM
	 */
	public void clear () {
		perform ("Clearing", MobileElement::clear);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jul 15, 2017 6:12:00 PM
	 */
	public void click () {
		perform ("Clicking on", e -> {
			e.click ();
		});
	}

	/**
	 * @author wasiq.bhamla
	 * @since Feb 2, 2018 1:45:15 PM
	 * @param dropElement
	 */
	public void dragDrop (final MobileElement dropElement) {
		perform ("Performing drag on", e -> this.driver
				.perform (Arrays.asList (SwipeUtils.dragTo (this.setting, e, dropElement))));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:51:07 PM
	 * @return enabled
	 */
	public boolean enabled () {
		return getValue ("Checking if element [%s] is enabled...", MobileElement::isEnabled);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:31:45 PM
	 * @param text
	 */
	public void enterText (final String text) {
		tap ();
		clear ();
		final String actionType = String.format ("Entering text [%s] in", text);
		perform (actionType, e -> e.sendKeys (text));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 10:03:16 PM
	 * @return the device
	 */
	public E getDevice () {
		return this.device;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 10:03:16 PM
	 * @return the driver
	 */
	public D getDriver () {
		return this.driver;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Sep 18, 2018 3:21:26 PM
	 */
	public void longPress () {
		perform ("Performing long press on",
				e -> this.touch.waitAction (WaitOptions.waitOptions (ofSeconds (this.afterTap)))
						.longPress (LongPressOptions.longPressOptions ()
								.withElement (ElementOption.element (e)))
						.waitAction (WaitOptions.waitOptions (ofSeconds (this.afterTap)))
						.perform ());
	}

	/**
	 * @author wasiq.bhamla
	 * @param distance
	 * @since 26-Apr-2017 8:49:08 PM
	 */
	public void pinch (final int distance) {
		perform ("Pinching on", e -> doubleFingerGesture (SwipeDirection.DOWN, SwipeDirection.UP,
				SwipeStartPosition.TOP, SwipeStartPosition.BOTTOM, distance));
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:50:40 PM
	 * @return selected
	 */
	public boolean selected () {
		return getValue ("Checking if element [%s] is selected...", MobileElement::isSelected);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 06-May-2017 4:56:42 PM
	 */
	public void submit () {
		perform ("Performing submit", MobileElement::submit);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-May-2017 10:07:14 PM
	 * @param direction
	 * @param start
	 * @param distance
	 */
	public void swipe (final SwipeDirection direction, final SwipeStartPosition start,
			final int distance) {
		perform ("Swiping on", e -> {
			this.driver.perform (Arrays.asList (swipeTo (direction, start, distance)));
			this.touch
					.waitAction (WaitOptions
							.waitOptions (ofSeconds (this.setting.getDelayAfterSwipe ())))
					.perform ();
		});
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-May-2017 10:08:55 PM
	 */
	public void tap () {
		perform ("Tapping on",
				e -> this.touch.waitAction (WaitOptions.waitOptions (ofSeconds (this.beforeTap)))
						.tap (TapOptions.tapOptions ()
								.withElement (ElementOption.element (e)))
						.waitAction (WaitOptions.waitOptions (ofSeconds (this.afterTap)))
						.perform ());
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:52:40 PM
	 * @return text
	 */
	public String text () {
		return getValue ("Getting text on element [%s]...", MobileElement::getText);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 10:09:58 PM
	 * @return verify
	 */
	public DeviceElementVerify <D, E, T> verifyThat () {
		return new DeviceElementVerify <> (this);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:51:40 PM
	 * @return visible
	 */
	public boolean visible () {
		return getValue ("Checking if element [%s] is visible...", MobileElement::isDisplayed);
	}

	/**
	 * @author wasiq.bhamla
	 * @param distance
	 * @since 26-Apr-2017 8:48:10 PM
	 */
	public void zoom (final int distance) {
		perform ("Zooming on", e -> doubleFingerGesture (SwipeDirection.UP, SwipeDirection.DOWN,
				SwipeStartPosition.CENTER, SwipeStartPosition.CENTER, distance));
	}

	private void checkElementEnabled () {
		DeviceChecker.checkDeviceElementEnabled (this.element, this.name);
	}

	private void doubleFingerGesture (final SwipeDirection finger1, final SwipeDirection finger2,
			final SwipeStartPosition start1, final SwipeStartPosition start2,
			final int distancePercent) {
		final Sequence firstFinger = swipeTo (finger1, start1, distancePercent);
		final Sequence secondFinger = swipeTo (finger2, start2, distancePercent);
		this.driver.perform (Arrays.asList (firstFinger, secondFinger));
	}

	private <R> R getValue (final String message, final Function <MobileElement, R> func) {
		log.info (String.format (message, this.name));
		try {
			return func.apply (this.element);
		} catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
		return null;
	}

	private void perform (final String action, final Consumer <MobileElement> consumer) {
		checkElementEnabled ();
		log.info (String.format ("%s element [%s]...", action, this.name));
		try {
			consumer.accept (this.element);
		} catch (final NoSuchSessionException e) {
			fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
		}
	}

	private Sequence swipeTo (final SwipeDirection direction, final SwipeStartPosition start,
			final int distancePercent) {
		return SwipeUtils.swipeTo (direction, start, distancePercent, this.setting, this.driver,
				this.element);
	}
}