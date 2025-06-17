plugins {
    id("build-logic")
    `kotlin-dsl`
    id("com.vanniktech.maven.publish")
}

apply<ProjectModulePlugin>()

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
