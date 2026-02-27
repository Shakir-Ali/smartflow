# 🚀 SmartFlow — Event-Driven Microservices Platform

SmartFlow is a production-style, containerized microservices system built using:

- Spring Boot (Multi-Module Maven)
- Spring Security + JWT
- Apache Kafka (Event-Driven Architecture)
- PostgreSQL (Database per service)
- API Gateway
- Docker & Docker Compose
- GitHub Actions CI/CD

This project demonstrates how to design, build, containerize, and automate a distributed system end-to-end.

---

# 🏗 Architecture Overview

```
Client
   ↓
API Gateway (8080)
   ↓
---------------------------------------
Auth Service (JWT, Security)  → auth-db
Order Service (CRUD)          → order-db
   ↓
Kafka (Event Broker)
   ↓
Notification Service (Consumer)
---------------------------------------
```

### Key Architectural Principles

- Microservice isolation
- Database-per-service pattern
- Event-driven communication
- Stateless JWT authentication
- Containerized infrastructure
- CI-based Docker validation
- Semantic version tagging

---

# 📦 Services

## 🔐 Auth Service
- User registration
- JWT login
- Role-based authorization
- Tenant-aware structure

## 📦 Order Service
- Order CRUD operations
- Pagination
- Soft delete implementation
- Auditing fields
- Publishes `OrderCreatedEvent` to Kafka

## 📩 Notification Service
- Kafka consumer
- Listens to `order-created` topic
- Processes order events asynchronously

## 🌐 API Gateway
- Single entry point
- Route-based forwarding
- Internal service isolation

---

# 🐳 Running the Project

## 1️⃣ Clone Repository

```bash
git clone https://github.com/<your-username>/smartflow.git
cd smartflow
```

---

## 2️⃣ Start Entire System

```bash
docker compose up --build
```

This will start:

- Auth Database
- Order Database
- Kafka + Zookeeper
- Auth Service
- Order Service
- Notification Service
- API Gateway

---

## 3️⃣ Access the System

API Gateway runs on:

```
http://localhost:8080
```

---

# 🔑 Sample API Usage

### 🔐 Login

```
POST /api/auth/login
```

Example Body:

```json
{
  "email": "test@example.com",
  "password": "password123"
}
```

---

### 📦 Create Order (Requires JWT)

```
POST /api/orders
Authorization: Bearer <your-token>
```

---

# 🧪 CI/CD Pipeline

The project uses **GitHub Actions** for automation.

Pipeline triggers on:

- Push to `main`
- Pull requests
- Version tags (`v1.0.0`, `v1.1.0`, etc.)

### CI Pipeline Performs:

1. Multi-module Maven build
2. Docker image build validation
3. Version-based image tagging

---

# 🏷 Versioning Strategy

SmartFlow follows **Semantic Versioning**:

```
v1.0.0
v1.1.0
v2.0.0
```

To create a release:

```bash
git tag v1.0.0
git push origin v1.0.0
```

This triggers a release build in CI.

Docker images are tagged accordingly:

```
smartflow-auth-service:v1.0.0
smartflow-order-service:v1.0.0
```

---

# 📁 Project Structure

```
smartflow/
│
├── auth-service/
├── order-service/
├── notification-service/
├── gateway-service/
│
├── docker-compose.yml
├── pom.xml (parent)
└── .github/workflows/ci.yml
```

---

# 🛠 Tech Stack

| Layer | Technology |
|-------|------------|
| Backend | Spring Boot 3 |
| Security | Spring Security + JWT |
| Messaging | Apache Kafka |
| Database | PostgreSQL |
| Containerization | Docker |
| Orchestration | Docker Compose |
| CI/CD | GitHub Actions |
| Build Tool | Maven (Multi-module) |

---

# 🚀 Future Enhancements (Possibility)

- Push Docker images to Docker Hub automatically
- Add H2 test profile for CI
- Add health checks in docker-compose
- Add observability (Prometheus + Actuator)
- Implement DLQ & retry strategy for Kafka
- Deploy to cloud (AWS / GCP)

---

# 👨‍💻 Author

**Shakir Ali**  
Backend Engineer | Java | Spring Boot | Microservices | DevOps Enthusiast

---

> This project was built as an end-to-end demonstration of microservices architecture combined with practical DevOps automation.