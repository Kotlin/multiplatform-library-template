plugins {
    `kotlin-dsl`
    id("project.library-conventions")
    id("com.vanniktech.maven.publish")
}

dependencies {
}

mavenPublishing {
    coordinates(group.toString(), "fibonacci-core", version.toString())
    pom {
        name = "Fibonacci Core"
        description = "Kernmodul für Fibonacci-Berechnungen."
    }
}
