package com.teamprooject.team.order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);
    List<Order> getAllOrder();
    Order getOrderById(String id);
    void deleteOrder(String id);

    Order getOrderByOrderId(String id);

}
