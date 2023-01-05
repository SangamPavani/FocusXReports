package com.focus.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.focus.base.BaseEngine;

public class WrapperLayoutPage extends BaseEngine 
{
	@FindBy(xpath="//*[@id='idquickAccessMenus_Main']/span[1]")
	private static WebElement aboutIdQuickAccessMenu;
	
		@FindBy(xpath="//*[@id='quickAccessDiv']/ul/li[1]/a")
		private static WebElement favouriteOption;
		
		@FindBy(xpath="//*[@id='quickAccessDiv']/ul/li[2]/a")
		private static WebElement recentItemsOpion;
		
		@FindBy(xpath="//*[@id='quickAccessDiv']/ul/li[3]/a")
		private static WebElement runOption;
		
		@FindBy(xpath="//*[@id='quickAccessDiv']/ul/li[4]/a/span")
		private static WebElement quickAccessOption;
		
		@FindBy(xpath="//*[@id='quickAccessDiv']/ul/li[5]/a")
		private static WebElement aboutOption;
		
			@FindBy(xpath="//*[@id='about']/div[1]/img")
			private static WebElement aboutImage;
			
			@FindBy(xpath="//*[@id='idAboutCompany']/div[1]/label[2]")
			private static WebElement aboutVersioin;

			@FindBy(xpath="//*[@id='idAboutCompany']/div[2]/label[2]")
			private static WebElement aboutRelease;

			@FindBy(xpath="//*[@id='idAboutCompany']/div[3]/label[2]")
			private static WebElement aboutLicensed;
			
	@FindBy(xpath="//*[@id='txtSearch']")
	private static WebElement searchOption;
	
	@FindBy(xpath="//*[@id='mainHeader_MainLayout']/nav/div/ul/li[2]/a/i")
	private static WebElement productTourOption;
	
	@FindBy(xpath="//*[@id='mainHeader_MainLayout']/nav/div/ul/li[3]/a/i")
	private static WebElement alertsOption;

	@FindBy(xpath="//*[@id='idRecentMenus_Main']/i")
	private static WebElement recentMenus;
	
	@FindBy(xpath="//*[@id='mainHeader_MainLayout']/nav/div/ul/li[5]/a/img")
	private static WebElement imgOfTheUser;

		@FindBy(xpath="//*[@id='userprofile']/li/span[1]")
		private static WebElement changePassword;
		
			@FindBy(xpath="//*[@id='securityNavBar']/div/div[1]/a/div/span[2]")
			private static WebElement changePasswordTitle;
		
			@FindBy(xpath="//*[@id='myNavbar']/ul/li/span[1]/i")
			private static WebElement changePasswordSaveBtn;			

			@FindBy(xpath="//*[@id='myNavbar']/ul/li/span[2]/i")
			private static WebElement changePasswordCloseBtn;

			@FindBy(xpath="//*[@id='oldPassword']")
			private static WebElement changePasswordOldPasswordTxt;

			@FindBy(xpath="//*[@id='newPassword']")
			private static WebElement changePasswordNewPasswordTxt;

			@FindBy(xpath="//*[@id='confirmPassword']")
			private static WebElement changePasswordConfirmTxt;
			
     			//Mandatory message
				@FindBy(xpath="//*[@id='idGlobalError']/div/table/tbody/tr/td[2]/div[2]")
				private static WebElement msgGlobalError;
				
				@FindBy(xpath="//*[@id='idGlobalError']/div/table/tbody/tr/td[3]/span")
				private static WebElement closeMsgGlobalError;
				

		@FindBy(xpath="//*[@id='ddlCompanyLangualges_MainLayout']")
		private static WebElement languageDropdownInLogout;
	
		@FindBy(xpath="//*[@id='userprofile']/li/span[2]")
		private static WebElement logoutOption;
		

	@FindBy(xpath="//*[@id='mainHeader_MainLayout']/nav/div/ul/li[5]/a/span")
	private static WebElement textNameOfTheUser;
	
