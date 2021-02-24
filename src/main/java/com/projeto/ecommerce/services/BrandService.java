package com.projeto.ecommerce.services;

import java.util.List;

import com.projeto.ecommerce.entities.Brand;
import com.projeto.ecommerce.repositories.BrandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

    @Transactional
    public List<Brand> findAll(){
        List<Brand> list = repository.findAll();
        return list;
    }

    @Transactional
    public Brand insert(Brand brand) {
        Brand entity = repository.save(brand);

        return new Brand(entity);
    }

}
