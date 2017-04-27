package com.github.wasiqb.coteafs.appium.android.activities;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.appium.android.AndroidActivity;
import com.github.wasiqb.coteafs.appium.device.DeviceElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author wasiq.bhamla
 * @since 26-Apr-2017 6:22:51 PM
 */
public class WalkthruActivity1 extends AndroidActivity {
	/**
	 * @author wasiq.bhamla
	 * @since 26-Apr-2017 6:22:51 PM
	 * @param driver
	 */
	public WalkthruActivity1 (final AndroidDriver <MobileElement> driver) {
		super (driver);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.DeviceActivity#build()
	 */
	@Override
	public void build () {
		final DeviceElement walk1 = DeviceElement.create ("Container")
			.using (By.id ("com.corfire.cwp.app:id/pageContainer"));
		final DeviceElement frame = DeviceElement.create ("FrameLayout")
			.using (By.className ("android.widget.FrameLayout"))
			.parent (walk1);
		final DeviceElement linear = DeviceElement.create ("LinearLayout")
			.using (By.className ("android.widget.LinearLayout"))
			.index (2)
			.parent (frame);
		DeviceElement.create ("Next")
			.using (By.className ("android.widget.ImageView"))
			.parent (linear);
		loadElements (walk1);
	}
}