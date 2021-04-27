package com.ecommerce.ordersservice.service;

import com.ecommerce.ordersservice.dto.OrderDto;
import com.ecommerce.ordersservice.jpa.OrderEntity;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDetails);

    OrderDto getOrderByOrderId(String orderID);
    Iterable<OrderEntity> getOrderByUserId(String userId);
}
