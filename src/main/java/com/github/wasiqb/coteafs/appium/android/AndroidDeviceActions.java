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

import static com.github.wasiqb.coteafs.appium.constants.ErrorMessage.SERVER_STOPPED;
import static com.github.wasiqb.coteafs.error.util.ErrorUtil.fail;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.imageio.ImageIO;

import com.github.wasiqb.coteafs.appium.android.system.AlertActivity;
import com.github.wasiqb.coteafs.appium.android.system.PermissionActivity;
import com.github.wasiqb.coteafs.appium.config.enums.AutomationType;
import com.github.wasiqb.coteafs.appium.config.enums.ClipboardType;
import com.github.wasiqb.coteafs.appium.config.enums.KeyCode;
import com.github.wasiqb.coteafs.appium.device.DeviceActions;
import com.github.wasiqb.coteafs.appium.error.AppiumServerStoppedError;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.SupportsNetworkStateManagement;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.clipboard.HasClipboard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 9:05:27 PM
 */
public class AndroidDeviceActions
    extends DeviceActions<AndroidDriver<MobileElement>, AndroidDevice, AndroidTouchAction> {
    private static final Logger LOG = LogManager.getLogger ();

    /**
     * @param device Device under test
     *
     * @author wasiq.bhamla
     * @since 26-Apr-2017 9:05:43 PM
     */
    public AndroidDeviceActions (final AndroidDevice device) {
        super (device, new AndroidTouchAction (device.getDriver ()));
    }

    /**
     * @return clipboard text
     *
     * @author wasiqb
     * @since Nov 2, 2018
     */
    public String clipboard () {
        return getValue ("Getting clipboard text...", HasClipboard::getClipboardText);
    }

    /**
     * @param type Type for which to get clipboard value
     *
     * @return clipboard
     *
     * @author wasiqb
     * @since Nov 2, 2018
     */
    public String clipboard (final ClipboardType type) {
        return getValue ("Getting clipboard for [{}]...", d -> d.getClipboard (type.getType ()), type);
    }

    /**
     * @param text Set clipboard with text
     *
     * @author Faisal Khatri
     * @since Mar 13, 2021
     */
    public void clipboard (final String text) {
        perform ("Setting clipboard text to [{}]...", d -> d.setClipboardText (text), text);
    }

    /**
     * @param url URL to set clipboard with.
     *
     * @author Wasiq Bhamla
     * @since 13-Mar-2021
     */
    public void clipboard (final URL url) {
        perform ("Setting clipboard URL to [{}]...", d -> d.setClipboard (ClipboardContentType.URL,
            Base64.getMimeEncoder ()
                .encode (url.getPath ()
                    .getBytes (StandardCharsets.UTF_8))), url);
    }

    /**
     * @param image Set clipboard with image
     *
     * @author Wasiq Bhamla
     * @since 13-Mar-2021
     */
    public void clipboard (final BufferedImage image) {
        perform ("Setting clipboard image...", d -> {
            try (final ByteArrayOutputStream os = new ByteArrayOutputStream ()) {
                ImageIO.write (image, "png", os);
                d.setClipboard (ClipboardContentType.IMAGE, Base64.getMimeEncoder ()
                    .encode (os.toByteArray ()));
            } catch (final IOException e) {
                LOG.error ("Error occurred while setting Image clipboard.");
                LOG.catching (e);
            }
        });
    }

    /**
     * @return Current Activity name
     *
     * @author wasiq.bhamla
     * @since 26-Apr-2017 9:09:43 PM
     */
    public String currentActivity () {
        return getValue ("Getting current activity name...", AndroidDriver<MobileElement>::currentActivity);
    }

    /**
     * @return Pop-up message
     *
     * @author wasiq.bhamla
     * @since Feb 8, 2018 4:01:35 PM
     */
    public String handleAlert () {
        return getValue ("Handling Android Alert pop-up...", d -> {
            try {
                final AlertActivity perm = new AlertActivity (this.device);
                final String description = perm.onElement ("Message")
                    .text ();
                LOG.trace ("Alert Text: {}", description);
                perm.onElement ("OK")
                    .tap ();
                return description;
            } catch (final TimeoutException e) {
                LOG.warn ("Expected Alert not displayed...");
                LOG.warn (e.getMessage ());
            }
            return null;
        });
    }

    /**
     * @param buttonText Button text to click on
     *
     * @return message
     *
     * @author wasiq.bhamla
     * @since 09-May-2017 9:14:16 PM
     */
    public String handlePermissionAlert (final String buttonText) {
        return getValue ("Handling Android Permission Alert pop-up...", d -> {
            try {
                final PermissionActivity perm = new PermissionActivity (this.device);
                final String description = perm.onElement ("Message")
                    .text ();
                LOG.trace ("Alert Text: {}", description);
                perm.onElement (buttonText)
                    .tap ();
                return description;
            } catch (final TimeoutException e) {
                LOG.warn ("Expected Alert not displayed...");
                LOG.warn (e.getMessage ());
            }
            return null;
        });
    }

    /**
     * @author wasiqb
     * @since Oct 20, 2018
     */
    public void hideKeyboard () {
        perform ("Hiding the keyboard...", d -> {
            if (d.isKeyboardShown ()) {
                d.hideKeyboard ();
            }
        });
    }

    /**
     * @return isLocked
     *
     * @author wasiq.bhamla
     * @since 26-Apr-2017 9:11:35 PM
     */
    public boolean isLocked () {
        return getValue ("Checking if device is locked...", AndroidDriver<MobileElement>::isDeviceLocked);
    }

    /**
     * @author wasiq.bhamla
     * @since 26-Apr-2017 9:11:45 PM
     */
    public void lock () {
        perform ("Locking the Android device...", AndroidDriver<MobileElement>::lockDevice);
    }

    /**
     * @param keyCode Key to long press
     *
     * @author Wasiq Bhamla
     * @since 21-Mar-2021
     */
    public void longPressKey (final KeyCode keyCode) {
        perform ("Pressing [{}] button on Android device...", d -> d.longPressKey (new KeyEvent (keyCode.getKey ())),
            keyCode);
    }

    /*
     * (non-Javadoc)
     * @see com.github.wasiqb.coteafs.appium.device.DeviceActions#pinch(int)
     */
    @Override
    public void pinch (final int distance) {
        if (this.device.getSetting ()
            .getAutomation () == AutomationType.ESPRESSO) {
            super.pinch (distance);
        } else {
            LOG.warn ("Pinch is only available when Automation type is Espresso...");
        }
    }

    /**
     * @param keyCode Key to press
     *
     * @author Wasiq Bhamla
     * @since 21-Mar-2021
     */
    public void pressKey (final KeyCode keyCode) {
        perform ("Pressing [{}] button on Android device...", d -> d.pressKey (new KeyEvent (keyCode.getKey ())),
            keyCode);
    }

    /**
     * @param devicePath Path on device
     * @param filePath File path to put on device
     *
     * @author Wasiq Bhamla
     * @since 19-Mar-2021
     */
    public void pushFile (final String devicePath, final String filePath) {
        perform ("Pushing file to Android device...", d -> {
            try {
                d.pushFile (devicePath, new File (filePath));
            } catch (final IOException e) {
                LOG.error ("Error while pushing file to device...");
                LOG.catching (e);
            }
        });
    }

    /**
     * @author wasiqb
     * @since Nov 2, 2018
     */
    public void toggleAirplane () {
        perform ("Toggling Airplane...", SupportsNetworkStateManagement::toggleAirplaneMode);
    }

    /**
     * @author wasiqb
     * @since Nov 2, 2018
     */
    public void toggleData () {
        perform ("Toggling Data...", SupportsNetworkStateManagement::toggleData);
    }

    /**
     * @author wasiqb
     * @since Nov 2, 2018
     */
    public void toggleLocation () {
        perform ("Toggling Location services...", AndroidDriver::toggleLocationServices);
    }

    /**
     * @author wasiqb
     * @since Nov 2, 2018
     */
    public void toggleWifi () {
        perform ("Toggling Wifi...", SupportsNetworkStateManagement::toggleWifi);
    }

    /**
     * @author wasiq.bhamla
     * @since 26-Apr-2017 9:11:52 PM
     */
    public void unlock () {
        perform ("Unlocking the Android device...", AndroidDriver<MobileElement>::unlockDevice);
    }

    /*
     * (non-Javadoc)
     * @see com.github.wasiqb.coteafs.appium.device.DeviceActions#zoom(int)
     */
    @Override
    public void zoom (final int distance) {
        if (this.device.getSetting ()
            .getAutomation () == AutomationType.ESPRESSO) {
            super.zoom (distance);
        } else {
            LOG.warn ("Zoom is only available when Automation type is Espresso...");
        }
    }

    private <T> T getValue (final String message, final Function<AndroidDriver<MobileElement>, T> action,
        final Object... args) {
        LOG.info (message, args);
        try {
            return action.apply (this.driver);
        } catch (final NoSuchSessionException e) {
            fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
        }
        return null;
    }

    private void perform (final String message, final Consumer<AndroidDriver<MobileElement>> action,
        final Object... args) {
        LOG.info (message, args);
        try {
            action.accept (this.driver);
        } catch (final NoSuchSessionException e) {
            fail (AppiumServerStoppedError.class, SERVER_STOPPED, e);
        }
    }
}