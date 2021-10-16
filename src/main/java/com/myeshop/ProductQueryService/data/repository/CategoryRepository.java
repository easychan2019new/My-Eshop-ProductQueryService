package com.myeshop.ProductQueryService.data.repository;

import com.myeshop.ProductQueryService.data.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, String> {

    Category findCategoryById(String id);
    Page<Category> findAll(Pageable pageable);
    Category findByName(String name);
}
