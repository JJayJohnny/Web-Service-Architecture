from maven:3.9.5-eclipse-temurin-17 as build
ADD . /tmp/
WORKDIR /tmp/
RUN mvn clean verify


from eclipse-temurin:17.0.6_10-jre

ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:aui-book
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING-DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DLL=true
ENV SPRING_JPA_HIBERNATE_DLL_AUTO=update

ENV SPRING_H2_CONSOLE_ENABLED=true

EXPOSE 8080

COPY --from=build /tmp/target/AUI-book-1.0.0-SNAPSHOT.jar /opt/aui-book/aui-book.jar
CMD ["java", "-jar", "/opt/aui-book/aui-book.jar"]

