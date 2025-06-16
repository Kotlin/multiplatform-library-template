plugins {
    kotlin("jvm")
    alias(libs.plugins.vanniktech.mavenPublish)
}

dependencies {
    implementation(project(":fibonacci-core"))
}

mavenPublishing {
    coordinates(group.toString(), "fibonacci-advanced", version.toString())
    pom {
        name = "Fibonacci Advanced"
        description = "Erweiterte Algorithmen für Fibonacci."
    }
}
