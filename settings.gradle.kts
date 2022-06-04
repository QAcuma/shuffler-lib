rootProject.name = "shuffler-lib"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}
enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("spring-boot", "2.6.7")
            version("postgresql", "42.3.4")
            version("flyway", "8.5.10")
            version("jooq", "3.16.6")
            version("lombok", "1.18.24")

            library("spring-jooq", "org.springframework.boot", "spring-boot-starter-jooq").versionRef("spring-boot")
            library("postgresql", "org.postgresql", "postgresql").versionRef("postgresql")
            library("flyway", "org.flywaydb", "flyway-core").versionRef("flyway")
            library("lombok", "org.projectlombok", "lombok").versionRef("lombok")

            bundle("data", listOf("spring-jooq", "postgresql", "flyway"))
            bundle("lombok", listOf("lombok"))
        }
    }
}