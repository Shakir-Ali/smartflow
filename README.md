# 🚀 SmartFlow – Event-Driven Multi-Tenant SaaS Platform

SmartFlow is a production-style microservices-based SaaS backend built using **Spring Boot, PostgreSQL, JWT, and Docker (planned)**.

This project demonstrates:

- 🔐 Secure authentication with JWT
- 🏗 Clean layered architecture
- 📦 Microservices-ready structure (monorepo)
- 🧩 Multi-tenant design foundation
- 🛡 Password hashing with BCrypt
- 🧠 Global exception handling
- 📘 Standardized API responses

---

## 🏛️ Architecture Overview

SmartFlow is designed as a microservices-based system:
smartflow/
├── auth-service/
├── order-service/ (planned)
├── inventory-service/ (planned)
├── notification-service/ (planned)
├── analytics-service/ (planned)
└── docker-compose.yml (planned)


Currently implemented:

### ✅ auth-service
Handles:
- User registration
- Secure password hashing (BCrypt)
- Login authentication
- JWT token generation

---

## 🛠 Tech Stack

- Java 17
- Spring Boot 3+
- Spring Security
- Spring Data JPA (Hibernate)
- PostgreSQL 16
- JWT (jjwt)
- Maven
- Git (Monorepo strategy)

---

## 🔐 Authentication Flow

1. User registers via `/api/auth/register`
2. Password is hashed using BCrypt
3. User logs in via `/api/auth/login`
4. Server generates signed JWT
5. Token will be used to secure other microservices (next phase)

---

## 📌 API Endpoints (Auth Service)

### 🔹 Register

POST /api/auth/register

Request:
{
  "name": "Shakir",
  "email": "shakir@test.com",
  "password": "123456"
}

### 🔹 Login

POST /api/auth/login

Response:
{
  "success": true,
  "message": "Login successful",
  "data": "JWT_TOKEN"
}

