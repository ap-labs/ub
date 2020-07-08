plugins {
    id("java")
    id("maven-publish")
}

group = "ru.aplabs.ub"
version = project.findProperty("version") as String

java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.1")
    implementation("org.slf4j:slf4j-api:1.7.30")
    testImplementation("junit:junit:4.12")
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ap-labs/ub")

            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            artifactId = "ub-api"
            from(components["java"])
        }
    }
}
