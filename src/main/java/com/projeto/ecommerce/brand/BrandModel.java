package com.projeto.ecommerce.brand;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.projeto.ecommerce.brand.color.ColorModel;

@Entity
@Table(name = "tb_brand")
public class BrandModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String description;
    private String gender;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="tb_brand_color",
            joinColumns = @JoinColumn(name = "brand_id"), // chave estrangeira relacionada a classe onde estamos, ou seja, será o produto.(A própria classe)
            inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    private List<ColorModel> colors = new ArrayList<>();

    public BrandModel() {
    }

    public BrandModel(Long id, String brand, String description, String gender) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.gender = gender;
    }

    public BrandModel(BrandModel entity){
        this.id = entity.getId();
        this.brand = entity.getBrand();
        this.description = entity.getDescription();
        this.gender = entity.getGender();
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

    public List<ColorModel> getColors() {
        return colors;
    }

    public void setColors(List<ColorModel> colors) {
        this.colors = colors;
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
        BrandModel other = (BrandModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
