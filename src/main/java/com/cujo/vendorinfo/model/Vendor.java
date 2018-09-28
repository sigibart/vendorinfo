package com.cujo.vendorinfo.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Vendor {
	
	private BigDecimal id;
	private String vendorName;	
	private Timestamp createdAt;
	
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}	
}
