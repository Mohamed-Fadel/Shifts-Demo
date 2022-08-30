rootProject.name = "HomeBase"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include (":app")

include (":feature:shifts:feature-shifts")
include(":feature:shifts:feature-shifts-domain")
include(":domain")
include(":data")
include(":shared")
