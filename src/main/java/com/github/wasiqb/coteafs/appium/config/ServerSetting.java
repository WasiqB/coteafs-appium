package com.github.wasiqb.coteafs.appium.config;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 8:43:22 PM
 */
public class ServerSetting {
	private String	ip;
	private boolean	noReset;
	private int		port;
	private long	startUpTimeOutSeconds;

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
	 * @since 12-Apr-2017 8:51:26 PM
	 * @return the startUpTimeOutSeconds
	 */
	public long getStartUpTimeOutSeconds () {
		return this.startUpTimeOutSeconds;
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
	 * @since 12-Apr-2017 8:51:26 PM
	 * @param startUpTimeOutSeconds
	 *            the startUpTimeOutSeconds to set
	 */
	public void setStartUpTimeOutSeconds (final long startUpTimeOutSeconds) {
		this.startUpTimeOutSeconds = startUpTimeOutSeconds;
	}
}