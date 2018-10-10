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

import static java.lang.String.format;

/**
 * @author wasiq.bhamla
 * @since Jan 18, 2018 9:32:14 PM
 */
public class PlaybackSetting {
	private int		defaultWait;
	private int		delayAfterSwipe;
	private int		delayAfterTap;
	private int		delayBeforeSwipe;
	private int		delayBeforeTap;
	private boolean	record;
	private String	recordPath;
	private String	recordPrefix;
	private boolean	screenshotOnError;
	private String	screenShotPath;
	private String	screenShotPrefix;
	private int		waitForElementUntil;

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:34:51 PM
	 */
	public PlaybackSetting () {
		this.defaultWait = 30;
		this.waitForElementUntil = 30;
		this.delayBeforeTap = 0;
		this.delayAfterTap = 0;
		this.delayBeforeSwipe = 0;
		this.delayAfterSwipe = 0;
		this.screenShotPath = format ("%s/screenshots", System.getProperty ("user.dir"));
		this.screenShotPrefix = "SCR";
		this.screenshotOnError = false;
		this.record = false;
		this.recordPath = format ("%s/video", System.getProperty ("user.dir"));
		this.recordPrefix = "VID";
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @return the defaultWait
	 */
	public int getDefaultWait () {
		return this.defaultWait;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @return the delayAfterSwipe
	 */
	public int getDelayAfterSwipe () {
		return this.delayAfterSwipe;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @return the delayAfterTap
	 */
	public int getDelayAfterTap () {
		return this.delayAfterTap;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @return the delayBeforeSwipe
	 */
	public int getDelayBeforeSwipe () {
		return this.delayBeforeSwipe;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @return the delayBeforeTap
	 */
	public int getDelayBeforeTap () {
		return this.delayBeforeTap;
	}

	/**
	 * @author wasiqb
	 * @since Oct 9, 2018
	 * @return the recordPath
	 */
	public String getRecordPath () {
		return this.recordPath;
	}

	/**
	 * @author wasiqb
	 * @since Oct 9, 2018
	 * @return the recordPrefix
	 */
	public String getRecordPrefix () {
		return this.recordPrefix;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @return the screenShotPath
	 */
	public String getScreenShotPath () {
		return this.screenShotPath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @return the screenShotPrefix
	 */
	public String getScreenShotPrefix () {
		return this.screenShotPrefix;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @return the waitForElementUntil
	 */
	public int getWaitForElementUntil () {
		return this.waitForElementUntil;
	}

	/**
	 * @author wasiqb
	 * @since Oct 9, 2018
	 * @return the record
	 */
	public boolean isRecord () {
		return this.record;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @return the screenshotOnError
	 */
	public boolean isScreenshotOnError () {
		return this.screenshotOnError;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @param defaultWait
	 *            the defaultWait to set
	 */
	public void setDefaultWait (final int defaultWait) {
		this.defaultWait = defaultWait;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @param delayAfterSwipe
	 *            the delayAfterSwipe to set
	 */
	public void setDelayAfterSwipe (final int delayAfterSwipe) {
		this.delayAfterSwipe = delayAfterSwipe;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @param delayAfterTap
	 *            the delayAfterTap to set
	 */
	public void setDelayAfterTap (final int delayAfterTap) {
		this.delayAfterTap = delayAfterTap;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @param delayBeforeSwipe
	 *            the delayBeforeSwipe to set
	 */
	public void setDelayBeforeSwipe (final int delayBeforeSwipe) {
		this.delayBeforeSwipe = delayBeforeSwipe;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @param delayBeforeTap
	 *            the delayBeforeTap to set
	 */
	public void setDelayBeforeTap (final int delayBeforeTap) {
		this.delayBeforeTap = delayBeforeTap;
	}

	/**
	 * @author wasiqb
	 * @since Oct 9, 2018
	 * @param record
	 *            the record to set
	 */
	public void setRecord (final boolean record) {
		this.record = record;
	}

	/**
	 * @author wasiqb
	 * @since Oct 9, 2018
	 * @param recordPath
	 *            the recordPath to set
	 */
	public void setRecordPath (final String recordPath) {
		this.recordPath = recordPath;
	}

	/**
	 * @author wasiqb
	 * @since Oct 9, 2018
	 * @param recordPrefix
	 *            the recordPrefix to set
	 */
	public void setRecordPrefix (final String recordPrefix) {
		this.recordPrefix = recordPrefix;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @param screenshotOnError
	 *            the screenshotOnError to set
	 */
	public void setScreenshotOnError (final boolean screenshotOnError) {
		this.screenshotOnError = screenshotOnError;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @param screenShotPath
	 *            the screenShotPath to set
	 */
	public void setScreenShotPath (final String screenShotPath) {
		this.screenShotPath = screenShotPath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @param screenShotPrefix
	 *            the screenShotPrefix to set
	 */
	public void setScreenShotPrefix (final String screenShotPrefix) {
		this.screenShotPrefix = screenShotPrefix;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:35:15 PM
	 * @param waitForElementUntil
	 *            the waitForElementUntil to set
	 */
	public void setWaitForElementUntil (final int waitForElementUntil) {
		this.waitForElementUntil = waitForElementUntil;
	}
}