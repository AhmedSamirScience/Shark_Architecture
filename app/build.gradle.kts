import dependencies.defaultLibraries
plugins {
    //plugins {} Block: Similar to the build.gradle/.kts in the root project, this applies plugins in this module.
    // It doesn't need to explicitly call version() because it has already been specified in the root project.
    // apply(true) is also not needed because by default it is true.

    id(ProjectPlugins.androidApp) //plugin to build Android app (e.g. default app module) (AGP)
    id(ProjectPlugins.kotlinAndroid) //plugin to enable Kotlin support in your project.
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
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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


}