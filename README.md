# coteafs-appium
# Introduction
This is a very easy to use Mobile Automation Framework which can be used to test multiple devices of different platforms in a single test. This is a one of it's kind framework with unique coding standards defined by the framework. Writing tests for Mobile devices was never so easy before, but by using this framework, the scripting time will be reduce by more than 50%. To know more about the framework let's see it's advantages now.

## Advantages:
* Supports Android and iOS devices.
* Enforces Page object model style of coding.
* Easily configureable with config file.
* Allows you to concentrate more on tests then other repeated codings.
* Promotes fluent style coding.
* Has inbuilt assertions to verify the device elements.
* Has pre-defined exceptions which wraps the Selenium and Appium exceptions in a meaningful way.
* Supports testing multiple devices of different platforms to be tested together.

# Usage
You need to use following in your pom.xml in order to use this framework.
```xml
<dependency>
  <groupId>com.github.wasiqb.coteafs</groupId>
  <artifactId>appium</artifactId>
  <version>0.0.1</version>
</dependency>
```
You will also need following supporting dependencies which is also required to be added in your pom file.
```xml
<dependency>
  <groupId>org.apache.logging.log4j</groupId>
  <artifactId>log4j-core</artifactId>
  <version>2.8.2</version>
</dependency>
<dependency>
  <groupId>org.apache.logging.log4j</groupId>
  <artifactId>log4j-api</artifactId>
  <version>2.8.2</version>
</dependency>
<dependency>
  <groupId>io.appium</groupId>
  <artifactId>java-client</artifactId>
  <version>4.1.2</version>
  <exclusions>
    <exclusion>
      <groupId>com.google.guava</groupId>
      <artifactId>guava</artifactId>
    </exclusion>
  </exclusions>
</dependency>
```

# Getting started with the Framework.
## Config file:
This the heart of this framework. It is a yaml file which will have all the settings needed for your tests. The framework will try to find System property `coteafs.appium.config` which will have the path of the config file. If it is not specified, by default, it will search the file at `test-config.yaml` under `src/test/resources` directory. If this file is not found in that location as well, then it will throw `AppiumConfigFileNotFoundException`.

### Supported Server Config List:
Following is the server config list:

Key | Sample Value | Default Value | Description
----|--------------|---------------|------------
`ip` | 127.0.0.1 | null | IP Address
`port` | 4723 | 0 | Port Number
`start_up_time_out_seconds` | 60 | 60 | Wait timeout for Server to start.
`session_timeout` | 120 | 120 | New command timeout value.
`external` | true | false | true, if using external server run from terminal, else, if required for framework to start the server.
`appium_js_path` | path\to\appiumJS | null | Path to **main.js** file in appium installation directory.
`no_reset` | true | false | true, if app reset is not required, else, can be omitted.
`full_reset` | true | false | true, if full reset of app is required, else, can be omitted.

### Supported Device Config List:
Following is the device config list:

Key | Platform | Allowed Values | Description
----|----------|----------------|------------
`device_name` | Both | | Name of the device.
`device_type` | Both | ANDROID, IOS, WINDOWS | Device type.
`device_version` | Both | | Platform version.
`automation_name` | Both | APPIUM, XCUI | Automation used.
`app_name` | IOS | | Application Name
`app_type` | Both | HYBRID, NATIVE, WEB | Application Type.
`app_package` | Android | | Application Package Name.
`app_location` | Both | | Local path to Application apk or ipa file.
`external_app` | Both | true, false | false, if app resides in `src/test/resources` folder, otherwise, true.
`app_activity` | Android | | Loading activity name.
`app_wait_activity` | Android | | Activity name to wait for to load.
`clear_system_files` | Both | true, false | true, will clear all the files after driver quit, else, false.
`default_wait` | Both | Int | Implicit wait.
`wait_for_element_until` | Both | Int | Explicit wait.
`bundle_id` | IOS | | Application Bundle Id.
`udid` | IOS | | Device UDID.
`team_id` | IOS | | Apple Developer 10 char unique id.
`signing_id` | IOS | iPhone Developer | Hardcoded value.
`agent_path` | IOS | | WebDriverAgent project location.
`bootstrap_path` | IOS | | WebDriverAgent xcode project file location.
`updated_wda_bundle_id` | IOS | | Bundle Id for which code is signed.
`use_new_wda` | IOS | true, false | true, will use new wda app everytime, else false.
`use_prebuilt_wda` | IOS | true, false | true, will not build and deploy wda app on device, else, false.
`wda_connection_timeout` | IOS | Int | WDA connection timeout value.
`session_timeout` | Both | Int | New command timeout value.
`no_reset` | Both | false | true, if app reset is not required, else, can be omitted.
`full_reset` | Both | false | true, if full reset of app is required, else, can be omitted.

