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
    implementation(libs.androidx.media3.exoplayer)

    // For exposing and controlling media sessions
    implementation(libs.androidx.media3.session)

    // For extracting data from media containers
    implementation(libs.androidx.media3.extractor)

    // For scheduling background operations using Jetpack Work's WorkManager with ExoPlayer
    implementation(libs.androidx.media3.exoplayer.workmanager)

    // For transforming media files
    implementation(libs.androidx.media3.transformer)

    // Common functionality for reading and writing media containers
    implementation(libs.androidx.media3.container)
    // Common functionality for media database components
    implementation(libs.androidx.media3.database)
    // Common functionality for media decoders
    implementation(libs.androidx.media3.decoder)
    // Common functionality for loading data
    implementation(libs.androidx.media3.datasource)
    // Common functionality used across multiple media libraries
    implementation(libs.androidx.media3.common)
    // Common Kotlin-specific functionality
    implementation(libs.androidx.media3.common.ktx)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}