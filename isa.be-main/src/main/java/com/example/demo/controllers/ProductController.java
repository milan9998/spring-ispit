package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.models.ProductModel;
import com.example.demo.repositories.IProductRepository;
import com.example.demo.services.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductRepository productRepository;
    private final IProductService  productService;

    @GetMapping("get-list")
    public List<Product> getList() {
        return productRepository.findAll();
    }


    @PostMapping("create-product")
    public ResponseEntity<?> create(@RequestBody @Valid ProductModel productModel, BindingResult result) {
        return ResponseEntity.ok(productService.create(productModel));
    }

    @PutMapping("update-product")
    public ResponseEntity<?> update(@RequestBody @Valid ProductModel productModel, BindingResult result) {

        if (result.hasErrors()) {
            return new ResponseEntity<>("Not updated!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(productService.update(productModel));
    }
}
