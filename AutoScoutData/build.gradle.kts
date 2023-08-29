
plugins {
    id(Plugins.andrdoidLibrary)
    id(Plugins.kotlinPlugin)
    kotlin(Plugins.kapt)

}

android {
    namespace = "com.example.autoscoutdata"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        buildConfigField("String", "BASE_URL", "\"http://private-fe87c-simpleclassifieds.apiary-mock.com/\"")

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
    buildFeatures{
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {


    api(Libs.moshi)
    api(Libs.moshiRetrofitAdapter)
    api(Libs.retrofit)
    api(Libs.hiltAndroid)
    api(project(mapOf("path" to ":AutoScoutDomain")))
    kapt(Libs.hiltCompiler)

    testApi(TestDependencies.Junit4)
    testApi(TestDependencies.Junit4)
    testApi(TestDependencies.mockk)
    testApi(TestDependencies.coroutines_test)
}