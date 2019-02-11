FROM openjdk:8-jre-alpine
MAINTAINER Mohsen Lotfizad (mohsen.lotfizad@gmail.com)

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    START_SLEEP=0 \
    JAVA_OPTS=""

# add directly the jar
ADD stock-assignment*.jar /app.jar

EXPOSE 8081
CMD echo "The application will start..." && \
    sleep ${START_SLEEP} && \
    java ${JAVA_OPTS} -Dsun.misc.URLClassPath.disableJarChecking=true -Djava.io.tmpdir=/var/tmp -Djava.security.egd=file:/dev/./urandom -jar /app.jar
