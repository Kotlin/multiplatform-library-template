pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()

    }
}

rootProject.name = "fibonacci"
include(":fibonacci-core")
include(":fibonacci-advanced")
include(":fibonacci")
