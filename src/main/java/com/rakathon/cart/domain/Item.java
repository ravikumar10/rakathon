package com.rakathon.cart.domain;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {

    private static final long serialVersionUID = 1L;

    @JsonProperty("itemNumber")
    @Id
    @NotNull
    int itemNumber;

    @JsonProperty("itemName")
    @Column
    String itemName;

    @JsonProperty("quantity")
    @Column
    int quantity;

    @JsonProperty("priceEachQuantity")
    @Column
    int priceEachQuantity;

    @JsonProperty("price")
    @Column
    private BigDecimal price;

    @JsonProperty("imageUrl")
    @Column
    private String imageUrl;

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPriceEachQuantity() {
        return priceEachQuantity;
    }

    public void setPriceEachQuantity(int priceEachQuantity) {
        this.priceEachQuantity = priceEachQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemNumber=" + itemNumber +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", priceEachQuantity=" + priceEachQuantity +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
