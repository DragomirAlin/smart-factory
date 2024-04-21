#!/bin/bash
# Script to bootstrap required services for development

echo ""
echo "******************************************"
echo "* Bootstrapping microservices for development *"
echo "******************************************"
echo ""

echo ""
echo "**********************************************"
echo "* [1/2] Build Docker images for all services *"
echo "**********************************************"
echo ""

BASE_DIR="${PWD}"

cd ../../user-management-service
./mvnw package -DskipTests;
./build-and-publish-docker.sh
cd "${BASE_DIR}"

echo ""
echo "**********************************************"
echo "* [2/2] Start all services with Docker *"
echo "**********************************************"
echo ""

docker-compose -f ../smartfactory/docker-compose-apps.yml  up -d

echo ""
echo "Microservices bootstrapped successfully!"