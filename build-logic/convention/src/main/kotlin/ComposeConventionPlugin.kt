import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import com.nataraj.convention.configureComposeAndroid
import com.nataraj.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType

/**
 * @author nataraj-7085
 * @since 11/03/25
 * */
class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            with(pluginManager) {
                apply(libs.findPlugin("compose-compiler").get().get().pluginId)
            }

            extensions.findByType<LibraryExtension>()?.apply {
                configureComposeAndroid(this)
            }

            extensions.findByType<ApplicationExtension>()?.apply {
                configureComposeAndroid(this)
            }

            dependencies {
                add("implementation", platform(libs.findLibrary("androidx-compose-bom").get()))

                add("implementation", libs.findBundle("compose-bundle").get())

                add("debugImplementation", libs.findLibrary("androidx-ui-tooling").get())
            }
        }
    }
}