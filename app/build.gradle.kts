import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
    // TODO - setup ktlint!
    // id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    id("com.palantir.docker") version "0.25.0"
    id("com.revolut.jooq-docker") version "0.3.4"
}

group = "ru.aplabs.ub"
java.sourceCompatibility = JavaVersion.VERSION_1_8

sourceSets {
    main {
        java {
            srcDir("src/main/java")
            srcDir("src/main/jooq")
        }
    }
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("io.javalin:javalin:3.9.1")
    implementation("com.squareup.okhttp3:okhttp:4.7.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.4")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.4")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.10.4")
    implementation("org.flywaydb:flyway-core:6.4.4")
    implementation("com.zaxxer:HikariCP:3.4.5")
    implementation("org.postgresql:postgresql:42.2.14")
    implementation("org.jooq:jooq:3.13.2")
    jdbc("org.postgresql:postgresql:42.2.14")
    implementation("org.slf4j:slf4j-api:1.7.30")
    testImplementation("junit:junit:4.12")
    testImplementation("org.testcontainers:testcontainers:1.14.3")
    testImplementation("org.testcontainers:postgresql:1.14.3")
}

tasks {
    generateJooqClasses {
        schemas = arrayOf("ub")
        basePackageName = "ru.aplabs.ub.generated"
        inputDirectory.setFrom(project.files("src/main/resources/db/migration"))
        outputDirectory.set(project.layout.projectDirectory.dir("src/main/jooq"))
        flywayProperties = mapOf("flyway.placeholderReplacement" to "false")
        excludeFlywayTable = true
        outputSchemaToDefault = setOf("ub")
        customizeGenerator {
            // stub
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

docker {
    dependsOn(tasks.getByName("build"))
    name = "docker.pkg.github.com/ap-labs/ub"
    setDockerfile(file("Dockerfile"))
    files(file("build/libs/app.jar"), file("docker-entrypoint.sh"))
    noCache(true)
    pull(true)
}
