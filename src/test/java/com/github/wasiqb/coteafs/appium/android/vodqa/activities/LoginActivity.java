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

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

/**
 * @author wasiq.bhamla
 * @since Jan 22, 2018 8:51:26 PM
 */
public class LoginActivity extends AndroidActivity {
	/**
	 * @author wasiq.bhamla
	 * @since Jan 22, 2018 8:51:27 PM
	 * @param device
	 */
	public LoginActivity (final AndroidDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#prepare()
	 */
	@Override
	protected DeviceElement prepare () {
		final DeviceElement main = DeviceElement.create ("LoginScreen")
			.using (By.id ("android:id/content"));
		DeviceElement.create ("UserName")
			.using (By.id ("username"))
			.parent (main);
		DeviceElement.create ("Password")
			.using (By.id ("password"))
			.parent (main);
		DeviceElement.create ("Login")
			.using (By.id ("login"))
			.parent (main);
		return main;
	}
}