cd AUI-ng
call npm i
call npm run build
cd ..

for /D %%i in (%USERPROFILE%\.jdks\temurin-17*) do (
    set "JAVA_HOME=%%i"
    goto :found
)
:found

cd AUI-book
call mvn clean verify
cd ..

cd AUI-author
call mvn clean verify
cd ..

cd AUI-gateway
call mvn clean verify
cd ..

cd AUI-eureka
call mvn clean verify
cd ..

cd AUI-config
call mvn clean verify
cd ..