## Contributing

I appreciate your interest for contributing in enhancing and evolving the coteafs-appium framework.

### 1. Where to start from?

If you've noticed a bug or have a question that doesn't belong on the
[mailing list][] or [Stack Overflow][], [search the issue tracker][tracker] to see if
someone else has already created a ticket. If not, go ahead and
[add one][new issue]!

### 2. Want to fix an issue or add new feature?

If this is something you think you can fix, then follow the following steps:

#### Step 0: Discuss with us

Before jumping on any ticket or any feature which you think should be there in the framework, discuss with us [here][groupdDevs]. Once you get go-ahead from us, you can proceed by following the steps mentioned hereafter.

#### Step 1: Setup your E-mail in Git

Assuming you have already done this. But if you are new and may forget this, you can do it as described [here][setup].

#### Step 2: Fork and clone coteafs-appium

To Fork **coteafs-appium** and clone it, see this useful [post][fork].

#### Step 3: Create new Branch

Now create a new branch with descriptive name in your forked repo. Refer [here][branch] to know about Git branches.

#### Step 4: Make changes

Make changes and commit it in your newly created branch. Also write Javadocs for methods, unit tests, update the [CHANGELOG][changelogs].

#### Step 5: Commit with a descriptive message

If committing a fix for a ticket, always start with `Fixed #[Ticket ID]` than describe the changes in detail.
For an example on how to write a proper commit message, see [this][commitHelp] post.

#### Step 6: Push changes to your cloned fork

After committing the changes, you need to push the commit to your cloned repo by executing `git push origin your-branch-name` command in the terminal.

#### Step 7: Send PR to us

Sending Pull Request will be the last step of your contribution. To know how to raise a PR, see [this][pr] post.

> **NOTE:** From your second contribution onwards, you can skip steps **(1) and (2)**.

To run the build,
1. Configure your device details in 'appium-config.yaml' file available at `src/test/resources` under `devices/test`.
1. Connect Android devices to your machine or start the emulators.
1. Run the tests from the command prompt by executing `mvn clean install`.

[mailing list]: https://groups.google.com/forum/#!forum/coteafs-appium
[Stack Overflow]: http://stackoverflow.com/questions/tagged/coteafs-appium
[tracker]: https://github.com/WasiqB/coteafs-appium/issues?q=something
[new issue]: https://github.com/WasiqB/coteafs-appium/issues/new
[fork]: https://help.github.com/articles/fork-a-repo/
[branch]: https://www.atlassian.com/git/tutorials/using-branches
[setup]: https://help.github.com/articles/setting-your-commit-email-address-in-git
[groupdDevs]: https://groups.google.com/forum/#!forum/coteafs-appium-devs
[changelogs]: ../CHANGELOG.md
[commitHelp]: https://github.com/erlang/otp/wiki/Writing-good-commit-messages
[pr]: https://help.github.com/articles/creating-a-pull-request
