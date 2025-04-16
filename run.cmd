@echo off
setlocal

for /f "delims=" %%i in ('dir /b /s target\*-jar-with-dependencies.jar') do (
    set "JAR=%%i"
    goto :found
)

echo Fat JAR not found. Did you run build.cmd?
exit /b 1

:found
echo Running your JavaFX app...
java -jar "%JAR%"
