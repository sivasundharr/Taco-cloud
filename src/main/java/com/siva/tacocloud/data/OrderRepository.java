package com.siva.tacocloud.data;

import com.siva.tacocloud.Order;
import org.springframework.data.repository.CrudRepository;
public interface OrderRepository extends CrudRepository<Order,Long>{
    
}
