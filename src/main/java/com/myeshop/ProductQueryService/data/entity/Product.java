package com.myeshop.ProductQueryService.data.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product")
public class Product {

    public Product(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "date_created")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_updated")
    private Date lastUpdated;

    //private String categoryId;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category productCategory;

}
