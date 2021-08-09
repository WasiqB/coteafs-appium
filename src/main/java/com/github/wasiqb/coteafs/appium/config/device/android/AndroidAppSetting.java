/*
 *
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
 *
 */
package com.github.wasiqb.coteafs.appium.config.device.android;

import static com.github.wasiqb.coteafs.appium.config.enums.ApplicationType.NATIVE;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import java.util.List;

import com.github.wasiqb.coteafs.appium.config.enums.ApplicationType;
import lombok.Data;

/**
 * @author Wasiq Bhamla
 * @since Mar 13, 2021
 */
@Data
public class AndroidAppSetting {
    private String          activityName   = EMPTY;
    private boolean         external;
    private boolean         grantPermission;
    private boolean         ignoreUnimportantViews;
    private long            installTimeout = 90000;
    private boolean         noStopOnReset;
    private List<String>    otherApps;
    private String          packageName    = EMPTY;
    private String          path           = EMPTY;
    private ApplicationType type           = NATIVE;
    private String          waitActivity   = EMPTY;
    private String          waitPackage    = EMPTY;
    private long            waitTimeout    = 20000;
}