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
package com.github.wasiqb.coteafs.appium.ios.vodqa.activities;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.appium.device.DeviceElement;
import com.github.wasiqb.coteafs.appium.ios.IOSActivity;
import com.github.wasiqb.coteafs.appium.ios.IOSDevice;

import io.appium.java_client.MobileBy;

/**
 * @author wasiqb
 * @since Oct 28, 2018
 */
public class BaseActivity extends IOSActivity {
	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 * @param device
	 */
	public BaseActivity (final IOSDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#prepare()
	 */
	@Override
	protected DeviceElement prepare () {
		final DeviceElement main = DeviceElement.create ("Form")
			.forIos (By.className ("XCUIElementTypeWindow"));

		DeviceElement.create ("Back")
			.parent (main)
			.forIos (MobileBy.iOSNsPredicateString ("name == 'Back'"));

		return main;
	}
}