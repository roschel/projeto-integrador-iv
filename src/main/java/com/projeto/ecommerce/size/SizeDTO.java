package com.projeto.ecommerce.size;

import java.io.Serializable;

import javax.validation.constraints.Positive;

public class SizeDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;

    @Positive(message = "Tamanho deve ser maior que zero")
    private Byte size;

    public SizeDTO() {
    }

    public SizeDTO(Long id, Byte size) {
        this.id = id;
        this.size = size;
    }

    public SizeDTO(SizeEntity entity) {
        this.id = entity.getId();
        this.size = entity.getSize();
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
}
