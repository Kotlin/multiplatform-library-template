plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(fromCatalog(libs.plugins.kotlin.gradle.plugin))
    implementation(fromCatalog(libs.plugins.vanniktech.mavenPublish))
}

fun fromCatalog(dependency: Provider<PluginDependency>): String {
    return "${dependency.get().pluginId}:${dependency.get().version}"
}

