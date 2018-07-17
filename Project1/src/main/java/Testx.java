import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.inputparams.FinalProduct;
import com.project.inputparams.InputPojo;

import java.text.DecimalFormat;
import java.util.*;
public class Testx {
	
	@Test
	public void other(){
		int input = 11;
		int prev = 1;
		int prev1 = -1;
		int current = 0;
		int count = 0;
	    while(count<input){
	        current = prev+prev1;
	        prev1=prev;
	        prev = current;
	        System.out.println(current);
	        count++;
	    }
		
	}
	
@Test
@Ignore
public void getList() throws JsonProcessingException{
	InputPojo inputPojo = new InputPojo();
	inputPojo.setProductCategory("A");
	inputPojo.setProductName("PRODUCT1");
	inputPojo.setProductMRP(23.32);
	inputPojo.setProductQuantity(4);
	InputPojo inputPojo1 = new InputPojo();
	inputPojo1.setProductCategory("B");
	inputPojo1.setProductName("PRODUCT2");
	inputPojo1.setProductMRP(23.32);
	inputPojo1.setProductQuantity(2);
	InputPojo inputPojo2 = new InputPojo();
	inputPojo2.setProductCategory("C");
	inputPojo2.setProductName("PRODUCT3");
	inputPojo2.setProductMRP(23.32);
	inputPojo2.setProductQuantity(3);
	InputPojo inputPojo3 = new InputPojo();
	inputPojo3.setProductCategory("A");
	inputPojo3.setProductName("PRODUCT4");
	inputPojo3.setProductMRP(23.32);
	inputPojo3.setProductQuantity(5);
	List<InputPojo> inputList = new ArrayList();
	inputList.add(inputPojo);
	inputList.add(inputPojo1);
	inputList.add(inputPojo2);
	inputList.add(inputPojo3);
	ObjectMapper objectMapper = new ObjectMapper();
	String write = objectMapper.writeValueAsString(inputList);
	
	
	final Map<String, Double> taxMap = new HashMap<>(3);
	taxMap.put("A", 10D);
	taxMap.put("B", 10D);
	taxMap.put("C", 0D);
	Double finalTax = 0D;
	Double finalMrp = 0D;
	Double totalCost = 0D;
	List<FinalProduct> finalProducts = new ArrayList();
	for(InputPojo pro: inputList){
		Double tax = taxMap.get(pro.getProductCategory());
		FinalProduct finalProduct = new FinalProduct();
		if(tax != null && tax>=0){
			Double theTax = pro.getProductMRP()*pro.getProductQuantity()*(tax/100);
			Double firstMrp = theTax+pro.getProductMRP();
			finalTax+=theTax;
			finalMrp+=pro.getProductMRP()*pro.getProductQuantity();
			totalCost+=firstMrp;
			finalProduct.setSalesTax(tax);
			finalProduct.setProductName(pro.getProductName());
			finalProduct.setProductMRP(pro.getProductMRP());
			finalProduct.setProductQuantity(pro.getProductQuantity());
			finalProduct.setFinalTax(theTax);
			finalProduct.setFinalMRP(pro.getProductMRP()*pro.getProductQuantity());
			finalProducts.add(finalProduct);
		}else{
			
		}
		
		
	}
	
	System.out.println(write);
	System.out.println("\n\n\n");
	System.out.println(new String(Base64.getDecoder().decode("RUFJU1RBR0lOR1VTRVI6RUFJMjAxOCM=")));
	
}
}