## Exceptions:
Sometimes it is very difficult to identify what went wrong when we run tests using Appium or Selenium. To handle this, framework handles all the events and throws a meaningful exception which is easy to identify the cause of failure.
Following is the list of exception and their events of occurring:

Exception | Events
----------|-------
`AppiumConfigFileNotFoundException` | When Config file is not found.
`AppiumConfigNotLoadedException` | When some error occurs while loading the config file.
`AppiumConfigParameterNotFoundException` | When the config file is missing mandatory params.
`AppiumServerAlreadyRunningException` | When Appium server is already running.
`AppiumServerNotRunningException` | When Appium server is not running.
`AppiumServerNotStartingException` | When there is Error while starting the server.
`AppiumServerNotStoppingException` | When there is Error while stopping the server.
`AppiumServerStoppedException` | When trying to interact with device while Appium server is stopped.
`DeviceAppNotClosingException` | When there is Error while closing Device app.
`DeviceAppNotFoundException` | When device app is not found on local machine.
`DeviceDesiredCapabilitiesNotSetException` | When device mandatory desired capabilities is not set.
`DeviceDriverDefaultWaitException` | When there is Error while setting implicit waits.
`DeviceDriverInitializationFailedException` | When there is Error while initializing device driver.
`DeviceDriverNotStartingException` | When there is Error while starting device driver.
`DeviceDriverNotStoppingException` | When there is Error while quitting device driver.
`DeviceElementDisabledException` | When you are trying to interact with disabled element.
`DeviceElementFindTimedOutException` | When element is not ready within specified explicit delay given in config file.
`DeviceElementNotDisplayedException` | When you are trying to interact with element which is not yet displayed.
`DeviceElementNotFoundException` | When device element cannot be found.
`DeviceTypeNotSupportedException` | When the mentioned device type is not supported by the framework.

## Logging:
By default, framework create 3 types of log files under `/logs` folder as specified below:

Log File Name | Description
--------------|-------------
`test-log-all.log` | Logs all the events in this file.
`test-log-error.log` | Logs only the errors encountered in this file.
`test-log-main.log` | Logs only the info events in this file.

The name of the file cannot be changed. If it is requested by many, then it can be done.
Following is the sample content of the logs which is generated by the framework.
```
[21:25:58.889] [INFO ] - Preparing to perform actions on iOS device element UserName... (IOSActivity:) 
[21:25:58.903] [INFO ] - Loading elements on iOS activity... (DeviceActivity:) 
[21:26:03.472] [INFO ] - Clearing element [UserName]... (DeviceElementActions:) 
[21:26:05.509] [INFO ] - Entering text [User1] in element [UserName]... (DeviceElementActions:) 
[21:26:07.148] [INFO ] - Preparing to perform actions on iOS device element Password... (IOSActivity:) 
[21:26:12.372] [INFO ] - Clearing element [Password]... (DeviceElementActions:) 
[21:26:14.491] [INFO ] - Entering text [Pass@123] in element [Password]... (DeviceElementActions:) 
[21:26:15.985] [INFO ] - Preparing to perform actions on iOS device element Go... (IOSActivity:) 
[21:26:23.432] [INFO ] - Tapping on element [Go] using [1] finger(s) with [100] ms delay... (DeviceElementActions:) 
```

## Verification of Elements:
It is possible to do assertion on any device element without writing any assertion ourself. This is handled in the framework where you can do assertion on any Element inline. Following is an example on how to do it.

```java
	. . .
	final DashboardActivity main = new DashboardActivity (this.device);
	main.onElement ("TypedAmt")
		.verifyThat ()
		.textShouldBeEqualTo ("$0.1");
	. . .
```
**Neat and clean, is'nt it??**

Following is the list of verification methods available:

Name | Description
-----|------------
`shouldBeDisabled` | Verifies if the element is disabled or not.
`shouldBeDisplayed` | Verifies if the element is displayed or not.
`shouldBeEnabled` | Verifies if the element is enabled or not.
`shouldNotBeDisplayed` | Verifies if the element is hidden or not.
`textShouldBeEqualTo` | Verifies if element text is equal to gievn string or not.

## Handling of Alerts in iOS or Permission Alerts in Android:
This is very commonly encountered when we test Mobile or Tablet devices of Android and iOS platform. It is very elegantly handled in the framework. Following is the code snippet to use it:

**Android Permission Alert**
```java
	. . .
	final LoginActivity login = new LoginActivity (this.androidDevice);
	String message = login.onDevice ().handlePermissionAlert("Allow");
	System.out.println (message);
	. . .
```

