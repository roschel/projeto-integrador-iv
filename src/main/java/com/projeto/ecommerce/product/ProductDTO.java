package com.projeto.ecommerce.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.projeto.ecommerce.brand.BrandDTO;
import com.projeto.ecommerce.color.ColorDTO;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Size(min = 5, max = 60, message = "Máximo de 60 caracteres")
    @NotBlank(message = "Campo obrigatório")
    private String product;

    @Size(max = 1000, message = "Máximo de 1000 caracteres")
    private String description;

    @Positive(message = "Avaliação deve ser um valor maior do que 0")
    private Double rating;
    private String gender;
    private Boolean delete;

    @Positive(message = "Preço deve ser um valor maior do que 0")
    private Double price;

    private BrandDTO brand;

    Set<ColorDTO> colors = new HashSet<>();

    public ProductDTO() {
    }

    public ProductDTO(Long id, String product, String description, Double rating, String gender, Boolean delete,
            Double price) {
        this.id = id;
        this.product = product;
        this.description = description;
        this.rating = rating;
        this.gender = gender;
        this.delete = delete;
        this.price = price;
    }

    public ProductDTO(ProductEntity entity) {
        this.id = entity.getId();
        this.product = entity.getProduct();
        this.description = entity.getDescription();
        this.rating = entity.getRating();
        this.gender = entity.getGender();
        this.delete = entity.getDelete();
        this.price = entity.getPrice();
        this.brand = new BrandDTO(entity.getBrand());
        entity.getColors().forEach(color -> this.colors.add(new ColorDTO(color)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductDTO other = (ProductDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Set<ColorDTO> getColors() {
        return colors;
    }

    public void setColors(Set<ColorDTO> colors) {
        this.colors = colors;
    }

}
