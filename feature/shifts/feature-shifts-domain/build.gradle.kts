import com.example.homebase.util.module

plugins {
    // TODO:: need to change it to `homebase-kotlin-library` because it doesn't depend on android sdk but facing some gradle issue need more time to fix
    `homebase-library`
    id("com.google.devtools.ksp").version("1.6.10-1.0.4") // Or latest version of KSP
}

module(
    projects.domain,
    projects.data
)

dependencies {
    implementation(libs.bundles.kotlin.coroutines)
    implementation(libs.utils.result.monad)
    implementation(libs.koin.android)
//    implementation(libs.google.gson)
    implementation(libs.bundles.moshi)

    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")

    implementation(libs.threeTen.abp)
}