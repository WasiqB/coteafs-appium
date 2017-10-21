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

/**
 * @author wasiq.bhamla
 * @since Oct 20, 2017 7:38:49 PM
 */
public enum SwipeDistance {
	/**
	 * Full distance from touch point to border of screen or element.
	 */
	FULL (1.0),
	/**
	 * Half distance from touch point to border of screen or element.
	 */
	HALF (0.5),
	/**
	 * 1/4th distance from touch point to border of screen or element.
	 */
	QUARTER (0.25),
	/**
	 * 3/4th distance from touch point to border of screen or element.
	 */
	THREE_QUARTER (0.75);

	private final double distance;

	/**
	 * @author wasiq.bhamla
	 * @since Oct 20, 2017 7:39:15 PM
	 */
	private SwipeDistance (final double distance) {
		this.distance = distance;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 20, 2017 7:40:20 PM
	 * @return the distance
	 */
	public double getDistance () {
		return this.distance;
	}
}