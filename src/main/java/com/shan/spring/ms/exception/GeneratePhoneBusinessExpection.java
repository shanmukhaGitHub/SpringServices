package com.shan.spring.ms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneratePhoneBusinessExpection extends Exception{

	private String errorCode;
	private String errorDesc;
	private String errorInDetails;
	
	
	
}
