import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

apply<ProjectModulePlugin>()

class ProjectModulePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.pluginManager.apply("org.jetbrains.kotlin.jvm")
        project.pluginManager.apply("java-library")
        project.pluginManager.apply("com.vanniktech.maven.publish")

        project.group = "io.github.kotlin.fibonacci"
        project.version = "1.0.0"

        project.repositories.mavenCentral()

        project.extensions.configure<KotlinJvmProjectExtension> {
            jvmToolchain(21)
        }

        project.extensions.configure<JavaPluginExtension> {
            withSourcesJar()
            withJavadocJar()

            targetCompatibility = JavaVersion.VERSION_11
            sourceCompatibility = JavaVersion.VERSION_11
        }

        project.extensions.configure<PublishingExtension> {
            repositories {
                maven {
                    name = "Local"
                    url = project.uri(project.rootProject.layout.buildDirectory.dir("repo"))
                }
            }
        }

        project.extensions.configure<MavenPublishBaseExtension> {
            // publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
            // signAllPublications()
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
}
