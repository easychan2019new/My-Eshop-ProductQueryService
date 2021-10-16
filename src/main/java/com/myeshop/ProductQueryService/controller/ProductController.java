package com.myeshop.ProductQueryService.controller;

import com.myeshop.ProductQueryService.data.entity.Product;
import com.myeshop.ProductQueryService.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product") // http://localhost:8082/product-query-service/product
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/findProduct")
    public Product findProduct(@RequestParam("id") String id) {
        return productRepository.findProductById(id);
    }

    @GetMapping("/findAll")
    public List<Product> findAll() {
        return productRepository.findAll();
    }

//    @GetMapping("/findByCategoryId")
//    public Page<Product> findByCategoryId(@RequestParam("id") String id) {
//        Pageable pageable = new PageRequest(0,20, Sort.Direction.ASC, "sku");
//        return productRepository.findAllByCategoryId(id, Pageable.unpaged());
//    }
}
