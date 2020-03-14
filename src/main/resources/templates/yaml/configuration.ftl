server:
  port: 80
spring:
  application:
    name: ${artifactId}
  datasource:
    url: ${databaseInfo.url}
    username: ${databaseInfo.username}
    password: ${databaseInfo.password}