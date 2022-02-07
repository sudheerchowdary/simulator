FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bnc-sim.jar
ENTRYPOINT ["java","-jar","/bnc-sim.jar"]