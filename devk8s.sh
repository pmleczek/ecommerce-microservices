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

cd kubernetes/helm
cd components

cd auth-service
helm dependency update
helm dependency build
cd ..

cd product-service
helm dependency update

helm dependency build
cd ..

cd ..
cd environments
helm dependency update development
helm dependency build development
helm install development development
