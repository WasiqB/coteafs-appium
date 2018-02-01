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
package com.github.wasiqb.coteafs.appium.android.vodqa.actions;

import com.github.wasiqb.coteafs.appium.android.AndroidActivityActions;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.LoginActivity;

/**
 * @author wasiq.bhamla
 * @since Jan 22, 2018 9:03:26 PM
 */
public class LoginActivityAction extends AndroidActivityActions {
	/**
	 * @author wasiq.bhamla
	 * @since Jan 22, 2018 9:03:26 PM
	 * @param device
	 */
	public LoginActivityAction (final AndroidDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivityActions#perform()
	 */
	@Override
	public void perform () {
		final LoginActivity login = new LoginActivity (getDevice ());
		// login.onElement ("UserName")
		// .enterText (value ("UserName"));
		// login.onElement ("Password")
		// .enterText (value ("Password"));
		// login.onDevice ()
		// .hideKeyboard ();
		login.onElement ("Login")
			.tap ();
	}
}