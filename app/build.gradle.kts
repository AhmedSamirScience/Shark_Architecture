import dependencies.defaultLibraries
import dependencies.navGraph

plugins {
    //plugins {} Block: Similar to the build.gradle/.kts in the root project, this applies plugins in this module.
    // It doesn't need to explicitly call version() because it has already been specified in the root project.
    // apply(true) is also not needed because by default it is true.

    id(ProjectPlugins.androidApp) //plugin to build Android app (e.g. default app module) (AGP)
    id(ProjectPlugins.kotlinAndroid) //plugin to enable Kotlin support in your project.
    id(ProjectPlugins.safeArgsProjectModule)  //plugin to enable Kotlin support in your project.


    //region Data Binding - View Binding
    //this is because of using data binding and view binding
    //url: https://androidgeek.co/how-to-use-data-binding-in-kotlin-complete-guide-83af78a0bb30
    //url: http://mobologicplus.com/how-to-use-android-data-binding-in-kotlin/
    //url: https://medium.com/@chetanvaghela457/android-kotlin-databinding-with-bindingadapter-recyclerview-binding-99c84aa7af68
    //url: https://medium.com/@dhananjay_yaa/android-databinding-with-kotlin-2e636eaceeff
    id(ProjectPlugins.kotlinKaptForDataBinding)  //plugin to enable data binding
    //endregion
}

android {
    namespace = ProjectConfiguration.appId
    compileSdk = ProjectConfiguration.compileSdk

    defaultConfig {
        //defaultConfig {} Block -> This specifies the default configuration for the project.

        applicationId = ProjectConfiguration.appId
        minSdk = ProjectConfiguration.minSdk
        targetSdk = ProjectConfiguration.targetSdk
        versionCode = ProjectConfiguration.versionCode
        versionName = ProjectConfiguration.versionName
        testInstrumentationRunner = ProjectConfiguration.testInstrumentationRunner

    }

    buildTypes {
        getByName("release") {

            /**
             * this is actually what will manage most of the staff with r8
             *  so if we set isMinifyEnabled with true then it will on the hand optimise your code.
             *  therefore it will remove unused if statements, unused try catch and all that staff it will will optimise your code
             *  also it will remove all unused classes, all unused function from your libraries (dependencies) and it will also obfuscate your code
             *  after all of these then it will rename all of your classes function for your release build and all of that will make your app a lot smaller in size
             *  so you should always set isMinifyEnabled to true
             */
            isMinifyEnabled = true

            /**
             * here is it will remove unused resources
             */
            isShrinkResources = true

            /**
             * here it just defines some file path to a proguard rules.profile
             */
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            /*
              * i chose debug to make it faster and uncomment this when you generate an apk prod
             */
            //signingConfig = signingConfigs.getByName("debug")
            buildConfigField("String", "BASE_URL",  project.extra["baseUrLProd"].toString())

        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            buildConfigField("String", "BASE_URL",  project.extra["baseUrLTest"].toString())
        }


    }
    signingConfigs {
        create("release") {
            storeFile = file("C:/Users/ahmed_samir/Downloads/ahmed.jks")
            storePassword = "123456"
            keyAlias = "key0"
            keyPassword = "123456"
        }

    }
    buildFeatures {
        //this because
        //Fixing the "Build Type contains custom BuildConfig fields, but the feature is disabled" error w/ buildConfigField
        buildConfig = true

        //region Data Binding - View Binding
        //url: https://androidgeek.co/how-to-use-data-binding-in-kotlin-complete-guide-83af78a0bb30
        //url: http://mobologicplus.com/how-to-use-android-data-binding-in-kotlin/
        //url: https://medium.com/@chetanvaghela457/android-kotlin-databinding-with-bindingadapter-recyclerview-binding-99c84aa7af68
        //url: https://medium.com/@dhananjay_yaa/android-databinding-with-kotlin-2e636eaceeff
        //this is because of using data binding and view binding
        dataBinding = true
        viewBinding = true
        //endregion
    }

    compileOptions {
        //compileOptions {} Block -> This specifies options related to compiling your Java code.
        sourceCompatibility = JavaVersion.VERSION_17 //sourceCompatiblity -> specifies the Java version that your code uses.
        targetCompatibility = JavaVersion.VERSION_17 //targetCompatiblity -> specifies the Java runtime version that your code will be executed on.
    }
    kotlinOptions {
        //kotlinOptions {} Block ->This specifies options related to compiling your Kotlin code.

        //jvmTarget - specifies the Java Virtual Machine (JVM) version your code will be compiled for.
        // In short, it compiles your code to byte code that is compatible with the JVM version that you specified.
        //If you don't specify any compile / Kotlin options here, the default value will be used which could be different for a different version of the build Gradle plugin.
        jvmTarget = ProjectConfiguration.jvmTarget

    }

    packaging {
        //packagingOptions {} Block -> This specifies certain resources to exclude from the Android package - APK or Android bundle files.
        resources {
            //resources -> specifies the set of resources that should be processed during the packaging process

            //it excludes the following license files: (*/META-INF/AL2.0) and (*/META-INF/LGPL2.1)
            // The purpose is to reduce the Android package file size.
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }


}

dependencies {

    defaultLibraries()

    navGraph()

}