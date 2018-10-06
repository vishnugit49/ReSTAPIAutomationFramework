package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.qa.base.BaseTest;

public class RestClient extends BaseTest{

	public void get(String url) {
		
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
		
			HttpGet getURL = new HttpGet(url);
		
			CloseableHttpResponse closeableHttpResponse = httpClient.execute(getURL);
		
			//To get status of the response
		
			int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
			System.out.println("ReST GET Request - Status Code..........."+statusCode);
		
			//To get JSON response
			String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			
			JSONObject responseJSON = new JSONObject(responseString);
			System.out.println("ReST GET Request - Response JSON..........."+responseJSON);
			
			//To get Header response
			Header[] headersArray = closeableHttpResponse.getAllHeaders();
			
			HashMap<String,String> allHeaders = new HashMap<String,String>();
			
			for(Header header : headersArray) {
				allHeaders.put(header.getName(), header.getValue());
			}
			
			System.out.println("ReST GET Request - Headers Resp..........."+allHeaders);
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(JSONException e) {
			e.printStackTrace();
		}
				
		
	}
}
