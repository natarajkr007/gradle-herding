import com.android.build.api.dsl.ApplicationExtension
import com.nataraj.convention.AndroidConfig
import com.nataraj.convention.configureKotlinAndroid
import com.nataraj.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * @author nataraj-7085
 * @since 10/03/25
 * */
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.findPlugin("android-application").get().get().pluginId)
                apply(libs.findPlugin("kotlin-android").get().get().pluginId)
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)

                defaultConfig.targetSdk = AndroidConfig.TARGET_SDK
            }
        }
    }
}