plugins {
    id("java-library")
    id("version-catalog")
    id("maven-publish")
    id("org.springframework.boot") version "2.7.3"
    id("org.flywaydb.flyway") version "8.2.3"
    id("nu.studer.jooq") version "5.2"
}

group = "ru.acuma"
version = "2.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_13
    targetCompatibility = JavaVersion.VERSION_13
}

val dbHost = System.getenv("SHUFFLER_DB_SERVER_HOST") ?: "localhost" as String?
val dbPort = System.getenv("SHUFFLER_DB_SERVER_PORT") ?: "5432" as String?
val dbName = System.getenv("SHUFFLER_DB_NAME") ?: "shuffler_local" as String?
val dbUser = System.getenv("SHUFFLER_DB_USER") ?: "local" as String?
val dbPassword = System.getenv("SHUFFLER_DB_PASSWORD") ?: "root" as String?

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation(libs.bundles.data)
    implementation(libs.bundles.util)
    implementation(libs.spring.web)
    jooqGenerator(libs.postgresql)
    annotationProcessor(libs.lombok)
    compileOnly(libs.lombok)
}
catalog {
    versionCatalog {
        plugin("springframework", "org.springframework.boot").versionRef("spring-boot")

        version("shuffler-lib", "1.0.9")
        version("spring-boot", "2.7.3")
        version("postgresql", "42.3.4")
        version("flyway", "8.5.10")
        version("jooq", "3.16.6")
        version("lombok", "1.18.24")
        version("telegrambots", "6.0.1")
        version("junit", "5.8.2")
        version("mockito", "4.5.1")
        version("orika", "2.2.7")
        version("gson", "2.9.0")
        version("lang3", "3.12.0")
        version("markdown", "1.3.2")

        library("shuffler-lib", "ru.acuma", "shuffler-lib").versionRef("shuffler-lib")

        library("spring-starter", "org.springframework.boot", "spring-boot-starter").versionRef("spring-boot")
        library("spring-web", "org.springframework.boot", "spring-boot-starter-web").versionRef("spring-boot")
        library("spring-test", "org.springframework.boot", "spring-boot-starter-test").versionRef("spring-boot")
        library("spring-security", "org.springframework.boot", "spring-boot-starter-security").versionRef("spring-boot")

        library("telegrambots", "org.telegram", "telegrambots").versionRef("telegrambots")
        library("telegrambotsextensions", "org.telegram", "telegrambotsextensions").versionRef("telegrambots")

        library("spring-jooq", "org.springframework.boot", "spring-boot-starter-jooq").versionRef("spring-boot")
        library("postgresql", "org.postgresql", "postgresql").versionRef("postgresql")
        library("flyway", "org.flywaydb", "flyway-core").versionRef("flyway")
        library("jooq", "org.jooq", "jooq").versionRef("jooq")

        library("lombok", "org.projectlombok", "lombok").versionRef("lombok")

        library("junit", "org.junit.jupiter", "junit-jupiter-engine").versionRef("lombok")
        library("mockito", "org.mockito", "mockito-core").versionRef("mockito")

        library("orika", "dev.akkinoc.spring.boot", "orika-spring-boot-starter").versionRef("orika")
        library("gson", "com.google.code.gson", "gson").versionRef("gson")
        library("lang3", "org.apache.commons", "commons-lang3").versionRef("lang3")
        library("markdown", "com.github.Steppschuh", "Java-Markdown-Generator").versionRef("markdown")

        bundle("data", listOf("spring-jooq", "postgresql", "flyway"))
        bundle("util", listOf("orika", "gson", "lang3", "markdown"))
        bundle("lombok", listOf("lombok"))
        bundle("telegram", listOf("telegrambots", "telegrambotsextensions"))
        bundle("test", listOf("spring-test", "junit", "mockito"))
    }
}

publishing {
    publications {
        create<MavenPublication>("shuffler-lib") {
            artifactId = "shuffler-lib"
            from(components["java"])
        }
        create<MavenPublication>("shuffler-catalog") {
            artifactId = "shuffler-catalog"
            from(components["versionCatalog"])
        }
    }
}

flyway {
    driver = "org.postgresql.Driver"
    url = "jdbc:postgresql://$dbHost:$dbPort/$dbName"
    user = dbUser
    password = dbPassword
    cleanDisabled = false
    encoding = "UTF-8"
}

jooq {
    version.set(libs.versions.jooq.get())
    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)

    configurations {
        create("main") {
            generateSchemaSourceOnCompilation.set(false)
            jooqConfiguration.apply {
                withLogging(org.jooq.meta.jaxb.Logging.ERROR)
                withOnError(org.jooq.meta.jaxb.OnError.LOG)
                jdbc.apply {
                    withDriver("org.postgresql.Driver")
                    withUrl("jdbc:postgresql://$dbHost:$dbPort/$dbName")
                    withUser(dbUser)
                    withPassword(dbPassword)
                }
                generator.apply {
                    withName("org.jooq.codegen.DefaultGenerator")
                    database.apply {
                        withName("org.jooq.meta.postgres.PostgresDatabase")
                        withInputSchema("public")
                        withExcludes("(.*_[0-9]+|.*_default)")
                        withForcedTypes(
                            arrayOf(
                                org.jooq.meta.jaxb.ForcedType()
                                    .withUserType("com.google.gson.JsonElement")
                                    .withName("varchar")
                                    .withIncludeExpression(".*")
                                    .withIncludeExpression(".*JSON.*")
                                    .withIncludeTypes("JSONB?")
                                    .withName("varchar")
                                    .withIncludeTypes("INET")
                            ).toList()
                        )
                    }
                    generate.apply {
                        withDaos(true)
                        withSpringAnnotations(true)
                        withPojos(true)
                        withFluentSetters(true)
                    }
                    target.apply {
                        withPackageName("ru.acuma.shuffler")
                        withDirectory("jooq")
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}