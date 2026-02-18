Cloud Deployment Management API

A production-style backend service for managing application deployments across multiple environments (DEV, STAGING, PROD).

This project models real-world DevOps workflows by tracking services, versioned deployments, and deployment states using a clean Spring Boot architecture backed by PostgreSQL.

Tech Stack

Java 17

Spring Boot 3

Spring Data JPA (Hibernate)

PostgreSQL

Gradle

Postman (API testing)

Domain Model
Service

Represents an application that can be deployed.

Environment

Represents deployment targets (DEV, STAGING, PROD).

Deployment

Represents a specific deployment of a service version to an environment.

Each deployment contains:

UUID identifier

Version

Status (default: PENDING)

Created timestamp

Associated Service

Associated Environment

Current Features

Create a deployment via REST API

Automatic creation of Service and Environment if not found

UUID-based identifiers

Relational data modeling with foreign key constraints

PostgreSQL persistence

Verified via Postman

API Example
Create Deployment

POST /deployments

Request body (JSON):

{
"serviceName": "payment-service",
"environmentName": "prod",
"version": "1.0.0"
}

Response (example):

{
"id": "uuid",
"version": "1.0.0",
"status": "PENDING",
"createdAt": "timestamp",
"service": { ... },
"environment": { ... }
}

Architecture

The application follows a layered architecture:

Controller Layer – REST endpoints

Service Layer – Business logic

Repository Layer – JPA persistence

PostgreSQL – Relational storage

The system uses explicit entity relationships and transactional persistence to maintain data integrity.

Local Setup
1. Create Database

CREATE DATABASE deployment_db;

2. Configure application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/deployment_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3. Run the Application

./gradlew bootRun

Server runs at:

http://localhost:8080

Roadmap

Retrieve deployments (GET endpoints)

Update deployment status lifecycle

Add validation and error handling

Pagination support

Dockerization

CI/CD integration