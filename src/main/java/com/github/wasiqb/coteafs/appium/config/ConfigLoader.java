package com.github.wasiqb.coteafs.appium.config;

import java.beans.IntrospectionException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.introspector.PropertyUtils;

import com.github.wasiqb.coteafs.appium.exception.AppiumConfigFileNotFoundException;
import com.github.wasiqb.coteafs.appium.exception.AppiumConfigNotLoadedException;
import com.google.common.base.CaseFormat;

/**
 * @author wasiq.bhamla
 * @since 12-Apr-2017 9:01:03 PM
 */
public final class ConfigLoader {
	private static final Logger		log;
	private static AppiumSetting	settings;

	static {
		log = LogManager.getLogger (ConfigLoader.class);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 9:05:18 PM
	 * @param path
	 */
	public static void load (final String path) {
		log.trace ("Loading settings from Config file...");
		if (settings == null) {
			settings = loadSettings (path);
		}
	}

	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 5:28:04 PM
	 * @return settings
	 */
	public static AppiumSetting settings () {
		return settings;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 12-Apr-2017 9:17:06 PM
	 * @param path
	 * @return
	 */
	private static AppiumSetting loadSettings (final String path) {
		final URL url = ConfigLoader.class.getClassLoader ()
			.getResource (path);
		final File file = new File (url.getPath ());
		if (!file.exists ()) {
			final String msg = "%s not found.";
			throw new AppiumConfigFileNotFoundException (String.format (msg, path));
		}
		final String msg = "Started Loading Appium Settings from location [%s]...";
		log.trace (String.format (msg, path));
		final Constructor ctor = new Constructor (AppiumSetting.class);
		final PropertyUtils propertyUtils = new PropertyUtils () {
			@Override
			public Property getProperty (final Class <? extends Object> type, final String name)
					throws IntrospectionException {
				String prop = name;
				if (prop.indexOf ('_') > -1) {
					prop = CaseFormat.LOWER_UNDERSCORE.to (CaseFormat.LOWER_CAMEL, prop);
				}
				return super.getProperty (type, prop);
			}
		};
		ctor.setPropertyUtils (propertyUtils);
		final Yaml yaml = new Yaml (ctor);
		AppiumSetting result = null;
		try (final InputStream in = new FileInputStream (file)) {
			result = (AppiumSetting) yaml.load (in);
		}
		catch (final IOException e) {
			throw new AppiumConfigNotLoadedException ("Error loading config file.", e);
		}
		log.trace ("Appium settings loaded successfully...");
		return result;
	}
}