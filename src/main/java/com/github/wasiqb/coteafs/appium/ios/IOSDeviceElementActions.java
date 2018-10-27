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
package com.github.wasiqb.coteafs.appium.ios;

import static java.lang.String.format;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;

import com.github.wasiqb.coteafs.appium.device.DeviceElementActions;
import com.github.wasiqb.coteafs.appium.device.SwipeDirection;
import com.github.wasiqb.coteafs.appium.device.SwipeStartPosition;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;

/**
 * @author wasiq.bhamla
 * @since 02-May-2017 6:37:57 PM
 */
public class IOSDeviceElementActions
	extends DeviceElementActions <IOSDriver <MobileElement>, IOSDevice, IOSTouchAction> {
	private static final Logger log = LogManager.getLogger (IOSDeviceElementActions.class);

	/**
	 * @author wasiq.bhamla
	 * @since 02-May-2017 6:38:12 PM
	 * @param device
	 * @param name
	 * @param element
	 */
	public IOSDeviceElementActions (final IOSDevice device, final String name,
		final MobileElement element) {
		super (device, name, element, new IOSTouchAction (device.getDriver ()));
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.github.wasiqb.coteafs.appium.device.DeviceElementActions#dragDrop(io.appium.java_client.
	 * MobileElement)
	 */
	@Override
	public void dragDrop (final MobileElement dropElement) {
		log.info (format ("Performing drag on element [%s]...", this.name));
		final Point fromCenter = this.element.getCenter ();
		final Point fromLocation = this.element.getLocation ();
		final Point toCenter = dropElement.getCenter ();

		final Map <String, Object> param = new HashMap <> ();
		param.put ("duration", 1.0);
		param.put ("fromX", fromCenter.getX () - fromLocation.getX ());
		param.put ("fromY", fromCenter.getY () - fromLocation.getY ());
		param.put ("toX", toCenter.getX () - fromLocation.getX ());
		param.put ("toY", toCenter.getY () - fromLocation.getY ());
		executeCommand ("mobile: dragFromToForDuration", param);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceElementActions#longPress()
	 */
	@Override
	public void longPress () {
		log.info (format ("Long pressing on element [%s]...", this.name));
		final Map <String, Object> param = new HashMap <> ();
		param.put ("duration", 1.0);
		param.put ("element", this.element.getId ());
		executeCommand ("mobile: touchAndHold", param);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceElementActions#pinch(int)
	 */
	@Override
	public void pinch (final int distance) {
		log.info (format ("Pinching on element [%s]...", this.name));
		final Map <String, Object> param = new HashMap <> ();
		param.put ("scale", 0.5);
		param.put ("velocity", distance);
		param.put ("element", this.element.getId ());
		executeCommand ("mobile: pinch", param);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.github.wasiqb.coteafs.appium.device.DeviceElementActions#swipe(com.github.wasiqb.coteafs.
	 * appium.device.SwipeDirection, com.github.wasiqb.coteafs.appium.device.SwipeStartPosition,
	 * int)
	 */
	@Override
	public void swipe (final SwipeDirection direction, final SwipeStartPosition start,
		final int distance) {
		log.info (format ("Swiping on element [%s]...", this.name));
		final Map <String, Object> param = new HashMap <> ();
		param.put ("direction", direction.name ()
			.toLowerCase ());
		param.put ("element", this.element.getId ());
		executeCommand ("mobile: swipe", param);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceElementActions#tap()
	 */
	@Override
	public void tap () {
		log.info (format ("Tapping on element [%s]...", this.name));
		final Point center = this.element.getCenter ();
		final Point location = this.element.getLocation ();
		final Map <String, Object> param = new HashMap <> ();
		param.put ("x", center.getX () - location.getX ());
		param.put ("y", center.getY () - location.getY ());
		param.put ("element", this.element.getId ());
		executeCommand ("mobile: tap", param);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceElementActions#verifyThat()
	 */
	@Override
	public IOSElementVerify verifyThat () {
		return new IOSElementVerify (this);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceElementActions#zoom(int)
	 */
	@Override
	public void zoom (final int distance) {
		log.info (format ("Zooming on element [%s]...", this.name));
		final Map <String, Object> param = new HashMap <> ();
		param.put ("scale", 1.5);
		param.put ("velocity", distance);
		param.put ("element", this.element.getId ());
		executeCommand ("mobile: pinch", param);
	}
}