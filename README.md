<div align="center">

<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 900 160" width="100%">
  <defs>
    <linearGradient id="bg" x1="0%" y1="0%" x2="100%" y2="100%">
      <stop offset="0%" style="stop-color:#0f0c29"/>
      <stop offset="50%" style="stop-color:#302b63"/>
      <stop offset="100%" style="stop-color:#24243e"/>
    </linearGradient>
  </defs>

  <!-- Background -->
  <rect width="900" height="160" fill="url(#bg)" rx="0"/>

  <!-- Wave bottom -->
  <path d="M0,120 C150,160 300,90 450,120 C600,150 750,90 900,110 L900,160 L0,160 Z" fill="#1a1730" opacity="0.6"/>
  <path d="M0,135 C200,100 400,155 600,130 C750,110 850,140 900,130 L900,160 L0,160 Z" fill="#0f0c29" opacity="0.8"/>

  <!-- Coin icon -->
  <circle cx="60" cy="68" r="22" fill="none" stroke="#a78bfa" stroke-width="2" opacity="0.8"/>
  <text x="60" y="75" font-family="Arial" font-size="22" fill="#a78bfa" text-anchor="middle">💰</text>

  <!-- Title -->
  <text x="95" y="60" font-family="Arial, sans-serif" font-size="36" font-weight="700" fill="#ffffff" letter-spacing="1">Finance Backend</text>

  <!-- Subtitle -->
  <text x="95" y="90" font-family="Arial, sans-serif" font-size="15" fill="#a78bfa" letter-spacing="0.5">Data Processing &amp; Access Control API</text>

  <!-- Decorative dots -->
  <circle cx="820" cy="40" r="3" fill="#a78bfa" opacity="0.5"/>
  <circle cx="840" cy="25" r="2" fill="#7c3aed" opacity="0.4"/>
  <circle cx="860" cy="50" r="4" fill="#a78bfa" opacity="0.3"/>
  <circle cx="880" cy="30" r="2" fill="#c4b5fd" opacity="0.5"/>
  <circle cx="800" cy="60" r="2" fill="#7c3aed" opacity="0.3"/>
</svg>

<br/>

