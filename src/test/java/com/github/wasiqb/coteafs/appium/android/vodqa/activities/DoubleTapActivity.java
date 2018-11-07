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
package com.github.wasiqb.coteafs.appium.android.vodqa.activities;

import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

import io.appium.java_client.MobileBy;

/**
 * @author wasiq.bhamla
 * @since Feb 8, 2018 3:34:06 PM
 */
public class DoubleTapActivity extends DefaultActivity {
	/**
	 * @author wasiq.bhamla
	 * @since Feb 8, 2018 3:34:07 PM
	 * @param device
	 */
	public DoubleTapActivity (final AndroidDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.android.vodqa.activities.DefaultActivity#prepare()
	 */
	@Override
	protected DeviceElement prepare () {
		final DeviceElement main = super.prepare ();

		DeviceElement.create ("Button")
			.parent (main)
			.forAndroid (MobileBy.AccessibilityId ("doubleTapMe"));

		return main;
	}
}