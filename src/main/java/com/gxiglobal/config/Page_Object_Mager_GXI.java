package com.gxiglobal.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.gxiglobal.pom.GXI_Admin_LoginPage;
import com.gxiglobal.pom.GXI_CategoriesPage;
import com.gxiglobal.pom.GXI_PostPage;
import com.gxiglobal.pom.GXI_TrashPage;

public class Page_Object_Mager_GXI {
	public WebDriver driver;
	private GXI_Admin_LoginPage loginpage;
	private GXI_PostPage postpage;
	private GXI_TrashPage trashpage;
	private GXI_CategoriesPage categoriespage;
	
	
	public Page_Object_Mager_GXI(WebDriver driverPOM) {
		this.driver=driverPOM;
		PageFactory.initElements(driver, this);
	
	}
	
	public GXI_Admin_LoginPage getAdminLoginPage() {
		
		loginpage =new GXI_Admin_LoginPage(driver);
		return loginpage;
	}
	
	public GXI_PostPage getPostPage() {
		
		postpage = new GXI_PostPage(driver);
		return postpage;
	}
	
	public GXI_TrashPage getTrashPage() {
		
		trashpage = new GXI_TrashPage(driver);
		return trashpage;
	}
	
	public GXI_CategoriesPage getCategoriesPage() {
		
		categoriespage = new GXI_CategoriesPage(driver);
		return categoriespage;
	}
	
}
