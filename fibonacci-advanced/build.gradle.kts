plugins {
    `kotlin-dsl`
    id("project.library-conventions")
    id("com.vanniktech.maven.publish") version "0.32.0"
}

dependencies {
    implementation(project(":fibonacci-core"))

    testImplementation(libs.kotlin.test)
}

mavenPublishing {
    coordinates(group.toString(), "fibonacci-advanced", version.toString())
    pom {
        name = "Fibonacci Advanced"
        description = "Erweiterte Algorithmen für Fibonacci."
    }
}