**iOS pop-up Alert**
```java
	. . .
	final LoginActivity login = new LoginActivity (this.iosDevice);
	String message = login.onDevice ().handleAlert();
	System.out.println (message);
	. . .
```

## Taking screenshots:
Framework allows you to take screenshots of any Activity which you are working on whenever you need. Following is the code snippet for the same.
```java
	. . .
	final LoginActivity login = new LoginActivity (this.iosDevice);
	login.onDevice ().captureScreenshot ("path/to/file/with/name.extension")
	. . .
```

## Hiding keyboard:
This is also another feature where you can just hide the keyboard when you are done with typing. Following is the code snippet for the same.
```java
	. . .
	final LoginActivity login = new LoginActivity (this.iosDevice);
	login.onDevice ().hideKeyboard ();
	. . .
```

# Sample Test
Let's demonstrate basic example of how to use this framework.

## Sample Config file.
Here we can configure all the required servers and devices. For naming the file, refer the details about this mentioned above.
```yaml
servers:	# should not be changed.
  android:  	# Can be any text, it will be used to refer configs in tests.
    ip: 127.0.0.1
    port: 4723
    external: true
  iphone:	# Can be any text, it will be used to refer configs in tests.
    ip: 127.0.0.1
    port: 4724
    external: true
  ipad:		# Can be any text, it will be used to refer configs in tests.
    ip: 127.0.0.1
    port: 4725
    external: true

devices:	# Should not change.
  android:	# Can be any text, it will be used to refer configs in tests.
    device_type: ANDROID
    device_name: Mi4
    device_version: 6.0.1
    app_type: HYBRID
    automation_name: APPIUM
    app_location: app/android/your_app.apk
    app_package: com.company.package
    app_activity: com.company.activity.MainActivity
    app_wait_activity: com.company.activity.SplashActivity
    session_timeout: 6000
    clear_system_files: true
  iphone:	# Can be any text, it will be used to refer configs in tests.
    device_type: IOS
    device_name: iPhone 6
    device_version: 10.3.1
    udid: XXXX
    bundle_id: com.company.app
    app_type: HYBRID
    app_location: app/iphone/your_app.ipa
    automation_name: XCUI
    app_name: Campus Key
    team_id: XXXXXXXXXX
    signing_id: iPhone Developer
    bootstrap_path: /usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent
    agent_path: /usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/WebDriverAgent.xcodeproj
    session_timeout: 6000
  ipad:		# Can be any text, it will be used to refer configs in tests.
    device_type: IOS
    device_name: iPad Mini 4
    device_version: 10.3.1
    udid: XXXX
    bundle_id: com.company.app
    app_type: HYBRID
    app_location: app/ipad/your_app.ipa
    automation_name: XCUI
    app_name: [Your App Name]
    team_id: XXXXXXXXXX
    signing_id: iPhone Developer
    bootstrap_path: /usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent
    agent_path: /usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent/WebDriverAgent.xcodeproj
    session_timeout: 6000
    wda_connection_timeout: 6000
    full_reset: true
    clear_system_files: true
```

## Sample Activity
For each activity, we need to create an Activity class by extending **AndroidActivity** class if working on Android, or **IOSActivity** if working on IOS device.
```java
import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.appium.device.DeviceElement;
import com.github.wasiqb.coteafs.appium.ios.IOSActivity;
import com.github.wasiqb.coteafs.appium.ios.IOSDevice;

public class LoginActivity extends IOSActivity {
	public LoginActivity (final IOSDevice device) {
		super (device);
	}

  	// You need to implement this protected method and return the root element.
	@Override
	protected DeviceElement prepare () {
    		// This the root element as seen in Inspector.
		final DeviceElement login = DeviceElement.create ("Login")	// <- You can specify any name you want. This will be refered from our tests. It is case sensitive.
			.using (By.className ("UIAApplication"));	// <- Specify the locator you identified using the inspector.
    		// This is the child element of login created above.
		DeviceElement.create ("UserName")
			.parent (login)		// <- Specify the parent of this element.
			.index (1)		// <- Specify the index where this element will be found. can be skipped if there is only 1 element with the specified locator.
			.using (By.className ("UIATextField"));
    		// This is also the child element of login created above.
		DeviceElement.create ("Password")
			.parent (login)
			.using (By.className ("UIASecureTextField"));
    		// This is also the child element of login created above.
		DeviceElement.create ("Login")
			.parent (login)
			.using (By.name ("Sign In"));
		// returning the root element.
		return login;
	}
}
```

