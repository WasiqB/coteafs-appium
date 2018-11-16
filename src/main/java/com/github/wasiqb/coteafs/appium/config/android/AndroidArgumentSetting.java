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
package com.github.wasiqb.coteafs.appium.config.android;

/**
 * @author wasiq.bhamla
 * @since Jan 18, 2018 8:55:02 PM
 */
public class AndroidArgumentSetting {
	private int		bootstrapPort;
	private String	chromeDriverExePath;
	private int		chromeDriverPort;
	private boolean	suppressAdbKillServer;

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:57:34 PM
	 * @return the bootstrapPort
	 */
	public int getBootstrapPort () {
		return this.bootstrapPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:57:34 PM
	 * @return the chromeDriverExePath
	 */
	public String getChromeDriverExePath () {
		return this.chromeDriverExePath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:57:34 PM
	 * @return the chromeDriverPort
	 */
	public int getChromeDriverPort () {
		return this.chromeDriverPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:57:34 PM
	 * @return the suppressAdbKillServer
	 */
	public boolean isSuppressAdbKillServer () {
		return this.suppressAdbKillServer;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:57:34 PM
	 * @param bootstrapPort
	 *            the bootstrapPort to set
	 */
	public void setBootstrapPort (final int bootstrapPort) {
		this.bootstrapPort = bootstrapPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:57:34 PM
	 * @param chromeDriverExePath
	 *            the chromeDriverExePath to set
	 */
	public void setChromeDriverExePath (final String chromeDriverExePath) {
		this.chromeDriverExePath = chromeDriverExePath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:57:34 PM
	 * @param chromeDriverPort
	 *            the chromeDriverPort to set
	 */
	public void setChromeDriverPort (final int chromeDriverPort) {
		this.chromeDriverPort = chromeDriverPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:57:34 PM
	 * @param suppressAdbKillServer
	 *            the suppressAdbKillServer to set
	 */
	public void setSuppressAdbKillServer (final boolean suppressAdbKillServer) {
		this.suppressAdbKillServer = suppressAdbKillServer;
	}
}