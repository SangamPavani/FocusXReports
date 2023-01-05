package com.focus.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.focus.supporters.ExcelReader;
//import com.focus.utilities.DriverUtility;

import com.focus.utilities.DriverUtility;
import com.focus.utilities.POJOUtility;
import com.focus.utilities.ScreenshotUtility;


//@Listeners(com.focus.listeners.Listener.class)
@Listeners(com.focus.listeners.Listener.class)

public class BaseEngine {

	private static WebDriver driver;
	private static String baseDir;
	private static String tcName;
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	private static Logger logger;
	private static WebDriverWait wait;

	private String filePath;
	private FileInputStream fip;
	private FileOutputStream fop;
	private Workbook workbook;
	private Sheet sheet;
	private Cell cell;
	private CellStyle style;
	private Row row;
	private String res=null;
	
	private String xlfile="\\E:\\ZFocusAI\\TestData.xls";
	
	  @Parameters("browser")
	  @BeforeSuite
	  public void openBrowser(@Optional("chrome")String browser)
	  {
		
		baseDir=System.getProperty("user.dir");
		PropertyConfigurator.configure(baseDir + "\\log4j.properties");
		
	
			
		if(browser.equalsIgnoreCase("chrome"))
		{	
			System.setProperty(DriverUtility.chromeKey,baseDir+DriverUtility.chromeValue);
			driver=new ChromeDriver();
			initActivities();
		}
		
		if(browser.equalsIgnoreCase("ie"))
		{	
			System.setProperty(DriverUtility.ieKey, baseDir+DriverUtility.ieValue);
			driver=new InternetExplorerDriver();
			initActivities();
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(DriverUtility.firefoxKey, baseDir+DriverUtility.firefoxValue);
			driver=new FirefoxDriver();
			initActivities();
		}
		
		
		  
	  }
	
	  
	  public void initActivities()
	  {
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
	  }
	  
	  @BeforeMethod
      public void beforeMethodExecution(Method method)
      {
		  tcName=method.getName();
		  System.out.println("tc started");
		  logger = Logger.getLogger(BaseEngine.class);
		  
		  getLogger().info("Currently Executing Test Case Name is : "+ tcName);
		  extentTest=extentReports.startTest(tcName);
      }
	  
	  @AfterMethod
	  public void afterMethodExecution(ITestResult result) throws IOException, EncryptedDocumentException, InvalidFormatException
	  {
		  
		  //ExcelReader excelReader=new ExcelReader(POJOUtility.getExcelPath());
		  
		  System.out.println(res);
		  System.out.println(result.getStatus());
		  
		  if (result.getStatus()==ITestResult.SUCCESS)
		  {
			  res="Pass";
			  getLogger().info("Test Case is Passed : " + tcName);
			  //excelReader.setCellData(xlfile, "Sheet3", 0, 0, res);
			  extentTest.log(LogStatus.PASS, "Test Case is Passed  : " + tcName);
			  System.out.println("Pass : Test Case is Passed from after Method : " + tcName);
		  }
		  else if(result.getStatus()==ITestResult.FAILURE)
		  {
			  res="Fail";
			  getLogger().info("Test Case is Failed : " + tcName + "So Taking the Screenshot");
			  //excelReader.setCellData(xlfile, "Sheet3", 0, 1, res);
			  extentTest.log(LogStatus.FAIL, "Test Case is Failed : " + tcName);
			  ScreenshotUtility.screenshot();
			  System.out.println("Fail : Test Case is Failed from after Method : " + tcName);
			  
		  }
		  else if(result.getStatus()==ITestResult.SKIP)
		  {
			  res="Skip";
			  getLogger().info("Test Case is Skipped : " + tcName + "So Taking the Screenshot");
			  //excelReader.setCellData(xlfile, "Sheet3", 0, 2, res);
			  extentTest.log(LogStatus.SKIP, "Test Case is Skipped : " + tcName);
			  ScreenshotUtility.screenshot();
			  System.out.println("Skip : Test Case is Skipped after Method : " + tcName);
		  }
		  
		  
		  
	  }
	  
	  
	  @AfterSuite
	  public void closeBrowser()
	  {
		  if(driver==null)
		  {
			  getLogger().info("Driver is pointing to Null : @AfterSuite");
		  }
		  else
		  {
			  driver.close();
		  }
	  }
	  
	  
	  
	
	  
	  @BeforeTest
	  public void intialiseReports()
	  {
			
		  
		  extentReports =new ExtentReports(baseDir+"\\reports\\FocusAutomationReport.html");
		  extentReports.assignProject("FocusAI");
	  }
	  
	  
	  
	  @AfterTest
	  public void generateReports()
	  {
		  extentReports.flush();
		  extentReports.endTest(extentTest);
	  }

	  
  
	  public static String getTCName()
	  {
		  return tcName;
	  }
	  
	  public static String getBaseDir()
	  {
		  return baseDir;
	  }
	  
	  public static WebDriver getDriver()
	  {
		  return driver;
	  }
	  
	  public static ExtentTest getExtentTest()
	  {
		  return extentTest;
	  }
	  
	  public static Logger getLogger()
	  {
		  return logger;
	  }
	  
	   public static void enterUrl(String url) 
	   {
			getDriver().get(url);
	   }
	   
	   public static Actions getAction()
	   {
		   Actions action=new Actions(driver);
		   return action;
	
		   
	   }
	   
	   
	   
	   public static Wait getWebDriverWait()
	   {
		   
		    wait = new WebDriverWait(getDriver(), 30);
		    return wait;
		   
	   }
  
	
}
