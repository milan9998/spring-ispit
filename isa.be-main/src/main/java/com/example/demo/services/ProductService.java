package com.example.demo.services;

import com.example.demo.exceptions.BaseException;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.models.ProductModel;
import com.example.demo.repositories.IProductRepository;
import com.example.demo.repositories.IUserProductsRepository;
import com.example.demo.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ProductModel update(ProductModel productModel) {
        var entity = ProductMapper.toEntity(productModel);
        try{
            var result = productRepository.save(entity);
            return ProductMapper.toModel(result);
        }catch (BaseException e){
            throw new BaseException(e.getMessage());
        }


    }


  /*  public List<ProductModel> findAll(ProductModel productModel) {
        return ProductMapper.toModelList(productRepository.findAll());
    }*/
}
