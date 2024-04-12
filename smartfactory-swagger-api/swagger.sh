#!/bin/bash

/usr/lib/jvm/java-1.8.0-openjdk-amd64/jre/bin/java -jar swagger-codegen-cli.jar generate \
  -i swagger.yaml \
  -l typescript-angular \
  -o ${PWD}/outputs/codegen
