package com.focus.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.focus.base.BaseEngine;

public class HomeMenuSecurityNetworkPolicyPage extends BaseEngine 
{
	
	//Home Menu
	@FindBy (xpath="//*[@id='1']/div/span")
    private static WebElement homeMenu;
	
	//Security Menu	
	@FindBy (xpath="//*[@id='6']/span")
    private static WebElement securityMenu;
	
		@FindBy (xpath="//*[@id='7']/span")
		private static WebElement networkPolicy;
		
			@FindBy (xpath="//*[@id='securityNavBar']/div/div[1]/a/div/span[2]")
			private static WebElement networkPolicyTitle;
			
			@FindBy (xpath="//*[@id='allowDiv']/div[1]/label")
			private static WebElement allowRadioBtnInNetworkPolicy;
		
			@FindBy (xpath="//*[@id='allowDiv']/div[2]/label")
			private static WebElement blockRadioBtnInNetworkPolicy;
			
			@FindBy (xpath="//*[@id='IPtable']/thead/tr/td[1]")
			private static WebElement startIp;
			
			@FindBy (xpath="//*[@id='IPtable']/thead/tr/td[2]")
			private static WebElement endIp;
				
			@FindBy (xpath="//*[@id='0']/td[1]")
			private static WebElement startIpValue;
			
			@FindBy (xpath="//*[@id='0']/td[2]")
			private static WebElement endIpValue;
			
			@FindBy (xpath="//*[@id='0']/td[2]/span[1]")
			private static WebElement closeImage;
			
			@FindBy (xpath="//*[@id='From']")
			private static WebElement fromIp;
			
			@FindBy (xpath="//*[@id='To']")
			private static WebElement toIp;
			
			@FindBy (xpath="//i[@class='icon-font6 icon-add']")
			private static WebElement addIp;
			
			@FindBy (xpath="//i[@class='icon-font6 icon-clear']")
			private static WebElement clearIp;
			
			@FindBy (xpath="//*[@id='buttons']/span[1]/i")
			private static WebElement saveBtnInNetworkPolicy;
			
			@FindBy (xpath="//*[@id='addbtn']/i")
			private static WebElement updateBtnInNetworkPolicy;
			
			@FindBy (xpath="//*[@id='buttons']/span[2]/i")
			private static WebElement closeBtnInNetworkPolicy;

		@FindBy (xpath="//*[@id='8']/span")
		private static WebElement passwordPolicy;
		
		@FindBy (xpath="//*[@id='9']/span")
		private static WebElement createProfile;
		
		@FindBy (xpath="//*[@id='10']/span")
		private static WebElement createRole;
		
		@FindBy (xpath="//*[@id='11']/span")
		private static WebElement createUser;
		
		@FindBy (xpath="//*[@id='12']/span")
		private static WebElement changePassword;
		
		@FindBy (xpath="//*[@id='13']/span")
		private static WebElement updatePersonalInfo;
		
		@FindBy (xpath="//*[@id='14']/span")
		private static WebElement usageLog;
		
		@FindBy (xpath="//*[@id='644']/span")
		private static WebElement userRightsReport;
		
		@FindBy (xpath="//*[@id='652']/span")
		private static WebElement roleRightsReport;
		
		@FindBy (xpath="//*[@id='653']/span")
		private static WebElement profileRightsReport;
		
		@FindBy(xpath="//*[@id='idGlobalError']/div/table/tbody/tr/td[2]/div[2]")
		private static WebElement msgNPGlobalError;
		
		@FindBy(xpath="//*[@id='idGlobalError']/div/table/tbody/tr/td[3]/span")
		private static WebElement closeMsgNPGlobalError;
		
		@FindBy(xpath="//*[@id='allow']")
		private static WebElement allowRadioBtn;
		
	
		
		public static void navigateToSecurityMenu()
		{
			
            getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
			
			homeMenu.click();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(securityMenu));
			
