# Database Setup

This guide explains how to set up the MySQL database for the MyToDos application.

## Prerequisites

* MySQL Server 8.0+
* Java JDK
* Apache Tomcat
* MySQL Connector/J

---

## Step 1: Create the Database

```sql
CREATE DATABASE mytodos;
USE mytodos;
```

---

## Step 2: Create the Users Table

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL
);
```

---

## Step 3: Create the Tasks Table

```sql
CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    status ENUM('pending', 'done') DEFAULT 'pending',
    
    CONSTRAINT fk_tasks_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);
```

---

## Database Schema

```text
mytodos
│
├── users
│   ├── id
│   ├── name
│   ├── username
│   ├── email
│   └── password_hash
│
└── tasks
    ├── id
    ├── user_id
    ├── title
    └── status
```

---

## Configure Database Connection

Open:

```text
src/main/java/model/dbConnection.java
```

Update the connection details:

```java
String url = "jdbc:mysql://localhost:3306/mytodos";
String username = "root";
String password = "your_password";
```

---

## Verify the Setup

After creating the tables, run:

```sql
SHOW TABLES;
```

Expected output:

```text
+------------------+
| Tables_in_mytodos|
+------------------+
| users            |
| tasks            |
+------------------+
```

Check the schema:

```sql
DESCRIBE users;
DESCRIBE tasks;
```

---

## Sample Data (Optional)

```sql
INSERT INTO users (name, username, email, password_hash)
VALUES (
    'John Doe',
    'johndoe',
    'john@example.com',
    '$2a$10$examplehashedpassword'
);

INSERT INTO tasks (user_id, title, status)
VALUES
(1, 'Complete Java Project', 'pending'),
(1, 'Push Code to GitHub', 'done');
```

---

## Common Issues

### Access Denied

```text
Access denied for user
```

Verify your MySQL username and password.

### Unknown Database

```text
Unknown database 'mytodos'
```

Create the database using:

```sql
CREATE DATABASE mytodos;
```

### JDBC Driver Error

```text
No suitable driver found
```

Ensure MySQL Connector/J is added to the project's classpath.

---

## Notes

* Passwords are stored as hashed values in the `password_hash` column.
* Each task belongs to a specific user through the `user_id` foreign key.
* Tasks support two statuses:

  * `pending`
  * `done`
* Deleting a user automatically deletes all associated tasks.

```
```
