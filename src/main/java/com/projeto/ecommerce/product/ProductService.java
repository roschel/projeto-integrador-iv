package com.projeto.ecommerce.product;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.projeto.ecommerce.brand.BrandEntity;
import com.projeto.ecommerce.color.ColorDTO;
import com.projeto.ecommerce.color.ColorEntity;
import com.projeto.ecommerce.color.ColorRepository;
import com.projeto.ecommerce.size.SizeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ColorRepository colorRepository;    

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<ProductEntity> list = repository.findAll();
        
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        copyDTOToEntity(dto, entity);
        entity = repository.save(entity);

        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
		ProductEntity entity = repository.getOne(id);
        copyDTOToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
	}

    @Transactional
    public String delete (Long id){
        Optional<ProductEntity> obj = repository.findById(id);
        ProductEntity entity = obj.orElseThrow();
        String retorno = "Produto "+ entity.getProduct() + " já se encontra deletada.";
        if (!entity.getDelete()){
            entity.setDelete(true);
            retorno = "Produto "+ entity.getBrand() + " deletado com sucesso.";
        }
        return retorno;
    }

    private void copyDTOToEntity(ProductDTO dto, ProductEntity entity) {
        entity.setProduct(dto.getProduct());
        entity.setDescription(dto.getDescription());
        entity.setGender(dto.getGender());
        entity.setPrice(dto.getPrice());
        entity.setRating(dto.getRating());
        entity.setDelete(dto.getDelete());
        entity.setBrand(new BrandEntity(dto.getBrand()));

        entity.getColors().clear();
        for (ColorDTO colorDto : dto.getColors()){
            Optional<ColorEntity> colorObj = colorRepository.findById(colorDto.getId());
            ColorEntity color = colorObj.orElseThrow();
            entity.getColors().add(color);
        }

        // entity.getColors().forEach(color -> color.getSizes().clear());
        // Set<SizeDTO> sizes = entity.getColors().forEach(color -> color.getSizes());
        // for (SizeDTO sizeDto : sizes);

        // }
    }

}
