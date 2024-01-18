
//settings.gradle/settings.gradle.kts block {}


pluginManagement {
    //pluginManagement
    //It configures repositories where plugins can be resolved/downloaded from gradlePluginPortal(), google() and mavenCentral().
    // All these are just function calls to set up the repository location.
    //What are plugins? plugins provide tasks/functions to build.gradle /build.gradle.kts to build your Android app

    //////////////////////////////////////////////////
    //my conclusion is when i put or download specific repo  because all of plugins (that support-> build.gradle whole project module) i want to include
    //////////////////////////////////////////////////
    
    repositories {
        //1- gradlePluginPortal() set up the repository hosted at plugins.gradle.org. Kotlin Android plugin(org.jetbrains.kotlin.android) is an example that is provided in this repository. Ca
        //2- google() set up the repository hosted at maven.google.com. Android application project plugin (com.andoird.application) and Android library project plugin (com.android.library) are 2 common plugins that are provided in this repository.
        //3- mavenCentral() set up the repository hosted at repo.maven.apache.org which is a popular repository. Most apps probably do not need this, but maybe it is a good practice to leave it here.
        //4- maven() set up the custom repository. In the above example, https://jitpack.io is the custom repository. To add another custom repository, just call maven() again with your custom repository URL.

        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    //dependencyResolutionManagement
    //It configures repositories which your code can download and resolve libraries from.
    // For example, your code uses certain libraries and those libraries' source code is hosted at these repositories.
    //What are dependencies? Dependencies are libraries that you import as a package in your source code.

    //////////////////////////////////////////////////
    //my conclusion is when i put or download specific repo  because all of the dependencies or libraries (that support-> build.gradle app module not whole project module) i want to include
    //////////////////////////////////////////////////

    //1- repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) tells Gradle to fail the build if there are any project-specific repositories. This is to prevent another developer who may fail to build the project if he/she doesn't have the same local repository setup correctly.

    //2- Same as the plugins, google() set up the maven.google.com repository and mavenCentral() set up repo.maven.apache.org repository. Instead of providing plugin tasks, they provide dependencies (libraries) for your code.
    // androidx.*(Android Jetpack libraries) is an example of libraries hosted at google() repository. You probably can't remove mavenCentral() as it is highly coupled with google() repository.


    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

//rootProject. name
//This is your root project name, which can be any name.
rootProject.name = "Shark_Architecture"

//include()
//This includes the subprojects/modules that you would like to build. Usually, the app module is pretty common.
// If you have implemented local libraries, you include them here too.
// include ("app", "buildutils") (or) include ("app") include ("buildutils")
include(":app")
