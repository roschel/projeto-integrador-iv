package com.projeto.ecommerce.brand;

import java.io.Serializable;

public class BrandDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String brand;
    private Boolean status;


    public BrandDTO() {
    }

    public BrandDTO(Long id, String brand, Boolean status) {
        this.id = id;
        this.brand = brand;
        this.status = status;
    }

    public BrandDTO(BrandEntity entity){
        this.id = entity.getId();
        this.brand = entity.getBrand();
        this.status = entity.getStatus();
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    
}
