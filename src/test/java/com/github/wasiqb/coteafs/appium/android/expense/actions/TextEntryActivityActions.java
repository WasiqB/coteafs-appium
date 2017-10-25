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
package com.github.wasiqb.coteafs.appium.android.expense.actions;

import com.github.wasiqb.coteafs.appium.android.AndroidActivityActions;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.android.expense.activities.ConfirmDialogActivity;
import com.github.wasiqb.coteafs.appium.android.expense.activities.DashboardActivity;
import com.github.wasiqb.coteafs.appium.android.expense.activities.TextEntryActivity;

/**
 * @author wasiq.bhamla
 * @since Oct 23, 2017 4:14:40 PM
 */
public class TextEntryActivityActions extends AndroidActivityActions {
	/**
	 * @author wasiq.bhamla
	 * @param device
	 * @since Oct 23, 2017 4:14:40 PM
	 */
	public TextEntryActivityActions (final AndroidDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivityActions#perform()
	 */
	@Override
	public void perform () {
		final DashboardActivity home = new DashboardActivity (getDevice ());
		home.onElement ("Text")
			.tap ();

		final TextEntryActivity entry = new TextEntryActivity (getDevice ());
		entry.onElement ("Title")
			.verifyThat ()
			.textShouldBeEqualTo ("Text Entry");

		entry.onElement ("Date")
			.tap ();
		setDate (value ("Date"));
		entry.onElement ("Amount")
			.enterText (value ("Amount"));
		entry.onElement ("Description")
			.appendText (value ("Description"));
		entry.onDevice ()
			.hideKeyboard ();
		if ((boolean) value ("AddFavorite")) {
			entry.onElement ("AddFavorite")
				.tap ();
		}
		entry.onElement ("Save")
			.tap ();
		entry.onDevice ()
			.pressBack ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 23, 2017 4:17:30 PM
	 * @param date
	 */
	private void setDate (final Object date) {
		final ConfirmDialogActivity dialog = new ConfirmDialogActivity (getDevice ());
		if (date == null) {
			dialog.onElement ("Cancel")
				.tap ();
		}
		else {
			final String [] values = date.toString ()
				.split ("-");
			dialog.onElement ("EditMonth")
				.enterText (values [0].toUpperCase ());
			dialog.onElement ("EditDay")
				.enterText (values [1]);
			dialog.onElement ("EditYear")
				.enterText (values [2]);
			dialog.onElement ("OK")
				.tap ();
		}
	}
}