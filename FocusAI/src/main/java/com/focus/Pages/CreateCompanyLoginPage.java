package com.focus.Pages;

import  com.focus.base.BaseEngine;

import java.util.List;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;

import com.focus.base.BaseEngine;
import com.focus.supporters.ExcelReader;
import com.focus.testcases.LoginPageTest;
import com.focus.Pages.LoginPage;

import com.focus.utilities.POJOUtility;

public class CreateCompanyLoginPage extends BaseEngine 
{

	private static LoginPage lp;
	
	@FindBy(xpath="//i[@title='Create Company']")
    private static WebElement companyCreateBtn;
	
	@FindBy(xpath="//*[@id='CompanyName']")
	private static WebElement companyName;
	
	@FindBy(xpath="//div[@id='errorCompanyName']")
	private static WebElement getCompanyNameError;
	
	@FindBy(xpath="//*[@id='CalendarType']")
	private static WebElement calendarType;
	
	@FindBy(xpath="//*[@id='CreatedDate_input_image']/span")
	private static WebElement datePicker;	
	
	@FindBy(xpath="//input[@id='CreatedDate']")
	private static WebElement accountingDate;
	
	@FindBy(xpath="//*[@id='CreatedDate_day_today']/td/span[2]")
	private static WebElement getDate;
	
	@FindBy(id="securityNormal")
	private static WebElement securityNormal;
	
	@FindBy(id="securityLow")
	private static WebElement securityLow;
	
    @FindBy(id="securityHigh")
    private static WebElement securityHigh;
	
	@FindBy(xpath="//input[@id='SUserPassword']")
    private static WebElement passwordSU;
	
	@FindBy(xpath=" //div[@id='errorUserPassword']")
	private static WebElement getPasswordErrorMsg;
	
	@FindBy(id="chkRemeberLoginCredentials")
	private static WebElement rememberLoginCredentials;
	
	@FindBy(id="chkUnauthorizedUsers")
	private static WebElement unAuthorizeUsers;
	
	@FindBy(id="Currency1")
	private static WebElement globalCurrency;
	
	@FindBy(id="Country")
	private static WebElement country;
	
	@FindBy(id="DefLanguages")
	private static WebElement defaultLanguage;
	
	@FindBy(id="CompanyLogo")
	private static WebElement companyLogo;
	
	@FindBy(xpath="//*[@id='errmsgDiv']")
	private static WebElement mandatoryMsgs;
	
	@FindBy(xpath="//label[@class='chk-margin Flabel']//input[@value='0']")
	private static WebElement languagesEnglish;
	
	@FindBy(xpath="//label[@class='chk-margin Flabel']//input[@value='1']")
	private static WebElement languagesArabic;
		
	@FindBy(xpath="//label[@class='chk-margin Flabel']//input[@value='2']")
	private static WebElement languagesPersian;
	
	@FindBy(xpath="//label[@class='chk-margin Flabel']//input[@value='3']")
	private static WebElement languagesChinese;
	
	@FindBy(xpath="//label[@class='chk-margin Flabel']//input[@value='4']")
	private static WebElement languagesSpanish;
	
	@FindBy(xpath="//label[@class='chk-margin Flabel']//input[@value='5']")
	private static WebElement languagesPortuguese;
	
	@FindBy(xpath="//label[@class='chk-margin Flabel']//input[@value='6']")
	private static WebElement languagesIndonesian;
	
	@FindBy(xpath="//span[contains(@class,'icon-ok icon-font6')]")
	private static WebElement okButtonInCreateCompany;
	
	@FindBy(xpath="//span[contains(@class,'icon-close icon-font6')]")
	private static WebElement cancelButtonInCreateCompany;
	
	@FindBy(xpath="//i[@class='indicator pull-right icon-collepse icon-font6']")
	private static WebElement companyMinimizeAndMaximize;
	
	@FindBy(xpath="//*[@id='1']/div/span")
	private static WebElement homeMenu;
	
	@FindBy(xpath="//*[@id='2']/div/span")
	private static WebElement companyMenu;
	
	@FindBy(xpath="//*[@id='2']/span")
	private static WebElement companyMenuExpand;
	
	
	
	
	Alert alert;
	
	
	
