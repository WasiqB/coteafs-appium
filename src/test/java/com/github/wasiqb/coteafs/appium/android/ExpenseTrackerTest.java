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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.appium.android.expense.actions.TextEntryActivityActions;

/**
 * @author wasiq.bhamla
 * @since Oct 23, 2017 4:08:17 PM
 */
public class ExpenseTrackerTest extends DefaultTest {
	/**
	 * @author wasiq.bhamla
	 * @param date
	 * @param amount
	 * @param description
	 * @param favorite
	 * @since Oct 23, 2017 4:12:37 PM
	 */
	@Test (dataProvider = "textEntryDataProvider")
	public void testCreateEntry (final String date, final String amount, final String description,
			final boolean favorite) {
		final TextEntryActivityActions entry = new TextEntryActivityActions (this.androidDevice);
		entry.addInputValue ("Date", date)
			.addInputValue ("Amount", amount)
			.addInputValue ("Description", description)
			.addInputValue ("AddFavorite", favorite)
			.perform ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 23, 2017 4:34:07 PM
	 * @return data set
	 */
	@DataProvider
	public Iterator <Object []> textEntryDataProvider () {
		final List <Object []> data = new ArrayList <> ();
		data.add (new Object [] { "Oct-24-2017", "10000", "Test 4", false });
		data.add (new Object [] { "Oct-24-2017", "10000", "Test 9", true });
		return data.iterator ();
	}
}