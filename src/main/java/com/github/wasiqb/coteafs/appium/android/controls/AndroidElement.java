package com.github.wasiqb.coteafs.appium.android.controls;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wasiq.bhamla
 * @since 25-Apr-2017 7:29:23 PM
 */
public class AndroidElement {
	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 7:34:42 PM
	 * @param name
	 * @return instance
	 */
	public static AndroidElement create (final String name) {
		return new AndroidElement (name);
	}

	private FindBy						by;
	private final List <AndroidElement>	childs;
	private int							index;
	private String						locator;
	private final String				name;
	private AndroidElement				parent;

	private AndroidElement (final String name) {
		this.childs = new ArrayList <> ();
		this.name = name;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 7:49:17 PM
	 * @return childs
	 */
	public List <AndroidElement> childs () {
		return this.childs;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 7:45:09 PM
	 * @return index
	 */
	public int index () {
		return this.index;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 7:44:39 PM
	 * @param location
	 * @return instance
	 */
	public AndroidElement index (final int location) {
		this.index = location;
		return this;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 7:40:30 PM
	 * @return locator
	 */
	public LocatorStrategy locator () {
		return new LocatorStrategy (this.by, this.locator);
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 7:35:06 PM
	 * @return name
	 */
	public String name () {
		return this.name;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 7:50:29 PM
	 * @return parent
	 */
	public AndroidElement parent () {
		return this.parent;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 7:49:46 PM
	 * @param elementParent
	 * @return instance
	 */
	public AndroidElement parent (final AndroidElement elementParent) {
		if (this.parent == null) {
			this.parent = elementParent;
		}
		if (!elementParent.childs ()
			.contains (this)) {
			elementParent.addChild (this);
		}
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		final String line1 = "Name: %s";
		final String line2 = "By: %s, Locator: %s";
		final String line4 = "Index: %d";
		final String line3 = "Childs: %s";
		final StringBuilder sb = new StringBuilder (String.format (line1, this.name)).append ("\n");
		sb.append (String.format (line2, this.by, this.locator))
			.append ("\n");
		sb.append (String.format (line4, this.index))
			.append ("\n");
		sb.append (String.format (line3, this.childs))
			.append ("\n");
		return sb.toString ();
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 7:36:32 PM
	 * @param findBy
	 * @return instance
	 */
	public AndroidElement using (final FindBy findBy) {
		this.by = findBy;
		return this;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 7:39:32 PM
	 * @param value
	 * @return instance
	 */
	public AndroidElement withLocator (final String value) {
		this.locator = value;
		return this;
	}

	/**
	 * @author wasiq.bhamla
	 * @since 25-Apr-2017 7:48:31 PM
	 * @param androidElement
	 */
	private void addChild (final AndroidElement child) {
		this.childs.add (child);
		if (child.parent () == null || !child.parent ()
			.equals (this)) {
			child.parent (this);
		}
	}
}