package com.gxiglobal.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GXI_CategoriesPage {

	public WebDriver driver;

	public GXI_CategoriesPage(WebDriver drivercategories) {
		this.driver = drivercategories;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[contains(text(),'Categories')])[1]")
	private WebElement click_Categories;

	public WebElement getClick_Categories() {
		return click_Categories;
	}

	public WebElement getClick_bulk_categories_btn() {
		return click_bulk_categories_btn;
	}

	public WebElement getClick_checkbox_categories_btn() {
		return click_checkbox_categories_btn;
	}

	public WebElement getClick_apply_categories_btn() {
		return click_apply_categories_btn;
	}

	@FindBy(xpath = "//*[@id='bulk-action-selector-top']")
	private WebElement click_bulk_categories_btn;

	@FindBy(xpath = "//*[@id='cb-select-all-1']")
	private WebElement click_checkbox_categories_btn;

	@FindBy(xpath = "//*[@id='doaction']")
	private WebElement click_apply_categories_btn;

}
