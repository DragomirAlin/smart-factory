#!/bin/bash
# Script to bootstrap required services for development

echo ""
echo "******************************************"
echo "* Bootstrapping required services for development *"
echo "******************************************"
echo ""

docker-compose -f ../smartfactory/docker-compose.yml up -d

echo ""
echo "Services bootstrapped successfully!"