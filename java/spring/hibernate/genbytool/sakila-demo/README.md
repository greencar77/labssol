# Sakila Spring Boot Hibernate Demo

This project demonstrates how to generate Hibernate entities from the MySQL 'sakila' sample database.

## Prerequisites
- Java 17
- MySQL server with 'sakila' database installed

**Note on Maven:** This project uses the Maven Wrapper. You don't need to install Maven globally. Use `.\mvnw.cmd` on Windows or `./mvnw` on Linux/macOS.

## Database Configuration
Update `src/main/resources/application.properties` and `src/main/resources/hibernate.properties` with your MySQL credentials:
```properties
# src/main/resources/application.properties
spring.datasource.username=your_username
spring.datasource.password=your_password

# src/main/resources/hibernate.properties
hibernate.connection.username=your_username
hibernate.connection.password=your_password
```

## How to Generate Entity Classes
The entity generation is configured using the `hibernate-tools-maven` plugin in `pom.xml`. It is set to NOT run during the standard build process (phase: none).

To generate the entities manually, run the following Maven command from the `sakila-demo` directory:

```bash
# On Windows
.\mvnw.cmd hibernate-tools:hbm2java

# On Linux/macOS
./mvnw hibernate-tools:hbm2java
```

### Configuration Details:
- **Package Name**: `com.example.sakilademo.entity`
- **Output Directory**: `target/generated-sources/hibernate` (default for the plugin) or configured in `pom.xml`.
- **Strategy**: It uses reverse engineering based on the database schema defined in `src/main/resources/hibernate.reveng.xml`.

If you want the generated files to be moved to your source folder automatically, you can either:
1. Copy them from `target/generated-sources/hibernate` to `src/main/java`.
2. Update the `<outputDirectory>` in `pom.xml` to `src/main/java`.

## Running the Application
```bash
.\mvnw.cmd spring-boot:run
```
