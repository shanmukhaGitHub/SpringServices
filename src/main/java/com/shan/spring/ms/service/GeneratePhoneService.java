package com.shan.spring.ms.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shan.spring.ms.controller.GeneratePhoneNumbersController;
import com.shan.spring.ms.exception.GeneratePhoneBusinessExpection;
import com.shan.spring.ms.model.AlphaNumericPojo;


@Service
public class GeneratePhoneService {
	
	
	private static final Logger log = LoggerFactory.getLogger(GeneratePhoneService.class);

	 // String array to store keypad characters 
    static final String codes[] 
        = { " ", "abc", "def", 
            "ghi", "jkl", "mno", 
            "pqr", "stu", "vwx", 
            "yz" }; 
	
	@Autowired
	AlphaNumericPojo alphaNumericPojo;
	/**
     * get combination of phone numbers.
     * @param phoneNumer
     * @return
	 * @throws GeneratePhoneBusinessExpection 
     */
    public AlphaNumericPojo getPhoneCombinationList(String phoneNumer) throws GeneratePhoneBusinessExpection{
    	
    	validateString(phoneNumer);
    	List<String> phoneStrs = generateKeyWords(phoneNumer);
    	alphaNumericPojo.setPhoneLists(phoneStrs);
    	alphaNumericPojo.setAlphaNumericListSize(phoneStrs.size());
    	
    	return alphaNumericPojo;
    }
    
    
    
    private void validateString(String phoneNumer) throws GeneratePhoneBusinessExpection {
		
    	if(null!=phoneNumer &&( phoneNumer.length()<7 || phoneNumer.length()>10)){
    		throw new GeneratePhoneBusinessExpection("6000","Phone number length is incorrect", "Phone number should be between 7 to 10 characters");
    	}
    	log.info(phoneNumer.replaceAll("^[0-9]", "") +","+phoneNumer.replaceAll("-?\\d+", ""));
    	if(phoneNumer.replaceAll("-?\\d+", "").length()>0) {
    		throw new GeneratePhoneBusinessExpection("6001","Phone number should numbers only","Numerics are allowed");
    	}
		
	}



	// Function that returns an Arraylist 
    // which contains all the generated words 
    private  ArrayList<String> generateKeyWords(String str) 
    { 
  
    	
        // If str is empty 
        if (str.length() == 0) { 
            ArrayList<String> baseRes = new ArrayList<>(); 
            baseRes.add(""); 
  
            // Return an Arraylist containing 
            // empty string 
            return baseRes; 
        } 
  
        // First character of str 
        char ch = str.charAt(0); 
  
        // Rest of the characters of str 
        String restStr = str.substring(1); 
  
        ArrayList<String> prevRes = generateKeyWords(restStr); 
        ArrayList<String> Res = new ArrayList<>(); 
  
        String code = codes[ch - '0']; 
  
        for (String val : prevRes) { 
  
            for (int i = 0; i < code.length(); i++) { 
                Res.add(code.charAt(i) + val); 
            } 
            Res.add(ch + val); 
        } 
        return Res; 
    } 


}
