package com.focus.Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.focus.base.BaseEngine;

public class HomeMenuSecurityCreateProfilePage extends BaseEngine {
	
	    //Home Menu
		@FindBy (xpath="//*[@id='1']/div/span")
	    private static WebElement homeMenu;

		//Security Menu	
		@FindBy (xpath="//*[@id='6']/span")
	    private static WebElement securityMenu;
		
		//Create Profile Sub Menu
		@FindBy (xpath="//*[@id='9']/span")
	    private static WebElement createProfileSubMenu;
	
		//Create Profile Title
		@FindBy (xpath="//*[@id='securityNavBar']/div/div[1]/a/div/span[2]")
	    private static WebElement createProfileTitle;
		
		//Create Profile Name
		@FindBy (xpath="//*[@id='profileName']")
	    private static WebElement createProfileName;
		
		//Create Profile Name arrow
		@FindBy (xpath="//*[@id='profileName_input_image']/span")
	    private static WebElement createProfileNameArrow;
		
		//Create Profile Name settings
		@FindBy (xpath="//*[@id='profileName_input_settings']/span")
	    private static WebElement createProfileNameSettings;
	
		//Create Profile Menu
		@FindBy (xpath="//*[@id='Profilemenu']")
	    private static WebElement profileMenu;
		
		        //Create Profile HomeExpand
				@FindBy (xpath="//*[@id='1']")
			    private static WebElement profileHomeExpand;
					
					//Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//a[@id='2']//span[contains(text(),'Company')]")
				    private static WebElement profileCompanyExpand;
					
						//Create Profile HomeExpand
						@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Open Company')]")
					    private static WebElement profileCompanyOpenCompany;
						
							//Create Profile HomeExpand
							@FindBy (xpath="//span[contains(text(),'Access')]")
						    private static WebElement companyRestrictionAccess;
							
