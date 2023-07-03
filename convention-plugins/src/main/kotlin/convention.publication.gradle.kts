import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`
import org.gradle.kotlin.dsl.signing
import java.util.*

plugins {
    `maven-publish`
    signing
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

val ossrhUsername by extra { System.getenv("secrets.OSSRH_USERNAME") }
val ossrhPassword by extra { System.getenv("secrets.OSSRH_PASSWORD") }
publishing {
    // Configure maven central repository
    repositories {
        maven {
            name = "sonatype"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }

    // Configure all publications
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
// Signing artifacts. Signing.* extra properties values will be used
val gpgKeyId by extra { System.getenv("secrets.OSSRH_GPG_SECRET_KEY_ID") }
val gpgKey by extra { System.getenv("secrets.OSSRH_GPG_SECRET_KEY") }
val gpgKeyPassword by extra { System.getenv("secrets.OSSRH_GPG_SECRET_KEY_PASSWORD") }
signing {
    useInMemoryPgpKeys(gpgKeyId, gpgKey, gpgKeyPassword)
    sign(publishing.publications)
}