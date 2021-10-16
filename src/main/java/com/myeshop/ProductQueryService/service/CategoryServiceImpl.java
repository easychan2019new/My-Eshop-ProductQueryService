package com.myeshop.ProductQueryService.service;

import com.myeshop.ProductQueryService.data.entity.Category;
import com.myeshop.ProductQueryService.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findCategory(String id) {
        return categoryRepository.findCategoryById(id);
    }

//    @Override
//    public Page<Category> findAllCategory() {
//        return categoryRepository.findAll(Pageable.unpaged());
//    }
}
