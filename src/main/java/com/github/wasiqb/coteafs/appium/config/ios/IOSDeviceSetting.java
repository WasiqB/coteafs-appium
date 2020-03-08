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
package com.github.wasiqb.coteafs.appium.config.ios;

/**
 * @author wasiq.bhamla
 * @since Jan 18, 2018 9:11:11 PM
 */
public class IOSDeviceSetting {
    private String  agentPath;
    private String  appName;
    private boolean autoAcceptAlerts;
    private boolean autoDismissAlerts;
    private String  bootstrapPath;
    private String  bundleId;
    private long    launchTimeout;
    private boolean showXcodeLog;
    private String  signingId;
    private String  teamId;
    private String  updatedWdaBundleId;
    private boolean useNewWda;
    private boolean usePrebuiltWda;
    private long    wdaConnectionTimeout;
    private int     wdaLocalPort;
    private int     wdaStartupRetries;
    private long    wdaStartupRetryInterval;

    /**
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:34:13 PM
     */
    public IOSDeviceSetting() {
        this.showXcodeLog = false;
        this.useNewWda = false;
        this.usePrebuiltWda = false;
        this.wdaLocalPort = 8100;
    }

    /**
     * @return the agentPath
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public String getAgentPath() {
        return this.agentPath;
    }

    /**
     * @return the appName
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public String getAppName() {
        return this.appName;
    }

    /**
     * @return the bootstrapPath
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public String getBootstrapPath() {
        return this.bootstrapPath;
    }

    /**
     * @return the bundleId
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public String getBundleId() {
        return this.bundleId;
    }

    /**
     * @return the launchTimeout
     * @author wasiq.bhamla
     * @since Jan 19, 2018 9:34:41 PM
     */
    public long getLaunchTimeout() {
        return this.launchTimeout;
    }

    /**
     * @return the signingId
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public String getSigningId() {
        return this.signingId;
    }

    /**
     * @return the teamId
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public String getTeamId() {
        return this.teamId;
    }

    /**
     * @return the updatedWdaBundleId
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public String getUpdatedWdaBundleId() {
        return this.updatedWdaBundleId;
    }

    /**
     * @return the wdaConnectionTimeout
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public long getWdaConnectionTimeout() {
        return this.wdaConnectionTimeout;
    }

    /**
     * @return the wdaLocalPort
     * @author wasiq.bhamla
     * @since Jan 19, 2018 9:25:52 PM
     */
    public int getWdaLocalPort() {
        return this.wdaLocalPort;
    }

    /**
     * @return the wdaStartupRetries
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public int getWdaStartupRetries() {
        return this.wdaStartupRetries;
    }

    /**
     * @return the wdaStartupRetryInterval
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public long getWdaStartupRetryInterval() {
        return this.wdaStartupRetryInterval;
    }

    /**
     * @return the autoAcceptAlerts
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public boolean isAutoAcceptAlerts() {
        return this.autoAcceptAlerts;
    }

    /**
     * @return the autoDismissAlerts
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public boolean isAutoDismissAlerts() {
        return this.autoDismissAlerts;
    }

    /**
     * @return the showXcodeLog
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public boolean isShowXcodeLog() {
        return this.showXcodeLog;
    }

    /**
     * @return the useNewWda
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public boolean isUseNewWda() {
        return this.useNewWda;
    }

    /**
     * @return the usePrebuiltWda
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public boolean isUsePrebuiltWda() {
        return this.usePrebuiltWda;
    }

    /**
     * @param agentPath the agentPath to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setAgentPath(final String agentPath) {
        this.agentPath = agentPath;
    }

    /**
     * @param appName the appName to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setAppName(final String appName) {
        this.appName = appName;
    }

    /**
     * @param autoAcceptAlerts the autoAcceptAlerts to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setAutoAcceptAlerts(final boolean autoAcceptAlerts) {
        this.autoAcceptAlerts = autoAcceptAlerts;
    }

    /**
     * @param autoDismissAlerts the autoDismissAlerts to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setAutoDismissAlerts(final boolean autoDismissAlerts) {
        this.autoDismissAlerts = autoDismissAlerts;
    }

    /**
     * @param bootstrapPath the bootstrapPath to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setBootstrapPath(final String bootstrapPath) {
        this.bootstrapPath = bootstrapPath;
    }

    /**
     * @param bundleId the bundleId to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setBundleId(final String bundleId) {
        this.bundleId = bundleId;
    }

    /**
     * @param launchTimeout the launchTimeout to set
     * @author wasiq.bhamla
     * @since Jan 19, 2018 9:34:41 PM
     */
    public void setLaunchTimeout(final long launchTimeout) {
        this.launchTimeout = launchTimeout;
    }

    /**
     * @param showXcodeLog the showXcodeLog to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setShowXcodeLog(final boolean showXcodeLog) {
        this.showXcodeLog = showXcodeLog;
    }

    /**
     * @param signingId the signingId to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setSigningId(final String signingId) {
        this.signingId = signingId;
    }

    /**
     * @param teamId the teamId to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setTeamId(final String teamId) {
        this.teamId = teamId;
    }

    /**
     * @param updatedWdaBundleId the updatedWdaBundleId to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setUpdatedWdaBundleId(final String updatedWdaBundleId) {
        this.updatedWdaBundleId = updatedWdaBundleId;
    }

    /**
     * @param useNewWda the useNewWda to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setUseNewWda(final boolean useNewWda) {
        this.useNewWda = useNewWda;
    }

    /**
     * @param usePrebuiltWda the usePrebuiltWda to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setUsePrebuiltWda(final boolean usePrebuiltWda) {
        this.usePrebuiltWda = usePrebuiltWda;
    }

    /**
     * @param wdaConnectionTimeout the wdaConnectionTimeout to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setWdaConnectionTimeout(final long wdaConnectionTimeout) {
        this.wdaConnectionTimeout = wdaConnectionTimeout;
    }

    /**
     * @param wdaLocalPort the wdaLocalPort to set
     * @author wasiq.bhamla
     * @since Jan 19, 2018 9:25:52 PM
     */
    public void setWdaLocalPort(final int wdaLocalPort) {
        this.wdaLocalPort = wdaLocalPort;
    }

    /**
     * @param wdaStartupRetries the wdaStartupRetries to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setWdaStartupRetries(final int wdaStartupRetries) {
        this.wdaStartupRetries = wdaStartupRetries;
    }

    /**
     * @param wdaStartupRetryInterval the wdaStartupRetryInterval to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 9:33:28 PM
     */
    public void setWdaStartupRetryInterval(final long wdaStartupRetryInterval) {
        this.wdaStartupRetryInterval = wdaStartupRetryInterval;
    }
}