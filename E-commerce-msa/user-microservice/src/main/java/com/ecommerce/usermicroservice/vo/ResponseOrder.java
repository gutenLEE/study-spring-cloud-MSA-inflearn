package com.ecommerce.usermicroservice.vo;

import lombok.Data;

@Data
public class ResponseOrder {

    private String produceId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Data createdAt;

    private String orderId;
}
