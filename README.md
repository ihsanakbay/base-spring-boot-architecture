# Base Spring Boot Architecture Template

This is a comprehensive Spring Boot architecture template that can be used as a foundation for any Spring Boot application. It includes all the essential components and best practices for building robust, secure, and maintainable applications.

## Features

- **Security**: JWT-based authentication and role-based authorization
- **Validation**: Bean validation with custom validators
- **Exception Handling**: Global exception handling with standardized responses
- **Logging**: AOP-based comprehensive logging
- **Database**: H2 in-memory database (easily configurable for other databases)
- **API Documentation**: OpenAPI/Swagger integration
- **Generic Components**: Base entity, service, and response classes
- **Auditing**: Automatic tracking of entity creation and modification

## Project Structure

```
src/main/java/com/ihsanakbay/base_spring_boot_architecture/
├── aspect/                  # AOP aspects for cross-cutting concerns
├── config/                  # Configuration classes
├── controller/              # REST controllers
├── dto/                     # Data Transfer Objects
│   ├── request/             # Request DTOs
│   └── response/            # Response DTOs
├── enums/                   # Enumeration classes
├── exception/               # Custom exceptions and global exception handler
├── model/                   # Entity classes
├── repository/              # Spring Data JPA repositories
├── security/                # Security configuration and components
│   ├── jwt/                 # JWT implementation
│   └── service/             # Security-related services
├── service/                 # Business logic services
│   └── impl/                # Service implementations
├── util/                    # Utility classes
└── validation/              # Custom validation components
    ├── annotation/          # Custom validation annotations
    └── validator/           # Custom validators
```

## Getting Started

### Prerequisites

- JDK 21 or later
- Gradle 8.x or later

### Running the Application

```bash
./gradlew bootRun
```

The application will start on http://localhost:8080/api

### API Documentation

Once the application is running, you can access the API documentation at:

```
http://localhost:8080/api/swagger-ui/index.html
```

### H2 Console

The H2 database console is available at:

```
http://localhost:8080/api/h2-console
```

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `password`

## Authentication

The application uses JWT for authentication. To get a token:

1. Register a user: `POST /api/auth/signup`
2. Login to get a token: `POST /api/auth/signin`
3. Use the token in the Authorization header: `Bearer <token>`

## Customization

This template is designed to be easily customizable:

1. Update application.yaml with your specific configuration
2. Add your own entity classes extending BaseEntity
3. Create repositories for your entities
4. Implement services extending BaseServiceImpl
5. Create controllers for your services

## Contributing

Feel free to contribute to this template by submitting pull requests or suggesting improvements.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
