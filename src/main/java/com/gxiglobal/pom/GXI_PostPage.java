package com.gxiglobal.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GXI_PostPage {

	
	public WebDriver driver;
	
	public GXI_PostPage(WebDriver driverpost) {
		this.driver=driverpost;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//*[@class='wp-menu-name'])[2]")
	private WebElement post_page_btn;
	
	public WebElement getPost_page_btn() {
		return post_page_btn;
	}

	public WebElement getBulk_drop_down_btn() {
		return bulk_drop_down_btn;
	}

	public WebElement getSelect_all_btn() {
		return select_all_btn;
	}

	public WebElement getClick_apply_btn() {
		return click_apply_btn;
	}

	@FindBy(xpath = "//*[@name='action']")
	private WebElement bulk_drop_down_btn;
	
	@FindBy(xpath= "//*[@id='cb-select-all-1']")
	private WebElement select_all_btn;
	
	@FindBy(xpath = "//*[@id='doaction']")
	private WebElement click_apply_btn;
	
	
	
	
	
	
	
	
}
