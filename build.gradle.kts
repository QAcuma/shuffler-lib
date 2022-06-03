plugins {
    id("java-library")
    id("maven-publish")
    id("org.springframework.boot") version "2.6.1"
    id("org.flywaydb.flyway") version "8.2.3"
    id("nu.studer.jooq") version "5.2"
}

group = "ru.acuma"
version = "1.0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_13
    targetCompatibility = JavaVersion.VERSION_13
}

val dbHost = System.getenv("K_SHUFFLER_DB_SERVER_HOST") ?: "localhost" as String?
val dbPort = System.getenv("K_SHUFFLER_DB_SERVER_PORT") ?: "5432" as String?
val dbName = System.getenv("K_SHUFFLER_DB_NAME") ?: "shuffler_local" as String?
val dbUser = System.getenv("K_SHUFFLER_DB_USER") ?: "local" as String?
val dbPassword = System.getenv("K_SHUFFLER_DB_PASSWORD") ?: "root" as String?

var springBootVersion = "2.6.7"
var lombokBootVersion = "1.18.24"
var lang3Version = "3.12.0"
var log4jVersion = "1.2.17"
var junitVersion = "5.8.1"
var psqlVersion = "42.3.4"
var flywayVersion = "8.5.10"
var jooqVersion = "3.16.6"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    api(libs.bundles.data)
    jooqGenerator(libs.postgresql)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
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
    cleanDisabled = true
    encoding = "UTF-8"
}

jooq {
    version.set(libs.versions.jooq.get())
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