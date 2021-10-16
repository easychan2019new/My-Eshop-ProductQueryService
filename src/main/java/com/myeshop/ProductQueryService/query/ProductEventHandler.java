package com.myeshop.ProductQueryService.query;

import com.myeshop.Core.Product.event.ProductCreatedEvent;
import com.myeshop.Core.Product.event.ProductReservedEvent;
import com.myeshop.Core.Product.event.ProductRollbackEvent;
import com.myeshop.ProductQueryService.data.entity.Product;
import com.myeshop.ProductQueryService.data.repository.ProductRepository;
import com.myeshop.ProductQueryService.service.ProductService;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductEventHandler.class);

    @Autowired
    private  ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent) {
        LOGGER.info("Handle productCreatedEvent!");
        productService.createProduct(productCreatedEvent);
    }

    @EventHandler
    public void on(ProductReservedEvent productReservedEvent) {
        LOGGER.info("Handle productReservedEvent!");
        Product product = productRepository.findProductById(productReservedEvent.getProductId());
        product.setQuantity(product.getQuantity() - productReservedEvent.getQuantity());
        productRepository.save(product);
    }

    @EventHandler
    public void on(ProductRollbackEvent productRollbackEvent) {
        LOGGER.info("Handle productRollbackEvent!");
        Product product = productRepository.findProductById(productRollbackEvent.getProductId());
        product.setQuantity(product.getQuantity() + productRollbackEvent.getQuantity());
        productRepository.save(product);
    }
}
