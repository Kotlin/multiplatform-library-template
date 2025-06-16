import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("jvm")
    alias(libs.plugins.vanniktech.mavenPublish)
}

dependencies {
    // testImplementation(libs.kotlin.test) zentral in root
}

mavenPublishing {
    coordinates(group.toString(), "fibonacci-core", version.toString())
    pom {
        name = "Fibonacci Core"
        description = "Kernmodul für Fibonacci-Berechnungen."
    }
}
