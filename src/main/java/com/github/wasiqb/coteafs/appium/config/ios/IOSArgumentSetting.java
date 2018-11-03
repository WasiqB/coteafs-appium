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
package com.github.wasiqb.coteafs.appium.config.ios;

/**
 * @author wasiq.bhamla
 * @since Jan 18, 2018 8:57:52 PM
 */
public class IOSArgumentSetting {
	private int		backendRetries;
	private String	ipaAbsolutePath;
	private boolean	safari;
	private int		wdaPort;
	private int		webkitDebugProxyPort;

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:59:34 PM
	 */
	public IOSArgumentSetting () {
		this.backendRetries = 3;
		this.wdaPort = 8100;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:59:54 PM
	 * @return the backendRetries
	 */
	public int getBackendRetries () {
		return this.backendRetries;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:59:54 PM
	 * @return the ipaAbsolutePath
	 */
	public String getIpaAbsolutePath () {
		return this.ipaAbsolutePath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:59:55 PM
	 * @return the wdaPort
	 */
	public int getWdaPort () {
		return this.wdaPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:59:55 PM
	 * @return the webkitDebugProxyPort
	 */
	public int getWebkitDebugProxyPort () {
		return this.webkitDebugProxyPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:59:54 PM
	 * @return the safari
	 */
	public boolean isSafari () {
		return this.safari;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:59:54 PM
	 * @param backendRetries
	 *            the backendRetries to set
	 */
	public void setBackendRetries (final int backendRetries) {
		this.backendRetries = backendRetries;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:59:54 PM
	 * @param ipaAbsolutePath
	 *            the ipaAbsolutePath to set
	 */
	public void setIpaAbsolutePath (final String ipaAbsolutePath) {
		this.ipaAbsolutePath = ipaAbsolutePath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:59:54 PM
	 * @param safari
	 *            the safari to set
	 */
	public void setSafari (final boolean safari) {
		this.safari = safari;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:59:55 PM
	 * @param wdaPort
	 *            the wdaPort to set
	 */
	public void setWdaPort (final int wdaPort) {
		this.wdaPort = wdaPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 8:59:55 PM
	 * @param webkitDebugProxyPort
	 *            the webkitDebugProxyPort to set
	 */
	public void setWebkitDebugProxyPort (final int webkitDebugProxyPort) {
		this.webkitDebugProxyPort = webkitDebugProxyPort;
	}
}