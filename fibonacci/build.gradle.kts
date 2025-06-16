plugins {
    `java-library`
    alias(libs.plugins.vanniktech.mavenPublish)
}

dependencies {
    api(project(":fibonacci-core"))
    api(project(":fibonacci-advanced"))
}

// Umbrella-Paket: keine eigenen Quellen, nur Aggregation

mavenPublishing {
    coordinates(group.toString(), "fibonacci", version.toString())
    pom {
        name = "Fibonacci Umbrella"
        description = "Umbrella-Paket für alle Fibonacci-Module."
    }
}
