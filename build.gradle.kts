plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.0"
}

group = "RailgunDownloaderV4"
version = "4.0.0"

sourceSets {
    main { kotlin.srcDirs("src/main/kotlin") }
    test { kotlin.srcDirs("src/test/kotlin") }
}

repositories {
    mavenCentral()
}
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jsoup:jsoup:1.18.3")
}
kotlin {
    jvmToolchain(17)
}
