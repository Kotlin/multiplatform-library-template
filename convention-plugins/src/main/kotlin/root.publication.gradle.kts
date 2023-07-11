plugins {
    id("io.github.gradle-nexus.publish-plugin")
}

allprojects {
    group = "com.github.asm0dey.dummylib"
    version = "0.0.1"
}

nexusPublishing {
    // Configure maven central repository
    // https://github.com/gradle-nexus/publish-plugin#publishing-to-maven-central-via-sonatype-ossrh
    repositories {
        sonatype()
    }
}
