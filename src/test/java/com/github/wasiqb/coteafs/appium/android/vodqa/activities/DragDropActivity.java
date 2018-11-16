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

import io.appium.java_client.MobileBy;

/**
 * @author wasiq.bhamla
 * @since Feb 2, 2018 1:11:54 PM
 */
public class DragDropActivity extends DefaultActivity {
	/**
	 * @author wasiq.bhamla
	 * @since Feb 2, 2018 1:11:55 PM
	 * @param device
	 */
	public DragDropActivity (final AndroidDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.android.vodqa.activities.DefaultActivity#prepare()
	 */
	@Override
	protected DeviceElement prepare () {
		final DeviceElement main = super.prepare ();

		DeviceElement.create ("Success")
			.parent (main)
			.forAndroid (MobileBy.AccessibilityId ("success"));
		DeviceElement.create ("DropZone")
			.parent (main)
			.forAndroid (MobileBy.AccessibilityId ("dropzone"));
		DeviceElement.create ("DropMe")
			.parent (main)
			.forAndroid (MobileBy.AccessibilityId ("dragMe"));

		return main;
	}
}