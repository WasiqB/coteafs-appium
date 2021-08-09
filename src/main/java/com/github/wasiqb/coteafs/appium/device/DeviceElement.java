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

import static com.github.wasiqb.coteafs.appium.config.enums.AutomationType.APPIUM;
import static com.github.wasiqb.coteafs.appium.config.enums.AutomationType.UIAUTOMATOR2;
import static com.github.wasiqb.coteafs.appium.config.enums.PlatformType.ANDROID;
import static java.text.MessageFormat.format;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.github.wasiqb.coteafs.appium.config.enums.AutomationType;
import com.github.wasiqb.coteafs.appium.config.enums.PlatformType;
import com.github.wasiqb.coteafs.appium.config.enums.WaitStrategy;
import org.openqa.selenium.By;

/**
 * @author wasiq.bhamla
 * @since 25-Apr-2017 7:29:23 PM
 */
public class DeviceElement {
    /**
     * @param name Device name
     *
     * @return instance
     *
     * @author wasiq.bhamla
     * @since 25-Apr-2017 7:34:42 PM
     */
    public static DeviceElement create (final String name) {
        return new DeviceElement (name);
    }

    private final List<DeviceElement>                        childs;
    private       int                                        index;
    private final Map<PlatformType, Map<AutomationType, By>> locators;
    private final String                                     name;
    private       DeviceElement                              parent;
    private       WaitStrategy                               wait;

    private DeviceElement (final String name) {
        this.childs = new ArrayList<> ();
        this.name = name;
        this.wait = WaitStrategy.NONE;
        this.locators = new EnumMap<> (PlatformType.class);
    }

    /**
     * @return childs
     *
     * @author wasiq.bhamla
     * @since 25-Apr-2017 7:49:17 PM
     */
    public List<DeviceElement> childs () {
        return this.childs;
    }

    /**
     * @param automation Automation type
     * @param findBy By locator
     *
     * @return instance
     *
     * @author wasiqb
     * @since Nov 4, 2018
     */
    public DeviceElement forAndroid (final AutomationType automation, final By findBy) {
        return using (ANDROID, automation, findBy);
    }

    /**
     * @param findBy By locator
     *
     * @return instance
     *
     * @author wasiqb
     * @since Nov 4, 2018
     */
    public DeviceElement forAndroid (final By findBy) {
        return using (ANDROID, UIAUTOMATOR2, findBy);
    }

    /**
     * @param automation Automation type
     * @param findBy By locator
     *
     * @return instance
     *
     * @author wasiqb
     * @since Nov 4, 2018
     */
    public DeviceElement forIos (final AutomationType automation, final By findBy) {
        return using (PlatformType.IOS, automation, findBy);
    }

    /**
     * @param findBy By Locator
     *
     * @return instance
     *
     * @author wasiqb
     * @since Nov 4, 2018
     */
    public DeviceElement forIos (final By findBy) {
        return using (PlatformType.IOS, AutomationType.XCUI, findBy);
    }

    /**
     * @return index
     *
     * @author wasiq.bhamla
     * @since 25-Apr-2017 7:45:09 PM
     */
    public int index () {
        return this.index;
    }

    /**
     * @param location Index location
     *
     * @return instance
     *
     * @author wasiq.bhamla
     * @since 25-Apr-2017 7:44:39 PM
     */
    public DeviceElement index (final int location) {
        this.index = location;
        return this;
    }

    /**
     * @return by locator
     *
     * @author wasiqb
     * @since Oct 23, 2018
     */
    public By locator () {
        return locator (APPIUM);
    }

    /**
     * @param automation Automation type
     *
     * @return by locator
     *
     * @author wasiqb
     * @since Oct 23, 2018
     */
    public By locator (final AutomationType automation) {
        return locator (ANDROID, automation);
    }

    /**
     * @param platform Platform type
     * @param automation Automation type
     *
     * @return by locator
     *
     * @author wasiqb
     * @since Oct 23, 2018
     */
    public By locator (final PlatformType platform, final AutomationType automation) {
        final Map<AutomationType, By> locator = this.locators.get (platform);
        if (!locator.containsKey (automation) && automation != APPIUM) {
            return locator.get (APPIUM);
        }
        return locator.get (automation);
    }

    /**
     * @return name
     *
     * @author wasiq.bhamla
     * @since 25-Apr-2017 7:35:06 PM
     */
    public String name () {
        return this.name;
    }

    /**
     * @return parent
     *
     * @author wasiq.bhamla
     * @since 25-Apr-2017 7:50:29 PM
     */
    public DeviceElement parent () {
        return this.parent;
    }

    /**
     * @param elementParent Parent element
     *
     * @return instance
     *
     * @author wasiq.bhamla
     * @since 25-Apr-2017 7:49:46 PM
     */
    public DeviceElement parent (final DeviceElement elementParent) {
        if (this.parent == null) {
            this.parent = elementParent;
        }
        if (!elementParent.childs ()
            .contains (this)) {
            elementParent.addChild (this);
        }
        return this;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString () {
        final String detail = "Name: {0}\nBy: {1}\nIndex: {2}\nChildren: {3}";
        return format (detail, this.name, this.locators, this.index, this.childs);
    }

    /**
     * @return {@link WaitStrategy}
     *
     * @author wasiq.bhamla
     * @since Jan 30, 2018 7:32:07 PM
     */
    public WaitStrategy waitStrategy () {
        return this.wait;
    }

    /**
     * @param strategy Wait strategy
     *
     * @return instance
     *
     * @author wasiq.bhamla
     * @since Jan 30, 2018 7:32:23 PM
     */
    public DeviceElement waitStrategy (final WaitStrategy strategy) {
        this.wait = strategy;
        return this;
    }

    private void addChild (final DeviceElement child) {
        this.childs.add (child);
        if (child.parent () == null || !child.parent ()
            .equals (this)) {
            child.parent (this);
        }
    }

    private DeviceElement using (final PlatformType platform, final AutomationType automation, final By findBy) {
        Map<AutomationType, By> platformLocator = new EnumMap<> (AutomationType.class);
        if (this.locators.containsKey (platform)) {
            platformLocator = this.locators.get (platform);
        }
        platformLocator.put (automation, findBy);
        this.locators.put (platform, platformLocator);
        return this;
    }
}