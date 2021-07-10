FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /opt/app
COPY target/docker-app-0.0.1.jar /opt/app
CMD ["java", "-jar", "/opt/app/docker-app-0.0.1.jar"]
EXPOSE 8080