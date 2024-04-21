#!/bin/bash

echo ""
echo "+------------------------------------+"
echo "| Subscription Service - build and publish Docker image |"
echo "+------------------------------------+"
echo ""
docker build -t localhost:5001/subscription-service:local -f Dockerfile .
docker push localhost:5001/subscription-service:local