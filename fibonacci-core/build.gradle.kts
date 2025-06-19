plugins {
    `kotlin-dsl`
    id("project.library-conventions")
    id("com.vanniktech.maven.publish") version "0.32.0"
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

mavenPublishing {
    coordinates(group.toString(), "fibonacci-core", version.toString())
    pom {
        name = "Fibonacci Core"
        description = "Kernmodul für Fibonacci-Berechnungen."
    }
}
