plugins {
    kotlin("js") version "1.3.61"
    kotlin("plugin.serialization") version "1.3.61" apply true
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven( "https://kotlin.bintray.com/kotlinx" )
}

dependencies {
    implementation(kotlin("stdlib-js"))
    testImplementation(kotlin("stdlib-js"))
    implementation(kotlin("test-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:0.14.0")
}

kotlin {
    target {
        nodejs()
        useCommonJs()
    }
    sourceSets {
        main {
            dependencies {
                implementation(npm("redux", "4.0.5"))
                implementation(npm("redux-logger", "3.0.6"))
                implementation(npm("redux-saga", "1.1.3"))
            }
        }
    }
}