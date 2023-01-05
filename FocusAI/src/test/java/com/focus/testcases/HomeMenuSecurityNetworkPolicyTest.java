package com.focus.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.focus.Pages.HomeMenuSecurityNetworkPolicyPage;
import com.focus.Pages.LoginPage;
import com.focus.base.BaseEngine;

public class HomeMenuSecurityNetworkPolicyTest extends BaseEngine
{
	
	//@Test(priority=73)
	public void openNetworkPolicyPage()
	{
		HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
		hmsp.navigateToSecurityMenu();
	
		Assert.assertEquals(hmsp.openNetwworkPolicyverifyQCSubMenus(), true);
		
	}

	
	//@Test(priority=74)
	public void checkMandatoryMessageWithAllIPBlank()
	{
		HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
		hmsp.clickOnAddBtnInNetworkPolicy();
		Assert.assertEquals(hmsp.verifyAddBtnWithAllBlankIPCheckInNetworkPolicy(), true);
		
	}
	
	
	//@Test(priority=75)
	public void checkToIpAsBlankAndFromIPIsMoreThanToIp() throws InterruptedException
	{
		HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
			
	    hmsp.enterFromIPToIP();
	    
	    hmsp.clickOnAddBtnInNetworkPolicy();
	    
        Assert.assertEquals(hmsp.verifyAddBtnWithToIPBlankCheckInNetworkPolicy(), true);
		
	}
	
	//@Test(priority=76)
	public void checkToIpAsBlankAndFromIPEndWithZero() throws InterruptedException
	{
		HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
			
	    hmsp.enterFromIPToIPForCheckingIpWithZeroValue();
	    
	    hmsp.clickOnAddBtnInNetworkPolicy();
	    
        Assert.assertEquals(hmsp.verifyAddBtnWithFromIPEndingWithZeroCheckInNetworkPolicy(), true);
		
	}
	
	

	//@Test(priority=77)
	public void checkClearBtn()
	{
		HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
		hmsp.verifyClearBtn();
		hmsp.clickOnAddBtnInNetworkPolicy();
		Assert.assertEquals(hmsp.verifyClearTxtBoxes(), true);
		
	}
	
	
	//@Test(priority=78)
	public void checkFromToIpStartWithZero()
	{
		HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
		hmsp.verifyIpStartWithZeroMessage();
		hmsp.clickOnAddBtnInNetworkPolicy();
		Assert.assertEquals(hmsp.verifyStartWithZero(), true);
		
	}
	
	//@Test(priority=79)
	public void checkStartIpAndEndIp()
	{
		HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
		hmsp.verifyValidFromToIPAdd();
		hmsp.clickOnAddBtnInNetworkPolicy();
		Assert.assertEquals(hmsp.verifyStartIpAndEndIpAfterClickOnAdd(), true);
		
	}
	
	
	//@Test(priority=80)
	public void checkSaveBtnInNetworkPolicy()
	{
		HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
		hmsp.clickOnSaveBtn();
		
		Assert.assertEquals(hmsp.verifyValidSaveBtn(), true);
		
		
	}
	
	
	//@Test(priority=81)
	public void verifyUpdateBtn() throws InterruptedException
	{
		HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());

	    Assert.assertEquals(hmsp.verifyUpdateBtn(), true);
	    
	}
	
	
	//@Test(priority=82)
	public void verifySaveTheUpdatedIp() throws InterruptedException
	{
		HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
		
		hmsp.clickOnSaveBtn();
		
		Assert.assertEquals(hmsp.verifyValidSaveBtn(), true);
		
	}
	
	     //Open Network Policy again after closing the Network Policy and check Saved Ip is displaying or not
		//@Test(priority=83)
		public void verifyOpenNetworkPolicyCheckSavedIp() throws InterruptedException
		{
			
			HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
		
			//hmsp.OpenNetworkPolicy();
			
			//hmsp.verifySavedIpIsdisplayingUserCloseReOpenTheNetworkpolicy();
			
			hmsp.verifyAllowIP();
			
			hmsp.clickOnSaveBtn();
			
			hmsp.verifyValidSaveBtn();
			
			
		}
		
		
		//Verify the Clear or Delete row in the Start and End Ip
	    //@Test(priority=84)
		public void verifyCloseImageClickAndCheckAlertInNetworkworkPolicy() throws InterruptedException
		{
			HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
			
			hmsp.verifyCloseImageStartIpendIp();
			
			hmsp.clickOnSaveBtn();
			
			hmsp.verifyValidSaveBtn();
			
			
			
			/*hmsp.clickOnSaveBtn();
			
			hmsp.verifyOkInAlertClickOnSaveAfterClickOnCloseImage();
			*/
			
		}
		
    
	    //@Test(priority=85)
        public void verifyDeletedIpIsDisplayingInNetworkPolicy() throws InterruptedException
        {
	    	
	    	HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
	    	hmsp.verifyAllowIpInNetworkPolicy();
	    	
        }
    
		//Click on Close button, Alert display and in that alert click on Ok button
	    //@Test(priority=86)
	    public void verifyCloseAlertInTheAlertClickOnOkBtn() throws InterruptedException
	    {
	    	
	    	HomeMenuSecurityNetworkPolicyPage hmsp=new HomeMenuSecurityNetworkPolicyPage(getDriver());
	    	
	    	hmsp.clickOnCloseBtnInNetworkPolicy();
	    	
	    	hmsp.verifyCloseAlertkInAlertClickOnOkBtn();
	    }
	    

	    //Checking the HomePage Dashboard is displaying or not
	    //@Test(priority=87)
	    public void verifyCloseNetworkPolicyPageInAlertOkUserClickOnCloseBtn() throws InterruptedException
	    {
	    	
	    	LoginPage lp=new LoginPage(getDriver());
	    	
	    	Assert.assertEquals(lp.verifyUserHomePageAndDashBoard(), true);
	    	

	    	
	    }
	    
	
	    
	    

	
	
}