package com.github.wasiqb.coteafs.appium.ios.webdriverioapp.action;

import com.github.wasiqb.coteafs.appium.ios.IOSActivityActions;
import com.github.wasiqb.coteafs.appium.ios.IOSDevice;
import com.github.wasiqb.coteafs.appium.ios.webdriverioapp.activities.LoginActivity;

/**
 * @author Faisal Khatri
 * @since Feb 16, 2021
 */
public class LoginActivityAction extends IOSActivityActions {
    /**
     * @param device
     *
     * @author Faisal Khatri
     */
    public LoginActivityAction (final IOSDevice device) {
        super (device);
    }

    @Override
    public void perform () {
        final LoginActivity login = new LoginActivity (getDevice ());
        login.onElement ("LoginTab")
            .tap ();
        login.onElement ("Username")
            .enterText (value ("Username"));
        login.onElement ("Password")
            .enterText (value ("Password"));
        login.onElement ("LoginBtn")
            .tap ();
    }
}