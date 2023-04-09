# E-commerce App
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white)  
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)  
![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)
![React Router](https://img.shields.io/badge/React_Router-CA4245?style=for-the-badge&logo=react-router&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white)  
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![GIT](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![Shell Scripts](https://img.shields.io/badge/Shell_Script-121011?style=for-the-badge&logo=gnu-bash&logoColor=white)
![IntelliJ Idea](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![WebStorm](https://img.shields.io/badge/webstorm-143?style=for-the-badge&logo=webstorm&logoColor=white&color=black)

## 🔍 About
E-commerce App is a full stack project created to practice building microservices with Spring Boot + Spring Cloud and frontend applications with React and TypeScript.

## 📝 Backend system architecture:
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
