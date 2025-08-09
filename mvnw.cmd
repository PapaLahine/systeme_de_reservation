@echo off
where mvn >nul 2>&1
if %ERRORLEVEL%==0 (
  mvn %*
) else (
  echo mvn not found. Please install Maven or provide a Maven Wrapper (.mvn).
  exit /b 1
)
