package org.top.orderpage.model;

import org.top.orderpage.entity.OrderTEntity;

import java.util.List;

public interface IControlOrder {

    void insertOrder(OrderTEntity order); // добавить

    OrderTEntity getOrderById(Long id); // получить  по id

    List<OrderTEntity> getAllOrders(); //  получить все

    void updateOrder(OrderTEntity car); // обновить данные

    void deleteOrderById(Long id);  // удалить по id
}