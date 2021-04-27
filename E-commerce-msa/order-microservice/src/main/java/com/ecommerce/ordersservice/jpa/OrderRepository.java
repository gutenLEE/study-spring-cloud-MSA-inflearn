package com.ecommerce.ordersservice.jpa;

import org.hibernate.criterion.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    OrderEntity findByOrderId(String productId);

    Iterable<OrderEntity> findByUserId(String userId);
}