			securityMenu.click();
			
			
		}
		

		
		
		
		public static boolean openNetwworkPolicyverifyQCSubMenus()
		{
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(networkPolicy));
			
			networkPolicy.click();
		
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(networkPolicyTitle));
			
			String getNetPolicyScreenName=networkPolicyTitle.getText();
	
			
	
			System.out.println(getNetPolicyScreenName);
			
			if(getNetPolicyScreenName.equalsIgnoreCase("Network Policy"))
			  {
				System.out.println("Pass : Network Policy Title is displaying Corrrect");
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(allowRadioBtnInNetworkPolicy));
				  
				  if(allowRadioBtnInNetworkPolicy.isDisplayed())
				  {
					  System.out.println("pass allowRadioBtnInNetworkPolicy");
					  
					  if(blockRadioBtnInNetworkPolicy.isDisplayed())
					  {
						  System.out.println("pass blockRadioBtnInNetworkPolicy");
			
						  if(startIp.isDisplayed())
						  {
							  System.out.println("pass startIp");
				
							  if(endIp.isDisplayed())
							  {
								  System.out.println("pass endIp");
					
								  if(fromIp.isDisplayed())
								  {
									  System.out.println("pass fromIp");
						
									  if(toIp.isDisplayed())
									  {
										  System.out.println("pass toIp");
							              
										  if(addIp.isDisplayed())
										  {
											  System.out.println("pass addIp");
								
											  if(clearIp.isDisplayed())
											  {
												  System.out.println("pass clearIp");
									
												  if(saveBtnInNetworkPolicy.isDisplayed())
												  {
													  System.out.println("pass saveBtnInNetworkPolicy");
													  
													  if(closeBtnInNetworkPolicy.isDisplayed())
													  {
														  System.out.println("pass closeBtnInNetworkPolicy");
														 
                                                            return true;
														  }
														  else
														  {
															  System.out.println("Fail closeBtnInNetworkPolicy");
															  return false;
														  }  

													  }
													  else
													  {
														  System.out.println("Fail saveBtnInNetworkPolicy");
														  return false;
													  }  
												  }
												  else
												  {
													  System.out.println("Fail clearIp");
													  return false;
												  }  

												  
											  }
											  else
											  {
												  System.out.println("Fail addIp");
												  return false;
											  }  
										  }

										  else
										  {
											  System.out.println("Fail toIp");
											  return false;
										  }  
									  }
									  else
									  {
										  System.out.println("Fail fromIp");
										  return false;
									  }  
								  }

								  else
								  {
									  System.out.println("Fail endIp");
									  return false;
								  }  
							  }

							  else
							  {
								  System.out.println("Fail startIp");
								  return false;
							  }  
						  }
	
						  else
						  {
							  System.out.println("Fail blockRadioBtnInNetworkPolicy");
							  return false;
						  }  
					  }

					  else
					  {
						  System.out.println("Fail allowRadioBtnInNetworkPolicy");
						  return false;
					  }  
				  }

				  else
				  {
					  System.out.println("Fail Network Policy Title is displaying Wrong");
					  return false;
				  }  
			  }
		
		
		
		public static void clickOnAddBtnInNetworkPolicy()
		{
			  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(addIp));
				
			  addIp.click();
			  
		}
		
		public static boolean verifyAddBtnWithAllBlankIPCheckInNetworkPolicy()
		{
			 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(msgNPGlobalError));
			
	        String getMandatoryMessageNewPassword=msgNPGlobalError.getText();
	        
			System.out.println(getMandatoryMessageNewPassword);
	        
			if(getMandatoryMessageNewPassword.equalsIgnoreCase("Enter From IP Address"))
			{
				closeMsgNPGlobalError.click();
				return true;
			}
			else
			{
				closeMsgNPGlobalError.click();
				return false;
			}
		}
		
		
		public static boolean verifyAddBtnWithToIPBlankCheckInNetworkPolicy()
		{
			 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(msgNPGlobalError));
			
	        String getMandatoryMessageNewPassword=msgNPGlobalError.getText();
	        
			System.out.println(getMandatoryMessageNewPassword);
	        
			if(getMandatoryMessageNewPassword.equalsIgnoreCase("The End range of IP Address can not be less than Start range."))
			{
				closeMsgNPGlobalError.click();
				return true;
			}
			else
			{
				closeMsgNPGlobalError.click();
				return false;
			}
		}
		
		
		
		public static void enterFromIP(String FromIpTxt)
		{
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(fromIp));
			
			//fromIp.click();
			//getAction().moveToElement(fromIp).sendKeys(Keys.HOME).perform();
			fromIp.sendKeys(FromIpTxt);
			
		}
		

		
		
		
		public static void enterToIP(String ToIpTxt)
		{
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(toIp));
			
			toIp.sendKeys(ToIpTxt);
			
		}
		
		
		public static void enterFromIPToIP() throws InterruptedException
		{
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(fromIp));
		
			fromIp.click();

			getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
			
			fromIp.sendKeys("192.193.9.91");
			
			getAction().moveToElement(fromIp).sendKeys(Keys.TAB).perform();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(toIp));
			
			toIp.sendKeys("0");
			
		
			
		}
		
		
		
		
		public static boolean verifyAddBtnWithFromIPMoreThanToIPCheckInNetworkPolicy()
		{
			
			
	        String getMandatoryMessageNewPassword=msgNPGlobalError.getText();
			
			System.out.println(getMandatoryMessageNewPassword);
			
			if(getMandatoryMessageNewPassword.equalsIgnoreCase("The End range of IP Address can not be less than Start range"))
			{
				closeMsgNPGlobalError.click();
				return true;
			}
			else
			{
				closeMsgNPGlobalError.click();
				return false;
			}
			
		}
		
		
	
		
		public static void enterFromIPToIPForCheckingIpWithZeroValue() throws InterruptedException
		{
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(fromIp));
		
			fromIp.click();

			getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
			
			fromIp.sendKeys("0.0");
			
			getAction().moveToElement(fromIp).sendKeys(Keys.TAB).perform();
			
			getAction().moveToElement(toIp).sendKeys(Keys.RIGHT).perform();
			
			getAction().moveToElement(toIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(toIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(toIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(toIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(toIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(toIp).sendKeys(Keys.BACK_SPACE).perform();
			
			getAction().moveToElement(toIp).sendKeys(Keys.BACK_SPACE).perform();
			
			toIp.sendKeys("192.193.9.99");
			
		
			
		}
		
		
		
		
		public static boolean verifyAddBtnWithFromIPEndingWithZeroCheckInNetworkPolicy()
		{
			
			
	        String getMandatoryMessageNewPassword=msgNPGlobalError.getText();
			
			System.out.println(getMandatoryMessageNewPassword);
			
			if(getMandatoryMessageNewPassword.equalsIgnoreCase("IP cannot end with 0 and Negative values."))
			{
				closeMsgNPGlobalError.click();
				return true;
			}
			else
			{
				closeMsgNPGlobalError.click();
				return false;
			}
			
		}
		
		
		public static void verifyClearBtn()
		{
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(clearIp));
			clearIp.click();
			
		}
		
		
		
		
		public static boolean verifyClearTxtBoxes()
		{
			
			 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(fromIp));
			 String getMandatoryMessageNewPassword=msgNPGlobalError.getText();
				
				System.out.println(getMandatoryMessageNewPassword);
				
				if(getMandatoryMessageNewPassword.equalsIgnoreCase("Enter From IP Address"))
				{
					closeMsgNPGlobalError.click();
					return true;
				}
				else
				{
					closeMsgNPGlobalError.click();
					return false;
				}
			
		}
		
		
		
		
		public static void verifyIpStartWithZeroMessage()
		{
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(fromIp));
		
			fromIp.click();
	
			fromIp.sendKeys("0.0.0.4");
			
			getAction().moveToElement(fromIp).sendKeys(Keys.TAB).perform();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(toIp));
			
			toIp.sendKeys("0.0.0.9");
			
		
			
		}
		
		
		public static boolean verifyStartWithZero()
		{
			
			 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(fromIp));
			 String getMandatoryMessageNewPassword=msgNPGlobalError.getText();
				
				System.out.println(getMandatoryMessageNewPassword);
				
				if(getMandatoryMessageNewPassword.equalsIgnoreCase("IP cannot start with 0 Negative values."))
				{
					closeMsgNPGlobalError.click();
					return true;
				}
				else
				{
					closeMsgNPGlobalError.click();
					return false;
				}
			
		}
		
		
		
		public static void verifyValidFromToIPAdd()
		{
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(clearIp));
			
			clearIp.click();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(fromIp));
		
			fromIp.click();
	
			fromIp.sendKeys("192.168.5.99");
			
			getAction().moveToElement(fromIp).sendKeys(Keys.TAB).perform();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(toIp));
			
			toIp.sendKeys("192.168.5.99");
			
		}

		
		
		public static boolean verifyStartIpAndEndIpAfterClickOnAdd()
		{
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(startIpValue));
			
			String getStartIp=startIpValue.getText();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(endIpValue));
			
			String getEndIp=endIpValue.getText();
			
	        System.out.println(getStartIp);
	        System.out.println(getEndIp);
	        
	        if(getStartIp.equalsIgnoreCase("192.168.5.99") && getEndIp.equalsIgnoreCase("192.168.5.99"))
	        {
	        	System.out.println("Pass");
	        	return true;
	        }
	        else
	        {
	        	System.out.println("Fail");
	        	return false;
	        }
			
		}
		
		
		
		
		
		public static void clickOnSaveBtn()
		{
			
			 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(saveBtnInNetworkPolicy));
			 saveBtnInNetworkPolicy.click();
		
		}
		
		
		public static boolean verifyValidSaveBtn()
		{
		
			 String getMandatoryMessageNewPassword=msgNPGlobalError.getText();
			 if(getMandatoryMessageNewPassword.equalsIgnoreCase("Network policy saved successfully"))
			 {
				 System.out.println("Pass : Network policy saved successfully");
				 closeMsgNPGlobalError.click();
				 return true;
			 }
			 else
			 {
				 System.out.println("Fail : Network policy not saved successfully");
				 closeMsgNPGlobalError.click();
				 return false;
			 }
			
		}
		
		
		
		
		
		
		public static boolean verifyUpdateBtn() throws InterruptedException
		{
			
			Actions actions = new Actions(getDriver());
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(startIpValue));
			
			actions.doubleClick(startIpValue).perform();
			
			Thread.sleep(2000);
			
			fromIp.click();

			getAction().moveToElement(fromIp).sendKeys(Keys.END).perform();
			
			getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
			
			fromIp.sendKeys("8");
			
			
			
			getAction().moveToElement(fromIp).sendKeys(Keys.TAB).perform();
			
			getAction().moveToElement(toIp).sendKeys(Keys.END).perform();
			
			getAction().moveToElement(toIp).sendKeys(Keys.BACK_SPACE).perform();
			
			toIp.sendKeys("8");
			
			 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(updateBtnInNetworkPolicy));
			
			updateBtnInNetworkPolicy.click();
			
			Thread.sleep(2000);
			
			String getStartIp=startIpValue.getText();
			String getEndIp=endIpValue.getText();
			
	        System.out.println(getStartIp);
	        System.out.println(getEndIp);
	        
	        if(getStartIp.equalsIgnoreCase("192.168.5.98")&&getEndIp.equalsIgnoreCase("192.168.5.98"))
	        {
	        	System.out.println("Pass");
	        	return true;
	        }
	        else
	        {
	        	System.out.println("Fail");
	        	return false;
	        }
	        
	        
		}
		
		
		
		
		public static boolean verifyClearBtnWhileUpdate() throws InterruptedException
		{
             Actions actions = new Actions(getDriver());
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(startIpValue));
			
			actions.doubleClick(startIpValue).perform();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(clearIp));
			
			clearIp.click();			
			
			Thread.sleep(2000);
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(fromIp));
		
			fromIp.click();
			
			getAction().moveToElement(fromIp).sendKeys(Keys.TAB).perform();
			
			getAction().moveToElement(toIp).sendKeys(Keys.SHIFT,Keys.TAB).perform();
			
			//getAction().moveToElement(fromIp).sendKeys(Keys.END).perform();
			
			//getAction().moveToElement(fromIp).sendKeys(Keys.SHIFT,Keys.HOME).perform();
			
			String getStartIpClear=fromIp.getAttribute("value");
		
			
			System.out.println(getStartIpClear);
		
			getAction().moveToElement(toIp).sendKeys(Keys.TAB).perform();
			
			String getEndIpclear=toIp.getAttribute("value");
			
	       
	        System.out.println(getEndIpclear);
	        
	        
	        if(getStartIpClear.equalsIgnoreCase("0.0.0.0")&&getEndIpclear.equalsIgnoreCase("0.0.0.0"))
	        {
	        	System.out.println("Pass");
	        	return true;
	        }
	        else
	        {
	        	System.out.println("Fail");
	        	return false;
	        }
			
		}
		
		
		
		public static void verifyCloseImageStartIpendIp()
		{
			Actions moveAction=new Actions(getDriver());
			
			moveAction.moveToElement(closeImage);
			moveAction.click().build().perform();
			

		}
		

		
		
		public static void verifyOkInAlertClickOnSaveAfterClickOnCloseImage() throws InterruptedException
		{
			
			 CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		
		     cco.waitForAlert();
		
		     String getExpectedCompMsg="Do you want to update empty ip range?";
		     
		     String actCompanySaveMsg=cco.getAlert().getText();
		     
		     Assert.assertEquals(actCompanySaveMsg, getExpectedCompMsg);
		     
		     System.out.println(actCompanySaveMsg);
		     
		     System.out.println(getExpectedCompMsg);
		     
		     cco.getAlert().accept();
		  
		     Thread.sleep(2000);
		     
 
		     

		}
		
		
		public static void clickOnCloseBtnInNetworkPolicy()
		{
			
			 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(closeBtnInNetworkPolicy));
			 closeBtnInNetworkPolicy.click();
			
		}
		
		
		
		
		public static void verifyCancekInAlertClickOnCancelAfterClickOnCloseImage() throws InterruptedException
		{
			
			 CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
		
		     cco.waitForAlert();
		     
		     String getExpectedCompMsg="Are you sure to close netWork policy?";
		     
		     String actCompanySaveMsg=cco.getAlert().getText();
		     
		     System.out.println(getExpectedCompMsg);
		     
		     System.out.println(actCompanySaveMsg);
		     
		     Assert.assertEquals(actCompanySaveMsg, getExpectedCompMsg);
		     
		     cco.getAlert().dismiss();
		     

		}
		
		
		
		
	   public static boolean getTheTitleAfterClickOnCancelBtnInAlertWhenUserClickOnCloseBtn()
	   {
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(networkPolicyTitle));
			
	        String getNetPolicyScreenName=networkPolicyTitle.getText();
	        
	        if(getNetPolicyScreenName.equalsIgnoreCase("Network Policy"))
	        {
	        	System.out.println("Pass : Cancel button is working in the Alert Of Close");
	        	return true;
	        }
	        else
	        {
	        	System.out.println("Fail : Cancel button is working in the Alert Of Close");
	        	return false;
	        }
		   
	      
	   }
	   
	   public static void verifyCloseAlertkInAlertClickOnOkBtn() throws InterruptedException
		{
			
			 CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
			
			 String getExpectedCompMsg="Are you sure to close netWork policy?";

		     cco.waitForAlert();
		     
		     String actCompanySaveMsg=cco.getAlert().getText();
		     
		     Assert.assertEquals(actCompanySaveMsg, getExpectedCompMsg);
		     
		     cco.getAlert().accept();
		     
		     Thread.sleep(2000);
		     
		}
	   
	   
		public static void OpenNetworkPolicy() throws InterruptedException
		{
			
			    String winHandleBefore =getDriver().getWindowHandle();

			    getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				homeMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(securityMenu));
				
				securityMenu.click();

				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(networkPolicy));
				
				networkPolicy.click();
			
		    

				
		}
	   
	   
		
	   
	   
	   
	   
	   public static boolean verifyStartIpAndEndIpAfterDelete()
		{
		
		   if(startIpValue.isDisplayed())
		   {
			   return false;
		   }
		   else
		   {
			   return true;
		   }
		   
			
		}
	   
	   
	   public boolean verifySavedIpIsdisplayingUserCloseReOpenTheNetworkpolicy()
	   {
	      
		   /* Actions actions = new Actions(getDriver());
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(startIpValue));
			
			actions.doubleClick(startIpValue).perform();
			
			Thread.sleep(2000);
			
			fromIp.click();*/

		   
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(startIpValue));
			
			String getStartIp=startIpValue.getText();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(endIpValue));
			
			String getEndIp=endIpValue.getText();
			
	        System.out.println(getStartIp);
	        System.out.println(getEndIp);
	        
	        if(getStartIp.equalsIgnoreCase("192.168.5.98") && getEndIp.equalsIgnoreCase("192.168.5.98"))
	        {
	        	System.out.println("Pass");
	        	return true;
	        }
	        else
	        {
	        	System.out.println("Fail");
	        	return false;
	        }
		   
		   
		   
		   
	   }
	   
	 public static void verifyAllowIP() throws InterruptedException
	 {
	
     	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(allowRadioBtn));
     	
     	allowRadioBtn.click();
     	
     	fromIp.click();
     	
     	getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
		getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
		getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
		getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
		getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
		getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
		getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
		
		fromIp.sendKeys("192.168.5.91");
		
		getAction().moveToElement(fromIp).sendKeys(Keys.TAB).perform();
		
		toIp.sendKeys("192.168.5.91");
		
		addIp.click();
		
