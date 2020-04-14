FROM openjdk:8-jre-alpine

RUN mkdir /app
WORKDIR /app

COPY target/*.jar app.jar

LABEL maintainer="radualinpopa@yahoo.com" \
	version="1.0.0-SNAPSHOT"

CMD ["java", "-jar", "app.jar"]

EXPOSE 8082
