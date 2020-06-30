# microservice-s1-day5
Service - to Service call, 1) Ribbon (RestTemplate) - @HystrixCommand(fallbackMethod=""), 2) Feign - @FeignClient(name="product-service", fallback=ProductServiceProxyImpl.class)


Day 5:

Service - to Service call

1) Ribbon (RestTemplate)
- @HystrixCommand(fallbackMethod="")

2) Feign
- @FeignClient(name="product-service",
fallback=ProductServiceProxyImpl.class)

-----------------------------------------------------

Note:
@HystrixCommand(fallbackMethod)/@FeignClient(fallback) will only works in a class marked with @Service/@Component

-----------------------------------------------------

Ribbon (RestTemplate)
- @HystrixCommand(fallbackMethod="")

1) Create a copy of the project:
(cloudserver-eureka-ribbon to cloudserver-eureka-ribbon-hystrix)

2) In pom.xml:

<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>

3) In application.properties:

server.port=9995

eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
eureka.client.register-with-eureka=false

#actuator-endpoints
management.endpoints.web.exposure.include=*

4) @HystrixCommand
@HystrixCommand(fallbackMethod) will only works in a class marked with @Service/@Component

5) Add @EnableCircuitBreaker in the Application class

-------------------------------------------------------

Feign
- @FeignClient(name="product-service",
fallback=ProductServiceFallback.class)

1) Create a copy of the project:
(cloudserver-eureka-feignclient to cloudserver-eureka-feignclient-hystrix)

2) In pom.xml:

<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>

3) In application.properties:

server.port=9994

eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
eureka.client.register-with-eureka=false

#actuator-endpoints
management.endpoints.web.exposure.include=*

4) Note: 
feign.hystrix.enabled=true

(don't forget to set it)

5) ProductServiceFallback.class
- should be annotated with @Component/@Service

6) Add @EnableCircuitBreaker 

-----------------------------------------------------------

Hystrix Dashboard:

1) In pom.xml: (hystrix, hystrix-dashboard and actuator)

<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>

2) Add @EnableHystrixDashboard 

3) In application.properties:
#actuator-endpoints
management.endpoints.web.exposure.include=*

4) Use Endpoint:

Hystrix Dashboard:
http://localhost:9994/hystrix

Hystrix Stream:
http://localhost:9994/actuator/hystrix.stream

----------------------------------------------------------
