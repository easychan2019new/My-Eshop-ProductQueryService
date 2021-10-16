package com.myeshop.ProductQueryService.service;

import com.myeshop.Core.Product.event.ProductCreatedEvent;
import com.myeshop.ProductQueryService.data.entity.Product;

public interface ProductService {
    Product createProduct(ProductCreatedEvent event);
}
