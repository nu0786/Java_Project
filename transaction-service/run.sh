#!/bin/bash

# Change to the directory where your JAR file is located
cd ../transaction-service

# Set environment variables (if needed)
export JDBC_URL=jdbc:mysql://localhost:3306/test
export JDBC_USERNAME=root
export JDBC_PASSWORD=rootsecret

docker build -t transaction-service .
docker run -p 8080:8080 transaction-service