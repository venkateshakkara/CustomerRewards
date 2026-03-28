package com.api.rewards.repository;


import com.api.rewards.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT s.product AS product, SUM(s.quantity) AS totalQty, SUM(s.amount) AS totalAmount " +
            "FROM Sale s WHERE s.createdAt BETWEEN :start AND :end GROUP BY s.product")
    List<Object[]> aggregateByProduct(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}