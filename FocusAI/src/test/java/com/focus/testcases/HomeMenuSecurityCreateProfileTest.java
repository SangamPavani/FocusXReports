package com.focus.testcases;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.focus.Pages.HomeMenuSecurityCreateProfilePage;
import com.focus.Pages.LoginPage;
import com.focus.base.BaseEngine;

import com.focus.base.BaseEngine;

public class HomeMenuSecurityCreateProfileTest extends BaseEngine{
	
     	@Test(priority=116)
		public static void verifyCreateProfilePage()
		{
     		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
			
			Assert.assertEquals(hmscp.navigateToCreateProfileSubMenu(), true);
			
		}
     	
     	//@Test(priority=117)
		public static void verifyCreateProfileScreenAvailbilityObjects()
		{
     		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
			
			Assert.assertEquals(hmscp.checkCreateProfileAvailability(), true);
			
		}
     	
     	
     	//@Test(priority=118)
		public static void verifyProfileNameAsMandatory()
		{
     		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
			
			Assert.assertEquals(hmscp.checkPolicyNameAsMandatory(), true);
			
		}
     	
     	//@Test(priority=119)
		public static void verifyCreateProfilePermissionAsMandatory()
		{
     		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
			
			Assert.assertEquals(hmscp.checkMenuPermissionsAsMandatory(), true);
			
		}
     	
     	//@Test(priority=120)
		public static void verifyCreateProfileHomeMenuSubMenuCompany()
		{
     		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
			
			Assert.assertEquals(hmscp.checkHomeSubMenuOptionsPermissions(), true);
			
		}
     	
     	//@Test(priority=121)
		public static void verifyCreateProfileFinancialsMenuSubMenuCompany()
		{
     		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
			
			Assert.assertEquals(hmscp.checkFinancialsSubMenu(), true);
		
		}
     	
        //@Test(priority=122)
		public static void verifyCreateProfileInventoryMenuSubMenuCompany() throws Exception
		{
     		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
			
			Assert.assertEquals(hmscp.checkInventoryMenu(), true);
			   	
		}
        
        
        //@Test(priority=123)
		public static void verifyCreateProfileIFixedAssetsMenuSubMenuCompany() throws Exception
		{
     		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
			
			Assert.assertEquals(hmscp.checkFixedAssetMenu(), true);
			
		}
        
        
        //@Test(priority=124)
		public static void verifyCreateProfileProductionMenuSubMenuCompany() throws Exception
		{
     		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
			
			Assert.assertEquals(hmscp.checkProductionMenu(), true);
			
		}
        
        //@Test(priority=125)
      	public static void verifyCreateProfilePointOfSaleMenuSubMenuCompany() throws Exception
      	{
           	HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
      			
      		Assert.assertEquals(hmscp.checkPointOfSaleMenu(), true);
      			
      	}

        //@Test(priority=126)
  		public static void verifyCreateProfileQualityControlMenuSubMenuCompany() throws Exception
  		{
       		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
  			
  			Assert.assertEquals(hmscp.checkQualityControlMenu(), true);
  			
  		}
        
        //@Test(priority=127)
  		public static void verifyCreateProfileSettingsMenuSubMenuCompany() throws Exception
  		{
       		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
  			
  			Assert.assertEquals(hmscp.checkSettingsMenu(), true);
  			
  		}
        
        //@Test(priority=128)
  		public static void verifySelectAllBtnWithSelectingMenu() throws Exception
  		{
       		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
  			
  			Assert.assertEquals(hmscp.checkMandatorySelectMenuClickOnSelectAllBtn(), true);
  			
  		}
        
        //@Test(priority=129)
  		public static void verifySaveBtnWithSelectAllBtn() throws Exception
  		{
       		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
  			
  			Assert.assertEquals(hmscp.saveCreateProfileBySelectAllWithProfileAsAllOptions(), true);
  			
  		}
        
        @Test(priority=130)
  		public static void verifySavedProfile() throws Exception
  		{
       		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
  			
  			Assert.assertEquals(hmscp.checkSavedProfileName(), true);
  			
  		}

  	    @Test(priority=131)
  		public static void verifyOpenCompany() throws Exception
  		{
       		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
  			
  			Assert.assertEquals(hmscp.checkOpenCompany(), true);
  			
  		}

  	    @Test(priority=132)
		public static void verifyOpenCompanyMenuRestrcition() throws Exception
		{
     		HomeMenuSecurityCreateProfilePage hmscp=new HomeMenuSecurityCreateProfilePage(getDriver());
			
			Assert.assertEquals(hmscp.getCompanyMenuRestriction(), true);
			
		}
  		

        
}
