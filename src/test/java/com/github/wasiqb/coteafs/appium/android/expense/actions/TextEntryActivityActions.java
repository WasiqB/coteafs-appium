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

import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.android.expense.activities.ConfirmDialogActivity;
import com.github.wasiqb.coteafs.appium.android.expense.activities.TextEntryActivity;

/**
 * @author wasiq.bhamla
 * @since Oct 23, 2017 4:14:40 PM
 */
public class TextEntryActivityActions {
	private final AndroidDevice device;

	/**
	 * @author wasiq.bhamla
	 * @param device
	 * @since Oct 23, 2017 4:14:40 PM
	 */
	public TextEntryActivityActions (final AndroidDevice device) {
		this.device = device;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 23, 2017 4:16:48 PM
	 * @param date
	 * @param amount
	 * @param description
	 * @param favorite
	 */
	public void entry (final String [] date, final String amount, final String description, final boolean favorite) {
		final TextEntryActivity entry = new TextEntryActivity (this.device);

		entry.onElement ("Title")
			.verifyThat ()
			.textShouldBeEqualTo ("Text Entry");

		entry.onElement ("Date")
			.tap ();
		setDate (date);
		entry.onElement ("Amount")
			.enterText (amount);
		entry.onElement ("Description")
			.enterText (description);
		entry.onDevice ()
			.hideKeyboard ();
		if (favorite) {
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
	private void setDate (final String [] date) {
		final ConfirmDialogActivity dialog = new ConfirmDialogActivity (this.device);
		if (date == null) {
			dialog.onElement ("Cancel")
				.tap ();
		}
		else {
			dialog.onElement ("EditMonth")
				.enterText (date [0].toUpperCase ());
			dialog.onElement ("EditDay")
				.enterText (date [1]);
			dialog.onElement ("EditYear")
				.enterText (date [2]);
			dialog.onElement ("OK")
				.tap ();
		}
	}
}