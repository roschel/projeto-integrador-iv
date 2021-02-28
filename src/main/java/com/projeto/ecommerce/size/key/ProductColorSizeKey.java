package com.projeto.ecommerce.size.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductColorSizeKey implements Serializable {

    @Column(name = "product_id")
    Long productId;

    @Column(name = "color_id")
    Long colorId;

    @Column(name = "size")
    Long size;

    public ProductColorSizeKey() {
    }

    public ProductColorSizeKey(Long productId, Long colorId, Long size) {
        this.productId = productId;
        this.colorId = colorId;
        this.size = size;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long sizeId) {
        this.size = sizeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductColorSizeKey that = (ProductColorSizeKey) o;
        return Objects.equals(productId, that.productId) && Objects.equals(colorId, that.colorId) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, colorId, size);
    }
}
