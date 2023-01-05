package com.focus.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.focus.Pages.CreateCompanyLoginPage;
import com.focus.Pages.HomeMenuPage;
import com.focus.Pages.LoginPage;
import com.focus.Pages.WrapperLayoutPage;
import com.focus.base.BaseEngine;
import com.graphbuilder.math.ExpressionParseException;


public class HomeMenuCompanySubMenuTest extends BaseEngine
{
	
	HomeMenuPage hmp;
	CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
	CreateCompanyLoginTest cclt;
	LoginPage lp=new LoginPage(getDriver());
	LoginPageTest lpt=new LoginPageTest();

	
	//@Test(priority=26) 
	public void checkHomeMenu() throws InterruptedException
	{
		hmp=new HomeMenuPage(getDriver());
		hmp.verifyHomeMenu();
		
	}
	
	///@Test(priority=27) 
	public void checkHomeMenuSubMenu() throws InterruptedException
	{
		
	
		hmp.VerifyHomeMenuSubMenus();
	    
		
	}
	
	//@Test(priority=28) 
	public void checkHomeMenuCompanySubMenu()
	{
		hmp.verifyCompanySubMenus();
		
	}
	
	//@Test(priority=29) 
	public void checkHomeMenuCompanySubMenuOpenCompany() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{
		hmp.openOpenCompany();
		
		//LoginPageTest lpt=new LoginPageTest();
        lpt.verifyTheAvaibilityOfFieldsInLoginScreen();
	}
	
	
	
	//@Test(priority=30)
	public void checkCancelOptionInOpenCompany() throws InterruptedException
	{
		hmp.verifyCancelOptionInOpenCompany();
		//LoginPage lp=new LoginPage(getDriver());
		Assert.assertEquals(lp.verifyUserHomePageAndDashBoard(), true);
		
	}
	
	
	
	//@Test(priority=31)
	public void checkCreateCompanyInOpencompany() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{

		hmp.openOpenCompany();
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());

		hmp.openCreateCompanyFromOpenCompany();
		
