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
            version("orika", "2.2.7")
            version("gson", "2.9.0")
            version("lang3", "3.12.0")
            version("lombok", "1.18.24")

            library("spring-web", "org.springframework.boot", "spring-boot-starter-web").versionRef("spring-boot")

            library("spring-jooq", "org.springframework.boot", "spring-boot-starter-jooq").versionRef("spring-boot")
            library("postgresql", "org.postgresql", "postgresql").versionRef("postgresql")
            library("flyway", "org.flywaydb", "flyway-core").versionRef("flyway")

            library("orika", "dev.akkinoc.spring.boot", "orika-spring-boot-starter").versionRef("orika")
            library("gson", "com.google.code.gson", "gson").versionRef("gson")
            library("lang3", "org.apache.commons", "commons-lang3").versionRef("lang3")

            library("lombok", "org.projectlombok", "lombok").versionRef("lombok")

            bundle("web", listOf("spring-web"))
            bundle("data", listOf("spring-jooq", "postgresql", "flyway"))
            bundle("util", listOf("orika", "gson", "lang3"))
            bundle("lombok", listOf("lombok"))
        }
    }
}