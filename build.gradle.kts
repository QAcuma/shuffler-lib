plugins {
    id("java-library")
    id("version-catalog")
    id("maven-publish")
    id("org.springframework.boot") version "3.0.3"
    id("nu.studer.jooq") version "5.2"
}

group = "ru.acuma"
version = "3.0.3"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
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

publishing {
    repositories {
        maven {
            name = "shuffler-lib"
            url = uri("https://maven.pkg.github.com/QAcuma/shuffler-lib")
            credentials {
                username = System.getenv("GITHUB_USERNAME")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("shuffler-lib") {
            artifactId = "shuffler-lib"
            from(components["java"])
        }
    }
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