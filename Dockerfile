FROM alpine:3.16

RUN apk add openjdk11
ADD /build/libs/Relex-test-task-java-0.0.1-SNAPSHOT.jar relex.jar

ENTRYPOINT ["java", "-jar", "relex.jar"]
