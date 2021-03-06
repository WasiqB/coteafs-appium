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
package com.github.wasiqb.coteafs.appium.android;

import com.github.wasiqb.coteafs.appium.android.vodqa.activities.MainActivity;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 10:09:49 PM
 */
public class DefaultTest {
    protected AndroidDevice androidDevice;
    protected MainActivity  main;
    private   AppiumServer  androidServer;

    /**
     * @param server
     * @param device
     *
     * @author wasiq.bhamla
     * @since 13-Apr-2017 10:10:45 PM
     */
    @Parameters ({ "server", "device" })
    @BeforeTest (alwaysRun = true)
    public void setupTest (final String server, final String device) {
        this.androidServer = new AppiumServer (server);
        this.androidServer.start ();

        this.androidDevice = new AndroidDevice (this.androidServer, device);
        this.androidDevice.start ();
        this.androidDevice.startRecording ();
        this.androidDevice.startStreaming ();

        this.main = new MainActivity (this.androidDevice);
    }

    /**
     * @author wasiq.bhamla
     * @since 17-Apr-2017 3:47:41 PM
     */
    @AfterTest (alwaysRun = true)
    public void tearDownTest () {
        this.androidDevice.stopStreaming ();
        this.androidDevice.stopRecording ();
        this.androidDevice.stop ();
        this.androidServer.stop ();
    }
}