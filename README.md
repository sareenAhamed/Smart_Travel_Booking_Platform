# SmartTravel -- Microservices-Based Travel Booking Platform

SmartTravel is a microservices-based travel booking system built using
**Spring Boot**, **MySQL**, **Feign Clients**, and **Spring Mail**.\
The system is designed as a fully distributed architecture with each
feature managed by its own microservice.

------------------------------------------------------------------------

# Microservices Included

  ------------------------------------------------------------------------
  Service               Port            Description
  --------------------- --------------- ----------------------------------
  **User Service**      8081            Manages user registration and
                                        details

  **Flight Service**    8082            Manages flights, airlines,
                                        schedules, prices

  **Hotel Service**     8083            Manages hotels, rooms,
                                        availability

  **Booking Service**   8084            Combines user, flight, hotel to
                                        create bookings

  **Payment Service**   8085            Processes booking payments

  **Notification Service**        8086            Sends email notifications                             

------------------------------------------------------------------------

# Architecture Diagram 
<img align="right" width="370" height="290" src="https://ibb.co/qMkphJpR">
  
------------------------------------------------------------------------

# Technology Stack

### Backend

-   Java 17\
-   Spring Boot 3\
-   Spring Data JPA\
-   Spring Web\
-   Spring Validation\
-   Spring Mail\
-   Spring Cloud OpenFeign\

### Database

-   MySQL 

### Tools

-   Maven\
-   Postman\
-   IntelliJ 

------------------------------------------------------------------------

# Project Structure

    smarttravel/
    │
    ├── user-service/
    ├── flight-service/
    ├── hotel-service/
    ├── booking-service/
    ├── payment-service/
    └── notification-service/

Each service follows:

    src/
     └── main/java/com/smarttravel/<service>/
          ├── controller/
          ├── service/
          │    └── impl/
          ├── repository/
          ├── entity/
          ├── dto/
          ├── exception/
          └── config/

------------------------------------------------------------------------

# How to Run Each Service

### 1. Start MySQL and create databases

``` sql
CREATE DATABASE user_db;
CREATE DATABASE flight_db;
CREATE DATABASE hotel_db;
CREATE DATABASE booking_db;
CREATE DATABASE payment_db;
CREATE DATABASE notification_db;
```

------------------------------------------------------------------------

### 2. Configure database credentials

Update each service's `application.properties`:

``` properties
spring.datasource.username=root
spring.datasource.password=XXXXX
```

------------------------------------------------------------------------

### 3. Run Microservices in this Order

    User Service → 8081  
    Flight Service → 8082  
    Hotel Service → 8083  
    Booking Service → 8084  
    Payment Service → 8085  
    Notification Service → 8086

------------------------------------------------------------------------

# Email Notification Setup

Use Gmail **App Password**:

``` properties
spring.mail.username=your_email@gmail.com
spring.mail.password=XXXXXXXX
```

------------------------------------------------------------------------

# API Endpoints

## User Service

    POST /api/users
    GET  /api/users/{id}

## Flight Service

    POST /api/flights
    GET  /api/flights/{id}

## Hotel Service

    POST /api/hotels
    GET  /api/hotels/{id}

## Booking Service

    POST /api/bookings
    GET  /api/bookings/{id}

## Payment Service

    POST /api/payments
    GET  /api/payments/{id}

## Notification Service

    POST /api/notifications

------------------------------------------------------------------------


# 👨‍💻 Author

**Sareen Ahamed**\
Bachelor of ICT --- Software Technology\



