#!/bin/bash
set -e

if [ "${1:0:1}" = '-' ]; then
  set -- java "$@"
fi

if [ "$1" = 'java' -a "$(id -u)" = '0' ]; then

    PROJECT_JAR_PATH=$(find /srv -name \*.jar -maxdepth 1)
    set -- java $JAVA_FLAGS $JAVA_DEBUG_FLAGS \
    	-jar $PROJECT_JAR_PATH \
    	--spring.config.location=file:/srv/config/application.yml
fi

# Allow the user to run arbitrarily commands like bash
exec "$@"
