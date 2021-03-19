/*
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

import static com.google.common.truth.Truth.assertThat;
import static java.lang.System.getProperty;
import static java.text.MessageFormat.format;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.wasiqb.coteafs.appium.android.vodqa.actions.LoginActivityAction;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.ChainedViewActivity;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.DoubleTapActivity;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.DragDropActivity;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.LongPressActivity;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.SliderActivity;
import com.github.wasiqb.coteafs.appium.android.vodqa.activities.VerticleSwipeActivity;
import com.github.wasiqb.coteafs.appium.config.enums.SwipeDirection;
import com.github.wasiqb.coteafs.appium.config.enums.SwipeStartPosition;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author wasiq.bhamla
 * @since Jan 23, 2018 8:14:51 PM
 */
public class VodQATest extends DefaultTest {
    /**
     * @return orientation list
     *
     * @author wasiqb
     * @since Oct 21, 2018
     */
    @DataProvider
    public static Iterator<Object[]> getOrientation () {
        final List<Object[]> data = new ArrayList<> ();
        data.add (new Object[] { ScreenOrientation.LANDSCAPE });
        data.add (new Object[] { ScreenOrientation.PORTRAIT });
        return data.iterator ();
    }

    /**
     * @author wasiqb
     * @since Oct 20, 2018
     */
    @Test
    public void test1Login () {
        final LoginActivityAction login = new LoginActivityAction (this.androidDevice);
        login.addInputValue ("UserName", "admin")
            .addInputValue ("Password", "admin")
            .perform ();

        this.main.onElement ("ChainedView")
            .verifyThat ()
            .shouldBeDisplayed ();
    }

    /**
     * @author wasiq.bhamla
     * @since Jan 23, 2018 9:39:20 PM
     */
    @Test
    public void test2NativeView () {
        this.main.onElement ("ChainedView")
            .tap ();

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

        this.main.onElement ("Back")
            .tap ();
    }

    /**
     * @author wasiq.bhamla
     * @since Feb 8, 2018 4:15:53 PM
     */
    @Test
    public void test3LongPress () {
        this.main.onElement ("LongPress")
            .tap ();

        final LongPressActivity lp = new LongPressActivity (this.androidDevice);
        lp.onElement ("Button")
            .longPress ();
        final String message = lp.onDevice ()
            .handleAlert ();
        Assert.assertEquals (message, "you pressed me hard :P");

        this.main.onElement ("Back")
            .tap ();
    }

    /**
     * @param orientation
     *
     * @author wasiqb
     * @since Oct 21, 2018
     */
    @Test (dataProvider = "getOrientation")
    public void test4Rotation (final ScreenOrientation orientation) {
        this.main.onDevice ()
            .rotate (orientation);
        assertThat (this.main.onDevice ()
            .rotation ()
            .name ()).isEqualTo (orientation.name ());
    }

    /**
     * @author wasiq.bhamla
     * @since Jan 27, 2018 7:45:48 PM
     */
    @Test
    public void test5Slider () {
        this.main.onElement ("Slider")
            .tap ();

        final SliderActivity slide = new SliderActivity (this.androidDevice);
        slide.onElement ("Slider")
            .swipe (SwipeDirection.RIGHT, SwipeStartPosition.LEFT, 75);
        slide.onElement ("Slider1")
            .swipe (SwipeDirection.LEFT, SwipeStartPosition.RIGHT, 75);

        this.main.onElement ("Back")
            .tap ();
    }

    /**
     * @author wasiq.bhamla
     * @since Feb 1, 2018 3:15:23 PM
     */
    @Test
    public void test6VerticalSwipe () {
        this.main.onElement ("VerticalSwipe")
            .tap ();

        final VerticleSwipeActivity vs = new VerticleSwipeActivity (this.androidDevice);
        vs.onElement ("List")
            .swipe (SwipeDirection.UP, SwipeStartPosition.BOTTOM, 25);
        vs.onElement ("List")
            .swipe (SwipeDirection.DOWN, SwipeStartPosition.TOP, 25);

        this.main.onElement ("Back")
            .tap ();
    }

    /**
     * @author wasiq.bhamla
     * @since Feb 2, 2018 2:59:25 PM
     */
    @Test
    public void test7DragDrop () {
        this.main.onElement ("DragDrop")
            .tap ();

        final DragDropActivity dd = new DragDropActivity (this.androidDevice);
        dd.onElement ("DropMe")
            .dragDrop (dd.getElement ("DropZone"));
        dd.onElement ("Success")
            .verifyThat ()
            .textShouldBeEqualTo ("Circle dropped");

        this.main.onElement ("Back")
            .tap ();
    }

    /**
     * @author wasiq.bhamla
     * @since Feb 8, 2018 4:21:19 PM
     */
    @Test
    public void test8DoubleTap () {
        this.main.onElement ("DoubleTap")
            .tap ();

        final DoubleTapActivity p = new DoubleTapActivity (this.androidDevice);
        p.onElement ("Button")
            .doubleTap ();

        final String message = p.onDevice ()
            .handleAlert ();
        Assert.assertEquals (message, "Double tap successful!");

        this.main.onElement ("Back")
            .tap ();
    }

    @Test
    public void test9PushPullFile () {
        final String filePath = format ("{0}/assets/coteafs-appium-logo.png", getProperty ("user.dir"));
        this.main.onDevice ()
            .pushFile ("/mnt/sdcard/Pictures/img.png", filePath);
        final byte[] content = this.main.onDevice ()
            .pullFile ("/mnt/sdcard/Pictures/img.png");
        assertThat (content).isNotEmpty ();
    }
}