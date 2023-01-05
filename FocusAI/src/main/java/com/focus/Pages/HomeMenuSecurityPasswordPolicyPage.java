package com.focus.Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.focus.base.BaseEngine;

public class HomeMenuSecurityPasswordPolicyPage extends BaseEngine
{

	//Home Menu
	@FindBy (xpath="//*[@id='1']/div/span")
    private static WebElement homeMenu;

	//Security Menu	
	@FindBy (xpath="//*[@id='6']/span")
    private static WebElement securityMenu;
	
	//Password Policy Menu
	@FindBy (xpath="//*[@id='8']/span")
    private static WebElement passwordPolicySubMenu;
	
	//Password Policy Screen Title
	@FindBy (xpath="//*[@id='securityNavBar']/div/div[1]/a/div/span[2]")
    private static WebElement passwordPolicyTitle;
	
	//Password Policy List
	@FindBy (xpath="//*[@id='PolicyListDiv']")
	private static WebElement passwordPolicyList;

	    //Password Policy Name in the List
		@FindBy (xpath="//html[1]/body[1]/section[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]")
		private static WebElement passwordPolicyNameInList;
	
		//Password Policy Name in the List
		@FindBy (xpath="//html[1]/body[1]/section[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]")
		private static WebElement passwordPolicyDeleteInList;
			
	//Password Policy AddBtn
	@FindBy (xpath="//*[@id='addPasswordPolicybtn']/i")
	private static WebElement passwordPolicyAddBtn;
	
	//Password Policy DeleteBtn
	@FindBy (xpath="//*[@id='controlBtns']/span[2]/i")
	private static WebElement passwordPolicyDeletebtn;
	
	//Password Policy CancelBtn
	@FindBy (xpath="//*[@id='controlBtns']/span[3]/i")
	private static WebElement passwordPolicyCancelBtn;
	
	//Password Policy SaveBtn
	@FindBy (xpath="//*[@id='btnSaveId']/i")
	private static WebElement passwordPolicySaveBtn;
	
    //Password Policy CloseBtn
  	@FindBy (xpath="//*[@id='myNavbar']/ul/li/span[2]/i")
  	private static WebElement passwordPolicyCloseBtn;
	
    //Password Policy policyName
  	@FindBy (xpath="//*[@id='policyName']")
  	private static WebElement policyName;

    //Password Policy passwordLength
  	@FindBy (xpath="//*[@id='MinPassLength']")
  	private static WebElement passwordLength;
   	
    //Password Policy passwordComplexity
  	@FindBy (xpath="//*[@id='complexity']")
  	private static WebElement passwordComplexity;
  	
    //Password Policy doNotAllowPreviousPassword
  	@FindBy (xpath="//*[@id='Donotallprevious']")
  	private static WebElement doNotAllowPrevious;
  	
    //Password Policy passwordExpiryDays
  	@FindBy (xpath="//*[@id='passwordexpirydays']")
  	private static WebElement passwordExpiryDays;
  	
    //Password Policy passwordOTPExpiryInMins
  	@FindBy (xpath="//*[@id='OTPexpiryinminute']")
  	private static WebElement passwordExpiryInMins;
  	
    //Password Policy passwordInvalidAttempts
  	@FindBy (xpath="//*[@id='NoOfInvalidAttemps']")
  	private static WebElement passwordInvalidAttempts;
  	
    //Password Policy passwordLockOut
  	@FindBy (xpath="//*[@id='Lockoutperiod']")
  	private static WebElement passwordLockOut;
  	
    //Password Policy passwordLockOutUnits
  	@FindBy (xpath="//*[@id='Units']")
  	private static WebElement passwordLockOutUnits;
  	
    //Password Policy sendMailCheck
  	@FindBy (xpath="//*[@id='Sendemailchk']")
  	private static WebElement sendMailCheck;
  	
    //Password Policy sendMailOnSuccess
  	@FindBy (xpath="//*[@id='sendemailonloginsuccesschk']")
  	private static WebElement sendMailOnSuccess;
  	
  	
    //Password Policy sendMailOnFailure
  	@FindBy (xpath="//*[@id='Sendemailonloginfailurechk']")
  	private static WebElement sendMailOnFailure;
  	
  	//Password Policy sendMailOnFailure
  	@FindBy (xpath="//*[@id='PolicyDiv']/div[14]/div/label")
  	private static WebElement changePasswordAfterFirstLogin;
  	
  	//Password Policy sendMailOnFailure
  	@FindBy (xpath="//*[@id='PolicyDiv']/div[15]/div/label")
  	private static WebElement cannotChangePassword;
  	
