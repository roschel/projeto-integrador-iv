package com.projeto.ecommerce.product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projeto.ecommerce.brand.BrandEntity;

@Entity
@Table(name = "tb_product")
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private String description;
    private Double rating;
    private String gender;
    private Boolean status;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "tb_brand")
    private BrandEntity brand;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String product, String description, Double rating, String gender, Boolean status,
            Double price, BrandEntity brand) {
        this.id = id;
        this.product = product;
        this.description = description;
        this.rating = rating;
        this.gender = gender;
        this.status = status;
        this.price = price;
        this.brand = brand;
    }

    public ProductDTO(ProductEntity entity) {
        this.id = entity.getId();
        this.product = entity.getProduct();
        this.description = entity.getDescription();
        this.rating = entity.getRating();
        this.gender = entity.getGender();
        this.status = entity.getStatus();
        this.price = entity.getPrice();
        this.brand = entity.getBrand();
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
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

}
