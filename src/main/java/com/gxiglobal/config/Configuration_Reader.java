package com.gxiglobal.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Configuration_Reader {
	public Properties pro;
	public WebDriver driver;

	public void getProperty() throws Throwable {

		File files = new File(
				"C:\\Users\\ANBARUVI\\eclipse-workspace\\GXI_Global\\src\\main\\java\\com\\gxiglobal\\config\\User_Credentials.properties");
		FileInputStream fis = new FileInputStream(files);
		pro = new Properties();
		pro.load(fis);

	}

	public String getUrl() {
		String browser = pro.getProperty("webapplication");
		return browser;
		
	}
	
	public  String user_name() {
		String user_name = pro.getProperty("user_name");
		return user_name;
		
	}
	public  String user_password() {
		String user_pass = pro.getProperty("user_password");
		return user_pass;
	}
	
	
}
