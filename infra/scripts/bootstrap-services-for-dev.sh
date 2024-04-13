#!/bin/bash
# Script to bootstrap required services for development

echo ""
echo "******************************************"
echo "* Bootstrapping required services for development *"
echo "******************************************"
echo ""

docker-compose -f ../smartfactory/docker-compose.yml \
               up -d --remove-orphans

echo ""
echo "Services bootstrapped successfully!"