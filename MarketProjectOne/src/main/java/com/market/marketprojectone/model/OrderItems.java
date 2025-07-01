/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.market.marketprojectone.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author victus
 */
@Entity
@Table(name = "order_items")
@NamedQueries({
    @NamedQuery(name = "OrderItems.findAll", query = "SELECT o FROM OrderItems o"),
    @NamedQuery(name = "OrderItems.findByOrderId", query = "SELECT o FROM OrderItems o WHERE o.orderItemsPK.orderId = :orderId"),
    @NamedQuery(name = "OrderItems.findByProductId", query = "SELECT o FROM OrderItems o WHERE o.orderItemsPK.productId = :productId"),
    @NamedQuery(name = "OrderItems.findByQuantity", query = "SELECT o FROM OrderItems o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "OrderItems.findByUnitPrice", query = "SELECT o FROM OrderItems o WHERE o.unitPrice = :unitPrice")})
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderItemsPK orderItemsPK;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Products products;

    public OrderItems() {
    }

    public OrderItems(OrderItemsPK orderItemsPK) {
        this.orderItemsPK = orderItemsPK;
    }

    public OrderItems(OrderItemsPK orderItemsPK, int quantity, BigDecimal unitPrice) {
        this.orderItemsPK = orderItemsPK;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public OrderItems(long orderId, long productId) {
        this.orderItemsPK = new OrderItemsPK(orderId, productId);
    }

    public OrderItemsPK getOrderItemsPK() {
        return orderItemsPK;
    }

    public void setOrderItemsPK(OrderItemsPK orderItemsPK) {
        this.orderItemsPK = orderItemsPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderItemsPK != null ? orderItemsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItems)) {
            return false;
        }
        OrderItems other = (OrderItems) object;
        if ((this.orderItemsPK == null && other.orderItemsPK != null) || (this.orderItemsPK != null && !this.orderItemsPK.equals(other.orderItemsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.market.marketprojectone.model.OrderItems[ orderItemsPK=" + orderItemsPK + " ]";
    }
    
}
