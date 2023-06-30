pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:7.4.1")
            }
        }
    }
}
rootProject.name = "dummylib-multiplatform"
includeBuild("convention-plugins")
