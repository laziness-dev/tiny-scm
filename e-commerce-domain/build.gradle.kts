import org.springframework.boot.gradle.tasks.bundling.BootJar

description = "e-commerce Domain Module"

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}

tasks.getByName<Jar>("jar") {
    enabled = true
}

dependencies {
    api("org.springframework.data:spring-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("org.hibernate.orm:hibernate-core:6.2.6.Final")
    implementation("org.projectlombok:lombok:1.18.28")

    annotationProcessor("org.projectlombok:lombok:1.18.28")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
