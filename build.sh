#!/bin/bash
set -e

echo "Building fat JAR..."
mvn clean package

echo "Build complete. Look for the JAR here:"
find target -name "*jar-with-dependencies.jar"