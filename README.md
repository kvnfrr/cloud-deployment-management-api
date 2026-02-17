# Cloud Deployment Management API

A production-style backend service designed to manage application deployments across multiple environments (DEV, STAGING, PROD).

This project models real-world DevOps workflows by tracking services, versioned deployments, and deployment state transitions using a clean, layered Spring Boot architecture.

---

## Tech Stack

- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- PostgreSQL  
- Gradle  

---

## System Overview

The system models three primary domain entities:

### Service
Represents an application that can be deployed.

### Environment
Represents deployment targets (e.g., DEV, STAGING, PROD).

### Deployment
Represents a specific deployment of a service version to an environment.

Each deployment maintains a strict status lifecycle:

- `PENDING`
- `DEPLOYED`
- `FAILED`
- `ROLLED_BACK`

---

## Architecture

The application follows a layered architecture:

- **Controller Layer** – REST endpoints  
- **Service Layer** – Business logic & deployment state transitions  
- **Repository Layer** – JPA persistence  
- **PostgreSQL** – Relational database  

Designed with:

- Clean entity modeling  
- DTO separation  
- Global exception handling  
- Input validation  
- Pagination support  
- Structured logging  

---

## Local Setup

### Ensure PostgreSQL is running

Create the database if it does not exist:

```sql
CREATE DATABASE deployment_db;
