plugins {
    kotlin("multiplatform") version "1.8.22"
    id("com.android.library") version "7.4.1"
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

kotlin {
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
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val androidMain by getting
        val androidUnitTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }
        val iosArm64Main by getting
        val iosArm64Test by getting
    }
}

android {
    namespace = "me.user.library"
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