# University Portal Backend

This repository contains the backend implementation of the University Portal project developed for the University of Liechtenstein. The system provides RESTful APIs for managing students, courses, registrations, schedules, and authentication.

## Tech Stack
```

- Java 17+
- Spring Boot
- Spring Security
- JWT Authentication
- PostgreSQL
- JPA / Hibernate
- Maven
```

## Architecture
```
The backend follows a layered architecture:


- Controller Layer — REST API endpoints
- Service Layer — Business logic
- Repository Layer — Database access
- Security Layer — JWT authentication and authorization
```

## Features
```

- User authentication (JWT)
- Role-based access control (RBAC)
- Student management
- Course and module management
- Course registration
- Schedule management
- RESTful API design
- PostgreSQL integration
```

## Project Structure

```

src/
├── controller
├── service
├── repository
├── entity
├── dto
├── security
└── config

```

## Prerequisites
```
Make sure you have installed:

- Java 17 or higher
- Maven
- PostgreSQL
- Git
```
## Database Configuration
```
Update `application.properties`:
```
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/university_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

## Running the Application

Clone the repository:

```bash
git clone https://github.com/Amal146/uni-portal-backend.git
```

Navigate to the project:

```bash
cd uni-portal-backend
```

Run the application:

```bash
mvn spring-boot:run
```

Or using jar:

```bash
mvn clean package
java -jar target/*.jar
```

The server will start at:

```
http://localhost:8080
```

## Authentication

The API uses JWT authentication.

### Login

```
POST /api/auth/login
```

### Register

```
POST /api/auth/register
```

Include token in requests:

```
Authorization: Bearer <token>
```

## Main API Endpoints

### Authentication

```
POST /api/auth/login
POST /api/auth/register
```

### Users

```
GET /api/users
POST /api/users
```

### Courses

```
GET /api/courses
POST /api/courses
```

### Registrations

```
POST /api/registrations
GET /api/registrations
```

## Security
```
The system includes:

* JWT stateless authentication
* Role-based authorization
* Password encryption
* Protected API endpoints
```
## Contributors
```
* Amal Jawahdou
* Team A&A
  University of Liechtenstein
```
## License
```
This project is developed for academic purposes.

```
