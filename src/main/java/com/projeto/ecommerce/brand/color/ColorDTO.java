package com.projeto.ecommerce.brand.color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.projeto.ecommerce.brand.BrandDTO;

public class ColorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private List<BrandDTO> models = new ArrayList<>();

    public ColorDTO() {
    }

    public ColorDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ColorDTO(ColorModel entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        entity.getModels().forEach(
                model -> this.models.add(new BrandDTO(model.getId(), model.getBrand(), model.getDescription(), model.getGender())));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BrandDTO> getModels() {
        return models;
    }

}
