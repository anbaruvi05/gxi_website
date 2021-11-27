package com.gxiglobal.testrunner;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.gxiglobal.baseclass.GXI_BaseClass;
import com.gxiglobal.config.Page_Object_Mager_GXI;

public class GXI_PostDelete_Runner_TestNG extends GXI_BaseClass {

	public Logger log;
	
	
	@BeforeSuite
	public void setUp() {
		log = Logger.getLogger("GXI_Post_Delete_TestNG_Project");
		BasicConfigurator.configure();
		log.info("Launch Edge Broswer");
		browserlanch("edge");
		log.info("Launch Application Url");
		url("https://gxiglobal.com/wp-login.php?loggedout=true&wp_lang=en_US");
		ExtentSparkReporter report = new ExtentSparkReporter("TestNG.html");
		ExtentReports rep = new ExtentReports();
		rep.attachReporter(report);
		ExtentTest test = rep.createTest("TestNG_Report");
		rep.flush();
	}

	@Test
	public void loginPage() {
		Page_Object_Mager_GXI pom = new Page_Object_Mager_GXI(driver);
		log.info("Enter the Username");
		inputofElement(pom.getAdminLoginPage().getUser_name(),"naveen");
		log.info("Enter the Password");
		inputofElement(pom.getAdminLoginPage().getUser_password(), "galaxyXInnovations@21");
		log.info("Click on Login");
		clickonElement(pom.getAdminLoginPage().getClick_on_login_btn());
	}

	@Test(enabled = false,invocationCount = 18)
	public void postPage()  {
		Page_Object_Mager_GXI pom = new Page_Object_Mager_GXI(driver);
		log.info("Click on Post_Button");
		clickonElement(pom.getPostPage().getPost_page_btn());
		log.info("Select Trash from the Dropdown");
		dropdown(pom.getPostPage().getBulk_drop_down_btn(), "byvalue", "trash");
		log.info("Click on select All");
		clickonElement(pom.getPostPage().getSelect_all_btn());
		log.info("Click on Apply Button");
		clickonElement(pom.getPostPage().getClick_apply_btn());
	}

	@Test(enabled = false,invocationCount = 18)
	public void trashPage()  {
		Page_Object_Mager_GXI pom = new Page_Object_Mager_GXI(driver);
		log.info("Click on Trash Button");
		clickonElement(pom.getTrashPage().getTrash_btn());
		log.info("Click on Select All Button");
		dropdown(pom.getTrashPage().getClick_bulk_action(), "byvalue", "delete");
		log.info("Click on Check box Button");
		clickonElement(pom.getTrashPage().getClick_checkbox());
		log.info("Click on Apply Button");
		clickonElement(pom.getTrashPage().getTrash_apply_btn());

	}
	@Test(enabled = false,priority = 1,invocationCount = 4 )
	public void categoriesPage() throws Throwable {
		Page_Object_Mager_GXI pom = new Page_Object_Mager_GXI(driver);
		log.info("Click on Post_Button");
		clickonElement(pom.getPostPage().getPost_page_btn());
		log.info("Click on Categories Button");
		clickonElement(pom.getCategoriesPage().getClick_Categories());
		log.info("Click on select all Button");
		dropdown(pom.getCategoriesPage().getClick_bulk_categories_btn(), "byvalue", "delete");
		log.info("Click on Checkbox Button");
		clickonElement(pom.getCategoriesPage().getClick_checkbox_categories_btn());
		log.info("Click on Apply Button");
		clickonElement(pom.getCategoriesPage().getClick_apply_categories_btn());
		screenshot("Screenshot");
	}

	@AfterSuite
	public void tearDown() {

		driver.close();
	}

}
