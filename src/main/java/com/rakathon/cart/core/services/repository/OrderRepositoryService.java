package com.rakathon.cart.core.services.repository;

import com.rakathon.cart.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryService extends JpaRepository<Order, Integer> {
}
