object ProjectPlugins {

    //region plugin to build Android app (e.g. default app module)
    const val androidApp = "com.android.application"
    const val androidAppVersionNumber = "8.2.0"
    //endregion

    //region plugin to enable Kotlin support in your project.
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinAndroidPluginVersionNumber = "1.8.22"
    //endregion

    //region plugin to enable safeArgs in your project.
    const val safeArgsProjectModule = "androidx.navigation.safeargs.kotlin"
    const val safeArgsAppModule = "androidx.navigation.safeargs"
    const val safeArgsAppModuleVersionNumber = "2.5.3"
    //endregion

    //region plugin to build Android DataBinding with Kotlin here is my reference -> https://medium.com/@dhananjay_yaa/android-databinding-with-kotlin-2e636eaceeff or https://medium.com/@chetanvaghela457/android-kotlin-databinding-with-bindingadapter-recyclerview-binding-99c84aa7af68
    const val kotlinKaptForDataBinding = "kotlin-kapt"
    //endregion

}