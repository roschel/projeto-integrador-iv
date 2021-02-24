package com.projeto.ecommerce.resources;

import java.net.URI;
import java.util.List;

import com.projeto.ecommerce.entities.Brand;
import com.projeto.ecommerce.services.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/brands")
public class BrandResource {

    @Autowired
    private BrandService service;

    @GetMapping
    public List<Brand> findAll(){
        List<Brand> list = service.findAll();
        return list;
    }

    @PostMapping
    public ResponseEntity<Brand> insert(@RequestBody Brand brand){
        brand = service.insert(brand);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(brand.getId())
                .toUri();
        return ResponseEntity.created(uri).body(brand);
    }

}
