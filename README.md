# University Department Management System

## Overview

A Spring Boot-based Java application to manage university departments and lectors. Users interact with the system via a console interface. Data is stored in a PostgreSQL database.

## Features

- **Departments & Lectors**: Manage departments and lectors with degrees (assistant, associate professor, professor).
- **Multiple Department Assignments**: Lectors can belong to multiple departments.
- **Statistics & Search**: Retrieve department statistics, average salary, employee count, and global search for lectors.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/ospodaryk/University.git
   cd University
   ```

2. **Configure Database**:
   Ensure PostgreSQL is running and create a database called `university_db`. 
   Populate your username and your password in application properties.
   The application connects using the following JDBC URL:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/university_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **Run the Application**:
   Simply run the Spring Boot app using:
   ```bash
   mvn spring-boot:run
   ```

## Commands

1. **Who is head of department {department_name}?**
   ```
   Who is head of department Computer Science?
   ```
   **Answer**: `Head of Computer Science department is John Snow`

2. **Show {department_name} statistics**
   ```
   Show Mathematics statistics
   ```
   **Answer**:  
   `Assistants - 5`  
   `Associate professors - 3`  
   `Professors - 7`

3. **Show the average salary for {department_name}**
   ```
   Show the average salary for Physics
   ```
   **Answer**: `The average salary of Physics is 45000.00`

4. **Show count of employees for {department_name}**
   ```
   Show count of employees for Chemistry
   ```
   **Answer**: `The employee count for Chemistry is 12`

5. **Global search by {template}**
   ```
   Global search by van
   ```
   **Answer**: `Ivan Petrenko, Petro Ivanov`
