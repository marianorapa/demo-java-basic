package com.example.demo.dto.request;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ProductCreationRequest {

    @NotBlank(message = "description is mandatory")
    @Pattern(regexp = "[a-zA-Z]+", message = "description must be text and can't exceed 255 characters")
    @Size(max = 255, message = "Description size can't exceed 255 characters")
    private String description;

    @Positive(message = "price must be a positive number")
    @NotNull(message = "price is mandatory")
    private BigDecimal price;

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
