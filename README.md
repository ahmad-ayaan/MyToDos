# 📝 MyToDos - Java Web Application

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JSP](https://img.shields.io/badge/JSP-Java%20Server%20Pages-blue?style=for-the-badge)
![Servlets](https://img.shields.io/badge/Servlets-Web%20Backend-orange?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)
![Tomcat](https://img.shields.io/badge/Apache%20Tomcat-Server-red?style=for-the-badge&logo=apachetomcat)

---

## 🚀 Overview

**MyToDos** is a full-stack Java web application that helps users manage their daily tasks efficiently.  
It is built using **Servlets, JSP, and JDBC** following the **MVC architecture pattern**.

This project demonstrates backend development skills including:
- Authentication system
- CRUD operations
- Database integration
- MVC design pattern

---

## ✨ Features

- 🔐 User Registration & Login system
- ➕ Add new tasks
- 📋 View all tasks
- 🗑️ Delete tasks
- 💾 Persistent storage using MySQL
- 🌐 Dynamic web pages using JSP

---

## 🛠️ Tech Stack

| Layer        | Technology |
|--------------|------------|
| Frontend     | HTML, CSS, JSP |
| Backend      | Java Servlets |
| Database     | MySQL |
| Server       | Apache Tomcat |
| Architecture | MVC Pattern |

---

## 📁 Project Structure
```text
MyToDos/
│
├── src/main/java/
│ ├── controller/
│ │ ├── LoginController.java
│ │ ├── Logout.java
│ │ ├── RegisterationController.java
│ │ └── ToDoServlet.java
│ │
│ └── model/
│ ├── ToDo.java
│ ├── ToDos.java
│ └── dbConnection.java
│
├── src/main/webapp/
│ ├── WEB-INF/
│ ├── META-INF/
│ ├── index.html
│ ├── login.html
│ ├── Registeration.html
│ └── tasks.jsp
│
├── .gitignore
└── README.md
```

## 📸 Screenshots

### 🏠 Home Page

![Home Page](Screenshots/HomePage.png)

### 📝 Registration Page

![Registration Page](Screenshots/RegisterationPage.png)

### 🔐 Login Page

![Login Page](Screenshots/LoginPage.png)


🔧 Installation & Setup
1. Clone the Repository
git clone https://github.com/ahmad-ayaan/MyToDos.git
2. Open in IDE

Import the project into:

Eclipse IDE
IntelliJ IDEA
NetBeans

3. Configure Database

Install MySQL
Create the database
Update JDBC credentials
For detailed database configuration instructions, see:

[DATABASE_SETUP.md](DATABASE_SETUP.md)

5. Deploy on Apache Tomcat

Add the project to Tomcat and start the server.

5. Run the Application

Open your browser and navigate to:

http://localhost:8080/MyToDos
🎯 Learning Outcomes

This project helped me gain practical experience with:

Java Servlet Development
JSP Pages
JDBC Connectivity
MySQL Integration
MVC Architecture
Session Management
Authentication & Authorization
CRUD Operations
Web Application Development
🔮 Future Improvements
Edit / Update Tasks
Password Hashing using BCrypt
Task Categories
Due Dates and Reminders
Responsive UI Design
Search and Filter Tasks
REST API Integration
Docker Deployment
🤝 Contributing

Contributions, suggestions, and improvements are welcome.

Fork the repository
Create a feature branch
Commit your changes
Push to your branch
Open a Pull Request
📄 License

This project is open source and available under the MIT License.

👨‍💻 Author

Ayaan Ahmad

GitHub: https://github.com/ahmad-ayaan

If you found this project useful, consider giving it a ⭐ on GitHub.
```bash
git clone https://github.com/ahmad-ayaan/MyToDos.git
