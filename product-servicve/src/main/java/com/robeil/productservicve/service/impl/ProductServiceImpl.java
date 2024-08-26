package com.robeil.productservicve.service.impl;

import com.robeil.productservicve.dto.ProductRequest;
import com.robeil.productservicve.dto.ProductResponse;
import com.robeil.productservicve.model.Product;
import com.robeil.productservicve.repository.ProductRepository;
import com.robeil.productservicve.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ModelMapper modelMapper;
    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = modelMapper.map(productRequest,Product.class);
        repository.save(product);
        logger.info("Save Product : {} " + product);
        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        logger.info("getAllProduct Product : {} ");
        var listProduct = repository.findAll();

        return listProduct.stream()
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .collect(Collectors.toList());

    }
}
