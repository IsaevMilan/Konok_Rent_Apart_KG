// Top-level build file
plugins {
    id("com.android.application") version "8.6.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}

buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.6.0")
        // Если используете Hilt, добавьте:
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
    }
}

