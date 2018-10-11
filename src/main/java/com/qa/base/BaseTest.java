package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

	public int RESPONSE_STATE_CODE_200 = 200;
	public int RESPONSE_STATE_CODE_500 = 500;
	public int RESPONSE_STATE_CODE_400 = 400;
	public int RESPONSE_STATE_CODE_401 = 401;
	public int RESPONSE_STATE_CODE_201 = 201;
	
	
	
	public Properties prop;
	
	public BaseTest() {
		
		try {
			prop = new Properties();
			FileInputStream fo = new FileInputStream("C:\\GCVSEL\\RestAPI\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fo);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
