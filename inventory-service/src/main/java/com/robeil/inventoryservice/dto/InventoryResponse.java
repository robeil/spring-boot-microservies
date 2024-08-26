package com.robeil.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryResponse {
    private String id;
    private String orderNumber, skuCode;
    private BigDecimal price;
    private int quantity;
}