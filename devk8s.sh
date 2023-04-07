#!/usr/bin/env bash
cd auth-service
gradle clean build -x test
docker build -t auth-service .
minikube image load auth-service
cd ..

cd product-service
gradle clean build -x test
docker build -t product-service .
minikube image load product-service
cd ..
