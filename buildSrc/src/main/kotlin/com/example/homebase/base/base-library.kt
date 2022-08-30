package com.example.homebase.base

import com.android.build.gradle.BaseExtension
import com.example.homebase.util.applyPlugins
import com.example.homebase.util.applyAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class BaseLibraryPlugin : Plugin<Project> {

    override fun apply(project: Project) = project.run {
        applyPlugins(
            "com.android.library"
        )
        applyAndroid {
            applyPlugins()
            enableViewBinding()
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
