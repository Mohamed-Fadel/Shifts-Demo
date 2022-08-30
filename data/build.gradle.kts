import com.example.homebase.util.module

plugins {
    `homebase-library`
    id("com.google.devtools.ksp").version("1.6.10-1.0.4")
}

module(
    projects.shared
)

dependencies {
//    implementation(libs.google.gson)
    implementation(libs.bundles.moshi)

    implementation(libs.koin.android)
    implementation(libs.threeTen.abp)

    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")
}