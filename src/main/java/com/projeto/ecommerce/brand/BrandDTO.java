package com.projeto.ecommerce.brand;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class BrandDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String brand;
    private Boolean delete;


    public BrandDTO() {
    }

    public BrandDTO(Long id, String brand, Boolean delete) {
        this.id = id;
        this.brand = brand;
        this.delete = delete;
    }

    public BrandDTO(BrandEntity entity){
        this.id = entity.getId();
        this.brand = entity.getBrand();
        this.delete = entity.getDelete();
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

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    
}
