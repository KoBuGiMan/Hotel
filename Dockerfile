# 첫 번째 단계: Gradle 빌드 환경 설정
FROM openjdk:21-jdk as builder

WORKDIR /app

# Gradle Wrapper와 관련된 파일들을 복사
COPY gradlew .
COPY gradle ./gradle
COPY settings.gradle .
COPY build.gradle .

# 필요한 의존성 다운로드
RUN ./gradlew dependencies

# 소스 코드 복사
COPY src ./src

# Gradle 빌드
RUN ./gradlew build -x test

# 두 번째 단계: 실행 이미지 설정
FROM openjdk:21-jdk

WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 실행 명령어 설정
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
