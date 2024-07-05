import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

group = "jp.ikanoshiokara"
version = "2.1.0"

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

// なんでこれ使ってエラーなるのかわからない
//val copyWasmResources = tasks.create("copyWasmResourcesWorkaround", Copy::class.java) {
//    from(rootProject.file("src/wasmJsMain/resources"))
//    into("build/processedResources/wasmJs/main")
//}
//
//afterEvaluate {
//    project.tasks.getByName("wasmJsProcessResources").finalizedBy(copyWasmResources)
//}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            commonWebpackConfig {
                outputFileName = "kota-shiokara.github.io.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
         wasmJsMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
                implementation(compose.animation)
                implementation(compose.components.resources)
            }
        }

        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                implementation(compose.components.resources)
            }
        }
    }
}
