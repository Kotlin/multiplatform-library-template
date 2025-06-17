plugins {
    `kotlin-dsl`
}

group = "io.github.kotlin.fibonacci.buildlogic"
version = "1.0.0"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.21")
    implementation(libs.plugins.vanniktech.mavenPublish)
}
