package com.projeto.ecommerce.product;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.projeto.ecommerce.brand.BrandEntity;
import com.projeto.ecommerce.color.ColorEntity;
import com.projeto.ecommerce.size.key.ProductColorSize;

@Entity
@Table(name = "tb_product")
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    @Column(columnDefinition = "TEXT")
    private String description;
    private Double rating;
    private String gender;
    private Boolean delete;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;

    @ManyToMany
    @JoinTable(
        name="tb_product_color",
        joinColumns = @JoinColumn(name="product_id"),
        inverseJoinColumns = @JoinColumn(name="color_id")
    )
    private Set<ColorEntity> colors = new HashSet<>();

    @OneToMany(mappedBy = "productEntity")
    Set<ProductColorSize> sizes;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String product, String description, Double rating, String gender, Boolean delete,
            Double price, BrandEntity brand) {
        this.id = id;
        this.product = product;
        this.description = description;
        this.rating = rating;
        this.gender = gender;
        this.delete = delete;
        this.price = price;
        this.brand = brand;
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

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }

    public Set<ColorEntity> getColors() {
        return colors;
    }


    public Set<ProductColorSize> getSizes() {
        return sizes;
    }

    public void setSizes(Set<ProductColorSize> sizes) {
        this.sizes = sizes;
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
        ProductEntity other = (ProductEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
