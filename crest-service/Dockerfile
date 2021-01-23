FROM openjdk:8-jre
VOLUME /tmp
ADD /target/crest-service-1.0-release.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
EXPOSE 8083
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]