	@FindBy(xpath="//*[@id='mainHeader_MainLayout']/nav/div/ul/li[5]/a/i")
	private static WebElement dropdownMenuUserChangePasswordLanguageAndLogout;

	@FindBy(xpath="//*[@id='companyLogo']")
	private static WebElement companyLogo;
	
	@FindBy(xpath="//*[@id='ulCompanyDetails_HomePage']/li[1]")
	private static WebElement companyNameInCompanyLogo;
	
	
	
	
	public static boolean checkAvailibityOfOptionsInWrapperLayout()
	{
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(aboutIdQuickAccessMenu));
		
		if(aboutIdQuickAccessMenu.isDisplayed())
		{
			System.out.println("pass : aboutIdQuickAccessMenu");
			
			if(searchOption.isDisplayed())
			{
				System.out.println("pass : searchOption");
				
				if(productTourOption.isDisplayed())
				{
					System.out.println("pass : productTourOption");
					
					if(alertsOption.isDisplayed())
					{
						System.out.println("pass : alertsOption");
						
						if( recentMenus.isDisplayed())
						{
							System.out.println("pass : recentMenus");
						
							if( imgOfTheUser.isDisplayed())
							{
								System.out.println("pass : imgOfTheUser");
								
								if( textNameOfTheUser.isDisplayed())
								{
									System.out.println("pass : textNameOfTheUser");
									
									if( dropdownMenuUserChangePasswordLanguageAndLogout.isDisplayed())
									{
										System.out.println("pass : dropdownMenuUserChangePasswordLanguageAndLogout");
										
										if( companyLogo.isDisplayed())
										{
											System.out.println("pass : companyLogo");
											return true;
										}
										else
										{
											System.out.println("Fail : companyLogo");
											return false;
										}
									}
									else
									{
										System.out.println("Fail : dropdownMenuUserChangePasswordLanguageAndLogout");
										return false;
									}
								}
								else
								{
									System.out.println("Fail : textNameOfTheUser");
									return false;
								}
							}
							else
							{
								System.out.println("Fail : imgOfTheUser");
								return false;
							}
						}
						else
						{
							System.out.println("Fail : recentMenus");
							return false;
						}
					}
					else
					{
						System.out.println("Fail : alertsOption");
						return false;
					}
				}
				else
				{
					System.out.println("Fail : productTourOption");
					return false;
					
				}
			}
			else
			{
				System.out.println("Fail : searchOption");
				return false;
				
			}
		}
		else
		{
			System.out.println("Fail : aboutIdQuickAccessMenu");
			return false;
			
		}

		
		
	}
	
	
	
	public static boolean checkAboutIdQuickAccessMenu() throws InterruptedException
	{
		
		getWebDriverWait().until(ExpectedConditions.visibilityOf(aboutIdQuickAccessMenu));
		
		
		Thread.sleep(2000);
		System.out.println("checkAboutIdQuickAccessMenu");
		
		aboutIdQuickAccessMenu.click();
		
		
		if(favouriteOption.isDisplayed())
		{
			System.out.println("pass : favouriteOption");
			
			if(recentItemsOpion.isDisplayed())
			{
				System.out.println("pass : recentItemsOpion");
				
				if(runOption.isDisplayed())
				{
					System.out.println("pass : runOption");
					
					if(quickAccessOption.isDisplayed())
					{
						System.out.println("pass : quickAccessOption");
						
						if( aboutOption.isDisplayed())
						{
							System.out.println("pass : aboutOption");
							return true;
						}
						else
						{
							System.out.println("Fail : aboutOption");
							return false;
						}
					}
					else
					{
						System.out.println("Fail : quickAccessOption");
						return false;
					}
				}
				else
				{
					System.out.println("Fail : runOption");
					return false;
					
				}
			}
			else
			{
				System.out.println("Fail : recentItemsOpion");
				return false;
				
			}
		}
		else
		{
			System.out.println("Fail : favouriteOption");
			return false;
	
		}

		
		
	}
	
	
	
	public static boolean clickOnAbout() throws InterruptedException
	{
		getWebDriverWait().until(ExpectedConditions.visibilityOf(aboutOption));
		
		Thread.sleep(2000);
		System.out.println("cliclonabout");
		
		aboutOption.click();
		
		
		if(aboutImage.isDisplayed())
		{
			if(aboutVersioin.isDisplayed())
			{
				if(aboutRelease.isDisplayed())
				{
					if(aboutLicensed.isDisplayed())
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		
	}
	
	
	
	public static String getReleasedate() throws InterruptedException
	{
		getWebDriverWait().until(ExpectedConditions.visibilityOf(aboutRelease));
		String getReleaseDateFromAbout=aboutRelease.getText();
		String modifyGetReleaseDateFromAbout=" "+getReleaseDateFromAbout;
		
		return modifyGetReleaseDateFromAbout;
	}
	
	
	
	
	
	
	public static void clickOnAboutToClose()
	{
		getWebDriverWait().until(ExpectedConditions.visibilityOf(aboutIdQuickAccessMenu));
		System.out.println("ClickOnCloseAbout");
		aboutIdQuickAccessMenu.click();
	}
	
	
	
	public static String getCompanyNameUserClickOnCompanyLogo()
	{
		
		getWebDriverWait().until(ExpectedConditions.visibilityOf(companyLogo));
		
		companyLogo.click();
		
  
		
		String companyNameCompanyLogo=companyNameInCompanyLogo.getText();
		
    	String getCompanyName=companyNameCompanyLogo.substring(0, 32);
    	System.out.println("getCompanyName :"+ getCompanyName);
    	companyLogo.click();
		
		
		return getCompanyName;
		
	}
	
	
	public static boolean checkUpdatedLanguage() throws InterruptedException
	{
		getWebDriverWait().until(ExpectedConditions.visibilityOf(imgOfTheUser));
		imgOfTheUser.click();

		String langDropdown= languageDropdownInLogout.getText();
		
		System.out.println("langDropdown"+langDropdown);
		
		boolean getUpdatedLang=false;
		String[] str= langDropdown.split("\n");   
		for(String sto :str)
		{
		
			sto.equals("Persian");
			getUpdatedLang=true;
			break;
		}
		
		return getUpdatedLang;
		
	}
		
	
	
	public static void clickOnChangePasssword()
	{
		
		WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		
		getWebDriverWait().until(ExpectedConditions.visibilityOf(imgOfTheUser));
		imgOfTheUser.click();
		
		
		getWebDriverWait().until(ExpectedConditions.visibilityOf(changePassword));
		changePassword.click();
		
		

	}
	
	
	
	//Change Password Screen : Click on Save button
	public static void clickOnSavebuttonInChangePassword()
	{
		getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordSaveBtn));
		
		changePasswordSaveBtn.click();
	}
	
	
	//Change Password Screen : Check Mandatory message is displaying on Click on Save button
	public static boolean verifyMandatoryMessageForOldPasswordOnClickSaveButtonInChangePassword()
	{
		String getMandatoryMessage=msgGlobalError.getText();
		System.out.println(getMandatoryMessage);
		
		if(getMandatoryMessage.equalsIgnoreCase("Enter old password"))
		{
			closeMsgGlobalError.click();
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	
	
	//Change Password Screen : Check Mandatory message is displaying on Click on Save button
	public static void clickOnSaveButtonForNewpassword()
	{
			
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordOldPasswordTxt));
			
			changePasswordOldPasswordTxt.sendKeys("su");
			
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordSaveBtn));
			
			changePasswordSaveBtn.click();
			
			
		}
	
	
		public static boolean verifyMandatoryMessageForNewPasswordOnClickSaveButton()
		{
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordOldPasswordTxt));
			
			changePasswordOldPasswordTxt.sendKeys("s");
			
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordSaveBtn));
			
			changePasswordSaveBtn.click();
			
			
			String getMandatoryMessageNewPassword=msgGlobalError.getText();
			
			System.out.println(getMandatoryMessageNewPassword);
			
			if(getMandatoryMessageNewPassword.equalsIgnoreCase("Enter new password"))
			{
				closeMsgGlobalError.click();
				return true;
				
			}
			else
			{
				return false;
			}
		}
		
		
		public static boolean verifyMandatoryMessageForConfirmPasswordOnClickSaveButton()
		{
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordOldPasswordTxt));
			
			changePasswordOldPasswordTxt.clear();
			changePasswordOldPasswordTxt.sendKeys("s");
			
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordNewPasswordTxt));
			
			changePasswordNewPasswordTxt.clear();
			changePasswordNewPasswordTxt.sendKeys("s");
			
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordSaveBtn));
			
			changePasswordSaveBtn.click();
			
			String getMandatoryMessageNewPassword=msgGlobalError.getText();
			System.out.println(getMandatoryMessageNewPassword);
			
			if(getMandatoryMessageNewPassword.equalsIgnoreCase("Enter confirm password"))
			{
				closeMsgGlobalError.click();
				return true;
			}
			else
			{
				return false;
			}
			
		}
		
		
		
		public static boolean verifyConfirmPasswordNewPasswordMatchOnClickSaveButton()
		{
			
			
            getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordOldPasswordTxt));
			
            
            changePasswordOldPasswordTxt.clear();
			changePasswordOldPasswordTxt.sendKeys("s");
				
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordNewPasswordTxt));
			
			changePasswordNewPasswordTxt.clear();
			changePasswordNewPasswordTxt.sendKeys("s");
				
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordConfirmTxt));
			changePasswordConfirmTxt.sendKeys("ss");
	
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordSaveBtn));
			
			changePasswordSaveBtn.click();
	
			String getMandatoryMessageNewPassword=msgGlobalError.getText();
			
			System.out.println(getMandatoryMessageNewPassword);
			
			if(getMandatoryMessageNewPassword.equalsIgnoreCase("Confirm password does not match"))
			{
				closeMsgGlobalError.click();
				return true;
			}
			else
			{
				return false;
			}
			
		}
	
	
	
		public static boolean verifyInvalidMessageForOldPasswordOnClickSaveButton()
		{
			
			changePasswordOldPasswordTxt.clear();
			changePasswordOldPasswordTxt.sendKeys("s");
				
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordNewPasswordTxt));
			
			changePasswordNewPasswordTxt.clear();
			changePasswordNewPasswordTxt.sendKeys("s");
				
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordConfirmTxt));
			changePasswordConfirmTxt.clear();
			changePasswordConfirmTxt.sendKeys("s");

			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordSaveBtn));
			
			changePasswordSaveBtn.click();
		
			String getMandatoryMessageNewPassword=msgGlobalError.getText();
			
			System.out.println(getMandatoryMessageNewPassword);
			
			if(getMandatoryMessageNewPassword.equalsIgnoreCase("Provided old password is incorrect"))
			{
				closeMsgGlobalError.click();
				return true;
			}
			else
			{
				return false;
			}
		}
	
		
		
		public static boolean verifyMessageOldNewPasswordSameFOnClickSaveButton()
		{
			
			changePasswordOldPasswordTxt.clear();
			changePasswordOldPasswordTxt.sendKeys("su");
				
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordNewPasswordTxt));
			
			changePasswordNewPasswordTxt.clear();
			changePasswordNewPasswordTxt.sendKeys("su");
				
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordConfirmTxt));
			changePasswordConfirmTxt.clear();
			changePasswordConfirmTxt.sendKeys("su");

			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordSaveBtn));
			
			changePasswordSaveBtn.click();
		
			String getMandatoryMessageNewPassword=msgGlobalError.getText();
			
			System.out.println(getMandatoryMessageNewPassword);
			
			if(getMandatoryMessageNewPassword.equalsIgnoreCase("Old and new passwords cannot be same"))
			{
				closeMsgGlobalError.click();
				return true;
			}
			else
			{
				return false;
			}
		}
		
		
		
		public static boolean verifyMessageValidOldNewPasswordFOnClickSaveButton()
		{
			
			changePasswordOldPasswordTxt.clear();
			changePasswordOldPasswordTxt.sendKeys("su");
				
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordNewPasswordTxt));
			
			changePasswordNewPasswordTxt.clear();
			changePasswordNewPasswordTxt.sendKeys("s");
				
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordConfirmTxt));
			changePasswordConfirmTxt.clear();
			changePasswordConfirmTxt.sendKeys("s");

			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordSaveBtn));
			changePasswordSaveBtn.click();
		
			String getMandatoryMessageNewPassword=msgGlobalError.getText();
			
			System.out.println(getMandatoryMessageNewPassword);
			
			if(getMandatoryMessageNewPassword.equalsIgnoreCase("Password Saved Successfully"))
			{
				closeMsgGlobalError.click();
				return true;
			}
			else
			{
				return false;
			}
		}
		
		
		public void clickOnCloseBtnInChangePassword()
		{
			getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordCloseBtn));
			changePasswordCloseBtn.click();
			
		}
		
		
		
	
		
		

	
	public static boolean verifyChangePasswordFields()
	{
		
		
		getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordTitle));
		
		
		getWebDriverWait().until(ExpectedConditions.visibilityOf(changePasswordOldPasswordTxt));
		

		if(changePasswordTitle.isDisplayed())
		{
			String compareChnagePasswordTxt=changePasswordTitle.getText();
			String compareChnagePasswordtxtvalue="Change Password";
			
			System.out.println(compareChnagePasswordTxt);
			System.out.println(compareChnagePasswordtxtvalue);
			
			
			System.out.println("Pass : Change Password Title is displaying");
			
			if(compareChnagePasswordTxt.equalsIgnoreCase(compareChnagePasswordtxtvalue))
			{
				System.out.println("Pass : Change Password Screen Name is displaying");
				
				if(changePasswordOldPasswordTxt.isDisplayed())
				{
					System.out.println("Pass : changePasswordOldPasswordTxt is displaying");
					
					if(changePasswordNewPasswordTxt.isDisplayed())
					{
						System.out.println("Pass : changePasswordNewPasswordTxt is displaying");
						
						if(changePasswordConfirmTxt.isDisplayed())
						{
							System.out.println("Pass : changePasswordConfirmTxt is displaying");
											
							if(changePasswordSaveBtn.isDisplayed())
							{
								System.out.println("Pass : changePasswordSaveBtn is displaying");						
								
								if(changePasswordCloseBtn.isDisplayed())
								{
									System.out.println("Pass : changePasswordCloseBtn is displaying");
									return true;
									
								}
								else
								{
									System.out.println("Fail : changePasswordCloseBtn is displaying");
									return false;
								}
							}
							
							else
							{
								System.out.println("Fail : changePasswordSaveBtn is displaying");
								return false;
							}
						}
							
						else
						{
							System.out.println("Fail : changePasswordConfirmTxt is displaying");
							return false;
						}
					}
					else
					{
						System.out.println("Fail : changePasswordNewPasswordTxt is displaying");
						return false;
					}
				}
				else
				{
					System.out.println("Fail : changePasswordOldPasswordTxt is displaying");
					return false;
				}
			}
			else
			{
				System.out.println("Fail : Change Password is displaying");
				return false;
			}
			
		}
		else
		{
			System.out.println("Fail : Change Password Title is displaying");
			return false;
		}
		
	}
	

	
	
	public boolean verifyRecentMenus()
	{
		getWebDriverWait().until(ExpectedConditions.visibilityOf(recentMenus));
		recentMenus.click();
		
		
		
	String recentMenusOption= recentMenus.getText();
		
		System.out.println("recentMenusOption"+recentMenusOption);
		
		boolean getUpdatedLang=false;
		String[] str= recentMenusOption.split("\n");   
		for(String sto :str)
		{
		
			sto.equals("Edit company");
			getUpdatedLang=true;
			break;
		}
		
		return getUpdatedLang;
		
		
	}
	
	
	
	
	
    public WrapperLayoutPage(WebDriver driver)
    {
    	
    	PageFactory.initElements(driver, this);
    	
    }
	
	
	
}
