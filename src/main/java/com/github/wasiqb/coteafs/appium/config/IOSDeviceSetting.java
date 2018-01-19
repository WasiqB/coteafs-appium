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
 * @since Jan 18, 2018 9:11:11 PM
 */
public class IOSDeviceSetting {
	private String	agentPath;
	private String	appName;
	private boolean	autoAcceptAlerts;
	private boolean	autoDismissAlerts;
	private String	bootstrapPath;
	private String	bundleId;
	private long	launchTimeout;
	private boolean	showXcodeLog;
	private String	signingId;
	private String	teamId;
	private String	updatedWdaBundleId;
	private boolean	useNewWda;
	private boolean	usePrebuiltWda;
	private long	wdaConnectionTimeout;
	private int		wdaLocalPort;
	private int		wdaStartupRetries;
	private long	wdaStartupRetryInterval;

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:34:13 PM
	 */
	public IOSDeviceSetting () {
		this.showXcodeLog = false;
		this.useNewWda = false;
		this.usePrebuiltWda = false;
		this.wdaLocalPort = 8100;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the agentPath
	 */
	public String getAgentPath () {
		return this.agentPath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the appName
	 */
	public String getAppName () {
		return this.appName;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the bootstrapPath
	 */
	public String getBootstrapPath () {
		return this.bootstrapPath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the bundleId
	 */
	public String getBundleId () {
		return this.bundleId;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 19, 2018 9:34:41 PM
	 * @return the launchTimeout
	 */
	public long getLaunchTimeout () {
		return this.launchTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the signingId
	 */
	public String getSigningId () {
		return this.signingId;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the teamId
	 */
	public String getTeamId () {
		return this.teamId;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the updatedWdaBundleId
	 */
	public String getUpdatedWdaBundleId () {
		return this.updatedWdaBundleId;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the wdaConnectionTimeout
	 */
	public long getWdaConnectionTimeout () {
		return this.wdaConnectionTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 19, 2018 9:25:52 PM
	 * @return the wdaLocalPort
	 */
	public int getWdaLocalPort () {
		return this.wdaLocalPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the wdaStartupRetries
	 */
	public int getWdaStartupRetries () {
		return this.wdaStartupRetries;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the wdaStartupRetryInterval
	 */
	public long getWdaStartupRetryInterval () {
		return this.wdaStartupRetryInterval;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the autoAcceptAlerts
	 */
	public boolean isAutoAcceptAlerts () {
		return this.autoAcceptAlerts;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the autoDismissAlerts
	 */
	public boolean isAutoDismissAlerts () {
		return this.autoDismissAlerts;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the showXcodeLog
	 */
	public boolean isShowXcodeLog () {
		return this.showXcodeLog;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the useNewWda
	 */
	public boolean isUseNewWda () {
		return this.useNewWda;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @return the usePrebuiltWda
	 */
	public boolean isUsePrebuiltWda () {
		return this.usePrebuiltWda;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param agentPath
	 *            the agentPath to set
	 */
	public void setAgentPath (final String agentPath) {
		this.agentPath = agentPath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param appName
	 *            the appName to set
	 */
	public void setAppName (final String appName) {
		this.appName = appName;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param autoAcceptAlerts
	 *            the autoAcceptAlerts to set
	 */
	public void setAutoAcceptAlerts (final boolean autoAcceptAlerts) {
		this.autoAcceptAlerts = autoAcceptAlerts;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param autoDismissAlerts
	 *            the autoDismissAlerts to set
	 */
	public void setAutoDismissAlerts (final boolean autoDismissAlerts) {
		this.autoDismissAlerts = autoDismissAlerts;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param bootstrapPath
	 *            the bootstrapPath to set
	 */
	public void setBootstrapPath (final String bootstrapPath) {
		this.bootstrapPath = bootstrapPath;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param bundleId
	 *            the bundleId to set
	 */
	public void setBundleId (final String bundleId) {
		this.bundleId = bundleId;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 19, 2018 9:34:41 PM
	 * @param launchTimeout
	 *            the launchTimeout to set
	 */
	public void setLaunchTimeout (final long launchTimeout) {
		this.launchTimeout = launchTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param showXcodeLog
	 *            the showXcodeLog to set
	 */
	public void setShowXcodeLog (final boolean showXcodeLog) {
		this.showXcodeLog = showXcodeLog;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param signingId
	 *            the signingId to set
	 */
	public void setSigningId (final String signingId) {
		this.signingId = signingId;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param teamId
	 *            the teamId to set
	 */
	public void setTeamId (final String teamId) {
		this.teamId = teamId;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param updatedWdaBundleId
	 *            the updatedWdaBundleId to set
	 */
	public void setUpdatedWdaBundleId (final String updatedWdaBundleId) {
		this.updatedWdaBundleId = updatedWdaBundleId;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param useNewWda
	 *            the useNewWda to set
	 */
	public void setUseNewWda (final boolean useNewWda) {
		this.useNewWda = useNewWda;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param usePrebuiltWda
	 *            the usePrebuiltWda to set
	 */
	public void setUsePrebuiltWda (final boolean usePrebuiltWda) {
		this.usePrebuiltWda = usePrebuiltWda;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param wdaConnectionTimeout
	 *            the wdaConnectionTimeout to set
	 */
	public void setWdaConnectionTimeout (final long wdaConnectionTimeout) {
		this.wdaConnectionTimeout = wdaConnectionTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 19, 2018 9:25:52 PM
	 * @param wdaLocalPort
	 *            the wdaLocalPort to set
	 */
	public void setWdaLocalPort (final int wdaLocalPort) {
		this.wdaLocalPort = wdaLocalPort;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param wdaStartupRetries
	 *            the wdaStartupRetries to set
	 */
	public void setWdaStartupRetries (final int wdaStartupRetries) {
		this.wdaStartupRetries = wdaStartupRetries;
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 18, 2018 9:33:28 PM
	 * @param wdaStartupRetryInterval
	 *            the wdaStartupRetryInterval to set
	 */
	public void setWdaStartupRetryInterval (final long wdaStartupRetryInterval) {
		this.wdaStartupRetryInterval = wdaStartupRetryInterval;
	}
}