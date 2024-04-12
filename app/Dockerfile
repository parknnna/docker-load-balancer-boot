##### Build Stage #####
# 빌드 작업을 위한 JDK 베이스이미지
FROM openjdk:17

# openjdk에 xargs 포함 x
RUN microdnf install findutils

## 워킹 디렉토리 설정
WORKDIR /workspace/app

# gradlew 복사
COPY gradlew .
# gradle 복사
COPY gradle gradle
# build.gradle 복사
COPY build.gradle .
# settings.gradle 복사
COPY settings.gradle .
# 웹어플리케이션 소스 복사
COPY src src

# gradlew 실행 권한 부여
RUN chmod +x ./gradlew

# gradlew를 통해 실행 가능한 jar 빌드
RUN ./gradlew bootJar

# deploy
#ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "/app/app.jar"]
ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-jar", "/workspace/app/build/libs/docker-load-balancer-boot-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
