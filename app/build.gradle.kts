plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "br.com.mizaeldouglas.api_com_mvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "br.com.mizaeldouglas.api_com_mvvm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    val lifecycle_version = "2.8.5"
    val arch_version = "2.2.0"

    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    implementation (libs.picasso)


    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // ViewModel utilities for Compose
    //implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")


    // Lifecycles only (without ViewModel or LiveData)
    // implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")

    // Lifecycle utilities for Compose
    // implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")

    // Saved state module for ViewModel
    // implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}