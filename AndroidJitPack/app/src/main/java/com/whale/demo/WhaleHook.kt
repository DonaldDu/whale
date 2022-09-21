package com.whale.demo

import com.lody.whale.xposed.XC_MethodHook
import com.lody.whale.xposed.XposedBridge


object WhaleHook {
    fun init() {
        hookAndroidId()
    }

    fun hookAndroidId() {
        XposedBridge.log("start androidId")
        //android.provider.Settings.Secure#getString
        val getString = android.provider.Settings.Secure::class.java.getDeclaredMethod(
            "getString", android.content.ContentResolver::class.java,
            java.lang.String::class.java
        )
        XposedBridge.hookMethod(getString, object : XC_MethodHook() {
            override fun beforeHookedMethod(param: MethodHookParam) {
                val key = param.args.last()
                if (key == android.provider.Settings.Secure.ANDROID_ID) {
                    println("hookAndroidId to 0")
                    param.result = "0"
                }
            }
        })
    }
}