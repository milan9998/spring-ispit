package com.example.demo.services;

import com.example.demo.models.ProductModel;

import java.util.List;

public interface IProductService {

    ProductModel create(ProductModel productModel);
    ProductModel update(ProductModel productModel);
  //  List<ProductModel> findAll(ProductModel productModel);


}
