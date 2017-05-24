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
 * @since 12-Apr-2017 8:43:22 PM
 */
public class ServerSetting {
	private String	appiumJsPath;
	private boolean	external;
	private boolean	fullReset;
	private String	ip;
	private boolean	noReset;
	private int		port;
	private int		sessionTimeout;
	private long	startUpTimeOutSeconds;

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:49:49 PM
	 */
	public ServerSetting () {
		this.external = false;
		this.noReset = false;
		this.fullReset = false;
		this.sessionTimeout = 120;
		this.startUpTimeOutSeconds = 60;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 09-May-2017 3:46:11 PM
	 * @return the appiumJsPath
	 */
	public String getAppiumJsPath () {
		return this.appiumJsPath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @return the ip
	 */
	public String getIp () {
		return this.ip;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @return the port
	 */
	public int getPort () {
		return this.port;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:49:31 PM
	 * @return the sessionTimeout
	 */
	public int getSessionTimeout () {
		return this.sessionTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @return the startUpTimeOutSeconds
	 */
	public long getStartUpTimeOutSeconds () {
		return this.startUpTimeOutSeconds;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 21-Apr-2017 5:06:22 PM
	 * @return the external
	 */
	public boolean isExternal () {
		return this.external;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:56:41 PM
	 * @return the fullReset
	 */
	public boolean isFullReset () {
		return this.fullReset;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @return the noReset
	 */
	public boolean isNoReset () {
		return this.noReset;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 09-May-2017 3:46:11 PM
	 * @param appiumJsPath
	 *            the appiumJsPath to set
	 */
	public void setAppiumJsPath (final String appiumJsPath) {
		this.appiumJsPath = appiumJsPath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 21-Apr-2017 5:06:22 PM
	 * @param external
	 *            the external to set
	 */
	public void setExternal (final boolean external) {
		this.external = external;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:56:52 PM
	 * @param fullReset
	 *            the fullReset to set
	 */
	public void setFullReset (final boolean fullReset) {
		this.fullReset = fullReset;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @param ip
	 *            the ip to set
	 */
	public void setIp (final String ip) {
		this.ip = ip;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @param noReset
	 *            the noReset to set
	 */
	public void setNoReset (final boolean noReset) {
		this.noReset = noReset;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @param port
	 *            the port to set
	 */
	public void setPort (final int port) {
		this.port = port;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:49:31 PM
	 * @param sessionTimeout
	 *            the sessionTimeout to set
	 */
	public void setSessionTimeout (final int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @param startUpTimeOutSeconds
	 *            the startUpTimeOutSeconds to set
	 */
	public void setStartUpTimeOutSeconds (final long startUpTimeOutSeconds) {
		this.startUpTimeOutSeconds = startUpTimeOutSeconds;
	}
}