TheActivityManager
==================

<a href="http://developer.android.com/index.html" target="_blank"><img src="https://img.shields.io/badge/platform-android-green.svg"/></a> <a href="https://android-arsenal.com/api?level=8" target="_blank"><img src="https://img.shields.io/badge/API-8%2B-green.svg?style=flat"/></a> <a href="http://opensource.org/licenses/MIT" target="_blank"><img src="https://img.shields.io/badge/License-MIT-blue.svg?style=flat"/></a> <a href="http://search.maven.org/#search%7Cga%7C1%7CTheActivityManager" target="_blank"><img src="https://img.shields.io/maven-central/v/com.yayandroid/TheActivityManager.svg"/></a>

<a href="http://www.methodscount.com/?lib=com.yayandroid%3ATheActivityManager%3A1.0.5" target="_blank"><img src="https://img.shields.io/badge/Methods count-74-e91e63.svg"></img></a> <a href="http://www.methodscount.com/?lib=com.yayandroid%3ATheActivityManager%3A1.0.5" target="_blank"><img src="https://img.shields.io/badge/Size-19 KB-e91e63.svg"></img></a> <a href="http://android-arsenal.com/details/1/3150" target="_blank"><img src="https://img.shields.io/badge/Android%20Arsenal-TheActivityManager-brightgreen.svg?style=flat"/></a>

<b> Tested with [Leak Canary][1] </b>

Android OS starts activities up to intents you send as a broadcast, but because it is done privately, you cannot track those activities. You may never know which activity is currently visible, unless you work around somehow. This library will provide you to manage that.

This library uses a singleton class to create a static object and keep instances of your activities. So, you can reach them out whenever you want, and do whatever you wish. 

## Configuration

To use this library, you need to notify TheActivityManager `onCreate`, `onResume`, `onPause` and `onDestroy` of activity. 

You can call these methods by yourself in every activity that you create

<b>OR</b>

To simplify this step i created a `TAMBaseActiviy`, which extends from AppCompatActivity, so just extend your activities from this and it will take care of the rest. 

<b>OR</b>

if your application's minSdkVersion >= 14 then you can simply call `TheActivityManager.getInstance().configure(application)` and it will handle all.

<b>CAUTION:</b> If you call configure method, you MUST call it only once, and you MUST NOT extend your activities from `TAMBaseActiviy` otherwise it will create multiple instance in TheActivityManager array, which may cause crash!

## Usage

```java 
TheActivityManager.getInstance().getCurrentActivity(); 
```
<ul><li>
This method basically return the instance of current activity and you can use it to compare with something or display dialog, popup or whatever you wish, you can call any method on that activity now. This will provide you to access almost every activity.
</li></ul>

```java  
TheActivityManager.getInstance().isApplicationRunning();  
```
<ul><li>
You can check whether application is currently running or it's been paused for some reason. For instance, you have a service to download something and when it is completed you can just check whether user is still using the application or not, you can have different ways to go.
</li></ul>

```java 
TheActivityManager.getInstance().finishAll();  
```
<ul><li>
It doesn't matter how deeply you are in the application, this method will finish all of activities and will quit application.
</li></ul>

```java 
TheActivityManager.getInstance().toLanding();  
```
<ul><li>
It doesn't matter how deeply you were visiting detail pages on application, this method will turn you back to landing page which you should set first by calling `setAsLanding` method otherwise it will just act like `finishAll` method.
</li></ul>

```java 
TheActivityManager.getInstance().setNextStep(activityTransporter);  
```
<ul><li>
Let's assume that you have Activity A and C but before you go to C you need to do something in Activity B. So you tell TheActivityManager that C is your nextStep with the extras if necessary and when you done with B just call moveForward method and TheActivityManager will lead user to that acitivity with already given extras. 
</li></ul>

## Download
Add library dependency to your `build.gradle` file:

```groovy
dependencies {    
     compile 'com.yayandroid:TheActivityManager:1.0.6'
}
```

Name Story
----------

I thought to name it as ActivityManager but didn't want it to be confused with Android's ActivityManager and than my friend remind me [John Carmack][2]'s tweet and it was just perfect fit, so it became "TheActivityManager".

<blockquote class="twitter-tweet" lang="tr"><p>I have moved to naming global singletons with a The* prefix -- ThePacketServer, TheMasterServer, TheVoip, etc. Feels pretty good.</p>&mdash; John Carmack (@ID_AA_Carmack) <a href="https://twitter.com/ID_AA_Carmack/status/575788622554628096">11 Mart 2015</a></blockquote>
<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>

Compatibility
-------------

This library works on 2.2+ probably earlier as well, but i didn't even bother to test because i believe at some point we have to stop supporting every version ;)


## License

```
The MIT License (MIT)

Copyright (c) 2015 yayandroid

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```

[1]: https://github.com/square/leakcanary
[2]: https://twitter.com/ID_AA_Carmack
