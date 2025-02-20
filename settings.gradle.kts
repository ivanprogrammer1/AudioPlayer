pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AudioPlayer"
include(":app")
include(":core:player")
include(":features:player:impl")
include(":features:player:api")
include(":core:coroutines")
include(":core:ui")
include(":features:audiolist:impl")
include(":features:audiolist:api")
