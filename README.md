## Installation

Add in your root build.gradle at the end of repositories:

allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}

Add the dependency in your module build.gradle
 
   implementation 'com.github.raag.TimerView:v0.5beta'
 
