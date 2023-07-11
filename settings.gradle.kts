pluginManagement {
    includeBuild("convention-plugins")
    repositories {
        google {
            mavenContent {
                releasesOnly()
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "dummylib-multiplatform"
include(":library")
