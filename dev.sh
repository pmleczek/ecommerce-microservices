#!/usr/bin/env bash
cd auth-service
gradle clean build -x test
cd ..

cd product-service
gradle clean build -x test
cd ..

cd discovery-service
gradle clean build -x test
cd ..

docker-compose up --build