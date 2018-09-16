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
