import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "ru.perm.v"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

var camel_version = "2.25.4"
val spring_version = "6.1.3"
val junit_version = "4.13.2"
val slf4j_version = "1.6.1"

//Note that this is a BootJar plugin used in org.springframework.boot
apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")
apply(plugin = "kotlin-kapt")


repositories {
	mavenCentral()
	mavenLocal()
}

plugins {
	val kotlinVersion = "1.8.21"
	id("org.springframework.boot") version "2.5.6"
	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	id("maven-publish")
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("kapt") version "1.7.0"
	java
	idea
	application
}

dependencies {

	implementation("org.apache.camel:camel-core:$camel_version")

	//	Spring
	implementation("org.springframework:spring-context")
	implementation("org.springframework:spring-core")
	implementation("org.springframework:spring-beans")
	implementation("org.springframework:spring-test")

	implementation("org.slf4j:slf4j-api:$slf4j_version")
	implementation("org.slf4j:slf4j-simple:$slf4j_version")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("junit:junit:$junit_version")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
