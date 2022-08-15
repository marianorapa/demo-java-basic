package com.example.demo.dto.response;

public class ProductCreationResponse {
    private final String status;

    public ProductCreationResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