[![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot_3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![H2](https://img.shields.io/badge/H2_Database-0052CC?style=for-the-badge&logo=h2&logoColor=white)](https://www.h2database.com)
[![Swagger](https://img.shields.io/badge/Swagger_OpenAPI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)](https://swagger.io)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)](https://maven.apache.org)

<br/>

*A clean, layered Spring Boot backend for managing financial records, user roles, and dashboard analytics.*

</div>

---

## 🚀 Tech Stack

| | Technology | Role |
|---|---|---|
| Language | Java 17 | Modern syntax, records |
| Framework | Spring Boot 3.x | DI, embedded Tomcat |
| ORM | Spring Data JPA + Hibernate | Entity lifecycle, queries |
| Database | H2 In-Memory | Zero-config, instant startup |
| Docs | Swagger / OpenAPI 3.0 | Live API explorer |
| Build | Maven | Dependency management |

---

## 🏗️ System Architecture

```
Client (Swagger / Postman)
        │ HTTP
        ▼
  Controller Layer      ← Routes requests, validates input
        │ DTOs
        ▼
  Service Layer         ← Business logic + RoleValidator (ADMIN / ANALYST / VIEWER)
        │ JPA
        ▼
  Repository Layer      ← DB queries (findByType, findByCategory, sumByType…)
        │
        ▼
  H2 Database           ← USERS ──FK──► FINANCIAL_RECORDS
```

---

## 🧱 Project Structure

```
com.zorvyn.finance/
├── controller/     ← REST endpoints
├── service/        ← Business logic + role checks
├── repository/     ← JPA queries
├── model/          ← Entities + Role enum
├── dto/            ← Request / Response objects
├── exception/      ← Global error handler
├── security/       ← RoleValidator
└── config/         ← Swagger, JPA config
```

---

## ✨ Features

### 🔐 Role-Based Access Control

| Role | Create | Read | Delete | Analytics |
|------|:------:|:----:|:------:|:---------:|
| `ADMIN` | ✅ | ✅ | ✅ | ✅ |
| `ANALYST` | ❌ | ✅ | ❌ | ✅ |
| `VIEWER` | ❌ | ✅ | ❌ | ❌ |

### 💸 Financial Records
Full CRUD — Amount · Type (`INCOME` / `EXPENSE`) · Category · Date · Notes

### 📊 Dashboard
`GET /api/dashboard/summary` → Total income · Total expense · Net balance

### 🔍 Filtering
Filter by type → `GET /api/records?type=INCOME`  
Filter by category → `GET /api/records?category=Salary`

### ✅ Validation & Error Handling
`@Valid` · `@NotNull` · `@NotBlank` + global `@RestControllerAdvice` for consistent JSON errors

---

## ⚙️ How to Run

**Prerequisites:** Java 17 · Maven 3.6+

```bash
git clone https://github.com/Manjunath-G-K/finance-backend.git
cd finance-backend
mvn clean install
mvn spring-boot:run
```

Swagger UI → `http://localhost:8080/swagger-ui.html`

---

## 🧪 Sample API Calls

<details>
<summary><b>👤 Create User — POST /api/users</b></summary>

```json
// Request
{
  "name": "Manjunath G K",
  "email": "manju@example.com",
  "role": "ADMIN",
  "status": "ACTIVE"
}

// Response 201
{
  "id": 1,
  "name": "Manjunath G K",
  "role": "ADMIN",
  "status": "ACTIVE"
}
```
</details>

<details>
<summary><b>💸 Create Record — POST /api/records</b></summary>

```json
// Request
{
  "amount": 5000.00,
  "type": "INCOME",
  "category": "Salary",
  "date": "2026-04-04",
  "note": "April salary"
}

// Response 201
{
  "id": 1,
  "amount": 5000.00,
  "type": "INCOME",
  "category": "Salary"
}
```
</details>

<details>
<summary><b>📊 Dashboard Summary — GET /api/dashboard/summary</b></summary>

```json
// Response 200
{
  "totalIncome": 15000.00,
  "totalExpense": 3500.00,
  "netBalance": 11500.00
}
```
</details>

---

## 🧠 Technical Decisions

**Layered architecture** — each layer has one job. Controllers handle HTTP, services own logic, repositories own data. Easy to test and modify independently.

**H2 in-memory DB** — zero setup for evaluation. Swapping to MySQL/PostgreSQL only requires `application.properties` changes — no code changes.

**Custom role validation** — lightweight service-layer checks, proportional to scope. Spring Security is the defined next step, not an oversight.

**DTOs over entity exposure** — decouples API contract from JPA entities. Prevents over-posting, keeps responses clean.

---

## ⚖️ Trade-offs

| Decision | Why | Production Path |
|----------|-----|----------------|
| No JWT auth | Scope focused on business logic | Spring Security + JWT |
| No pagination | Simple evaluation dataset | `Pageable` + `Page<T>` |
| H2 in-memory | Zero setup, resets on restart | MySQL / PostgreSQL + Flyway |
| No tests yet | Time-scoped build | JUnit 5 + Mockito |

---

## 🚀 Future Roadmap

- [ ] JWT authentication + Spring Security
- [ ] Pagination and sorting on all list endpoints
- [ ] Date-range and amount-range filtering
- [ ] Category analytics with trend breakdown
- [ ] MySQL / PostgreSQL migration
- [ ] Unit and integration test coverage
- [ ] Docker + `docker-compose.yml`
- [ ] GitHub Actions CI/CD

---

## 🙌 Final Note

Built to be readable first, extensible second. Every decision here has a documented reason and a clear upgrade path for production.

---

<div align="center">

**Manjunath G K**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/manjunath-g-k)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Manjunath-G-K)

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:0f0c29,50:302b63,100:24243e&height=100&section=footer" width="100%"/>

</div>
