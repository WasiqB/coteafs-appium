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
package com.github.wasiqb.coteafs.appium.utils;

import static java.time.Duration.ofSeconds;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import com.github.wasiqb.coteafs.appium.config.PlaybackSetting;
import com.github.wasiqb.coteafs.appium.device.SwipeDirection;
import com.github.wasiqb.coteafs.appium.device.SwipeStartPosition;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

/**
 * @author wasiq.bhamla
 * @since Feb 1, 2018 12:23:46 PM
 */
public final class SwipeUtils {
	/**
	 * @author wasiq.bhamla
	 * @since Feb 2, 2018 3:25:54 PM
	 * @param driver
	 * @param setting
	 * @param fromElement
	 * @param toElement
	 * @return touch action
	 */
	public static TouchAction dragTo (final PerformsTouchActions driver, final PlaybackSetting setting,
			final MobileElement fromElement, final MobileElement toElement) {
		final TouchAction returnAction = new TouchAction (driver);
		returnAction.press (fromElement)
			.waitAction (ofSeconds (setting.getDelayBeforeSwipe ()))
			.moveTo (toElement)
			.release ()
			.waitAction (ofSeconds (setting.getDelayAfterSwipe ()));
		return returnAction;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Feb 1, 2018 12:30:56 PM
	 * @param direction
	 * @param start
	 * @param distancePercent
	 * @param setting
	 * @param driver
	 * @param element
	 * @return touch action
	 */
	public static TouchAction swipeTo (final SwipeDirection direction, final SwipeStartPosition start,
			final int distancePercent, final PlaybackSetting setting, final AppiumDriver <MobileElement> driver,
			final MobileElement element) {
		final Dimension screenSize = driver.manage ()
			.window ()
			.getSize ();
		final double distance = distancePercent / 100.0;
		final int w = screenSize.getWidth ();
		final int h = screenSize.getHeight ();

		final Point startPosition = getStartPoint (start, w, h, element);
		final int startX = startPosition.getX ();
		final int startY = startPosition.getY ();

		int endX = (int) (startX * direction.getX () * distance);
		int endY = (int) (startY * direction.getY () * distance);

		final int beforeSwipe = setting.getDelayBeforeSwipe ();
		final int afterSwipe = setting.getDelayAfterSwipe ();
		final TouchAction returnAction = new TouchAction (driver);
		if (element == null) {
			returnAction.press (startX, startY)
				.waitAction (ofSeconds (beforeSwipe))
				.moveTo (endX, endY)
				.release ()
				.waitAction (ofSeconds (afterSwipe));
		}
		else {
			final Dimension elementSize = element.getSize ();
			endX = startX + (int) (elementSize.getWidth () * direction.getX () * distance);
			endY = startY + (int) (elementSize.getHeight () * direction.getY () * distance);

			returnAction.press (element, startX, startY)
				.waitAction (ofSeconds (beforeSwipe))
				.moveTo (element, endX, endY)
				.release ();
		}

		return returnAction;
	}

	private static Point getStartPoint (final SwipeStartPosition start, final int w, final int h,
			final MobileElement element) {
		int x = 0;
		int y = 0;
		int width = w;
		int height = h;
		Point location = new Point (0, 0);

		if (element != null) {
			final Dimension size = element.getSize ();
			width = size.getWidth ();
			height = size.getHeight ();
			location = element.getLocation ();
		}
		switch (start) {
			case BOTTOM:
				x = width / 2;
				y = element != null && height + location.getY () < h ? height : height - 5;
				break;
			case CENTER:
				x = width / 2;
				y = height / 2;
				break;
			case LEFT:
				x = element != null && width + location.getX () > 0 ? 0 : 5;
				y = height / 2;
				break;
			case RIGHT:
				x = element != null && width + location.getX () < w ? width : width - 5;
				y = height / 2;
				break;
			case TOP:
			default:
				x = width / 2;
				y = 5;
				break;
		}
		return new Point (x, y);
	}

	private SwipeUtils () {
		// Util class.
	}
}