package com.shan.spring.ms.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AlphaNumericPojo {
	
	Integer alphaNumericListSize;
	List<String> phoneLists;

}
