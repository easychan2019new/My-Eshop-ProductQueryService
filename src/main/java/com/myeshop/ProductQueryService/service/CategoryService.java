package com.myeshop.ProductQueryService.service;

import com.myeshop.ProductQueryService.data.entity.Category;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Category findCategory(String categoryId);
    //Page<Category> findAllCategory();
}
