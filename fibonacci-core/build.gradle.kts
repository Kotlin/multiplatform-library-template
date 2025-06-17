plugins {
    `kotlin-dsl`
    id("com.vanniktech.maven.publish")
}

apply<ProjectModulePlugin>()

dependencies {
}

mavenPublishing {
    coordinates(group.toString(), "fibonacci-core", version.toString())
    pom {
        name = "Fibonacci Core"
        description = "Kernmodul für Fibonacci-Berechnungen."
    }
}
