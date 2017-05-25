# coteafs-appium
This is an easy to use Mobile Automation Framework build on top of Appium. It is completely configurable thru the config file. It can be used to test native Mobile app for iOS and Android platform. This framework introduces AOM (Activity Object Model) concept similar to Page Object Model and promotes fluent coding style. Main aim behind this framework is to minimize the line of codes needed to write tests as all the heavy weight lifting is done by the framework itself.

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
This the heart of this framework. It is a yaml file which will have all the settings needed for your tests. The framework will try to find System property `coteafs.appium.config` which will have the path of the config file. If it is not specified, by default, it will search the file at `src/test/resources/test-config.yaml`. If this file is not found, then it will throw `AppiumConfigFileNotFoundException`.

## Supported Server Config List:
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

## Supported Device Config List:
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

# Sample Test
Let's demonstrate basic example of how to use this framework.

## Sample Config file.
Here we can configure all the required servers and devices.
```yaml
servers:
  android:  // Used to refer config in tests.
    ip: 127.0.0.1
    port: 4723
    external: true
  iphone:
    ip: 127.0.0.1
    port: 4724
    external: true
  ipad:
    ip: 127.0.0.1
    port: 4725
    external: true

devices:
  android:
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
  iphone:
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
  ipad:
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
For each activity, we need to create an Activity class extending **AndroidActivity** class if working on Android, or **IOSActivity** if working on IOS.
```java
import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.appium.device.DeviceElement;
import com.github.wasiqb.coteafs.appium.ios.IOSActivity;
import com.github.wasiqb.coteafs.appium.ios.IOSDevice;

public class LoginActivity extends IOSActivity {
	public LoginActivity (final IOSDevice device) {
		super (device);
	}

  // You need to implement this protected method.
	@Override
	protected DeviceElement prepare () {
    // This the root element as seen in Inspector.
		final DeviceElement login = DeviceElement.create ("Login")
			.using (By.className ("UIAApplication"));
    // This is the child element of login created above.
		DeviceElement.create ("UserName")
			.parent (login)
			.using (By.className ("UIATextField"));
    // This is also the child element of login created above.
		DeviceElement.create ("Password")
			.parent (login)
			.using (By.className ("UIASecureTextField"));
    // This is also the child element of login created above.
		DeviceElement.create ("Login")
			.parent (login)
			.using (By.name ("Sign In"));
		return login;
	}
}
```

## Sample Test
After creating the activity above, you now will move straight to writing tests. Below is a sample test.
```java
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.github.wasiqb.coteafs.appium.ios.IOSDevice;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

import io.appium.java_client.SwipeElementDirection;

public class IOSHappyPathDemo {
	protected IOSDevice	device;
	protected AppiumServer	server;
  
  @BeforeSuite (alwaysRun = true)
	public void setupTestSuite () {
		this.server = new AppiumServer ("ipad");
		this.server.start ();

		this.device = new IOSDevice (this.server, "ipad");
		this.device.start ();
	}
  
	@AfterSuite (alwaysRun = true)
	public void tearDownTestSuite () {
		if (this.server != null && this.device != null) {
			this.device.stop ();
			this.server.stop ();
		}
	}

  @Test
	public void test1 () {
		final LoginActivity login = new LoginActivity (this.device);
		login.onElement ("UserName")
			.enterText ("UserID_1");
		login.onElement ("Password")
			.enterText ("Password1");
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

2. For now, you must use external server as server started from Framework is causing problem for IOS. For Android it works.

## Following not yet supported
Windows platform is not yet supported which will be done later.
* Windows Platform
* Mobile web apps

# Framework Status
Area | Status
-----|-------
Dependencies | [![Dependency Status](https://www.versioneye.com/user/projects/59269e4925feb9004d428b76/badge.svg)](https://www.versioneye.com/user/projects/59269e4925feb9004d428b76)
Issues | [![Github Issues](http://githubbadges.herokuapp.com/wasiqb/coteafs-appium/issues.svg)](https://github.com/wasiqb/coteafs-appium/issues)
Pull Requests | [![Pending Pull-Requests](http://githubbadges.herokuapp.com/wasiqb/coteafs-appium/pulls.svg)](https://github.com/wasiqb/coteafs-appium/pulls)
Release | [![Github Releases](https://img.shields.io/github/downloads/wasiqb/coteafs-appium/latest/total.svg)](https://github.com/wasiqb/coteafs-appium/releases)
Stars | [![GitHub stars](https://img.shields.io/github/stars/wasiqb/coteafs-appium.svg?style=social&label=Star)](https://github.com/wasiqb/coteafs-appium)
Forks | [![GitHub forks](https://img.shields.io/github/forks/wasiqb/coteafs-appium.svg?style=social&label=Fork)](https://github.com/wasiqb/coteafs-appium)
License | [![GitHub license](https://img.shields.io/github/license/wasiqb/coteafs-appium.svg)](http://www.apache.org/licenses/LICENSE-2.0)
Maven Central | [![Maven Central](https://img.shields.io/maven-central/v/com.github.wasiqb.coteafs/appium.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.wasiqb.coteafs/appium)
