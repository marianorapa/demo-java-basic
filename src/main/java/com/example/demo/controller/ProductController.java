package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.request.ProductCreationRequest;
import com.example.demo.dto.response.ProductCreationResponse;
import com.example.demo.dto.response.ProductsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

    @GetMapping
    public ProductsResponse getProducts(@RequestParam(defaultValue = ".*") String description,
                                        @RequestParam(name = "min_price", defaultValue = "0") BigDecimal minPrice) {
        ProductDto[] productDtos = {new ProductDto("Mouse", BigDecimal.valueOf(50)), new ProductDto("Keyboard", BigDecimal.valueOf(100))};

        System.out.println(minPrice);
        return new ProductsResponse(Arrays.stream(productDtos)
                .filter(productDto -> productDto.getDescription().matches(description) && productDto.getPrice().compareTo(minPrice) > 0)
                .collect(Collectors.toList()));
    }

    @GetMapping(path = "/{id}")
    public ProductDto getProduct(@PathVariable String id) {
        return new ProductDto(id, "Random Product");
    }

    @PostMapping
    public ProductCreationResponse createProduct(@RequestBody @Valid ProductCreationRequest request) {
        return new ProductCreationResponse("OK");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
