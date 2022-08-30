plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation("com.android.tools.build:gradle:${libs.versions.gradlePlugin.gradle.get()}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.version.get()}")
    implementation("org.koin:koin-gradle-plugin:${libs.versions.gradlePlugin.koin.get()}")
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

}

gradlePlugin {
    plugins {
        create("HomeBaseAndroidPlugin") {
            id = "homebase-android"
            implementationClass = "com.example.homebase.base.BaseAndroidPlugin"
        }

        create("HomeBaseApplicationPlugin") {
            id = "homebase-application"
            implementationClass = "com.example.homebase.base.BaseApplicationPlugin"
        }

        create("HomeBaseKotlinPlugin") {
            id = "homebase-kotlin"
            implementationClass = "com.example.homebase.base.BaseKotlinPlugin"
        }

        create("HomeBaseLibraryPlugin") {
            id = "homebase-library"
            implementationClass = "com.example.homebase.base.BaseLibraryPlugin"
        }

        create("HomeBaseKotlinLibraryPlugin") {
            id = "homebase-kotlin-library"
            implementationClass = "com.example.homebase.base.BaseKotlinLibraryPlugin"
        }
    }
}
