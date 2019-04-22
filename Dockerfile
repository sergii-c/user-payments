FROM alpine:latest
ADD target/user-payments-*.jar user-payments.jar
RUN apk --update add openjdk8-jre
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "user-payments.jar"]
