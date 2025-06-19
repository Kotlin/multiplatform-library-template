pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "fibonacci"
include(":fibonacci-core")
include(":fibonacci-advanced")
include(":fibonacci")
includeBuild("build-logic")
