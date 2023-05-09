group = "jp.ikanoshiokara"
version = "1.0.0"

val copyJsResources = tasks.create("copyJsResourcesWorkaround", Copy::class.java) {
    from(rootProject.file("src/jsMain/resources"))
    into("build/processedResources/js/main")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers")
    google()
}

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    js(IR) {
        browser()
        browser {
            webpackTask {
                outputFileName = "main.js"
            }
            runTask {
                outputFileName = "main.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)

                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }

//            resources.srcDir("./src/jsMain/resources")
        }
    }
}

compose.experimental {
    web.application {}
}

afterEvaluate {
    rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
        versions.webpackDevServer.version = "4.0.0"
        versions.webpackCli.version = "4.10.0"
    }
    project.tasks.getByName("jsProcessResources").finalizedBy(copyJsResources)
}