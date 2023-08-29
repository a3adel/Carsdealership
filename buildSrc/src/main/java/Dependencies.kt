object Libs {
    const val androidXCore = "androidx.core:core-ktx:${Versions.corexVersion}"
    const val lifecycleRuntimeKTX =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"

    //region compose
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeBom = "androidx.compose:compose-bom:2023.03.00"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeGraphics = "androidx.compose.ui:ui-graphics"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeTooling = "androidx.compose.ui:ui-tooling"

    const val composeMaterial3 = "androidx.compose.material3:material3"

    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coil}"
    const val constraintLayoutCompose = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintCompose}"
    // endregion

    //region retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val moshiRetrofitAdapter =
        "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
    //endregion

    //region hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
    const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInject}"
    //endregion

}

object Plugins {
    const val hiltPlugin = "com.google.dagger.hilt.android"
    const val kotlinPlugin = "org.jetbrains.kotlin.android"
    const val kotlinJVMPlugin = "org.jetbrains.kotlin.jvm"
    const val androidApplication = "com.android.application"
    const val andrdoidLibrary = "com.android.library"
    const val javaLibrary = "java-library"
    const val kapt = "kapt"
}

object TestDependencies {
    const val Junit4 = "junit:junit:4.13.2"
    const val androidJunit = "androidx.test.ext:junit:1.1.5"
    const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val mockk_android = "io.mockk:mockk-android:${Versions.mockk}"
    const val coroutines_test =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines_version}"
}