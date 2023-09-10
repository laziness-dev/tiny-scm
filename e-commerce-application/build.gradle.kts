description = "e-commerce Application Module"

repositories {
    mavenCentral()
}

buildscript {
    configurations["classpath"].resolutionStrategy.eachDependency {
        if (requested.group == "org.jooq") {
            useVersion("3.18.6")
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
    api(project(":e-commerce-domain"))

    implementation("org.springframework.boot:spring-boot-starter-jooq")

    jooqGenerator(project(":jooq-codegen"))
    jooqGenerator("org.jooq:jooq-meta-extensions-hibernate:3.18.4")
    jooqGenerator("com.h2database:h2:2.1.214")

    runtimeOnly("com.h2database:h2:2.1.214")
}


tasks.named<nu.studer.gradle.jooq.JooqGenerate>("generateSakilaDBJooq") {
    allInputsDeclared.set(true)
}
