#!/bin/bash

echo ""
echo "+------------------------------------+"
echo "| User Management - build and publish Docker image |"
echo "+------------------------------------+"
echo ""
docker build -t localhost:5001/user-management-service:local -f Dockerfile .
docker push localhost:5001/user-management-service:local