## Sample Test
After creating the activity above, you can use it in any testing framework, be it **TestNG**, **JUnit** or **Cucumber**. Following is a sample test written in **TestNG**.
```java
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.github.wasiqb.coteafs.appium.ios.IOSDevice;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

import io.appium.java_client.SwipeElementDirection;

public class IOSHappyPathDemo {
	protected IOSDevice	device;
	protected AppiumServer	server;
  
  	// This is how you can setup the test.
  	@BeforeSuite (alwaysRun = true)
	public void setupTestSuite () {
		// Initializing the server for the device by specifying the name given in config file.
		this.server = new AppiumServer ("ipad");
		// If external = true, will checkif external server is running or no, if not running
		// will throw an exception.
		// If external = false, it will start the server on runtime.
		this.server.start ();

		// This will initialize the device only.
		this.device = new IOSDevice (this.server, "ipad");
		// This will connect to the server and launch the app on connected device.
		this.device.start ();
	}
  
  	// This is how you will teardown the test.
	@AfterSuite (alwaysRun = true)
	public void tearDownTestSuite () {
		if (this.server != null && this.device != null) {
			// Thsi will close the app and quit the device.
			this.device.stop ();
			// If external = false, this will stop the server, else will do nothing.
			this.server.stop ();
		}
	}

  	@Test
	public void test1 () {
		// Initialize the login activity.
		final LoginActivity login = new LoginActivity (this.device);
		// Find and enter text in UserName element.
		login.onElement ("UserName")	// <- Remember, this is the name given while creating the device element in activity?
			.enterText ("UserID_1");
		// Find and enter text in Password element.
		login.onElement ("Password")
			.enterText ("Password1");
		// Find and tap on login button.
		login.onElement ("Login")
			.tap (100);
	}
}
```

# Known issues.
1. Sometimes it is observed that due some conflicting dependencies for **SnakeYaml** and **Google's Guava**, you need to make sure you add exclusion in other library dependenceis (__which is internally using an old version of the above mentioned library__) which you may use in your pom along with this framework. This is how you do this:
```xml
<dependency>
  <groupId>org.testng</groupId>
  <artifactId>testng</artifactId>
  <version>6.11</version>
  <exclusions>
    <exclusion>
      <groupId>org.yaml</groupId>
      <artifactId>snakeyaml</artifactId>
    </exclusion>
    <exclusion>
      <groupId>com.google.guava</groupId>
      <artifactId>guava</artifactId>
    </exclusion>
  </exclusions>
</dependency>
```
If this won't solve the issues, than you need to remove old versions from your **.m2** repository from your local machine for both **SnakeYaml** and **Google's Guava**.

# Following not yet supported
Windows platform is not yet supported which will be done later. We will decide the priority and release it in new releases.
* Windows Devices.
* Simulators / Emulators.
* Starting of Appium server from script for iOS devices.
* Mobile web apps testing on device browsers.
* Parallel execution is not tested, that's why mentioned here. It may work.

# Framework Status
Area | Status
-----|-------
Gitter IM | [![Join the chat at https://gitter.im/wasiqb/coteafs-appium](https://badges.gitter.im/wasiqb/coteafs-appium.svg)](https://gitter.im/wasiqb/coteafs-appium?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
Dependencies | [![Dependency Status](https://www.versioneye.com/user/projects/59269e4925feb9004d428b76/badge.svg)](https://www.versioneye.com/user/projects/59269e4925feb9004d428b76)
Issues | [![Github Issues](http://githubbadges.herokuapp.com/wasiqb/coteafs-appium/issues.svg)](https://github.com/wasiqb/coteafs-appium/issues)
Pull Requests | [![Pending Pull-Requests](http://githubbadges.herokuapp.com/wasiqb/coteafs-appium/pulls.svg)](https://github.com/wasiqb/coteafs-appium/pulls)
Release | [![Github Releases](https://img.shields.io/github/downloads/wasiqb/coteafs-appium/latest/total.svg)](https://github.com/wasiqb/coteafs-appium/releases)
Stars | [![GitHub stars](https://img.shields.io/github/stars/wasiqb/coteafs-appium.svg?style=social&label=Star)](https://github.com/wasiqb/coteafs-appium)
Forks | [![GitHub forks](https://img.shields.io/github/forks/wasiqb/coteafs-appium.svg?style=social&label=Fork)](https://github.com/wasiqb/coteafs-appium)
License | [![GitHub license](https://img.shields.io/github/license/wasiqb/coteafs-appium.svg)](http://www.apache.org/licenses/LICENSE-2.0)
Maven Central | [![Maven Central](https://img.shields.io/maven-central/v/com.github.wasiqb.coteafs/appium.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.wasiqb.coteafs/appium)
