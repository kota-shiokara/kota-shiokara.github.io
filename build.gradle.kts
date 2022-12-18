plugins {
    kotlin("multiplatform") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.0"
}

group = "jp.ikanoshiokara"
version = "0.0.1"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers")
    google()
}

kotlin {
    js(IR) {
        browser()
        browser {
            webpackTask {
                outputFileName = "main.js"
                cssSupport.enabled = true
            }
            runTask {
                outputFileName = "main.js"
                cssSupport.enabled = true
            }
        }
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)

                // kotlin react
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.201-kotlin-1.5.0")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.201-kotlin-1.5.0")
                implementation(npm("react", "17.0.2"))
                implementation(npm("react-dom", "17.0.2"))

                implementation(npm("react-icons", "4.7.1"))
                implementation(npm("@fortawesome/react-fontawesome", "latest"))
            }
        }
    }
}

afterEvaluate {
    rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
        versions.webpackDevServer.version = "4.0.0"
        versions.webpackCli.version = "4.10.0"
    }
}