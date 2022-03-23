plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:7.1.2")
    implementation(kotlin("gradle-plugin", version = "1.6.10"))
}