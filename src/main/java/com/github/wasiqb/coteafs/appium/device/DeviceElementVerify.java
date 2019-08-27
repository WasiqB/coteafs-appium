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

import static com.google.common.truth.Truth.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

/**
 * @author wasiq.bhamla
 * @param <D>
 * @param <E>
 * @param <T>
 * @since 19-May-2017 9:57:58 PM
 */
public class DeviceElementVerify <D extends AppiumDriver <MobileElement>, E extends Device <D, T>,
	T extends TouchAction <T>> {
	private static final Logger						log	= LogManager
		.getLogger (DeviceElementVerify.class);

	private final DeviceElementActions <D, E, T>	actions;

	/**
	 * @author wasiq.bhamla
	 * @param actions
	 * @since 19-May-2017 9:59:32 PM
	 */
	public DeviceElementVerify (final DeviceElementActions <D, E, T> actions) {
		this.actions = actions;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 10:07:53 PM
	 * @return instance
	 */
	public DeviceElementVerify <D, E, T> shouldBeDisabled () {
		log.info ("Verifying if element is disabled...");
		assertThat (this.actions.enabled ()).isFalse ();
		return this;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 10:08:28 PM
	 * @return instance
	 */
	public DeviceElementVerify <D, E, T> shouldBeDisplayed () {
		log.info ("Verifying if element is displayed...");
		assertThat (this.actions.visible ()).isTrue ();
		return this;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 10:07:22 PM
	 * @return instance
	 */
	public DeviceElementVerify <D, E, T> shouldBeEnabled () {
		log.info ("Verifying if element is enabled...");
		assertThat (this.actions.enabled ()).isTrue ();
		return this;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 20-May-2017 12:24:26 PM
	 * @return instance
	 */
	public DeviceElementVerify <D, E, T> shouldNotBeDisplayed () {
		log.info ("Verifying if element is not displayed...");
		assertThat (this.actions.visible ()).isFalse ();
		return this;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 20-May-2017 12:39:27 PM
	 * @param expected
	 * @return instance
	 */
	public DeviceElementVerify <D, E, T> textShouldBeEqualTo (final String expected) {
		log.info ("Verifying if element text is equal to [{}]...", expected);
		assertThat (this.actions.text ()).isEqualTo (expected);
		return this;
	}
}