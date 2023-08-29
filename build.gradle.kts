// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.androidApplication) version Versions.androidAppVesion apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
    id(Plugins.kotlinPlugin) version Versions.kotlinVersion apply false
    id(Plugins.hiltPlugin) version Versions.hiltVersion apply false
    id(Plugins.andrdoidLibrary) version Versions.androidAppVesion apply false
}