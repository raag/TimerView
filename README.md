## Installation

Add in your root build.gradle at the end of repositories:

```html
<code>
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
</code>
```

Add the dependency in your module build.gradle
```html
   implementation 'com.github.raag.TimerView:v0.5.1beta'
```
