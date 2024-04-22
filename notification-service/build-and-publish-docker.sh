#!/bin/bash

echo ""
echo "+------------------------------------+"
echo "| Notification Service - build and publish Docker image |"
echo "+------------------------------------+"
echo ""
docker build -t localhost:5001/notification-service:local -f Dockerfile .
docker push localhost:5001/notification-service:local