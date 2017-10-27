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

/**
 * @author wasiq.bhamla
 * @since Oct 27, 2017 1:26:27 PM
 */
public class ServerArgumentSetting {
	private int			backendRetries;
	private int			bootstrapPort;
	private String		chromeDriverExePath;
	private int			chromeDriverPort;
	private String		ipaAbsolutePath;
	private boolean		localTimeZone;
	private LogLevel	logLevel;
	private boolean		logTimeStamp;
	private String		nodeConfigFile;
	private boolean		safari;
	private boolean		sessionOverride;
	private boolean		suppressAdbKillServer;
	private int			wdaPort;
	private int			webkitDebugProxyPort;

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:26:27 PM
	 */
	public ServerArgumentSetting () {
		this.logLevel = LogLevel.ERROR;
		this.backendRetries = 3;
		this.wdaPort = 8100;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @return the backendRetries
	 */
	public int getBackendRetries () {
		return this.backendRetries;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @return the bootstrapPort
	 */
	public int getBootstrapPort () {
		return this.bootstrapPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @return the chromeDriverExePath
	 */
	public String getChromeDriverExePath () {
		return this.chromeDriverExePath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @return the chromeDriverPort
	 */
	public int getChromeDriverPort () {
		return this.chromeDriverPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @return the ipaAbsolutePath
	 */
	public String getIpaAbsolutePath () {
		return this.ipaAbsolutePath;
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
	 * @since Oct 27, 2017 2:59:11 PM
	 * @return the wdaPort
	 */
	public int getWdaPort () {
		return this.wdaPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @return the webkitDebugProxyPort
	 */
	public int getWebkitDebugProxyPort () {
		return this.webkitDebugProxyPort;
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
	 * @return the safari
	 */
	public boolean isSafari () {
		return this.safari;
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
	 * @since Oct 27, 2017 1:37:02 PM
	 * @return the suppressAdbKillServer
	 */
	public boolean isSuppressAdbKillServer () {
		return this.suppressAdbKillServer;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @param backendRetries
	 *            the backendRetries to set
	 */
	public void setBackendRetries (final int backendRetries) {
		this.backendRetries = backendRetries;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @param bootstrapPort
	 *            the bootstrapPort to set
	 */
	public void setBootstrapPort (final int bootstrapPort) {
		this.bootstrapPort = bootstrapPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @param chromeDriverExePath
	 *            the chromeDriverExePath to set
	 */
	public void setChromeDriverExePath (final String chromeDriverExePath) {
		this.chromeDriverExePath = chromeDriverExePath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @param chromeDriverPort
	 *            the chromeDriverPort to set
	 */
	public void setChromeDriverPort (final int chromeDriverPort) {
		this.chromeDriverPort = chromeDriverPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @param ipaAbsolutePath
	 *            the ipaAbsolutePath to set
	 */
	public void setIpaAbsolutePath (final String ipaAbsolutePath) {
		this.ipaAbsolutePath = ipaAbsolutePath;
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
	 * @param safari
	 *            the safari to set
	 */
	public void setSafari (final boolean safari) {
		this.safari = safari;
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

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @param suppressAdbKillServer
	 *            the suppressAdbKillServer to set
	 */
	public void setSuppressAdbKillServer (final boolean suppressAdbKillServer) {
		this.suppressAdbKillServer = suppressAdbKillServer;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 3:20:32 PM
	 * @param wdaPort
	 *            the wdaPort to set
	 */
	public void setWdaPort (final int wdaPort) {
		this.wdaPort = wdaPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Oct 27, 2017 1:37:02 PM
	 * @param webkitDebugProxyPort
	 *            the webkitDebugProxyPort to set
	 */
	public void setWebkitDebugProxyPort (final int webkitDebugProxyPort) {
		this.webkitDebugProxyPort = webkitDebugProxyPort;
	}
}