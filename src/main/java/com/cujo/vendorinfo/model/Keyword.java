package com.cujo.vendorinfo.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Keyword {
	
	
	private BigDecimal id;
	private BigDecimal vendorId;
	private String keyword;	
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

}
