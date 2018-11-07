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

import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.config.enums.AutomationType;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

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
			.forAndroid (MobileBy.AccessibilityId ("scrollView"));

		DeviceElement.create ("ChainedView")
			.parent (scroll)
			.forAndroid (MobileBy.AccessibilityId ("Chained View"));
		DeviceElement.create ("Slider")
			.parent (scroll)
			.forAndroid (MobileBy.AccessibilityId ("Slide your number"));
		DeviceElement.create ("VerticalSwipe")
			.parent (scroll)
			.forAndroid (By.xpath ("//android.view.ViewGroup[@content-desc=\"verticalSwipe\"]"))
			.forAndroid (AutomationType.UIAUTOMATOR2,
				MobileBy.AndroidUIAutomator ("new UiSelector ().description (\"verticalSwipe\");"));
		DeviceElement.create ("DragDrop")
			.parent (scroll)
			.forAndroid (MobileBy.AccessibilityId ("Demo drag and drop"));
		DeviceElement.create ("DoubleTap")
			.parent (scroll)
			.forAndroid (MobileBy.AccessibilityId ("Demo double tap button"));
		DeviceElement.create ("WebView")
			.parent (scroll)
			.forAndroid (MobileBy.AccessibilityId ("View hacker news"));
		DeviceElement.create ("LongPress")
			.parent (scroll)
			.forAndroid (MobileBy.AccessibilityId ("Demo Long press button"));
		DeviceElement.create ("PhotoView")
			.parent (scroll)
			.forAndroid (MobileBy.AccessibilityId ("Ping & Zoom"));
		DeviceElement.create ("HorizontalSwipe")
			.parent (scroll)
			.forAndroid (MobileBy.AccessibilityId ("Demos swipe left & right"));
		DeviceElement.create ("WheelPicker")
			.parent (scroll)
			.forAndroid (MobileBy.AccessibilityId ("Demos wheel picker color"));

		return main;
	}
}