						//Create Profile HomeExpand
						@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'New Company')]")
					    private static WebElement profileCompanyNewCompany;
						
							//Create Profile HomeExpand
							@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Create Company')]")
						    private static WebElement profileCompanyCreateCompany;
							
						//Create Profile HomeExpand
						@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Edit Company')]")
						private static WebElement profileCompanyEditCompany;	
						
						//Create Profile HomeExpand
						@FindBy (xpath="//li[@class='treeview']//a[@id='131']")
						private static WebElement profileCompanyYearEndProcessCompany;	
						
							//Create Profile HomeExpand
							@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Close Company')]")
							private static WebElement profileCompanyCloseCompany;	
							
							//Create Profile HomeExpand
							@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Update COGS')]")
							private static WebElement profileCompanyUpdateCogsCompany;					
							
						//Create Profile HomeExpand
						@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Inter Company Transactions')]")
						private static WebElement profileCompanyInterCompanyTransactions;	
							
							//Create Profile HomeExpand
							@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Inter Company Settings')]")
							private static WebElement profileCompanyInterCompanySettings;	
								
							//Create Profile HomeExpand
							@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Mapping')]")
							private static WebElement profileCompanyInterCompanyMappings;	
							
							//Create Profile HomeExpand
							@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Inbox/Outbox')]")
							private static WebElement profileCompanyIOBox;	
								
							//Create Profile HomeExpand
							@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Offline Import')]")
							private static WebElement profileCompanyOfflineImport;	
						
					//Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Security')]")
				    private static WebElement profileSecurityExpand;
					
					//Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//a[@id='1000']//span[contains(text(),'Masters')]")
				    private static WebElement profileMastersExpand;
					
					//Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//a[@id='25']")
				    private static WebElement profileDataManagementExpand;
					
					//Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//a[@id='20']//span[contains(text(),'Utilities')]")
				    private static WebElement profileUtilitiesExpand;
							
				//Create Profile FinancialExpand
				@FindBy (xpath="//*[@id='60']/i")
			    private static WebElement profileFinancialExpand;
									
					//Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//a[@id='61']//span[contains(text(),'Transactions')]")
				    private static WebElement financialsTransactionsExpand;
						
					//Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Credit Management')]")
				    private static WebElement financialsCreditManagementExpand;
				
					//Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//a[@id='81']//span[contains(text(),'Reports')]")
				    private static WebElement financialsReportsExpand;
				
					//Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Final Accounts')]")
				    private static WebElement financialsAccountsExpand;
				
					//Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Receivable and Payable Analysis')]")
				    private static WebElement financialsReceviablesAndPayablesExpand;
						
					//Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//a[@id='3301']//span[contains(text(),'Budget')]")
				    private static WebElement financialsBudgetExpand;
					
					//Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Online Payments')]")
				    private static WebElement financialsOnlinePaymentExpand;
								
				//Create Profile InventoryExpand
				@FindBy (xpath="/html[1]/body[1]/section[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[3]/a[1]/span[1]")
			    private static WebElement profileInventoryExpand;	
				
					//Create Profile Menu
					@FindBy (xpath="/html[1]/body[1]/section[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[1]/a[1]/span[1]")
				    private static WebElement inventoryTransactionsExpand;
						
					//Create Profile Menu
					@FindBy (xpath="/html[1]/body[1]/section[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]/span[1]")
				    private static WebElement inventoryReportsExpand;
				
					//Create Profile Menu
					@FindBy (xpath="//html[1]/body[1]/section[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[3]/a[1]/span[1]")
				    private static WebElement inventorOrderManagementExpand;
							
				//Create Profile FixedAssetExpand
				@FindBy (xpath="//*[@id='136']/i")
			    private static WebElement profileFixedAssetExpand;	
				
					//Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//a[@id='138']//span[contains(text(),'Transactions')]")
				    private static WebElement fixedAssetsTransactions;
																
				//Create Profile ProductionExpand
			    @FindBy (xpath="//*[@id='3000']/i")
			    private static WebElement profileProductionExpand;	
			    
				    //Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//a[@id='3001']//span[contains(text(),'Transactions')]")
				    private static WebElement productionTransactions;
			    
					//Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//a[@id='625']//span[contains(text(),'Reports')]")
				    private static WebElement productionReports;
					
					//Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'MRP Settings')]")
				    private static WebElement productionMRPSettings;
			    
				//Create Profile PointOfSaleExpand
			    @FindBy (xpath="//*[@id='8000']/i")
			    private static WebElement profilePointOfSaleExpand;
			    
				    //Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Main Screen')]")
				    private static WebElement pointOfSaleMainScreen;
			    
					//Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'POS Reports')]")
				    private static WebElement pointOfSaleReports;
					
					//Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//a[@id='8003']//span[contains(text(),'Utilities')]")
				    private static WebElement pointOfSaleUtilities;
				    		
			    //Create Profile QualityControlExpand
			    @FindBy (xpath="//*[@id='150']/i")
			    private static WebElement profileQualityControlExpand;
			    
				    //Create Profile Menu
					@FindBy (xpath="//li[@class='treeview']//a[@id='151']//span[contains(text(),'Transactions')]")
				    private static WebElement qualityControlTransactions;
					
			    //Create Profile SettingsExpand
			    @FindBy (xpath="//*[@id='16']/i")
			    private static WebElement profileSettingExpand;
		
				    //Create Profile HomeExpand
					@FindBy (xpath="/html[1]/body[1]/section[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[8]/ul[1]/li[1]/a[1]/span[1]")
				    private static WebElement settingsConfigureTransactions;
					
					//Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Transaction Authorization')]")
				    private static WebElement settingsTransactionAuthorization;
					
					 //Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Pricebook Authorization')]")
				    private static WebElement settingsPriceBookAuthorzation;
					
					//Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Configure Masters')]")
				    private static WebElement settingsConfigureMasters;
					
					 //Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Master Authorization')]")
				    private static WebElement settingsMasterAuthorization;
					
					//Create Profile HomeExpand
					@FindBy (xpath="//span[contains(text(),'Dashboard')]")
				    private static WebElement settingsDashBoard;
					
					 //Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Credit Limit Authorization')]")
				    private static WebElement settingsCreditLimitAuthorization;
					
					//Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Design Workflow')]")
				    private static WebElement settingsDesignWorkFlow;
					
					 //Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Settings Wizard')]")
				    private static WebElement settingsWizard;
					
					//Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Map Credit Limit')]")
				    private static WebElement settingsMapCreditLimit;
							
					//Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'VAT Tax Code')]")
				    private static WebElement settingVATTaxCode;
					
					//Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Customer Portal Admin')]")
				    private static WebElement settingCustomerPortalAdmin;
					
					//Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Budget Authorization')]")
				    private static WebElement settingsBudgetAuthorization;
					
					 //Create Profile HomeExpand
					@FindBy (xpath="//li[@class='treeview']//span[contains(text(),'Payment Gateway Integration')]")
				    private static WebElement settingsPaymentGatewayIntegration;
				
		//Create Profile Restriction
		@FindBy (xpath="//*[@id='restrictionsDiv']")
	    private static WebElement profileRestriction;
				
		//Create Profile SelectAllBtn
		@FindBy (xpath="//*[@id='controlBtns']/div/span[1]/i")
	    private static WebElement profileSelectAllBtn;
		
		//Create Profile UnSelectAllBtn
		@FindBy (xpath="//*[@id='controlBtns']/div/span[2]/i")
	    private static WebElement profileUnSelectAllBtn;
		
		//Create Profile SaveBtn
		@FindBy (xpath="//*[@id='myNavbar']/ul/li/span[1]/i")
	    private static WebElement profileSaveBtn;
				
		//Create Profile QDeleteBtn
		@FindBy (xpath="//*[@id='myNavbar']/ul/li/span[2]/i")
	    private static WebElement profileDeletBtn;
		
		//Create Profile LoadFromBtn
		@FindBy (xpath="//*[@id='myNavbar']/ul/li/span[3]/i")
	    private static WebElement profileLoadBtn;
				
		//Create Profile CloseBtn
		@FindBy (xpath="//*[@id='myNavbar']/ul/li/span[4]/i")
	    private static WebElement profileCloseBtn;
		
		@FindBy(xpath="//*[@id='idGlobalError']/div/table/tbody/tr/td[2]/div[2]")
		private static WebElement msgCreateProfileGlobalError;
		
		@FindBy(xpath="//*[@id='idGlobalError']/div/table/tbody/tr/td[3]/span")
		private static WebElement closeMsgCreateProfileGlobalError;
	    
	    
		
		public static boolean navigateToCreateProfileSubMenu()
		{
			
	        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
			
			homeMenu.click();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(securityMenu));
			
			securityMenu.click();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileSubMenu));
			
			createProfileSubMenu.click();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileTitle));
			
			String getCreateProfileScreenName=createProfileTitle.getText();

			System.out.println(getCreateProfileScreenName);
			
			if(getCreateProfileScreenName.equalsIgnoreCase("Create Profile"))
			  {
				System.out.println("Pass : Create Profile Title is displaying Corrrect");
				return true;
			  }
			else
			{
				System.out.println("Fail : Create Profile Title is not displaying Correct");
				return false;
			}
		}
		
		
		
		
		public static boolean checkCreateProfileAvailability()
		{
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileName));
			  
			  if(createProfileName.isDisplayed())
			  {
				  System.out.println("pass createProfileName");
				  
				  if(createProfileNameArrow.isDisplayed())
				  {
					  System.out.println("pass createProfileNameArrow");
		
					  if(createProfileNameSettings.isDisplayed())
					  {
						  System.out.println("pass createProfileNameSettings");
			
						  if(profileMenu.isDisplayed())
						  {
							  System.out.println("pass profileMenu");
							  
							  createProfileName.click();
							  
							  getAction().moveToElement(createProfileName).sendKeys(Keys.TAB).perform();
				
							  if(profileHomeExpand.isDisplayed())
							  {
								  System.out.println("pass profileHomeExpand");
								  
								  getAction().moveToElement(profileHomeExpand).sendKeys(Keys.TAB).perform();
								  
								  if(profileFinancialExpand.isDisplayed())
								  {									  
									  System.out.println("pass profileFinancialExpand");
									  
									  getAction().moveToElement(profileFinancialExpand).sendKeys(Keys.TAB).perform();
						              
									  if(profileInventoryExpand.isDisplayed())
									  {
										  System.out.println("pass profileInventoryExpand");
										  
										  getAction().moveToElement(profileInventoryExpand).sendKeys(Keys.TAB).perform();
							
										  if(profileFixedAssetExpand.isDisplayed())
										  {
											  System.out.println("pass profileFixedAssetExpand");
											  
											  getAction().moveToElement(profileFixedAssetExpand).sendKeys(Keys.TAB).perform();
								
											  if(profileProductionExpand.isDisplayed())
											  {
												  System.out.println("pass profileProductionExpand");
												  
												  getAction().moveToElement(profileProductionExpand).sendKeys(Keys.TAB).perform();
												  
												  if(profilePointOfSaleExpand.isDisplayed())
												  {
													  System.out.println("pass profilePointOfSaleExpand");
													  
													  getAction().moveToElement(profilePointOfSaleExpand).sendKeys(Keys.TAB).perform();
													 
													  if(profileQualityControlExpand.isDisplayed())
													  {
														  System.out.println("pass profileQualityControlExpand");
														  
														  getAction().moveToElement(profileQualityControlExpand).sendKeys(Keys.TAB).perform();
														 
														  if(profileSettingExpand.isDisplayed())
														  {
															  System.out.println("pass profileSettingExpand");
															  
															  getAction().moveToElement(profileSettingExpand).sendKeys(Keys.TAB).perform();
															 
															  if(profileRestriction.isDisplayed())
															  {
																  System.out.println("pass profileRestriction");
																 																 													  
																  if(profileSelectAllBtn.isDisplayed())
																  {
																	  System.out.println("pass profileSelectAllBtn");
																 																						  
																	  if(profileUnSelectAllBtn.isDisplayed())
																	  {
																		  System.out.println("pass profileUnSelectAllBtn");
																		 
																		  if(profileSaveBtn.isDisplayed())
																		  {
																			  System.out.println("pass profileSaveBtn");
																			  
																			  if(profileDeletBtn.isDisplayed())
																			  {
																				  System.out.println("pass profileDeletBtn");
																				 
																				  if(profileLoadBtn.isDisplayed())
																				  {
																					  System.out.println("pass profileLoadBtn");
																					 
																					  if(profileCloseBtn.isDisplayed())
																					  {
																						  System.out.println("pass profileCloseBtn");
																						 
																						  return true;
																						  }
																						  else
																						  {
																							  System.out.println("Fail profileCloseBtn");
																							  return false;
																						  }  
																					  }
																					  else
																					  {
																						  System.out.println("Fail profileLoadBtn");
																						  return false;
																					  }  
																				  }
																				  else
																				  {
																					  System.out.println("Fail profileDeletBtn");
																					  return false;
																				  }  
																			  }
																			  else
																			  {
																				  System.out.println("Fail profileSaveBtn");
																				  return false;
																			  }  
																		  }
																		  else
																		  {
																			  System.out.println("Fail profileUnSelectAllBtn");
																			  return false;
																		  }  
																	  }
																	  else
																	  {
																		  System.out.println("Fail profileSelectAllBtn");
																		  return false;
																	  }  
																  }
																  else
																  {
																	  System.out.println("Fail profileRestriction");
																	  return false;
																  }  
															  }
															  else
															  {
																  System.out.println("Fail profileSettingExpand");
																  return false;
															  }  
														  }
														  else
														  {
															  System.out.println("Fail profileQualityControlExpand");
															  return false;
														  }  
													  }
													  else
													  {
														  System.out.println("Fail profilePointOfSaleExpand");
														  return false;
													  }  

												  }
												  else
												  {
													  System.out.println("Fail profileProductionExpand");
													  return false;
												  }  
											  }
											  else
											  {
												  System.out.println("Fail profileFixedAssetExpand");
												  return false;
											  }  
 
										  }
										  else
										  {
											  System.out.println("Fail profileInventoryExpand");
											  return false;
										  }  
									  }

									  else
									  {
										  System.out.println("Fail profileFinancialExpand");
										  return false;
									  }  
								  }
								  else
								  {
									  System.out.println("Fail profileHomeExpand");
									  return false;
								  }  
							  }

							  else
							  {
								  System.out.println("Fail profileMenu");
								  return false;
							  }  
						  }

						  else
						  {
							  System.out.println("Fail createProfileNameSettings");
							  return false;
						  }  
					  }

					  else
					  {
						  System.out.println("Fail createProfileNameArrow");
						  return false;
					  }  
				  }

				  else
				  {
					  System.out.println("Fail createProfileName");
					  return false;
				  }  
			  }


		

		public boolean checkPolicyNameAsMandatory()
		{
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profileSaveBtn));
			profileSaveBtn.click();
						
			String getPolciyNameAsMandatoryMsg=msgCreateProfileGlobalError.getText();
			
			System.out.println(getPolciyNameAsMandatoryMsg);
			
			if(getPolciyNameAsMandatoryMsg.equalsIgnoreCase("Please provide profile name"))
			{
				System.out.println("Pass : Please provide profile name Mandatory message is displaying");
				closeMsgCreateProfileGlobalError.click();
				return true;
			}
			else
			{
				System.out.println("Fail : Please provide profile name Mandatory message is not displaying");
				closeMsgCreateProfileGlobalError.click();
				return false;
			}
			
			
		}
		
		
		public boolean checkMenuPermissionsAsMandatory()
		{
			
			createProfileName.sendKeys("All Options Profile");
				
			profileSaveBtn.click();
								
			String getPolciyNameAsMandatoryMsg=msgCreateProfileGlobalError.getText();
			
			System.out.println(getPolciyNameAsMandatoryMsg);
			
			if(getPolciyNameAsMandatoryMsg.equalsIgnoreCase("Provide some Permissions and Save"))
			{
				System.out.println("Pass : Provide some Permissions Mandatory message is displaying");
				closeMsgCreateProfileGlobalError.click();
				return true;
			}
			else
			{
				System.out.println("Fail : Provide some Permissions Mandatory message is not displaying");
				closeMsgCreateProfileGlobalError.click();
				return false;
			}
			
			
		}
		
		
		public boolean checkHomeSubMenuOptionsPermissions()
		{
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileName));
			createProfileName.click();
			  
			 getAction().moveToElement(createProfileName).sendKeys(Keys.TAB).perform();
								
			if(profileHomeExpand.isDisplayed())
			  {
				  System.out.println("pass profileHomeExpand");
				  
				  profileHomeExpand.click();
				  
				  getAction().moveToElement(profileHomeExpand).sendKeys(Keys.TAB).perform();
				 		  
				  if(profileCompanyExpand.isDisplayed())
				  {
					  System.out.println("pass profileCompanyExpand");
		
					  getAction().moveToElement(profileCompanyExpand).sendKeys(Keys.TAB).perform();
					  
					  if(profileSecurityExpand.isDisplayed())
					  {
						  
						  System.out.println("pass profileSecurityExpand");
						  
						  getAction().moveToElement(profileSecurityExpand).sendKeys(Keys.TAB).perform();
						  
						  
						  if(profileMastersExpand.isDisplayed())
						  {
							  System.out.println("pass profileMastersExpand");
							  
							  getAction().moveToElement(profileMastersExpand).sendKeys(Keys.TAB).perform();
							  
							  
							  if(profileDataManagementExpand.isDisplayed())
							  {
								  System.out.println("pass profileDataManagementExpand");
								  
								  getAction().moveToElement(profileDataManagementExpand).sendKeys(Keys.TAB).perform();
								  
								  if(profileUtilitiesExpand.isDisplayed())
								  {
									  System.out.println("pass profileUtilitiesExpand");
									  return true;
								  }
								  else
								  {
									  System.out.println("Fail profileUtilitiesExpand");
									  return false;
								  }
							  }
							  else
							  {
								  System.out.println("Fail profileDataManagementExpand");
								  return false;
							  }
						  }
						  else
						  {
							  System.out.println("Fail profileMastersExpand");
							  return false;
						  }
					  }
					  else
					  {
						  System.out.println("Fail profileSecurityExpand");
						  return false;
					  }
				  }
				  else
				  {
					  System.out.println("Fail profileCompanyExpand");
					  return false;
				  }
			  }
			else
			{
				System.out.println("Fail profileHomeExpand");
				return false;
			}
			
			
			
			  
			
		}
		
		
	
		
		
		public static boolean checkFinancialsSubMenu()
		{		
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profileFinancialExpand));
				profileFinancialExpand.click();
				  
				getAction().moveToElement(profileFinancialExpand).sendKeys(Keys.TAB).perform();
									
				if(financialsTransactionsExpand.isDisplayed())
				  {
					  System.out.println("pass financialsTransactionsExpand");
					  
					  getAction().moveToElement(financialsTransactionsExpand).sendKeys(Keys.TAB).perform();
					 		  
					  if(financialsCreditManagementExpand.isDisplayed())
					  {
						  System.out.println("pass financialsCreditManagementExpand");
			
						  getAction().moveToElement(financialsCreditManagementExpand).sendKeys(Keys.TAB).perform();
						  
						  if(financialsReportsExpand.isDisplayed())
						  {
							 System.out.println("pass financialsReportsExpand");
							  
							  getAction().moveToElement(financialsReportsExpand).sendKeys(Keys.TAB).perform();
							  
							  if(financialsAccountsExpand.isDisplayed())
							  {
								  System.out.println("pass financialsAccountsExpand");
								  
								  getAction().moveToElement(financialsAccountsExpand).sendKeys(Keys.TAB).perform();
								  
								  if(financialsReceviablesAndPayablesExpand.isDisplayed())
								  {
									  System.out.println("pass financialsReceviablesAndPayablesExpand");
									  
									  getAction().moveToElement(financialsReceviablesAndPayablesExpand).sendKeys(Keys.TAB).perform();
									  
									  if(financialsBudgetExpand.isDisplayed())
									  {
										  System.out.println("pass financialsBudgetExpand");
										  
										  getAction().moveToElement(financialsBudgetExpand).sendKeys(Keys.TAB).perform();
										  
										  if(financialsOnlinePaymentExpand.isDisplayed())
										  {
											  System.out.println("pass financialsOnlinePaymentExpand");
											  return true;
										  }
										  else
										  {
											  System.out.println("Fail financialsOnlinePaymentExpand");
											  return false;
										  }
									  }
									  else
									  {
										  System.out.println("Fail financialsBudgetExpand");
										  return false;
									  }
								  }
								  else
								  {
									  System.out.println("Fail financialsReceviablesAndPayablesExpand");
									  return false;
								  }
							  }
							  else
							  {
								  System.out.println("Fail financialsAccountsExpand");
								  return false;
							  }
						  }
						  else
						  {
							  System.out.println("Fail financialsReportsExpand");
							  return false;
						  }
					  }
					  else
					  {
						  System.out.println("Fail financialsCreditManagementExpand");
						  return false;
					  }
				  }
				else
				{
					System.out.println("Fail financialsTransactionsExpand");
					return false;
				}
						  
			}
	
		
		
		public static boolean checkInventoryMenu() throws Exception
		{
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profileFinancialExpand));
			profileFinancialExpand.click();
						
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileName));
			createProfileName.click();
			  
			getAction().moveToElement(createProfileName).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileHomeExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileFinancialExpand).sendKeys(Keys.TAB).perform();
			
			  System.out.println("checkInventoryMenu");
			  
			  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profileInventoryExpand));

			  profileInventoryExpand.click();
			   
			  getAction().moveToElement(profileInventoryExpand).sendKeys(Keys.TAB).perform();
			  
			  if(inventoryTransactionsExpand.isDisplayed())
			  {			  
				  System.out.println("pass : inventoryTransactionsExpand");
				  getAction().moveToElement(inventoryTransactionsExpand).sendKeys(Keys.TAB).perform();
				  
				  if(inventoryReportsExpand.isDisplayed())
				  {			  
					  System.out.println("pass inventoryReportsExpand");
					  getAction().moveToElement(inventoryReportsExpand).sendKeys(Keys.TAB).perform();
					  
					  if(inventorOrderManagementExpand.isDisplayed())
					  {			  
						  System.out.println("pass : inventorOrderManagementExpand");
						  return true;
						 
					  }
					  else
					  {
						  System.out.println("Fail : inventorOrderManagementExpand");
						  return false;
					  }
				  }
				  else
				  {
					  System.out.println("Fail : inventoryReportsExpand");
					  return false;
				  }
			  }
			  else
			  {
				  System.out.println("Fail : inventoryTransactionsExpand");
				  return false;
			  }
			  
			
			  
		}

		
		
		
		public static boolean checkFixedAssetMenu() throws Exception
		{
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profileInventoryExpand));
			profileInventoryExpand.click();
						
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileName));
			createProfileName.click();
			  
			getAction().moveToElement(createProfileName).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileHomeExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileFinancialExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileInventoryExpand).sendKeys(Keys.TAB).perform();

			System.out.println("profileFixedAssetExpand");

			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profileFixedAssetExpand));
			profileFixedAssetExpand.click();
		
            getAction().moveToElement(profileFixedAssetExpand).sendKeys(Keys.TAB).perform();
						  
					  if(fixedAssetsTransactions.isDisplayed())
					  {
						  System.out.println("pass : Fixed Assets Transactions Sub Menu display");
						  return true;
					  }
					  else
					  {
						   System.out.println("Fail : Fixed Assets Transactions Sub Menu is not display");
						   return false;
					   }
			

			
			  }

		
		public static boolean checkProductionMenu() throws Exception
		{
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profileFixedAssetExpand));
			profileFixedAssetExpand.click();
						
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileName));
			createProfileName.click();
			  
			getAction().moveToElement(createProfileName).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileHomeExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileFinancialExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileInventoryExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileFixedAssetExpand).sendKeys(Keys.TAB).perform();
			System.out.println("checkProductionMenu");

			profileProductionExpand.click();
			   
			  getAction().moveToElement(profileProductionExpand).sendKeys(Keys.TAB).perform();
			  
			  if(productionTransactions.isDisplayed())
			  {			  
				  System.out.println("pass productionTransactions");
				  
				  getAction().moveToElement(productionTransactions).sendKeys(Keys.TAB).perform();
				  
				  if(productionReports.isDisplayed())
				  {			  
					  System.out.println("pass : productionReports");
					  
					  getAction().moveToElement(productionReports).sendKeys(Keys.TAB).perform();
					  
					  if(productionMRPSettings.isDisplayed())
					  {			  
						  System.out.println("pass : productionMRPSettings");
						  return true;
						 
					  }
					  else
					  {
						  System.out.println("Fail : productionMRPSettings");
						  return false;
					  }
				  }
				  else
				  {
					  System.out.println("Fail : productionReports");
					  return false;
				  }
			  }
			  else
			  {
				  System.out.println("Fail : productionTransactions");
				  return false;
			  }
			  
			
			  
			  }




		public static boolean checkPointOfSaleMenu() throws Exception
		{
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profileProductionExpand));
			profileProductionExpand.click();
						
			Thread.sleep(3000);
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileName));
			createProfileName.click();
			  
			getAction().moveToElement(createProfileName).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileHomeExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileFinancialExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileInventoryExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileFixedAssetExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileProductionExpand).sendKeys(Keys.TAB).perform();
			System.out.println("checkPointOfSaleMenu");

			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profilePointOfSaleExpand));
			profilePointOfSaleExpand.click();
			   
			  getAction().moveToElement(profilePointOfSaleExpand).sendKeys(Keys.TAB).perform();
			  
				  if(pointOfSaleMainScreen.isDisplayed())
				  {			  
					  System.out.println("pass : pointOfSaleMainScreen");
					  
					  getAction().moveToElement(pointOfSaleMainScreen).sendKeys(Keys.TAB).perform();
					  
					  if(pointOfSaleReports.isDisplayed())
					  {			  
						  System.out.println("pass : pointOfSaleReports");
						  
						  getAction().moveToElement(pointOfSaleUtilities).sendKeys(Keys.TAB).perform();
						  
						  if(pointOfSaleUtilities.isDisplayed())
						  {			  
							  System.out.println("pass : pointOfSaleUtilities");
							  return true;
							 
						  }
						  else
						  {
							  System.out.println("Fail : pointOfSaleUtilities");
							  return false;
						  }
						 
					  }
					  else
					  {
						  System.out.println("Fail : pointOfSaleReports");
						  return false;
					  }
				  }
				  else
				  {
					  System.out.println("Fail : pointOfSaleMainScreen");
					  return false;
				  }
			  }

			  
			
		public static boolean checkQualityControlMenu() throws Exception
		{
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profilePointOfSaleExpand));
			profilePointOfSaleExpand.click();
						
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileName));
			createProfileName.click();
			  
			getAction().moveToElement(createProfileName).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileHomeExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileFinancialExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileInventoryExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileFixedAssetExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileProductionExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profilePointOfSaleExpand).sendKeys(Keys.TAB).perform();
			System.out.println("checkQualityControl");

			profileQualityControlExpand.click();
			   
			  getAction().moveToElement(profileQualityControlExpand).sendKeys(Keys.TAB).perform();
			  
				  if(qualityControlTransactions.isDisplayed())
				  {			  
					  System.out.println("pass : qualityControlTransactions");
				
					  return true;
					  
				  }
				  else
				  {
					  System.out.println("Fail : qualityControlTransactions");
					  return false;
				  }
			  }

		public static boolean checkSettingsMenu() throws Exception
		{
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profileQualityControlExpand));
			profileQualityControlExpand.click();
						
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileName));
			createProfileName.click();
			  
			getAction().moveToElement(createProfileName).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileHomeExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileFinancialExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileInventoryExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileFixedAssetExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileProductionExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profilePointOfSaleExpand).sendKeys(Keys.TAB).perform();
            getAction().moveToElement(profileQualityControlExpand).sendKeys(Keys.TAB).perform();
			System.out.println("checkSettings");

			profileSettingExpand.click();
			
			Thread.sleep(4000);
			   
			settingsConfigureTransactions.click();
			
				  if(settingsConfigureTransactions.isDisplayed())
				  {			  
					  System.out.println("pass : settingsConfigureTransactions");

					  if(settingsTransactionAuthorization.isDisplayed())
					  {			  
						  System.out.println("pass : settingsTransactionAuthorization");
						  
						  if(settingsPriceBookAuthorzation.isDisplayed())
						  {			  
							  System.out.println("pass : settingsPriceBookAuthorzation");
							  
							  if(settingsConfigureMasters.isDisplayed())
							  {			  
								  System.out.println("pass : settingsConfigureMasters");
								  
								  if(settingsMasterAuthorization.isDisplayed())
								  {			  
									  System.out.println("pass : settingsMasterAuthorization");
									  
									  Thread.sleep(4000);
									  
									  if(settingsDashBoard.isDisplayed())
									  {			  
										  System.out.println("pass : settingsDashBoard");
										  
										  if(settingsCreditLimitAuthorization.isDisplayed())
										  {			  
											  System.out.println("pass : settingsCreditLimitAuthorization");
											  
											  if(settingsDesignWorkFlow.isDisplayed())
											  {			  
												  System.out.println("pass : settingsDesignWorkFlow");
												  
	
												  if(settingsWizard.isDisplayed())
												  {			  
													  System.out.println("pass : settingsWizard");
													  
													  if(settingsMapCreditLimit.isDisplayed())
													  {			  
														  System.out.println("pass : settingsMapCreditLimit");
														  
														  js.executeScript("arguments[0].scrollIntoView();", settingVATTaxCode);
														  
														  if(settingVATTaxCode.isDisplayed())
														  {			  
															  System.out.println("pass : settingVATTaxCode");
															  
															  if(settingCustomerPortalAdmin.isDisplayed())
															  {			  
																  System.out.println("pass : settingCustomerPortalAdmin");
																  
																  if(settingsBudgetAuthorization.isDisplayed())
																  {			  
																	  System.out.println("pass : settingsBudgetAuthorization");
																	  
																	  Thread.sleep(2000);
																	  
																	  if(settingsPaymentGatewayIntegration.isDisplayed())
																	  {			  
																		  System.out.println("pass : settingsPaymentGatewayIntegration");
																		  return true;
																		  
																	  }
																	  else
																	  {
																		  System.out.println("Fail : settingsPaymentGatewayIntegration");
																		  return false;
																	  }
																	  
																  }
																  else
																  {
																	  System.out.println("Fail : settingsBudgetAuthorization");
																	  return false;
																  }
																  
															  }
															  else
															  {
																  System.out.println("Fail : settingCustomerPortalAdmin");
																  return false;
															  }
															  
														  }
														  else
														  {
															  System.out.println("Fail : settingVATTaxCode");
															  return false;
														  }
														  
													  }
													  else
													  {
														  System.out.println("Fail : settingsMapCreditLimit");
														  return false;
													  }
													  
													  
												  }
												  else
												  {
													  System.out.println("Fail : settingsWizard");
													  return false;
												  }
												  
											  }
											  else
											  {
												  System.out.println("Fail : settingsDesignWorkFlow");
												  return false;
											  }
											  
											  
										  }
										  else
										  {
											  System.out.println("Fail : settingsCreditLimitAuthorization");
											  return false;
										  }
										  
									  }
									  else
									  {
										  System.out.println("Fail : settingsDashBoard");
										  return false;
									  }
									  
								  }
								  else
								  {
									  System.out.println("Fail : settingsMasterAuthorization");
									  return false;
								  }
								  
							  }
							  else
							  {
								  System.out.println("Fail : settingsConfigureMasters");
								  return false;
							  }
							  
						  }
						  else
						  {
							  System.out.println("Fail : settingsPriceBookAuthorzation");
							  return false;
						  }
						  
					  }
					  else
					  {
						  System.out.println("Fail : settingsTransactionAuthorization");
						  return false;
					  }
					  
				  }
				  else
				  {
					  System.out.println("Fail : settingsConfigureTransactions");
					  return false;
				  }
			  }
		
		
		public boolean checkMandatorySelectMenuClickOnSelectAllBtn() throws InterruptedException
		{
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profileSettingExpand));
			profileSettingExpand.click();
			
			
			
			profileSelectAllBtn.click();
			
            String getSelectAllBtnAsMandatoryMsg=msgCreateProfileGlobalError.getText();
			
			System.out.println(getSelectAllBtnAsMandatoryMsg);
			
			Thread.sleep(2000);
			
			if(getSelectAllBtnAsMandatoryMsg.equalsIgnoreCase("Select menu"))
			{
				System.out.println("Pass : Select menu Mandatory message is displaying");
				closeMsgCreateProfileGlobalError.click();
				return true;
			}
			else
			{
				System.out.println("Fail : Select menu Mandatory message is not displaying");
				closeMsgCreateProfileGlobalError.click();
				return false;
			}
		
		}

		
		

		public boolean saveCreateProfileBySelectAllWithProfileAsAllOptions() throws InterruptedException
		{
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileName));
			createProfileName.click();

			Thread.sleep(2000);
			
			getAction().moveToElement(createProfileName).sendKeys(Keys.TAB).perform();
			
			profileHomeExpand.click();
			profileSelectAllBtn.click();
			profileHomeExpand.click();
			getAction().moveToElement(profileHomeExpand).sendKeys(Keys.TAB).perform();
			Thread.sleep(2000);
		    
			profileFinancialExpand.click();
			profileSelectAllBtn.click();
			profileFinancialExpand.click();
			getAction().moveToElement(profileFinancialExpand).sendKeys(Keys.TAB).perform();
			Thread.sleep(2000);
			
			profileInventoryExpand.click();
			profileSelectAllBtn.click();
			profileInventoryExpand.click();
			getAction().moveToElement(profileInventoryExpand).sendKeys(Keys.TAB).perform();
			
			profileFixedAssetExpand.click();
			profileSelectAllBtn.click();
			profileFixedAssetExpand.click();
			getAction().moveToElement(profileFixedAssetExpand).sendKeys(Keys.TAB).perform();
            
			profileProductionExpand.click();
			profileSelectAllBtn.click();
			profileProductionExpand.click();
			getAction().moveToElement(profileProductionExpand).sendKeys(Keys.TAB).perform();
			
			profilePointOfSaleExpand.click();
			profileSelectAllBtn.click();
			profilePointOfSaleExpand.click();
			getAction().moveToElement(profilePointOfSaleExpand).sendKeys(Keys.TAB).perform();
			
			profileQualityControlExpand.click();
			profileSelectAllBtn.click();
			profileQualityControlExpand.click();
			getAction().moveToElement(profileQualityControlExpand).sendKeys(Keys.TAB).perform();
          			
			profileSettingExpand.click();
			profileSelectAllBtn.click();
			profileSettingExpand.click();

			
			profileSaveBtn.click();
			
			 String getProfileSaveMsg=msgCreateProfileGlobalError.getText();
				
				System.out.println(getProfileSaveMsg);
				
				if(getProfileSaveMsg.equalsIgnoreCase("Profile saved Successfully"))
				{
					System.out.println("Pass : Profile saved Successfully message is displaying");
					closeMsgCreateProfileGlobalError.click();
					return true;
				}
				else
				{
					System.out.println("Fail : Profile saved Successfully message is not displaying");
					closeMsgCreateProfileGlobalError.click();
					return false;
				}
		}
		
		
		
		public static boolean checkSavedProfileName()
		{
			
			String Strq= createProfileName.getText();
			
			 boolean createProfileNameValue=false;
			 String[] str= Strq.split("\n");     
		      for(String st1 : str)
		      {
		    	
		    	  st1.equals("All Options Profile");
		    	  createProfileName.click();
		    	  createProfileName.sendKeys("All Options Profile");
		    	  getAction().moveToElement(createProfileName).sendKeys(Keys.TAB).perform();
		    	  createProfileNameValue=true;
		    	  break;
		      }
		      
			return createProfileNameValue;
			
		}
		
		
		
		public static boolean checkOpenCompany()
		{
		   //System.out.println("First : 1");
           //getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileName));
           //System.out.println("Second : 2");
		   //createProfileName.click();
		   //System.out.println("Third : 3");
		   //createProfileName.sendKeys("All");
	       //getAction().moveToElement(createProfileName).sendKeys(Keys.TAB).perform();
		   //System.out.println("4");
		   
		   getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profileHomeExpand));
		   profileHomeExpand.click();
		   System.out.println("5");	
		   getAction().moveToElement(profileHomeExpand).sendKeys(Keys.ENTER).perform();
			getAction().moveToElement(profileHomeExpand).sendKeys(Keys.TAB).perform();
        
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(profileCompanyExpand));
			profileCompanyExpand.click();
			
			if(profileCompanyOpenCompany.isDisplayed())
			{
				System.out.println("Pass : Company Menu has Open Company");
				
				profileCompanyOpenCompany.click();
				return true;
			
			}
			else
			{
				System.out.println("Fail : Company Menu has Open Company");
				return false;
			}
		}
		
		
		public static boolean getCompanyMenuRestriction()
		{
			if(companyRestrictionAccess.isSelected())
			{
				System.out.println("Pass : Company Restriction Access is checked");
				return true;
			}
			else
			{
				System.out.println("Fail : Company Restriction Access is un check");
				return false;
			}
			
			
		}
		
		
		
		
		/*public static boolean checkHomeAllOptions()
		{
			
			
			getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createProfileName));
			
			createProfileName.click();
			
			createProfileName.sendKeys("[Tab]");
			
			profileHomeExpand.click();
			
			profileHomeExpand.sendKeys("[Tab]");
			
			profileCompanyExpand.click();
			
		
			
			if(profileCompanyOpenCompany.isDisplayed())
			{
				System.out.println("Pass : Company Menu has Open Company");
				
				profileCompanyExpand.sendKeys("[Tab]");
				
				if(profileCompanyNewCompany.isDisplayed())
				{
					System.out.println("Pass : Profile Company has New Company Menu");
					
					profileCompanyNewCompany.click();
					
					if(profileCompanyCreateCompany.isDisplayed())
					{
						System.out.println("Pass : Profile Company has New Company Menu");
						
						profileCompanyCreateCompany.click();
						
						
					}
					else
					{
						System.out.println("Pass : Profile Company has no New Company");
					}
					
				}
				else
				{
					System.out.println("Pass : Profile Company has no New Company");
				}
			}
			else
			{
				System.out.println("Pass : Company Menu has no Open Company");
			}
			
			
			
			
			
			
		}*/
		
		
		
	
	public HomeMenuSecurityCreateProfilePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	  
		
}
