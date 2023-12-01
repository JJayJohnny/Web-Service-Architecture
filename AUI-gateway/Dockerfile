FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

# ENV AUI_GATEWAY_HOST=localhost:8080

# ENV AUI_BOOK_URL=http://localhost:8081
# ENV AUI_AUTHOR_URL=http://localhost:8082

EXPOSE 8080

COPY  target/AUI-gateway-1.0.0-SNAPSHOT.jar /opt/aui-gateway/aui-gateway.jar
CMD ["java", "-jar", "/opt/aui-gateway/aui-gateway.jar"]