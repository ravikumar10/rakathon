package com.rakathon.cart.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddToCartRequestDTO {
    @JsonProperty("itemName")
    String itemName;

    @JsonProperty("itemQuantity")
    String itenQuantity;

    @JsonProperty("itemNumber")
    String itemNumber;

    @JsonProperty("memberId")
    String memberId;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItenQuantity() {
        return itenQuantity;
    }

    public void setItenQuantity(String itenQuantity) {
        this.itenQuantity = itenQuantity;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }
}
