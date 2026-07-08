# Spring Learn Application Walkthrough

## 1. Directory Structure Overview
* **`src/main/java`**: This folder contains the main application source code. It houses all the Java packages (e.g., `com.cognizant.springlearn`) and classes required to run the application, including the main entry point, controllers, services, and repositories.
* **`src/main/resources`**: This folder is dedicated to application configuration files and static resources. It typically includes `application.properties` (or `application.yml`) where you define server ports, database configurations, and custom application properties. It also holds templates and static assets (HTML, CSS, JS).
* **`src/test/java`**: This folder contains all the code for testing the application. It mirrors the package structure of `src/main/java` and holds unit tests and integration tests (e.g., `SpringLearnApplicationTests.java`).

## 2. Walkthrough: SpringLearnApplication `main()` Method
```java
@SpringBootApplication
public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting SpringLearnApplication...");
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("SpringLearnApplication started successfully!");
    }
}
```
* The `main()` method is the standard entry point for any Java application.
* `SpringApplication.run()` is called to bootstrap the application. It creates the Spring application context, sets up the embedded web server (like Tomcat), and starts listening for requests.
* We included `LOGGER.info()` statements before and after `run()` to verify that the method is executed, satisfying the requirement to track execution in the console.

## 3. Purpose of `@SpringBootApplication` Annotation
`@SpringBootApplication` is a convenience annotation that acts as a wrapper for three essential Spring annotations:
1. **`@Configuration`**: Tags the class as a source of bean definitions for the application context.
2. **`@EnableAutoConfiguration`**: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if `spring-webmvc` is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a `DispatcherServlet`.
3. **`@ComponentScan`**: Tells Spring to look for other components, configurations, and services in the `com.cognizant.springlearn` package, allowing it to find and register controllers and other components automatically.

## 4. `pom.xml` Walkthrough
The `pom.xml` (Project Object Model) is the core configuration file for Maven.
* **`<parent>`**: Inherits defaults from `spring-boot-starter-parent` (like dependency versions and plugin configurations).
* **`<dependencies>`**: 
  * `spring-boot-starter-web`: Pulls in all dependencies needed for building web applications, including RESTful applications using Spring MVC. It uses Tomcat as the default embedded container.
  * `spring-boot-devtools`: Provides fast application restarts and LiveReload for an improved development experience.
  * `spring-boot-starter-test`: Pulls in libraries like JUnit, Mockito, and Spring Test for writing robust tests.
* **`<build>`**: Includes the `spring-boot-maven-plugin`, which packages the application as an executable JAR file.

## 5. Dependency Tree (Dependency Hierarchy)
If you were to open the 'Dependency Hierarchy' in an IDE like Eclipse, or run `mvn dependency:tree` in the command line, you would see a structure similar to this:
```
com.cognizant:spring-learn:jar:0.0.1-SNAPSHOT
+- org.springframework.boot:spring-boot-starter-web:jar:3.1.2:compile
|  +- org.springframework.boot:spring-boot-starter-json:jar:3.1.2:compile
|  +- org.springframework.boot:spring-boot-starter-tomcat:jar:3.1.2:compile
|  +- org.springframework:spring-web:jar:6.0.11:compile
|  \- org.springframework:spring-webmvc:jar:6.0.11:compile
+- org.springframework.boot:spring-boot-devtools:jar:3.1.2:runtime
+- org.springframework.boot:spring-boot-starter-test:jar:3.1.2:test
|  +- org.junit.jupiter:junit-jupiter:jar:5.9.3:test
|  +- org.mockito:mockito-core:jar:5.3.1:test
|  \- ...
```
This tree demonstrates how top-level "starter" dependencies automatically bring in their required transitive dependencies, dramatically simplifying setup and avoiding version conflicts.
