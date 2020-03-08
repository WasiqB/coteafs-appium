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
package com.github.wasiqb.coteafs.appium.device;

import static com.google.common.truth.Truth.assertThat;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @param <D>
 * @param <E>
 * @param <T>
 * @author wasiq.bhamla
 * @since 19-May-2017 9:57:58 PM
 */
public class DeviceElementVerify<D extends AppiumDriver<MobileElement>, E extends Device<D, T>,
    T extends TouchAction<T>> {
    private static final Logger log = LogManager.getLogger(DeviceElementVerify.class);

    private final DeviceElementActions<D, E, T> actions;

    /**
     * @param actions
     * @author wasiq.bhamla
     * @since 19-May-2017 9:59:32 PM
     */
    public DeviceElementVerify(final DeviceElementActions<D, E, T> actions) {
        this.actions = actions;
    }

    /**
     * @return instance
     * @author wasiq.bhamla
     * @since 19-May-2017 10:07:53 PM
     */
    public DeviceElementVerify<D, E, T> shouldBeDisabled() {
        log.info("Verifying if element is disabled...");
        assertThat(this.actions.enabled()).isFalse();
        return this;
    }

    /**
     * @return instance
     * @author wasiq.bhamla
     * @since 19-May-2017 10:08:28 PM
     */
    public DeviceElementVerify<D, E, T> shouldBeDisplayed() {
        log.info("Verifying if element is displayed...");
        assertThat(this.actions.visible()).isTrue();
        return this;
    }

    /**
     * @return instance
     * @author wasiq.bhamla
     * @since 19-May-2017 10:07:22 PM
     */
    public DeviceElementVerify<D, E, T> shouldBeEnabled() {
        log.info("Verifying if element is enabled...");
        assertThat(this.actions.enabled()).isTrue();
        return this;
    }

    /**
     * @return instance
     * @author wasiq.bhamla
     * @since 20-May-2017 12:24:26 PM
     */
    public DeviceElementVerify<D, E, T> shouldNotBeDisplayed() {
        log.info("Verifying if element is not displayed...");
        assertThat(this.actions.visible()).isFalse();
        return this;
    }

    /**
     * @param expected
     * @return instance
     * @author wasiq.bhamla
     * @since 20-May-2017 12:39:27 PM
     */
    public DeviceElementVerify<D, E, T> textShouldBeEqualTo(final String expected) {
        log.info("Verifying if element text is equal to [{}]...", expected);
        assertThat(this.actions.text()).isEqualTo(expected);
        return this;
    }
}