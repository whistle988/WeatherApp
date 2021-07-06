package com.example.weatherapp.extension


import android.util.Log
import com.example.weatherapp.BuildConfig
import org.apache.commons.lang3.builder.ToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle

/******************************************************************
 * created in: Android Studio
 *     author: BanHammer ( bogdan2001@gmail.com )
 *       date: 16.03.2020 17:43:00
 ******************************************************************/

private const val TAG = "myLogs"

fun Any.debug(message: String) {
    if (BuildConfig.DEBUG)
        Log.d(TAG, message)
}

fun Any.debug(obj: Any?) {
    debug(ToStringBuilder.reflectionToString(obj, ToStringStyle.SHORT_PREFIX_STYLE))
}

inline fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2)->R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}
inline fun <T1 : Any, T2 : Any, T3 : Any, R : Any> safeLet(p1: T1?, p2: T2?, p3: T3?, block: (T1, T2, T3)->R?): R? {
    return if (p1 != null && p2 != null && p3 != null) block(p1, p2, p3) else null
}
inline fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, R : Any> safeLet(p1: T1?, p2: T2?, p3: T3?, p4: T4?, block: (T1, T2, T3, T4)->R?): R? {
    return if (p1 != null && p2 != null && p3 != null && p4 != null) block(p1, p2, p3, p4) else null
}
inline fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, R : Any> safeLet(p1: T1?, p2: T2?, p3: T3?, p4: T4?, p5: T5?, block: (T1, T2, T3, T4, T5)->R?): R? {
    return if (p1 != null && p2 != null && p3 != null && p4 != null && p5 != null) block(p1, p2, p3, p4, p5) else null
}

inline fun <T1 : Any, T2 : Any, R : Any> T1?.let2(p2: T2?, block: (T1, T2)->R?): R? {
    return if (this != null && p2 != null) block(this, p2) else null
}
inline fun <T1 : Any, T2 : Any, T3 : Any, R : Any> T1?.let3(p2: T2?, p3: T3?, block: (T1, T2, T3)->R?): R? {
    return if (this != null && p2 != null && p3 != null) block(this, p2, p3) else null
}
inline fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, R : Any> T1?.let4(p2: T2?, p3: T3?, p4: T4?, block: (T1, T2, T3, T4)->R?): R? {
    return if (this != null && p2 != null && p3 != null && p4 != null) block(this, p2, p3, p4) else null
}
inline fun <T1 : Any, T2 : Any, T3 : Any, T4 : Any, T5 : Any, R : Any> T1?.let5(p2: T2?, p3: T3?, p4: T4?, p5: T5?, block: (T1, T2, T3, T4, T5)->R?): R? {
    return if (this != null && p2 != null && p3 != null && p4 != null && p5 != null) block(this, p2, p3, p4, p5) else null
}
