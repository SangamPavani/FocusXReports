package com.focus.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.focus.Pages.HomeMenuSecurityNetworkPolicyPage;
import com.focus.Pages.LoginPage;
import com.focus.base.BaseEngine;

import com.focus.Pages.HomeMenuSecurityPasswordPolicyPage;
import com.focus.base.BaseEngine;

public class HomeMenuSecurityPasswordPolicyTest extends BaseEngine
{

	
	//@Test(priority=88)
	public static void verifyPasswordPolicy()
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
			
		hmspp.navigateToPasswordPolicySubMenu();
		
		Assert.assertEquals(hmspp.openPasswordPolicyverifyQCSubMenus(), true);
	}
	
	
	
	//@Test(priority=89)
	public static void verifyPasswordPolicyNameAsMandatory()
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkPolicyNameAsMandatory(), true);
	}
	
	//@Test(priority=90)
	public static void verifyPasswordPolicyPasswordLengthAsMandatory()
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkMinimumPasswordLengthAsMandatory(), true);
	}
	
	
	//@Test(priority=91)
	public static void verifyPasswordPolicyPasswordLengthAsNumeric()
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkMinimumPasswordLengthAsNumericFields(), true);
	}
	
	//@Test(priority=92)
	public static void verifyPasswordPolicyComplexity()
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkComplexity(), true);
		
	}
	
	//@Test(priority=93)
	public static void verifyTheSavingPasswordPolicySimpleComplex()
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkPasswordPolicySimpleSave(), true);
		
	}
	
	//@Test(priority=94)
	public static void verifyPasswordPolicyListAfterSaving()
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkPasswordPolicyLists(), true);
		
	}
	
	
	//@Test(priority=95)
	public static void verifyPasswordPolicySavedPolicyOrNot()
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkGetTheSimplePasswordPolicy(), true);
		
	}
	
	
	//@Test(priority=96)
	public static void verifyPasswordPolicyUpdatingPolicy()
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkUpdateSimplePasswordPolicy(), true);
	}
	

	//@Test(priority=97)
	public static void verifyPasswordPolicyCloseBtn() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		hmspp.checkCloseBtnInPasswordpolicy();
		
		
		
	}
	

	
	//@Test(priority=98)
	public static void verifyPasswordPolicyAlertOnDelete() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		hmspp.navigateToPasswordPolicySubMenu();
		
		hmspp.checkAlertOnDeletePasswordPolicy();
		
	}
	
	
	//@Test(priority=99)
	public static void verifyDeletedPasswordPolicyClickOnCancelInAlert() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		hmspp.checkCancelInAlertDeletePasswordPolicy();
		
	}
	

	//@Test(priority=100)
	public static void verifyDeletedPasswordPolicyClickOnOkInAlert() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		hmspp.checkOkInAlertDeletePasswordPolicy();
		
	}
	

	//@Test(priority=101)
	public static void verifySaveSimplePasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		hmspp.checkSaveSimpleAfterDeletePasswordpolicy();
		
	}
	
	
	//@Test(priority=102)
	public static void verifySaveAlphabetsWithDoNotAllowPreviousPasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		hmspp.checkSaveAlphabetsWithDoNotAllowPreviousPasswordpolicy();
		
	}

	//@Test(priority=103)
	public static void verifySaveAlphaNumericPasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		hmspp.checkSaveAlphanumericPasswordpolicy();
		
	}

	
	//@Test(priority=104)
	public static void verifySaveAlphaNumericStarPasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		hmspp.checkSaveAlphanumericStarPasswordpolicy();
		
	}
	
	//@Test(priority=105)
	public static void verifySaveNumericPasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		hmspp.checkSaveNumericPasswordpolicy();
		
	}
	
	
	//@Test(priority=106)
	public static void verifySaveAlphaNumericSpecialPasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		hmspp.checkSaveAlphaNumericSpecialPasswordPolicy();
		
	}
	
	
	
	//@Test(priority=107)
	public static void verifyInputAlphaNumericSpecialStarAndCheckLockoutPasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		hmspp.checkInputAlphaNumericSpecialStarPasswordpolicy();
		
	}
	
	
	//@Test(priority=108)
	public static void verifySaveAlphaNumericSpecialStarAndCheckLockoutPasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkMandatoyEmailAlphaNumericSpecailStarAllOptions(), true);
		
		
	}
	
	
	//@Test(priority=109)
	public static void verifyValidEmailPasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkValidEmailOnSendEmailId(), true);
		
		
	}
	
	
	//@Test(priority=110)
	public static void verifyValidEmailOnSucessPasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkValidEmailOnLoginSucess(), true);
		
		
	}
	
	//@Test(priority=111)
	public static void verifyValidEmailOnFailurePasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkValidEmailOnLoginFailure(), true);
		
		
	}
	
	//@Test(priority=112)
	public static void verifySaveWithAllOptionsPasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkSavePasswordPolicyWithAllOptions(), true);
		
		
	}
	
	//@Test(priority=113)
	public static void verifySaveCannotChangePasswordPolicyC() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkCannotChangePasswordInPasswordPolicy(), true);
		
		
	}
	
	
	//@Test(priority=114)
	public static void verifyCancelBtnInPasswordolicy() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		Assert.assertEquals(hmspp.checkCancelBtnInPasswordPolicy(), true);
		
		
	}
	
	//@Test(priority=115)
	public static void verifyCloseBtnAffterAddingAllPasswordPolicy() throws InterruptedException
	{
		HomeMenuSecurityPasswordPolicyPage hmspp=new HomeMenuSecurityPasswordPolicyPage(getDriver());
		
		hmspp.checkCloseBtnInPasswordpolicy();
		
		
	}
	
}
