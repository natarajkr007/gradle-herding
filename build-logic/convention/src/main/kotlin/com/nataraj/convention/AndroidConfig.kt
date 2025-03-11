package com.nataraj.convention

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object AndroidConfig {

    val javaVersion: JavaVersion = JavaVersion.VERSION_17
    val jvmTarget: JvmTarget = JvmTarget.JVM_17

    const val TARGET_SDK = 24
    const val MIN_SDK = 24
    const val COMPILE_SDK = 35
}