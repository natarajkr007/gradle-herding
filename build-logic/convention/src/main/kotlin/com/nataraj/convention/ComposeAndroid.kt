package com.nataraj.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

/**
 * @author nataraj-7085
 * @since 11/03/25
 * */
internal fun Project.configureComposeAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }
    }
}