	public static String verifyCreateCompanyTitles() 
	{
		String CreateCompanyTitle = getDriver().getTitle();
		
		System.out.println(CreateCompanyTitle);
		return CreateCompanyTitle;   
    }
    
	
	
	public boolean verifyAvailablityOfCreateCompanyFields() throws InterruptedException
	{
		System.out.println("****Begin check in the createcompanyfields");
		
		//boolean verifyFiledsStatus=true;
		
	    getWebDriverWait().until(ExpectedConditions.visibilityOf(companyName));
		
		//Thread.sleep(20000);
		
	     System.out.println("****Begin check in the after wait q"+companyName);
	     
			if(companyName.isDisplayed()&&companyName.isEnabled())
			{
				System.out.println("****Begin check in the companyName");
				
				System.out.println("Company Name is displayed and enabled ");
	
				
				 //getWebDriverWait().until(ExpectedConditions.visibilityOf(calendarType));
				
				if(calendarType.isDisplayed()&&calendarType.isEnabled())
				{
					System.out.println(calendarType.isDisplayed());
					System.out.println(calendarType.isEnabled());
					
					System.out.println("Calendar is displayed and enabled ");
					
					 getWebDriverWait().until(ExpectedConditions.visibilityOf(accountingDate));
					
					if(accountingDate.isDisplayed()&&accountingDate.isEnabled())
					{
						System.out.println("Accounting Date is displayed and enabled ");
					
						if(securityNormal.isDisplayed()&&securityNormal.isEnabled())
						{
							System.out.println("Security Normal is displayed and enabled ");
					
							if(securityLow.isDisplayed()&&securityLow.isEnabled())
							{
								System.out.println("Security Low is displayed and enabled ");
							
								if(securityHigh.isDisplayed()&&securityLow.isEnabled())
								{
									System.out.println("Security High is displayed and enabled ");
												
									if(passwordSU.isDisplayed()&&passwordSU.isEnabled())
									{
										System.out.println("Password is displayed and enabled ");
									
										if(rememberLoginCredentials.isDisplayed()&&rememberLoginCredentials.isEnabled()&&rememberLoginCredentials.isSelected()==false)
										{
											System.out.println("Remember Login Credentials is displayed and enabled and Check box is uncheck by default ");
							
											if(unAuthorizeUsers.isDisplayed()&&unAuthorizeUsers.isEnabled()&&unAuthorizeUsers.isSelected()==false)
											{
												System.out.println("Un Authorize Users is displayed and enabled and Check box is uncheck by default ");
													
												if(globalCurrency.isDisplayed()&&globalCurrency.isEnabled())
												{
													System.out.println("Global Currency is displayed and enabled ");
																
													 if(country.isDisplayed()&&country.isEnabled())
													 {
														System.out.println("Country is displayed and enabled ");
														
														if(defaultLanguage.isDisplayed()&&defaultLanguage.isEnabled())
														 {
															System.out.println("Default Language English is displayed and enabled and Selected");
															
															if(companyLogo.isDisplayed()&&companyLogo.isEnabled())
															 {
																System.out.println("Company Logo is displayed and enabled ");
																
																if(languagesEnglish.isDisplayed()&&languagesEnglish.isEnabled()&&languagesEnglish.isSelected()==true)
																 {
																	System.out.println("Languages Option English is displayed and enabled ");
																		
																	if(languagesArabic.isDisplayed()&&languagesArabic.isEnabled()&&languagesArabic.isSelected()==false)
																	 {
																		System.out.println("Language Option Arabic is displayed and enabled ");
																		
																		if(languagesPersian.isDisplayed()&&languagesPersian.isEnabled()&&languagesPersian.isSelected()==false)
																		 {
																			System.out.println("Language Option Persian is displayed and enabled ");
																			
																			if(languagesChinese.isDisplayed()&&languagesChinese.isEnabled()&&languagesChinese.isSelected()==false)
																			 {
																				System.out.println("Language Option Chinese is displayed and enabled ");
																			
																				if(languagesSpanish.isDisplayed()&&languagesSpanish.isEnabled()&&languagesSpanish.isSelected()==false)
																				 {
																					System.out.println("Language Option Spanish is displayed and enabled ");
																				
																					if(languagesPortuguese.isDisplayed()&&languagesPortuguese.isEnabled()&&languagesPortuguese.isSelected()==false)
																					 {
																						System.out.println("Language Option Portuguese is displayed and enabled ");
																						
																						if(languagesIndonesian.isDisplayed()&&languagesIndonesian.isEnabled()&&languagesIndonesian.isSelected()==false)
																						 {
																							System.out.println("Language Option Indonesian is displayed and enabled ");
																							
																							if(okButtonInCreateCompany.isDisplayed()&&okButtonInCreateCompany.isEnabled())
																							 {
																								System.out.println("Ok Button is displayed and enabled ");
																								
																								if(cancelButtonInCreateCompany.isDisplayed()&&cancelButtonInCreateCompany.isEnabled())
																								 {
																									System.out.println("Cancel Button is displayed and enabled ");
																									
																									if(companyMinimizeAndMaximize.isDisplayed()&&companyMinimizeAndMaximize.isEnabled())
																									 {
																										System.out.println("Company Maxmize And Minimizs is displayed and enabled ");
																										return true;
																										
																											
																								     }
																									else 
																									{
																										System.out.println("Fail : Company Maxmize And Minimizs is displayed and enabled ");
																										return false;
																										
																							        }
																								 }
																								else 
																								{
																									System.out.println("Fail : Cancel Button is displayed and enabled ");
																									return false;
																									
																								}
																						     }
																						else 
																						{
																							System.out.println("Fail : Ok Button is displayed and enabled ");
																							return false;
																							//
																						}
																				     }
																				else 
																				{
																					
																					System.out.println("Fail : Language Option Indonesian is displayed and enabled ");
																					return false;
																					
																				}
																		     }
																			else 
																			{
																				System.out.println("Fail : Language Option Portuguese is displayed and enabled ");
																				return false;
																			
																			}
																	     }
																		else 
																		{
																			System.out.println("Fail : Language Option Spanish is displayed and enabled ");
																			return false;
																		}
																     }
																	else 
																	{
																		System.out.println("Fail : Language Option Chinese is displayed and enabled ");
																		return false;
																	}
															     }
																else 
																{
																	System.out.println("Fail : Language Option Persian is displayed and enabled ");
																	return false;
																}
														     }
															else 
															{
																System.out.println("Fail : Language Option Arabic is displayed and enabled ");
																return false;
															}
															
													     }
														else 
														{
															System.out.println("Fail : Languages Option English is displayed and enabled ");
															return false;
														}
												     }
													else 
													{
														System.out.println("Fail : Company Logo is displayed and enabled ");
														return false;
													}
												 }
												else 
												{
													System.out.println("Fail : Default Language English is displayed and enabled and Selected");
													return false;
												}
											 }
											else 
											{
												System.out.println("Fail : Country is displayed and enabled ");
												return false;
											}
											 
										}
										else 
										{
											System.out.println("Fail : Global Currency is displayed and enabled ");
											return false;
										}
									}
									else 
									{
										System.out.println("Fail : Un Authorize Users is displayed and enabled and Check box is uncheck by default ");
										return false;
									}
								}
								else 
								{
									System.out.println("Fail : Remember Login Credentials is displayed and enabled and Check box is uncheck by default ");
									return false;
								}
						     }
							else 
							{
								System.out.println("Fail : Password is displayed and enabled ");
								return false;
							}
					      }
						else 
						{
							System.out.println("Fail Security High is displayed and enabled ");
							return false;
						}
				      }
					else 
					{
						System.out.println("Fail : Security Low is displayed and enabled ");
						return false;
					}
				   }
				else 
				{
					System.out.println("Fail : Security Normal is displayed and enabled ");
					return false;
				}
			}
		 else 
		 {
			 System.out.println("Fail : Accounting Date is displayed and enabled ");
			 return false;
			}
		}		
		else 
		{
			System.out.println("Fail : Calendar is displayed and enabled ");
			return false;
		}
	 }
	else 
	{
		System.out.println("****stop check in the companyName");
		System.out.println("Fail : Company Name is displayed and enabled ");
		return false;
	}


   
			
   }
	
	
    public static void clickOnCompanyCreateBtn()
    {
    	 getWebDriverWait().until(ExpectedConditions.visibilityOf(companyCreateBtn));
    	
    	 companyCreateBtn.click();
    	
    }
	
	
	public void enterCompanyName(String companyNameTxt)
	{
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(companyName));
		companyName.sendKeys(companyNameTxt);
	}

	
	public String getCompanyNameError()
	{
		
		return getCompanyNameError.getText();
	}
	
	
	public static void clickOnOk()
	{
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(okButtonInCreateCompany));
		okButtonInCreateCompany.click();
	}
	

	public String getPasswordError()
	{

	   return getPasswordErrorMsg.getText();
	}
	
	
	
	public void enterSuPasssord(String passText)
	{
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(passwordSU));
		passwordSU.sendKeys(passText);
	}
	
	

	
	public boolean getSelectedCalender()
	{
		String Strq= calendarType.getText();
		
		 boolean getCalenderValue=false;
		 String[] str= Strq.split("\n");     
	      for(String st1 : str)
	      {
	    	
	    	  st1.equals("Georgian");
	    	  getCalenderValue=true;
	    	  break;
	      }
		return getCalenderValue;
	}
	
	
	public String getCalenderValues()
	{
		return calendarType.getText();
		
	}

	
	public int getCalenderCount()
	{

		 Select oSelect = new Select(calendarType);
		 List <WebElement> elementCount = oSelect.getOptions();
		
		 int iSize = elementCount.size();
		 System.out.println("Calender Count :"+iSize);
		 return iSize;
 
	}
	
	
	public String getAccountingDate()
	{
	
		datePicker.click();
		
		String getCalenderPopupDate=getDate.getText();

		String ConPopupDate=getCalenderPopupDate.replace("/", "-");
		
		return ConPopupDate;
	 }
	
	public String getCountryValues()
	{
		return country.getText();
	}
	
	
	public int getCountrqCount()
	{
		 Select oSelect = new Select(country);
		 List <WebElement> elementCount = oSelect.getOptions();
		
		 int cSize = elementCount.size();
		 System.out.println("Country Count :"+cSize);
		 return cSize;
	}
	
	//String Split is Used Here
	
	public boolean getSelectedCountry()
	{
		String Strq= country.getText();
		
		 boolean getCountryValue=false;
		 String[] str= Strq.split("\n");     
	      for(String st1 : str)
	      {
	    	
	    	  st1.equals("India");
	    	  getCountryValue=true;
	    	  break;
	      }
	      
		return getCountryValue;
	}
	
	
	
	public String getCurrencyValues()
	{
		return globalCurrency.getText();
	}

	
	
	public int getGlobalCurrencyCount()
	{
		 Select oSelect = new Select(globalCurrency);
		 List <WebElement> elementCount = oSelect.getOptions();
		
		 int gcSize = elementCount.size();
		 System.out.println("Currency Count :"+gcSize);
		 return gcSize;
	}
	
	
	public void checkArabicLanguage()
	{
		languagesArabic.click();
	}
	
    
	public void unCheckArabicLanguage()
	{
		languagesArabic.click();
	}
	
	public int getDefaultLanguageCount()
	{
		
		Select oSelect = new Select(defaultLanguage);
		 List <WebElement> elementCount = oSelect.getOptions();
		
		 int glSize = elementCount.size();
		 System.out.println("Currency Count :"+glSize);
		 return glSize;
	}
	
	
	public String getDefaultCurrencyValues()
	{
		return defaultLanguage.getText();
	}
	
	public void clickOnLogo()
	{
		companyLogo.click();
	}
	

	
	
	public void waitForAlert()
	{
		new WebDriverWait(getDriver(), 800).ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
	}
	
	
   public Alert getAlert()
   {
		alert=getDriver().switchTo().alert();
		return alert;
   }
	
   
   /*public void checkLoginScreenAfterCompanyCreation()
   {
	   
	   lp=new LoginPage(getDriver());
	   
	   try
	   {
		   
	   }
	   catch(Exception e)
	   {
		   
	   }
   }*/
   
   public boolean verifyAvailablityOfCreateCompanyFieldsInEditCompany() throws InterruptedException
	{
		System.out.println("****Begin check in the createcompanyfields");
		
		//boolean verifyFiledsStatus=true;
		
	    getWebDriverWait().until(ExpectedConditions.visibilityOf(companyName));
		
		//Thread.sleep(20000);
		
	     System.out.println("****Begin check in the after wait q"+companyName);
	     
			if(companyName.isDisplayed()&&companyName.isEnabled())
			{
				System.out.println("****Begin check in the companyName");
				
				System.out.println("Company Name is displayed and enabled ");
	
				
				 //getWebDriverWait().until(ExpectedConditions.visibilityOf(calendarType));
				
			/*	if(calendarType.isDisplayed()&&calendarType.isEnabled())
				{
					System.out.println(calendarType.isDisplayed());
					System.out.println(calendarType.isEnabled());
					
					System.out.println("Calendar is displayed and enabled ");
					
					 getWebDriverWait().until(ExpectedConditions.visibilityOf(accountingDate));
				*/	
					if(accountingDate.isDisplayed()&&accountingDate.isEnabled())
					{
						System.out.println("Accounting Date is displayed and enabled ");
					
						if(securityNormal.isDisplayed()&&securityNormal.isEnabled())
						{
							System.out.println("Security Normal is displayed and enabled ");
					
							if(securityLow.isDisplayed()&&securityLow.isEnabled())
							{
								System.out.println("Security Low is displayed and enabled ");
							
								if(securityHigh.isDisplayed()&&securityLow.isEnabled())
								{
									System.out.println("Security High is displayed and enabled ");
												
									if(passwordSU.isDisplayed()&&passwordSU.isEnabled())
									{
										System.out.println("Password is displayed and enabled ");
									
										if(rememberLoginCredentials.isDisplayed()&&rememberLoginCredentials.isEnabled()&&rememberLoginCredentials.isSelected()==false)
										{
											System.out.println("Remember Login Credentials is displayed and enabled and Check box is uncheck by default ");
							
											if(unAuthorizeUsers.isDisplayed()&&unAuthorizeUsers.isEnabled()&&unAuthorizeUsers.isSelected()==false)
											{
												System.out.println("Un Authorize Users is displayed and enabled and Check box is uncheck by default ");
													
												if(globalCurrency.isDisplayed()&&globalCurrency.isEnabled())
												{
													System.out.println("Global Currency is displayed and enabled ");
																
													 if(country.isDisplayed()&&country.isEnabled())
													 {
														System.out.println("Country is displayed and enabled ");
														
														/*if(defaultLanguage.isDisplayed()&&defaultLanguage.isEnabled())
														 {
															System.out.println("Default Language English is displayed and enabled and Selected");
														*/	
															if(companyLogo.isDisplayed()&&companyLogo.isEnabled())
															 {
																System.out.println("Company Logo is displayed and enabled ");
																
/*																if(languagesEnglish.isDisplayed()&&languagesEnglish.isEnabled()&&languagesEnglish.isSelected()==true)
																 {
																	System.out.println("Languages Option English is displayed and enabled ");
																	*/	
																	if(languagesArabic.isDisplayed()&&languagesArabic.isEnabled()&&languagesArabic.isSelected()==false)
																	 {
																		System.out.println("Language Option Arabic is displayed and enabled ");
																		
																		if(languagesPersian.isDisplayed()&&languagesPersian.isEnabled()&&languagesPersian.isSelected()==false)
																		 {
																			System.out.println("Language Option Persian is displayed and enabled ");
																			
																			if(languagesChinese.isDisplayed()&&languagesChinese.isEnabled()&&languagesChinese.isSelected()==false)
																			 {
																				System.out.println("Language Option Chinese is displayed and enabled ");
																			
																				if(languagesSpanish.isDisplayed()&&languagesSpanish.isEnabled()&&languagesSpanish.isSelected()==false)
																				 {
																					System.out.println("Language Option Spanish is displayed and enabled ");
																				
																					if(languagesPortuguese.isDisplayed()&&languagesPortuguese.isEnabled()&&languagesPortuguese.isSelected()==false)
																					 {
																						System.out.println("Language Option Portuguese is displayed and enabled ");
																						
																						if(languagesIndonesian.isDisplayed()&&languagesIndonesian.isEnabled()&&languagesIndonesian.isSelected()==false)
																						 {
																							System.out.println("Language Option Indonesian is displayed and enabled ");
																							
																							if(okButtonInCreateCompany.isDisplayed()&&okButtonInCreateCompany.isEnabled())
																							 {
																								System.out.println("Ok Button is displayed and enabled ");
																								
																								if(cancelButtonInCreateCompany.isDisplayed()&&cancelButtonInCreateCompany.isEnabled())
																								 {
																									System.out.println("Cancel Button is displayed and enabled ");
																									
																									if(companyMinimizeAndMaximize.isDisplayed()&&companyMinimizeAndMaximize.isEnabled())
																									 {
																										System.out.println("Company Maxmize And Minimizs is displayed and enabled ");
																										return true;
																										
																											
																								     }
																									else 
																									{
																										System.out.println("Fail : Company Maxmize And Minimizs is displayed and enabled ");
																										return false;
																										
																							        }
																								 }
																								else 
																								{
																									System.out.println("Fail : Cancel Button is displayed and enabled ");
																									return false;
																									
																								}
																						     }
																						else 
																						{
																							System.out.println("Fail : Ok Button is displayed and enabled ");
																							return false;
																							//
																						}
																				     }
																				else 
																				{
																					
																					System.out.println("Fail : Language Option Indonesian is displayed and enabled ");
																					return false;
																					
																				}
																		     }
																			else 
																			{
																				System.out.println("Fail : Language Option Portuguese is displayed and enabled ");
																				return false;
																			
																			}
																	     }
																		else 
																		{
																			System.out.println("Fail : Language Option Spanish is displayed and enabled ");
																			return false;
																		}
																     }
																	else 
																	{
																		System.out.println("Fail : Language Option Chinese is displayed and enabled ");
																		return false;
																	}
															     }
																else 
																{
																	System.out.println("Fail : Language Option Persian is displayed and enabled ");
																	return false;
																}
														     }
															else 
															{
																System.out.println("Fail : Language Option Arabic is displayed and enabled ");
																return false;
															}
															
													     }
/*														else 
														{
															System.out.println("Fail : Languages Option English is displayed and enabled ");
															return false;
														}
												     }*/
													else 
													{
														System.out.println("Fail : Company Logo is displayed and enabled ");
														return false;
													}
												 }
/*												else 
												{
													System.out.println("Fail : Default Language English is displayed and enabled and Selected");
													return false;
												}
											 }*/
											else 
											{
												System.out.println("Fail : Country is displayed and enabled ");
												return false;
											}
											 
										}
										else 
										{
											System.out.println("Fail : Global Currency is displayed and enabled ");
											return false;
										}
									}
									else 
									{
										System.out.println("Fail : Un Authorize Users is displayed and enabled and Check box is uncheck by default ");
										return false;
									}
								}
								else 
								{
									System.out.println("Fail : Remember Login Credentials is displayed and enabled and Check box is uncheck by default ");
									return false;
								}
						     }
							else 
							{
								System.out.println("Fail : Password is displayed and enabled ");
								return false;
							}
					      }
						else 
						{
							System.out.println("Fail Security High is displayed and enabled ");
							return false;
						}
				      }
					else 
					{
						System.out.println("Fail : Security Low is displayed and enabled ");
						return false;
					}
				   }
				else 
				{
					System.out.println("Fail : Security Normal is displayed and enabled ");
					return false;
				}
			}
		 else 
		 {
			 System.out.println("Fail : Accounting Date is displayed and enabled ");
			 return false;
			}
		}		
/*		else 
		{
			System.out.println("Fail : Calendar is displayed and enabled ");
			return false;
		}
	 }*/
	else 
	{
		System.out.println("****stop check in the companyName");
		System.out.println("Fail : Company Name is displayed and enabled ");
		return false;
	}


  
			
  }
	
 
   
   
   public boolean getCompanyListIsCreatingAfterCreatingCompany()
   {
   
   	LoginPageTest t=new LoginPageTest();
   	int ccb=t.getTheCompanyListCountBeforeCompanyList();
   	int z=t.getTheCompanyListCountAfterCompanyList();
   	
   	if(ccb==z)
   	{
   		return true;
   	}
   	
   	else
   	{
   		return false;
   	}
   	
   }
   
   
 public void clickOnCompanyMenu()
 {
	 //Menus menu=new Menus();
	 
	 homeMenu.click();
	 companyMenu.click();
	 companyMenuExpand.click();
 }
   
  
   public void clickOnCancelBuutonInCompanyCreation()
   {
	   cancelButtonInCreateCompany.click();
   }
   
   
    public CreateCompanyLoginPage(WebDriver driver)
    {
    	
    	PageFactory.initElements(driver, this);
    	
    }
	   
	
}
