package com.robeil.orderservice.service.impl;

import com.robeil.orderservice.client.InventoryClient;
import com.robeil.orderservice.dto.OrderRequest;
import com.robeil.orderservice.model.Order;
import com.robeil.orderservice.repository.OrderRepository;
import com.robeil.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final OrderRepository repository;
    private final InventoryClient inventoryClient;
    private final ModelMapper modelMapper;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        var isProductInStock = inventoryClient.isInStock(orderRequest.getSkuCode(), orderRequest.getQuantity());

        if(isProductInStock) {
            Order order = modelMapper.map(orderRequest, Order.class);
            order.setOrderNumber(UUID.randomUUID().toString());
            repository.save(order);
            logger.info("Order placed Successfully");
        } else {
            logger.info("Product with skuCode " + orderRequest.getSkuCode() + " is not in Stock");
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll();
    }
}
