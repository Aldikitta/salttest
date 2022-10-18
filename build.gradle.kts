buildscript {
//    ext {
//        compose_version = '1.1.1'
//    }
    repositories {
        mavenCentral()
//        google()
    }

}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.com.android.application).apply(false)
    alias(libs.plugins.com.android.library).apply(false)
    alias(libs.plugins.org.jetbrains.kotlin.android).apply(false)
    alias(libs.plugins.nl.littlerobots.version.catalog.update)
    alias(libs.plugins.com.github.ben.manes.versions)
    alias(libs.plugins.com.google.dagger.hilt.android).apply(false)
    alias(libs.plugins.kotlin.serialization).apply(false)
}