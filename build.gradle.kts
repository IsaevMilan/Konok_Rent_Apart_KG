// Top-level build file
plugins {
    id("com.android.application") version "8.11.1" apply false
    id("org.jetbrains.kotlin.android") version "2.3.10" apply false   // ← вот сюда 2.3.10
    id("com.google.dagger.hilt.android") version "2.51.1" apply false   // hilt можно обновить позже до 2.52+ если хочешь
    id("org.jetbrains.kotlin.plugin.serialization") version "2.3.10" apply false  // тоже подними
}

/*buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.6.1")
        // Если используете Hilt, добавьте:
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
    }
}*/

