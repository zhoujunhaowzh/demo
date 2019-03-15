FROM openjdk:8-jre-alpine

COPY target/picture-0.0.1-SNAPSHOT.jar /app.jar

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

EXPOSE 8080

ENTRYPOINT java -jar /app.jar
