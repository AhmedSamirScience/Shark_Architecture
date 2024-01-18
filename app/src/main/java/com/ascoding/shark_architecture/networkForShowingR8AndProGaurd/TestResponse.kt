package com.ascoding.shark_architecture.networkForShowingR8AndProGaurd

import androidx.annotation.Keep

/**
 * if you want to just declare this class as a class we don't to obfuscate  we have two option on the hand we can just add the keep annotation like below
 * and this will tell the proguard hey or hey r8 we want to keep this class and don't obfuscate this now if you have a lot of data classes this is annoying to always
 * add this keep annotation so you can do this as a quick way if you only have a specific class but to actually add more classes to your pool you want to obfuscate
 * you can use these proguard rules in the (proguard-rules.pro) so please if you want to use the second option please go to proguard-rules.pro file in gradle scripts
 */
@Keep
data class TestResponse(
    var testVariable: String = ""
)
