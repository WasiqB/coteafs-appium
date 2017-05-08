package com.github.wasiqb.coteafs.appium.config;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:43:22 PM
 */
public class ServerSetting {
	private boolean	external;
	private boolean	fullReset;
	private String	ip;
	private boolean	noReset;
	private int		port;
	private int		sessionTimeout;
	private long	startUpTimeOutSeconds;

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:49:49 PM
	 */
	public ServerSetting () {
		this.external = false;
		this.noReset = false;
		this.fullReset = false;
		this.sessionTimeout = 120;
		this.startUpTimeOutSeconds = 60;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @return the ip
	 */
	public String getIp () {
		return this.ip;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @return the port
	 */
	public int getPort () {
		return this.port;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:49:31 PM
	 * @return the sessionTimeout
	 */
	public int getSessionTimeout () {
		return this.sessionTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @return the startUpTimeOutSeconds
	 */
	public long getStartUpTimeOutSeconds () {
		return this.startUpTimeOutSeconds;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 21-Apr-2017 5:06:22 PM
	 * @return the external
	 */
	public boolean isExternal () {
		return this.external;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:56:41 PM
	 * @return the fullReset
	 */
	public boolean isFullReset () {
		return this.fullReset;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @return the noReset
	 */
	public boolean isNoReset () {
		return this.noReset;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 21-Apr-2017 5:06:22 PM
	 * @param external
	 *            the external to set
	 */
	public void setExternal (final boolean external) {
		this.external = external;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:56:52 PM
	 * @param fullReset
	 *            the fullReset to set
	 */
	public void setFullReset (final boolean fullReset) {
		this.fullReset = fullReset;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @param ip
	 *            the ip to set
	 */
	public void setIp (final String ip) {
		this.ip = ip;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @param noReset
	 *            the noReset to set
	 */
	public void setNoReset (final boolean noReset) {
		this.noReset = noReset;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @param port
	 *            the port to set
	 */
	public void setPort (final int port) {
		this.port = port;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 08-May-2017 7:49:31 PM
	 * @param sessionTimeout
	 *            the sessionTimeout to set
	 */
	public void setSessionTimeout (final int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 8:51:26 PM
	 * @param startUpTimeOutSeconds
	 *            the startUpTimeOutSeconds to set
	 */
	public void setStartUpTimeOutSeconds (final long startUpTimeOutSeconds) {
		this.startUpTimeOutSeconds = startUpTimeOutSeconds;
	}
}