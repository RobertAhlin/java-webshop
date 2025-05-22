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

## API Endpoints (in progress)

| Method | URL        | Description                    |
|--------|------------|--------------------------------|
| GET    | `/hello`   | Simple greeting test endpoint  |

> More endpoints (products, orders, etc.) will be added as the project evolves.

## 👤 Author

- Robert Ahlin
## Future planning

### Plan för produkthantering    
**Steg 1** – Skapa Product-modellen  
Skapa en klass med attributen från specifikationen.  

**Steg 2** – Skapa exempelprodukter i en "Repository"-klass (in-memory)  
Använda t.ex. en List<Product> som hårdkodas vid start.  

**Steg 3** – Skapa ProductService som hämtar produkter från repository  
**Steg 4** – Skapa REST-controller med endpoints:  
- GET /api/products – lista alla produkter  

- GET /api/products/{id} – hämta en produkt baserat på ID  

**Steg 5** – Testa i webbläsare eller Postman