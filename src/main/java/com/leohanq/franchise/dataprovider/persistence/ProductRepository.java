package com.leohanq.franchise.dataprovider.persistence;

import com.leohanq.franchise.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value = """
        SELECT p.id AS product_id, p.name AS product_name, p.stock AS stock,
               l.id AS location_id, l.name AS location_name
        FROM product p
        INNER JOIN location l ON p.location_id = l.id
        WHERE l.franchise_id = :franchiseId
        AND p.stock = (SELECT MAX(p2.stock) FROM product p2 WHERE p2.location_id = l.id)
        """, nativeQuery = true)
    List<ProductMaxStockProjection> findTopStockProductsByFranchise(@Param("franchiseId") Long franchiseId);
}
