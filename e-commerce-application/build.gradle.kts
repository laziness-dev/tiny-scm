description = "e-commerce Application Module"

repositories {
    mavenCentral()
}

buildscript {
    configurations["classpath"].resolutionStrategy.eachDependency {
        if (requested.group == "org.jooq") {
            useVersion("3.18.2")
        }
    }
}

sourceSets {
    main {
        java {
            srcDir(file("src/generated/jooq"))
        }
    }
}

dependencies {
    compileOnly(project(":e-commerce-domain"))
    compileOnly(project(":jooq-codegen"))

    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    jooqGenerator(project(":jooq-codegen"))
    jooqGenerator("org.jooq:jooq-meta-extensions-hibernate:3.18.2")
    jooqGenerator("com.h2database:h2:2.1.214")

    runtimeOnly("com.h2database:h2:2.1.214")
}


tasks.named<nu.studer.gradle.jooq.JooqGenerate>("generateSakilaDBJooq") {
    allInputsDeclared.set(true)
}
