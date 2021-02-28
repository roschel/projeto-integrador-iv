package com.projeto.ecommerce.size;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SizeService {

    @Autowired
    private SizeRepository repository;

    @Transactional(readOnly = true)
    public List<SizeDTO> findAll(){
        List<SizeEntity> list = repository.findAll();
        
        return list.stream().map(x -> new SizeDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public SizeDTO insert(SizeDTO dto) {
        SizeEntity entity = new SizeEntity();
        copyDTOToEntity(dto, entity);
        entity = repository.save(entity);

        return new SizeDTO(entity);
    }

    private void copyDTOToEntity(SizeDTO dto, SizeEntity entity) {
        entity.setSize(dto.getSize());
    }
    
}
