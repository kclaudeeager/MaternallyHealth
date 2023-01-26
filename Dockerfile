FROM openjdk:14-jdk-alpine
# EXPOSE 8080
# ADD target/maternally.jar maternally.jar 
# ENTRYPOINT ["java","-jar","/maternally.jar"]

ENV SPRING_PROFILES_ACTIVE=prod
ENV JAVA_OPTS=-Xmx256m

COPY target/maternally.jar /app/maternally.jar
COPY src/main/resources/application-prod.properties /app/config/

EXPOSE 8080

CMD ["java", "-jar", "/app/maternally.jar"]