@echo off
chcp 65001 >nul
set SRC=src\main\java
set RES=src\main\resources
set OUT=target\classes
set LIB=lib\mysql-connector-j-8.3.0.jar

call setup-lib.bat
if errorlevel 1 exit /b 1

if not exist "%OUT%" mkdir "%OUT%"
xcopy /Y /Q "%RES%\*" "%OUT%\" >nul

echo 正在编译...
dir /s /b %SRC%\*.java > "%TEMP%\difu_sources.txt"
javac -encoding UTF-8 -cp "%LIB%" -d "%OUT%" @%TEMP%\difu_sources.txt
if errorlevel 1 (
    echo 编译失败，请确认已安装 JDK 17+
    pause
    exit /b 1
)

echo.
echo 启动地府管理系统（MySQL 持久化）...
java -Dfile.encoding=UTF-8 -cp "%OUT%;%LIB%" com.difu.Main
pause
