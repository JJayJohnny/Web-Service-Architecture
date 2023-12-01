cd AUI-ng
call npm i
call npm run build
cd ..

set "JAVA_HOME=%USERPROFILE%\.jdks\temurin-17.0.9"

cd AUI-book
call mvn clean verify
cd ..

cd AUI-author
call mvn clean verify
cd ..

cd AUI-gateway
call mvn clean verify
cd ..