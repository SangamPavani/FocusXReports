package com.focus.Pages;




import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.openqa.selenium.support.How;
import com.focus.base.BaseEngine;
import com.focus.supporters.ExcelReader;
import com.focus.testcases.LoginPageTest;
import com.focus.utilities.POJOUtility;


public class LoginPage extends BaseEngine 
{
	private static WebElement loginTitle;
	
	@FindBy(xpath="//*[@id='txtUsername']")
	private static WebElement username;

	@FindBy(id="txtPassword")
	private static WebElement password;
	
    @FindBy(id="ddlCompany")
    private static WebElement companyDropDownList;

	@FindBy(id="btnSignin")
	private static WebElement signIn;
	
	@FindBy(xpath="//i[@title='Create Company']")
    private static WebElement companyCreateBtn;		

	@FindBy(xpath="//i[@title='Keyboard ']")
	private static WebElement keyboardBtn;

    @FindBy(xpath="//i[@title='Refresh']")
    private static WebElement refreshBtn;
	
	@FindBy(id="chkRememberMe")
	private static WebElement rememberMeChk;
	
	@FindBy(id="chkRememberPwd")
	private static WebElement rememberPwdChk;
	
	@FindBy(id="frgtPwd")
	private static WebElement frgtPwdLnk;
	
	@FindBy(xpath="//span[contains(@class,'icon-ok icon-font6')]")
	private static WebElement okButtonInCreateCompany;
	
	@FindBy(xpath="//span[contains(@class,'icon-close icon-font6')]")
	private static WebElement cancelButtonInCreateCompany;
	
	@FindBy(linkText="Create Company")
	private static WebElement createCompanyScreen;
	
	@FindBy(xpath="//*[@id='errmsgDiv']")
	private static WebElement mandatoryMsgs;
	
	//Fields of Company su Home Page
	@FindBy(xpath="//*[@id='ulCompanyDetails_HomePage']/li[1]")
	private static WebElement companyName;
	
	@FindBy(xpath="//*[@id='mainHeader_MainLayout']/a/img")
	private static WebElement focusLogo;
	
	@FindBy(xpath="//*[@id='id_focus8_wrapper_default']/aside/section")
	private static WebElement menuBar;
	
	@FindBy(xpath="//*[@id='dashName']")
	private static WebElement dashboardName;
	
	@FindBy(xpath="//*[@id='dashIcons']")
	private static WebElement dashboardIcons;
	
	@FindBy(xpath="//*[@id='mainHeader_MainLayout']/nav/div/ul/li[6]/a/span")
	private static WebElement userNameDisplay;
	
	@FindBy(xpath="//*[@id='companyLogo']")
	private static WebElement companyLogo;
	
	@FindBy(xpath="//*[@id='userprofile']/li/span[1]")
	private static WebElement changePassword;
	
	@FindBy(xpath="//*[@id='ddlCompanyLangualges_MainLayout']")
	private static WebElement languageDropdownInLogout;
	
	@FindBy(xpath="//*[@id='userprofile']/li/span[2]")
	private static WebElement logoutOption;
	
