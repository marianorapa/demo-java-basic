package com.example.demo.dto.response;

import com.example.demo.dto.ProductDto;

import java.util.Arrays;
import java.util.List;

public class ProductsResponse {

    private final List<ProductDto> products;

    public ProductsResponse(List<ProductDto> products) {
        this.products = products;
    }

    public List<ProductDto> getProducts() {
        return products;
    }
}
