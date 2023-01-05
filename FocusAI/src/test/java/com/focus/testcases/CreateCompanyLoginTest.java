package com.focus.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.focus.Pages.CreateCompanyLoginPage;
import com.focus.Pages.HomeMenuPage;
import com.focus.Pages.LoginPage;
import com.focus.base.BaseEngine;
//import com.focus.supporters.ExcelReader;
import com.focus.supporters.ExcelReader;
import com.focus.utilities.POJOUtility;
import com.focus.Pages.LoginPage;




public class CreateCompanyLoginTest extends BaseEngine
{
	private static LoginPage lp;
	private static ExcelReader excelReader;
	private static final DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");


	
	//@Test(priority=4)
	public void verifyTheCreateCompanyText() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		
		
		ExcelReader excelReader=new ExcelReader(POJOUtility.getExcelPath());
		   
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		
		String url=excelReader.getCellData("Sheet1", 1, 0);
	    String lgnTitle=excelReader.getCellData("Sheet2", 1, 2);
	    
	    String inputCompName=excelReader.getCellData("Sheet2", 1, 4);
	    
	    
	    String inputPassword=excelReader.getCellData("Sheet2", 1, 7); 
	    String getCalenderText=excelReader.getCellData("Sheet2", 1, 8);
	    String getCountryq=excelReader.getCellData("Sheet2", 1, 9);
	    String getGlobalCurrencyValues=excelReader.getCellData("Sheet2", 1, 10);
	    String getExpectedcompmsg=excelReader.getCellData("Sheet2", 1, 11);
	          
	       Thread.sleep(2000);
	       
	       cco.clickOnCompanyCreateBtn();
	      
	       Thread.sleep(2000);
	       
	       System.out.println("verifyTheCreateCompanyText");
	
