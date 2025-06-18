plugins {
    `kotlin-dsl`
    id("project.library-conventions")
    id("com.vanniktech.maven.publish")
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
