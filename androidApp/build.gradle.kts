plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    kotlin("plugin.serialization") version "1.9.22"
}

android {
    namespace = "com.mo.newbase.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.mo.newbase.android"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation(libs.androidx.activity.compose)
    implementation (libs.androidx.material.icons.extended)

    /**system ui helper**/
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.30.1")

    /**Splash Api**/
    implementation(libs.splash.api)

    debugImplementation(libs.compose.ui.tooling)
    /**Navigation**/
    implementation(libs.androidx.navigation.compose)
    /**Koin**/
    implementation(platform("io.insert-koin:koin-bom:3.5.1"))
    implementation("io.insert-koin:koin-compose")
    implementation("io.insert-koin:koin-androidx-compose")

    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")

    /**Coil**/
    implementation ("io.coil-kt:coil:1.1.1")
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation ("com.google.accompanist:accompanist-coil:0.7.0")

//    /**firebase fcm**/
//    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
//    implementation(libs.firebase.messaging.ktx)
}