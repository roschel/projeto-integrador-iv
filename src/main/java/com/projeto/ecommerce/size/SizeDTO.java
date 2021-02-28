package com.projeto.ecommerce.size;

import java.io.Serializable;

import javax.validation.constraints.Positive;

public class SizeDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;

    @Positive(message = "Tamanho deve ser maior que zero")
    private Byte size;

    private Integer quantity;

    public SizeDTO() {
    }

    public SizeDTO(Long id, Byte size, Integer quantity) {
        this.id = id;
        this.size = size;
        this.quantity = quantity;
    }

    public SizeDTO(SizeEntity entity) {
        this.id = entity.getId();
        this.size = entity.getSize();
        this.quantity = entity.getQuantity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getSize() {
        return size;
    }

    public void setSize(Byte size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
