package com.robeil.orderservice.client;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

//@FeignClient(value = "inventory", url = "${inventory.url}")
public interface InventoryClient {

   Logger logger = LoggerFactory.getLogger(InventoryClient.class);

//    @RequestMapping(method = RequestMethod.GET, value = "/api/inventories")
    @GetExchange("/api/inventories")
    @CircuitBreaker(name="inventory",fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

    default boolean fallbackMethod(String code, Integer quantity, Throwable throwable){
        logger.info("Cannot get inventory for skuCode {} , failure reason :{}", code, throwable.getCause());
        return false;
    }
}
