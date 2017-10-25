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
package com.github.wasiqb.coteafs.appium.android.expense.activities;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

/**
 * @author wasiq.bhamla
 * @since Oct 23, 2017 3:43:56 PM
 */
public class ListActivity extends AndroidActivity {
	/**
	 * @author wasiq.bhamla
	 * @since Oct 23, 2017 3:43:56 PM
	 * @param device
	 */
	public ListActivity (final AndroidDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#prepare()
	 */
	@Override
	protected DeviceElement prepare () {
		final DeviceElement main = DeviceElement.create ("Main")
			.using (By.id ("android:id/content"));

		final DeviceElement tabs = DeviceElement.create ("Tabs")
			.parent (main)
			.using (By.id ("android:id/tabs"));

		DeviceElement.create ("ThisWeek")
			.parent (tabs)
			.using (By.className ("android.widget.RelativeLayout"));
		DeviceElement.create ("ThisMonth")
			.parent (tabs)
			.index (1)
			.using (By.className ("android.widget.RelativeLayout"));
		DeviceElement.create ("ThisYear")
			.parent (tabs)
			.index (2)
			.using (By.className ("android.widget.RelativeLayout"));
		DeviceElement.create ("All")
			.parent (tabs)
			.index (3)
			.using (By.className ("android.widget.RelativeLayout"));

		final DeviceElement tabContent = DeviceElement.create ("List")
			.parent (main)
			.using (By.id ("com.vinsol.expensetracker:id/expense_listing_listview"));

		return main;
	}
}