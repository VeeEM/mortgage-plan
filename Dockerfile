# syntax=docker/dockerfile:1

FROM openjdk:17-alpine3.14

WORKDIR /app

COPY gradle/ ./gradle
COPY gradlew gradlew
COPY settings.gradle settings.gradle
COPY build.gradle build.gradle
COPY src/ ./src
COPY wait-for-it/wait-for-it.sh wait-for-it.sh

COPY prospects.txt prospects.txt

CMD ["./wait-for-it.sh", "mysqlserver:3306", "--", "./gradlew", "bootRun" ""prospects.txt"]
