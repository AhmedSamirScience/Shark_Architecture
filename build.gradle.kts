// Top-level build file where you can add configuration options common to all sub-projects/modules.

//plugins block {}
//This defines the core plugins that are used by all your modules.
plugins {
    //Android Gradle Plugin (AGP)
    //You can specify the Gradle version in either the File > Project Structure > Project menu in Android Studio
    id(ProjectPlugins.androidApp) version ProjectPlugins.androidAppVersionNumber apply false //plugin to build Android app (e.g. default app module)

    id(ProjectPlugins.kotlinAndroid) version ProjectPlugins.kotlinAndroidPluginVersionNumber apply false //plugin to enable Kotlin support in your project.
    id(ProjectPlugins.safeArgsAppModule) version ProjectPlugins.safeArgsAppModuleVersionNumber apply false //plugin to enable safeArgs in your project.

}