package com.projeto.ecommerce.color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.projeto.ecommerce.brand.BrandDTO;

public class ColorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public ColorDTO() {
    }

    public ColorDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ColorDTO(ColorEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
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
}