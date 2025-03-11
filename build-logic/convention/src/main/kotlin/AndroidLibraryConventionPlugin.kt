import com.android.build.gradle.LibraryExtension
import com.nataraj.convention.AndroidConfig
import com.nataraj.convention.configureKotlinAndroid
import com.nataraj.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * @author nataraj-7085
 * @since 11/03/25
 * */
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.findPlugin("android-library").get().get().pluginId)
                apply(libs.findPlugin("kotlin-android").get().get().pluginId)
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = AndroidConfig.TARGET_SDK
            }
        }
    }
}