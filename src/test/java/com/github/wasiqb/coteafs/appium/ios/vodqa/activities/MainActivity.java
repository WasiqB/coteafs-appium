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
public class MainActivity extends BaseActivity {
	/**
	 * @author wasiqb
	 * @since Oct 28, 2018
	 * @param device
	 */
	public MainActivity (final IOSDevice device) {
		super (device);
	}

	@Override
	protected DeviceElement prepare () {
		final DeviceElement main = super.prepare ();

		final DeviceElement view = DeviceElement.create ("scrollView")
			.parent (main)
			.forIos (MobileBy.AccessibilityId ("scrollView"));

		DeviceElement.create ("Slider")
			.parent (view)
			.forIos (MobileBy.iOSNsPredicateString ("name == 'slider1'"));
		DeviceElement.create ("DragDrop")
			.parent (view)
			.forIos (MobileBy.iOSNsPredicateString ("name == 'dragAndDrop'"));
		DeviceElement.create ("VerticleSwipe")
			.parent (view)
			.forIos (MobileBy.iOSNsPredicateString ("name == 'verticalSwipe'"));
		DeviceElement.create ("DoubleTap")
			.parent (view)
			.forIos (MobileBy.iOSNsPredicateString ("name == 'doubleTap'"));
		DeviceElement.create ("LongPress")
			.parent (view)
			.forIos (MobileBy.iOSNsPredicateString ("name == 'longPress'"));

		return main;
	}
}