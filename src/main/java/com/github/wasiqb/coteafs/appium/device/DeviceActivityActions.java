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

import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

/**
 * @param <D> Driver
 * @param <E> Device
 * @param <T>
 *
 * @author wasiq.bhamla
 * @since Oct 23, 2017 10:51:31 PM
 */
public abstract class DeviceActivityActions<D extends AppiumDriver<MobileElement>, E extends Device<D, T>, T extends TouchAction<T>> {
    private final E                   device;
    private final Map<String, Object> values;

    /**
     * @param device Device instance
     *
     * @author wasiq.bhamla
     * @since Oct 23, 2017 10:51:31 PM
     */
    protected DeviceActivityActions (final E device) {
        this.device = device;
        this.values = new HashMap<> ();
    }

    /**
     * @param element Element name
     * @param value Input value
     *
     * @return instance
     *
     * @author wasiq.bhamla
     * @since Oct 23, 2017 11:01:15 PM
     */
    public DeviceActivityActions<D, E, T> addInputValue (final String element, final Object value) {
        this.values.put (element, value);
        return this;
    }

    /**
     * @return the device
     *
     * @author wasiq.bhamla
     * @since Oct 23, 2017 10:55:13 PM
     */
    public E getDevice () {
        return this.device;
    }

    /**
     * @author wasiq.bhamla
     * @since Oct 23, 2017 10:53:59 PM
     */
    public abstract void perform ();

    @SuppressWarnings ("unchecked")
    protected <X> X value (final String element) {
        return (X) this.values.get (element);
    }
}