  	//Password Policy sendMailOnFailure
  	@FindBy (xpath="//*[@id='PolicyDiv']/div[16]/div/label")
  	private static WebElement otpBasedLogin;
  	
  	//Password Policy sendMailOnFailure
  	@FindBy (xpath="//*[@id='sendEmailId']")
  	private static WebElement sendEmailId;
  	
  	//Password Policy sendMailOnFailure
  	@FindBy (xpath="//*[@id='sendemailonloginsuccessId']")
  	private static WebElement sendEmailOnLoginSuccess;
  	
  	//Password Policy sendMailOnFailure
  	@FindBy (xpath="//*[@id='SendemailonloginfailureId']")
  	private static WebElement sendEmailOnLoginFailure;
  	
	@FindBy(xpath="//*[@id='idGlobalError']/div/table/tbody/tr/td[2]/div[2]")
	private static WebElement msgPasswordGlobalError;
	
	@FindBy(xpath="//*[@id='idGlobalError']/div/table/tbody/tr/td[3]/span")
	private static WebElement closeMsgPasswordGlobalError;

  	
  	
	public static void navigateToPasswordPolicySubMenu()
	{
		
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
		
		homeMenu.click();
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(securityMenu));
		
		securityMenu.click();
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicySubMenu));
		
		passwordPolicySubMenu.click();
		
  	
  	
	}
	
	
	
	public static boolean openPasswordPolicyverifyQCSubMenus()
	{
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyTitle));
		
		String getPasswordPolicyScreenName=passwordPolicyTitle.getText();

		System.out.println(getPasswordPolicyScreenName);
		
		if(getPasswordPolicyScreenName.equalsIgnoreCase("Password policy"))
		  {
			System.out.println("Pass : Password Policy Title is displaying Corrrect");
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyList));
			  
			  if(passwordPolicyList.isDisplayed())
			  {
				  System.out.println("pass passwordPolicyList");
				  
				  if(passwordPolicyAddBtn.isDisplayed())
				  {
					  System.out.println("pass passwordPolicyAddBtn");
		
					  if(passwordPolicyAddBtn.isDisplayed())
					  {
						  System.out.println("pass passwordPolicyAddBtn");
			
						  if(passwordPolicyDeletebtn.isDisplayed())
						  {
							  System.out.println("pass passwordPolicyDeletebtn");
				
							  if(passwordPolicyCancelBtn.isDisplayed())
							  {
								  System.out.println("pass passwordPolicyCancelBtn");
					
								  if(passwordPolicySaveBtn.isDisplayed())
								  {
									  System.out.println("pass passwordPolicySaveBtn");
						              
									  if(passwordPolicyCloseBtn.isDisplayed())
									  {
										  System.out.println("pass passwordPolicyCloseBtn");
							
										  if(policyName.isDisplayed())
										  {
											  System.out.println("pass policyName");
								
											  if(passwordLength.isDisplayed())
											  {
												  System.out.println("pass passwordLength");
												  
												  if(passwordComplexity.isDisplayed())
												  {
													  System.out.println("pass passwordComplexity");
													 
													  if(doNotAllowPrevious.isDisplayed())
													  {
														  System.out.println("pass doNotAllowPrevious");
														 
														  if(passwordExpiryDays.isDisplayed())
														  {
															  System.out.println("pass passwordExpiryDays");
															 
															  if(passwordExpiryInMins.isDisplayed())
															  {
																  System.out.println("pass passwordExpiryInMins");
																 
																  if(passwordInvalidAttempts.isDisplayed())
																  {
																	  System.out.println("pass passwordInvalidAttempts");
																	 
																	  if(passwordLockOut.isDisplayed())
																	  {
																		  System.out.println("pass passwordLockOut");
																		 
																		  if(passwordLockOutUnits.isDisplayed())
																		  {
																			  System.out.println("pass passwordLockOutUnits");
																			 
																			  if(sendMailCheck.isDisplayed())
																			  {
																				  System.out.println("pass sendMailCheck");
																				 
																				  if(sendMailOnSuccess.isDisplayed())
																				  {
																					  System.out.println("pass sendMailOnSuccess");
																					 
																					  if(sendMailOnFailure.isDisplayed())
																					  {
																						  System.out.println("pass sendMailOnFailure");
																						 
																						  return true;
																						  }
																						  else
																						  {
																							  System.out.println("Fail sendMailOnFailure");
																							  return false;
																						  }  
																					  }
																					  else
																					  {
																						  System.out.println("Fail sendMailOnSuccess");
																						  return false;
																					  }  
																				  }
																				  else
																				  {
																					  System.out.println("Fail sendMailCheck");
																					  return false;
																				  }  
																			  }
																			  else
																			  {
																				  System.out.println("Fail passwordLockOutUnits");
																				  return false;
																			  }  
																		  }
																		  else
																		  {
																			  System.out.println("Fail passwordLockOut");
																			  return false;
																		  }  
																	  }
																	  else
																	  {
																		  System.out.println("Fail passwordInvalidAttempts");
																		  return false;
																	  }  
																  }
																  else
																  {
																	  System.out.println("Fail passwordExpiryInMins");
																	  return false;
																  }  
															  }
															  else
															  {
																  System.out.println("Fail passwordExpiryDays");
																  return false;
															  }  
														  }
														  else
														  {
															  System.out.println("Fail doNotAllowPrevious");
															  return false;
														  }  
													  }
													  else
													  {
														  System.out.println("Fail passwordComplexity");
														  return false;
													  }  

												  }
												  else
												  {
													  System.out.println("Fail passwordLength");
													  return false;
												  }  
											  }
											  else
											  {
												  System.out.println("Fail policyName");
												  return false;
											  }  

											  
										  }
										  else
										  {
											  System.out.println("Fail passwordPolicyCloseBtn");
											  return false;
										  }  
									  }

									  else
									  {
										  System.out.println("Fail passwordPolicySaveBtn");
										  return false;
									  }  
								  }
								  else
								  {
									  System.out.println("Fail passwordPolicyCancelBtn");
									  return false;
								  }  
							  }

							  else
							  {
								  System.out.println("Fail passwordPolicyDeletebtn");
								  return false;
							  }  
						  }

						  else
						  {
							  System.out.println("Fail passwordPolicyAddBtn");
							  return false;
						  }  
					  }

					  else
					  {
						  System.out.println("Fail passwordPolicyTitle");
						  return false;
					  }  
				  }

				  else
				  {
					  System.out.println("Fail passwordPolicyList");
					  return false;
				  }  
			  }

			  else
			  {
				  System.out.println("Fail Password Policy Title is displaying Wrong");
				  return false;
			  }  
		  }
	
	
	public boolean checkPolicyNameAsMandatory()
	{
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyAddBtn));
		passwordPolicyAddBtn.click();
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicySaveBtn));
		passwordPolicySaveBtn.click();
		
		String getPolciyNameAsMandatoryMsg=msgPasswordGlobalError.getText();
		
		System.out.println(getPolciyNameAsMandatoryMsg);
		
		if(getPolciyNameAsMandatoryMsg.equalsIgnoreCase("Provide your policy name"))
		{
			System.out.println("Pass : Policy Name as mandatory message is displaying");
			closeMsgPasswordGlobalError.click();
			return true;
		}
		else
		{
			System.out.println("Fail : Policy Name as mandatory message is not displaying");
			closeMsgPasswordGlobalError.click();
			return false;
		}
		
		
	}
	
	
	public boolean checkMinimumPasswordLengthAsMandatory()
	{
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(policyName));
		policyName.sendKeys("Simple Policy");
		
		passwordPolicySaveBtn.click();
		
        String getPasswordLengthAsMandatoryMsg=msgPasswordGlobalError.getText();
		
		System.out.println(getPasswordLengthAsMandatoryMsg);
		
		if(getPasswordLengthAsMandatoryMsg.equalsIgnoreCase("Provide password length"))
		{
			System.out.println("Pass : Policy Password Length as mandatory message is displaying");
			closeMsgPasswordGlobalError.click();
			return true;
		}
		else
		{
			System.out.println("Fail : Policy Password length as mandatory message is not displaying");
			closeMsgPasswordGlobalError.click();
			return false;
		}
	}
	
	
	
	public boolean checkMinimumPasswordLengthAsNumericFields()
	{
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(policyName));
		
		passwordLength.sendKeys("4Test");
		
        String getPasswordLengthNumeric=passwordLength.getAttribute("value");
		
		System.out.println(getPasswordLengthNumeric);
		
		if(getPasswordLengthNumeric.equalsIgnoreCase("4"))
		{
			System.out.println("Pass : Policy Password Length accepts Numeric");
            return true;
		}
		else
		{
			System.out.println("Fail : Policy Password Length not accepting Numeric");
			return false;
		
		}
	}
	
	
	public static boolean checkComplexity()
	{
		
		Select complexity = new Select(passwordComplexity);
		
		String[] complexityValues={"Simple","Alphabets","Alpha-numeric","Alpha-numeirc*","Numeric","Alpha-numeric & special characters","Alpha-numeric & special characters*"};
		 
		int count=0;
		
		boolean q=true;
		
	    List<WebElement> options=complexity.getOptions();
	    
	    
	    for(WebElement we:options)
	    {
	    	for(int i=0;i<complexityValues.length;i++)
	    	{
	    		if(we.getText().equalsIgnoreCase(complexityValues[i]))
	    		{
	    			count=count+1;
	    		
	    		}

	    	}	    	
	    }
	   
	    
	    if(count==6)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	
		
		
	}
	
	
	public static boolean checkPasswordPolicySimpleSave()
	{
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicySaveBtn));
		
		passwordPolicySaveBtn.click();
		
        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
		
		System.out.println(getPasswordSaveSimpleMsg);
		
		if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Password policy created successfully"))
		{
			System.out.println("Pass : Password policy Simple complexity Save message is displaying");
			closeMsgPasswordGlobalError.click();
			return true;
		}
		else
		{
			System.out.println("Fail : Password policy Simple complexity Save message is not displaying");
			closeMsgPasswordGlobalError.click();
			return false;
		}
		
	}
	
	
	
	public static boolean checkPasswordPolicyLists()
	{
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyNameInList));
		
		passwordPolicyNameInList.click();
		
        String getPasswordSaveListName=passwordPolicyNameInList.getText();
		
		System.out.println(getPasswordSaveListName);
		
		if(getPasswordSaveListName.equalsIgnoreCase("Simple Policy"))
		{
			System.out.println("Pass : Password policy Simple is displaying");
			//closeMsgPasswordGlobalError.click();
			return true;
		}
		else
		{
			System.out.println("Fail : Password policy Simple is not displaying");
			//closeMsgPasswordGlobalError.click();
			return false;
		}
		
	}
	
	
	
	
	public static boolean checkGetTheSimplePasswordPolicy()
	{
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyNameInList));
		
		passwordPolicyNameInList.click();
		
        String getPolicyName=policyName.getAttribute("value");
		        
        String getPolicyMinPasswordLength=passwordLength.getAttribute("value");
        
        String getPolicyComplexity=passwordComplexity.getText();
        
		System.out.println(getPolicyName);
		System.out.println(getPolicyMinPasswordLength);
		System.out.println("getPolicyComplexity"+getPolicyComplexity);
		
		Select complexity = new Select(passwordComplexity);

		List<WebElement> options=complexity.getOptions();
		
		if(getPolicyName.equalsIgnoreCase("Simple Policy"))
		{
			System.out.println("Pass : Password policy Simple is displaying");
			//closeMsgPasswordGlobalError.click();
			if(getPolicyMinPasswordLength.equalsIgnoreCase("4"))
			{
				System.out.println("Pass : Password policy Simple is displaying");

						
					WebElement comboBox = passwordComplexity;
					Select selectedValue = new Select(comboBox);
					String wantedText = selectedValue.getFirstSelectedOption().getText();
					System.out.println("wantedText"+wantedText);
				
					
					if(wantedText.equalsIgnoreCase("Simple"))
					{
					    System.out.println("Pass : Password policy Complexity Simple is dipslaying");
						return true;
				    }    

				else
				{
					System.out.println("Fail : Password policy Complexity Simple is not displaying");
					//closeMsgPasswordGlobalError.click();
					return false;
				}
			}
			else
			{
				System.out.println("Fail : Password policy Simple is not displaying");
				//closeMsgPasswordGlobalError.click();
				return false;
			}
		}
		else
		{
			System.out.println("Fail : Password policy Simple is not displaying");
			//closeMsgPasswordGlobalError.click();
			return false;
		}
		
	}
	
	
	
	public static boolean checkUpdateSimplePasswordPolicy()
	{
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyNameInList));
		
		passwordPolicyNameInList.click();
				
		getAction().moveToElement(passwordLength).sendKeys(Keys.END).perform();
		
		getAction().moveToElement(passwordLength).sendKeys(Keys.BACK_SPACE).perform();
		
		passwordLength.sendKeys("3");
				
        passwordPolicySaveBtn.click();
		
        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
		
		System.out.println(getPasswordSaveSimpleMsg);
		
		if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Password policy updated successfully"))
		{
			System.out.println("Pass : Password policy Simple complexity Save message is displaying");
			closeMsgPasswordGlobalError.click();
			return true;
		}
		else
		{
			System.out.println("Fail : Password policy Simple complexity Save message is not displaying");
			closeMsgPasswordGlobalError.click();
			return false;
		}
		
	}
	
	
	public static boolean checkGetTheUpdatedPasswordPolicy()
	{
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyNameInList));
		
		passwordPolicyNameInList.click();
		
					WebElement comboBox = passwordComplexity;
					Select selectedValue = new Select(comboBox);
					String wantedText = selectedValue.getFirstSelectedOption().getText();
					System.out.println("wantedText"+wantedText);
				
					
					if(wantedText.equalsIgnoreCase("Simple"))
					{
					    System.out.println("Pass : Password Policy, Updated Complexity is displaying Correct");
						return true;
				    }    
					else
					{
						System.out.println("Fail : Password policy, Updated Complexity is not displaying Correct");
						return false;
					}

		
	}
	
	
	
	public static void checkCloseBtnInPasswordpolicy() throws InterruptedException
	{
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyCloseBtn));
		passwordPolicyCloseBtn.click();
		
    	LoginPage lp=new LoginPage(getDriver());
    	
    	Assert.assertEquals(lp.verifyUserHomePageAndDashBoard(), true);
		
	}
	
	
	
	
	public static void checkAlertOnDeletePasswordPolicy() throws InterruptedException
	{
		
					 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyNameInList));
					 
					 passwordPolicyNameInList.click();
					 					
					 passwordPolicyDeletebtn.click();

					 CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
					
				     cco.waitForAlert();
				
				     String getExpectedCompMsg="Are you sure that you want to delete this policy?";
				     
				     String actCompanySaveMsg=cco.getAlert().getText();
				     
				     Assert.assertEquals(actCompanySaveMsg, getExpectedCompMsg);
				     
				     System.out.println(actCompanySaveMsg);
				     
				     System.out.println(getExpectedCompMsg);
				     
				     cco.getAlert().dismiss();
				  
				     Thread.sleep(2000);
								
					
       	}
	
	
	
	
	public static boolean checkCancelInAlertDeletePasswordPolicy() throws InterruptedException
	{

		 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyNameInList));
		 passwordPolicyNameInList.click();

			
					String getPasswordSaveListName=passwordPolicyNameInList.getText();
					
					System.out.println(getPasswordSaveListName);
					
					if(getPasswordSaveListName.equalsIgnoreCase("Simple Policy"))
					{
						System.out.println("Pass : Password policy Simple is displaying");
						//closeMsgPasswordGlobalError.click();
						return true;
					}
					else
					{
						System.out.println("Fail : Password policy Simple is not displaying");
						//closeMsgPasswordGlobalError.click();
						return false;
					}
					
	
					
					
	}
	
	
	
	public static boolean checkOkInAlertDeletePasswordPolicy() throws InterruptedException
	{
		
		
		 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyNameInList));
		 passwordPolicyNameInList.click();
							
		            passwordPolicyDeletebtn.click();
		 			
					CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
						
				    cco.waitForAlert();
				     
				    cco.getAlert().accept();
					
				    String getPasswordpolicyDeleteSimpleMsg=msgPasswordGlobalError.getText();
					
					System.out.println(getPasswordpolicyDeleteSimpleMsg);
					
					if(getPasswordpolicyDeleteSimpleMsg.equalsIgnoreCase("Policy removed Successfully"))
					{
						System.out.println("Pass : Password policy Simple is Deleted Successfully Message is displaying");
						closeMsgPasswordGlobalError.click();
						return true;
					}
					else
					{
						System.out.println("Fail : Password policy Simple is Deleted Successfully Message is not displaying");
						closeMsgPasswordGlobalError.click();
						return false;
					}				
					
	}
	
	
	public static boolean checkSaveSimpleAfterDeletePasswordpolicy()
	{
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyAddBtn));
				
				passwordPolicyAddBtn.click();
		
				policyName.sendKeys("Simple Policy");
		
				passwordLength.sendKeys("4");
				
				
				//getAction().moveToElement(fromIp).sendKeys(Keys.BACK_SPACE).perform();
				
				getAction().moveToElement(passwordLength).sendKeys(Keys.TAB).perform();
				
				
				
				WebElement comboBox = passwordComplexity;
				Select selectedValue = new Select(comboBox);
				selectedValue.selectByIndex(0);
				
				
	
		
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicySaveBtn));
				
				passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Password policy created successfully"))
				{
					System.out.println("Pass : Password policy Simple complexity Save message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Password policy Simple complexity Save message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
	}
	
	
	
	public static boolean checkSaveAlphabetsWithDoNotAllowPreviousPasswordpolicy()
	{
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyAddBtn));
		
		passwordPolicyAddBtn.click();

		policyName.sendKeys("Alphabets with Dont allow Previous as Three");

		passwordLength.sendKeys("4");
		
		getAction().moveToElement(passwordLength).sendKeys(Keys.TAB).perform();
		
		
		
		WebElement comboBox = passwordComplexity;
		Select selectedValue = new Select(comboBox);
		selectedValue.selectByIndex(1);
		
		
		doNotAllowPrevious.sendKeys("3");

		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicySaveBtn));
		
		passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Password policy created successfully"))
				{
					System.out.println("Pass : Password policy Alphabets complexity Save message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Password policy Alphabets complexity Save message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
	}
	
	
	public static boolean checkSaveAlphanumericPasswordpolicy()
	{
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyAddBtn));
		
		passwordPolicyAddBtn.click();

		policyName.sendKeys("Alphabets With Numeric");

		passwordLength.sendKeys("4");
		
		getAction().moveToElement(passwordLength).sendKeys(Keys.TAB).perform();
		
		
		
		WebElement comboBox = passwordComplexity;
		Select selectedValue = new Select(comboBox);
		selectedValue.selectByIndex(2);
		
		


		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicySaveBtn));
		
		passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Password policy created successfully"))
				{
					System.out.println("Pass : Password policy Alphabets complexity Save message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Password policy Alphabets complexity Save message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
	}
	
	
	
	public static boolean checkSaveAlphanumericStarPasswordpolicy()
	{
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyAddBtn));
		
		passwordPolicyAddBtn.click();

		policyName.sendKeys("Alphabets With Numeric Star");

		passwordLength.sendKeys("4");
		
		getAction().moveToElement(passwordLength).sendKeys(Keys.TAB).perform();
		
		
		
		WebElement comboBox = passwordComplexity;
		Select selectedValue = new Select(comboBox);
		selectedValue.selectByIndex(3);
		
		


		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicySaveBtn));
		
		passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Password policy created successfully"))
				{
					System.out.println("Pass : Password policy Alphabets complexity Save message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Password policy Alphabets complexity Save message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
	}
	
	
	
	public static boolean checkSaveNumericPasswordpolicy()
	{
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyAddBtn));
		
		passwordPolicyAddBtn.click();

		policyName.sendKeys("Numeric");

		passwordLength.sendKeys("5");
		
		getAction().moveToElement(passwordLength).sendKeys(Keys.TAB).perform();
		
		
		
		WebElement comboBox = passwordComplexity;
		Select selectedValue = new Select(comboBox);
		selectedValue.selectByIndex(4);
		
		


		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicySaveBtn));
		
		passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Password policy created successfully"))
				{
					System.out.println("Pass : Password policy Alphabets complexity Save message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Password policy Alphabets complexity Save message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
	}
	
	
	
	
	
	public static boolean checkSaveAlphaNumericSpecialPasswordPolicy()
	{
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyAddBtn));
		
		passwordPolicyAddBtn.click();

		policyName.sendKeys("Alpha Numeric Special");

		passwordLength.sendKeys("6");
		
		getAction().moveToElement(passwordLength).sendKeys(Keys.TAB).perform();
		
		
		
		WebElement comboBox = passwordComplexity;
		Select selectedValue = new Select(comboBox);
		selectedValue.selectByIndex(5);
		
		


		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicySaveBtn));
		
		passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Password policy created successfully"))
				{
					System.out.println("Pass : Password policy Alphabets complexity Save message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Password policy Alphabets complexity Save message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
	}
	
	
	
	

	public static boolean checkInputAlphaNumericSpecialStarPasswordpolicy()
	{
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyAddBtn));
		
		passwordPolicyAddBtn.click();

		policyName.sendKeys("Alpha Numeric Special Star with all options");

		passwordLength.sendKeys("12");
		
		getAction().moveToElement(passwordLength).sendKeys(Keys.TAB).perform();
	
		WebElement comboBox = passwordComplexity;
		Select selectedValue = new Select(comboBox);
		selectedValue.selectByIndex(6);
		
		doNotAllowPrevious.sendKeys("1");

		getAction().moveToElement(doNotAllowPrevious).sendKeys(Keys.TAB).perform();
		
		passwordExpiryDays.sendKeys("1");
		
		getAction().moveToElement(passwordExpiryDays).sendKeys(Keys.TAB).perform();
		
		passwordExpiryInMins.sendKeys("1");
		
		getAction().moveToElement(passwordExpiryInMins).sendKeys(Keys.TAB).perform();
		
		passwordInvalidAttempts.sendKeys("1");
		
		getAction().moveToElement(passwordInvalidAttempts).sendKeys(Keys.TAB).perform();
		
		passwordLockOut.sendKeys("1");
		
		getAction().moveToElement(passwordLockOut).sendKeys(Keys.TAB).perform();
		
        Select lockout = new Select(passwordLockOutUnits);
		
		String[] complexityValues={"Unit","Minute","Hour","Day"};
		 
		int count=0;
		
		boolean q=true;
		
	    List<WebElement> options=lockout.getOptions();
	    
	    
	    for(WebElement we:options)
	    {
	    	for(int i=0;i<complexityValues.length;i++)
	    	{
	    		if(we.getText().equalsIgnoreCase(complexityValues[i]))
	    		{
	    			count=count+1;
	    		
	    		}

	    	}	    	
	    }
	   
	    
	    if(count==3)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }

	    
	}
	
	
	
	
  public static boolean checkMandatoyEmailAlphaNumericSpecailStarAllOptions()
  {
	 
	  Select lockout = new Select(passwordLockOutUnits);
	  
	  lockout.selectByIndex(1);
		
	  getAction().moveToElement(passwordLockOutUnits).sendKeys(Keys.TAB).perform();
	  
	  sendMailCheck.click();
	 
	  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicySaveBtn));
		
	  passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Provide email address for Send E-Mail"))
				{
					System.out.println("Pass : Provide email address for Send E-Mail Validation message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Provide email address for Send E-Mail Validation message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
		
  }
	
  
  public static boolean checkMandatoryEmailOnLoginSuccess()
  {
	  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(sendEmailId));
	  
	  sendEmailId.sendKeys("naveenkumar@focussoftnet.com");
	  
	  getAction().moveToElement(sendEmailId).sendKeys(Keys.TAB).perform();
	  
	  sendMailOnSuccess.click();
	
	  passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Provide email address for Send E-Mail on login success"))
				{
					System.out.println("Pass : Provide email address for Send E-Mail on Login Success Validation message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Provide email address for Send E-Mail on Login Success Validation message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
				
  }
	
	
  
  
  public static boolean checkMandatoryEmailOnLoginFailure()
  {
	  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(sendEmailId));
	  
	  sendEmailOnLoginSuccess.sendKeys("naveenkumar@focussoft");
	  
	  getAction().moveToElement(sendEmailOnLoginSuccess).sendKeys(Keys.TAB).perform();
	  
	  sendMailOnFailure.click();
	  
	  passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Provide email address for Send E-Mail on login failure"))
				{
					System.out.println("Pass : Provide email address for Send E-Mail on login failure Validation message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Provide email address for Send E-Mail on login failure Validation message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
  }

  
  public static boolean checkValidEmailOnSendEmailId()
  {
	  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(sendEmailId));
	  	  
	  sendEmailId.click();
	  
	  sendEmailId.clear();
	  
	  sendEmailId.sendKeys("naveenkumar");
	  
	  passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Invalid email address"))
				{
					System.out.println("Pass : Invalid email address message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Invalid email address message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
  }

  public static boolean checkValidEmailOnLoginSucess()
  {
	  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(sendEmailId));
	  
	  sendEmailId.clear();
	  
	  sendEmailId.sendKeys("naveenkumar@focussoftnet.com");
	  
	  getAction().moveToElement(sendEmailId).sendKeys(Keys.TAB).perform();
	  
	  sendMailOnSuccess.click();
	   
	  sendEmailOnLoginSuccess.sendKeys("naveenkumar");
	  
	  //sendEmailOnLoginFailure.sendKeys("naveenkumar@focussoftnet.com");
		
		passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Invalid email address"))
				{
					System.out.println("Pass : Invalid email address message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Invalid email address message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
  }

  public static boolean checkValidEmailOnLoginFailure()
  {
	  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(sendEmailId));
	  
	  sendEmailOnLoginSuccess.clear();
	  
	  sendEmailOnLoginSuccess.sendKeys("naveenkumar@focussoftnet.com");
	  
	  getAction().moveToElement(sendEmailOnLoginSuccess).sendKeys(Keys.TAB).perform();
	  
	  sendMailOnFailure.click();
	  
	  sendEmailOnLoginFailure.sendKeys("naveenkumar");
		
		passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Invalid email address"))
				{
					System.out.println("Pass : Invalid email address message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Invalid email address message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
  }

  
  public static boolean checkSavePasswordPolicyWithAllOptions()
  {
	  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(sendEmailId));
	  
	  sendEmailId.clear();
	  sendEmailId.sendKeys("naveenkumar@focussoftnet.com");
	  
	  sendEmailOnLoginSuccess.clear();
	  sendEmailOnLoginSuccess.sendKeys("naveenkumar@focussoftnet.com");
	  
	  sendEmailOnLoginFailure.clear();
	  sendEmailOnLoginFailure.sendKeys("naveenkumar@foussoftnet.com");
		
      changePasswordAfterFirstLogin.click();
	  
	  getAction().moveToElement(changePasswordAfterFirstLogin).sendKeys(Keys.TAB).perform();
	  
	  cannotChangePassword.click();
	  
	  getAction().moveToElement(cannotChangePassword).sendKeys(Keys.TAB).perform();
	  
	  otpBasedLogin.click();
	  
	  
	  
		passwordPolicySaveBtn.click();
				
		        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
				
				System.out.println(getPasswordSaveSimpleMsg);
				
				if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Password policy created successfully"))
				{
					System.out.println("Pass : Invalid email address message is displaying");
					closeMsgPasswordGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Invalid email address message is not displaying");
					closeMsgPasswordGlobalError.click();
					return false;
				}
  }
  
  
  
  
  
  
  
  
  public static boolean checkCannotChangePasswordInPasswordPolicy()
  {
	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyAddBtn));
		
		passwordPolicyAddBtn.click();

		policyName.sendKeys("Simple With Cannot Change Password");

		passwordLength.sendKeys("2");
		
		getAction().moveToElement(passwordLength).sendKeys(Keys.TAB).perform();
		
		getAction().moveToElement(passwordComplexity).sendKeys(Keys.TAB).perform();
		
		//doNotAllowPrevious.sendKeys("1");

		getAction().moveToElement(doNotAllowPrevious).sendKeys(Keys.TAB).perform();
		
		//passwordExpiryDays.sendKeys("1");
		
		getAction().moveToElement(passwordExpiryDays).sendKeys(Keys.TAB).perform();
		
		//passwordExpiryInMins.sendKeys("1");
		
		getAction().moveToElement(passwordExpiryInMins).sendKeys(Keys.TAB).perform();
		
		//passwordInvalidAttempts.sendKeys("1");
		
		getAction().moveToElement(passwordInvalidAttempts).sendKeys(Keys.TAB).perform();
		
		//passwordLockOut.sendKeys("1");
		
		getAction().moveToElement(passwordLockOut).sendKeys(Keys.TAB).perform();
		
		 getAction().moveToElement(passwordLockOutUnits).sendKeys(Keys.TAB).perform();
		
		getAction().moveToElement(sendMailCheck).sendKeys(Keys.TAB).perform();
		getAction().moveToElement(sendMailOnSuccess).sendKeys(Keys.TAB).perform();
		getAction().moveToElement(sendMailOnFailure).sendKeys(Keys.TAB).perform();
		
		
		 getAction().moveToElement(changePasswordAfterFirstLogin).sendKeys(Keys.TAB).perform();
		 
		 cannotChangePassword.click();
		
		 
		 passwordPolicySaveBtn.click();
			
	        String getPasswordSaveSimpleMsg=msgPasswordGlobalError.getText();
			
			System.out.println(getPasswordSaveSimpleMsg);
			
			if(getPasswordSaveSimpleMsg.equalsIgnoreCase("Password policy created successfully"))
			{
				System.out.println("Pass : Invalid email address message is displaying");
				closeMsgPasswordGlobalError.click();
				return true;
			}
			else
			{
				System.out.println("Fail : Invalid email address message is not displaying");
				closeMsgPasswordGlobalError.click();
				return false;
			}
		 
  }
  
  
  
  public static boolean checkCancelBtnInPasswordPolicy()
  {
	  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordPolicyAddBtn));
		
		passwordPolicyAddBtn.click();

		policyName.sendKeys("Simple With Cannot Change Password");

		passwordLength.sendKeys("2");
		
		passwordPolicyCancelBtn.click();
		
		String getPolicyNameTxt=policyName.getText();
		
		String getPasswordLength=passwordLength.getText();
		
		if(getPolicyNameTxt.equalsIgnoreCase("")&&getPasswordLength.equalsIgnoreCase(""))
		{
			
		System.out.println("Pass : Cancel button is working");
		return true;
		}
		
		else
		{
		System.out.println("Fail : Cancel button is not working");
	    return false;		
		}
		
	
  }
  
  
  
  
	public HomeMenuSecurityPasswordPolicyPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
  	
}

