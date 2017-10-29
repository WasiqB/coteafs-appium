# coteafs-appium

A Mobile Automation Framework built on top of [Appium][] which supports testing web and native apps for Android, iOS and Windows Mobiles and Tablets whether real or emulators.

[![GitHub license](https://img.shields.io/github/license/wasiqb/coteafs-appium.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.wasiqb.coteafs/appium.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.wasiqb.coteafs/appium)

## Why to create yet-another Appium wrapper Framework?
* I couldn't find an easy-to-use framework which had underlying Appium when I started Mobile Automation.
* Also, it was not so easy to identify which capabilities to use for which devices.
* So I came up with this solution for myself and made it open source so everyone can benefit from it.

## Getting Started
* The [wiki][] of coteafs-appium includes all the information you need to get started including usage, advantages, sample test.
* For sample project, have a look at the [unit tests][] for coteafs-appium.

## What to do when you need help?
* Join the discussion on our [Gitter][] chats.
* Discuss your queries by writing to us on our [mailing list][]
* If you find any issue which is bottleneck for you, [search the issue tracker][] to see if it is already raised.
* If not raised, then you can create a [new issue][] with required details as mentioned in the issue template.

## Depending coteafs projects
Since **coteafs-appium** is a part of **coteafs** suite, hence it also depends on some of the other coteafs projects:

Name | Description
-----|------------
[coteafs-config][] | Provides support for Yaml file config file.
[coteafs-logger][] | Customizable logger which can be customized by it's config file.
[coteafs-error][] | Custom Error with categorization of errors.
[coteafs-parent][] | Common Parent POM file with build and release configuration.

[wiki]: https://github.com/WasiqB/coteafs-appium/wiki
[unit tests]: https://github.com/WasiqB/coteafs-appium/tree/master/src/test
[Gitter]: https://gitter.im/wasiqb/coteafs-appium
[mailing list]: https://groups.google.com/forum/#!forum/coteafs-appium
[search the issue tracker]: https://github.com/WasiqB/coteafs-appium/issues?q=something
[new issue]: https://github.com/WasiqB/coteafs-appium/issues/new
[coteafs-logger]: https://github.com/WasiqB/coteafs-logger
[coteafs-config]: https://github.com/WasiqB/coteafs-config
[coteafs-error]: https://github.com/WasiqB/coteafs-error
[coteafs-parent]: https://github.com/WasiqB/coteafs-parent
[Appium]: https://github.com/appium/java-client/releases
