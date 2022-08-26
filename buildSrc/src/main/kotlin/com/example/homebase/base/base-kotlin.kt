package com.example.homebase.base

import com.example.homebase.util.applyAndroid
import com.example.homebase.util.applyPlugins
import com.example.homebase.util.library
import org.gradle.api.JavaVersion.VERSION_11
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.buildscript
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.repositories
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class BaseKotlinPlugin : Plugin<Project> {

    override fun apply(project: Project) = project.run {
        setBuildScript()
        setJvmTarget()
        setCompileOptions()
        applyPlugins()
        setDependencies()
    }

    private fun Project.applyPlugins() {
        applyPlugins(
            "kotlin-kapt"
        )
    }

    private fun Project.setDependencies() {
        dependencies {
            add("implementation", library.kotlin.stdLib)

            // TODO:: check the following usage
//            add("implementation", library.bundles.kotlin.coroutines)

//            add("implementation", library.log.timber)
        }
    }

    private fun Project.setCompileOptions() {
        applyAndroid {
            compileOptions {
                sourceCompatibility = VERSION_11
                targetCompatibility = VERSION_11
            }
        }
    }

    private fun Project.setJvmTarget() {
        tasks.withType(KotlinCompile::class.java).all {
            kotlinOptions {
                jvmTarget = VERSION_11.toString()
            }
        }
    }

    private fun Project.setBuildScript() {
        buildscript {
            repositories {
                mavenCentral()
                gradlePluginPortal()
            }
        }
    }
}

