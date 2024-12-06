# Base image 설정
FROM openjdk:21-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# 소스 복사
COPY . .

# Gradle 빌드 수행
RUN ./gradlew clean build

# JAR 파일 실행 설정
ENTRYPOINT ["java", "-jar", "/app/build/libs/mypage-service.jar"]