/*		saveBtnInNetworkPolicy.click();
		
		closeMsgNPGlobalError.click();*/
	 
	 }
	 
	 
	 
	 
	 public static boolean verifyAllowIpInNetworkPolicy() throws InterruptedException
	   {
	      
		    Actions actions = new Actions(getDriver());
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(startIpValue));
			
			actions.doubleClick(startIpValue).perform();
			
			Thread.sleep(2000);
			
			fromIp.click();		  
		 
		 
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(startIpValue));
			
			String getStartIp=startIpValue.getText();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(endIpValue));
			
			String getEndIp=endIpValue.getText();
			
	        System.out.println(getStartIp);
	        System.out.println(getEndIp);
	        
	        if(getStartIp.equalsIgnoreCase("192.168.5.91") && getEndIp.equalsIgnoreCase("192.168.5.91"))
	        {
	        	System.out.println("Pass : Deleted IP is not displaying in the Network policy");
	        	return true;
	        }
	        else
	        {
	        	System.out.println("Fail : Deleted IP is displaying in the Network policy");
	        	return false;
	        }
		   
		   
		   
		   
	   }
	 
	 
	 
	 
	 
	 
	 
		
		public HomeMenuSecurityNetworkPolicyPage(WebDriver driver)
		{
			
			PageFactory.initElements(driver, this);
			
		}
		

	

}
