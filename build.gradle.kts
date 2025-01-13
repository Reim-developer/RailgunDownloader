/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: build.gradle.kts
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
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
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}
kotlin {
    jvmToolchain(17)
}
