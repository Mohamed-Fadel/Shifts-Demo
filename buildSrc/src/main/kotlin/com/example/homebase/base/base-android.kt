package com.example.homebase.base

import com.android.build.gradle.BaseExtension
import com.example.homebase.util.applyAndroid
import com.example.homebase.util.applyPlugins
import com.example.homebase.util.int
import com.example.homebase.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.buildscript
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.repositories


class BaseAndroidPlugin : Plugin<Project> {

    override fun apply(project: Project) = project.run {
        setBuildScript()
        applyAndroid {
            setToolVersion(project)
            applyPlugins()
            setDefaultConfig(project)
            setDependencies()
            setLintOptions()
        }
    }

    private fun Project.applyPlugins() {
        applyPlugins(
            "kotlin-android",
            "homebase-kotlin"
        )
    }

    private fun BaseExtension.setDefaultConfig(project: Project) {
        val libs = project.library
        defaultConfig {
            minSdk = libs.versions.min.sdk.int
            targetSdk = libs.versions.target.sdk.int
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables.useSupportLibrary = true
            consumerProguardFiles("consumer-rules.pro")
        }
    }

    private fun Project.setDependencies() {
        dependencies {
            // add any dependencies needed for common android
        }
    }

    private fun BaseExtension.setToolVersion(project: Project) {
        val libs = project.library
        compileSdkVersion(libs.versions.compile.sdk.int)
        buildToolsVersion(libs.versions.build.tools.get())
    }

    private fun BaseExtension.setLintOptions() {
        lintOptions {
            // add any lint options needed for common android
        }
    }

    private fun Project.setBuildScript() {
        buildscript {
            repositories {
                // set any build script here
            }
        }
    }
}

