package com.charterdemo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Purchase {

    private int id;

    private int userId;

    private Date date;

    private BigDecimal subtotal;

    private BigDecimal taxes;

    private BigDecimal total;
    
    public Purchase(int id, int userId, Date date, BigDecimal subtotal,
		    BigDecimal taxes, BigDecimal total) {
	this.id = id;
	this.userId = userId;
	this.date = date;
	this.subtotal = subtotal;
	this.taxes = taxes;
	this.total = total;
    }

    public Date getDate() {
	return date;
    }

    public int getId() {
	return id;
    }

    public BigDecimal getSubtotal() {
	return subtotal;
    }

    public BigDecimal getTaxes() {
	return taxes;
    }

    public BigDecimal getTotal() {
	return total;
    }

    public int getUserId() {
	return userId;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public void setId(Integer id) {
	this.id = id.intValue();
    }

    public void setSubtotal(BigDecimal subtotal) {
	this.subtotal = subtotal;
    }

    public void setTaxes(BigDecimal taxes) {
	this.taxes = taxes;
    }

    public void setTotal(BigDecimal total) {
	this.total = total;
    }

    public void setUserId(Integer userId) {
	this.userId = userId.intValue();
    }

    @Override
    public String toString() {
	return getUserId() + " -> " + getSubtotal();
    }
}
