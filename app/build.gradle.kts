plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kapt)
    alias(libs.plugins.android.hilt)
}

android {
    namespace = "com.khyzhun.kravatka"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.khyzhun.kravatka"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += setOf("META-INF/AL2.0", "META-INF/LGPL2.1")
        }
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.activity.compose)

    implementation(libs.compose.ui)
    implementation(libs.compose.ui.android)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material)
    implementation(libs.compose.material3)
    implementation(libs.compose.compiler)
    implementation(libs.compose.constraint)
    implementation(libs.compose.paging)

    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.viewmodel)

    implementation(libs.androidx.navigation)

    implementation(libs.accompanist.system.ui)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicator)

    implementation(libs.coil)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter)
    implementation(libs.retrofit.gson)

    implementation(libs.hilt.android)
    implementation(libs.hilt.compose)
    kapt(libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    androidTestImplementation(libs.compose.ui.test.junit4)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)
}

//kapt {
//    correctErrorTypes = true
//}