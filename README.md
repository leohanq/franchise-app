# Franchise App

REST API for managing franchises, their locations (branches), and products. Built with Clean Architecture principles.

## Tech Stack

- Java 21
- Spring Boot 4.1.1
- Spring Data JPA / Hibernate
- MySQL
- Lombok
- Maven

## Architecture

The project follows a Clean Architecture / Use Case-driven layered approach:

```
entrypoint/rest/        -> Controllers, Request DTOs (inbound)
usecase/                -> Use case interfaces + Service implementations (business logic)
domain/                 -> Entities, DTOs, Mappers (core)
dataprovider/           -> Data providers + JPA Repositories (outbound)
```

## Entity Model

```
Franchise (1) ───── (*) Location (1) ───── (*) Product
```

| Entity | Table | Fields |
|--------|-------|--------|
| Franchise | `franchise` | id, name, taxId |
| Location | `location` | id, name, address, franchise_id (FK) |
| Product | `product` | id, name, stock, location_id (FK) |

## AWS Deployment

This project is deployed on AWS using the following services:

- **Amazon ECS (Fargate)** — runs the containerized application
- **Amazon RDS (MySQL 8)** — managed database
- **AWS Secrets Manager** — stores database credentials securely
- **Amazon ECR** — Docker image registry
### Hosts

| Environment | URL |
|-------------|-----|
| Local | `http://localhost:8080/api/v1` |
| AWS (prod) | `http://3.239.14.81:8080/api/v1` |

## Prerequisites

- Java 21+
- Maven 3.9+ (or use the included `mvnw` wrapper)
- MySQL 8+ running on `localhost:3306`

## Database Setup

```sql
CREATE DATABASE franchise;
```

The application uses `ddl-auto: update`, so tables are created/updated automatically on startup.

## Configuration

Default connection in `src/main/resources/application.yaml`:

```yaml
server:
  servlet:
    context-path: /api/v1

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/franchise
    username: 'your local user'
    password: 'your local password'
```

## How to Run

```bash
# From the franchise-app/ directory
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080/api/v1`.

## API Endpoints

### Franchise

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/franchise` | Create a franchise |
| GET | `/api/v1/franchise/{id}/max-stock-products` | Get top stock product per location |

### Location

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/location` | Create a location |

### Product

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/product` | Create a product |
| PATCH | `/api/v1/product/{id}/stock` | Reduce product stock |
| DELETE | `/api/v1/product/{id}` | Delete a product |

## Example Requests

### Create Franchise

```bash
POST http://localhost:8080/api/v1/franchise
Content-Type: application/json

{
    "name": "McDonald's Colombia",
    "taxId": "900123456-7"
}
```

### Create Location

```bash
POST http://localhost:8080/api/v1/location
Content-Type: application/json

{
    "name": "Sede Norte",
    "address": "Calle 100 #15-20, Bogota",
    "franchiseId": 1
}
```

### Create Product

```bash
POST http://localhost:8080/api/v1/product
Content-Type: application/json

{
    "name": "Big Mac",
    "stock": 50,
    "locationId": 1
}
```

### Update Stock (subtract)

```bash
PATCH http://localhost:8080/api/v1/product/1/stock
Content-Type: application/json

{
    "stock": 5
}
```

### Delete Product

```bash
DELETE http://localhost:8080/api/v1/product/1
```

### Get Top Stock Products by Franchise

```bash
GET http://localhost:8080/api/v1/franchise/1/max-stock-products
```

Returns the product with the highest stock for each location within the franchise.

## Business Rules

- **Stock modification**: Subtracts the requested amount from current stock. Returns error if resulting stock would be negative ("Insufficient stock").
- **Max stock query**: For a given franchise, returns the product with the highest stock per location.