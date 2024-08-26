package com.robeil.productservicve.service;

import com.robeil.productservicve.dto.ProductRequest;
import com.robeil.productservicve.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
    List<ProductResponse>  getAllProduct();
}
