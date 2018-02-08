/**
 * Copyright (c) 2017, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.wasiqb.coteafs.appium.android;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.appium.android.vodqa.activities.ChainedViewActivity;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.DoubleTapActivity;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.DragDropActivity;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.LongPressActivity;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.PhotoViewActivity;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.SliderActivity;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.VerticleSwipeActivity;
import com.github.wasiqb.coteafs.appium.device.SwipeDirection;
import com.github.wasiqb.coteafs.appium.device.SwipeStartPosition;

/**
 * @author wasiq.bhamla
 * @since Jan 23, 2018 8:14:51 PM
 */
public class VodQATest extends DefaultTest {
	/**
	 * @author wasiq.bhamla
	 * @since Feb 2, 2018 9:56:28 PM
	 */
	@Test (enabled = false)
	public void test1 () {
		this.main.onElement ("VerticalSwipe")
			.click ();

		// final AndroidDriver <MobileElement> driver = this.androidDevice.getDriver ();
		// final MobileElement slider = driver.findElementByAccessibilityId ("listview");
		// final Dimension size = slider.getSize ();
		// System.out.println (size);
		//
		// final Point loc = slider.getLocation ();
		// System.out.println (loc);
		//
		// final int startX = size.width / 2;
		// final int startY = size.height - 5;
		// System.out.println ("Starting at x: " + startX + ", y: " + startY);
		//
		// final int endX = size.width / 2;
		// final int endY = startY + (int) (size.height * -0.25);
		// System.out.println ("ending at x: " + endX + ", y: " + endY);

		// new TouchAction (driver).press (slider, 540, 5)
		// .waitAction (Duration.ofSeconds (2))
		// .moveTo (slider, 540, 393)
		// .release ()
		// .perform ();
		//
		// new TouchAction (driver).press (slider, 540, 393)
		// .waitAction (Duration.ofSeconds (2))
		// .moveTo (slider, 540, 0)
		// .release ()
		// .perform ();
		//
		// final TouchAction wait = new TouchAction (driver);
		// wait.waitAction (Duration.ofSeconds (1))
		// .perform ();

		final VerticleSwipeActivity vs = new VerticleSwipeActivity (this.androidDevice);
		vs.onElement ("List")
			.swipe (SwipeDirection.UP, SwipeStartPosition.BOTTOM, 25);
		vs.onElement ("List")
			.swipe (SwipeDirection.DOWN, SwipeStartPosition.TOP, 25);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Feb 8, 2018 4:03:52 PM
	 */
	@Test
	public void testDoubleTap () {
		this.main.onElement ("DoubleTap")
			.click ();

		final DoubleTapActivity dt = new DoubleTapActivity (this.androidDevice);
		dt.onElement ("Button")
			.doubleTap ();
		final String message = dt.onDevice ()
			.handleAlert ();
		Assert.assertEquals (message, "Double tap successful!");
	}

	/**
	 * @author wasiq.bhamla
	 * @since Feb 2, 2018 2:59:25 PM
	 */
	@Test (enabled = false)
	public void testDragDrop () {
		this.main.onElement ("DragDrop")
			.click ();

		final DragDropActivity dd = new DragDropActivity (this.androidDevice);
		dd.onElement ("DropMe")
			.dragDrop (dd.getElement ("DropZone"));
		dd.onElement ("Success")
			.verifyThat ()
			.textShouldBeEqualTo ("Circle dropped");
	}

	/**
	 * @author wasiq.bhamla
	 * @since Feb 8, 2018 4:15:53 PM
	 */
	@Test (enabled = false)
	public void testLongPress () {
		this.main.onElement ("LongPress")
			.click ();

		final LongPressActivity lp = new LongPressActivity (this.androidDevice);
		lp.onElement ("Button")
			.longPress ();
		final String message = lp.onDevice ()
			.handleAlert ();
		Assert.assertEquals (message, "you pressed me hard :P");
	}

	/**
	 * @author wasiq.bhamla
	 * @throws InterruptedException
	 * @since Jan 23, 2018 9:39:20 PM
	 */
	@Test (enabled = false)
	public void testNativeView () throws InterruptedException {
		this.main.onElement ("ChainedView")
			.click ();

		final ChainedViewActivity chained = new ChainedViewActivity (this.androidDevice);
		chained.onElement ("Text1")
			.verifyThat ()
			.textShouldBeEqualTo ("Hello World, I'm View one ");
		chained.onElement ("Text2")
			.verifyThat ()
			.textShouldBeEqualTo ("Hello World, I'm View two ");
		chained.onElement ("Text3")
			.verifyThat ()
			.textShouldBeEqualTo ("Hello World, I'm View three ");
	}

	/**
	 * @author wasiq.bhamla
	 * @since Jan 27, 2018 7:45:48 PM
	 */
	@Test
	public void testSlider () {
		this.main.onElement ("Slider")
			.click ();

		final SliderActivity slide = new SliderActivity (this.androidDevice);
		slide.onElement ("Slider")
			.swipe (SwipeDirection.RIGHT, SwipeStartPosition.LEFT, 25);
		slide.onElement ("Slider1")
			.swipe (SwipeDirection.LEFT, SwipeStartPosition.RIGHT, 25);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Feb 1, 2018 3:15:23 PM
	 */
	@Test
	public void testVerticleSwipe () {
		this.main.onElement ("VerticalSwipe")
			.click ();

		final VerticleSwipeActivity vs = new VerticleSwipeActivity (this.androidDevice);
		vs.onElement ("List")
			.swipe (SwipeDirection.UP, SwipeStartPosition.BOTTOM, 25);
		vs.onElement ("List")
			.swipe (SwipeDirection.DOWN, SwipeStartPosition.TOP, 25);
	}

	/**
	 * @author wasiq.bhamla
	 * @since Feb 8, 2018 4:21:19 PM
	 */
	@Test
	public void testZoomPinch () {
		this.main.onElement ("PhotoView")
			.click ();

		final PhotoViewActivity p = new PhotoViewActivity (this.androidDevice);
		p.onElement ("Img")
			.zoom (25);

		p.onElement ("Img")
			.pinch (25);
	}
}