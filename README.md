# GIV-planner
______

"A Google-Integrated Van planner"

# Overview
______

Tired of creating hundreds of Google Calendar Events manually? Well,
then the **Giv-planner** is for you! Give it a shot!

*GIV-planner* is a command line scheduler tool, calculating the best route to a number of locations given a time frame.

# Requirements
______
+ [Java
  7.0](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) < (at least)
+ Git v1.9.X < (optional - for cloning, making changes to the source
  code)
+ Google Account
+ Google Script

# Installing
______
The best, and easiest, way to obtain **GIV-planner** is to **clone** it using the `git
clone` command.

The following command is the `git clone` command using
SSH protocol:

```
git clone git@github.com:kinneerc/giv-planner.git
```

To `clone` a Git repository requires that you have `Git` installed on
your machine. A Git client will allow you to make changes, branches,
merges, and maintain your own copy of **GIV-planner** without downloading
an entire copy of updated versions of **GIV-planner**.

Downloading the
`ZIP` of **GIV-planner** will not allow you to do any of these things.
Downloading the `ZIP` is mostly meant for people who just want to get the
tool and not make changes.

To download the `ZIP`, **click** the **Download ZIP** button displayed
below:

![alt
tag](https://raw.githubusercontent.com/kinneerc/giv-planner/master/images/zip.png?token=AFShGHuvKKjpAhdVFgd5cGK_qN4TeiTEks5WbjC-wA%3D%3D)

Downloading the ZIP will place `giv-planner-master.zip` in your
`Downloads/` folder. See the image located directly below.

_Note: This
example was taken on a Mac, your file system may look different than the
example._

![alt
tag](https://raw.githubusercontent.com/kinneerc/giv-planner/master/images/download.png?token=AFShGK2760yAnY8XvT83IFfULdDPWpX-ks5WbjRKwA%3D%3D)

# Preparation
______
+ Relocate **GIV-planner**
+ Unzip **GIV-planner**
+ Launch Terminal or Command Prompt
+ Change into `giv-planner-master` directory

### Relocating **GIV-planner**
While in your `Downloads/` directory, highlight the **unzipped** `giv-planner-master`
and then **drag-and-drop** to the new location where you would like to
be able to access the tool in the future.

### Unzip GIV-planner
After downloading the ZIP to your local machine, you will need to
"unzip" the ZIP. You can do this simple by a *double-click* on the ZIP.
You may have to **right-click** on the zipped folder and choose
**Extract All**---depending on your operating system.

In doing so, an unzipped folder will appear---displayed in the figure
below.

_Note: This
example was taken on a Mac, your file system may look different than the
example. Also, unzipping a file may require a different process in a
different operating system._

![alt
tag](https://raw.githubusercontent.com/kinneerc/giv-planner/master/images/unzip.png?token=AFShGAKYvj80_hhNVdrGyNFhQgx2b6Ydks5WbjVFwA%3D%3D)

### Launch Terminal or Command Prompt
Our system, in its current state, requires you to use the
Terminal (OSX, Linux) or Command Prompt (Windows).
Launching the Terminal/Command Prompt will put you in your home directory.
After launching Terminal/Command Prompt, you will need to navigate to
the `giv-planner-master` directory. This will depend on where you chose
to relocate the tool in the previous step.

### Change Directory
You will need to navigate
your file system using the following command until you are able to locate the
`giv-planner-master` directory.

The following command is the
`cd <folder_name/to/giv-planner-master>` command or **Change Directory** command:

```
# OSX/Linux
cd <folder_name/path/to/giv-planner-master>

# Windows (backslash instead of forwardslash)
cd <folder_name\path\to\giv-planner-master>
```

By default, remember that the ZIP downloaded to your `Downloads/`
directory. Depending on where you extracted the ZIP to will determine
where the unzipped directory is located. By default, it should have also
extracted to the `Downloads/` directory.

So the following command should be applicable to you:

```
# That is not a typo. In the extraction process it puts it in a folder
# of the same name

cd Downloads\giv-planner-master\giv-planner-master\
```

Once you are in the `giv-planner-master` directory, give yourself a pat
on the back before moving to the next section, you are on your way to
becoming a computer expert hacking away in the Terminal/Command Prompt.

# Usage
______
In the current state, we use [Gradle](http://gradle.org/) a Java build
tool to manage the system's tasks.

## Steps
+ Start Gradle
+ Run (with Gradle)

### Start Gradle
Starting Gradle is easy!

Again, you will see that this step is operating system dependent.

```
# OSX/Linux
./gradlew

# Windows
gradlew.bat
```

Running the above commands should provide you with output similar to the
following:

```
Starting a new Gradle Daemon for this build (subsequent builds will be
faster).
:help

Welcome to Gradle 2.9.

To run a build, run gradlew <task> ...

To see a list of available tasks, run gradlew tasks

To see a list of command-line options, run gradlew --help

To see more detail about a task, run gradlew help --task <task>

BUILD SUCCESSFUL

Total time: 6.197 secs
```

If you want to be less cool, you can navigate to the
`giv-planner-master` folder from **My Documents** and then just
**double-click** the `gradlew` Windows batch file. Remember, this will
automatically make you less "cool".

## Run (with Gradle)
Again, Gradle makes running this system very easy. Running this system
is as easy as the following command:

```
# OSX/Linux
./gradlew run

# Windows
gradlew run
```

If you do not get output similar to this, please refer to the FAQ
sections below.

# FAQ
+ [**JAVA_HOME** is not set and no **java** command can be
  found](https://docs.oracle.com/cd/E19509-01/820-3208/inst_cli_jdk_javahome_t/)

# Feedback
______

If you like it, hate it, or have some ideas for new features, submit a
issue request
[here](https://github.com/kinneerc/giv-planner/issues) and we will
respond as soon as possible!

# Contributors
______

+ Cody Kinneer ([kinneerc](https://github.com/kinneerc))
+ Colton McCurdy ([mccurdyc](https://github.com/mccurdyc))
+ Ayodele Hamilton([AyodeleH](https://github.com/AyodeleH))
+ Brandon Ginoza ([ginozab](https://github.com/ginozab))
+ Almog Boanos
+ SJ Guillaume

# License
______

## [GNU General Public License v3.0](https://raw.githubusercontent.com/kinneerc/giv-planner/master/LICENSE?token=AFShGG2RnNTW6ARDo5z4iz-d6RNIswD3ks5Wbj-AwA%3D%3D)

The GNU General Public License is a free, copyleft license for software
and other kinds of works.
The licenses for most software and other practical works are designed to
take away your freedom to share and change the works. By contrast, the
GNU General Public License is intended to guarantee your freedom to
share and change all versions of a program--to make sure it remains free
software for all its users. We, the Free Software Foundation, use the
GNU General Public License for most of our software; it applies also to
any other work released this way by its authors. You can apply it to
your programs, too.
When we speak of free software, we are referring to freedom, not price.
Our General Public Licenses are designed to make sure that you have the
freedom to distribute copies of free software (and charge for them if
you wish), that you receive source code or can get it if you want it,
that you can change the software or use pieces of it in new free
programs, and that you know you can do these things.
To protect your rights, we need to prevent others from denying you these
rights or asking you to surrender the rights. Therefore, you have
certain responsibilities if you distribute copies of the software, or if
you modify it: responsibilities to respect the freedom of others.
For example, if you distribute copies of such a program, whether gratis
or for a fee, you must pass on to the recipients the same freedoms that
you received. You must make sure that they, too, receive or can get the
source code. And you must show them these terms so they know their
rights.
Developers that use the GNU GPL protect your rights with two steps: (1)
assert copyright on the software, and (2) offer you this License giving
you legal permission to copy, distribute and/or modify it.
For the developers' and authors' protection, the GPL clearly explains
that there is no warranty for this free software. For both users' and
authors' sake, the GPL requires that modified versions be marked as
changed, so that their problems will not be attributed erroneously to
authors of previous versions.
Some devices are designed to deny users access to install or run
modified versions of the software inside them, although the manufacturer
can do so. This is fundamentally incompatible with the aim of protecting
users' freedom to change the software. The systematic pattern of such
abuse occurs in the area of products for individuals to use, which is
precisely where it is most unacceptable. Therefore, we have designed
this version of the GPL to prohibit the practice for those products. If
such problems arise substantially in other domains, we stand ready to
extend this provision to those domains in future versions of the GPL, as
needed to protect the freedom of users.
Finally, every program is threatened constantly by software patents.
States should not allow patents to restrict development and use of
software on general-purpose computers, but in those that do, we wish to
avoid the special danger that patents applied to a free program could
make it effectively proprietary. To prevent this, the GPL assures that
patents cannot be used to render the program non-free.
The precise terms and conditions for copying, distribution and
modification follow [GNU General Public License
v3.0](https://raw.githubusercontent.com/kinneerc/giv-planner/master/LICENSE?token=AFShGG2RnNTW6ARDo5z4iz-d6RNIswD3ks5Wbj-AwA%3D%3D).

