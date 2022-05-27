plugins {
    id("java-library")
    id("maven-publish")
    id("org.springframework.boot") version "2.6.1"
    id("org.flywaydb.flyway") version "8.2.3"
    id("nu.studer.jooq") version "5.2"
}

group = "ru.acuma"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

val dbHost = System.getenv("K_SHUFFLER_DB_SERVER_HOST") ?: "80.85.139.74" as String?
val dbPort = System.getenv("K_SHUFFLER_DB_SERVER_PORT") ?: "5432" as String?
val dbName = System.getenv("K_SHUFFLER_DB_NAME") ?: "ks_local" as String?
val dbUser = System.getenv("K_SHUFFLER_DB_USER") ?: "ks_local" as String?
val dbPassword = System.getenv("K_SHUFFLER_DB_PASSWORD") ?: "kicker" as String?

var springBootVersion = "2.6.7"
var lombokBootVersion = "1.18.24"
var lang3Version = "3.12.0"
var log4jVersion = "1.2.17"
var junitVersion = "5.8.1"
var telegramBotVersion = "6.0.1"
var psqlVersion = "42.3.4"
var flywayVersion = "8.5.10"
var jooqVersion = "3.16.6"
val codeGsonVersion = "2.9.0"
val orikaVersion = "2.2.7"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-jooq:$springBootVersion")

    api("org.postgresql:postgresql:$psqlVersion")
    api("org.flywaydb:flyway-core:$flywayVersion")
    api("org.jooq:jooq:$jooqVersion")
    compileOnly("org.jooq:jooq-meta:$jooqVersion")
    compileOnly("org.jooq:jooq-codegen:$jooqVersion")
    jooqGenerator("org.postgresql:postgresql:$psqlVersion")

    compileOnly("org.projectlombok:lombok:$lombokBootVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokBootVersion")
}

publishing {
    publications {
        create<MavenPublication>("shuffler-lib") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            url = uri("${buildDir}/publishing-repository")
        }
    }
}

flyway {
    driver = "org.postgresql.Driver"
    url = "jdbc:postgresql://$dbHost:$dbPort/$dbName"
    user = dbUser
    password = dbPassword
    cleanDisabled = false
}

jooq {
    version.set(jooqVersion)
    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)

    configurations {
        create("main") {
            generateSchemaSourceOnCompilation.set(false)
            jooqConfiguration.apply {
                logging = org.jooq.meta.jaxb.Logging.ERROR
                onError = org.jooq.meta.jaxb.OnError.LOG
                jdbc.apply {
                    driver = "org.postgresql.Driver"
                    url = "jdbc:postgresql://$dbHost:$dbPort/$dbName"
                    user = dbUser
                    password = dbPassword
                }
                generator.apply {
                    name = "org.jooq.codegen.DefaultGenerator"
                    database.apply {
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "public"
                        excludes = "(.*_[0-9]+|.*_default)"
                        forcedTypes.addAll(
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
                        isDeprecated = false
                        isRecords = true
                        isPojos = true
                        isImmutablePojos = false
                        isFluentSetters = true
                    }
                    target.apply {
                        packageName = "ru.acuma.k.shuffler"
                        directory = "jooq"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}