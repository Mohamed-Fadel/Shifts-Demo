import com.example.homebase.util.module

plugins {
    id("org.jetbrains.kotlin.android")
    `homebase-library`
}

module(
    projects.domain,
    projects.shared,
    projects.feature.shifts.featureShiftsDomain
)

dependencies {
    implementation(libs.androidx.coreKtx)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.constraint)

    implementation(libs.androidx.viewModel)
    implementation(libs.androidx.viewBinding)

    implementation(libs.bundles.kotlin.coroutines)
    implementation(libs.utils.result.monad)

    implementation(libs.koin.android)

    implementation(libs.google.material)

    implementation(libs.threeTen.abp)

    implementation("com.jaredrummler:material-spinner:1.3.1")

}