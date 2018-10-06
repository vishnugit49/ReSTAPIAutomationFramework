package com.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.client.RestClient;

public class GetAPITest extends BaseTest{

	BaseTest baseTest;
	String url;
	RestClient restClient;
	String c_serviceURL;
	
	@BeforeMethod
	public void setUp() {
		baseTest = new BaseTest();
		restClient = new RestClient();
		c_serviceURL = prop.getProperty("serviceURL");
	}
	
	@Test
	public void getAPITest() {
		String c_userPathURL = prop.getProperty("userPathURL");
		url = c_serviceURL+c_userPathURL;
		restClient.get(url);
	}
	
	@Test
	public void getAPTOneUserTest() {
		String c_oneUserPathURL = prop.getProperty("oneUserPathURL");
		url = c_serviceURL+c_oneUserPathURL;
		restClient.get(url);
	}
	
	@Test
	public void getAPTUserNotFoundTest() {
		String c_userNotFoundPathURL = prop.getProperty("userNotFoundPathURL");
		url = c_serviceURL+c_userNotFoundPathURL;
		restClient.get(url);
	}
	
	
	
}

