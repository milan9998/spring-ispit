package com.example.demo.services;

import com.example.demo.mappers.ProductMapper;
import com.example.demo.models.ProductModel;
import com.example.demo.repositories.IProductRepository;
import com.example.demo.repositories.IUserProductsRepository;
import com.example.demo.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final IUserRepository userRepository;
    private final IUserProductsRepository userProductsRepository;
    @Override
    public ProductModel create(ProductModel productModel) {

        var product = ProductMapper.toEntity(productModel);
        var savedProduct = productRepository.save(product);


        return ProductMapper.toModel(savedProduct);
    }
}
