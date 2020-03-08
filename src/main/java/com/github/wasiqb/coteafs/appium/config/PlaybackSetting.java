/*
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
    private int           defaultWait;
    private int           delayAfterSwipe;
    private int           delayAfterTap;
    private long          delayBeforeSwipe;
    private int           delayBeforeTap;
    private RecordSetting record;
    private String        screenShotPath;
    private String        screenShotPrefix;
    private boolean       screenshotOnError;
    private int           waitForElementUntil;

    /**
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:34:51 PM
     */
    public PlaybackSetting() {
        this.defaultWait = 30;
        this.waitForElementUntil = 30;
        this.delayBeforeTap = 0;
        this.delayAfterTap = 0;
        this.delayBeforeSwipe = 0;
        this.delayAfterSwipe = 0;
        this.screenShotPath = format("%s/screenshots", System.getProperty("user.dir"));
        this.screenShotPrefix = "SCR";
        this.record = new RecordSetting();
        this.screenshotOnError = false;
    }

    /**
     * @return the defaultWait
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public int getDefaultWait() {
        return this.defaultWait;
    }

    /**
     * @return the delayAfterSwipe
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public int getDelayAfterSwipe() {
        return this.delayAfterSwipe;
    }

    /**
     * @return the delayAfterTap
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public int getDelayAfterTap() {
        return this.delayAfterTap;
    }

    /**
     * @return the delayBeforeSwipe
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public long getDelayBeforeSwipe() {
        return this.delayBeforeSwipe;
    }

    /**
     * @return the delayBeforeTap
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public int getDelayBeforeTap() {
        return this.delayBeforeTap;
    }

    /**
     * @return the record
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public RecordSetting getRecord() {
        return this.record;
    }

    /**
     * @return the screenShotPath
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public String getScreenShotPath() {
        return this.screenShotPath;
    }

    /**
     * @return the screenShotPrefix
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public String getScreenShotPrefix() {
        return this.screenShotPrefix;
    }

    /**
     * @return the waitForElementUntil
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public int getWaitForElementUntil() {
        return this.waitForElementUntil;
    }

    /**
     * @return the screenshotOnError
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public boolean isScreenshotOnError() {
        return this.screenshotOnError;
    }

    /**
     * @param defaultWait the defaultWait to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public void setDefaultWait(final int defaultWait) {
        this.defaultWait = defaultWait;
    }

    /**
     * @param delayAfterSwipe the delayAfterSwipe to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public void setDelayAfterSwipe(final int delayAfterSwipe) {
        this.delayAfterSwipe = delayAfterSwipe;
    }

    /**
     * @param delayAfterTap the delayAfterTap to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public void setDelayAfterTap(final int delayAfterTap) {
        this.delayAfterTap = delayAfterTap;
    }

    /**
     * @param delayBeforeSwipe the delayBeforeSwipe to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public void setDelayBeforeSwipe(final long delayBeforeSwipe) {
        this.delayBeforeSwipe = delayBeforeSwipe;
    }

    /**
     * @param delayBeforeTap the delayBeforeTap to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public void setDelayBeforeTap(final int delayBeforeTap) {
        this.delayBeforeTap = delayBeforeTap;
    }

    /**
     * @param record the record to set
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public void setRecord(final RecordSetting record) {
        this.record = record;
    }

    /**
     * @param screenShotPath the screenShotPath to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public void setScreenShotPath(final String screenShotPath) {
        this.screenShotPath = screenShotPath;
    }

    /**
     * @param screenShotPrefix the screenShotPrefix to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public void setScreenShotPrefix(final String screenShotPrefix) {
        this.screenShotPrefix = screenShotPrefix;
    }

    /**
     * @param screenshotOnError the screenshotOnError to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public void setScreenshotOnError(final boolean screenshotOnError) {
        this.screenshotOnError = screenshotOnError;
    }

    /**
     * @param waitForElementUntil the waitForElementUntil to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:35:15 PM
     */
    public void setWaitForElementUntil(final int waitForElementUntil) {
        this.waitForElementUntil = waitForElementUntil;
    }
}