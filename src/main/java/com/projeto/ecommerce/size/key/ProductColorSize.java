package com.projeto.ecommerce.size.key;

import com.projeto.ecommerce.color.ColorEntity;
import com.projeto.ecommerce.product.ProductEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="tb_product_color_size")
public class ProductColorSize {

    @EmbeddedId
    ProductColorSizeKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @ManyToOne
    @MapsId("colorId")
    @JoinColumn(name = "color_id")
    private ColorEntity colorEntity;

    private Integer quantity;

    public ProductColorSize() {
    }

    public ProductColorSize(ProductColorSizeKey id, ProductEntity productEntity, ColorEntity colorEntity, Integer quantity) {
        this.id = id;
        this.productEntity = productEntity;
        this.colorEntity = colorEntity;
        this.quantity = quantity;
    }

    public ProductColorSizeKey getId() {
        return id;
    }

    public void setId(ProductColorSizeKey id) {
        this.id = id;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public ColorEntity getColorEntity() {
        return colorEntity;
    }

    public void setColorEntity(ColorEntity colorEntity) {
        this.colorEntity = colorEntity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
