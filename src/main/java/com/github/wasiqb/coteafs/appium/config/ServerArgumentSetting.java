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

import com.github.wasiqb.coteafs.appium.config.android.AndroidArgumentSetting;
import com.github.wasiqb.coteafs.appium.config.enums.LogLevel;
import com.github.wasiqb.coteafs.appium.config.ios.IOSArgumentSetting;

/**
 * @author wasiq.bhamla
 * @since Oct 27, 2017 1:26:27 PM
 */
public class ServerArgumentSetting {
	private AndroidArgumentSetting	android;
	private String					callbackIp;
	private int						callbackPort;
	private IOSArgumentSetting		ios;
	private boolean					localTimeZone;
	private LogLevel				logLevel;
	private boolean					logTimeStamp;
	private String					nodeConfigFile;
	private boolean					sessionOverride;

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:26:27 PM
	 */
	public ServerArgumentSetting () {
		this.logLevel = LogLevel.ERROR;
		this.android = new AndroidArgumentSetting ();
		this.ios = new IOSArgumentSetting ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:02:13 PM
	 * @return the android
	 */
	public AndroidArgumentSetting getAndroid () {
		return this.android;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Nov 20, 2017 11:26:54 PM
	 * @return the callbackIp
	 */
	public String getCallbackIp () {
		return this.callbackIp;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Nov 20, 2017 11:26:54 PM
	 * @return the callbackPort
	 */
	public int getCallbackPort () {
		return this.callbackPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:02:13 PM
	 * @return the ios
	 */
	public IOSArgumentSetting getIos () {
		return this.ios;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @return the logLevel
	 */
	public LogLevel getLogLevel () {
		return this.logLevel;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @return the nodeConfigFile
	 */
	public String getNodeConfigFile () {
		return this.nodeConfigFile;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @return the localTimeZone
	 */
	public boolean isLocalTimeZone () {
		return this.localTimeZone;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @return the logTimeStamp
	 */
	public boolean isLogTimeStamp () {
		return this.logTimeStamp;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @return the sessionOverride
	 */
	public boolean isSessionOverride () {
		return this.sessionOverride;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:02:13 PM
	 * @param android
	 *            the android to set
	 */
	public void setAndroid (final AndroidArgumentSetting android) {
		this.android = android;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Nov 20, 2017 11:26:54 PM
	 * @param callbackIp
	 *            the callbackIp to set
	 */
	public void setCallbackIp (final String callbackIp) {
		this.callbackIp = callbackIp;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Nov 20, 2017 11:26:54 PM
	 * @param callbackPort
	 *            the callbackPort to set
	 */
	public void setCallbackPort (final int callbackPort) {
		this.callbackPort = callbackPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:02:13 PM
	 * @param ios
	 *            the ios to set
	 */
	public void setIos (final IOSArgumentSetting ios) {
		this.ios = ios;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @param localTimeZone
	 *            the localTimeZone to set
	 */
	public void setLocalTimeZone (final boolean localTimeZone) {
		this.localTimeZone = localTimeZone;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @param logLevel
	 *            the logLevel to set
	 */
	public void setLogLevel (final LogLevel logLevel) {
		this.logLevel = logLevel;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @param logTimeStamp
	 *            the logTimeStamp to set
	 */
	public void setLogTimeStamp (final boolean logTimeStamp) {
		this.logTimeStamp = logTimeStamp;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @param nodeConfigFile
	 *            the nodeConfigFile to set
	 */
	public void setNodeConfigFile (final String nodeConfigFile) {
		this.nodeConfigFile = nodeConfigFile;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @param sessionOverride
	 *            the sessionOverride to set
	 */
	public void setSessionOverride (final boolean sessionOverride) {
		this.sessionOverride = sessionOverride;
	}
}