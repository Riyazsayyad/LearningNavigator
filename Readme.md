Great! Now that we have the entity classes, we can proceed with creating the README file. Let's structure it as follows:

---

# Learning Navigator

Learning Navigator is a RESTful API service developed using Spring Boot to manage the exam enrollment process for a Learning Management System (LMS). It provides endpoints for CRUD operations on Students, Subjects, and Exams, along with additional features like exam registration and an Easter Egg feature.

## Table of Contents

1. [Endpoints](#endpoints)
2. [Entity Classes](#entity-classes)
3. [Controllers](#controllers)
4. [Service Layer](#service-layer)
5. [Repository Layer](#repository-layer)
6. [Additional Features](#additional-features)
7. [Configuration](#configuration)
8. [Build and Run](#build-and-run)
9. [Contributing](#contributing)
10. [License](#license)

## Endpoints

The following endpoints are available:

- `GET /students`: Retrieves all students.
- `GET /students/{studentId}`: Retrieves a student by ID.
- `POST /students`: Creates a new student.
- `PUT /students/{studentId}`: Updates an existing student.
- `DELETE /students/{studentId}`: Deletes a student.
- `POST /students/{studentId}/register/{examId}`: Registers a student for a specific exam.

(Add endpoints for subjects and exams)

## Entity Classes

### Student

The `Student` entity represents a student enrolled in the LMS.

Attributes:
- `id`: Unique identifier for the student.
- `registrationId`: Unique registration ID for the student.
- `name`: Name of the student.
- `enrolledSubjects`: List of subjects in which the student is enrolled.
- `registeredExams`: List of exams registered by the student.

### Subject

The `Subject` entity represents a subject offered in the LMS.

Attributes:
- `id`: Unique identifier for the subject.
- `subjectId`: Unique identifier for the subject.
- `name`: Name of the subject.
- `enrolledStudents`: List of students enrolled in the subject.
- `exams`: List of exams associated with the subject.

### Exam

The `Exam` entity represents an exam offered in the LMS.

Attributes:
- `id`: Unique identifier for the exam.
- `examId`: Unique identifier for the exam.
- `subject`: Subject to which the exam belongs.
- `registeredStudents`: List of students registered for the exam.



## Controllers

### EasterEggController

The `EasterEggController` provides an endpoint to trigger the Easter Egg feature, which generates a random fact about a given number.

Endpoints:
- `GET /hidden-feature/{number}`: Generates a fact about the specified number using the Numbers API.

### ExamController

The `ExamController` manages CRUD operations for exams in the Learning Management System.

Endpoints:
- `GET /exams`: Retrieves all exams.
- `POST /exams/{examId}`: Registers a student for the specified exam.

### StudentController

The `StudentController` manages CRUD operations for students in the Learning Management System.

Endpoints:
- `GET /students`: Retrieves all students.
- `GET /students/{studentId}`: Retrieves a student by ID.
- `POST /students`: Creates a new student.
- `PUT /students/{studentId}`: Updates an existing student.
- `DELETE /students/{studentId}`: Deletes a student.
- `POST /students/{studentId}/register/{examId}`: Registers a student for a specific exam.
- `POST /students/{studentId}/enroll-subject/{subjectId}`: Enrolls a student for a specific subject.

### SubjectController

The `SubjectController` manages CRUD operations for subjects in the Learning Management System.

Endpoints:
- `GET /subjects`: Retrieves all subjects.
- `POST /subjects`: Creates a new subject.

## Services

### ExamService

The `ExamService` provides methods to interact with exam-related data in the Learning Management System.

**Functionality:**
- `getAllExams()`: Retrieves all exams.
- `registerStudentForExam(Long examId, Student student)`: Registers a student for a specific exam.

### StudentService

The `StudentService` provides methods to interact with student-related data in the Learning Management System.

**Functionality:**
- `getAllStudents()`: Retrieves all students.
- `createStudent(Student student)`: Creates a new student.
- `getStudentById(Long studentId)`: Retrieves a student by ID.
- `updateStudent(Long studentId, Student updatedStudent)`: Updates an existing student.
- `deleteStudent(Long studentId)`: Deletes a student.
- `registerForExam(Long studentId, Long examId)`: Registers a student for a specific exam.
- `enrollStudentForSubject(Long studentId, Long subjectId)`: Enrolls a student for a specific subject.

### SubjectService

The `SubjectService` provides methods to interact with subject-related data in the Learning Management System.

**Functionality:**
- `getAllSubjects()`: Retrieves all subjects.
- `createSubject(Subject subject)`: Creates a new subject.


## Repositories

### ExamRepository

The `ExamRepository` interface provides methods for accessing exam-related data in the database.

**Methods:**
- Inherits all methods from `JpaRepository<Exam, Long>`.
- Additional custom methods can be defined here if needed.

### StudentRepository

The `StudentRepository` interface provides methods for accessing student-related data in the database.

**Methods:**
- Inherits all methods from `JpaRepository<Student, Long>`.
- Additional custom methods can be defined here if needed.

### SubjectRepository

The `SubjectRepository` interface provides methods for accessing subject-related data in the database.

**Methods:**
- Inherits all methods from `JpaRepository<Subject, Long>`.
- Additional custom methods can be defined here if needed.


## Additional Features

### Global Exception Handling

The `GlobalExceptionHandler` class provides global exception handling for the application. It catches any exceptions that occur during request processing and returns an appropriate error response with a status code of 500 (Internal Server Error).

### RestTemplate Configuration

The `RestTemplateConfig` class defines a configuration bean for `RestTemplate`, which is a tool for making HTTP requests in Spring applications. It allows the application to communicate with external APIs or services.

### Easter Egg Feature

The `EasterEggController` class defines a REST endpoint `/hidden-feature/{number}` that generates a random fact based on the provided number. It utilizes the Numbers API to fetch trivia facts. If the fact is retrieved successfully, it returns the fact as the response. Otherwise, it returns an error response with a status code of 500 (Internal Server Error).


## Dependencies

The project includes the following dependencies:

- **javax.persistence:javax.persistence-api:2.2:** Provides the Java Persistence API for managing relational data in Java applications.

- **org.springframework.boot:spring-boot-starter-data-jpa:** Starter for using Spring Data JPA with Hibernate for data access.

- **org.springframework.boot:spring-boot-starter-web:** Starter for building web applications using Spring MVC.

- **org.projectlombok:lombok:** Library that helps reduce boilerplate code by providing annotations to generate code during compilation.

- **org.springframework.boot:spring-boot-devtools:** Provides development-time tools to improve the development experience with Spring Boot.

- **com.mysql:mysql-connector-java:** Connector for MySQL database, enabling connectivity with MySQL databases.

- **org.springframework.boot:spring-boot-starter-test:** Starter for testing Spring Boot applications with libraries like JUnit and Mockito.


## Build and Run
To build and run the Learning Navigator project using Gradle, follow these steps:

### Build the Project:
1. Open a terminal or command prompt.
2. Navigate to the root directory of the project where the `build.gradle` file is located.
3. Run the following command to build the project:
   ```
   ./gradlew build
   ```
   This command compiles the source code, runs tests, and packages the application into a JAR file.

### Run the Application:
1. After the build process completes successfully, navigate to the same directory as above.
2. Run the following command to start the application:
   ```
   ./gradlew bootRun
   ```
   This command launches the Spring Boot application using an embedded Tomcat server.

### Access the Application:
Once the application is running, you can access it by navigating to `http://localhost:8080/learningnavigator` in your web browser, assuming that the application is configured to run on port 8080 and with the context path `/learningnavigator`.

### Additional Notes:
- Make sure you have configured your MySQL database with the correct credentials as specified in the `application.properties` file.
- Ensure that no other application is already running on port 8080 to avoid conflicts.
- For production deployment, consider building a deployable JAR or WAR file using `./gradlew build` and deploying it to your preferred server environment.

These steps should allow you to build and run the Learning Navigator project locally on your machine. Adjustments may be necessary based on your specific development environment and requirements.
