FROM adoptopenjdk:11-jre-hotspot as builder
EXPOSE 8080
ADD target/jumia-application.jar jumia-application.jar
ENTRYPOINT{"java" , "-jar" , "/jumia-application.jar"}
