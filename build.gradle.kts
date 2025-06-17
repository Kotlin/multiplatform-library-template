plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.vanniktech.mavenPublish) apply false
    id("java-library")
}

allprojects {
    repositories {
        mavenCentral()
    }
}
