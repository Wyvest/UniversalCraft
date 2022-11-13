import cc.polyfrost.gradle.util.*

plugins {
    kotlin("jvm")
    id("cc.polyfrost.multi-version")
    id("cc.polyfrost.defaults")
    `maven-publish`
}

group = "cc.polyfrost"

java.withSourcesJar()
tasks.compileKotlin.setJvmDefault(if (platform.mcVersion >= 11400) "all" else "all-compatibility")
loom {
    noServerRunConfigs()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21")
}

tasks.jar {
    manifest {
        attributes(mapOf("FMLModType" to "LIBRARY"))
    }
}

if (project.hasProperty("releasesUsername") && project.hasProperty("releasesPassword")) {
    setupPublishing("https://repo.polyfrost.cc/releases", "polyfrost", project.property("releasesUsername").toString(), project.property("releasesPassword").toString())
}