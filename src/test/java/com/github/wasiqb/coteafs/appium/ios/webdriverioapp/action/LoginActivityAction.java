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
     * @author Faisal Khatri
     * @param device
     */
    public LoginActivityAction (IOSDevice device) {
        super (device);
    }

    @Override
    public void perform () {
        final LoginActivity login = new LoginActivity (getDevice ());
        login.onElement ("Username")
            .enterText (value ("Username"));
        login.onElement ("Password")
            .enterText (value ("Password"));
        login.onElement ("Login")
            .tap ();
    }
}
