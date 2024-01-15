# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

##########################################    MY DESCRIBTION about progaurd-rules.pro file   ##########################################
#inside of this file we can declare rules for progaurd so we essentialy use r8 here to opitimse our code
# but r8 also uses these progaurd rules files and here we can for example declare classes we don't want to obfustacte
# we can declare classes we don't want to opitimise and all that stuff and now you might ask why that is actually
# useful to not obfustcate some classes because you actually usually think that you want to obfustacte everything
#but that is not true lets think of for example of network model classes so you just define some data classes
# you use to parse some json into and these some classes you usually don't want to obfustacte because if you do that
#the problem would be that the feild names of the json resposne must be the same as the feild names of of your data class and if you code obfustacted that means
# that the fieled of your data class will be renamed and then you kotlin data class or android studio will not know which feild from json class or json response
# it should parse into which feild of your data class so that means we should add these data classes here in this proguard rule (here in this file)
# so r8 will know okay i shouldn't obfustacte these classes so whenever you actaully build your release app then i would always try it out before you upload it to google play so
# just because an app works in debug build doens't mean it works in release build as well because if you forgot about these things then your app will crash
##############################################################################################################


#####################################    MY DESCRIBTION about second option if you want to obfuscate all network models or data classes #####################################
#if you want to tell pro gaurd or r8 that i want to obfuscate more than one class
-keep class com.ascoding.shark_architecture.networkForShowingR8AndProGaurd.*

# if you want to do as above but you want to add some additional like the function or classes declared in the package and not only classes
# so you will add { *; } to include all functions and classes
-keep class com.ascoding.shark_architecture.networkForShowingR8AndProGaurd.* { *; }

#if you want to tell pro gaurd or r8 that i want to obfuscate specific class
-keep class com.ascoding.shark_architecture.networkForShowingR8AndProGaurd.TestResponse
#############################################################################################################################################################################
