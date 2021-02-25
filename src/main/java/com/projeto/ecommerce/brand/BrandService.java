package com.projeto.ecommerce.brand;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

    @Transactional(readOnly = true)
    public List<BrandDTO> findAll(){
        List<BrandModel> list = repository.findAll();
        
        return list.stream().map(x -> new BrandDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public BrandModel insert(BrandModel brand) {
        BrandModel entity = repository.save(brand);

        return new BrandModel(entity);
    }

}
