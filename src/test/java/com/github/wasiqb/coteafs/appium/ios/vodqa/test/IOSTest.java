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
package com.github.wasiqb.coteafs.appium.ios.vodqa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.appium.config.enums.SwipeDirection;
import com.github.wasiqb.coteafs.appium.ios.IOSDevice;
import com.github.wasiqb.coteafs.appium.ios.vodqa.action.LoginActivityAction;
import com.github.wasiqb.coteafs.appium.ios.vodqa.activities.DragDropActivity;
import com.github.wasiqb.coteafs.appium.ios.vodqa.activities.LoginActivity;
import com.github.wasiqb.coteafs.appium.ios.vodqa.activities.LongPressActivity;
import com.github.wasiqb.coteafs.appium.ios.vodqa.activities.MainActivity;
import com.github.wasiqb.coteafs.appium.ios.vodqa.activities.VerticleSwipeActivity;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

/**
 * @author wasiqb
 * @since Oct 28, 2018
 */
public class IOSTest {
	private IOSDevice		device;
	private AppiumServer	server;

	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 */
	@BeforeMethod
	public void setupMethod () {
		this.device.start ();
	}

	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 */
	@BeforeTest
	public void setupTest () {
		this.server = new AppiumServer ("iphone");
		this.server.start ();

		this.device = new IOSDevice (this.server, "iphone");
	}

	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 */
	@AfterMethod
	public void teardownMethod () {
		this.device.stop ();
	}

	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 */
	@AfterTest
	public void teardownTest () {
		this.server.stop ();
	}

	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 */
	@Test
	public void test1Login () {
		final LoginActivityAction login = new LoginActivityAction (this.device);
		login.addInputValue ("Username", "admin")
			.addInputValue ("Password", "admin")
			.perform ();
	}

	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 */
	@Test
	public void test2VerticleSwipe () {
		login ();
		final MainActivity main = new MainActivity (this.device);
		main.onElement ("VerticleSwipe")
			.tap ();

		final VerticleSwipeActivity vs = new VerticleSwipeActivity (this.device);
		vs.onElement ("List")
			.swipe (SwipeDirection.UP);
		vs.onElement ("List")
			.swipe (SwipeDirection.DOWN);
	}

	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 */
	@Test
	public void test3DragDrop () {
		login ();
		final MainActivity main = new MainActivity (this.device);
		main.onElement ("DragDrop")
			.tap ();

		final DragDropActivity dt = new DragDropActivity (this.device);
		dt.onElement ("DragMe")
			.dragDrop (dt.getElement ("DropZone"));

		dt.onElement ("Message")
			.verifyThat ()
			.textShouldBeEqualTo ("Circle dropped");
	}

	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 */
	@Test
	public void test4LongPress () {
		login ();
		final MainActivity main = new MainActivity (this.device);
		main.onElement ("LongPress")
			.tap ();

		final LongPressActivity lp = new LongPressActivity (this.device);
		lp.onElement ("LongPress")
			.longPress ();

		final String message = lp.onDevice ()
			.handleAlert ();

		Assert.assertEquals (message, "Long Pressed\nyou pressed me hard :P");
	}

	private void login () {
		final LoginActivity login = new LoginActivity (this.device);
		login.onElement ("Login")
			.tap ();
	}
}