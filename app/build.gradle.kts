plugins {
    id("application")
    id("com.github.ben-manes.versions") version "0.52.0"
    id("checkstyle")
    id("org.sonarqube") version "7.2.3.7755"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("info.picocli:picocli:4.7.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.0.1")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

}

application {
    mainClass = "hexlet.code.App"
}

checkstyle {
    toolVersion = "10.12.4"
}

sonar {
    properties {
        property("sonar.projectKey", "anstyfil_java-project-71")
        property("sonar.projectName", "java-project-71")
        property("sonar.organization", "anstyfil")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}


tasks.test {
    useJUnitPlatform()
}
