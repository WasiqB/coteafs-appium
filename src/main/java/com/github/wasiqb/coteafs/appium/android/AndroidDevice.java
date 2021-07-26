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

import com.github.wasiqb.coteafs.appium.config.device.android.AndroidVideoSetting;
import com.github.wasiqb.coteafs.appium.device.Device;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.android.AndroidStopScreenRecordingOptions;
import io.appium.java_client.android.AndroidTouchAction;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 5:32:01 PM
 */
public class AndroidDevice extends Device<AndroidDriver<MobileElement>, AndroidTouchAction> {
    /**
     * @param server Server instance
     * @param name Device name
     *
     * @author wasiq.bhamla
     * @since 13-Apr-2017 9:12:47 PM
     */
    public AndroidDevice (final AppiumServer server, final String name) {
        super (server, name);
    }

    /*
     * (non-Javadoc)
     * @see com.github.wasiqb.coteafs.appium.device.Device#startRecordSetting()
     */
    @SuppressWarnings ("unchecked")
    @Override
    protected AndroidStartScreenRecordingOptions startRecordSetting () {
        final AndroidStartScreenRecordingOptions options = AndroidStartScreenRecordingOptions.startScreenRecordingOptions ();
        final AndroidVideoSetting record = this.setting.getPlayback ()
            .getRecording ()
            .getAndroid ();
        if (record.getBitRate () != 4) {
            options.withBitRate (record.getBitRate ());
        }
        if (record.getSize () != null) {
            options.withVideoSize (record.getSize ());
        }
        return options;
    }

    /*
     * (non-Javadoc)
     * @see com.github.wasiqb.coteafs.appium.device.Device#stopRecordSetting()
     */
    @SuppressWarnings ("unchecked")
    @Override
    protected AndroidStopScreenRecordingOptions stopRecordSetting () {
        return AndroidStopScreenRecordingOptions.stopScreenRecordingOptions ();
    }
}