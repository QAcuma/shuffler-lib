@file:Suppress("UnstableApiUsage")
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

        maven("https://maven.pkg.github.com/QAcuma/shuffler-catalog")
    }

    versionCatalogs {
        create("libs") {
            from("ru.acuma:shuffler-catalog:2.0.3")
        }
    }
}