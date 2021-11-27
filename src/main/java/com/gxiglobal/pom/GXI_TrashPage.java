package com.gxiglobal.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GXI_TrashPage {

public WebDriver driver;
	
	public GXI_TrashPage(WebDriver drivertrash) {
		this.driver=drivertrash;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "(//*[contains(text(),'Trash ')])[2]")
	private WebElement trash_btn;
	
	public WebElement getTrash_btn() {
		return trash_btn;
	}

	public WebElement getClick_bulk_action() {
		return click_bulk_action;
	}

	public WebElement getClick_checkbox() {
		return click_checkbox;
	}

	public WebElement getTrash_apply_btn() {
		return trash_apply_btn;
	}

	@FindBy(xpath = "//*[@id='bulk-action-selector-top']")
	private WebElement click_bulk_action;
	
	@FindBy(xpath = "//*[@id='cb-select-all-1']")
	private WebElement click_checkbox;
	
	@FindBy(xpath = "//*[@id='doaction']")
	private WebElement trash_apply_btn;
	
	
	
	
	
	
}
