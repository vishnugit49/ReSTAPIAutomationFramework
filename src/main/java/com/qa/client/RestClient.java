package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.qa.base.BaseTest;

public class RestClient extends BaseTest{

	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet getHttpURL = new HttpGet(url);//http get request
			CloseableHttpResponse closeableHttpResponse = httpClient.execute(getHttpURL);//hit the get URL
			return closeableHttpResponse;		
	}
	
	public CloseableHttpResponse get(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getHttpURLWithHeader = new HttpGet(url);//http get request
		
		for(Map.Entry<String, String> entry : headerMap.entrySet())
		{
			getHttpURLWithHeader.addHeader(entry.getKey(),entry.getValue());
		}
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(getHttpURLWithHeader);//hit the get URL with header.
		return closeableHttpResponse;		
	}
	
}
