package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

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
