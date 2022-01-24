FROM openjdk:17-alpine
MAINTAINER com.projectagora
COPY target/realtimebidderapp-1.0-spring-boot.jar realtimebidderapp-1.0-spring-boot.jar
ENTRYPOINT ["java","-jar","/realtimebidderapp-1.0-spring-boot.jar"]