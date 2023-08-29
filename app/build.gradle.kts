import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinPlugin)
    id(Plugins.hiltPlugin)
    kotlin(Plugins.kapt)
}

android {
    namespace = "com.example.autoscout24"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.autoscout24"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Libs.androidXCore)
    implementation(Libs.lifecycleRuntimeKTX)

    implementation(Libs.activityCompose)
    implementation(platform(Libs.composeBom))
    implementation(Libs.composeGraphics)
    implementation(Libs.composeUi)
    implementation(Libs.composePreview)
    implementation(Libs.composeMaterial3)
    implementation(Libs.constraintLayoutCompose)
    implementation(Libs.coilCompose)

    implementation(Libs.hiltAndroid)
    implementation(project(mapOf("path" to ":AutoScoutDomain")))
    implementation(project(mapOf("path" to ":AutoScoutData")))
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    testImplementation(TestDependencies.Junit4)
    androidTestImplementation(TestDependencies.androidJunit)
    androidTestImplementation(TestDependencies.espresso)
    androidTestImplementation(platform(Libs.composeBom))
    androidTestImplementation(TestDependencies.composeUiTest)
    debugImplementation(Libs.composeTooling)
    debugImplementation(TestDependencies.composeUiTestManifest)
}
