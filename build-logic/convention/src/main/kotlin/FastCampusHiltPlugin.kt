import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * @author soohwan.ok
 */
class FastCampusHiltPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager){
                apply("com.google.dagger.hilt.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            dependencies {
                "implementation"(libraries.findLibrary("hilt").get())
                "kapt"(libraries.findLibrary("hilt-compiler").get())
            }
        }
    }
}