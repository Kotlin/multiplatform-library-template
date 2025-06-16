plugins {
    kotlin("jvm") version libs.versions.kotlin.get() apply false
    alias(libs.plugins.vanniktech.mavenPublish) apply false
}

subprojects {
    group = "io.github.kotlin.fibonacci"
    version = "1.0.0"

    repositories {
        mavenCentral()
    }

    plugins.withId("org.jetbrains.kotlin.jvm") {
        kotlin {
            jvmToolchain(21)
        }
        dependencies {
            "testImplementation"(libs.kotlin.test)
        }
    }
}

allprojects {
    // Zentrale Konfiguration für mavenPublishing
    plugins.withId("com.vanniktech.maven.publish") {
        mavenPublishing {
            publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.CENTRAL_PORTAL)
            signAllPublications()
            pom {
                inceptionYear = "2024"
                url = "https://github.com/kotlin/multiplatform-library-template/"
                licenses {
                    license {
                        name = "XXX"
                        url = "YYY"
                        distribution = "ZZZ"
                    }
                }
                developers {
                    developer {
                        id = "XXX"
                        name = "YYY"
                        url = "ZZZ"
                    }
                }
                scm {
                    url = "XXX"
                    connection = "YYY"
                    developerConnection = "ZZZ"
                }
            }
        }
    }
}
