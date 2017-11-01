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

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.github.wasiqb.coteafs.appium.service.AppiumServer;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 10:09:49 PM
 */
public class DefaultTest {
	protected AndroidDevice	androidDevice;
	private AppiumServer	androidServer;

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 10:10:45 PM
	 */
	@BeforeSuite (alwaysRun = true)
	public void setupTestSuite () {
		this.androidServer = new AppiumServer ("android");
		this.androidServer.start ();

		this.androidDevice = new AndroidDevice (this.androidServer, "test");
		this.androidDevice.start ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 17-Apr-2017 3:47:41 PM
	 */
	@AfterSuite (alwaysRun = true)
	public void tearDownTestSuite () {
		if (this.androidServer != null && this.androidDevice != null) {
			this.androidDevice.stop ();
			this.androidServer.stop ();
		}
	}
}