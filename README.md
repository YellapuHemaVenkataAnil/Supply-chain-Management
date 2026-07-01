# 📦 Supply Chain Management System

A **Spring Boot-based Supply Chain Management System** designed to streamline supply chain operations by managing products, suppliers, inventory, warehouses, and orders through a secure and scalable backend with a simple HTML frontend.

---

## 🚀 Features

- 🔐 User Login & Authentication
- 📦 Product Management (Add, Update, Delete, View)
- 🏢 Supplier Management
- 📊 Inventory Management
- 🛒 Order Management
- 📈 Dashboard Overview
- 🔍 Search and Filter Records
- 💾 MySQL Database Integration
- 🌐 RESTful APIs
- ⚡ Spring Boot Backend
- 🎨 HTML, CSS & JavaScript Frontend

---

# 🛠 Tech Stack

### Backend
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Maven

### Frontend
- HTML5
- CSS3
- JavaScript

### Database
- MySQL

### Development Tools
- IntelliJ IDEA / Eclipse
- Git & GitHub
- Postman

---

# 📁 Project Structure

```text
Supply-Chain-Management/
│
├── Frontend/
│   ├── index.html
│   └── login.html
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── scm/
│       │           ├── config/
│       │           ├── controller/
│       │           ├── dto/
│       │           ├── model/
│       │           ├── repository/
│       │           ├── service/
│       │           └── SupplyChainApplication.java
│       │
│       └── resources/
│           └── application.properties
│
├── target/
│   └── classes/
│       ├── META-INF/
│       ├── com/scm/
│       └── application.properties
│
├── pom.xml
└── README.md
```

---

# ⚙️ Installation

## 1. Clone the Repository

```bash
git clone https://github.com/yourusername/Supply-Chain-Management.git
```

```bash
cd Supply-Chain-Management
```

---

## 2. Configure Database

Create a MySQL database.

```sql
CREATE DATABASE supply_chain_db;
```

Update **application.properties**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/supply_chain_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 3. Build the Project

```bash
mvn clean install
```

---

## 4. Run the Application

```bash
mvn spring-boot:run
```

Application starts at:

```
http://localhost:8080
```

---

## 5. Open Frontend

Open the files inside the **Frontend** folder in your browser.

```
Frontend/index.html
```

or

```
Frontend/login.html
```

---

# 📂 Modules

### Authentication
- Secure Login
- User Validation

### Product Management
- Add Products
- Edit Products
- Delete Products
- View Products

### Supplier Management
- Register Suppliers
- Update Supplier Details
- Delete Suppliers

### Inventory Management
- Track Stock
- Update Inventory
- Stock Availability

### Order Management
- Create Orders
- View Orders
- Update Order Status

---

# 📡 REST API

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/products` | Get all products |
| POST | `/products` | Add a product |
| PUT | `/products/{id}` | Update product |
| DELETE | `/products/{id}` | Delete product |
| GET | `/suppliers` | Get suppliers |
| POST | `/suppliers` | Add supplier |
| GET | `/orders` | Get orders |

> Replace the endpoints above with the exact controller mappings used in your project if they differ.

---

# 📌 Future Enhancements

- Email Notifications
- Shipment Tracking
- Barcode Integration
- QR Code Support
- Reports & Analytics
- Admin Dashboard
- JWT Authentication
- Role-Based Access Control
- Docker Deployment
- Cloud Deployment

---

# 🤝 Contributing

1. Fork the repository.
2. Create a feature branch.

```bash
git checkout -b feature/new-feature
```

3. Commit your changes.

```bash
git commit -m "Add new feature"
```

4. Push the branch.

```bash
git push origin feature/new-feature
```

5. Open a Pull Request.

---

# 📄 License

This project is licensed under the MIT License.

---

# 👨‍💻 Author

**Anil Yellapu**

- GitHub: https://github.com/YellapuHemaVenkataAnil
- LinkedIn: https://www.linkedin.com/in/anilyellapu/

---

## ⭐ Show Your Support

If you found this project useful, consider giving it a **⭐ Star** on GitHub!
