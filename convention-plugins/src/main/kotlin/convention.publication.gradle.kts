import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`
import org.gradle.kotlin.dsl.signing

plugins {
    `maven-publish`
    signing
    id("io.github.gradle-nexus.publish-plugin")
}


val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

nexusPublishing {
    // Configure maven central repository
    repositories {
        sonatype()
    }


    // Configure all publications
}

publishing {
    publications.withType<MavenPublication> {
        // Stub javadoc.jar artifact
        artifact(javadocJar.get())

        // Provide artifacts information requited by Maven Central
        pom {
            name.set("Dummy Kotlin Multiplatform library")
            description.set("Dummy library to test deployment to Maven Central")
            url.set("https://github.com/asm0dey/dummylib-multiplatform")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            developers {
                developer {
                    id.set("asm0dey")
                    name.set("Pasha Finkelshteyn")
                    email.set("asm0dey@jetbrains.com")
                }
            }
            scm {
                url.set("https://github.com/asm0dey/dummylib-multiplatform")
            }
        }
    }
}

val gpgKeyId by extra { System.getenv("secrets.OSSRH_GPG_SECRET_KEY_ID") }
val gpgKey by extra { System.getenv("secrets.OSSRH_GPG_SECRET_KEY") }
val gpgKeyPassword by extra { System.getenv("secrets.OSSRH_GPG_SECRET_KEY_PASSWORD") }
signing {
    useGpgCmd()
    sign(publishing.publications)
}
