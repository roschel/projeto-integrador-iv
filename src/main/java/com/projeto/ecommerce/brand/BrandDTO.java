package com.projeto.ecommerce.brand;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.projeto.ecommerce.brand.color.ColorDTO;

public class BrandDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String brand;
    private String description;
    private String gender;

    private List<ColorDTO> colors = new ArrayList<>();

    public BrandDTO() {
    }

    public BrandDTO(Long id, String brand, String description, String gender) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.gender = gender;
    }

    public BrandDTO(BrandModel entity){
        this.id = entity.getId();
        this.brand = entity.getBrand();
        this.description = entity.getDescription();
        this.gender = entity.getGender();
        entity.getColors().forEach(color -> this.colors.add(new ColorDTO(color.getId(),color.getName())));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<ColorDTO> getColors() {
        return colors;
    }

    public void setColors(List<ColorDTO> colors) {
        this.colors = colors;
    }

    
}
