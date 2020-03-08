/*
 * Copyright (c) 2017-2020, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.appium.utils;

import static java.lang.String.format;
import static org.apache.commons.io.FileUtils.writeByteArrayToFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;

import com.github.wasiqb.coteafs.appium.config.RecordSetting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author wasiqb
 * @since Oct 13, 2018
 */
public class ScreenRecorder {
    private static final Logger LOG = LogManager.getLogger(ScreenRecorder.class);

    /**
     * @param content
     * @param setting
     * @author wasiqb
     * @since Oct 13, 2018
     */
    public static void saveRecording(final String content, final RecordSetting setting) {
        final byte[] decode = Base64.getDecoder()
            .decode(content);
        try {
            final String path = setting.getPath();
            final String prefix = setting.getPrefix();
            final SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd-HHmmss");
            final String timeStamp = date.format(Calendar.getInstance()
                .getTime());
            final String fileName = format("%s/%s-%s.%s", path, prefix, timeStamp, "mp4");
            LOG.info("Saving video recording to [{}] path...", fileName);
            writeByteArrayToFile(new File(fileName), decode);
        } catch (final IOException e) {
            LOG.error("Error occurred while saving video recording...");
            LOG.catching(e);
        }
    }

    private ScreenRecorder() {
        // Utility class.
    }
}