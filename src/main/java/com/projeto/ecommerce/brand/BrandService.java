package com.projeto.ecommerce.brand;

import java.util.List;
import java.util.Optional;
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
        List<BrandEntity> list = repository.findAll();
        
        return list.stream().map(x -> new BrandDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public BrandDTO insert(BrandDTO dto) {
        BrandEntity entity = new BrandEntity();
        copyDTOToEntity(dto, entity);
        entity = repository.save(entity);

        return new BrandDTO(entity);
    }

    @Transactional
    public BrandDTO update (Long id, BrandDTO dto){
        BrandEntity entity = repository.getOne(id);
        copyDTOToEntity(dto, entity);
        entity = repository.save(entity);
        return new BrandDTO(entity);
    }

    @Transactional
    public String delete (Long id){
        Optional<BrandEntity> obj = repository.findById(id);
        BrandEntity entity = obj.orElseThrow();
        String retorno = "Marca "+ entity.getBrand() + " já se encontra deletada.";
        if (entity.getStatus()){
            entity.setStatus(false);
            retorno = "Marca "+ entity.getBrand() + " deletada com sucesso.";
        }
        return retorno;
    }

    private void copyDTOToEntity(BrandDTO dto, BrandEntity entity) {
        entity.setBrand(dto.getBrand());
        entity.setStatus(dto.getStatus());
    }

}
