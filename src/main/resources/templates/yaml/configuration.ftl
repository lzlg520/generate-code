server:
  port: 80
spring:
  application:
    name: ${artifactId}
  datasource:
    druid:
      url: ${databaseInfo.url}
      username: ${databaseInfo.username}
      password: ${databaseInfo.password}
      driverClassName: com.mysql.jdbc.Driver
      initialSize: 5  #初始建立连接数量
      minIdle: 5  #最小连接数量
      maxActive: 20 #最大连接数量
      maxWait: 10000  #获取连接最大等待时间，毫秒
      testOnBorrow: true #申请连接时检测连接是否有效
      testOnReturn: false #归还连接时检测连接是否有效
      timeBetweenEvictionRunsMillis: 60000 #配置间隔检测连接是否有效的时间（单位是毫秒）
      minEvictableIdleTimeMillis: 300000  #连接在连接池的最小生存时间（毫秒）
mybatis:
  mapper-locations: classpath:mapper/*.xml