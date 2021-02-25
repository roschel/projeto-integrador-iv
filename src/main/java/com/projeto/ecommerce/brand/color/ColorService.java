package com.projeto.ecommerce.brand.color;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ColorService {

    @Autowired
    private ColorRepository repository;

    @Transactional
    public List<ColorDTO> findAll(){
        List<ColorModel> list = repository.findAll();
        return list.stream().map(x -> new ColorDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public ColorModel insert(ColorModel brand) {
        ColorModel entity = repository.save(brand);

        return new ColorModel(entity);
    }

}
