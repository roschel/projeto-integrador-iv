package com.projeto.ecommerce.product;

import java.util.List;

import com.projeto.ecommerce.brand.BrandDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<ProductDTO> findAll(){
        List<ProductDTO> list = service.findAll();
        return list;
    }
    
}
