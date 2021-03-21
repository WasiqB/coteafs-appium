package com.github.wasiqb.coetafs.appium.ios.webdriverio.test;

import static com.google.common.truth.Truth.assertThat;
import static java.lang.System.getProperty;
import static java.text.MessageFormat.format;

import com.github.wasiqb.coteafs.appium.ios.IOSDevice;
import com.github.wasiqb.coteafs.appium.ios.webdriverioapp.action.LoginActivityAction;
import com.github.wasiqb.coteafs.appium.ios.webdriverioapp.activities.LoginActivity;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since Feb 16, 2021
 */
public class IOSTest {
    private IOSDevice    device;
    private AppiumServer server;

    /**
     * @param server
     * @param device
     *
     * @author Faisal Khatri
     * @since Feb 16, 2021
     */
    @Parameters ({ "server", "device" })
    @BeforeTest (alwaysRun = true)
    public void setupTest (final String server, final String device) {
        this.server = new AppiumServer (server);
        this.server.start ();

        this.device = new IOSDevice (this.server, device);
        this.device.start ();
        this.device.startRecording ();
    }

    /**
     * @author Faisal Khatri
     * @since Feb 16, 2021
     */
    @AfterTest (alwaysRun = true)
    public void tearDownTest () {
        this.device.stopRecording ();
        this.device.stop ();
        this.server.stop ();
    }

    /**
     * @author Faisal Khatri
     * @since Feb 16, 2021
     */
    @Test
    public void test1Login () {
        final LoginActivityAction login = new LoginActivityAction (this.device);
        login.addInputValue ("Username", "test@webdriver.io")
            .addInputValue ("Password", "Test1234!")
            .perform ();
    }

    @Test
    public void test2PushPullFile () {
        final String filePath = format ("{0}/assets/coteafs-appium-logo.png", getProperty ("user.dir"));
        final LoginActivity login = new LoginActivity (this.device);
        login.onDevice ()
            .pushFile ("/mnt/sdcard/Pictures/img.png", filePath);
        final byte[] content = login.onDevice ()
            .pullFile ("/mnt/sdcard/Pictures/img.png");
        assertThat (content).isNotEmpty ();
    }
}