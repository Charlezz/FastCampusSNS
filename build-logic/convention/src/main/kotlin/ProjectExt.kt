import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension

/**
 * @author soohwan.ok
 */


val Project.libraries get() :VersionCatalog = extensions.getByType(VersionCatalogsExtension::class.java).named("libs")