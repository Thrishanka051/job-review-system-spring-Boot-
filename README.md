# job-review-system-spring-Boot-
backend only

# Job Review System (Backend)

## Project Overview
The **Job Review System** is a backend application that provides functionality to manage jobs, companies, and reviews. It establishes relationships between these entities, allowing users to associate jobs with companies and add reviews for specific jobs. This system is built using Spring Boot and follows a modular design for scalability and maintainability.

### Key Features
- **Companies**: Manage company information.
- **Jobs**: Manage job postings associated with companies.
- **Reviews**: Add and manage reviews for specific jobs.

---

## Project Structure
The project is organized into three main packages, each responsible for specific functionality:

### 1. `job`
- **Purpose**: Handles job-related operations.
- **Contains**:
  - `controller`: Handles API endpoints for job management.
  - `service`: Business logic for jobs.
  - `repository`: Data access layer for jobs.
  - `entity`: Defines the `Job` entity that maps to the database.

### 2. `company`
- **Purpose**: Manages company-related data.
- **Contains**:
  - `controller`: Handles API endpoints for company management.
  - `service`: Business logic for companies.
  - `repository`: Data access layer for companies.
  - `entity`: Defines the `Company` entity that maps to the database.

### 3. `review`
- **Purpose**: Manages reviews for jobs.
- **Contains**:
  - `controller`: Handles API endpoints for review management.
  - `service`: Business logic for reviews.
  - `repository`: Data access layer for reviews.
  - `entity`: Defines the `Review` entity that maps to the database.

---

## Relationships Between Packages
- A **Company** can have multiple **Jobs**.
- A **Job** can have multiple **Reviews**.
- This creates the following hierarchy:
  - **Company** ➔ **Job** ➔ **Review**

---

## Technologies Used
- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **JPA/Hibernate**: For database interaction.
- **PostgreSQL**: For storing data.

---

## How to Run the Project
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Thrishanka051/job-review-system-spring-Boot-
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd job-review-system
   ```

3. **Build the Project**:
   ```bash
   ./mvnw clean install
   ```

4. **Run the Application**:
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Access API Endpoints**:
   - Base URL: `http://localhost:8080`

---


## Future Enhancements
- Add user authentication and authorization.
- Implement a frontend for user interaction.
- Enhance API documentation using Swagger.

---



