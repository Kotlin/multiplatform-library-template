import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    kotlin("multiplatform") version "1.8.22"
    id("com.android.library")
    id("convention.publication")
}

group = "com.github.asm0dey"
version = "0.0.1-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    android()
    iosArm64 {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }
    iosSimulatorArm64() {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }
    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.github.asm0dey.dummylib"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}