	        Assert.assertEquals(cco.verifyCreateCompanyTitles(), lgnTitle);
	     
	  	   
	}
	
	
	//@Test(priority=5)
	public void verifyTheFieldsInCreateCompanyPage() throws InterruptedException
	{
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		Assert.assertEquals(cco.verifyAvailablityOfCreateCompanyFields(), true);
		
	}
	
	

	//@Test(priority=6)
	public void verifyCompanyNameAsMandatory() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ExcelReader excelReader=new ExcelReader(POJOUtility.getExcelPath());
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		
		String getcompyErrMsg=excelReader.getCellData("Sheet2", 1, 3);
		
		cco.clickOnOk();
	       
	    String erc=cco.getCompanyNameError();
	       
		Assert.assertEquals(erc, getcompyErrMsg);
		
	}
	
	
	
	//@Test(priority=7)
	public void verifyPasswordAsMandatory() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		System.out.println("****enter in the Pasword mandatory*******");
		
		ExcelReader excelReader=new ExcelReader(POJOUtility.getExcelPath());
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		
		String inputCompName=excelReader.getCellData("Sheet2", 1, 4);
		String getPasswordErrMsg=excelReader.getCellData("Sheet2", 1, 5);
		
		System.out.println("****enter in the Company Name *******");
		
		cco.enterCompanyName(inputCompName);

	    cco.clickOnOk();
	       
	    String erPasMsg=cco.getPasswordError();
	    
	    Assert.assertEquals(erPasMsg, getPasswordErrMsg);
	       
	       
	}
	
	
	//@Test(priority=8)
	public void verifyCalenderType() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ExcelReader excelReader=new ExcelReader(POJOUtility.getExcelPath());
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		
		 String inputPassword=excelReader.getCellData("Sheet2", 1, 7); 
		 
		
		 cco.enterSuPasssord(inputPassword);
	       
	     cco.getCalenderCount();
	     
	     Assert.assertEquals(cco.getSelectedCalender(), true);
		
		
	}
	
	
	//@Test(priority=9)
	public void verifyCalenderValues() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ExcelReader excelReader=new ExcelReader(POJOUtility.getExcelPath());
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		
		String getCalenderValue=excelReader.getCellData("Sheet2", 1, 6);
			
		Assert.assertEquals(cco.getCalenderValues(), getCalenderValue);
		
	}
	
	
	
	//@Test(priority=10)
	public void verifyDateFormatValue() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ExcelReader excelReader=new ExcelReader(POJOUtility.getExcelPath());
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		
		Date date=new Date();
	
		Assert.assertEquals(cco.getAccountingDate(), sdf.format(date));
		
	}
	
	
	//@Test(priority=11)
	public void verifyCountryDefaultValue() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ExcelReader excelReader=new ExcelReader(POJOUtility.getExcelPath());
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		
		
		Assert.assertEquals(cco.getSelectedCountry(), true);
	}
	
	
	
	//@Test(priority=12)
	public void verifyCountryValues() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ExcelReader excelReader=new ExcelReader(POJOUtility.getExcelPath());
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		
		String getCountryq=excelReader.getCellData("Sheet2", 1, 9);
		
		Assert.assertEquals(getCountryq, cco.getCountryValues());
		
		
	}
	
	
	
	
	//@Test(priority=13)
	public void verifyGlobalCurrency() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		ExcelReader excelReader=new ExcelReader(POJOUtility.getExcelPath());
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		
		String getGlobalCurrencyValues=excelReader.getCellData("Sheet2", 1, 10);
		
		Assert.assertEquals(cco.getCurrencyValues(), getGlobalCurrencyValues); 
		
	}
	
	//@Test(priority=14)
	public void verifyDefaultLanguage()
	{
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
	
		Assert.assertEquals(cco.getDefaultLanguageCount(), 1);
		
	}
	
	
	
	//@Test(priority=15)
	public void verifyDefaultLanguageAfterSelectingOtherLanguage()
	{
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		cco.checkArabicLanguage();
		
		Assert.assertEquals(cco.getDefaultLanguageCount(), 2);
		
	}
	
	
	
	
	//@Test(priority=16)
	public void verifyDefaultLangaugeAfterUnSelectingOtherLanguage()
	{
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		cco.unCheckArabicLanguage();
		
		Assert.assertEquals(cco.getDefaultLanguageCount(), 1);
		
	}
	
	
	//@Test(priority=17)
	public void verifyDefaultLangaugeAfterCheckUncheckAndCheckOtherLanguage()
	{
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		cco.checkArabicLanguage();
		
		Assert.assertEquals(cco.getDefaultLanguageCount(), 2);
		
	}

	
	//@Test(priority=18)
	public void verifyAlertCompanyCreation() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		
		ExcelReader excelReader=new ExcelReader(POJOUtility.getExcelPath());
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		
		 String getExpectedCompMsg=excelReader.getCellData("Sheet2", 1, 11);
		
		 cco.clickOnLogo();
	     
	     Thread.sleep(2000);
	     
	     Runtime.getRuntime().exec("E:\\ZFocusAI\\FocusAI\\autoIt\\scripts\\FocusCompanyLogo.exe");
	     
	     Thread.sleep(2000);
	     
	     cco.clickOnOk();
	      
	     cco.waitForAlert();
	     
	     String actCompanySaveMsg=cco.getAlert().getText();
	     
	     Assert.assertEquals(actCompanySaveMsg, getExpectedCompMsg);
	     
	     cco.getAlert().accept();
	     
		
	}
	
	
	
	//@Test(priority=18)
		public void verifyAlertCompanyScreenUpdate() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			
			//ExcelReader excelReader=new ExcelReader(POJOUtility.getExcelPath());
			CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
			
			 String getExpectedCompMsg="Company updated successfully";
			
			 //cco.clickOnLogo();
		     
		     //Thread.sleep(2000);
		     
		     //Runtime.getRuntime().exec("E:\\ZFocusAI\\FocusAI\\autoIt\\scripts\\FocusCompanyLogo.exe");
		     
		     //Thread.sleep(2000);
		     
		     cco.clickOnOk();
		      
		     cco.waitForAlert();
		     
		     String actCompanySaveMsg=cco.getAlert().getText();
		     
		     Assert.assertEquals(actCompanySaveMsg, getExpectedCompMsg);
		     
		     cco.getAlert().accept();
		     
			
		}
	
	
	
	//@Test(priority=19)
	public void verifyLoginScreenAfterCompanyCreation()
	{
		 lp=new LoginPage(getDriver());
		
		 Assert.assertEquals(lp.verifyLoginPageAfterCompanyCreation(), true);

      
	}
	
	
	//@Test(priority=20)
	public void verifyCompanyListCheckAfterCompanyCreation() throws InterruptedException
	{
		
		lp.getCompanyFromCompanyListAfterCompanyCreate();
		
		CreateCompanyLoginPage cclp=new CreateCompanyLoginPage(getDriver());
		
		
		
		Assert.assertEquals(cclp.getCompanyListIsCreatingAfterCreatingCompany(), true);
		
	}
	
	
	
	//@Test(priority=21)
	public void verifySuperUserAsMandatoryInLoginScreen() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		
		lp=new LoginPage(getDriver());	
		Assert.assertEquals(lp.verifyMandatoryFieldCheckForSuperUserName(), true);
		//Thread.sleep(9900);
		
		
	}
	
	
	//@Test(priority=22)
	public void verifyPasswordAsMandatoryInLoginScreen() throws InterruptedException
	{
		lp=new LoginPage(getDriver());
		Assert.assertEquals(lp.verifyMandatoryFieldCheckForPassword(), true);
		//Thread.sleep(9900);
		
	}

	//@Test(priority=23)
	public void verifySuperUserAsInvalidInLoginScreen() throws InterruptedException
	{
		lp=new LoginPage(getDriver());
		Assert.assertEquals(lp.verifyInvalidSuperUserName(), true);
		//Thread.sleep(9900);
	}
  
	
	//@Test(priority=24)
	public void verifyPasswordAsInvalidInLoginScreen() throws InterruptedException
	{
		lp=new LoginPage(getDriver());
		Assert.assertEquals(lp.verifyInvalidPassword(), true);
		//Thread.sleep(9900);
		
	}
	
	
	        //User Creates the Company and Login the Company 
			@Test(priority=25) 
			public void verifyValidLoginTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
			{

			         lp=new LoginPage(getDriver());
			         
			         excelReader=new ExcelReader(POJOUtility.getExcelPath());
			       
			         String unamelt=excelReader.getCellData("Sheet2",1,0);
			       
			         String pawslt=excelReader.getCellData("Sheet2", 1, 1);
			         
			         System.out.println("1******************************************");
			       
		             System.out.println(unamelt);
			            
		             //Thread.sleep(2000);
		             
		             System.out.println("2******************************************");
		             
		             lp.enterUserName(unamelt);
		             
		             System.out.println("3******************************************");
		       
		             lp.enterPassword(pawslt);
		             
		             System.out.println("4******************************************");
		        
		             
		             lp.clickOnSignInBtn();
		            
		            //Thread.sleep(2000);
		            
		            Assert.assertEquals(lp.verifyUserHomePageAndDashBoard(), true);
		            
		            System.out.println("5******************************************");

			}
			
	
	    
		
		//@Test(priority=26)
		public void verifyMenuCount()
		{
			
			CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
			//System.out.println("The Value of the count is : "+cco.getHomeMenuCount());
			
			cco.clickOnCompanyMenu();
		}
		
		//@Test(priority=27)
		public void verifyHomemenuDisplay() throws InterruptedException
		{
			
			HomeMenuPage hmp=new HomeMenuPage(getDriver());
			
			Assert.assertEquals(hmp.verifyCompanySubMenus(),true);
			
			
			
			//CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
			//cco.clickOnCompanyMenu();
		
			
		}
		
	
	
}
