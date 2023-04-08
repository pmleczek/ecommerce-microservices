# E-commerce microservices
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white)  
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)  
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![GIT](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![Shell Scripts](https://img.shields.io/badge/Shell_Script-121011?style=for-the-badge&logo=gnu-bash&logoColor=white)
![IntelliJ Idea](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

## About
E-commerce microservices is a project created to revise and practice building microservices with Spring Boot. It consists of 3 core microservices, each with its own database (either MongoDB or PostgreSQL) and of 2 Spring Cloud microservices: Netflix Eureka based discovery-service and Spring Cloud Gateway based gateway-service. All services use Docker and Docker Compose for seamless integration during development and all of the 3 core microservices rely on Spring Security to provide access control and security configuration.

## System architecture:
![System architecture](https://user-images.githubusercontent.com/67064618/230743524-2b468743-2cc6-4d92-9aae-a551de3754f4.jpeg)
### 🟢 Spring Cloud microservices:
#### gateway-service
- Features: Gateway service, path-based routing
- Technologies used: Spring Boot, Spring Cloud Gateway, Eureka Discovery Client
#### discovery-service
- Features: Service discoverability, instance registration
- Technologies used: Spring Boot, Eureka Disovery Server
### 🔵 Core microservices:
#### auth-service
- Features: Simple JWT authentication server
- Technologies used: Spring Boot, Spring Security, Auth0 java-jwt, Spring Webflux, Spring Data Reactive MongoDB
#### product-service
- Features: Provide product and category data, expose endpoints for managing categories and products
- Technologies used: Spring Boot, Spring Security, Auth0 java-jwt, Spring Webflux, Spring Data Reactive MongoDB
#### order-service
- Features: Track state of user carts, manage orders
- Technologies used: Spring Boot, Spring Security, Auth0 java-jwt, Spring Webflux, Spring R2DBC, PostgreSQL Driver
### 🟠 Databases:
- MongoDB
- PostgreSQL
