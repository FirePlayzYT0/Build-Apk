#!/usr/bin/env sh

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Determine the location of the Gradle home
DIRNAME=$(dirname "$0")
GRADLE_HOME="$DIRNAME/gradle"

# Default Java options
DEFAULT_JVM_OPTS="-Xms64m -Xmx512m"

# Run Gradle
exec java $DEFAULT_JVM_OPTS -jar "$GRADLE_HOME/gradle-wrapper.jar" "$@"