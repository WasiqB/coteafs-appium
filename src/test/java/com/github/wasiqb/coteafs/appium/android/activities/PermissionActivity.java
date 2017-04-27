package com.github.wasiqb.coteafs.appium.android.activities;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 11:11:50 PM
 */
public class PermissionActivity extends AndroidActivity {
	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 11:11:51 PM
	 * @param driver
	 */
	public PermissionActivity (final AndroidDriver <MobileElement> driver) {
		super (driver);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#build()
	 */
	@Override
	public void build () {
		final DeviceElement container = DeviceElement.create ("Permission Window")
			.using (By.id ("com.android.packageinstaller:id/dialog_container"));
		DeviceElement.create ("Message")
			.parent (container)
			.using (By.id ("com.android.packageinstaller:id/permission_message"));
		DeviceElement.create ("Allow")
			.parent (container)
			.using (By.id ("com.android.packageinstaller:id/permission_allow_button"));
		DeviceElement.create ("Deny")
			.parent (container)
			.using (By.id ("com.android.packageinstaller:id/permission_deny_button"));
		loadElements (container);
	}
}