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

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import com.github.wasiqb.coteafs.appium.config.PlaybackSetting;
import com.github.wasiqb.coteafs.appium.config.enums.SwipeDirection;
import com.github.wasiqb.coteafs.appium.config.enums.SwipeStartPosition;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * @author wasiq.bhamla
 * @since Feb 1, 2018 12:23:46 PM
 */
public final class SwipeUtils {
	/**
	 * @author wasiq.bhamla
	 * @since Feb 2, 2018 3:25:54 PM
	 * @param setting
	 * @param fromElement
	 * @param toElement
	 * @param actions
	 * @return touch action
	 */
	public static <T extends TouchAction <T>> T dragTo (final PlaybackSetting setting,
		final MobileElement fromElement, final MobileElement toElement, final T actions) {
		final Point source = fromElement.getCenter ();
		final Point target = toElement.getCenter ();
		return actions.press (PointOption.point (source.getX (), source.getY ()))
			.waitAction (
				WaitOptions.waitOptions (Duration.ofMillis (setting.getDelayBeforeSwipe ())))
			.moveTo (PointOption.point (target.getX (), target.getY ()))
			.release ()
			.waitAction (
				WaitOptions.waitOptions (Duration.ofMillis (setting.getDelayAfterSwipe ())));
	}

	/**
	 * @author wasiq.bhamla
	 * @since Sep 18, 2018 8:03:55 PM
	 * @param direction
	 * @param startPosition
	 * @param distancePercent
	 * @param setting
	 * @param screenSize
	 * @param elementSize
	 * @param elementLocation
	 * @param actions
	 * @return action
	 */
	public static <T extends TouchAction <T>> T swipeTo (final SwipeDirection direction,
		final SwipeStartPosition startPosition, final int distancePercent,
		final PlaybackSetting setting, final Dimension screenSize, final Dimension elementSize,
		final Point elementLocation, final T actions) {
		final double distance = distancePercent / 100.0;
		final Point source = getStartPoint (startPosition, screenSize, elementSize,
			elementLocation);
		int endX = source.getX () + (int) (source.getX () * direction.getX () * distance);
		int endY = source.getY () + (int) (source.getY () * direction.getY () * distance);
		if (elementSize != null) {
			endX = source.getX () + (int) (elementSize.getWidth () * direction.getX () * distance);
			endY = source.getY () + (int) (elementSize.getHeight () * direction.getY () * distance);
		}
		System.out.println ("Screen: " + screenSize);
		System.out.println ("Element: " + elementSize);
		System.out.println ("Location: " + elementLocation);
		System.out.println ("Start: " + source);
		System.out.println ("End: " + new Point (endX, endY));
		return actions.press (PointOption.point (source.getX (), source.getY ()))
			.waitAction (
				WaitOptions.waitOptions (Duration.ofMillis (setting.getDelayBeforeSwipe ())))
			.moveTo (PointOption.point (endX, endY))
			// .waitAction (
			// WaitOptions.waitOptions (Duration.ofMillis (setting.getDelayAfterSwipe ())))
			.release ();
	}

	private static Point getStartPoint (final SwipeStartPosition start, final Dimension screenSize,
		final Dimension elementSize, final Point elementLocation) {
		int x = 0;
		int y = 0;
		int width = screenSize.getWidth ();
		int height = screenSize.getHeight ();
		Point location = new Point (0, 0);

		if (elementSize != null) {
			width = elementSize.getWidth ();
			height = elementSize.getHeight ();
			location = elementLocation;
		}

		switch (start) {
			case BOTTOM:
				x = width / 2;
				y = elementSize != null
					&& height + location.getY () < screenSize.getHeight () ? height : height - 5;
				break;
			case CENTER:
				x = width / 2;
				y = height / 2;
				break;
			case LEFT:
				x = elementSize != null && width + location.getX () > 0 ? 0 : 5;
				y = height / 2;
				break;
			case RIGHT:
				x = elementSize != null
					&& width + location.getX () < screenSize.getWidth () ? width : width - 5;
				y = height / 2;
				break;
			case TOP:
			default:
				x = width / 2;
				y = 5;
				break;
		}
		return new Point (location.getX () + x, location.getY () + y);
	}

	private SwipeUtils () {
		// Util class.
	}
}