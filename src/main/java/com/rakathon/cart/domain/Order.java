package com.rakathon.cart.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @NotNull
    int orderNumber;
    @Column
    int memberId;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.EAGER )
    @Column
    List<Item> orderItems;
    @Column
    int totalAmount;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public List<Item> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Item> orderItems) {
        this.orderItems = orderItems;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
