#!/bin/bash

FX_LIB="/Users/mikaelmatthiasson/Downloads/javafx-sdk-24.0.1/lib"

JAR=$(find target -name "*jar-with-dependencies.jar" | head -n 1)

if [[ -z "$JAR" ]]; then
  echo "Fat JAR not found. Did you run ./build.sh?"
  exit 1
fi

echo "Running JavaFX app..."
java --module-path "$FX_LIB" --add-modules javafx.controls,javafx.fxml -jar "$JAR"