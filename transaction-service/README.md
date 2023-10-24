# Spring Boot Project Setup

This document provides instructions on setting up and running the Spring Boot project.

## Prerequisites

Before you begin, ensure you have the following prerequisites installed:

- Java Development Kit (JDK)
- Maven or Gradle (for building the project)
- MySQL Database

## Getting Started

1. Clone the project repository to your local machine:

   ```bash
   git clone https://github.com/nu0786/Java_Project.git
   cd transaction-service

1. Database Configuration (if using MySQL):
   Edit the application.yml or application.properties file to configure your MySQL database connection settings, including the database URL, username, and password.
2. Build the Project:
   ./gradlew build
3. Run the Application:
   The project includes a run.sh script for starting the Spring Boot application. 
   sh run.sh
4. Access the Application:
      The Spring Boot application will be available at http://localhost:8080//transaction-service with context path as /transaction-service in url

API Endpoints
1. Create an Account:
   POST: /accounts
    Request Body:
    {
    "document_number": "12345678900"
    }

2. Retrieve an Account:
   GET: /accounts/{accountId}

3. Create a Transaction:
   POST: /transactions
   Request Body:
   {
     "account_id": 1,
     "operation_type_id": 4,
     "amount": 123.45
   }

Tests
    The project includes unit tests for the APIs. You can run the tests.
    ./gradlew test

Troubleshooting
If you encounter any issues during setup or running the application, please check your configuration and make sure all prerequisites are installed.