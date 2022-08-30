plugins {
    `homebase-library`
}

dependencies {
    implementation(libs.androidx.coreKtx)
    implementation(libs.androidx.appCompat)

    implementation(libs.androidx.viewModel)
    implementation(libs.google.material)

    implementation(libs.koin.android)

    implementation(libs.utils.result.monad)


    implementation(libs.threeTen.abp)
}