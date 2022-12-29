FROM openjdk:8-jre
WORKDIR /app
COPY target/spring-boot-mysql-v3.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ] 
