rootProject.name = "shuffler-lib"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
    }

    versionCatalogs {
        create("libs") {
            from("ru.acuma:shuffler-catalog:2.0.1")
        }
    }
}