package com.github.wasiqb.coteafs.appium.android.activities;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 8:19:07 PM
 */
public class WalkThruActivity2 extends AndroidActivity {
	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 8:19:07 PM
	 * @param driver
	 */
	public WalkThruActivity2 (final AndroidDriver <MobileElement> driver) {
		super (driver);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#build()
	 */
	@Override
	public void build () {
		final DeviceElement walk2 = DeviceElement.create ("Container")
			.using (By.id ("com.corfire.cwp.app:id/pageContainer"));
		final DeviceElement frame = DeviceElement.create ("FrameLayout")
			.using (By.className ("android.widget.FrameLayout"))
			.parent (walk2);
		final DeviceElement linear = DeviceElement.create ("LinearLayout")
			.using (By.className ("android.widget.LinearLayout"))
			.parent (frame);
		DeviceElement.create ("Skip")
			.using (By.className ("android.widget.TextView"))
			.index (2)
			.parent (linear);
		loadElements (walk2);
	}
}