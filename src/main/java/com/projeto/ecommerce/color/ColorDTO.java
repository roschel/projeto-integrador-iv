package com.projeto.ecommerce.color;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class ColorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
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
