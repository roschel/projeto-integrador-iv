package com.projeto.ecommerce.services;

import javax.transaction.Transactional;

import com.projeto.ecommerce.entities.Product;
import com.projeto.ecommerce.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public List<Product> findAll() {
        List<Product> list = repository.findAll();
        return list;
    }

    @Transactional
    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);

        Product product = obj.orElseThrow();

        return product;
    }

    @Transactional
    public Product insert(Product product) {
        Product entity = repository.save(product);

        return new Product(entity);
    }

    @Transactional
    public Product update(Long id, Product product) {
        Product entity = repository.getOne(id);
        copyProductToEntity(product, entity);
        entity = repository.save(entity);
        return entity;
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);

    }

    private void copyProductToEntity(Product product, Product entity) {
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setQuantity(product.getQuantity());
        entity.setImgUrl(product.getImgUrl());
        entity.setPrice(product.getPrice());
    }

}
