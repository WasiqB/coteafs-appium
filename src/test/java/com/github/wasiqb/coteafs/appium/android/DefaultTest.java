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
package com.github.wasiqb.coteafs.appium.android;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.github.wasiqb.coteafs.appium.android.vodqa.actions.LoginActivityAction;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.MainActivity;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 10:09:49 PM
 */
public class DefaultTest {
	protected AndroidDevice	androidDevice;
	protected MainActivity	main;
	private AppiumServer	androidServer;

	/**
	 * @author wasiq.bhamla
	 * @since Feb 2, 2018 3:37:06 PM
	 */
	@BeforeMethod
	public void setupMethod () {
		this.androidDevice = new AndroidDevice (this.androidServer, "test_browserstack");
		this.androidDevice.start ();

		login ();

		this.main = new MainActivity (this.androidDevice);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 10:10:45 PM
	 */
	@BeforeClass (alwaysRun = true)
	public void setupTestSuite () {
		this.androidServer = new AppiumServer ("browserstack");
		this.androidServer.start ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since Feb 2, 2018 3:38:26 PM
	 */
	@AfterMethod
	public void tearDownMethod () {
		if (this.androidDevice != null) {
			this.androidDevice.stop ();
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-Apr-2017 3:47:41 PM
	 */
	@AfterClass (alwaysRun = true)
	public void tearDownTestSuite () {
		if (this.androidServer != null) {
			this.androidServer.stop ();
		}
	}

	private void login () {
		final LoginActivityAction login = new LoginActivityAction (this.androidDevice);
		login.addInputValue ("UserName", "admin")
				.addInputValue ("Password", "admin")
				.perform ();
	}
}