package com.projeto.ecommerce.size;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sizes")
public class SizeResource {

    @Autowired
    public SizeService service;


    @GetMapping
    public List<SizeDTO> findAll(){
        List<SizeDTO> list = service.findAll();

        return list;
    }
    
}
