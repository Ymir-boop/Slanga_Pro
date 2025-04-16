@echo off
echo Building fat JAR...

REM Clean and package with Maven
call mvn clean package

echo.
echo Build complete. Look for the JAR in the target folder.
