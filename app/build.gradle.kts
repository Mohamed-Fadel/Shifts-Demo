import com.example.homebase.util.module

plugins {
    `homebase-application`
}

module(
    projects.data,
    projects.shared,
    projects.feature.shifts.featureShifts,
    projects.feature.shifts.featureShiftsDomain
)

dependencies {

    implementation(libs.androidx.coreKtx)
    implementation(libs.androidx.appCompat)

    implementation(libs.koin.android)
    implementation(libs.google.material)

    implementation(libs.threeTen.abp)
}