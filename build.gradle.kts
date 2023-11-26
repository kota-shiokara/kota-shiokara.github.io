import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

group = "jp.ikanoshiokara"
version = "2.0.0"

repositories {
    google()
    mavenCentral()
    mavenLocal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
}

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
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

@OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)
kotlin {
    wasmJs {
        moduleName = "kota-shiokara.github.io"

        browser {
            commonWebpackConfig {
                outputFileName = "kota-shiokara.github.io.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        add(project.rootDir.path)
                    }
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)

                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }
    }
}

compose.experimental {
    web.application {}
}

compose {
    val kotlinVersion = rootProject.extra["kotlin.version"] as String
    val composeCompilerVersion = rootProject.extra["compose.compiler.version"] as String

    kotlinCompilerPlugin.set(composeCompilerVersion)
    kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=$kotlinVersion")
}

