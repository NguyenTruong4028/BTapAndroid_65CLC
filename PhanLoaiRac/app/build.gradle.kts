plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "ntu.nguyentruong.phanloairac"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "ntu.nguyentruong.phanloairac"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Các thư viện cơ bản (Đã dùng đúng Version Catalog)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Core TFLite Support Library
    implementation("org.tensorflow:tensorflow-lite-support:0.4.4")

    // Core TFLite Interpreter
    implementation("org.tensorflow:tensorflow-lite:2.14.0")

    // Camera và Permissions
    implementation("androidx.camera:camera-core:1.3.1")
    implementation("androidx.camera:camera-camera2:1.3.1")
    implementation("androidx.camera:camera-lifecycle:1.3.1")
    implementation("androidx.camera:camera-view:1.3.1")

    // Thư viện xử lý ảnh (Glide)
    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")
}