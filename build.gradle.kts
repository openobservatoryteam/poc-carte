group = "fr.openobservatory"
version = "0.0.1-SNAPSHOT"
description = "poc-carte-backend"
java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
    id("org.springframework.boot") version "3.0.0"
    id("io.freefair.lombok") version "6.6.1"
    id("com.diffplug.spotless") version "6.11.0"
    java
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.1")
    implementation("org.springframework.boot:spring-boot-starter-security:3.0.1")
    implementation("org.springframework.boot:spring-boot-starter-web:3.0.1")
    implementation("org.modelmapper:modelmapper:3.1.1")

    runtimeOnly("com.h2database:h2:2.1.214")
    runtimeOnly("org.springframework.boot:spring-boot-devtools:3.0.1")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.0.1")
}

spotless {
    java {
        googleJavaFormat()
    }
    kotlinGradle {
        target("*.gradle.kts")
        ktlint()
    }
}
