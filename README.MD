# Colendi WebView SDK

The Colendi Web View Software Development Kit.

# Table of Content
- [Overview](#overview)
- [Requirements](#requirements)
    - [General Requirements](#general-requirements)
- [Installation](#installation)
    - [Gradle](#Gradle)
- [Integration](#integration)
- [Author](#author)
- [LICENSE](#license)

# Overview

The Colendi Web View is a Software Development Kit developed by Colendians to enable fast and simple integration to Colendi World.

#  Requirements

## General Requirements
* compileSdkVersion & targetSdkVersion 33 or higher  


## Installation

### Gradle

ColendiWebView is available through Private JFrog Repository. To install
it, simply add the following line to your build.gradle:

```groovy
implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1'
implementation 'com.colendi:webview:1.0.1'
```
also Enable DataBinding in the Module build.gradle by adding this line into code block of android {}:

```groovy
dataBinding { enabled true  } 
```

Example build.gradle

```groovy
plugins {
    id 'com.android.application'
}

android {
    namespace 'com.colendi.example'
    compileSdk 33

    defaultConfig {
        applicationId "com.colendi.example"
        minSdk 21
        targetSdk 33
        versionCode 1
        versionName "1.0"
        dataBinding { enabled true  }
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}

dependencies {
    ....
    implementation 'com.colendi:webview:1.0.1'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1'
    ....
}
```

Add the following in the Project build.gradle within in buildscript within the buildscript->repositories and buildscript->allprojects

```groovy
jcenter()
maven { url "https://jfrog.colendilabs.com/artifactory/libs-release/" }
```

Go to AndroidManifest.xml, apply these line
```xml
<application
....
tools:replace="android:label">
</application>

```


## Integration

Add ColendiWebView to your activity/fragment xml

```xml
<com.colendi.webview.ColendiWebView
        android:id="@+id/webView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

```

You have to set your activity before loadUrl. setActivity function also gives onMessageReceived callback for data transfers. Spesific data blocks will be shared.
```java
public class MainActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.getSimpleName();

    ColendiWebView colendiWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colendiWebView = findViewById(R.id.webView);
        colendiWebView.setActivity(this, s -> {
            Log.d(TAG, "onMessageReceived: ");
        });
        colendiWebView.loadUrl(""); // Your Url
    }
}

```

# Authors

[Gökberk Bardakçı](https://www.github.com/gokberkbar), [Uygar İşiçelik](https://www.github.com/uygar) from [Colendi](https://www.twitter.com/colendiapp)

# License

ColendiWebView is available under the GNU GENERAL PUBLIC LICENSE license. See the LICENSE file for more info.
