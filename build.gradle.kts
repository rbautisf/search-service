val isDevelopment: Boolean = project.ext.has("development")

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.serialization)
}

group = "com.nowherelearn"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation(libs.bundles.ktor.server)
    testImplementation(testLibs.bundles.test)
}