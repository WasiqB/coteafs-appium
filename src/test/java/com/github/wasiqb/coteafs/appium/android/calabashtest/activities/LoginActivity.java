package com.github.wasiqb.coteafs.appium.android.activities;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.android.AndroidDevice;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 8:26:22 PM
 */
public class LoginActivity extends AndroidActivity {
	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:26:22 PM
	 * @param device
	 */
	public LoginActivity (final AndroidDevice device) {
		super (device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#prepare()
	 */
	@Override
	public DeviceElement prepare () {
		final DeviceElement webkit = DeviceElement.create ("WebView")
			.using (By.className ("android.webkit.WebView"));
		DeviceElement.create ("userName")
			.using (By.id ("email-username"))
			.parent (webkit);
		DeviceElement.create ("password")
			.using (By.id ("password"))
			.parent (webkit);
		DeviceElement.create ("login")
			.using (By.id ("login-button"))
			.parent (webkit);
		return webkit;
	}
}