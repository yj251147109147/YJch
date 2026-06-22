@echo off
chcp 65001 >nul
set LIB=lib
set JAR=%LIB%\mysql-connector-j-8.3.0.jar

if not exist "%LIB%" mkdir "%LIB%"

if exist "%JAR%" (
    echo MySQL 驱动已存在: %JAR%
    exit /b 0
)

echo 正在下载 MySQL JDBC 驱动...
powershell -NoProfile -Command ^
  "$url='https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.3.0/mysql-connector-j-8.3.0.jar';" ^
  "$out='lib\mysql-connector-j-8.3.0.jar';" ^
  "Invoke-WebRequest -Uri $url -OutFile $out -UseBasicParsing"

if exist "%JAR%" (
    echo 下载完成: %JAR%
) else (
    echo 下载失败，请手动将 mysql-connector-j-8.3.0.jar 放入 lib 目录
    exit /b 1
)
