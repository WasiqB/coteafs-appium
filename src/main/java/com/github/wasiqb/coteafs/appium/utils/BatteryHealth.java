/**
 * Copyright (c) 2017-2020, Wasiq Bhamla.
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

import static com.github.wasiqb.coteafs.appium.utils.ErrorUtils.fail;
import static java.text.MessageFormat.format;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.wasiqb.coteafs.appium.error.NotEnoughBatteryChargeError;

/**
 * @author wasiqb
 * @since Oct 2, 2018
 */
public final class BatteryHealth {
	private static final Logger log = LogManager.getLogger (BatteryHealth.class);

	/**
	 * @author wasiqb
	 * @since Oct 2, 2018
	 * @param state
	 * @param level
	 */
	public static void check (final String state, final double level) {
		log.info (format ("Current Battery status is [{0}] with charge level as [{1}%]...", state,
				level * 100));
		if (!state.equals ("CHARGING") && !state.equals ("FULL") && level < 0.2) {
			fail (NotEnoughBatteryChargeError.class,
					"Battery does not have enough charging, to continue, put your device on USB...");
		}
	}

	private BatteryHealth () {
		// TODO Auto-generated constructor stub
	}
}