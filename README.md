# Webshop Backend – Java & Spring Boot

This is the backend system for a simple webshop project, developed as part of the *Backend Development in Java* course. The application is built using Java and Spring Boot, and it exposes a REST API that can be consumed by a frontend (e.g., React).

## Technologies & Frameworks

- Java 21
- Spring Boot 3.4.5
- Maven
- Spring Web (REST API)
- Bean Validation (Jakarta)
- Spring Boot DevTools (for hot-reloading)
- In-memory storage using Java Collections (List, Map)
- JUnit (unit testing – coming later)

## Getting Started

### Prerequisites

- Java 17+ (Java 21 is used in this project)
- Maven 3.8+
- IntelliJ IDEA (Community Edition is sufficient)
- Git (for version control)

### How to Run

1. Clone project to run locally.
```
git clone https://github.com/RobertAhlin/java-webshop.git
```
2. Open the project in IntelliJ IDEA
3. Run the `WebshopApplication.java` class
4. Open a browser and visit [http://localhost:8080/hello](http://localhost:8080/hello) to test

## Workflow

This section describes the development workflow followed while building the webshop backend.

### 1. Project Setup
- Created a new Spring Boot project using [start.spring.io](https://start.spring.io)
- Added dependencies: Spring Web, Lombok, Validation, DevTools
- Opened the project in IntelliJ IDEA Community Edition
- Initialized Git and connected to a public GitHub repository

### 2. Initial Testing
- Implemented a simple `GET /hello` endpoint to verify the app was running
- Used Postman to confirm the response from the backend

### 3. Product Management
- Created a `Product` class using Lombok to reduce boilerplate
- Built an in-memory `ProductRepository` using a `List<Product>` with sample data
- Added a `ProductService` to separate business logic
- Implemented `ProductController` with two REST endpoints:
    - `GET /api/products` – returns all products
    - `GET /api/products/{id}` – returns a single product by ID
- Verified all product endpoints using Postman
![postman test products API](readmefiles/postman-products-01.png)

### 4. Documentation
- Maintained and updated this `README.md` continuously during development
- Included API endpoint descriptions and run instructions



## API Endpoints (in progress)

| Method | URL        | Description                    |
|--------|------------|--------------------------------|
| GET    | `/hello`   | Simple greeting test endpoint  |
| GET    | `/api/products`        | Returns all available products      |
| GET    | `/api/products/{id}`   | Returns a product by its ID         |

> More endpoints (orders, etc.) will be added as the project evolves.

## 👤 Author

- Robert Ahlin
## Future planning
