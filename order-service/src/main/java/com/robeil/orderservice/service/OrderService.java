package com.robeil.orderservice.service;

import com.robeil.orderservice.dto.OrderRequest;
import com.robeil.orderservice.model.Order;

import java.util.List;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
    List<Order> getAllOrders();
}
