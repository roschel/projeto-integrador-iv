package com.projeto.ecommerce.color;

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
        List<ColorEntity> list = repository.findAll();
        return list.stream().map(x -> new ColorDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public ColorDTO insert(ColorDTO dto) {
        ColorEntity entity = new ColorEntity();
        copyDTOToEntity(dto, entity);
        entity = repository.save(entity);

        return new ColorDTO(entity);
    }


    private void copyDTOToEntity(ColorDTO dto, ColorEntity entity) {
        entity.setName(dto.getName());
    }

}
