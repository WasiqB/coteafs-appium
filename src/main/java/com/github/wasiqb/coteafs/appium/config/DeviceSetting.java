package com.github.wasiqb.coteafs.appium.config;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:34:28 PM
 */
public class DeviceSetting {
	private String			appActivity;
	private String			appLocation;
	private String			appPackage;
	private ApplicationType	appType;
	private String			deviceName;
	private DeviceType		deviceType;
	private String			deviceVersion;
	private String			udid;

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:48 PM
	 * @return the appActivity
	 */
	public String getAppActivity () {
		return this.appActivity;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:48 PM
	 * @return the appLocation
	 */
	public String getAppLocation () {
		return this.appLocation;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @return the appPackage
	 */
	public String getAppPackage () {
		return this.appPackage;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @return the appType
	 */
	public ApplicationType getAppType () {
		return this.appType;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @return the deviceName
	 */
	public String getDeviceName () {
		return this.deviceName;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @return the deviceType
	 */
	public DeviceType getDeviceType () {
		return this.deviceType;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @return the deviceVersion
	 */
	public String getDeviceVersion () {
		return this.deviceVersion;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @return the udid
	 */
	public String getUdid () {
		return this.udid;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:48 PM
	 * @param appActivity
	 *            the appActivity to set
	 */
	public void setAppActivity (final String appActivity) {
		this.appActivity = appActivity;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param appLocation
	 *            the appLocation to set
	 */
	public void setAppLocation (final String appLocation) {
		this.appLocation = appLocation;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param appPackage
	 *            the appPackage to set
	 */
	public void setAppPackage (final String appPackage) {
		this.appPackage = appPackage;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param appType
	 *            the appType to set
	 */
	public void setAppType (final ApplicationType appType) {
		this.appType = appType;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param deviceName
	 *            the deviceName to set
	 */
	public void setDeviceName (final String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param deviceType
	 *            the deviceType to set
	 */
	public void setDeviceType (final DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param deviceVersion
	 *            the deviceVersion to set
	 */
	public void setDeviceVersion (final String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:42:49 PM
	 * @param udid
	 *            the udid to set
	 */
	public void setUdid (final String udid) {
		this.udid = udid;
	}
}