# 📘 User Registration API – Backend Project

This is a backend RESTful API developed for a university project at **Estácio University**. The API manages basic user data, allowing for **Create, Read, Update, and Delete (CRUD)** operations.

Developed with **Java**, **Spring Boot**, and **H2 Database**, this project is intended for educational purposes and demonstrates core backend development skills.

---

## 🚀 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Lombok
- Maven

cadastro_usuarioAPI/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com.cadastro.usuario/ # Main package
│ │ └── resources/
│ │ ├── application.properties # Environment configuration
│ │ └── static/ / templates/ # (Optional: Not used here)
├── .gitignore
├── pom.xml
└── README.md

## ⚙️ Features

- ✅ Register new users
- ✅ List all users
- ✅ Update user details
- ✅ Delete users by ID
- ✅ In-memory database with **H2** and web console access
- ✅ DTOs and validation handling
- ✅ Environment variables for DB config via `.env`

---

## 🧪 API Endpoints

| Method | Endpoint        | Description          |
|--------|-----------------|----------------------|
| GET    | `/usuarios`     | List all users       |
| POST   | `/usuarios`     | Create a new user    |
| GET    | `/usuarios/{id}`| Get user by ID       |
| PUT    | `/usuarios/{id}`| Update user by ID    |
| DELETE | `/usuarios/{id}`| Delete user by ID    |
