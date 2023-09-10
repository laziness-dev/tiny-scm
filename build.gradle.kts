plugins {
    id("java")
    id("nu.studer.jooq") version "8.2" apply false
    id("org.springframework.boot") version("3.1.2") apply false
    id("io.spring.dependency-management") version("1.1.2") apply false
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

allprojects {
    group = "io.github.laziness_dev"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("java-library")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    val implementation by configurations

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
    }
}

project(":e-commerce-application") {
    apply {
        plugin("idea")
        plugin("nu.studer.jooq")
        from("jooq.gradle")
    }
}
