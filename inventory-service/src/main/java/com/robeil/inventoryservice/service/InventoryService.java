package com.robeil.inventoryservice.service;

public interface InventoryService {

    boolean isInStock(String skuCode, Integer quantity);
}
