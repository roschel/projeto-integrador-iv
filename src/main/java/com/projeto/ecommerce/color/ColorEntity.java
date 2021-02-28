package com.projeto.ecommerce.color;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.projeto.ecommerce.size.SizeEntity;
import com.projeto.ecommerce.size.key.ProductColorSize;

@Entity
@Table(name = "tb_color")
public class ColorEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToMany
//    @JoinTable(
//        name="tb_color_size",
//        joinColumns = @JoinColumn(name="color_id"),
//        inverseJoinColumns = @JoinColumn(name="size_id")
//    )
//    private Set<SizeEntity> sizes = new HashSet<>();

    @OneToMany(mappedBy = "colorEntity")
    Set<ProductColorSize> sizes;

    public ColorEntity() {
    }

    public ColorEntity(Long id, String name) {
        this.id = id;
        this.name = name;
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
        ColorEntity other = (ColorEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}