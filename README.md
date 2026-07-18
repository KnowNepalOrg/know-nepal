# 🇳🇵 Know Nepal

> **An open-source digital platform and API ecosystem dedicated to preserving, organizing, and sharing Nepal's geography, history, culture, heritage, tourism, and public information.**

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Spring_Boot-4.0.7-brightgreen?style=for-the-badge" />
  <img src="https://img.shields.io/badge/PostgreSQL-18-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Maven-3.9+-red?style=for-the-badge" />
  <img src="https://img.shields.io/badge/License-MIT-success?style=for-the-badge" />
</p>

---

# 📖 Overview

**Know Nepal** is a comprehensive open-source platform that aims to become the digital knowledge base of Nepal.

The project provides a collection of modular REST APIs covering various aspects of Nepal including:

- 🗺️ Geography
- 🏛️ Administrative Divisions
- 📜 History
- 🎭 Culture
- 🛕 Heritage
- 🧳 Tourism
- 🌄 Natural Resources
- 📚 Public Information

The project follows an **API-first** approach where each domain is developed as an independent backend module.

---

# 🚀 Project Vision

Our goal is to build a centralized, open, and reliable data platform that developers, researchers, students, government agencies, and the public can use to access authentic information about Nepal.

---

# 🏗️ Project Architecture

```
know-nepal/
│
├── know-nepal-geography/
│
├── know-nepal-history/          (Planned)
│
├── know-nepal-culture/          (Planned)
│
├── know-nepal-tourism/          (Planned)
│
├── know-nepal-heritage/         (Planned)
│
└── more modules...
```

Each module is an independent Spring Boot application with its own lifecycle.

At the current stage, **there is no parent Maven project (`pom.xml`) at the repository root.**

---

# 📌 Current Development Status

> 🚧 **Project is under active development**

### Current Sprint

Development is currently focused exclusively on:

```
know-nepal-geography
```

Other modules will be introduced in future development phases.

---

# 🗺️ Geography Module

The **know-nepal-geography** module serves as the central geographic data service of Nepal.

It contains structured administrative and geographic information for the country.

## Features

### Province Information

- Complete information of all **7 Provinces**
- Administrative metadata
- Historical details

### District Information

- Complete information for all **77 Districts**
- Geographic metadata
- Administrative hierarchy

### Local Government Information

Supports all local administrative units:

- 🏘️ Rural Municipality (Gaunpalika)
- 🏙️ Municipality (Nagarpalika)
- 🌆 Sub-Metropolitan City (Upa-Mahanagarpalika)
- 🌇 Metropolitan City (Mahanagarpalika)

---

# 🛠 Technology Stack

## Backend

| Technology | Version |
|------------|---------|
| Java | 21 |
| Spring Boot | 4.0.7 |
| Maven | 3.9+ |
| PostgreSQL | 18 |
| OpenAPI | Latest |
| Swagger UI | Included |
| Postman | API Testing |

---

## Frontend (Planned)

| Technology | Status |
|------------|--------|
| Next.js | Planned |
| TypeScript | Planned |
| Node.js | Planned |

> The repository currently functions as a backend-only API project.

---

# 📋 Prerequisites

Before running the project, ensure you have installed:

- Java Development Kit (JDK) 21
- Apache Maven 3.9+
- PostgreSQL 18
- Git
- Postman (Optional)

---

# 📦 Installation

## 1. Clone the Repository

```bash
git clone https://github.com/KnowNepalOrg/know-nepal.git
```

Navigate into the project.

```bash
cd know-nepal
```

Navigate to the geography module.

```bash
cd know-nepal-geography
```

---

## 2. Configure PostgreSQL

Create a PostgreSQL database.

Example:

```sql
CREATE DATABASE know_nepal_geography;
```

Update your database configuration inside:

```
src/main/resources/application.yml
```

or

```
application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/know_nepal_geography
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

---

## 3. Build the Project

Using Maven:

```bash
mvn clean install
```

---

## 4. Run the Application

```bash
mvn spring-boot:run
```

Or

```bash
java -jar target/know-nepal-geography.jar
```

---

# 📖 API Documentation

After starting the application:

### Swagger UI

```
http://localhost:8080/swagger-ui.html
```

or

```
http://localhost:8080/swagger-ui/index.html
```

### OpenAPI JSON

```
http://localhost:8080/v3/api-docs
```

---

# 🧪 API Testing

API endpoints can be tested using:

- Swagger UI
- Postman
- Insomnia
- curl

Example:

```bash
curl http://localhost:8080/api/v1/provinces
```

---

# 📂 Repository Structure

```
know-nepal/
│
├── know-nepal-geography/
│   ├── src/
│   ├── pom.xml
│   └── README.md
│
└── README.md
```

---

# 🎯 Roadmap

Upcoming modules include:

- ✅ Geography
- ⏳ History
- ⏳ Culture
- ⏳ Heritage
- ⏳ Tourism
- ⏳ Economy
- ⏳ Education
- ⏳ Public Services
- ⏳ Demographics
- ⏳ National Parks
- ⏳ Rivers
- ⏳ Mountains
- ⏳ Religious Sites
- ⏳ Festivals

---

# 🤝 Contributing

Contributions are welcome!

If you'd like to contribute:

1. Fork the repository.
2. Create a new feature branch.

```bash
git checkout -b feature/your-feature-name
```

3. Commit your changes.

```bash
git commit -m "Add your feature"
```

4. Push to GitHub.

```bash
git push origin feature/your-feature-name
```

5. Open a Pull Request.

Please ensure your code follows the project's coding standards and includes appropriate documentation.

---

# 📜 License

This project is licensed under the **MIT License**.

See the `LICENSE` file for more information.

---

# 👨‍💻 Maintainers

**Know Nepal Organization**

GitHub: https://github.com/KnowNepalOrg

---

# ⭐ Support the Project

If you find this project useful, please consider:

- ⭐ Starring the repository
- 🍴 Forking the project
- 🐛 Reporting issues
- 💡 Suggesting new features
- 🤝 Contributing to development

Together, let's build the largest open-source knowledge platform dedicated to Nepal.
