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
 * @since Oct 23, 2017 3:17:10 PM
 */
public class ConfirmDialogActivity extends AndroidActivity {
	/**
	 * @author wasiq.bhamla
	 * @since Oct 23, 2017 3:17:10 PM
	 * @param device
	 */
	public ConfirmDialogActivity (final AndroidDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#prepare()
	 */
	@Override
	protected DeviceElement prepare () {
		final DeviceElement main = DeviceElement.create ("Main")
			.using (By.id ("android:id/parentPanel"));

		DeviceElement.create ("Title")
			.parent (main)
			.using (By.id ("android:id/alertTitle"));
		DeviceElement.create ("Message")
			.parent (main)
			.using (By.id ("android:id/message"));
		DeviceElement.create ("Confirm")
			.parent (main)
			.using (By.id ("com.vinsol.expensetracker:id/disable_delete_dialog_checkbox"));
		DeviceElement.create ("OK")
			.parent (main)
			.using (By.id ("android:id/button1"));
		DeviceElement.create ("Cancel")
			.parent (main)
			.using (By.id ("android:id/button2"));

		final DeviceElement month = DeviceElement.create ("Month")
			.parent (main)
			.using (By.id ("android:id/month"));
		final DeviceElement day = DeviceElement.create ("Day")
			.parent (main)
			.using (By.id ("android:id/day"));
		final DeviceElement year = DeviceElement.create ("Year")
			.parent (main)
			.using (By.id ("android:id/year"));

		DeviceElement.create ("EditMonth")
			.parent (month)
			.using (By.className ("android.widget.EditText"));
		DeviceElement.create ("EditDay")
			.parent (day)
			.using (By.className ("android.widget.EditText"));
		DeviceElement.create ("EditYear")
			.parent (year)
			.using (By.className ("android.widget.EditText"));

		return main;
	}
}