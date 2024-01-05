FROM eclipse-temurin:17.0.6_10-jre

ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_CLOUD_CONFIG_SERVER_NATIVE_SEARCH_LOCATIONS=file:/var/aui-config/configuration
VOLUME /var/aui-config/configuration

EXPOSE 8080

COPY target/AUI-config-1.0.0-SNAPSHOT.jar /opt/aui-config/aui-config.jar
CMD ["java", "-jar", "/opt/aui-config/aui-config.jar"]