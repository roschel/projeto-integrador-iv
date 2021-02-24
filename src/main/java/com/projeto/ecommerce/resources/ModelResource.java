package com.projeto.ecommerce.resources;

import java.net.URI;
import java.util.List;

import com.projeto.ecommerce.entities.Model;
import com.projeto.ecommerce.services.ModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/models")
public class ModelResource {

    @Autowired
    private ModelService service;

    @GetMapping
    public List<Model> findAll(){
        List<Model> list = service.findAll();
        return list;
    }

    @PostMapping
    public ResponseEntity<Model> insert(@RequestBody Model model){
        model = service.insert(model);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(model.getId())
                .toUri();
        return ResponseEntity.created(uri).body(model);
    }

}
