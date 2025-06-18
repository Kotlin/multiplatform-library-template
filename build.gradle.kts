plugins {
    `kotlin-dsl`
}

tasks.withType<Wrapper>().configureEach {
    distributionType = Wrapper.DistributionType.BIN
    gradleVersion = "8.7"
}