# Spring Security Authentication and Authorization with JWT Template

## 📌 Introduction
This template is designed to streamline the process of setting up authentication and authorization in a Spring Boot application using Spring Security and JWT (JSON Web Token). It provides a pre-configured setup to save time and effort in implementing secure APIs.

## 🚀 Features
- 🔐 **User Authentication**: Secure login with JWT-based authentication.
- 🎟 **JWT Authorization**: Role-based access control using JWT tokens.
- 🛡 **Spring Security Configuration**: Pre-configured security setup with minimal effort.
- 🔄 **Token Refresh**: Endpoint for refreshing expired JWT tokens.
- 🗄 **User Management**: Example endpoints for user registration and role assignment.
- 📡 **REST API Support**: Fully functional RESTful endpoints for authentication and authorization.

## 🏗 Technologies Used
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Oauth 2.0**
- **Spring Data JPA**
- **H2/PostgreSQL/MySQL (Configurable)**
- **Maven**


## 🛠 Setup Instruction
### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Kaiettt/JWT-Spring-security-template.git
cd JWT-Spring-security-template
```

### 2️⃣ Test the API
Use tools like **Postman** or **cURL** to test the following endpoints:


#### 🔹 Authenticate (Login)
```http
POST /api/v1/auth/login
```
Request Body:
```json
{
    "username" : "kietnak584@gmail.com",
    "password" : "123"
}
```
Response:
```json
{
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJrYWthQGdtYWlsLmNvbSIsImV4cCI6MTc0MTkxMzM0OCwiaWF0IjoxNzQxNjEzMzQ4LCJhdXRob3JpdGllcyI6WyJBRE1JTiJdfQ.uRXCDbyJa4IDSerN5nBwd2WtoRE7Vru3cnnWQHV0rFbkziWET5eH4wDBHgVDxBNaiPvMAckoNbwOiPm-enyAUw",
    "user": {
        "id": 4,
        "userName": "kietnak584@gmail.com",
        "fullName": "kaka",
        "role": "ADMIN"
    }
}
```



## 🔄 Token Refresh
If the token expires, you can refresh it using:
```http
POST /api/v1/auth/refresh
```

## 🛡 Role-Based Access Control
Modify roles and permissions in the database to restrict API access based on user roles.

## 🤝 Contributing
Feel free to submit issues or pull requests to enhance this template.

## 📜 AUTHOR: Nguyen Anh Kiet

---

💡 **Happy coding! Secure your Spring Boot applications effortlessly with this template.**

