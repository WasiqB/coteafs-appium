/**
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
	private int				bitRate;
	private int				duration;
	private boolean			enabled;
	private String			path;
	private String			prefix;
	private VideoQuality	quality;
	private String			size;

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 */
	public RecordSetting () {
		this.duration = 3;
		this.quality = VideoQuality.MEDIUM;
		this.enabled = false;
		this.path = format ("%s/videos", System.getProperty ("user.dir"));
		this.prefix = "VID";
		this.bitRate = 4;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @return the bitRate
	 */
	public int getBitRate () {
		return this.bitRate;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @return the duration
	 */
	public int getDuration () {
		return this.duration;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @return the path
	 */
	public String getPath () {
		return this.path;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @return the prefix
	 */
	public String getPrefix () {
		return this.prefix;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @return the quality
	 */
	public VideoQuality getQuality () {
		return this.quality;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @return the size
	 */
	public String getSize () {
		return this.size;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @return the enabled
	 */
	public boolean isEnabled () {
		return this.enabled;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @param bitRate
	 *            the bitRate to set
	 */
	public void setBitRate (final int bitRate) {
		this.bitRate = bitRate;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration (final int duration) {
		this.duration = duration;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled (final boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @param path
	 *            the path to set
	 */
	public void setPath (final String path) {
		this.path = path;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @param prefix
	 *            the prefix to set
	 */
	public void setPrefix (final String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @param quality
	 *            the quality to set
	 */
	public void setQuality (final VideoQuality quality) {
		this.quality = quality;
	}

	/**
	 * @author wasiqb
	 * @since Oct 13, 2018
	 * @param size
	 *            the size to set
	 */
	public void setSize (final String size) {
		this.size = size;
	}
}