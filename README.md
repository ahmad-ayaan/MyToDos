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
## ⚙️ Setup Instructions

### 1️⃣ Clone Repository
git clone https://github.com/ahmad-ayaan/MyToDos.git

2️⃣ Import into Eclipse
Open Eclipse
File → Import → Existing Dynamic Web Project
Select the project folder

3️⃣ Configure Server
Add Apache Tomcat in Eclipse
Deploy project to server

4️⃣ Database Setup
Create MySQL database (example: todos_db)
Configure connection in dbConnection.java
Update username/password as per your system

5️⃣ Run the Project
Right click project → Run on Server

Open browser:

http://localhost:8080/MyToDos/
```bash
git clone https://github.com/ahmad-ayaan/MyToDos.git
