plugins {
    alias(libs.plugins.herding.android.application.convention)
    alias(libs.plugins.herding.android.compose.convention)
}

android {
    namespace = "com.nataraj.gradleherding"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.nataraj.gradleherding"

        versionName = "1.0"
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
}

dependencies {

    implementation(projects.alpha)
    implementation(projects.beta)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.test.manifest)
}