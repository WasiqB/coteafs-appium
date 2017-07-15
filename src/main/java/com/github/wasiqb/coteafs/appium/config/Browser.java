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
package com.github.wasiqb.coteafs.appium.config;

import org.openqa.selenium.remote.BrowserType;

/**
 * @author wasiq.bhamla
 * @since Jul 15, 2017 4:50:08 PM
 */
public enum Browser {
	/**
	 * Chrome browser.
	 */
	CHROME (BrowserType.CHROME),
	/**
	 * Firefox browser.
	 */
	FIREFOX (BrowserType.FIREFOX),
	/**
	 * Opera browser.
	 */
	OPERA (BrowserType.OPERA_BLINK),
	/**
	 * Safari browser.
	 */
	SAFARI (BrowserType.SAFARI);

	private final String browser;

	private Browser (final String browser) {
		this.browser = browser;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jul 15, 2017 5:04:12 PM
	 * @return the browser
	 */
	public String getBrowser () {
		return this.browser;
	}
}