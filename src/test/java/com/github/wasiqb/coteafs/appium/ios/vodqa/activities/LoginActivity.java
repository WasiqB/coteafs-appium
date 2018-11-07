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

import com.github.wasiqb.coteafs.appium.device.DeviceElement;
import com.github.wasiqb.coteafs.appium.ios.IOSDevice;

import io.appium.java_client.MobileBy;

/**
 * @author wasiqb
 * @since Oct 28, 2018
 */
public class LoginActivity extends BaseActivity {
	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 * @param device
	 */
	public LoginActivity (final IOSDevice device) {
		super (device);
	}

	@Override
	protected DeviceElement prepare () {
		final DeviceElement form = super.prepare ();
		DeviceElement.create ("Username")
			.parent (form)
			.forIos (MobileBy.AccessibilityId ("username"));
		DeviceElement.create ("Password")
			.parent (form)
			.forIos (MobileBy.AccessibilityId ("password"));
		DeviceElement.create ("Login")
			.parent (form)
			.forIos (MobileBy.iOSNsPredicateString ("name == 'login'"));
		return form;
	}
}