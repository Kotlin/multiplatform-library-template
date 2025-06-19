plugins {
    `kotlin-dsl`
    id("project.library-conventions")
    id("com.vanniktech.maven.publish") version "0.32.0"
}

dependencies {
    api(project(":fibonacci-core"))
    api(project(":fibonacci-advanced"))
}

mavenPublishing {
    coordinates(group.toString(), "fibonacci", version.toString())
    pom {
        name = "Fibonacci (Aggregator)"
        description = "Umbrella-Paket für alle Fibonacci-Module."
    }
}
