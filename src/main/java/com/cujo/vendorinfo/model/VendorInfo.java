package com.cujo.vendorinfo.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class VendorInfo {
	
	private BigDecimal id;
	private BigDecimal vendorId;
	private String vendorInfo;	
	private Timestamp createdAt;
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getVendorId() {
		return vendorId;
	}
	public void setVendorId(BigDecimal vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorInfo() {
		return vendorInfo;
	}
	public void setVendorInfo(String vendorInfo) {
		this.vendorInfo = vendorInfo;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}
