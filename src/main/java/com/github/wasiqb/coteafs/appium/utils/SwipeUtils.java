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
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;

import com.github.wasiqb.coteafs.appium.config.PlaybackSetting;
import com.github.wasiqb.coteafs.appium.device.SwipeDirection;
import com.github.wasiqb.coteafs.appium.device.SwipeStartPosition;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

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
	 * @return touch action
	 */
	public static Sequence dragTo (final PlaybackSetting setting, final MobileElement fromElement,
			final MobileElement toElement) {
		final Point source = fromElement.getCenter ();
		final Point target = toElement.getCenter ();
		final PointerInput finger = new PointerInput (Kind.TOUCH, "finger");
		final Sequence sequence = new Sequence (finger, 0);
		sequence.addAction (
				finger.createPointerMove (Duration.ofMillis (setting.getDelayBeforeSwipe ()),
						PointerInput.Origin.viewport (), source.getX (), source.getY ()));
		sequence.addAction (finger.createPointerDown (PointerInput.MouseButton.MIDDLE.asArg ()));
		sequence.addAction (
				finger.createPointerMove (Duration.ofMillis (setting.getDelayAfterSwipe ()),
						PointerInput.Origin.viewport (), target.getX (), target.getY ()));
		sequence.addAction (finger.createPointerUp (PointerInput.MouseButton.MIDDLE.asArg ()));
		return sequence;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Sep 18, 2018 8:03:55 PM
	 * @param direction
	 * @param startPosition
	 * @param distancePercent
	 * @param setting
	 * @param driver
	 * @param element
	 * @return sequence
	 */
	public static Sequence swipeTo (final SwipeDirection direction,
			final SwipeStartPosition startPosition, final int distancePercent,
			final PlaybackSetting setting, final AppiumDriver <MobileElement> driver,
			final MobileElement element) {
		final double distance = distancePercent / 100.0;
		final Dimension size = driver.manage ()
				.window ()
				.getSize ();
		final Point source = getStartPoint (startPosition, size.getWidth (), size.getHeight (),
				element);
		final PointerInput finger = new PointerInput (Kind.TOUCH, "finger");
		int endX = (int) (source.getX () * direction.getX () * distance);
		int endY = (int) (source.getY () * direction.getY () * distance);

		if (element != null) {
			final Dimension elementSize = element.getSize ();
			endX = source.getX () + (int) (elementSize.getWidth () * direction.getX () * distance);
			endY = source.getY () + (int) (elementSize.getHeight () * direction.getY () * distance);
		}
		final Sequence sequence = new Sequence (finger, 0);
		sequence.addAction (
				finger.createPointerMove (Duration.ofMillis (setting.getDelayBeforeSwipe ()),
						PointerInput.Origin.viewport (), source.getX (), source.getY ()));
		sequence.addAction (finger.createPointerDown (PointerInput.MouseButton.MIDDLE.asArg ()));
		sequence.addAction (
				finger.createPointerMove (Duration.ofMillis (setting.getDelayAfterSwipe ()),
						PointerInput.Origin.viewport (), endX, endY));
		sequence.addAction (finger.createPointerUp (PointerInput.MouseButton.MIDDLE.asArg ()));
		return sequence;
	}

	private static Point getStartPoint (final SwipeStartPosition start, final int w, final int h,
			final MobileElement element) {
		int x = 0;
		int y = 0;
		int width = w;
		int height = h;
		Point location = new Point (0, 0);

		if (element != null) {
			final Point size = element.getCenter ();
			width = size.getX ();
			height = size.getY ();
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