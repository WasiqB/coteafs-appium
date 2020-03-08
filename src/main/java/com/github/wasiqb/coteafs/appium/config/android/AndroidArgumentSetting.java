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
package com.github.wasiqb.coteafs.appium.config.android;

/**
 * @author wasiq.bhamla
 * @since Jan 18, 2018 8:55:02 PM
 */
public class AndroidArgumentSetting {
    private int     bootstrapPort;
    private String  chromeDriverExePath;
    private int     chromeDriverPort;
    private boolean suppressAdbKillServer;

    /**
     * @return the bootstrapPort
     * @author wasiq.bhamla
     * @since Jan 18, 2018 8:57:34 PM
     */
    public int getBootstrapPort() {
        return this.bootstrapPort;
    }

    /**
     * @return the chromeDriverExePath
     * @author wasiq.bhamla
     * @since Jan 18, 2018 8:57:34 PM
     */
    public String getChromeDriverExePath() {
        return this.chromeDriverExePath;
    }

    /**
     * @return the chromeDriverPort
     * @author wasiq.bhamla
     * @since Jan 18, 2018 8:57:34 PM
     */
    public int getChromeDriverPort() {
        return this.chromeDriverPort;
    }

    /**
     * @return the suppressAdbKillServer
     * @author wasiq.bhamla
     * @since Jan 18, 2018 8:57:34 PM
     */
    public boolean isSuppressAdbKillServer() {
        return this.suppressAdbKillServer;
    }

    /**
     * @param bootstrapPort the bootstrapPort to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 8:57:34 PM
     */
    public void setBootstrapPort(final int bootstrapPort) {
        this.bootstrapPort = bootstrapPort;
    }

    /**
     * @param chromeDriverExePath the chromeDriverExePath to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 8:57:34 PM
     */
    public void setChromeDriverExePath(final String chromeDriverExePath) {
        this.chromeDriverExePath = chromeDriverExePath;
    }

    /**
     * @param chromeDriverPort the chromeDriverPort to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 8:57:34 PM
     */
    public void setChromeDriverPort(final int chromeDriverPort) {
        this.chromeDriverPort = chromeDriverPort;
    }

    /**
     * @param suppressAdbKillServer the suppressAdbKillServer to set
     * @author wasiq.bhamla
     * @since Jan 18, 2018 8:57:34 PM
     */
    public void setSuppressAdbKillServer(final boolean suppressAdbKillServer) {
        this.suppressAdbKillServer = suppressAdbKillServer;
    }
}