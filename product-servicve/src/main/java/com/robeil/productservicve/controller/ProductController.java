package com.robeil.productservicve.controller;

import com.robeil.productservicve.dto.ProductRequest;
import com.robeil.productservicve.dto.ProductResponse;
import com.robeil.productservicve.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return service.createProduct(productRequest);

    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse>  getAllProduct(){

        //for testing purpose
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
       return service.getAllProduct();
    }
}