	@FindBy(xpath="//*[@id='dashName']")
	private static WebElement dashboard;
	
	
	
	
	public static String verifyLoginTitles() 
	{
		String loginTitle = getDriver().getTitle();
		
		System.out.println(loginTitle);
		return loginTitle;   
    }
	
   
	public static boolean verifyAvailablityOfFields()
	{
		boolean verifyFiledsStatus=true;
		
		getWebDriverWait().until(ExpectedConditions.visibilityOf(username));
		
		if(username.isDisplayed()&&username.isEnabled())
		{
			System.out.println("UserName text box is displayed and enabled "+ verifyFiledsStatus);
			
			if(password.isDisplayed()&&password.isEnabled())
			{
				System.out.println("Password text box is displayed and enabled "+ verifyFiledsStatus);
	
				if(companyDropDownList.isDisplayed()&&companyDropDownList.isEnabled())
				{
					System.out.println("Company Drop Down box is displayed and enabled "+ verifyFiledsStatus);
				
					if(signIn.isDisplayed()&&signIn.isEnabled())
					{
						System.out.println("SignIn is displayed and enabled "+ verifyFiledsStatus);
					
						if(companyCreateBtn.isDisplayed()&&companyCreateBtn.isEnabled())
						{
							System.out.println("Create Company Button is displayed and enabled "+ verifyFiledsStatus);
						
							if(keyboardBtn.isDisplayed()&&keyboardBtn.isEnabled())
							{
								System.out.println("Keyboard Button is displayed and enabled "+ verifyFiledsStatus);
							
								if(refreshBtn.isDisplayed()&&refreshBtn.isEnabled())
								{
									System.out.println("Refresh Button is displayed and enabled "+ verifyFiledsStatus);
					
									if(rememberMeChk.isDisplayed()&&rememberMeChk.isEnabled())
									{
										System.out.println("Remember Me Checkbox is displayed and enabled "+ verifyFiledsStatus);
											
										if(rememberPwdChk.isDisplayed()&&rememberPwdChk.isEnabled())
										{
											System.out.println("Remember Password Checkbox is displayed and enabled "+ verifyFiledsStatus);
														
											 if(frgtPwdLnk.isDisplayed()&&frgtPwdLnk.isEnabled())
											 {
												System.out.println("Forgot Password Link is displayed and enabled "+ verifyFiledsStatus);
												verifyFiledsStatus=true;
												
											 }
											 else
											 {
												 System.out.println("Fail ");
												 verifyFiledsStatus=false;
											 }
										}
										 else
										 {
											 System.out.println("Fail ");
											 verifyFiledsStatus=false;
										 }
									}
									 else
									 {
										 System.out.println("Fail ");
										 verifyFiledsStatus=false;
									 }
								}
								 else
								 {
									 System.out.println("Fail ");
									 verifyFiledsStatus=false;
								 }
						     }
							 else
							 {
								 System.out.println("Fail ");
								 verifyFiledsStatus=false;
							 }
					      }		
						 else
						 {
							 System.out.println("Fail ");
							 verifyFiledsStatus=false;
						 }
				      }
					 else
					 {
						 System.out.println("Fail ");
						 verifyFiledsStatus=false;
					 }
				   }
				 else
				 {
					 System.out.println("Fail ");
					 verifyFiledsStatus=false;
				 }
			   }
			 else
			 {
				 System.out.println("Fail ");
				 verifyFiledsStatus=false;
			 }
				
			}
			else 
			{
				verifyFiledsStatus=false;
				System.out.println(verifyFiledsStatus);
			}

		return verifyFiledsStatus;
			
	  }
	
    public static void clickOnCompanyCreateBtn()
    {
    	System.out.println("company create");
    	
    	companyCreateBtn.click();
    	
    }
	
	
	
	public void enterUserName(String uname)
	{
		
		getWebDriverWait().until(ExpectedConditions.visibilityOf(username));
		username.clear();
	    username.click();
        username.sendKeys(uname);
        getAction().moveToElement(username).sendKeys(Keys.TAB).perform();
       
	}
	
	
	
	public static void enterPassword(String pswd)
	{		
		getWebDriverWait().until(ExpectedConditions.visibilityOf(password));
		password.clear();
		password.click();
		password.sendKeys(pswd);
		getAction().moveToElement(password).sendKeys(Keys.TAB).perform();
		
	}
	
	
	public static void clickOnSignInBtn()
	{

		getWebDriverWait().until(ExpectedConditions.visibilityOf(signIn));
		signIn.click();	
	}
	

	 public boolean verifyLoginPageAfterCompanyCreation()
	 {
		 System.out.println("******** 1.verifyLoginPageAfterCompanyCreation*********");
		 
		 boolean signInScreen=false;
		   try
			{
			   System.out.println("******** 2.verifyLoginPageAfterCompanyCreation First Try block ********");
			   getWebDriverWait().until(ExpectedConditions.elementToBeClickable(signIn));
			   
				if(signIn.isDisplayed())
				{
				    System.out.println("******** 3.verifyLoginPageAfterCompanyCreation user enter in Try block");
					getLogger().info("Pass :Login Screen is displaying after user creating company");
					System.out.println("Pass : Login Screen is displaying after user creating company");
					//getWebDriverWait().until(ExpectedConditions.elementToBeClickable(signIn));
					//signIn.click();
					signInScreen=true;
					
				}
			

		}
	        catch(Exception e) 
			{
					getLogger().info("Error is displaying while creating Company"+e.getMessage());
					System.out.println("******* 6.verifyLoginPageAfterCompanyCreation user enter in Catch block");
					getWebDriverWait().until(ExpectedConditions.elementToBeClickable(cancelButtonInCreateCompany));
					LoginPage.cancelButtonInCreateCompany.click();
					//signIn.click();
					signInScreen=false;
			}

		   return signInScreen;
	   }

	 public static void checkRememberMe()
	 {
		 rememberMeChk.click();
	 }
	 
	 
	 
    public static String getCompanyNameFromLoginScreen()
    {
    	String getCompanyNameText=companyDropDownList.getText();
    	return getCompanyNameText;
    	
    }
	
    
    public static boolean verifyUserHomePageAndDashBoard() throws InterruptedException
    {
    	boolean avbFields=false;
    	
    	
    	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(userNameDisplay));
    	
