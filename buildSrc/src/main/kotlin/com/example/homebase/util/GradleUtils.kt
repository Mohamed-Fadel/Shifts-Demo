package com.example.homebase.util

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.internal.catalog.DelegatingProjectDependency
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope

val Project.library get()= extensions.getByName("libs") as LibrariesForLibs

fun Project.applyJava(func: BaseExtension.() -> Unit) {
    val androidExtension = project.extensions.getByName("java")
    if (androidExtension is BaseExtension) {
        androidExtension.apply(func)
    }
}

fun Project.applyAndroid(func: BaseExtension.() -> Unit) {
    val androidExtension = project.extensions.getByName("android")
    if (androidExtension is BaseExtension) {
        androidExtension.apply(func)
    }
}

val Provider<String>.int get()= get().toInt()

/* Takes list of plugins and applies all those plugins in project with help of plugin manager. */
fun Project.applyPlugins(vararg pluginIds: String) = pluginIds.forEach {
    pluginManager.apply(it)
}

private fun Project.impl(moduleDependencies: Array<out DelegatingProjectDependency>, type: String) {
    val handlerScope = DependencyHandlerScope.of(dependencies)
    handlerScope.apply {
        moduleDependencies.forEach { dependency ->
            type(dependency)
        }
    }
}
// Region: Our TOML Project Implementation implementation(libs.domain)
fun Project.module(vararg moduleDependencies: DelegatingProjectDependency) =
    impl(moduleDependencies, "implementation")