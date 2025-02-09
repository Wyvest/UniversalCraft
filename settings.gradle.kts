pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        maven("https://repo.polyfrost.org/releases")
    }
    plugins {
        val egtVersion = "0.6.7"
        id("org.polyfrost.multi-version.root") version egtVersion
        id("org.polyfrost.multi-version.api-validation") version egtVersion
    }
}

rootProject.name = "UniversalCraft"
rootProject.buildFileName = "root.gradle.kts"

include(":standalone")
include(":standalone:example")

listOf(
    "1.8.9-forge",
    "1.8.9-fabric",
    "1.12.2-fabric",
    "1.12.2-forge",
    "1.16.5-forge",
    "1.16.5-fabric",
    "1.17.1-fabric",
    "1.17.1-forge",
    "1.18.2-fabric",
    "1.18.2-forge",
    "1.19-fabric",
    "1.19.1-fabric",
    "1.19.2-fabric",
    "1.19.2-forge",
    "1.19.3-fabric",
    "1.19.3-forge",
    "1.19.4-fabric",
    "1.19.4-forge",
    "1.20-fabric",
    "1.20.1-fabric",
    "1.20.1-forge",
    "1.20.2-fabric",
    "1.20.2-forge",
    "1.20.4-fabric",
    "1.20.4-forge",
    "1.20.6-fabric",
    "1.21-fabric",
    "1.21.2-fabric",
).forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../../build.gradle.kts"
    }
}