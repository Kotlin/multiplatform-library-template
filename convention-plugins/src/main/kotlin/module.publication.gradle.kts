import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    `maven-publish`
    signing
    id("com.jfrog.artifactory")
}

publishing {
    
    publications.withType<MavenPublication> {
        groupId = project.group as String
        version = project.version as String

        artifact(tasks.register("${name}JavadocJar", Jar::class) {
            archiveClassifier.set("javadoc")
            archiveAppendix.set(this@withType.name)
        })

        // Provide artifacts information required by Maven Central
        pom {
            name.set("Kotlin Multiplatform library template")
            description.set("Dummy library to test deployment to Maven Central")
            url.set("https://github.com/Kotlin/multiplatform-library-template")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            developers {
                developer {
                    id.set("JetBrains")
                    name.set("JetBrains Team")
                    organization.set("JetBrains")
                    organizationUrl.set("https://www.jetbrains.com")
                }
            }
            scm {
                url.set("https://github.com/Kotlin/multiplatform-library-template")
            }
        }
    }
}

signing {
    if (project.hasProperty("signing.gnupg.keyName")) {
        useGpgCmd()
        sign(publishing.publications)
    }
}


artifactory {
    setContextUrl(project.findProperty("artifactory_contextUrl") as String)
    publish {
        repository {
            setRepoKey(project.findProperty("artifactory_snapshot_repo") as String)
            setUsername(project.findProperty("artifactory_user") as String)
            setPassword(project.findProperty("artifactory_password") as String)
        }
        defaults {
            publications("kotlinMultiplatform", "androidRelease", "jvm")
            setPublishArtifacts(false)
        }
    }
}
