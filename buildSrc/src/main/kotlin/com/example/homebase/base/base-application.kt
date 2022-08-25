package com.example.homebase.base

import com.android.build.gradle.BaseExtension
import com.example.homebase.util.applyAndroid
import com.example.homebase.util.applyPlugins
import org.gradle.api.Plugin
import org.gradle.api.Project

class BaseApplicationPlugin : Plugin<Project> {

    override fun apply(project: Project) = project.run {
        applyPlugins(
            "com.android.application"
        )
        applyAndroid {
            enableViewBinding()
            applyPlugins()
            applyDefaultConfig()
            applyAaptOptions()
        }
    }


    private fun BaseExtension.applyAaptOptions() {
        aaptOptions {
            // add any extensions needed for aapt
        }
    }

    private fun BaseExtension.applyDefaultConfig() {
        defaultConfig {
            versionCode = Integer.valueOf(
                System.getenv("VERSION_CODE") ?: System.getenv("GITHUB_RUN_NUMBER") ?: "1"
            )
            applicationId = "com.example.homebase"
        }
    }

    private fun BaseExtension.enableViewBinding() {
        buildFeatures.viewBinding = true
    }

    private fun Project.applyPlugins() {
        applyPlugins(
            "homebase-android"
        )
    }
}