    	Thread.sleep(4000);
    	getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(userNameDisplay, "SU"));
    	String userInfo=userNameDisplay.getText();
    	
    	System.out.println("User Info : "+userInfo);
    	System.out.println("User Info Capture Text :"+userNameDisplay.getText());
    	
    	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(companyLogo));
    	companyLogo.click();
    	
    	String getCompanyTxt=companyName.getText();
    	String getLoginCompanyName=getCompanyTxt.substring(0, 19);
    	System.out.println("company name :"+ getLoginCompanyName);
    	companyLogo.click();
    	
    	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(dashboard));
    	
    	String getDashboard=dashboard.getText();
    	
    	System.out.println(getDashboard);
    	
    		if(userInfo.equalsIgnoreCase("SU")&&getLoginCompanyName.equalsIgnoreCase("Automation Company "))
    		{
    			avbFields=true;
    			getLogger().info("Login User the Company Name and Information is displaying correct");
    			System.out.println("Pass : Login User and Company Name is displaying Correct");
    		
    		
    			if(getDashboard.equalsIgnoreCase("Dashboard"))
    			{
    				avbFields=true;
    			}
    		    else
    		    {
    		    	avbFields=false;
    		    	
    		    }
    		}
    		else
    		{
    			avbFields=false;
    			getLogger().info("Fail : Login User the Company Name and Information is displaying Wrong");
    			System.out.println("Fail : Login Name the Company Name and Information is displaying Wrong");
    		}

    	
    	return avbFields;
    }
    
    
    public int verifyTheNumberOfListInCompanyDropdownList()
    {
    	 Select oSelect = new Select(companyDropDownList);
		 List <WebElement> elementCount = oSelect.getOptions();
		
		 int cSize = elementCount.size();
		 System.out.println("CompanyDropdownList Count :"+cSize);
		 return cSize;
    }
    
    
    
    
    
    
	
	public void getCompanyFromCompanyListAfterCompanyCreate() throws InterruptedException
	{
		
		getAction().moveToElement(username).sendKeys(Keys.TAB).perform();
		
		getAction().moveToElement(password).sendKeys(Keys.TAB).perform();
		
		LoginPage lp=new LoginPage(getDriver());	
		
		  String compname="Automation Company";
		  
		  Select dropdown= new Select(lp.companyDropDownList);
		  int i;
		  
		  List<WebElement> list = dropdown.getOptions();

			List<String> text = new ArrayList<>();
			for(i=0; i<list.size(); i++) 
			{
			
	    	  list.get(i).getText();
	    	  String optionName = list.get(i).getText();
	    	  if(optionName.toUpperCase().startsWith(compname.toUpperCase()))
	    	  {
	    		  list.get(i).click();
	    		  
	    	  }
	      
	      }

			Thread.sleep(3000);
	}
	 
	 
	

	 public boolean verifyMandatoryFieldCheckForSuperUserName() throws InterruptedException
	  {
		  
		  username.clear();
		  String msgMandatoryComp="Username cannot be blank";
		  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(signIn));
		  signIn.click();
		  getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(mandatoryMsgs, "Username cannot be blank"));
		  System.out.println(mandatoryMsgs.getText());
		  
		  if(msgMandatoryComp.equalsIgnoreCase(mandatoryMsgs.getText()))
		  {
			  System.out.println(true);
			  return true;
		  }
		  else
		  {
			  System.out.println(false);
			  return false;
		  }
		  
	  }
	 
	 
	 
	 public boolean verifyMandatoryFieldCheckForPassword() throws InterruptedException
	  {
		  
		  String msgMandatoryComp="Password cannot be blank";
		  username.sendKeys("su");
		  getAction().moveToElement(username).sendKeys(Keys.TAB).perform();

		  getAction().moveToElement(password).sendKeys(Keys.TAB).perform();
		  
		  
		  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(signIn));
		  signIn.click();
		  System.out.println(mandatoryMsgs.getText());
		  getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(mandatoryMsgs, "Password cannot be blank"));
		  if(msgMandatoryComp.equalsIgnoreCase(mandatoryMsgs.getText()))
		  {
			  System.out.println(true);
			  return true;
		  }
		  else
		  {
			  System.out.println(false);
			  return false;
		  }
		  
	  }
	 
	 
	 
	 public boolean verifyInvalidSuperUserName() throws InterruptedException
	  {
		  
		  String msgMandatoryComp="User name not found";
		  username.click();
		  username.clear();
		  username.sendKeys("suu");
		  getAction().moveToElement(username).sendKeys(Keys.TAB).perform();
		  //password.clear();
	      password.sendKeys("su");
		  getAction().moveToElement(password).sendKeys(Keys.TAB).perform();
		  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(signIn));
		  signIn.click();
		  getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(mandatoryMsgs, "User name not found"));
		  System.out.println(mandatoryMsgs.getText());
		  
		  if(msgMandatoryComp.equalsIgnoreCase(mandatoryMsgs.getText()))
		  {
			  System.out.println(true);
			  return true;
		  }
		  else
		  {
			  System.out.println(false);
			  return false;
		  }
		  
	  }
	 
	 
	 public boolean verifyInvalidPassword() throws InterruptedException
	  {
		  
		  String msgMandatoryComp="Invalid Password";
		  username.click();
		  username.clear();
		  username.sendKeys("su");
		  getAction().moveToElement(username).sendKeys(Keys.TAB).perform();
		  password.clear();
	      password.sendKeys("s");
		  getAction().moveToElement(password).sendKeys(Keys.TAB).perform();
		  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(signIn));
		  signIn.click();
		  //Thread.sleep(3500);
		  getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(mandatoryMsgs, "Invalid Password"));
		  System.out.println(mandatoryMsgs.getText());
		  
		  if(msgMandatoryComp.equalsIgnoreCase(mandatoryMsgs.getText()))
		  {
			  System.out.println(true);
			  return true;
		  }
		  else
		  {
			  System.out.println(false);
			  return false;
		  }
		  
	  }
	 
	 

	 
	 public static boolean verifyUserNameImage()
	 {
		 boolean chkLogout=false;
		 //getWebDriverWait().until(ExpectedConditions.elementToBeClickable(userNameDisplay));
		 System.out.println("Verify UserNameImage Screen");
		 userNameDisplay.click();
		 
		 System.out.println("User Image dropdown user name : "+ LoginPage.getLanguageTextInUserNameDisplay());
		 System.out.println("User Image dropdown language count :"+ LoginPage.getLanguageCountInUserNameDisplay());
		 
		 if(changePassword.isDisplayed()&&changePassword.isEnabled()
		    &&languageDropdownInLogout.isDisplayed()&&languageDropdownInLogout.isEnabled()
			&&logoutOption.isDisplayed()&&logoutOption.isEnabled())
		 {
			 
			 System.out.println("Pass First : ***Verifyusrename");
			
			 if(LoginPage.getLanguageCountInUserNameDisplay()==2)
			 {
				 System.out.println("Pass Second : ***Verifyusrename");
			 
				 if(LoginPage.getLanguageTextInUserNameDisplay()==true)
				 {
					 System.out.println("Pass Third : ***Verifyusrename");
					 
					 chkLogout=true;
				 }
				 else
				 {
					 chkLogout=false;
					 System.out.println("Fail first : ***Verifyusrename");
				 }
			 }
			 else
			 {
				 chkLogout=false;
				 System.out.println("Fail two : ***Verifyusrename");
			 }
		 }	
		 else
		 {
			 chkLogout=false;
			 System.out.println("Fail Third : ***Verifyusrename");
		 }

		 return chkLogout;
		 
	 }

	 
	 public static int getLanguageCountInUserNameDisplay()
	 {
			Select oSelect = new Select(languageDropdownInLogout);
			 List <WebElement> elementCount = oSelect.getOptions();
			
			 int lSize = elementCount.size();
			 System.out.println("Language Dropdown List are :"+lSize);
			 return lSize;
	 }
	 	

	 
	 public static boolean getLanguageTextInUserNameDisplay()
	 {
		 //String languageInLogout=languageDropdownInLogout.getText();
		 
		 
		 String Strlpl= languageDropdownInLogout.getText();
			
		 boolean getLanguageDropdownList=false;
		 String[] str= Strlpl.split("\n");     
	      for(String st1 : str)
	      {
	    	
	    	  st1.equals("English");
	    	  getLanguageDropdownList=true;
	    	  break;
	      }
	      
		return getLanguageDropdownList;
		 
	 }
	 
	 
	 
	 
	 public static void clickOnLogOut()
	 {
		 
		// //userNameDisplay.click();
		 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(logoutOption));
		 logoutOption.click();
		 
	 }
	 
	 public static void clickOnLogoutWithOptions()
	 {
		 
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(userNameDisplay));
		 userNameDisplay.click();
		 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(logoutOption));
		 logoutOption.click();
	 }

	 
	 public static boolean clickOnLogoutChangePasswordSingInWithInvalid()
	 {
		 
		  String msgMandatoryComp="Invalid Password";
		 
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(userNameDisplay));
		 userNameDisplay.click();
		 getWebDriverWait().until(ExpectedConditions.elementToBeClickable(logoutOption));
		 logoutOption.click();
		 
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(username));
		 username.sendKeys("su");
		 getAction().moveToElement(username).sendKeys(Keys.TAB).perform();
		
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(password));
		 password.sendKeys("su");
		 getAction().moveToElement(password).sendKeys(Keys.TAB).perform();
		

		 signIn.click();
		 

		  getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(mandatoryMsgs, "Invalid Password"));
		  System.out.println(mandatoryMsgs.getText());
		  
		  if(msgMandatoryComp.equalsIgnoreCase(mandatoryMsgs.getText()))
		  {
			  System.out.println(true);
			  return true;
		  }
		  else
		  {
			  System.out.println(false);
			  return false;
		  }
	 }
	 
	 
	 
	 
	 
	 
	 public static void clickOnLogoutChangePasswordSingInWithValid() throws InterruptedException
	 {
		 
		
		 
		 //getWebDriverWait().until(ExpectedConditions.visibilityOf(userNameDisplay));
		 //userNameDisplay.click();
		 //getWebDriverWait().until(ExpectedConditions.elementToBeClickable(logoutOption));
		 //logoutOption.click();
		 
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(username));
		 username.clear();
		 username.sendKeys("su");
		 getAction().moveToElement(username).sendKeys(Keys.TAB).perform();
		
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(password));
		 password.sendKeys("s");
		 getAction().moveToElement(password).sendKeys(Keys.TAB).perform();
		

		 signIn.click();
		 
		 
		 

	 }
	 
	 
	 
	 
	 public static boolean signInWithSuperUserBycheckingRememberMeAndLogout() throws InterruptedException
	 {
	
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(username));

		 //getWebDriverWait().until(ExpectedConditions.visibilityOf(password));
		 
		 //getWebDriverWait().until(ExpectedConditions.visibilityOf(companyDropDownList));
		 
		 //getWebDriverWait().until(ExpectedConditions.visibilityOf(signIn));
		 
		 
		 username.click();
		 String sunameValue=username.getAttribute("value");
		  
		 
		 
		 
		 String pwdValue=password.getAttribute("value");
		 
		 System.out.println("**********user name is display as"+sunameValue);
		 System.out.println("**********pwdValue is display as"+pwdValue);
		 System.out.println("**********pwdValue true or false is display as"+pwdValue.isEmpty());
		 
		 boolean verifyFiledsStatus=true;
		 
		 if(username.isDisplayed()&&username.isEnabled()&&sunameValue.equalsIgnoreCase("su"))
			{
				System.out.println("UserName text box is displayed and enabled "+ verifyFiledsStatus);
				
				if(password.isDisplayed()&&password.isEnabled()&&pwdValue.isEmpty()==true)
				{
					System.out.println("Password text box is displayed and enabled "+ verifyFiledsStatus);
		
					if(companyDropDownList.isDisplayed()&&companyDropDownList.isEnabled())
					{
						System.out.println("Company Drop Down box is displayed and enabled "+ verifyFiledsStatus);
					
						if(signIn.isDisplayed()&&signIn.isEnabled())
						{
							System.out.println("SignIn is displayed and enabled "+ verifyFiledsStatus);
						
							if(companyCreateBtn.isDisplayed()&&companyCreateBtn.isEnabled())
							{
								System.out.println("Create Company Button is displayed and enabled "+ verifyFiledsStatus);
							
								if(keyboardBtn.isDisplayed()&&keyboardBtn.isEnabled())
								{
									System.out.println("Keyboard Button is displayed and enabled "+ verifyFiledsStatus);
								
									if(refreshBtn.isDisplayed()&&refreshBtn.isEnabled())
									{
										System.out.println("Refresh Button is displayed and enabled "+ verifyFiledsStatus);
						
										if(rememberMeChk.isDisplayed()&&rememberMeChk.isEnabled()&&rememberMeChk.isSelected())
										{
											System.out.println("Remember Me Checkbox is displayed and enabled "+ verifyFiledsStatus);
												
											if(rememberPwdChk.isDisplayed()&&rememberPwdChk.isEnabled())
											{
												System.out.println("Remember Password Checkbox is displayed and enabled "+ verifyFiledsStatus);
															
												 if(frgtPwdLnk.isDisplayed()&&frgtPwdLnk.isEnabled())
												 {
													System.out.println("Forgot Password Link is displayed and enabled "+ verifyFiledsStatus);
													verifyFiledsStatus=true;
													
												 }
												 else
												 {
													 System.out.println("Forgot Password Link : Fail ");
													 verifyFiledsStatus=false;
												 }
											}
											 else
											 {
												 System.out.println("Remember Password : Fail ");
												 verifyFiledsStatus=false;
											 }
											
										}
										 else
										 {
											 System.out.println("Remember Me : Fail ");
											 verifyFiledsStatus=false;
										 }
									}
									 else
									 {
										 System.out.println("Refresh Button  : Fail ");
										 verifyFiledsStatus=false;
									 }
							     }
								 else
								 {
									 System.out.println("Keyboard button : Fail ");
									 verifyFiledsStatus=false;
								 }
						      }
							 else
							 {
								 System.out.println("Company Create button : Fail ");
								 verifyFiledsStatus=false;
							 }
					      }
						 else
						 {
							 System.out.println("Sign In Button : Fail ");
							 verifyFiledsStatus=false;
						 }
					   }
					 else
					 {
						 System.out.println("Company Dropdown : Fail ");
						 verifyFiledsStatus=false;
					 }
				   }
				 else
				 {
					 System.out.println("Fail ");
					 verifyFiledsStatus=false;
				 }
					
				}
				else 
				{
					System.out.println("Fail");	
					verifyFiledsStatus=false;
					
				}

			return verifyFiledsStatus;
				
		  }

				
					
	 public static boolean signInAgainWithSuperUserBycheckingRememberMeAfterLogout() throws InterruptedException
	 {
		 
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(username));
		 
         username.click();
		 //Thread.sleep(4000);
         
         getAction().moveToElement(username).sendKeys(Keys.TAB).perform();
         
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(password));
		 
		
		 getAction().moveToElement(password).sendKeys(Keys.TAB).perform();
		 
		 String sunameValue=username.getAttribute("value");
		 String pwdValue=password.getAttribute("value");
		 boolean p=pwdValue.isEmpty();
		 
		 
		 System.out.println("sunameValue"+sunameValue);
		 System.out.println("pwdValue"+pwdValue);
		 System.out.println("p"+p);
		 
		 boolean verifyFiledsStatus=true;
		 
		 if(username.isDisplayed()&&username.isEnabled()&&sunameValue.equalsIgnoreCase("su"))
			{
				System.out.println("UserName text box is displayed and enabled "+ verifyFiledsStatus);
				
				
				if((password.isDisplayed())&&(password.isEnabled())&&p==true)
				{
					System.out.println("Password text box is displayed and enabled "+ verifyFiledsStatus);
					 password.sendKeys("su");
		
					if(companyDropDownList.isDisplayed()&&companyDropDownList.isEnabled())
					{
						System.out.println("Company Drop Down box is displayed and enabled "+ verifyFiledsStatus);
					
						if(signIn.isDisplayed()&&signIn.isEnabled())
						{
							System.out.println("SignIn is displayed and enabled "+ verifyFiledsStatus);
						
							if(companyCreateBtn.isDisplayed()&&companyCreateBtn.isEnabled())
							{
								System.out.println("Create Company Button is displayed and enabled "+ verifyFiledsStatus);
							
								if(keyboardBtn.isDisplayed()&&keyboardBtn.isEnabled())
								{
									System.out.println("Keyboard Button is displayed and enabled "+ verifyFiledsStatus);
								
									if(refreshBtn.isDisplayed()&&refreshBtn.isEnabled())
									{
										System.out.println("Refresh Button is displayed and enabled "+ verifyFiledsStatus);
						
		                                getWebDriverWait().until(ExpectedConditions.visibilityOf(rememberMeChk));
		 
										if(rememberMeChk.isDisplayed()&&rememberMeChk.isEnabled()&&rememberMeChk.isSelected())
										{
											System.out.println("Remember Me Checkbox is displayed and enabled "+ verifyFiledsStatus);
												
											
											if(rememberPwdChk.isDisplayed()&&rememberPwdChk.isEnabled())
											{
												System.out.println("Remember Password Checkbox is displayed and enabled "+ verifyFiledsStatus);
															
												 if(frgtPwdLnk.isDisplayed()&&frgtPwdLnk.isEnabled())
												 {
													System.out.println("Forgot Password Link is displayed and enabled "+ verifyFiledsStatus);
													verifyFiledsStatus=true;
													
												 }
												 else
												 {
													 System.out.println("Fail : frgtPwdLnk");
													 verifyFiledsStatus=false;
												 }
											}
											else
											 {
												 System.out.println("Fail : rememberPwdChk ");
												 verifyFiledsStatus=false;
											 }

											
										}
										else
										 {
											 System.out.println("Fail : rememberMeChk");
											 verifyFiledsStatus=false;
										 }

									}
									else
									 {
										 System.out.println("Fail : frgtPwdLnk");
										 verifyFiledsStatus=false;
									 }
							     }
								else
								 {
									 System.out.println("Fail : refreshBtn ");
									 verifyFiledsStatus=false;
								 }

						      }
							else
							 {
								 System.out.println("Fail : keyboardBtn");
								 verifyFiledsStatus=false;
							 }

					      }
						
						else
						 {
							 System.out.println("Fail : companyCreateBtn ");
							 verifyFiledsStatus=false;
						 }

					   }
					else
					 {
						 System.out.println("Fail : companyDropDownList");
						 verifyFiledsStatus=false;
					 }

				   }
				else
				 {
					verifyFiledsStatus=false;
					 System.out.println("Fail : password");
					System.out.println( password.isDisplayed());
					System.out.println(password.isEnabled());
					System.out.println(pwdValue.isEmpty());
	
				 }

				}
	 						
				else 
				{
					verifyFiledsStatus=false;
					System.out.println("Fail username "+verifyFiledsStatus);
				}

			return verifyFiledsStatus;
				
		  }

		 
   public void signInWithRememberMyPassword()
   {
	   
	   
	     username.click();
         username.sendKeys("su");
         getAction().moveToElement(username).sendKeys(Keys.TAB).perform();
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(password));
		 password.sendKeys("su");
		 getAction().moveToElement(password).sendKeys(Keys.TAB).perform();
		 
		 String sunameValue=username.getAttribute("value");
		 String pwdValue=username.getAttribute("value");
		 
		 rememberMeChk.click();
		 
		 rememberPwdChk.click();
		 
		 signIn.click();
		 
		 
	   
   }
   
   
   
	
	 
   
   public static boolean signOutWithSignInAsRememeberMyPassword() throws InterruptedException
	 {
		 
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(username));
		 
         username.click();
		 //Thread.sleep(4000);
       
         getAction().moveToElement(username).sendKeys(Keys.TAB).perform();
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(password));
		 //password.sendKeys("su");
		 getAction().moveToElement(password).sendKeys(Keys.TAB).perform();
		 
		 String sunameValue=username.getAttribute("value");
		 String pwdValue=username.getAttribute("value");
		 
		 System.out.println(sunameValue);
		 System.out.println(pwdValue);
		 
		 boolean verifyFiledsStatus=true;
		 
		 if(username.isDisplayed()&&username.isEnabled()&&sunameValue.equalsIgnoreCase("su"))
			{
				System.out.println("UserName text box is displayed and enabled "+ verifyFiledsStatus);
				
				if(password.isDisplayed()&&password.isEnabled()&&pwdValue.equalsIgnoreCase("su"))
				{
					System.out.println("Password text box is displayed and enabled "+ verifyFiledsStatus);
		
					if(companyDropDownList.isDisplayed()&&companyDropDownList.isEnabled())
					{
						System.out.println("Company Drop Down box is displayed and enabled "+ verifyFiledsStatus);
					
						if(signIn.isDisplayed()&&signIn.isEnabled())
						{
							System.out.println("SignIn is displayed and enabled "+ verifyFiledsStatus);
						
							if(companyCreateBtn.isDisplayed()&&companyCreateBtn.isEnabled())
							{
								System.out.println("Create Company Button is displayed and enabled "+ verifyFiledsStatus);
							
								if(keyboardBtn.isDisplayed()&&keyboardBtn.isEnabled())
								{
									System.out.println("Keyboard Button is displayed and enabled "+ verifyFiledsStatus);
								
									if(refreshBtn.isDisplayed()&&refreshBtn.isEnabled())
									{
										System.out.println("Refresh Button is displayed and enabled "+ verifyFiledsStatus);
						
		                                getWebDriverWait().until(ExpectedConditions.visibilityOf(rememberMeChk));
		 
										if(rememberMeChk.isDisplayed()&&rememberMeChk.isEnabled()&&rememberMeChk.isSelected())
										{
											System.out.println("Remember Me Checkbox is displayed and enabled "+ verifyFiledsStatus);
												
											
											if(rememberPwdChk.isDisplayed()&&rememberPwdChk.isEnabled()&&rememberPwdChk.isSelected())
											{
												System.out.println("Remember Password Checkbox is displayed and enabled "+ verifyFiledsStatus);
															
												 if(frgtPwdLnk.isDisplayed()&&frgtPwdLnk.isEnabled())
												 {
													System.out.println("Forgot Password Link is displayed and enabled "+ verifyFiledsStatus);
													verifyFiledsStatus=true;
													
												 }
												 else
												 {
													 System.out.println("Forgot Password Link is : Fail ");
													 verifyFiledsStatus=false;
												 }
											}
											else
											 {
												 System.out.println("rememberPwdChk Checkbox : Fail ");
												 verifyFiledsStatus=false;
											 }

											
										}
										else
										 {
											 System.out.println("rememberMeChk Button : Fail ");
											 verifyFiledsStatus=false;
										 }

									}
									else
									{
										 System.out.println("refreshBtn Button : Fail ");
										 verifyFiledsStatus=false;
									}
							     }
								else
								 {
									 System.out.println("keyboardBtn : Fail ");
									 verifyFiledsStatus=false;
								 }

						      }
							else
							 {
								 System.out.println("companyCreateBtn : Fail ");
								 verifyFiledsStatus=false;
							 }

					      }
						
						else
						 {
							 System.out.println("signIn : Fail ");
							 verifyFiledsStatus=false;
						 }

					   }
					else
					 {
						 System.out.println("companyDropDownList : Fail ");
						 verifyFiledsStatus=false;
					 }

				   }
				else
				 {
					 System.out.println("Password field is displaying as Fail ");
					 verifyFiledsStatus=false;
				 }

				}
	 						
				else 
				{
					verifyFiledsStatus=false;
					System.out.println("User Name "+verifyFiledsStatus);
				}

			return verifyFiledsStatus;
				
		  }

	 
   
   
   
   
   public boolean checkForgotMyPassword() throws InterruptedException
   {
	   
	   String forgotMsg="Email not found for \'su\'";
	   System.out.println("Forgot msg : "+forgotMsg);
	   
	   getWebDriverWait().until(ExpectedConditions.elementToBeClickable(frgtPwdLnk));
	   
	   frgtPwdLnk.click();
	   
	   Thread.sleep(4000);
	   
	   System.out.println("Mandatory Message : "+mandatoryMsgs.getText());
		  
		  if(forgotMsg.equalsIgnoreCase(mandatoryMsgs.getText()))
		  {
			  System.out.println(true);
			  return true;
		  }
		  else
		  {
			  System.out.println(false);
			  return false;
		  }
		  
	   
   }
   
   
   
   public void clickOnSignIn()
   {
	     getWebDriverWait().until(ExpectedConditions.visibilityOf(username));
	     username.click();
         username.sendKeys("su");
         getAction().moveToElement(username).sendKeys(Keys.TAB).perform();
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(password));
		 password.sendKeys("su");
		 getAction().moveToElement(password).sendKeys(Keys.TAB).perform();
		 
		 getWebDriverWait().until(ExpectedConditions.visibilityOf(signIn));
		 signIn.click();
		 
   }

   
   
   
   public static boolean verifyUserHomePageAndDashBoardAfterUpdateTheCompany() throws InterruptedException
   {
	   
   	boolean avbFields=false;
   	
	WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
	
	wlp.clickOnAbout();

	String getgetPatchDateTime=wlp.getReleasedate();
	
	wlp.clickOnAboutToClose();
	
	String getCompanyNamePatch="Automation Company : "+getgetPatchDateTime;
	
	System.out.println("GetCompanyNamePatch**********GetCompanyPatch : "+getCompanyNamePatch);
	
	
   /*	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(userNameDisplay));
   	
   	Thread.sleep(4000);
   	getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(userNameDisplay, "SU"));
   	String userInfo=userNameDisplay.getText();
   	
   	System.out.println("User Info : "+userInfo);
   	System.out.println("User Info Capture Text :"+userNameDisplay.getText());
   	
   	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(companyLogo));
   	companyLogo.click();
   	
   	//getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(companyName, "Automation Company "));
   	String getCompanyTxt=companyName.getText();
   	String getLoginCompanyName=getCompanyTxt.substring(0, 23);
   	System.out.println("company name :"+ getLoginCompanyName);
  
   	
   	companyLogo.click();
   	
   	//if(focusLogo.isDisplayed()&&menuBar.isDisplayed()&&dashboardName.isDisplayed()&&dashboardIcons.isDisplayed()&&userNameDisplay.isDisplayed()&&companyLogo.isDisplayed())
   	//{
   		//getLogger().info("Pass : Login the Company and Information is displaying correct");
			//System.out.println("Pass : Login the Company and Information is displaying Correct");
   		
   		if(userInfo.equalsIgnoreCase("SU")&&getLoginCompanyName.equalsIgnoreCase(getCompanyNamePatch))
   		{
   			avbFields=true;
   			getLogger().info("Login User the Company Name and Information is displaying correct");
   			System.out.println("Pass : Login User and Company Name is displaying Correct");
   		}
   		else
   		{
   			avbFields=false;
   			getLogger().info("Fail : Login User the Company Name and Information is displaying Wrong");
   			System.out.println("Fail : Login Name the Company Name and Information is displaying Wrong");
   		}
   		
   	//}
   	//else
   	//{
   		//getLogger().info("Fail : Login the Company and Information is displaying correct");
			//System.out.println("Fail : Login User the Company Name and Information is displaying Correct");
   		
   		//avbFields=false;
*/   	
   	return avbFields;
   }
   
   

	
	public LoginPage(WebDriver driver) 
	{
		
		  PageFactory.initElements(driver, this);
	}
	
	

	
}