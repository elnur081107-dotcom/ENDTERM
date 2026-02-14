A. Project Overview

This project is a Spring Boot RESTful API for a Car Rental System.
It demonstrates:

Layered architecture (Controller → Service → Repository → Database)

SOLID principles

Advanced OOP concepts

Design Patterns (Singleton, Factory, Builder)

Component Principles (REP, CCP, CRP)

Database integration using JPA

Global exception handling

In-memory caching (Bonus Task)

The system allows management of cars and rentals through REST endpoints.

B. REST API Documentation
Base URL
http://localhost:8080

1. Car Endpoints
   🔹 Get All Cars
   GET /cars


Response:

[
{
"id": 1,
"name": "Tesla Model 3",
"pricePerDay": 120.0,
"available": true
}
]

🔹 Get Car By ID
GET /cars/{id}

🔹 Create Car
POST /cars


Request:

{
"type": "ELECTRIC",
"name": "Tesla Model S",
"pricePerDay": 150.0,
"batteryCapacity": 100
}

🔹 Update Car
PUT /cars/{id}


Request:

{
"name": "Tesla Model S Updated",
"pricePerDay": 170.0,
"batteryCapacity": 110
}

🔹 Delete Car
DELETE /cars/{id}

🔹 Clear Cache (Bonus)
DELETE /cars/cache

C. Design Patterns
1. Singleton Pattern

Used in:

CarCache

Purpose:

Ensure only one cache instance exists in the entire application.

Implementation:

Private constructor

Static instance

Public synchronized getInstance() method

Reason:
The cache must be shared across the application and must not be recreated per request.

2. Builder Pattern

Used in:

CarBuilder

Purpose:

Construct complex Car objects step-by-step.

Support optional parameters such as battery capacity.

Advantages:

Improves readability

Avoids telescoping constructors

Supports fluent API

Example:

CarBuilder builder = new CarBuilder(type)
.name(name)
.pricePerDay(price)
.available(true)
.batteryCapacity(capacity);

3. Factory Pattern

Used to create different types of cars based on type.

Example:

ElectricCar

StandardCar

Purpose:

Return base type Car

Allow easy extension without modifying existing logic

Supports Open/Closed Principle.

D. Component Principles
REP — Reuse/Release Equivalence Principle

Reusable modules:

repository

service

utils

patterns

Each module has a clear responsibility and can evolve independently.

CCP — Common Closure Principle

Classes that change together are grouped together:

CarController

CarService

CarRepository

Car-related logic is grouped logically.

CRP — Common Reuse Principle

Modules are not forced to depend on unnecessary classes.

For example:

Controller does not depend on cache implementation details.

Repository does not depend on business logic.

E. SOLID & OOP Summary
Single Responsibility Principle

Controller → handles HTTP requests

Service → business logic

Repository → database operations

Open/Closed Principle

New car types can be added without modifying existing service logic.

Liskov Substitution Principle

Subclasses of Car can be used wherever Car is expected.

Interface Segregation Principle

Repository interfaces are focused and minimal.

Dependency Inversion Principle

Service depends on abstraction (CarRepository), not concrete implementation.

F. Database Schema
cars

id (PK)

name

price_per_day

available

type

battery_capacity

rentals

id (PK)

car_id (FK → cars.id)

start_date

end_date

Foreign key constraint ensures referential integrity.

Deletion of a car is restricted if rentals reference it.

G. System Architecture
Controller → Service → Repository → Database
↓
Cache (Singleton)


The caching layer is implemented in the service layer without breaking architecture.

Bonus Task — Caching Layer
Implementation

A simple in-memory cache was implemented using:

ConcurrentHashMap

Singleton pattern

Service-layer integration

Cached Method
getAll()

How It Works

First request → data fetched from database and stored in cache.

Subsequent requests → data returned from cache.

Cache is invalidated after:

create

update

delete

Benefits

Reduces database calls

Improves performance

Maintains consistency via invalidation

Thread Safety

ConcurrentHashMap is used to ensure safe access in a multi-threaded Spring Boot environment.

H. Instructions to Run the Application

Clone repository

Configure database in application.properties

Run:

mvn spring-boot:run


or run Application.java from IDE.

Use Postman to test endpoints.

I. Reflection

This project demonstrates:

Real-world backend architecture

Practical use of design patterns

Database integrity management

RESTful API design

Performance optimization via caching

Application of SOLID principles in a Spring Boot system

The integration of patterns, component principles, caching, and REST architecture resulted in a clean, maintainable, and scalable backend system.