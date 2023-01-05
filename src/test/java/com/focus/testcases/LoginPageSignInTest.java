package com.focus.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import com.focus.Pages.LoginPage;
import com.focus.base.BaseEngine;

public class LoginPageSignInTest extends BaseEngine {

	LoginPage lp;
	
	    @Test(priority=26)
		public void verifySuperUserAsMandatoryInLoginScreen() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
			lp=new LoginPage(getDriver());
			Assert.assertEquals(LoginPage.verifyMandatoryFieldCheckForSuperUserName(), true);	
		}
	    
	    
	    @Test(priority=27)
		public void verifyPassAsMandatoryInLoginScreen() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
	    	lp=new LoginPage(getDriver());
			Assert.assertEquals(LoginPage.verifyMandatoryFieldCheckForPassword(), true);	
		}
	    

	    
	    @Test(priority=28)
		public void verifySuperUserAsInvalidInLoginScreen() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
	    	  lp=new LoginPage(getDriver());
			  Assert.assertEquals(LoginPage.verifyInvalidSuperUserName(), true);
		   
		}
	    
	   
	    
	    @Test(priority=29)
		public void verifyPasswordAsInvalidInLoginScreen() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
	    	  lp=new LoginPage(getDriver());
			  Assert.assertEquals(LoginPage.verifyInvalidPassword(), true);
		   
		}
	    
	    
	    @Test(priority=30)
		public void verifyRememberMeInLoginScreen() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
	    	  lp=new LoginPage(getDriver());
			  Assert.assertEquals(LoginPage.checkRememberMeAsCheckedInLoginPage(), true);
		   
		}
	    
	    @Test(priority=31)
		public void verifySignInWithRememberMeInLoginScreen() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
	    	  lp=new LoginPage(getDriver());
			  Assert.assertEquals(LoginPage.checkRememberMeSignIn(), true);
		   
		}
	    
	    @Test(priority=32)
		public void verifyLogoutWithSignInAsRememberMe() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
	    	  lp=new LoginPage(getDriver());
			  Assert.assertEquals(LoginPage.checkLoginPageLogInWithRememeberMeLogout(), true);
		   
		}
	    
	    
	    
	    @Test(priority=33)
		public void verifySignInRememberIsCheckedForSecondTime() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
	    	  lp=new LoginPage(getDriver());
			  Assert.assertEquals(LoginPage.checkSignInAgainWithSuperUserBycheckingRememberMeAfterLogout(), true);
		   
		}
	    
	    

	    
	    @Test(priority=34)
		public void verifyRememberMeRememberMyPasswordSelectedInLoginScreen() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
	    	  lp=new LoginPage(getDriver());
			  Assert.assertEquals(LoginPage.checkRememeberMeRememberSelected(), true);
		   
		}
	    
	    @Test(priority=35)
		public void verifyLoginInRememberMeRememberPassword() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
	    	  lp=new LoginPage(getDriver());
			  Assert.assertEquals(LoginPage.checkRememberMeRememberMyPasswordSignIn(), true);
		   
		}
	    
	    @Test(priority=36)
		public void verifyLogoutWithSignInAsRememberMeRememberMyPassword() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
	    	  lp=new LoginPage(getDriver());
			  Assert.assertEquals(LoginPage.checkLoginPageLogInWithRememeberMeRememberMyPasswordLogout(), true);
		   
		}
	    
	    
	    @Test(priority=37)
		public void verifyIForgotMyPassword() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		{
	    	  lp=new LoginPage(getDriver());
			  Assert.assertEquals(LoginPage.checkForgotMyPasswordForSuperUser(), true);
		   
		}
	    
	    
	   
}
