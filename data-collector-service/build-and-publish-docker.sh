#!/bin/bash

echo ""
echo "+------------------------------------+"
echo "| Data Collector Service - build and publish Docker image |"
echo "+------------------------------------+"
echo ""
docker build -t localhost:5001/data-collector-service:local -f Dockerfile .
docker push localhost:5001/data-collector-service:local