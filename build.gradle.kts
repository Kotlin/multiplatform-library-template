import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("jvm") version libs.versions.kotlin.get() apply false
    alias(libs.plugins.vanniktech.mavenPublish) apply false
    id("java-library")
}

var kotlinTest = libs.kotlin.test

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "com.vanniktech.maven.publish")
    apply(plugin = "java-library")

    group = "io.github.kotlin.fibonacci"
    version = "1.0.0"

    repositories {
        mavenCentral()
    }

    the<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension>().jvmToolchain(21)

    dependencies {
        "testImplementation"(kotlinTest)
    }

    extensions.configure<PublishingExtension> {
        repositories {
            maven {
                name = "Local"
                url = uri(rootProject.layout.buildDirectory.dir("repo"))
            }
        }
    }

    // Maven publishing
    extensions.configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
        signAllPublications()
        pom {
            inceptionYear.set("2024")
            url.set("https://github.com/kotlin/multiplatform-library-template/")
            licenses {
                license {
                    name.set("Apache-2.0")
                    url.set("https://www.apache.org/licenses/LICENSE-2.0")
                    distribution.set("repo")
                }
            }
            developers {
                developer {
                    id.set("your-id")
                    name.set("Your Name")
                    url.set("https://your.website.com")
                }
            }
            scm {
                url.set("https://github.com/kotlin/multiplatform-library-template")
                connection.set("scm:git:git://github.com/kotlin/multiplatform-library-template.git")
                developerConnection.set("scm:git:ssh://github.com:kotlin/multiplatform-library-template.git")
            }
        }
    }
}
