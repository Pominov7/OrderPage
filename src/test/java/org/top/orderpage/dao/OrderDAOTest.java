package org.top.orderpage.dao;

import org.junit.jupiter.api.Test;
import org.top.orderpage.entity.OrderTEntity;

import java.util.List;


class OrderDAOTest {

    @Test
    void insertOrder() {
        OrderTEntity order = new OrderTEntity();
        order.setNameF("Пётр");
        order.setEmailF("petr222@mail.ru");
        order.setPhoneF("+79133625456");
        order.setAddressF("Островского 21");
        System.out.println(order);
    }

    @Test
    void getOrderById() {
        OrderTEntity result = new OrderDAO().getOrderById(2L);
        System.out.println(result);
    }

    @Test
    void getAllOrders() {
        List<OrderTEntity> orders = new OrderDAO().getAllOrders();
        for (OrderTEntity order : orders) {
            System.out.println(order);
        }
    }

    @Test
    void updateOrder() {
        OrderTEntity result = new OrderDAO().getOrderById(2L);
        result.setNameF("Алиса");
        System.out.println(result);
    }

    @Test
    void deleteOrderById() {
        new OrderDAO().deleteOrderById(3L);
        List<OrderTEntity> orders = new OrderDAO().getAllOrders();
        for (OrderTEntity order : orders) {
            System.out.println(order);
        }
    }
}