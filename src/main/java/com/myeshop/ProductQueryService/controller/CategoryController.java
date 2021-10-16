package com.myeshop.ProductQueryService.controller;

import com.myeshop.ProductQueryService.data.entity.Category;
import com.myeshop.ProductQueryService.data.repository.CategoryRepository;
import com.myeshop.ProductQueryService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category") // http://localhost:8082/product-query-service/category
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/findCategory")
    public Category findCategory(@RequestParam("id") String id) {
        return categoryService.findCategory(id);
    }

    @GetMapping("/findAllCategory")
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @GetMapping("/findCategoryByName")
    public Category findCategoryByName(@RequestParam("name") String name) {
        return categoryRepository.findByName(name);
    }
}
