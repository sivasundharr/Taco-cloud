package com.siva.tacocloud.data;
/*
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siva.tacocloud.Order;
import com.siva.tacocloud.Taco;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcOrderRepository implements OrderRepository{

    private SimpleJdbcInsert orderInserter;
    private SimpleJdbcInsert orderTacoInserter;
    private ObjectMapper objectMapper;

    public JdbcOrderRepository(JdbcTemplate jdbc){
        this.orderInserter = new SimpleJdbcInsert(jdbc)
            .withTableName("Taco_Order")
            .usingGeneratedKeyColumns("id");

        this.orderTacoInserter = new SimpleJdbcInsert(jdbc)
            .withTableName("Taco_Order_Tacos");

        this.objectMapper = new ObjectMapper();

    }

    @Override
    public Order save(Order order){
        order.setCreatedAt(new Date());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        List<Taco> tacos = order.getTacos();

        for(Taco taco:tacos){
            saveTacoToOrder(taco,orderId);
        }

        return order;
    }

    private long saveOrderDetails(Order order){
        @SuppressWarnings("unchecked")
        Map<String,Object> values = objectMapper.convertValue(order,Map.class);

        values.put("createdAt",order.getCreatedAt());

        long orderId = orderInserter.executeAndReturnKey(values)
            .longValue();
        
        return orderId;
    }

    private void saveTacoToOrder(Taco taco,long orderId){
        Map<String,Object> values = new HashMap<>();
        values.put("tacoOrder",orderId);
        values.put("taco",taco.getId());
        orderTacoInserter.execute(values);

    }
    
}
*/