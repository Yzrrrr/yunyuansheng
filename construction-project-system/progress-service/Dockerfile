# 使用官方 OpenJDK 运行时镜像作为基础镜像
FROM openjdk:17-jdk-slim

# 指定作者（可选）
LABEL maintainer="yizeren"

# 创建工作目录
WORKDIR /app

# 将 JAR 包复制到容器中
COPY target/progress-service-1.0.0.jar app.jar

# 暴露应用运行端口（根据 application.yml 设置）
EXPOSE 8002

# 运行 Spring Boot 应用
ENTRYPOINT ["java", "-jar", "app.jar"]