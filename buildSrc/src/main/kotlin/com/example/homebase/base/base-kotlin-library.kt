package com.example.homebase.base

import com.example.homebase.util.applyPlugins
import org.gradle.api.JavaVersion.VERSION_11
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.buildscript
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.repositories
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class BaseKotlinLibraryPlugin : Plugin<Project> {

    override fun apply(project: Project) = project.run {
        applyPlugins()
        setBuildScript()
        setCompileOptions()
        setJvmTarget()
        setDependencies()
    }

    private fun Project.applyPlugins() {
        applyPlugins(
            "java-library",
            "org.jetbrains.kotlin.jvm",
            "kotlin-kapt"
        )
    }

    private fun Project.setDependencies() {
        dependencies {
        }
    }

    private fun Project.setCompileOptions() {
        tasks.withType(JavaCompile::class.java).all {
            sourceCompatibility = VERSION_11.toString()
            targetCompatibility = VERSION_11.toString()
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
                google()
                mavenCentral()
                gradlePluginPortal()
            }
        }
    }
}

