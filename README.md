# microservice-s1-day5
Service - to Service call, 1) Ribbon (RestTemplate) - @HystrixCommand(fallbackMethod=""), 2) Feign - @FeignClient(name="product-service", fallback=ProductServiceProxyImpl.class)
