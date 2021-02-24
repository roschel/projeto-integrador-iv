package com.projeto.ecommerce.services;

import java.util.List;

import com.projeto.ecommerce.entities.Model;
import com.projeto.ecommerce.repositories.ModelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ModelService {

    @Autowired
    private ModelRepository repository;

    @Transactional
    public List<Model> findAll(){
        List<Model> list = repository.findAll();
        return list;
    }

    @Transactional
    public Model insert(Model model) {
        Model entity = repository.save(model);

        return new Model(entity);
    }
}
