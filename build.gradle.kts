plugins {
    id("java-library")
}

allprojects {
    repositories {
        mavenCentral()
    }
}

java {
    targetCompatibility = JavaVersion.VERSION_21
}