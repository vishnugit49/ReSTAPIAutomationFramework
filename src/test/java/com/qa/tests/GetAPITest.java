package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

public class GetAPITest extends BaseTest{

	BaseTest baseTest;
	String url;
	RestClient restClient;
	String c_serviceURL;
	CloseableHttpResponse closeableHttpResponse;
	
	@BeforeMethod
	public void setUp() {
		baseTest = new BaseTest();
		restClient = new RestClient();
		c_serviceURL = prop.getProperty("serviceURL");
	}
	
	@Test
	public void getAPIWithoutHeaderTest() throws ParseException, IOException, JSONException {
		restClient = new RestClient();
		String c_userPathURL = prop.getProperty("userPathURL");
		url = c_serviceURL+c_userPathURL;
		
		closeableHttpResponse = restClient.get(url);
		
		//a. Status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code..................."+statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATE_CODE_200, "Status code is not 200");
		
		//b. Json String
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response String............."+responseJson);
		
		//Single value assertion
		//per_page
		String perPageValue = TestUtil.getValueByJPath(responseJson, "/per_page");
		System.out.println("Per Page:........................"+perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 3);
		
		//total
		String totalValue = TestUtil.getValueByJPath(responseJson, "/total");
		System.out.println("Per Page:........................"+totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		//get the value from JSON Array
		String lastName = TestUtil.getValueByJPath(responseJson, "/data[0]/last_name");
		String id = TestUtil.getValueByJPath(responseJson, "/data[0]/id");
		String avatar = TestUtil.getValueByJPath(responseJson, "/data[0]/avatar");
		String firstName = TestUtil.getValueByJPath(responseJson, "/data[0]/first_name");
		Assert.assertEquals(lastName, "Bluth");
		Assert.assertEquals(id, "1");
		Assert.assertEquals(avatar, "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
		Assert.assertEquals(firstName, "George");
		
		
		//c. All Headers
		Header[] headerArray = closeableHttpResponse.getAllHeaders(); //storing in array.
		HashMap<String,String> allHeader = new HashMap<String, String>(); //storing in HashMap.
		for(Header header : headerArray) {
			allHeader.put(header.getName(), header.getValue());
		}
		System.out.println("All Headers..................."+allHeader);
	}
	
	
	
	@Test
	public void getAPIWithHeaderTest() throws ParseException, IOException, JSONException {
		restClient = new RestClient();
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		//headerMap.put("UserName", "user1");
		//headerMap.put("Password", "user1");
		//headerMap.put("Authorization-Token", "sdfdsew3kjkdsfjkw45k2j");
		//
		
		String c_userPathURL = prop.getProperty("userPathURL");
		url = c_serviceURL+c_userPathURL;
		
		closeableHttpResponse = restClient.get(url,headerMap);
		
		//a. Status code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code..................."+statusCode);
		Assert.assertEquals(statusCode, RESPONSE_STATE_CODE_200, "Status code is not 200");
		
		//b. Json String
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response String............."+responseJson);
		
		//Single value assertion
		//per_page
		String perPageValue = TestUtil.getValueByJPath(responseJson, "/per_page");
		System.out.println("Per Page:........................"+perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 3);
		
		//total
		String totalValue = TestUtil.getValueByJPath(responseJson, "/total");
		System.out.println("Per Page:........................"+totalValue);
		Assert.assertEquals(Integer.parseInt(totalValue), 12);
		
		//get the value from JSON Array
		String lastName = TestUtil.getValueByJPath(responseJson, "/data[0]/last_name");
		String id = TestUtil.getValueByJPath(responseJson, "/data[0]/id");
		String avatar = TestUtil.getValueByJPath(responseJson, "/data[0]/avatar");
		String firstName = TestUtil.getValueByJPath(responseJson, "/data[0]/first_name");
		Assert.assertEquals(lastName, "Bluth");
		Assert.assertEquals(id, "1");
		Assert.assertEquals(avatar, "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
		Assert.assertEquals(firstName, "George");
		
		
		//c. All Headers
		Header[] headerArray = closeableHttpResponse.getAllHeaders(); //storing in array.
		HashMap<String,String> allHeader = new HashMap<String, String>(); //storing in HashMap.
		for(Header header : headerArray) {
			allHeader.put(header.getName(), header.getValue());
		}
		System.out.println("All Headers..................."+allHeader);
	}
	
	
}

