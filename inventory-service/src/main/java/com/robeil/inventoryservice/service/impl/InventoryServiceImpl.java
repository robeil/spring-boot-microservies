package com.robeil.inventoryservice.service.impl;

import com.robeil.inventoryservice.repository.InventoryRepository;
import com.robeil.inventoryservice.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository repository;
    private final Logger logger = LoggerFactory.getLogger(InventoryService.class);

    @Override
    public boolean isInStock(String skuCode, Integer quantity) {
        var allOrder = repository.findAll()
                .stream()
                .filter(order -> order.getSkuCode().equals(skuCode) && order.getQuantity() >= quantity)
                .findAny();
     return allOrder.isEmpty() ? false : true;
       // return repository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
    }
}
