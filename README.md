# Safaricom Hack Application using: Spring Boot, MySQL, JPA, Hibernate Rest API and Jenkins

This is a Restful CRUD API for the safaricom hack application application using Spring Boot, Mysql & Jenkins.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Create Mysql database**
```bash
create database called "safaricom"
```

**2. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

change your mysql username and password accordingly

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation i.e. user: root, password: secret

**3. Build and run the app using maven**

```bash
mvn package
java -jar target/safaricom-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8091>. If the port is being used by another application, change to another port in `src/main/resources/application.properties`

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/hackers
    
    POST /api/hacker/create
    
    GET /api/hacker/{hackerId}/view
    
    PUT /api/hacker/{hackerId}/update
    
    DELETE /api/hacker/{hackerId}/delete

You can test them using postman, curl or any other rest api client.

## Repository

This app can be downloaded from `https://github.com/cimplival/safaricom-hack`
