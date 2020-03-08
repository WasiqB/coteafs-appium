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

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.text.StringSubstitutor.replaceSystemProperties;

/**
 * @author wasiqb
 * @since Oct 2, 2018
 */
public final class StringUtil {
    /**
     * @param value
     * @return extracted string.
     * @author wasiqb
     * @since Oct 2, 2018
     */
    public static String replaceSystemProperty(final String value) {
        if (isEmpty(value)) {
            return null;
        }
        return value.startsWith("${") ? replaceSystemProperties(value) : value;
    }

    private StringUtil() {
        // Util class.
    }
}