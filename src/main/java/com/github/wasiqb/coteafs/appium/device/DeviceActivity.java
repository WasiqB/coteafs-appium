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

import static com.github.wasiqb.coteafs.appium.constants.ErrorMessage.SERVER_STOPPED;
import static com.github.wasiqb.coteafs.appium.utils.ErrorUtils.fail;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.github.wasiqb.coteafs.appium.checker.ServerChecker;
import com.github.wasiqb.coteafs.appium.config.device.DeviceSetting;
import com.github.wasiqb.coteafs.appium.config.device.PlaybackSetting;
import com.github.wasiqb.coteafs.appium.config.enums.AutomationType;
import com.github.wasiqb.coteafs.appium.config.enums.PlatformType;
import com.github.wasiqb.coteafs.appium.config.enums.WaitStrategy;
import com.github.wasiqb.coteafs.appium.error.AppiumSelectorNotImplementedError;
import com.github.wasiqb.coteafs.appium.error.AppiumServerStoppedError;
import com.github.wasiqb.coteafs.appium.error.DeviceElementFindTimedOutError;
import com.github.wasiqb.coteafs.appium.error.DeviceElementNameNotFoundError;
import com.github.wasiqb.coteafs.appium.error.DeviceElementNotFoundError;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @param <D>
 * @param <E>
 * @param <T>
 *
 * @author wasiq.bhamla
 * @since 26-Apr-2017 4:31:24 PM
 */
public abstract class DeviceActivity<D extends AppiumDriver<MobileElement>, E extends Device<D, T>, T extends TouchAction<T>> {
    private static final Logger log = LogManager.getLogger (DeviceActivity.class);

    protected final AutomationType             automation;
    protected final E                          device;
    protected final Map<String, DeviceElement> deviceElements;
    protected final PlatformType               platform;
    private final   PlaybackSetting            playSetting;
    private final   T                          touch;
    private final   WebDriverWait              wait;

    /**
     * @param device
     * @param touch
     *
     * @author wasiq.bhamla
     * @since 26-Apr-2017 4:32:45 PM
     */
    public DeviceActivity (final E device, final T touch) {
        this.device = device;
        this.touch = touch;
        this.deviceElements = new HashMap<> ();
        final DeviceSetting deviceSetting = device.getSetting ();
        this.automation = deviceSetting.getAutomation ();
        this.platform = deviceSetting.getOs ();
        this.playSetting = deviceSetting.getPlayback ();
        this.wait = new WebDriverWait (device.getDriver (), ofSeconds (this.playSetting.getDelay ()
            .getExplicit ()).getSeconds ());
    }

    /**
     * @param name
     *
     * @return element
     *
     * @author wasiq.bhamla
     * @since Feb 2, 2018 1:44:52 PM
     */
    public MobileElement getElement (final String name) {
        load ();
        log.trace ("Getting element with name [{}]...", name);
        return findElements (getDeviceElement (name));
    }

    /**
     * @return device actions
     *
     * @author wasiq.bhamla
     * @since 26-Apr-2017 8:41:07 PM
     */
    public DeviceActions<D, E, T> onDevice () {
        this.device.checkServerRunning ();
        log.info ("Preparing to perform actions on device...");
        return new DeviceActions<> (this.device, this.touch);
    }

    /**
     * @param name
     *
     * @return element actions
     *
     * @author wasiq.bhamla
     * @since 26-Apr-2017 6:45:09 PM
     */
    public DeviceElementActions<D, E, T> onElement (final String name) {
        ServerChecker.checkServerRunning (this.device.server);
        log.trace ("Preparing to perform actions on device element [{}]...", name);
        return new DeviceElementActions<> (this.device, name, getElement (name), this.touch);
    }

    /**
     * @param name
     * @param index
     *
     * @return actions
     *
     * @author wasiq.bhamla
     * @since Jul 5, 2017 6:55:54 AM
     */
    public DeviceElementActions<D, E, T> onElement (final String name, final int index) {
        ServerChecker.checkServerRunning (this.device.server);
        log.trace ("Preparing to perform actions on dynamic device element [{}] on index [{}]...", name, index);
        final DeviceElement e = getDeviceElement (name);
        final DeviceElement element = Objects.requireNonNull (e, "Element not found.")
            .index (index);
        return new DeviceElementActions<> (this.device, name, findElements (element), this.touch);
    }

