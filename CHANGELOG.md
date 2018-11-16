## Version-3.0.0-beta1 - Coming soon
- **[BREAKING CHANGE]** [#38][38] : Added support to add multiple locators depending on Platform and Automation type.
  - Removed method `using` from `DeviceElement` and added `forAndroid` and forIos` methods to capture locators for Android and iOS platforms.
- **[ENHANCEMENT]** [#50][50] : Support for cloud based solution like BrowserStack, SauceLabs, etc.
- **[ENHANCEMENT]** [#54][54] : Updated README.
- **[ENHANCEMENT]** [#60][60] : Battery check is added. No action will be performed and execution will fail if Battery level is less than 20%.
- **[ENHANCEMENT]** [#56][56] :  Video record tests for Android and iOS.
- **[ENHANCEMENT]** [#63][63] : Common settings block for device and server section in config file.
- **[ENHANCEMENT]** [#75][75] : New missing actions added:
  - [x] Double tap
  - [x] N Tap
  - [x] Get Orientation
  - [x] Set Orientation
  - [x] Toggle Wifi (_Only Android_)
  - [x] Toggle Data (_Only Android_)
  - [x] Toggle Airplane (_Only Android_)
  - [x] Toggle Location service (_Only Android_)
  - [x] Get Clipboard (Text, Image, URL)
- **[FIX]** [#41][41] : Refactoring for latest Appium Java client.
- **[FIX]** [#42][42] : Build moved from Travis CI to Circle CI.
- **[FIX]** [#62][62] : Port handling for SauceLabs.
- **[FIX]** [#65][65] : NullPointerException when some keys missing from config.
- **[FIX]** [#71][71] : Error when only package name given instead of `app_location` config key.
- **[FIX]** [#78][78] : Action class not support for iOS, gestures handled with commands.
- **[UPGRADE]** [#51][51] : Upgraded dependencies:
  - **coteafs-parent:** 1.5.0 -> 2.1.0
  - **coteafs-config:** 1.5.0 -> 1.7.0
  - **coteafs-error:** 1.4.0 -> 1.6.0
  - **coteafs-logger:** 1.5.0 -> 1.7.0
  - **selenium-java:** 3.10.0 -> 3.141.5
  - **appium-java:** 5.0.4 -> 6.1.0

## Version-2.2.0 - 16/03/2018
### Missing Features:
* [#23][23]: UiAutomator is not supported in the framework.
* [#24][24]: Swipe on element does not work.
* [#37][37]: No availability to press enter key after entering search text in the search bar of the app.

### Fixes:
* [#26][26], [#28][28], [#29][29], [#30][30], [#31][31], [#32][32], [#33][33], [#34][34], [#35][35], [#36][36]: Code Climate issues.

### Dependencies Update:
* **coteafs-parent:** 1.4.0 -> 1.5.0
* **selenium-java:** 3.9.1 -> 3.10.0
* **coteafs-config:** 1.4.0 -> 1.5.0
* **coteafs-error:** 1.3.0 -> 1.4.0
* **coteafs-logger:** 1.4.0 -> 1.5.0

> Sample config file attached with release for reference.

## Version-2.1.0 - 08/12/2017
### Enhancements
* [#20][20] - Log file should be backedup and new logs should be created on every run.
* [#21][21] - Screenshot should be captured on UI action failure.

### Bug fixes
* [#19][19] - Error displayed in the console is not captured in log file.
* [#22][22] - Unable to run the tests using Chrome browser on Android mobile.

## Version-2.0.0 - 09/11/2017
* [#1][1] **- [NEW] -** Add unit tests for the Framework for Android.
* [#5][5] **- [NEW] -** Allow multiple inline verification on an element.
* [#9][9] **- [NEW] -** Required:New feature in the Framework - Dynamic Screenshot Naming Convention.
* [#11][11] **- [NEW] -** Incorporate latest Appium Java client v-5.0.0 for device level actions.
* [#12][12] **- [NEW] -** Provide support for Windows devices.
* [#13][13] **- [FIXED] -** Error "Missing artifact com.github.wasiqb.coteafs:configs:jar:${coteafs.config.version}"
* [#14][14] **-[NEW] -** Require configurable delay between user actions.
* [#15][15] **- [NEW] -** New Abstract class for Activity Actions needs to be added.
* [#16][16] **- [NEW] -** In config file, port should be made optional.
* [#17][17] **- [NEW] -** Need support for multiple Server Arguments.

## Version-1.0.0 - 27/08/2017
* [#2][2] **- [NEW] -** Provide support to Mobile Web App Automation for Android and iOS
* [#3][3] **- [NEW] -** Provide support for executing run on simulators / emulators for Android and iOS.
* [#7][7] **- [NEW] -** Incorporate coteafs-config project.
* [#8][8] **- [NEW] -** Feature to handle dynamic elements like lists and tables.
* [#10][10] **- [NEW] -** Allow configurable logging.
* [#4][4] **- [FIXED] -** No proper Exception when name is incorrect in method onElement.
* [#6][6] **- [FIXED] -** Solve issues in code identified by SonarQube.

## Initial Version 0.0.1
See README file for details.

[1]: https://github.com/WasiqB/coteafs-appium/issues/1
[2]: https://github.com/WasiqB/coteafs-appium/issues/2
[3]: https://github.com/WasiqB/coteafs-appium/issues/3
[4]: https://github.com/WasiqB/coteafs-appium/issues/4
[5]: https://github.com/WasiqB/coteafs-appium/issues/5
[6]: https://github.com/WasiqB/coteafs-appium/issues/6
[7]: https://github.com/WasiqB/coteafs-appium/issues/7
[8]: https://github.com/WasiqB/coteafs-appium/issues/8
[9]: https://github.com/WasiqB/coteafs-appium/issues/9
[10]: https://github.com/WasiqB/coteafs-appium/issues/10
[11]: https://github.com/WasiqB/coteafs-appium/issues/11
[12]: https://github.com/WasiqB/coteafs-appium/issues/12
[13]: https://github.com/WasiqB/coteafs-appium/issues/13
[14]: https://github.com/WasiqB/coteafs-appium/issues/14
[15]: https://github.com/WasiqB/coteafs-appium/issues/15
[16]: https://github.com/WasiqB/coteafs-appium/issues/16
[17]: https://github.com/WasiqB/coteafs-appium/issues/17
[19]: https://github.com/WasiqB/coteafs-appium/issues/19
[20]: https://github.com/WasiqB/coteafs-appium/issues/20
[21]: https://github.com/WasiqB/coteafs-appium/issues/21
[22]: https://github.com/WasiqB/coteafs-appium/issues/22
[23]: https://github.com/WasiqB/coteafs-appium/issues/23
[24]: https://github.com/WasiqB/coteafs-appium/issues/24
[26]: https://github.com/WasiqB/coteafs-appium/issues/26
[28]: https://github.com/WasiqB/coteafs-appium/issues/28
[29]: https://github.com/WasiqB/coteafs-appium/issues/29
[30]: https://github.com/WasiqB/coteafs-appium/issues/30
[31]: https://github.com/WasiqB/coteafs-appium/issues/31
[32]: https://github.com/WasiqB/coteafs-appium/issues/32
[33]: https://github.com/WasiqB/coteafs-appium/issues/33
[34]: https://github.com/WasiqB/coteafs-appium/issues/34
[35]: https://github.com/WasiqB/coteafs-appium/issues/35
[36]: https://github.com/WasiqB/coteafs-appium/issues/36
[37]: https://github.com/WasiqB/coteafs-appium/issues/37
[38]: https://github.com/WasiqB/coteafs-appium/issues/38
[41]: https://github.com/WasiqB/coteafs-appium/issues/41
[42]: https://github.com/WasiqB/coteafs-appium/issues/42
[50]: https://github.com/WasiqB/coteafs-appium/issues/50
[51]: https://github.com/WasiqB/coteafs-appium/issues/51
[54]: https://github.com/WasiqB/coteafs-appium/issues/54
[56]: https://github.com/WasiqB/coteafs-appium/issues/56
[60]: https://github.com/WasiqB/coteafs-appium/issues/60
[62]: https://github.com/WasiqB/coteafs-appium/issues/62
[63]: https://github.com/WasiqB/coteafs-appium/issues/63
[65]: https://github.com/WasiqB/coteafs-appium/issues/65
[71]: https://github.com/WasiqB/coteafs-appium/issues/71
[75]: https://github.com/WasiqB/coteafs-appium/issues/75
[78]: https://github.com/WasiqB/coteafs-appium/issues/78