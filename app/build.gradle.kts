plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.compose.compiler)

}
val navVersion = "2.7.0"

android {
    namespace = "com.ptk.pnclovecounter"
    compileSdk = 34

        packagingOptions {
            resources {
                excludes += "META-INF/INDEX.LIST"
            }
        }

    defaultConfig {
        applicationId = "com.ptk.pnclovecounter"
        minSdk = 31
        targetSdk = 34
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
hilt {
    enableAggregatingTask = false
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
    implementation(libs.androidx.navigation.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Viewmodel
    implementation(libs.lifecycle.viewmodel.ktx)




    //Scalable Size Unit sdp
    implementation(libs.sdp.compose)

    // Ktor
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.logging)
    implementation(libs.logback.classic)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)



    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler.ksp)
    // Hilt for Jetpack Compose
    implementation(libs.androidx.hilt.navigation.compose)

    // COil
    implementation(libs.coil.compose)
    implementation(libs.coil.gif)

    // Lottie
    implementation(libs.lottie)

    //Navigation
    implementation(libs.androidx.navigation.compose)

    //room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    //splash
    implementation(libs.androidx.core.splashscreen)


}


