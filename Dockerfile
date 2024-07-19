# 첫 번째 단계: Gradle 빌드 환경 설정
FROM openjdk:21-jdk

ARG JAR_FILE=/build/libs/Team-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]