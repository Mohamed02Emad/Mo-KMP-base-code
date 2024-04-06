plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.22"
    id("app.cash.sqldelight") version "2.0.0"
}
private val sqlDelightVersion = "2.0.0"


kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
//            baseName = "shared"
//            isStatic = true
            baseName = "shared"
            /**MOKO MVVM**/
            export("dev.icerock.moko:mvvm-core:0.16.1")
            export("dev.icerock.moko:mvvm-flow:0.16.1")
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            /**koin**/
            implementation(project.dependencies.platform("io.insert-koin:koin-bom:3.5.1"))
            implementation("io.insert-koin:koin-core")
            /**serialization**/
            implementation(libs.kotlinx.serialization.json)
            /**ktor**/
            implementation(libs.bundles.ktor)
            implementation(libs.kotlinx.coroutines.core)
            /**dataStore**/
            implementation(libs.androidx.datastore.preferences.core)
            /**DataBase**/
            implementation("app.cash.sqldelight:coroutines-extensions:$sqlDelightVersion")
            /**log**/
            implementation(libs.kermit)
            /**Moko MVVM**/
            api("dev.icerock.moko:mvvm-core:0.16.1")
            api("dev.icerock.moko:mvvm-flow:0.16.1")
            implementation("io.insert-koin:koin-core:3.2.0")
        }
        androidMain.dependencies{
            implementation(libs.ktor.client.android)
            /**koin**/
            implementation(project.dependencies.platform("io.insert-koin:koin-bom:3.5.1"))
            implementation("io.insert-koin:koin-androidx-compose")
            /**DataBase**/
            implementation("app.cash.sqldelight:android-driver:$sqlDelightVersion")
            /**MOKO MVVM**/
            implementation("io.insert-koin:koin-android:3.2.0")

        }
        iosMain.dependencies{
            implementation(libs.ktor.client.ios)
            /**DataBase**/
            implementation("app.cash.sqldelight:native-driver:$sqlDelightVersion")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.mo.newbase"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
dependencies {
    implementation(libs.androidx.ui.text.android)
}

sqldelight {
    databases {
        create(name = "MyDataBase") {
            packageName.set("com.mo.newbase")
        }
    }
}
