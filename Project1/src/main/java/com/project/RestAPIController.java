package com.project;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.inputparams.FinalBill;
import com.project.inputparams.FinalProduct;
import com.project.inputparams.InputPojo;
import com.project.services.BillingService;

@RestController
@CrossOrigin("*")
public class RestAPIController {

	@Autowired
	BillingService billingService;
	
	@RequestMapping(path="/processBill",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> processBill(@RequestBody List<InputPojo> productList,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BindingResult bindingResult){
		
		String authHeader = httpServletRequest.getHeader("Authorization");
		if(!"Basic YWRtaW46YWRtaW4=".equals(authHeader)){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\":\"You are not authorized\"}");
		}
		
		if(productList == null){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Invalid Products\"}");
		}
		else if(productList.isEmpty()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Invalid Products\"}");
		}
		
		FinalBill finalBill = null;
		try {
			finalBill = billingService.caculateBill(productList);
		}catch(Exception e){
			System.out.println("Exception occured while bill processing");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.ok().body(finalBill);
	}
}
