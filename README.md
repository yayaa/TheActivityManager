TheActivityManager
==================

Android OS starts activities up to intents you send as a broadcast, but because it is done privately, you cannot track those activities. You may never know which activity is currently visible, unless you work around somehow. This library will provide you to manage that.

This library uses a singleton class to create a static object and keep instances of your activities. So, you can reach them out whenever you want, and do whatever you wish. 

To use this library, you need to notify TheActivityManager `onCreate`, `onResume`, `onPause` and `onDestroy` of activity. Or you can simply extend `ManagerBaseActiviy` and it will take care of the rest. 

This project is under [MIT license][2] 

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

[![Maven Central](https://img.shields.io/maven-central/v/com.yayandroid/TheActivityManager.svg)](http://search.maven.org/#search%7Cga%7C1%7CTheActivityManager)
```groovy
dependencies {    
     compile 'com.yayandroid:TheActivityManager:1.0.1'
}
```

Name Story
----------

I thought to name it as ActivityManager but didn't want it to be confused with Android's ActivityManager and than my friend remind me [John Carmack][1]'s tweet and it was just perfect fit, so it became "TheActivityManager".

<blockquote class="twitter-tweet" lang="tr"><p>I have moved to naming global singletons with a The* prefix -- ThePacketServer, TheMasterServer, TheVoip, etc. Feels pretty good.</p>&mdash; John Carmack (@ID_AA_Carmack) <a href="https://twitter.com/ID_AA_Carmack/status/575788622554628096">11 Mart 2015</a></blockquote>
<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>

Compatibility
-------------

This library works on 2.2+ probably earlier as well, but i didn't even bother to test because i believe at some point we have to stop supporting every version ;)


[1]: https://twitter.com/ID_AA_Carmack
[2]: http://opensource.org/licenses/mit-license.php
