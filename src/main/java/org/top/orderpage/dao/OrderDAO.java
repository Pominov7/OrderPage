package org.top.orderpage.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.top.orderpage.entity.OrderTEntity;
import org.top.orderpage.model.IControlOrder;

import java.util.List;

public class OrderDAO implements IControlOrder {

    //CREATE
    @Override
    public void insertOrder(OrderTEntity order) {
        // 1. создаем фабрику
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        // 2. manager
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // 3. объект транзакции
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            // выполнение самой операции создания записи в БД
            transaction.begin();
            entityManager.persist(order);   // создание новой записи на основе объекта
            transaction.commit();
        } finally {
            // все закрыть и откатить транзакцию, если нужно
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public OrderTEntity getOrderById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        // переменная для хранения объекта-результата поиска
        OrderTEntity result = null;
        try {
            transaction.begin();
            // сама операция
            result = entityManager.find(OrderTEntity.class, id);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return result;  // вернуть результат
    }

    @Override
    public List<OrderTEntity> getAllOrders() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        // список результатов
        List<OrderTEntity> orders = null;

        try {
            transaction.begin();
            // сама операция
            orders = entityManager.createQuery("SELECT e FROM OrderTEntity e").getResultList();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return orders;
    }

    @Override
    public void updateOrder(OrderTEntity order) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            // 1. получаю обновляемый объект по Id
            OrderTEntity updated = entityManager.find(OrderTEntity.class, order.getIdF());
            // 2. обновляю поля обновляемого объекта
            updated.updateFields(order);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public void deleteOrderById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            // сама операция
            // 1. получить удаляемый объект
            OrderTEntity deleted = entityManager.find(OrderTEntity.class, id);
            // 2. удалить
            entityManager.remove(deleted);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
