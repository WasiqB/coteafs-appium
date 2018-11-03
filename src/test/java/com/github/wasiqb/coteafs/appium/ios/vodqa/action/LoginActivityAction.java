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
package com.github.wasiqb.coteafs.appium.ios.vodqa.action;

import com.github.wasiqb.coteafs.appium.ios.IOSActivityActions;
import com.github.wasiqb.coteafs.appium.ios.IOSDevice;
import com.github.wasiqb.coteafs.appium.ios.vodqa.activities.LoginActivity;

import io.appium.java_client.remote.HideKeyboardStrategy;

/**
 * @author wasiqb
 * @since Oct 28, 2018
 */
public class LoginActivityAction extends IOSActivityActions {
	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 * @param device
	 */
	public LoginActivityAction (final IOSDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivityActions#perform()
	 */
	@Override
	public void perform () {
		final LoginActivity login = new LoginActivity (getDevice ());
		login.onElement ("Username")
			.enterText (value ("Username"));
		login.onDevice ()
			.hideKeyboard (HideKeyboardStrategy.PRESS_KEY, "return");
		login.onElement ("Password")
			.enterText (value ("Password"));
		login.onDevice ()
			.hideKeyboard (HideKeyboardStrategy.PRESS_KEY, "return");
		login.onElement ("Login")
			.tap ();
	}
}