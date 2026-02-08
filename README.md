# Endterm Project — Car Rental REST API

## Project Overview

This project is a Spring Boot RESTful API for a **Car Rental System**, developed as the Endterm Project.
It integrates **Design Patterns**, **Component Principles**, **SOLID**, and **REST architecture**.

The system allows:
- Managing cars (CRUD)
- Renting cars
- Tracking rentals
- Working with a relational database using Spring Data JPA

---

## Technologies Used

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven
- Hibernate
- Postman (API testing)

---

## REST API Documentation

### Cars

#### Create car
**POST** `/cars`

```json
{
  "type": "ELECTRIC",
  "name": "Tesla Model 3",
  "pricePerDay": 120,
  "batteryCapacity": 75
}
Get all cars
GET /cars

Get car by id
GET /cars/{id}

Update car
PUT /cars/{id}

json
Копировать код
{
  "type": "ELECTRIC",
  "name": "Tesla Model Y",
  "pricePerDay": 150,
  "batteryCapacity": 80
}
Delete car
DELETE /cars/{id}

Rentals
Rent a car
POST /rentals

json
Копировать код
{
  "carId": 1,
  "customerId": 100,
  "startDate": "2026-02-10",
  "endDate": "2026-02-15"
}
If the car is already rented, the system returns an error.

Design Patterns
Singleton Pattern
Used for:

Database configuration

Example:

DatabaseConfigSingleton

Ensures only one instance exists during application lifecycle.

Factory Pattern
Used for creating different car types:

Car (abstract)

ElectricCar

GasCar

Implemented in:

CarFactory

Allows easy extension for new car types.

Builder Pattern
Used for building complex objects with optional fields.

Implemented in:

CarBuilder

RentalBuilder

Provides fluent and readable object creation.

Component Principles
REP (Reuse/Release Equivalence Principle)
Reusable packages:

repository

service

patterns

utils

CCP (Common Closure Principle)
Classes that change together are grouped together:

Controllers

Services

Entities

CRP (Common Reuse Principle)
Modules depend only on required classes.
No unnecessary dependencies between layers.

SOLID & OOP Principles
Single Responsibility — controllers, services, repositories have distinct responsibilities

Open/Closed — new car types can be added without modifying existing logic

Liskov Substitution — subclasses replace base Car safely

Interface Segregation — repositories expose minimal required methods

Dependency Inversion — services depend on abstractions (repositories)

Database Schema
Tables:
cars

rentals

Relationships:
One car can have many rentals

Rental references a car by car_id

System Architecture
nginx
Копировать код
Controller → Service → Repository → Database
REST Controllers handle HTTP requests

Services contain business logic

Repositories handle database access

Exception Handling
The system uses Spring exception handling.
Errors are returned as JSON responses with HTTP status codes.

Example:

json
Копировать код
{
  "status": 404,
  "error": "Car not found"
}
How to Run the Application
Clone the repository

Configure database in application.properties

Run the application:

arduino
Копировать код
mvn spring-boot:run
Application runs on:

arduino
Копировать код
http://localhost:8080
API Testing
API was tested using Postman:

POST /cars

GET /cars

POST /rentals

Error handling verified

Reflection
This project demonstrates how classic design patterns and SOLID principles
can be integrated into a modern Spring Boot REST API.
It improved understanding of clean architecture, layered design, and backend development best practices.