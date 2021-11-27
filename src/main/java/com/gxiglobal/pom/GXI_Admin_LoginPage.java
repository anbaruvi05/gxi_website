package com.gxiglobal.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GXI_Admin_LoginPage {

	public WebDriver driver;

	public GXI_Admin_LoginPage(WebDriver driverLoginPage) {

		this.driver = driverLoginPage;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user_login")
	private WebElement user_name;

	@FindBy(id = "user_pass")
	private WebElement user_password;

	@FindBy(id = "wp-submit")
	private WebElement click_on_login_btn;

	public WebElement getUser_name() {
		return user_name;
	}

	public WebElement getUser_password() {
		return user_password;
	}

	public WebElement getClick_on_login_btn() {
		return click_on_login_btn;
	}
}
