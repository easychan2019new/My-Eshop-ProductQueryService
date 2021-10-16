package com.myeshop.ProductQueryService.data.repository;

import com.myeshop.ProductQueryService.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, String> {
    Product findProductById(String id);

    List<Product> findAll();

    List<Product> findAllByProductCategoryId(@RequestParam("id") String id, Pageable pageable);

    // http://localhost:8082/product-query-service/products/search/findAllByProductCategoryName?name=Books
    Page<Product> findAllByProductCategoryName(@RequestParam("name") String name, Pageable pageable);

    // http://localhost:8082/product-query-service/products/search/findByNameContaining?name=SQL
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
