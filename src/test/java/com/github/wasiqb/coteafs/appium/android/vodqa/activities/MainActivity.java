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
import com.github.wasiqb.coteafs.appium.device.WaitStrategy;

import io.appium.java_client.MobileBy;

/**
 * @author wasiq.bhamla
 * @since Jan 23, 2018 8:54:51 PM
 */
public class MainActivity extends DefaultActivity {
	/**
	 * @author wasiq.bhamla
	 * @since Jan 23, 2018 8:54:51 PM
	 * @param device
	 */
	public MainActivity (final AndroidDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#prepare()
	 */
	@Override
	protected DeviceElement prepare () {
		final DeviceElement main = super.prepare ();

		final DeviceElement scroll = DeviceElement.create ("ScrollView")
			.parent (main)
			.using (MobileBy.AccessibilityId ("scrollView"));

		DeviceElement.create ("ChainedView")
			.parent (scroll)
			.waitStrategy (WaitStrategy.ENABLED)
			.using (MobileBy.AccessibilityId ("chainedView"));
		DeviceElement.create ("Slider")
			.parent (scroll)
			.waitStrategy (WaitStrategy.ENABLED)
			.using (MobileBy.AccessibilityId ("slider1"));
		DeviceElement.create ("VerticalSwipe")
			.parent (scroll)
			.waitStrategy (WaitStrategy.ENABLED)
			.using (MobileBy.AccessibilityId ("verticalSwipe"));
		DeviceElement.create ("DragDrop")
			.parent (scroll)
			.waitStrategy (WaitStrategy.ENABLED)
			.using (MobileBy.AccessibilityId ("dragAndDrop"));
		DeviceElement.create ("DoubleTap")
			.parent (scroll)
			.waitStrategy (WaitStrategy.ENABLED)
			.using (MobileBy.AccessibilityId ("doubleTap"));
		DeviceElement.create ("WebView")
			.parent (scroll)
			.waitStrategy (WaitStrategy.ENABLED)
			.using (MobileBy.AccessibilityId ("webView"));
		DeviceElement.create ("LongPress")
			.parent (scroll)
			.waitStrategy (WaitStrategy.ENABLED)
			.using (MobileBy.AccessibilityId ("longPress"));
		DeviceElement.create ("PhotoView")
			.parent (scroll)
			.waitStrategy (WaitStrategy.ENABLED)
			.using (MobileBy.AccessibilityId ("photoView"));

		return main;
	}
}