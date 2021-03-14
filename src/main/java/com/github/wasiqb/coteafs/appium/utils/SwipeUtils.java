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
package com.github.wasiqb.coteafs.appium.utils;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import com.github.wasiqb.coteafs.appium.config.device.DelaySetting;
import com.github.wasiqb.coteafs.appium.config.enums.SwipeDirection;
import com.github.wasiqb.coteafs.appium.config.enums.SwipeStartPosition;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import lombok.Builder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

/**
 * @author wasiq.bhamla
 * @since Feb 1, 2018 12:23:46 PM
 */
@Builder
public final class SwipeUtils<T extends TouchAction<T>> {
    private final T                  actions;
    private final SwipeDirection     direction;
    private final int                distancePercent;
    private final Point              elementLocation;
    private final Dimension          elementSize;
    private final Dimension          screenSize;
    private final DelaySetting       setting;
    private final SwipeStartPosition startPosition;

    /**
     * @param fromElement
     * @param toElement
     *
     * @return touch action
     *
     * @author wasiq.bhamla
     * @since Feb 2, 2018 3:25:54 PM
     */
    public T dragTo (final MobileElement fromElement, final MobileElement toElement) {
        final Point source = fromElement.getCenter ();
        final Point target = toElement.getCenter ();
        return this.actions.press (point (source.getX (), source.getY ()))
            .waitAction (waitOptions (ofMillis (this.setting.getBeforeSwipe ())))
            .moveTo (point (target.getX (), target.getY ()))
            .release ()
            .waitAction (waitOptions (ofMillis (this.setting.getAfterSwipe ())));
    }

    /**
     * @return action
     *
     * @author wasiq.bhamla
     * @since Sep 18, 2018 8:03:55 PM
     */
    public T swipe () {
        final double distance = this.distancePercent / 100.0;
        final Point source = getStartPoint (this.startPosition, this.screenSize, this.elementSize,
            this.elementLocation);
        int endX = source.getX () + (int) (source.getX () * this.direction.getX () * distance);
        int endY = source.getY () + (int) (source.getY () * this.direction.getY () * distance);
        if (this.elementSize != null) {
            endX = source.getX () + (int) (this.elementSize.getWidth () * this.direction.getX () * distance);
            endY = source.getY () + (int) (this.elementSize.getHeight () * this.direction.getY () * distance);
        }
        return this.actions.press (point (source.getX (), source.getY ()))
            .waitAction (waitOptions (ofMillis (this.setting.getBeforeSwipe ())))
            .moveTo (point (endX, endY))
            .release ();
    }

    private Point getStartPoint (final SwipeStartPosition start, final Dimension screenSize,
        final Dimension elementSize, final Point elementLocation) {
        final int x;
        final int y;
        int width = screenSize.getWidth ();
        int height = screenSize.getHeight ();
        Point location = new Point (0, 0);

        if (elementSize != null) {
            width = elementSize.getWidth ();
            height = elementSize.getHeight ();
            location = elementLocation;
        }

        switch (start) {
            case BOTTOM -> {
                x = width / 2;
                y = elementSize != null && height + location.getY () < screenSize.getHeight () ? height : height - 5;
            }
            case CENTER -> {
                x = width / 2;
                y = height / 2;
            }
            case LEFT -> {
                x = elementSize != null && width + location.getX () > 0 ? 0 : 5;
                y = height / 2;
            }
            case RIGHT -> {
                x = elementSize != null && width + location.getX () < screenSize.getWidth () ? width : width - 5;
                y = height / 2;
            }
            default -> {
                x = width / 2;
                y = 5;
            }
        }
        return new Point (location.getX () + x, location.getY () + y);
    }
}