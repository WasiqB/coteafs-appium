/*
 * Copyright (c) 2017-2020, Wasiq Bhamla.
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

import io.appium.java_client.ios.IOSStartScreenRecordingOptions.VideoQuality;

/**
 * @author wasiqb
 * @since Oct 13, 2018
 */
public class RecordSetting {
    private int          bitRate;
    private int          duration;
    private boolean      enabled;
    private String       path;
    private String       prefix;
    private VideoQuality quality;
    private String       size;

    /**
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public RecordSetting() {
        this.duration = 3;
        this.quality = VideoQuality.MEDIUM;
        this.enabled = false;
        this.path = format("%s/videos", System.getProperty("user.dir"));
        this.prefix = "VID";
        this.bitRate = 4;
    }

    /**
     * @return the bitRate
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public int getBitRate() {
        return this.bitRate;
    }

    /**
     * @return the duration
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * @return the path
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public String getPath() {
        return this.path;
    }

    /**
     * @return the prefix
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public String getPrefix() {
        return this.prefix;
    }

    /**
     * @return the quality
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public VideoQuality getQuality() {
        return this.quality;
    }

    /**
     * @return the size
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public String getSize() {
        return this.size;
    }

    /**
     * @return the enabled
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * @param bitRate the bitRate to set
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public void setBitRate(final int bitRate) {
        this.bitRate = bitRate;
    }

    /**
     * @param duration the duration to set
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public void setDuration(final int duration) {
        this.duration = duration;
    }

    /**
     * @param enabled the enabled to set
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @param path the path to set
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public void setPath(final String path) {
        this.path = path;
    }

    /**
     * @param prefix the prefix to set
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public void setPrefix(final String prefix) {
        this.prefix = prefix;
    }

    /**
     * @param quality the quality to set
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public void setQuality(final VideoQuality quality) {
        this.quality = quality;
    }

    /**
     * @param size the size to set
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public void setSize(final String size) {
        this.size = size;
    }
}