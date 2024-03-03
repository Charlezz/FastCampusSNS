pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FastcampusSNS"
include(":app")
//include(":practice")
include(":domain")
include(":presentation")
include(":data")
include(":assistedinjection")
include(":hiltextensionapp")
include(":annotations")
include(":compiler")
include(":DynamicFeature")
