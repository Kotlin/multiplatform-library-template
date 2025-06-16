plugins {
    kotlin("jvm") version libs.versions.kotlin.get()
    alias(libs.plugins.vanniktech.mavenPublish) apply false
}
