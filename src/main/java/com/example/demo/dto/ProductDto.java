package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    private String id;

    @JsonProperty(value = "product_description")
    private String description;

    private BigDecimal price;

    public ProductDto(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public ProductDto(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
