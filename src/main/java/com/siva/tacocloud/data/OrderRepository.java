package com.siva.tacocloud.data;

import com.siva.tacocloud.Order;

public interface OrderRepository {
    Order save(Order order);
}
