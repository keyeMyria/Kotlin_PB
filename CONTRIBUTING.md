# Introduction

This is the first draft of our coding conventions inside the MeGo android team. This will most conveniently be synced with the coding conventions across the MeGo team.
We will focus first on our "Code-style conventions" and incrementally we will include more topics.

## Code-style conventions
We apply the AOSP(Android Open Source Project) code style with a set of custom modification. The related custom modifications are listed as follow:

### Setup the style file in Android Studio
**Step 1 Get the style xml file**

Download the style file [Here](https://https://gitlab.com/mego/android/blob/master/MeGoStyle.xml)

**Step 2 Add the definitions file to your Android codestyles folder**

Move the style file within your .AndroidStudio configuration folder on your machine. The exact location will vary not only between operating systems, but also Android Studio versions.

> On MacOS:
`~/Library/Preferences/.AndroidStudio[Version Number]/config/codestyles`

> On Linux
`/home/username/.AndroidStudio[Version Number]/config/codestyles`

**Step 3: Apply the code style to your project**

Restart Android Studio to allow the new code style to be found. Open the Code Style settings in the IDE.  A new entry JodelAndroidStyle should be in the list of available code styles.  Select and click Copy to Project to apply it to the current project. Then apply the formatting by running the Reformat Code tool across your source.