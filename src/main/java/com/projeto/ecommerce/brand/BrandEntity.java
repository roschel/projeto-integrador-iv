package com.projeto.ecommerce.brand;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.projeto.ecommerce.product.ProductEntity;

@Entity
@Table(name = "tb_brand")
public class BrandEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private Boolean delete;

    @OneToMany(mappedBy = "product")
    private Set<ProductEntity> products= new HashSet<>();

    public BrandEntity() {
    }

    public BrandEntity(Long id, String brand, Boolean delete) {
        this.id = id;
        this.brand = brand;
        this.delete=delete;
    }

    public BrandEntity(BrandDTO dto){
        this.id = dto.getId();
        this.brand = dto.getBrand();
        this.delete = dto.getDelete();
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
        BrandEntity other = (BrandEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    

}
