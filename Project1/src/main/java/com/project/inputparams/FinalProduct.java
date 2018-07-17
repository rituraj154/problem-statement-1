package com.project.inputparams;

public class FinalProduct {

	private String productName;
	private Integer productQuantity;
	private Double productMRP;
	private Double finalMRP;
	private Double salesTax;
	private Double finalTax;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public Double getProductMRP() {
		return productMRP;
	}
	public void setProductMRP(Double productMRP) {
		this.productMRP = productMRP;
	}
	public Double getFinalMRP() {
		return finalMRP;
	}
	public void setFinalMRP(Double finalMRP) {
		this.finalMRP = finalMRP;
	}
	public Double getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(Double salesTax) {
		this.salesTax = salesTax;
	}
	public Double getFinalTax() {
		return finalTax;
	}
	public void setFinalTax(Double finalTax) {
		this.finalTax = finalTax;
	}
	@Override
	public String toString() {
		return "FinalProduct [productName=" + productName + ", productQuantity=" + productQuantity + ", productMRP="
				+ productMRP + ", finalMRP=" + finalMRP + ", salesTax=" + salesTax + ", finalTax=" + finalTax + "]";
	}
	
	
	
	
}
