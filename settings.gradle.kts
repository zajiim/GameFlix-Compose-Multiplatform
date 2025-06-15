rootProject.name = "GameFlix"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
}

include(":composeApp")
include(":core-database")
include(":core-network")

include(":favorite:data")
include(":favorite:domain")
include(":favorite:presentation")

include(":game:data")
include(":game:domain")
include(":game:presentation")

include(":search:data")
include(":search:domain")
include(":search:presentation")

include(":shared")
