package com.robeil.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
    private String id;
    private String orderNumber, skuCode;
    private BigDecimal price;
    private int quantity;
}