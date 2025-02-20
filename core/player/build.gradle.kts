plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.tattoshaman.player"
    compileSdk = 35

    defaultConfig {
        minSdk = 27

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    //media3

    // For media playback using ExoPlayer
    api(libs.androidx.media3.exoplayer)

    // For exposing and controlling media sessions
    api(libs.androidx.media3.session)

    // For extracting data from media containers
    api(libs.androidx.media3.extractor)

    // For scheduling background operations using Jetpack Work's WorkManager with ExoPlayer
    api(libs.androidx.media3.exoplayer.workmanager)

    // For transforming media files
    api(libs.androidx.media3.transformer)

    // Common functionality for reading and writing media containers
    api(libs.androidx.media3.container)
    // Common functionality for media database components
    api(libs.androidx.media3.database)
    // Common functionality for media decoders
    api(libs.androidx.media3.decoder)
    // Common functionality for loading data
    api(libs.androidx.media3.datasource)
    // Common functionality used across multiple media libraries
    api(libs.androidx.media3.common)
    // Common Kotlin-specific functionality
    api(libs.androidx.media3.common.ktx)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}