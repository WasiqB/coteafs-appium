package com.github.wasiqb.coteafs.appium.device;

import static com.google.common.truth.Truth.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * @author wasiq.bhamla
 * @param <TDriver>
 * @param <TDevice>
 * @since 19-May-2017 9:57:58 PM
 */
public class DeviceElementVerify <TDriver extends AppiumDriver <MobileElement>, TDevice extends Device <TDriver>> {
	private static final Logger log;

	static {
		log = LogManager.getLogger (DeviceElementActions.class);
	}

	private final DeviceElementActions <TDriver, TDevice> actions;

	/**
	 * @author wasiq.bhamla
	 * @param actions
	 * @since 19-May-2017 9:59:32 PM
	 */
	public DeviceElementVerify (final DeviceElementActions <TDriver, TDevice> actions) {
		this.actions = actions;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 10:07:53 PM
	 */
	public void shouldBeDisabled () {
		log.trace ("Verifying element to be disabled...");
		assertThat (this.actions.enabled ()).isFalse ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 10:08:28 PM
	 */
	public void shouldBeDisplayed () {
		log.trace ("Verifying element to be displayed...");
		assertThat (this.actions.visible ()).isTrue ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 19-May-2017 10:07:22 PM
	 */
	public void shouldBeEnabled () {
		log.trace ("Verifying element to be enabled...");
		assertThat (this.actions.enabled ()).isTrue ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 20-May-2017 12:24:26 PM
	 */
	public void shouldNotBeDisplayed () {
		log.trace ("Verifying element not to be displayed...");
		assertThat (this.actions.visible ()).isFalse ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 20-May-2017 12:39:27 PM
	 * @param expected
	 */
	public void textShouldBeEqualTo (final String expected) {
		final String msg = "Verifying element text to be equal to [%s]...";
		log.trace (String.format (msg, expected));
		assertThat (this.actions.text ()).isEqualTo (expected);
	}
}