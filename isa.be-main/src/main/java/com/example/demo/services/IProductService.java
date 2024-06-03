package com.example.demo.services;

import com.example.demo.models.ProductModel;

public interface IProductService {

    ProductModel create(ProductModel productModel);
    ProductModel update(ProductModel productModel);


}
