import org.springframework.boot.gradle.tasks.bundling.BootJar

description = "jOOQ DSL Generator Module"

tasks.named<BootJar>("bootJar") {
    enabled = false
}

tasks.named<Jar>("jar") {
    enabled = true
}

dependencies {
    api(project(":e-commerce-domain"))
    implementation("org.jooq:jooq-codegen:3.18.6")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
}
