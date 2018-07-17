package com.project.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.inputparams.FinalBill;
import com.project.inputparams.FinalProduct;
import com.project.inputparams.InputPojo;

@Service
public class BillingService {

	@Autowired
	Map<String, Double> levyMap;
	public FinalBill caculateBill(List<InputPojo> productList) throws Exception{
		Double finalTax = 0D;
		Double finalMrp = 0D;
		Double totalCost = 0D;
		DecimalFormat df = new DecimalFormat("0.00");
		List<FinalProduct> finalProducts = new ArrayList<FinalProduct>();
		for(InputPojo pro: productList){
			Double tax = levyMap.get(pro.getProductCategory());
			FinalProduct finalProduct = new FinalProduct();
			if(tax != null && tax>=0){
				Double theTax = pro.getProductMRP()*pro.getProductQuantity()*(tax/100);
				Double firstMrp = theTax+pro.getProductMRP();
				finalTax+=theTax;
				finalMrp+=pro.getProductMRP()*pro.getProductQuantity();
				totalCost+=firstMrp;
				finalProduct.setSalesTax(Double.valueOf(df.format(tax)));
				finalProduct.setProductName(pro.getProductName());
				finalProduct.setProductMRP(pro.getProductMRP());
				finalProduct.setProductQuantity(pro.getProductQuantity());
				finalProduct.setFinalTax(Double.valueOf(df.format(theTax)));
				finalProduct.setFinalMRP(Double.valueOf(df.format(pro.getProductMRP()*pro.getProductQuantity())));
				finalProducts.add(finalProduct);
			}else{
				throw new Exception("{\"error\":\"Invalid product category\"}");
			}
		}
		FinalBill finalBill = new FinalBill();
		finalBill.setFinalProducts(finalProducts);
		finalBill.setFinalMrp(Double.valueOf(df.format(finalMrp)));
		finalBill.setFinalTax(Double.valueOf(df.format(finalTax)));
		finalBill.setTotalAmount(Double.valueOf(df.format(finalMrp+finalTax)));
		return finalBill;
	}
}
