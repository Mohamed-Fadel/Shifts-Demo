package com.example.homebase.util

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.provider.Provider

val Project.library get()= extensions.getByName("libs") as LibrariesForLibs

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