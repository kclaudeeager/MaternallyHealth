FROM openjdk:14-jdk-alpine
EXPOSE 8080
ADD target/maternally.jar maternally.jar 
ENTRYPOINT ["java","-jar","/maternally.jar"]