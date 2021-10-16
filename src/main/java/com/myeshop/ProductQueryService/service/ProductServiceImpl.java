package com.myeshop.ProductQueryService.service;

import com.myeshop.Core.Product.event.ProductCreatedEvent;
import com.myeshop.ProductQueryService.data.entity.Category;
import com.myeshop.ProductQueryService.data.entity.Product;
import com.myeshop.ProductQueryService.data.repository.CategoryRepository;
import com.myeshop.ProductQueryService.data.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(ProductCreatedEvent event) {
        Category productCategory = categoryRepository.findCategoryById(event.getCategoryId());
        Product product = new Product(event.getProductId());
        BeanUtils.copyProperties(event, product);
        product.setProductCategory(productCategory);
        productRepository.save(product);
        return product;
    }
}
