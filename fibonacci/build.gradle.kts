dependencies {
    api(project(":fibonacci-core"))
    api(project(":fibonacci-advanced"))
}

mavenPublishing {
    coordinates(group.toString(), "fibonacci", version.toString())
    pom {
        name = "Fibonacci Umbrella"
        description = "Umbrella-Paket für alle Fibonacci-Module."
    }
}
