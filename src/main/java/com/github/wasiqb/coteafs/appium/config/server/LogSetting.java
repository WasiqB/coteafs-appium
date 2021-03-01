/*
 *  Copyright (c) 2020, Wasiq Bhamla.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.wasiqb.coteafs.appium.config.server;

import static java.lang.System.getProperty;
import static java.lang.Thread.currentThread;
import static java.text.MessageFormat.format;

import com.github.wasiqb.coteafs.appium.config.enums.LogLevel;
import lombok.Data;

@Data
public class LogSetting {
    private static final String PATH_PATTERN = "{0}/logs/server-{1}.log";

    private boolean  asyncTrace;
    private boolean  debugSpacing;
    private LogLevel level = LogLevel.ERROR;
    private boolean  localTimezone;
    private boolean  noColors;
    private String   path  = format (PATH_PATTERN, getProperty ("user.dir"), currentThread ().getId ());
    private boolean  timestamp;
}