package com.deliver.dsdeliver.repositories;

import java.util.List;

import com.deliver.dsdeliver.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long> {

    @Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products "
            + " WHERE obj.status = 0 ORDER BY obj.moment ASC")
    List<Order> findAllOrdersPending();
    
}
