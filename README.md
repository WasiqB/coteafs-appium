<p align="center">
  <img src="./coteafs-appium.png" width=300 padding=10 />
</p>

A Mobile Automation Framework built on top of [Appium][] which supports testing web and native apps for Android, iOS and Windows Mobiles and Tablets whether real or emulators.

[![CircleCI](https://circleci.com/gh/WasiqB/coteafs-appium.svg?style=svg)](https://circleci.com/gh/WasiqB/coteafs-appium)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aappium&metric=bugs)](https://sonarcloud.io/project/issues?id=com.github.wasiqb.coteafs%3Aappium&resolved=false)
[![Test Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aappium&metric=coverage)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Aappium&metric=Coverage)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aappium&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.github.wasiqb.coteafs%3Aappium)
[![Maintainability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aappium&metric=sqale_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Aappium&metric=Maintainability)
[![Reliability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aappium&metric=reliability_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Aappium&metric=Reliability)
[![Security](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aappium&metric=security_rating)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Aappium&metric=Security)
[![Vulnurability](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aappium&metric=vulnerabilities)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Aappium&metric=new_vulnerabilities)
[![Duplicate Code](https://sonarcloud.io/api/project_badges/measure?project=com.github.wasiqb.coteafs%3Aappium&metric=duplicated_lines_density)](https://sonarcloud.io/component_measures?id=com.github.wasiqb.coteafs%3Aappium&metric=Duplications)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.wasiqb.coteafs/appium.svg)][maven]
[![Github Releases](https://img.shields.io/github/downloads/WasiqB/coteafs-appium/total.svg)](https://github.com/WasiqB/coteafs-appium/releases)
[![Github search hit counter](https://img.shields.io/github/search/WasiqB/coteafs-appium/goto.svg)](https://github.com/WasiqB/coteafs-appium)
[![GitHub last commit](https://img.shields.io/github/last-commit/WasiqB/coteafs-appium.svg)](https://github.com/WasiqB/coteafs-appium)

## Why to create yet-another Appium wrapper Framework?
* I couldn't find an easy-to-use framework which had underlying Appium when I started Mobile Automation.
* Also, it was not so easy to identify which capabilities to use for which devices.
* So I came up with this solution for myself and made it open source so everyone can benefit from it.

## Getting Started
* The [wiki][] of coteafs-appium includes all the information you need to get started including setup, usage, advantages, sample test.
* To know what changes are Released, check out the [change log][] for complete list of changes.
* Want to know when our next feature or fix release is going to happen? Watch out our planned [milestones][].

## What to do when you need help?
* **Directly chat with me on my [site][] and I'll revert to you as soon as possible.**
* Discuss your queries by writing to us on our [mailing list][]
* If you find any issue which is bottleneck for you, [search the issue tracker][] to see if it is already raised.
* If not raised, then you can create a [new issue][] with required details as mentioned in the issue template.

## What you do if you like the project?
* Spread the word with your network.
* **Star** the project to make the project popular.
* Stay updated with the project progress by **Watching** it.
* Contribute to fix open issues, documentations or add new features. To know more, see our [contributing][] page.

## Depending coteafs projects
Since **coteafs-appium** is a part of **coteafs** suite, hence it also depends on some of the other coteafs projects:

Name | Description
-----|------------
[coteafs-config][] | Provides support for Yaml file config file.
[coteafs-logger][] | Customizable logger which can be customized by it's config file.
[coteafs-error][] | Custom Error with categorization of errors.
[coteafs-parent][] | Common Parent POM file with build and release configuration.

## Versioning ideology
The project release versioning ideology is adopted from [SemVer][semver].

## Contributors
* [Wasiq Amjad Bhamla][dev]: Framework developer and maintainer
* [Mohammad Faisal Khatri][tester]: Framework Tester

## Thanks

<p align="center">
  <a href="http://browserstack.com">
    <img src="./browserstack-logo-600x315.png" width=300 />
  </a>
</p>
For allowing us to run our unit tests on different platforms.

[wiki]: https://wasiqb.github.io/coteafs/appium/intro/
[unit tests]: https://github.com/WasiqB/coteafs-appium/tree/master/src/test
[site]: https://wasiqb.github.io
[mailing list]: https://groups.google.com/forum/#!forum/coteafs-appium-users
[search the issue tracker]: https://github.com/WasiqB/coteafs-appium/issues?q=something
[new issue]: https://github.com/WasiqB/coteafs-appium/issues/new
[coteafs-logger]: https://github.com/WasiqB/coteafs-logger
[coteafs-config]: https://github.com/WasiqB/coteafs-config
[coteafs-error]: https://github.com/WasiqB/coteafs-error
[coteafs-parent]: https://github.com/WasiqB/coteafs-parent
[Appium]: https://github.com/appium/java-client/releases
[change log]: CHANGELOG.md
[milestones]: https://github.com/WasiqB/coteafs-appium/milestones
[semver]: http://semver.org/
[license]: http://www.apache.org/licenses/LICENSE-2.0
[maven]: https://maven-badges.herokuapp.com/maven-central/com.github.wasiqb.coteafs/appium
[dev]: https://github.com/WasiqB/
[tester]: https://github.com/mfaisalkhatri
[contributing]: .github/CONTRIBUTING.md