    /**
     * @return element
     *
     * @author wasiq.bhamla
     * @since 02-May-2017 4:38:00 PM
     */
    protected abstract DeviceElement prepare ();

    private void captureScreenshotOnError () {
        if (this.playSetting.getScreenshot ()
            .isOnError ()) {
            onDevice ().captureScreenshot ();
        }
    }

    private MobileElement find (final D deviceDriver, final DeviceElement parent, final By locator, final int index,
        final WaitStrategy strategy) {
        try {
            wait (locator, strategy);
            List<MobileElement> result = null;
            if (parent != null) {
                log.trace ("Finding child element of [{}] parent using [{}] at index [{}]...", parent.name (), locator,
                    index);
                final MobileElement mobileElement = getElement (parent.name ());
                result = mobileElement.findElements (locator);
            } else {
                log.trace ("Finding root element using [{}] at index [{}]...", locator, index);
                result = deviceDriver.findElements (locator);
            }
            return result.get (index);
        } catch (final TimeoutException e) {
            captureScreenshotOnError ();
            final String message = String.format ("[%s] locator timed out.", locator);
            fail (DeviceElementFindTimedOutError.class, message, e);
        } catch (final NoSuchSessionException e) {
            fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
        } catch (final InvalidSelectorException e) {
            fail (AppiumSelectorNotImplementedError.class, "Selector not supported", e);
        } catch (final Exception e) {
            captureScreenshotOnError ();
            String message = "";
            if (parent == null) {
                message = String.format (
                    "Error occured while finding root device element with locator [%s] at index [%d].", locator, index);
                fail (DeviceElementNotFoundError.class, message, e);
            } else {
                message = String.format (
                    "Error occured while finding device element with locator [%s] at index [%d] under parent %s.",
                    locator, index, parent.name ());
                fail (DeviceElementNotFoundError.class, message, e);
            }
        }
        return null;
    }

    private MobileElement findElements (final DeviceElement element) {
        Objects.requireNonNull (element, "Element is required.");
        final DeviceElement parent = element.parent ();
        final By locator = element.locator (this.platform, this.automation);
        final int index = element.index ();
        final WaitStrategy strategy = element.waitStrategy ();
        return find (this.device.getDriver (), parent, locator, index, strategy);
    }

    private DeviceElement getDeviceElement (final String name) {
        if (this.deviceElements.containsKey (name)) {
            return this.deviceElements.get (name);
        }
        final String msg = String.format ("DeviceElement with name [%s] not found.", name);
        fail (DeviceElementNameNotFoundError.class, msg);
        return null;
    }

    private void load () {
        if (this.deviceElements.size () == 0) {
            log.trace ("Loading elements on [{}] activity...", this.platform);
            loadElements (prepare ());
        }
    }

    private void loadElements (final DeviceElement rootElement) {
        ServerChecker.checkServerRunning (this.device.server);
        if (!this.deviceElements.containsKey (rootElement.name ())) {
            this.deviceElements.put (rootElement.name (), rootElement);
        }
        final List<DeviceElement> childs = rootElement.childs ();
        for (final DeviceElement child : childs) {
            loadElements (child);
        }
    }

    /**
     * @param locator
     * @param waitStrategy
     *
     * @author wasiq.bhamla
     * @since Jan 30, 2018 7:33:47 PM
     */
    private void wait (final By locator, final WaitStrategy waitStrategy) {
        switch (waitStrategy) {
            case ENABLED:
                this.wait.until (ExpectedConditions.elementToBeClickable (locator));
                break;
            case PRESENT:
                this.wait.until (ExpectedConditions.presenceOfElementLocated (locator));
                break;
            case VISIBLE:
                this.wait.until (visibilityOfElementLocated (locator));
                break;
            case NONE:
            default:
                break;
        }
    }
}