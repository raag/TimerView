## Installation

Add in your root build.gradle at the end of repositories:

```html
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency in your module build.gradle
```html
   implementation 'com.github.raag:TimerView:v0.5.1beta'
```
