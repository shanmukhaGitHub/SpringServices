package com.shan.spring.ms.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shan.spring.ms.exception.GeneratePhoneBusinessExpection;
import com.shan.spring.ms.model.AlphaNumericPojo;
import com.shan.spring.ms.service.GeneratePhoneService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class GeneratePhoneNumberServiceTest {
	
	@Autowired
	GeneratePhoneService service;

	@Test
	public void test_getPhoneCombinationListWhenValidationFailed() {
		AlphaNumericPojo alphaNumericPojoExpected = new AlphaNumericPojo();
		try {
		AlphaNumericPojo alphaNumericPojoResult = service.getPhoneCombinationList("12");
		alphaNumericPojoExpected.setPhoneLists(alphaNumericPojoResult.getPhoneLists());
		alphaNumericPojoExpected.setAlphaNumericListSize(16);
		}catch (GeneratePhoneBusinessExpection e) {
			assertThat(e);
		}
	}
	
	@Test
	public void test_getPhoneCombinationList() throws GeneratePhoneBusinessExpection {
		AlphaNumericPojo alphaNumericPojoExpected = new AlphaNumericPojo();
		AlphaNumericPojo alphaNumericPojoResult = service.getPhoneCombinationList("00000001");
		alphaNumericPojoExpected.setPhoneLists(alphaNumericPojoResult.getPhoneLists());
		alphaNumericPojoExpected.setAlphaNumericListSize(512);
		assertArrayEquals(alphaNumericPojoExpected.getPhoneLists().toArray(), alphaNumericPojoResult.getPhoneLists().toArray());
	}
}