		Assert.assertEquals(cco.verifyAvailablityOfCreateCompanyFields(), true);
		
		
	}
	
	

	//@Test(priority=32)
	public void checkCancelOptionInCreateCompanyWhenUserSelectThroughOpenCompany() throws InterruptedException
	{
		//CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		cco.clickOnCancelBuutonInCompanyCreation();
		
		Assert.assertEquals(lp.verifyUserHomePageAndDashBoard(), true);
	}

	
	
	
	
	//@Test(priority=33)
	public void checkSignInOptionWhenUserSelectThroughOpenCompany() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		hmp.openOpenCompany();
		
		lp.signInWithRememberMyPassword();
		
		Assert.assertEquals(lp.verifyUserHomePageAndDashBoard(), true);
		
		
	}
	
	
	//Company Menu // New // Create Company Starts
	//Verify Create Company option in New //Company //Home
	//@Test(priority=34)
	public void verifyCreateCompanyWhenUserSelectFromNew()
	{
		
		hmp.verifyNewCompanyOptionCreateCompany();
		
	}
	
	
	//verify Title or Page Name as Create Company
	//@Test(priority=35)
	public void verifyPageNameForCreateCompany()
	{
		
		hmp.getCompanyTitleAsCreateCompany();
	}
	
	
	//Verify Fields in the Create Company
	//@Test(priority=36)
	public void verifyFieldsInCreateCompany() throws InterruptedException
	{
		CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		Assert.assertEquals(cco.verifyAvailablityOfCreateCompanyFields(), true);
	}
	
	
	//Verify Mandatory Fields Check in the Create Company
	//@Test(priority=37)
	public void verifyCompanyNameAsMandatoryInCreateCompany() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyCompanyNameAsMandatory();
	}
	
	
	//Verify Password as Mandatory Field Check in the Create Company
	//@Test(priority=38)
	public void verifyPasswordAsmandatoryInCreateCompany() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyPasswordAsMandatory();
	}

	
	//Verify Calendar Type Check in the Create Company
	//@Test(priority=39)
	public void verifyCalendarTypeInCreateCompany() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyCalenderType();
	}
	
	//Verify Calendar Values Check in the Create Company
	//@Test(priority=40)
	public void verifyCaledarValuesInCreateCompany() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyCalenderValues();
	}
	
	
	//Verify Date Format Check in the Create Company
	//@Test(priority=41)
	public void verifyDateFormatValueInCreateCompany() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyDateFormatValue();
	}
	
	
	//Verify Verify Country Default Value Check in the Create Company
	//@Test(priority=42)
	public void verifyCountryDefaultValueInCreateCompany() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyCountryDefaultValue();
	}
	
	
	//Verify Country Values Check in the Create Company
    //@Test(priority=43)
	public void verifyCountryValuesInCreateCompany() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
    	CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyCountryValues();
	}
	
	//Verify Global Currency Values Check in the Create Company
    //@Test(priority=44)
	public void verifyGlobalCurrencyInCreateCompany() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
    	CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyGlobalCurrency();
	}
	
    
    //Verify Default Language Check in the Create Company
    //@Test(priority=45)
	public void verifyDefaultLanguageInCreateCompany() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
    	CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyDefaultLanguage();
	}
    
    //Verify Default Language After Selecting OtherLanguage Check in the Create Company
    //@Test(priority=46)
	public void verifyDefaultLanguageAfterSelectingOtherLanguageInCreateCompany() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
    	CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyDefaultLanguageAfterSelectingOtherLanguage();
	}
    
    
    //Verify Default Language After UnSelecting Other Language Check in the Create Company
   // @Test(priority=47)
	public void verifyDefaultLangaugeAfterUnSelectingOtherLanguageInCreateCompany() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
    	CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyDefaultLangaugeAfterUnSelectingOtherLanguage();
	}
    
    
    
    //Verify select alternative and uncheck and check the language Check in the Create Company
    //@Test(priority=48)
	public void verifyDefaultLangaugeAfterCheckUncheckAndCheckOtherLanguage() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
    	CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyDefaultLangaugeAfterCheckUncheckAndCheckOtherLanguage();
	}
    
    
    //Verify verify Alert Company Creation Check in the Create Company
    //@Test(priority=49)
	public void verifyAlertCompanyCreationInCreateCompany() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
    	CreateCompanyLoginTest cclt=new CreateCompanyLoginTest();
		cclt.verifyAlertCompanyCreation();
	}
    
    
    
    //Verify Company Screen is displaying or not after creating the Company
    //@Test(priority=50)
    public void verifySuperUserDashboardAfterCompanyCreationFromNew() throws InterruptedException
    {
    	LoginPage lp=new LoginPage(getDriver());
    	
    	if(hmp.getCompanyTitleAsCreateCompany()==true)
    	{
    		hmp.clickonCancelButtonInCreateCompany();
    	}
    	else
    	{
    	
    		Assert.assertEquals(lp.verifyUserHomePageAndDashBoard(), true);
    	}
    		
    	
    }
    
    
    
	
    
    //Verify Edit Company Screen is displaying or not
    //@Test(priority=51)
    public void verifyEditCompanyScreen()
    {
    	HomeMenuPage hmp=new HomeMenuPage(getDriver());
    	hmp.clickOnEditCompany();
    	
    }
    
    
    //Verify Company Creation fields are displaying or not
    //@Test(priority=52)
    public void verifyEditCompanyFieldsAvialability() throws InterruptedException
    {
    	
    	CreateCompanyLoginPage cclo=new CreateCompanyLoginPage(getDriver());
    	//cclo.verifyAvailablityOfCreateCompanyFieldsInEditCompany();
    	Assert.assertEquals(cclo.verifyAvailablityOfCreateCompanyFieldsInEditCompany(), true);
    	
    }
	
    
    //Check the About Focus Patch Release date, so shifting to wrapper layout class and checking and getting the date of Patch
    //@Test(priority=53)
    public void checkAvailibityOfOptionsInWrapperLayout()
    {
    	WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
    	Assert.assertEquals(wlp.checkAvailibityOfOptionsInWrapperLayout(), true);
    	
    	
    }
	
    
    //Click on aboutIdQuickAccessMenu in the Wrapper Layout
    //@Test(priority=54)
    public void clickOnaboutIdQuickAccessMenu() throws InterruptedException
    {
    	WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
    	Assert.assertEquals(wlp.checkAboutIdQuickAccessMenu(), true);
    	
    	
    }
    
    
    //Click on About
    //@Test(priority=55)
    public void checkOptionsInAbout() throws InterruptedException
    {
    	WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
    	Assert.assertEquals(wlp.clickOnAbout(), true);
        	
    	
    }
    
    
    //update the Company and check alert is displaying
    //@Test(priority=56)
    public void chekUpdateOnEditCompanyScreen() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
    {
    	 HomeMenuPage hmp=new HomeMenuPage(getDriver());
    	
    	 hmp.editCompanyScreenUpdateTheCompanyName();
    			
		 String getExpectedCompMsg="Company updated successfully";
			         
		 CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
	
	     cco.waitForAlert();
	     
	     String actCompanySaveMsg=cco.getAlert().getText();
	     
	     System.out.println("getExpectedCompMsg"+getExpectedCompMsg);
	     System.out.println("actCompanySaveMsg"+actCompanySaveMsg);
	     
	     Assert.assertEquals(actCompanySaveMsg,getExpectedCompMsg);

	     cco.getAlert().accept();
	     
    }
    
    
   

    
	 //Check Updated Company Name is displaying in the Edit Company Name 
	 //@Test(priority=57)
	 public void checkCompanyNameUpdateInCompanyEdit() throws InterruptedException
	 {
		 HomeMenuPage hmp=new HomeMenuPage(getDriver());
	
		 hmp.clickOnCancelInEditScreen();

	     Assert.assertEquals(hmp.checkPatchDateAgainForComparsion(), true);
	     
		
	 }
    
    
	 //Check Updated Persian Language is displaying in the Edit Company Name 
	 //@Test(priority=58)
	 public void checkPersianUpdateInCompanyEdit() throws InterruptedException
	 {
		 HomeMenuPage hmp=new HomeMenuPage(getDriver());
	
         hmp.clickOnSaveAndUpdateLanguage();
         
         hmp.checkUpdateLanguageAlert();
		
	 }
	 
	 
	 
    /*//Click on aboutIdQuickAccessMenu in the Wrapper Layout here we are getting release date again to compare
	    @Test(priority=54)
        public void verifyCompanyNamePatchDateUpdateCompany() throws InterruptedException
        {

	    	 HomeMenuPage hmp=new HomeMenuPage(getDriver());
      
	    	 Assert.assertEquals(hmp.getPatchAfterCompanyUpdateLogoutLogin(), true);
        	
  
        	
        }*/
	 
	 
	 
	 //Check Updated Persian Language is displaying in the Edit Company Name 
	 //@Test(priority=59)
	 public void checkCompanyNameUpdateInCompanyCompanyLogo() throws InterruptedException
	 {
		 HomeMenuPage hmp=new HomeMenuPage(getDriver());
	
         hmp.clickOnLogoutLoginCompanyUpdate();
		
		 Assert.assertEquals(hmp.getPatchAfterCompanyUpdateLogoutLogin(), true);
		 
	  }
	 
	 
	 
	 //Check Updated language is displaying in the User Image Screen
	 //@Test(priority=60)
	 public void checkUpdatedLangugePersianInLanguageDropdown() throws InterruptedException
	 {
		 WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		 
		 wlp.checkUpdatedLanguage();
		 
		 Assert.assertEquals(wlp.checkUpdatedLanguage(), true);
	 }
	 
	 

	 
	 //Check Change Password 
	 //@Test(priority=61)
	 public void checkChangePasswordScreen()
	 {
		 WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		 
		 wlp.clickOnChangePasssword();
		 
		 Assert.assertEquals(wlp.verifyChangePasswordFields(), true);
		 
		 
		 
	 }
	 
	 //Check Mandatory Message for field Old password
	 //@Test(priority=62)
	 public void checkOldPasswordMandatoryMessageOnClickSave()
	 {
		 WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		 
		 wlp.clickOnSavebuttonInChangePassword();
		 
		 Assert.assertEquals(wlp.verifyMandatoryMessageForOldPasswordOnClickSaveButtonInChangePassword(), true);
		 
		 
		 
	 }
	 
	 
	 //Check Mandatory Message for field New password
	 //@Test(priority=63)
	 public void checkNewPasswordMandatoryMessageOnClickSave()
	 {
		 WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		 
		 //wlp.clickOnSaveButtonForNewpassword();

		 Assert.assertEquals(wlp.verifyMandatoryMessageForNewPasswordOnClickSaveButton(), true);
	 }
	 

	 //Check Mandatory Message for field New password
	 //@Test(priority=64)
	 public void checkConfirmPasswordMandatoryMessageOnClickSave()
	 {
		 WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		 
		 //wlp.clickOnSaveButtonForNewpassword();

		 Assert.assertEquals(wlp.verifyMandatoryMessageForConfirmPasswordOnClickSaveButton(), true);
	 }
	 
	 //Check Mandatory Message for field confirm password
	 //@Test(priority=65)
	 public void checkConfirmPasswordNewPasswordMatchOnClickSaveButton()
	 {
		 WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		 
		 //wlp.clickOnSaveButtonForNewpassword();

		 Assert.assertEquals(wlp.verifyConfirmPasswordNewPasswordMatchOnClickSaveButton(), true);
	 }
	 
	 
	 //Check Mandatory Message for field confirm password
	 //@Test(priority=66)
	 public void checkInvalidMessageForOldPasswordOnClickSaveButton()
	 {
		 WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		 
		 //wlp.clickOnSaveButtonForNewpassword();

		 Assert.assertEquals(wlp.verifyInvalidMessageForOldPasswordOnClickSaveButton(), true);
	 }
	 
	 
	 
	 //Check Mandatory Message for field confirm password
	 //@Test(priority=67)
	 public void verifyMessageOldNewPasswordSameFOnClickSaveButton()
	 {
		 WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		 
		 //wlp.clickOnSaveButtonForNewpassword();

		 Assert.assertEquals(wlp.verifyMessageOldNewPasswordSameFOnClickSaveButton(), true);
	 }
	 

	 
	 //Check Mandatory Message for field confirm password
	 //@Test(priority=68)
	 public void checkValidMessageOldNewConfirmPasswordOnClickSaveButton()
	 {
		 WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		 
		 //wlp.clickOnSaveButtonForNewpassword();

		 Assert.assertEquals(wlp.verifyMessageValidOldNewPasswordFOnClickSaveButton(), true);
	 }
	 
	 
	//Check Mandatory Message for field confirm password
    //@Test(priority=69)
    public void checkCloseBtnInChangePassword() throws InterruptedException
	{
	     WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
			 
	     wlp.clickOnChangePasssword();
	     
         wlp.clickOnCloseBtnInChangePassword();
         
         LoginPage lp=new LoginPage(getDriver());

	     Assert.assertEquals(lp.verifyUserHomePageAndDashBoard(), true);
	     
    }
	 
	 
	 //@Test(priority=70)
	 public void checkLoginUserWithUpdatedPasswordByInputtingInvalid()
	 {
		 LoginPage lp=new LoginPage(getDriver());
		 Assert.assertEquals(lp.clickOnLogoutChangePasswordSingInWithInvalid(), true);
		 
	 }
	 
	 
	 //@Test(priority=71)
	 public void checkLoginUserWithUpdatedPasswordByInputtingValid() throws InterruptedException
	 {
		 
		 LoginPage lp=new LoginPage(getDriver());
	
		 lp.clickOnLogoutChangePasswordSingInWithValid();
		 
		 Assert.assertEquals(LoginPage.verifyUserHomePageAndDashBoard(), true);
		 
		 
	 }
	 
	 
	 //@Test(priority=72)
	 public void checkRecentMenus()
	 {
		 
		 WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());

		 Assert.assertEquals(wlp.verifyRecentMenus(), true);
		
		 
	 }
	 
	 
	 
}


