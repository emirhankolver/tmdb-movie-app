import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.dagger.hilt)
}

val localProperties = Properties().apply {
    load(rootProject.file("local.properties").inputStream())
}

val apiToken: String = localProperties.getProperty("TMDB_API_TOKEN")
val maskedToken = apiToken.take(15) + "..." // Show only first 6 chars
println("[!] Setting TMDB API Token: $maskedToken (masked for security)")

android {
    namespace = "com.emirhankolver.tmdbapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.emirhankolver.tmdbapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "TMDB_API_TOKEN", "\"$apiToken\"")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)

    // Network
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.coil.compose)

    // DI
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.hilt.android.compiler)

    // Pagination
    implementation(libs.paging.compose)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.runtime.ktx)

    // Etc.
    implementation(libs.compose.shimmer)
    implementation(libs.androidx.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}