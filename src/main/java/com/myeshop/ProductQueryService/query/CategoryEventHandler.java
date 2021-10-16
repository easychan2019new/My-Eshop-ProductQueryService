package com.myeshop.ProductQueryService.query;

import com.myeshop.Core.category.event.CategoryCreatedEvent;
import com.myeshop.ProductQueryService.data.entity.Category;
import com.myeshop.ProductQueryService.data.repository.CategoryRepository;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryEventHandler.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @EventHandler
    public void on(CategoryCreatedEvent event) {

        Category category = new Category();

        category.setId(event.getCategoryId());
        category.setName(event.getName());

        LOGGER.info("Handle CategoryCreatedEvent!");
        categoryRepository.save(category);
    }
}
