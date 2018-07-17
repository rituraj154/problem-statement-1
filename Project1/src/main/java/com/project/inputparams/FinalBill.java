package com.project.inputparams;

import java.util.List;

public class FinalBill {

	private List<FinalProduct> finalProducts;
	private Double finalMrp;
	private Double finalTax;
	private Double totalAmount;
	
	
	public Double getFinalMrp() {
		return finalMrp;
	}

	public void setFinalMrp(Double finalMrp) {
		this.finalMrp = finalMrp;
	}

	public Double getFinalTax() {
		return finalTax;
	}

	public void setFinalTax(Double finalTax) {
		this.finalTax = finalTax;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<FinalProduct> getFinalProducts() {
		return finalProducts;
	}

	public void setFinalProducts(List<FinalProduct> finalProducts) {
		this.finalProducts = finalProducts;
	}
	
}
