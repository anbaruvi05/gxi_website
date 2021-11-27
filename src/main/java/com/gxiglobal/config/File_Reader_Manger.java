package com.gxiglobal.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class File_Reader_Manger {
	public Configuration_Reader config;
	public WebDriver driver;

	public File_Reader_Manger(WebDriver driverfileReader) {
		this.driver=driverfileReader;
		PageFactory.initElements(driver, this);
	}

	public Configuration_Reader GetConfiguration() {
		config = new Configuration_Reader();
		return config;

	}

}
