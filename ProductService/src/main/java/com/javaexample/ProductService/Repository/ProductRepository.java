package com.javaexample.ProductService.Repository;

import com.javaexample.ProductService.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select p.stock from Product p where p.id=:productId")
    Integer stockCount(@Param("productId")int productId);

    Page<Product> findAll(Pageable pageable);
}
