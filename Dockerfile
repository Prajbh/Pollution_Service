FROM openjdk:latest
MAINTAINER Prajyoth Bhandary
ADD target/pollution_service.jar /default/pollution_service.jar
USER root
RUN chown root:root /default
RUN chmod 777 /default
EXPOSE 9000
CMD ["java","-jar","/default/pollution_service.jar"]