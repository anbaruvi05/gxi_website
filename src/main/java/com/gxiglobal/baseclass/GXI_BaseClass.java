package com.gxiglobal.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GXI_BaseClass {

	public static WebDriver driver;
	public Properties pro;
	public static WebDriver browserlanch(String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\ANBARUVI\\eclipse-workspace\\GXI_Global\\Drivers\\newchromed.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\ANBARUVI\\eclipse-workspace\\GXI_Global\\Drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("gecko")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\ANBARUVI\\eclipse-workspace\\GXI_Global\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\ANBARUVI\\eclipse-workspace\\GXI_Global\\Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}else {
				System.out.println("Invalid browser");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;

	}
//Properties Class methods
	public void getProperty() throws Throwable {

		File files = new File(
				"C:\\Users\\ANBARUVI\\eclipse-workspace\\GXI_Global\\src\\main\\java\\com\\gxiglobal\\config\\User_Credentials.properties");
		FileInputStream fis = new FileInputStream(files);
		pro = new Properties();
		pro.load(fis);

	}

	public String getUrl() {
		String URL = pro.getProperty("webapplication");
		return URL;
		
	}
	
	public  String user_name() {
		String user_name = pro.getProperty("user_name");
		return user_name;
		
	}
	public  String user_password() {
		String user_pass = pro.getProperty("user_password");
		return user_pass;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 2.SLEEP---------------------------------------------------------------------
	public static void sleep(long value) throws InterruptedException {
		Thread.sleep(value);
	}

	// IMPLICIT-WAIT-----------------------------------------------------------------------

	public static void waitimplicit(long value) {
		driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
	}

	// EXPLICIT-WAIT-----------------------------------------------------------------------

	public static void waitexplicit(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// 3.GET-------------------------------------------------------------------------
	public static void url(String value) {
		driver.get(value);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// 4.ALERT---------------------------------------------------------------------------

	public static void alertok() {
		driver.switchTo().alert().accept();
	}

	public static void alertno() {
		driver.switchTo().alert().dismiss();

	}

	public static void promptalert(String value) {
		driver.switchTo().alert().sendKeys(value);
		driver.switchTo().alert().accept();
	}

	// 5.CLOSE------------------------------------------------------------------------
	public static void close() {
		driver.close();
	}

	// 6.QUIT------------------------------------------------------------------------

	public static void quit() {
		driver.quit();
	}

	// 7.NAVIGATE-TO-----------------------------------------------------------------

	public static void navigateto(String value) {
		driver.navigate().to(value);
	}

	// 8.NAVIGATE-BACK-----------------------------------------------------------------

	public static void navigateback() {
		driver.navigate().back();
	}

	// 9.NAVIGATE-FORWARD-----------------------------------------------------------------

	public static void navigateforward() {
		driver.navigate().forward();
	}

	// 10.NAVIGATE-REFRESH-----------------------------------------------------------------
	public static void navigaterefresh() {
		driver.navigate().refresh();
	}

	// 11.SENDKEYS--------------------------------------------------------------------
	public static void inputofElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	// 12.CLICK-------------------------------------------------------------------------

	public static void clickonElement(WebElement element) {
		element.click();
	}

	// 13.CLEAR

	public static void clearofelement(WebElement element) {
		element.clear();
	}

	// 14.ACTIONS---------------------------------------------------------------------------------------

	public static void action(WebElement element, String option, WebElement drop) {
		Actions ac = new Actions(driver);

		try {
			if (option.equalsIgnoreCase("movetoelement")) {
				ac.moveToElement(element).build().perform();
			} else if (option.equalsIgnoreCase("draganddrop")) {
				ac.dragAndDrop(element, drop).build().perform();
			} else if (option.equalsIgnoreCase("rightclick")) {
				ac.contextClick(element).build().perform();
			} else if (option.equalsIgnoreCase("click")) {
				ac.click().build().perform();
			} else {
				System.out.println("Invalid Mouse Action");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 15.ROBOT--------------------------------------------------------------------------

	public static void robot(String option) throws AWTException {
		Robot r = new Robot();

		try {
			if (option.equalsIgnoreCase("down")) {
				r.keyPress(KeyEvent.VK_DOWN);
			} else if (option.equalsIgnoreCase("enter")) {
				r.keyPress(KeyEvent.VK_ENTER);
			} else {
				System.out.println("Invalid Key Action");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 16.DROPDOWN----------------------------------------------------------------------

	public static void dropdown(WebElement element, String option, String value) {
		Select s = new Select(element);

		try {
			if (option.equalsIgnoreCase("byindex")) {
				int parseInt = Integer.parseInt(value);
				s.selectByIndex(parseInt);
			} else if (option.equalsIgnoreCase("byvalue")) {
				s.selectByValue(value);
			} else if (option.equalsIgnoreCase("byvisibletext")) {
				s.selectByVisibleText(value);
			} else {
				System.out.println("Invalid selection");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}

	// 17.TAKESCREENSHOT---------------------------------------------------------------------------

	public static void screenshot(String pic) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File desfile = new File(pic);
		FileUtils.copyFileToDirectory(srcfile, desfile);
		System.out.println("Pic taken");
	}
/*
	public static void screenshot(String string) throws Throwable   {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("dd_MM_YYYY - hh_mm_ss").format(new Date());
		File desFile = new File(string + timestamp);
		FileUtils.copyFileToDirectory(srcFile, desFile);
		System.out.println("Pic taken");
		
	}
*/
	
	
	// 18.JAVA-SCRIPT-EXECUTER-scroll-------------------------------------------------------------
	public static void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// 19.GETATTRIBUTE------------------------------------------------------------------------------

	public static void getattribute(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		System.out.println(attribute);

	}

	// 20.IS-ENABLE----------------------------------------------------------------------------------

	public static void isenabled(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}

	// 21.IS-DISPLAYED---------------------------------------------------------------------------------

	public static void isdisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}

	// 22.IS-SELECTED----------------------------------------------------------------------------------

	public static void isselected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println(selected);
	}

	// 23.GETTITLE----------------------------------------------------------------------------------

	public static void gettitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	// 24.GETCURRENT-URL----------------------------------------------------------------------------------

	public static void getcurrenturl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}

	// 25.GETTEXT-----------------------------------------------------------------------------------------

	public static void gettext(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	// 26.IS-MULTIPLE-----------------------------------------------------------------------------------

	public static void ismultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

	// 27.GETFIRSTSELECTEDOPTION--------------------------------------------------------------------------

	public static void getFirstSelectedOption(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption);
	}

	// 28.GETALLSELECTEDOPTION-----------------------------------------------------------------------------

	public static void getallselectedoption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		System.out.println(allSelectedOptions);
	}

	// 29.GET-OPTIONS----------------------------------------------------------------------------------------

	public static void getoptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		System.out.println(options);

	}

	// 30.Windows-Handling----------------------------------------------------------------------------------

	public static void idandtitle() {
		String s = driver.getWindowHandle();
		System.out.println(s);

		String title = driver.getTitle();
		System.out.println(title);
	}

	// ---------------------------------------------------------------

	public static void idsandtitles() {
		Set<String> handles = driver.getWindowHandles();
		for (String s : handles) {
			System.out.println(s);

			String title = driver.switchTo().window(s).getTitle();
			System.out.println(title);
		}
	}

	// ---------------------------------------------------------------------

	public static void noofwindows() {
		int size = driver.getWindowHandles().size();
		System.out.println("Number of windows:" + size);
	}

	// ---------------------------------------------------------------------

	public static void Windowshandling(String value) {
		String parentid = driver.getWindowHandle();
		System.out.println(parentid);

		Set<String> allid = driver.getWindowHandles();
		for (String id : allid) {
			System.out.println(id);
			String title = driver.switchTo().window(id).getTitle();
			System.out.println(title);
		}
		String actualvalue = value;
		for (String id : allid) {
			if (driver.switchTo().window(id).getTitle().equals(actualvalue)) {
				break;
			}
		}
	}

	// ---------------------------------------------------------------

	public static void Windowshandlingcloseallexceptvalue() {
		String parentid = driver.getWindowHandle();

		Set<String> allid = driver.getWindowHandles();
		for (String id : allid) {
			if (!id.equals(parentid)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
	}

	// FRAMES-----------------------------------------------------------------------

	public static void framebyindex(int i) {
		driver.switchTo().frame(i);
	}

	public static void framebystring(String value) {
		driver.switchTo().frame(value);
	}

	public static void framebyelementsendkeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void framebyelement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void framemain() {
		driver.switchTo().defaultContent();
	}

	// checkbox---------------------------------------------------------------------------

	public static void checkbox(WebElement element) {
		if (element.isSelected()) {
			element.click();

		}

	}






	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
