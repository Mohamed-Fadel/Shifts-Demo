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
    implementation("com.android.tools.build:gradle:${libs.versions.gradlePlugin.get()}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.get()}")
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
    }
}
