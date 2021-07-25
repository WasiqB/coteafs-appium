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
package com.github.wasiqb.coteafs.appium.checker;

import static com.github.wasiqb.coteafs.error.util.ErrorUtil.fail;
import static java.text.MessageFormat.format;

import com.github.wasiqb.coteafs.appium.error.DeviceDesiredCapabilitiesNotSetError;
import com.github.wasiqb.coteafs.appium.error.DeviceElementDisabledError;
import com.github.wasiqb.coteafs.appium.error.DeviceElementNotDisplayedError;
import io.appium.java_client.MobileElement;

/**
 * @author wasiq.bhamla
 * @since 04-May-2017 4:30:02 PM
 */
public final class DeviceChecker {
    /**
     * @param key Capability key
     * @param value Capability value
     *
     * @author wasiq.bhamla
     * @since 12-May-2017 7:31:31 PM
     */
    public static void checkCapabilitiesParams (final String key, final Object value) {
        if (value == null) {
            final String msg = "Device Desired Capabilities value for [{0}] key not set.";
            fail (DeviceDesiredCapabilitiesNotSetError.class, format (msg, key));
        }
    }

    /**
     * @param element Element under test
     * @param name Name of element
     *
     * @author wasiq.bhamla
     * @since 04-May-2017 10:10:28 PM
     */
    public static void checkDeviceElementDisplayed (final MobileElement element, final String name) {
        if (!element.isDisplayed ()) {
            final String msg = "Device element [{0}] is not displayed.";
            fail (DeviceElementNotDisplayedError.class, format (msg, name));
        }
    }

    /**
     * @param element Element under test
     * @param name Name of element
     *
     * @author wasiq.bhamla
     * @since 04-May-2017 11:08:59 PM
     */
    public static void checkDeviceElementEnabled (final MobileElement element, final String name) {
        if (!element.isEnabled ()) {
            final String msg = "Device element [{0}] is disabled.";
            fail (DeviceElementDisabledError.class, format (msg, name));
        }
    }

    private DeviceChecker () {
        // Utility class.
    }
}