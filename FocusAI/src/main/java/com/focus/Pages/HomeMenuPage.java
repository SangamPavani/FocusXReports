package com.focus.Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.focus.base.BaseEngine;


public class HomeMenuPage extends BaseEngine
{

	private static String getPatchDateTime;
	
	//Home Menu
	@FindBy (xpath="//*[@id='1']/div/span")
    private static WebElement homeMenu;
	
	    //Company Menu
		@FindBy (xpath="//*[@id='2']/span")
	    private static WebElement companyMenu;
		
			@FindBy (xpath="//*[@id='129']/span")
		    private static WebElement openCompany;
			  
			   @FindBy (xpath="//*[@id='id_login_div']/div[5]/button[1]")
			   private static WebElement cancelInLoginScreenOfOpenCompany;
			   
			   @FindBy (xpath="//*[@id='login_div']/div[1]/div[2]/ul/li[1]/a/i")
			   private static WebElement createCompanyScreenOfOpenCompany;	    
			   
			@FindBy (xpath="//*[@id='3']/span")
		    private static WebElement newCompanyMenu;
		
			   @FindBy (xpath="//*[@id='130']/span")
			   private static WebElement createCompany;
			   
			      @FindBy (xpath="//*[@id='page_Content']/form/div/div[1]/nav/div/div[1]/a/div/span[2]")
			      private static WebElement CreateCompanyTitle;
			      
			      @FindBy (xpath="//*[@id='btn_common_header']/div[2]/div[1]/span")
			      private static WebElement cancelButtonInCreateCompany;
			      
			      @FindBy (xpath="//*[@id='company_Languages']/div[3]/label")
			      private static WebElement chkBoxPersianLanguage;			      
			      
			      @FindBy (xpath="//*[@id='btnUpdateLanguage']/div[1]/span")
			      private static WebElement btnUpdateLanguage;
			      
			@FindBy (xpath="//*[@id='107']/span")
			private static WebElement editCompany;
			  
				 @FindBy (xpath="//*[@id='CompanyName']")
				 private static WebElement getCompanyNameTextInEditScreen;
				 
				 @FindBy (xpath="//*[@id='CreatedDate']")
				 private static WebElement companyDateInEditCompany;
				 
				 @FindBy(xpath="//*[@id='btn_common_header']/div[2]/div[1]/span")
				 private static WebElement okButtonInEditCompanyScreen;
				 
				 @FindBy(xpath="//*[@id='btn_common_header']/div[3]/div[1]")
				 private static WebElement cancelButtonInEditCompanyScreen;
				 
				
			@FindBy (xpath="//*[@id='131']/span")
			private static WebElement yearEndProcess;

			   @FindBy (xpath="//*[@id='87']/span")
			   private static WebElement closeCompany;

			   @FindBy (xpath="//*[@id='146']/span")
			   private static WebElement updateCogs;
			
			
			@FindBy (xpath="//*[@id='125']/span")
			private static WebElement ineterCompanyTransactions;
			
			   @FindBy (xpath="//*[@id='103']/span")
			   private static WebElement interCompanySettings;

			   @FindBy (xpath="//*[@id='29']/span")
			   private static WebElement mappings;
			   
			   @FindBy (xpath="//*[@id='30']/span")
			   private static WebElement inboxAndOutbox;

			   @FindBy (xpath="//*[@id='126']/span")
			   private static WebElement oflineImport;
			   
		//Security Menu	
		@FindBy (xpath="//*[@id='6']/span")
	    private static WebElement securityMenu;
		
			@FindBy (xpath="//*[@id='7']/span")
			private static WebElement networkPolicy;
			
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
		
		//Masters Menu	
		@FindBy (xpath="//*[@id='1000']/span")
	    private static WebElement mastersMenu;
		
			@FindBy (xpath="//*[@id='1104']/span")
			private static WebElement accounts;
	
			@FindBy (xpath="//*[@id='220']/span")
			private static WebElement currency;
	
				@FindBy (xpath="//*[@id='70']/span")
				private static WebElement currencyMaster;
		
				@FindBy (xpath="//*[@id='71']/span")
				private static WebElement exchangeRate;
		
				@FindBy (xpath="//*[@id='233']/span")
				private static WebElement exchangeRateHistory;
	
			@FindBy (xpath="//*[@id='221']/span")
			private static WebElement products;
	
				@FindBy (xpath="//*[@id='1105']/span")
				private static WebElement productsMaster;
		
				@FindBy (xpath="//*[@id='1114']/span")
				private static WebElement units;
		
				@FindBy (xpath="//*[@id='72']/span")
				private static WebElement unitsConversion;
		
				@FindBy (xpath="//*[@id='76']/span")
				private static WebElement sellerPriceBook;
		
				@FindBy (xpath="//*[@id='80']/span")
				private static WebElement buyerPriceBook;
		
				@FindBy (xpath="//*[@id='18']/span")
				private static WebElement barcodeDefinition;
	
			@FindBy (xpath="//*[@id='224']/span")
			private static WebElement mrp;
			
				@FindBy (xpath="//*[@id='1116']/span")
				private static WebElement plant;
		
				@FindBy (xpath="//*[@id='1117']/span")
				private static WebElement supplyArea;
		
				@FindBy (xpath="//*[@id='1118']/span")
				private static WebElement maintainanceParameter;
		
				@FindBy (xpath="//*[@id='1119']/span")
				private static WebElement safetyInstructions;
		
				@FindBy (xpath="//*[@id='1120']/span")
				private static WebElement capacity;
		
				@FindBy (xpath="//*[@id='1121']/span")
				private static WebElement workCenter;
		
				@FindBy (xpath="//*[@id='1122']/span")
				private static WebElement holiday;
		
				@FindBy (xpath="//*[@id='1162']/span")
				private static WebElement process;
				
			@FindBy (xpath="//*[@id='225']/span")
			private static WebElement qc;
	
				@FindBy (xpath="//*[@id='1123']/span")
				private static WebElement qzFailureReason;
		
				@FindBy (xpath="//*[@id='1163']/span")
				private static WebElement qcParameters;
	
			@FindBy (xpath="//*[@id='251']/span")
			private static WebElement maintainance;
	
				@FindBy (xpath="//*[@id='1164']/span")
				private static WebElement breakDownStandardReason;
		
			@FindBy (xpath="//*[@id='8001']/span")
			private static WebElement pointOfSale;
	
				@FindBy (xpath="//*[@id='8005']/span")
				private static WebElement member;
		
					@FindBy (xpath="//*[@id='8009']/span")
					private static WebElement memberCardRegistration;
			
					@FindBy (xpath="//*[@id='1148']/span")
					private static WebElement memberType;
			
					@FindBy (xpath="//*[@id='1152']/span")
					private static WebElement memberMaster;
			
					@FindBy (xpath="//*[@id='1159']/span")
					private static WebElement memberCardDefinition;
	
	
				@FindBy (xpath="//*[@id='8006']/span")
				private static WebElement giftVoucher;
		
					@FindBy (xpath="//*[@id='8011']/span")
					private static WebElement giftVoucherRegistration;
			
					@FindBy (xpath="//*[@id='1149']/span")
					private static WebElement giftVoucherDefinition;
		
				
				@FindBy (xpath="//*[@id='8035']/span")
				private static WebElement discountVoucher;
		
					@FindBy (xpath="//*[@id='8034']/span")
					private static WebElement discountVoucherRegistration;
			
					@FindBy (xpath="//*[@id='1153']/span")
					private static WebElement discountVoucherDefinition;
		
	
				@FindBy (xpath="//*[@id='1025']/span")
				private static WebElement tableManagement;
		
					@FindBy (xpath="//*[@id='1154']/span")
					private static WebElement floor;
			
					@FindBy (xpath="//*[@id='1155']/span")
					private static WebElement section;
			
					@FindBy (xpath="//*[@id='1156']/span")
					private static WebElement table;
			
					@FindBy (xpath="//*[@id='1157']/span")
					private static WebElement guest;
			
					@FindBy (xpath="//*[@id='1158']/span")
					private static WebElement voidRemarks;

				@FindBy (xpath="//*[@id='1146']/span")
				private static WebElement outlet;
					
				@FindBy (xpath="//*[@id='1147']/span")
				private static WebElement counter;
			
				@FindBy (xpath="//*[@id='1150']/span")
				private static WebElement category;
			
				@FindBy (xpath="//*[@id='1151']/span")
				private static WebElement bankCardType;
					
				@FindBy (xpath="//*[@id='1160']/span")
				private static WebElement returnRemarks;
			
				@FindBy (xpath="//*[@id='1167']/span")
				private static WebElement kitchenDisplaySystem;
			
				@FindBy (xpath="//*[@id='1168']/span")
				private static WebElement deliveryTimeInterval;
					
				@FindBy (xpath="//*[@id='1169']/span")
				private static WebElement epayment;
			
			
			@FindBy (xpath="//*[@id='1103']/span")
			private static WebElement payroll;
	
				@FindBy (xpath="//*[@id='1128']/span")
				private static WebElement employeeMaster;
		
				@FindBy (xpath="//*[@id='1130']/span")
				private static WebElement postionMaster;
		
				@FindBy (xpath="//*[@id='1131']/span")
				private static WebElement qualification;
		
				@FindBy (xpath="//*[@id='1132']/span")
				private static WebElement specialization;
		
				@FindBy (xpath="//*[@id='1133']/span")
				private static WebElement nationality;
		
				@FindBy (xpath="//*[@id='1134']/span")
				private static WebElement skillType;
		
				@FindBy (xpath="//*[@id='1135']/span")
				private static WebElement skill;
		
				@FindBy (xpath="//*[@id='1136']/span")
				private static WebElement sourceType;
		
				@FindBy (xpath="//*[@id='1137']/span")
				private static WebElement sourceMaster;
		
				@FindBy (xpath="//*[@id='1138']/span")
				private static WebElement roundTypeMaster;
		
				@FindBy (xpath="//*[@id='1139']/span")
				private static WebElement gradeMaster;
				
				@FindBy (xpath="//*[@id='1140']/span")
				private static WebElement scaleMaster;
				
				@FindBy (xpath="//*[@id='1141']/span")
				private static WebElement courseType;
				
				@FindBy (xpath="//*[@id='1165']/span")
				private static WebElement Trainer;
				
				@FindBy (xpath="//*[@id='1166']/span")
				private static WebElement airlineSector;


			@FindBy (xpath="//*[@id='1106']/span")
			private static WebElement departments;
	
			@FindBy (xpath="//*[@id='1107']/span")
			private static WebElement warehouse;
	
			@FindBy (xpath="//*[@id='1108']/span")
			private static WebElement costcenter;
	
			@FindBy (xpath="//*[@id='1109']/span")
			private static WebElement location;
	
			@FindBy (xpath="//*[@id='1110']/span")
			private static WebElement region;
	
			@FindBy (xpath="//*[@id='1111']/span")
			private static WebElement country;
	
			@FindBy (xpath="//*[@id='1112']/span")
			private static WebElement state;
	
			@FindBy (xpath="//*[@id='1113']/span")
			private static WebElement city;
	
			@FindBy (xpath="//*[@id='1115']/span")
			private static WebElement bins;
	
			@FindBy (xpath="//*[@id='1126']/span")
			private static WebElement insurance;
	
			@FindBy (xpath="//*[@id='1127']/span")
			private static WebElement fixedassets;
			
			@FindBy (xpath="//*[@id='1161']/span")
			private static WebElement taxCode;

		
	    //DataManagement menu
		@FindBy (xpath="//*[@id='25']/span")
	    private static WebElement dataMangementMenu;
		
			@FindBy (xpath="//*[@id='26']/span")
			private static WebElement backup;
				
			@FindBy (xpath="//*[@id='27']/span")
			private static WebElement restore;
			
			@FindBy (xpath="//*[@id='111']/span")
			private static WebElement reindex;
			
			@FindBy (xpath="//*[@id='115']/span")
			private static WebElement eraseAll;
			
			@FindBy (xpath="//*[@id='216']/span")
			private static WebElement lockAndUnlock;
		
	    //Utilities Menu		
		@FindBy (xpath="//*[@id='20']/span")
	    private static WebElement utilities;
		
			@FindBy (xpath="//*[@id='21']/span")
		    private static WebElement calendar;
			
			@FindBy (xpath="//*[@id='22']/span")
		    private static WebElement reportDesigner;
		
			@FindBy (xpath="//*[@id='23']/span")
		    private static WebElement scheduleReport;
			
			@FindBy (xpath="//*[@id='112']/span")
		    private static WebElement renumberVouchers;
			
			@FindBy (xpath="//*[@id='114']/span")
		    private static WebElement repostVouchers;

			@FindBy (xpath="//*[@id='122']/span")
		    private static WebElement adjustForeginExchange;
			
			@FindBy (xpath="//*[@id='128']/span")
		    private static WebElement transactionImport;
			
			@FindBy (xpath="//*[@id='106']/span")
		    private static WebElement dataStatistics;
					
			@FindBy (xpath="//*[@id='149']/span")
		    private static WebElement ediGeneration;
			
			@FindBy (xpath="//*[@id='160']/span")
		    private static WebElement standardRate;
			
			@FindBy (xpath="//*[@id='647']/span")
		    private static WebElement authorizationDetails;
			
			@FindBy (xpath="//*[@id='259']/span")
		    private static WebElement regroup;
			
			@FindBy (xpath="//*[@id='3319']/span")
		    private static WebElement releaseReveration;
			
			
			
			
			public static boolean verifyHomeMenu() throws InterruptedException
			{
			
				if (homeMenu.isDisplayed()==true)
				{
					
					return true;
				}
				else
				{
					return false;
				}
					
			}
			
			
			public static boolean VerifyHomeMenuSubMenus() throws InterruptedException
			{
			   		
				homeMenu.click();
				
				if(companyMenu.isDisplayed())
				{
					System.out.println("pass : companyMenu");
					if(securityMenu.isDisplayed())
					{
						System.out.println("pass : securityMenu");
						if(mastersMenu.isDisplayed())
						{
							System.out.println("pass : mastersMenu");
							if(dataMangementMenu.isDisplayed())
							{
								System.out.println("pass : dataMangementMenu");
								if( utilities.isDisplayed())
								{
									System.out.println("pass : utilities");
									return true;
								}
								else
								{
									System.out.println("Fail : utilities");
									return false;
								}
							}
							else
							{
								System.out.println("Fail : dataMangementMenu");
								return false;
							}
						}
						else
						{
							System.out.println("Fail : mastersMenu");
							return false;
							
						}
					}
					else
					{
						System.out.println("Fail : securityMenu");
						return false;
						
					}
				}
				else
				{
					System.out.println("Fail : companyMenu");
					return false;
					
				}

				
			}
			
			
			public boolean verifyCompanySubMenus()
			{
				
                getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				homeMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(companyMenu));
				
				companyMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(openCompany));
				
				   if(openCompany.isDisplayed())
				   {
					System.out.println("Pass Open Company");
					
					 if(newCompanyMenu.isDisplayed())
				     {
					  System.out.println("Pass newCompanyMenu");
								 
						if(editCompany.isDisplayed())
					    {
						System.out.println("Pass editCompany");
											
							if(yearEndProcess.isDisplayed())
						    {
							System.out.println("Pass yearEndProcess");
							
							   if(ineterCompanyTransactions.isDisplayed())
							   {
							   System.out.println("Pass ineterCompanyTransactions");
							   return true;
							   }
							   else
							   {
								 System.out.println("Fail ineterCompanyTransactions");
								 return false;
							   }
						     }
							 else
							 {
								System.out.println("Fail yearEndProcess");
								return false;
							 }
						    }
							else
							 {
								System.out.println("Fail editCompany");
								return false;
							 }
				           }
						 else
						 {
							System.out.println("Fail newCompanyMenu");
							return false;
						 }
				       }
				     else
					 {
						System.out.println("Fail Open company");
						return false;
					 }
		          
				   
				}
				
				
			
			
			public boolean verifySecuritySubMenus()
			{
				
                getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				homeMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(securityMenu));
				
				securityMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(networkPolicy));
				
				        if(networkPolicy.isDisplayed())
						  {
					         System.out.println("Pass Networkpolicy");
					         
					         if(passwordPolicy.isDisplayed())
					         {
					        	 System.out.println("Pass Passwordpolicy");
					        	 
					        	 if(createProfile.isDisplayed())
					        	 {
					        		 System.out.println("Pass createProfile");
					        		 
					        		 if(createRole.isDisplayed())
					        		 {
					        			 System.out.println("Pass createRole");
					        			 
					        			 if(createUser.isDisplayed())
					        			 {
					        				 System.out.println("Pass createuser");
					        				 
					        				 if(changePassword.isDisplayed())
						        			 {
						        				 System.out.println("Pass changePassowrd");
						        				 
						        				 if(usageLog.isDisplayed())
						        				 {
						        					 System.out.println("Pass usaeLog");
						        					 
						        					 if(userRightsReport.isDisplayed())
						        					 {
						        						 System.out.println("Pass userRightsReport");
						        						 
						        						 if(roleRightsReport.isDisplayed())
						        						 {
						        							 System.out.println("Pass roleRightsReport");
						        							 
						        							 if(profileRightsReport.isDisplayed())
							        						 {
							        							 System.out.println("Pass ProfileRightsReport");
							        							 return true;
							        						 }
						        							 else
						        							 {
						        								 System.out.println("Fail ProfileRightsReport");
						        								 return false;
						        							 }
						        						 }
						        						 else
						        						 {
						        							 System.out.println("Fail roleRightsReport");
					        								 return false;
						        						 }
						        					 }
						        					 else
						        					 {
						        						 System.out.println("Fail userRightsReport");
				        								 return false;
						        					 }
						        				 }
						        				 else
						        				 {
						        					 System.out.println("Fail usaeLog");
			        								 return false;
						        				 }
						        			 }
					        				 else
					        				 {
					        					 System.out.println("Fail changePassowrd");
		        								 return false;
					        				 }
					        			 }
					        			 else
					        			 {
					        				 System.out.println("Fail createuser");
	        								 return false;
					        			 }
					        		 }
					        		 else
					        		 {
					        			 System.out.println("Fail createRole");
        								 return false;
					        		 }
					        	 }
					        	 else
					        	 {
					        		 System.out.println("Fail createProfile");
    								 return false;
					        	 }
					         }
					         else
				        	 {
				        		 System.out.println("Fail Passwordpolicy");
								 return false;
				        	 }
						  }
				         else
			        	 {
			        		 System.out.println("Fail Networkpolicy");
							 return false;
			        	 }
					   	

			}
			
			
			
			public boolean verifyMastersSubMenus()
			{
				    getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
					
					homeMenu.click();
					
					getWebDriverWait().until(ExpectedConditions.elementToBeClickable(mastersMenu));
					
					mastersMenu.click();
					
					getWebDriverWait().until(ExpectedConditions.elementToBeClickable(accounts));
					
					  
					if(accounts.isDisplayed())
					{
						System.out.println("Pass Accounts");
						
						 if(currency.isDisplayed())
						 {
							 System.out.println("Pass Currency");
							 
							 if(products.isDisplayed())
							 {
								 System.out.println("Pass Products");
								  
								 if(mrp.isDisplayed())
								   {
								     System.out.println("Pass mrp");
								     
									 if(qc.isDisplayed())
								     {
									     System.out.println("Pass qc");
								
									     if(maintainance.isDisplayed())
										  {
										     System.out.println("Pass maintainance");

										     if(pointOfSale.isDisplayed())
											 {
											     System.out.println("Pass pointOfSale");
											     
											     if(payroll.isDisplayed())
												 {
												     System.out.println("Pass payroll");
												  
												     if(costcenter.isDisplayed())
													 {
													     System.out.println("Pass costcenter");
													    
													     if(location.isDisplayed())
														 {
														     System.out.println("Pass location");
														     
														     if(region.isDisplayed())
															 {
															     System.out.println("Pass region");

															     if(country.isDisplayed())
																 {
																     System.out.println("Pass country");
													
																     if(state.isDisplayed())
																	 {
																	     System.out.println("Pass state");
																	     
																	     if(city.isDisplayed())
																		 {																			 System.out.println("Pass insurance");
																		 System.out.println("Pass city");
																	     
																		 if(bins.isDisplayed())
																		 {
																			 System.out.println("Pass bins");
																			 
																			 if(insurance.isDisplayed())
																			 {
																				 System.out.println("Pass insurance");
																				 
																				 if(fixedassets.isDisplayed())
																				 {
																					 System.out.println("Pass fixedassets");
																				     if(taxCode.isDisplayed())
																					 {
																						 System.out.println("Pass taxcode");
																						 return true;
																					 }
																				     else
																				     {
																				    	 System.out.println("Fail taxcode");
																						 return false;
																				     }
																				    }
																					else
																					{
																						System.out.println("Fail fixedAssets");
																						return false;
																				    }
																				   }
																				 else
																				 {
																					 System.out.println("Fail Insurance");
																					 return false;
																				 }
																			 }
																			 else
																			 {
																				 System.out.println("Fail Bins");
																				 return false;
																			 }
																		 }
																		 else
																		 {
																			 System.out.println("Fail city");
																			 return false;
																		 }
																	  }
																	  else
																	  {
																		System.out.println("Fail State");
																		return false;
																	  }
																	}
																	else
																	{
																	 System.out.println("Fail Counytry");
																		return false;
																	 }
															       } 
															     else
																 {
																	System.out.println("Fail region");
																	return false;
																 }
														       }
															  else
															  {
																System.out.println("Fail location");
																return false;
															   }
													        }
													     else
														 {
															System.out.println("Fail costcenter");
															return false;
														 }
												       }
												     else
													 {
														System.out.println("Fail payrol");
														return false;
													 }
											      }
											     else
												 {
													System.out.println("Fail pointofsale");
													return false;
												 }
										     }
									     else
										 {
											System.out.println("Fail maintiance");
											return false;
										 }
								     }
									 else
									 {
										System.out.println("Fail qc");
										return false;
									 }
								   }
								 else
								 {
									System.out.println("Fail mrp");
									return false;
								 }
							 }

						 else
						 {
							System.out.println("Fail product");
							return false;
						 }
					}
					else
					 {
						System.out.println("Fail currency");
						return false;
					 }
			      }
			     else
				 {
					System.out.println("Fail Accounts");
					return false;
				 }
									     												     
		    }
			
			


			public boolean verifyDataManagementSubMenus()
			{
				
                getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				homeMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(dataMangementMenu));
				
				dataMangementMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(backup));
				
				   if(backup.isDisplayed())
				   {
					System.out.println("Pass backup");
					
					 if(restore.isDisplayed())
				     {
					  System.out.println("Pass restore");
								 
						if(reindex.isDisplayed())
					    {
						System.out.println("Pass reindex");
						
							if(eraseAll.isDisplayed())
						    {
							System.out.println("Pass eraseAll");
													
								if(lockAndUnlock.isDisplayed())
							    {
								System.out.println("Pass lockAndUnlock");
								return true;
							    }
								else
								{
								  System.out.println("Fail lockAndUnlock");
								   return false;
								   }
							     }
								 else
								 {
									System.out.println("Fail eraseAll");
									return false;
								 }
							    }
								else
								 {
									System.out.println("Fail reindex");
									return false;
								 }
					           }
							 else
							 {
								System.out.println("Fail restore");
								return false;
							 }
				           }
						 else
						 {
							System.out.println("Fail backup");
							return false;
						 }

				}

			
			public boolean verifyUtilitiesSubMenu()
			{
				
                getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				homeMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(utilities));
				
				utilities.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(calendar));
				
				   if(calendar.isDisplayed())
				   {
					System.out.println("Pass calendar");
					
					 if(reportDesigner.isDisplayed())
				     {
					  System.out.println("Pass reportDesigner");
								 
						if(scheduleReport.isDisplayed())
					    {
						System.out.println("Pass scheduleReport");
						
							if(renumberVouchers.isDisplayed())
						    {
							System.out.println("Pass renumberVouchers");
													
								if(repostVouchers.isDisplayed())
							    {
								System.out.println("Pass repostVouchers");
								
									if(adjustForeginExchange.isDisplayed())
								    {
									System.out.println("Pass adjustForeginExchange");
									
										if(transactionImport.isDisplayed())
									    {
										System.out.println("Pass transactionImport");
										
											if(dataStatistics.isDisplayed())
										    {
											System.out.println("Pass dataStatistics");
									
												if(ediGeneration.isDisplayed())
											    {
												System.out.println("Pass ediGeneration");
												
														if(standardRate.isDisplayed())
													    {
														System.out.println("Pass standardRate");
														
															if(authorizationDetails.isDisplayed())
														    {
															System.out.println("Pass authorizationDetails");
															
																if(regroup.isDisplayed())
															    {
																System.out.println("Pass regroup");
																
																	if(releaseReveration.isDisplayed())
																    {
																	System.out.println("Pass releaseReveration");
																	return true;
																    }
																	else
																	{
																	  System.out.println("Fail releaseReveration");
																	   return false;
																	   }
																     }
																else
																{
																  System.out.println("Fail regroup");
																   return false;
																   }
															     }
															else
															{
															  System.out.println("Fail authorizationDetails");
															   return false;
															   }
														     }
														else
														{
														  System.out.println("Fail standardRate");
														   return false;
														   }
													     }
											
													else
													{
													  System.out.println("Fail edigenegration");
													   return false;
													   }
												     }
								
												else
												{
												  System.out.println("Fail dataStatistics");
												   return false;
												   }
											     }
									
												else
												{
												  System.out.println("Fail transactionImport");
												   return false;
												   }
											     }
										
											else
											{
											  System.out.println("Fail adjustForeginExchange");
											   return false;
											   }
										     }
										else
										{
										  System.out.println("Fail repostVouchers");
										   return false;
										   }
									     }
									 else
									 {
										System.out.println("Fail renumberVouchers");
										return false;
									 }
								    }
								else
								 {
									System.out.println("Fail scheduleReport");
									return false;
								 }
					           }
							 else
							 {
								System.out.println("Fail reportDesigner");
								return false;
							 }
				           }
						 else
						 {
							System.out.println("Fail Calender");
							return false;
						 }

				}

			
			public static boolean verifyNewCompanyOptionCreateCompany()
			{
				
		          getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				  homeMenu.click();
						
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(companyMenu));
						
				  companyMenu.click();
						
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(newCompanyMenu));
				  
				  newCompanyMenu.click();
				  
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(createCompany));
				  
				  if(createCompany.isDisplayed())
				  {
					  System.out.println("pass createCompany");
					  return true;
				  }
				  else
				  {
					  System.out.println("Fail createCompany");
					  return false;
				  }
				  
				
			}
			
			
			
			public static boolean verifyYearEndProcess()
			{
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				  homeMenu.click();
						
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(companyMenu));
						
				  companyMenu.click();
				
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(yearEndProcess));
					
				  yearEndProcess.click();
				
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(closeCompany));
				 
				  
				  if(closeCompany.isDisplayed())
				  {
					  System.out.println("pass closeCompany");
					  
					  if(updateCogs.isDisplayed())
					  {
						  System.out.println("pass updateCogs");
						  return true;
					  }
					  else
					  {
						  System.out.println("Fail updateCogs");
						  return false;
					  }  
				  }
				  else
				  {
					  System.out.println("Fail closeCompany");
					  return false;
				  }	 	  
			}
			
			
			
			public static boolean verifyInterCompanyMenuOptions()
			{
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				  homeMenu.click();
						
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(companyMenu));
					
				  companyMenu.click();
				  
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(ineterCompanyTransactions));
					
				  ineterCompanyTransactions.click();

				
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(interCompanySettings));
				 
				  
				  if(interCompanySettings.isDisplayed())
				  {
					  System.out.println("pass interCompanySettings");
					  
					  if(mappings.isDisplayed())
					  {
						  System.out.println("pass mappings");
						  
						  if(inboxAndOutbox.isDisplayed())
						  {
							  System.out.println("pass inboxAndOutbox");
							  
							  if(oflineImport.isDisplayed())
							  {
								  System.out.println("pass oflineImport");
								  return true;
							  }
							  else
							  {
								  System.out.println("Fail oflineImport");
								  return false;
							  }  
						  }

						  else
						  {
							  System.out.println("Fail inboxAndOutbox");
							  return false;
						  }  
					  }

					  else
					  {
						  System.out.println("Fail mappings");
						  return false;
					  }  
				  }
				  else
				  {
					  System.out.println("Fail interCompanySettings");
					  return false;
				  }	 	  
			}
			
			
			
			public static boolean verifyCurrencySubMenus()
			{
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				  homeMenu.click();
						
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(mastersMenu));
					
				  mastersMenu.click();
				  
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(currency));
					
				  currency.click();

				
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(currencyMaster));
				 
				  
				  if(currencyMaster.isDisplayed())
				  {
					  System.out.println("pass currencyMaster");
					  
					  if(exchangeRate.isDisplayed())
					  {
						  System.out.println("pass exchangeRate");
						  
						  if(exchangeRateHistory.isDisplayed())
						  {
							  System.out.println("pass exchangeRateHistory");
				
								  return true;
							  }
							  else
							  {
								  System.out.println("Fail exchangeRateHistory");
								  return false;
							  }  
						  }

						  else
						  {
							  System.out.println("Fail exchangeRate");
							  return false;
						  }  
					  }

					  else
					  {
						  System.out.println("Fail currencyMaster");
						  return false;
					  }  
				  }

			
			
			
			public static boolean verifyProductSubMenu()
			{
				
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				  homeMenu.click();
						
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(mastersMenu));
					
				  mastersMenu.click();
				  
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(products));
					
				  products.click();

				
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(productsMaster));
				 
				  
				  if(productsMaster.isDisplayed())
				  {
					  System.out.println("pass productsMaster");
					  
					  if(units.isDisplayed())
					  {
						  System.out.println("pass units");
						  
						  if(unitsConversion.isDisplayed())
						  {
							  System.out.println("pass unitsConversion");
				
							  if(sellerPriceBook.isDisplayed())
							  {
								  System.out.println("pass sellerPriceBook");
					
								  if(buyerPriceBook.isDisplayed())
								  {
									  System.out.println("pass buyerPriceBook");
						
									  if(barcodeDefinition.isDisplayed())
									  {
										  System.out.println("pass barcodeDefinition");
							
											  return true;
										  }
										  else
										  {
											  System.out.println("Fail barcodeDefinition");
											  return false;
										  }  
									  }

									  else
									  {
										  System.out.println("Fail buyerPriceBook");
										  return false;
									  }  
								  }

								  else
								  {
									  System.out.println("Fail sellerPriceBook");
									  return false;
								  }  
							  }
		
							  else
							  {
								  System.out.println("Fail unitsConversion");
								  return false;
							  }  
						  }

						  else
						  {
							  System.out.println("Fail units");
							  return false;
						  }  
					  }

					  else
					  {
						  System.out.println("Fail productsMaster");
						  return false;
					  }  
				  }

			
			public static boolean verifyMRPSubMenu()
			{
				
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				  homeMenu.click();
						
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(mastersMenu));
					
				  mastersMenu.click();
				  
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(mrp));
					
				  mrp.click();

				
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(plant));
				 
				  
				  if(plant.isDisplayed())
				  {
					  System.out.println("pass plant");
					  
					  if(supplyArea.isDisplayed())
					  {
						  System.out.println("pass supplyArea");
						  
						  if(maintainanceParameter.isDisplayed())
						  {
							  System.out.println("pass maintainanceParameter");
				
							  if(safetyInstructions.isDisplayed())
							  {
								  System.out.println("pass safetyInstructions");
					
								  if(capacity.isDisplayed())
								  {
									  System.out.println("pass capacity");
						
									  if(workCenter.isDisplayed())
									  {
										  System.out.println("pass workCenter");
							
										  if(holiday.isDisplayed())
										  {
											  System.out.println("pass holiday");
								              
					  
											  
											  if(process.isDisplayed())
											  {
												  System.out.println("pass process");
									
													  return true;
												  }
												  else
												  {
													  System.out.println("Fail process");
													  return false;
												  }  
											  }

											  else
											  {
												  System.out.println("Fail holiday");
												  return false;
											  }  
										  }
										  else
										  {
											  System.out.println("Fail workCenter");
											  return false;
										  }  
									  }

									  else
									  {
										  System.out.println("Fail capacity");
										  return false;
									  }  
								  }

								  else
								  {
									  System.out.println("Fail safetyInstructions");
									  return false;
								  }  
							  }
		
							  else
							  {
								  System.out.println("Fail maintainanceParameter");
								  return false;
							  }  
						  }

						  else
						  {
							  System.out.println("Fail supplyArea");
							  return false;
						  }  
					  }

					  else
					  {
						  System.out.println("Fail plant");
						  return false;
					  }  
				  }
			
			
			
			
			public static boolean verifyQCSubMenus()
			{
				
		          getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				  homeMenu.click();
						
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(mastersMenu));
					
				  mastersMenu.click();
						
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(qc));
				  
				  qc.click();
				  
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(qzFailureReason));
				  
				  if(qzFailureReason.isDisplayed())
				  {
					  System.out.println("pass qzFailureReason");
					  
					  if(qcParameters.isDisplayed())
					  {
						  System.out.println("pass qcParameters");
						  return true;
					  }
					  else
					  {
						  System.out.println("Fail qcParameters");
						  return false;
					  }
				  }
				  else
				  {
					  System.out.println("Fail qzFailureReason");
					  return false;
				  }
				  
				
			}
			
			
			public static boolean verifyMaintainanceSubMenus()
			{
				
		          getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				  homeMenu.click();
						
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(mastersMenu));
					
				  mastersMenu.click();
						
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(maintainance));
				  
				  maintainance.click();
				  
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(breakDownStandardReason));
				  
				  if(breakDownStandardReason.isDisplayed())
				  {
					  System.out.println("pass breakDownStandardReason");
					  
						  return true;
				   }
				  else
				  {
					  System.out.println("Fail breakDownStandardReason");
					  return false;
				  }
				  
				
			}
			
			public static boolean verifyPointOfSaleSubMenus()
			{
				
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				  homeMenu.click();
						
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(mastersMenu));
					
				  mastersMenu.click();
				  
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(pointOfSale));
					
				  pointOfSale.click();

				
				  getWebDriverWait().until(ExpectedConditions.elementToBeClickable(member));
				 
				  
				  if(member.isDisplayed())
				  {
					  System.out.println("pass member");
					  
					  if(giftVoucher.isDisplayed())
					  {
						  System.out.println("pass giftVoucher");

							  if(discountVoucher.isDisplayed())
							  {
								  System.out.println("pass discountVoucher");
					
								  if(tableManagement.isDisplayed())
								  {
									  System.out.println("pass tableManagement");
						
									  if(outlet.isDisplayed())
									  {
										  System.out.println("pass outlet");
							
										  if(counter.isDisplayed())
										  {
											  System.out.println("pass counter");
								              
											  if(category.isDisplayed())
											  {
												  System.out.println("pass category");
									
												  if(bankCardType.isDisplayed())
												  {
													  System.out.println("pass bankCardType");
										
													  if(returnRemarks.isDisplayed())
													  {
														  System.out.println("pass returnRemarks");
											
														  if(kitchenDisplaySystem.isDisplayed())
														  {
															  System.out.println("pass kitchenDisplaySystem");
												
															  if(deliveryTimeInterval.isDisplayed())
															  {
																  System.out.println("pass deliveryTimeInterval");
													
																  if(epayment.isDisplayed())
																  {
																	  System.out.println("pass epayment");
														
																		  return true;
																	  }
																	  else
																	  {
																		  System.out.println("Fail category");
																		  return false;
																	  }
																  }
																  else
																  {
																	  System.out.println("Fail category");
																	  return false;
																  }
															  }
															  else
															  {
																  System.out.println("Fail category");
																  return false;
															  }
														  }
														  else
														  {
															  System.out.println("Fail category");
															  return false;
														  }
													  }
													  else
													  {
														  System.out.println("Fail category");
														  return false;
													  }
												  }
												  else
												  {
													  System.out.println("Fail category");
													  return false;
												  }  
											  }

											  else
											  {
												  System.out.println("Fail counter");
												  return false;
											  }  
										  }
										  else
										  {
											  System.out.println("Fail outlet");
											  return false;
										  }  
									  }

									  else
									  {
										  System.out.println("Fail tableManagement");
										  return false;
									  }  
								  }

								  else
								  {
									  System.out.println("Fail discountVoucher");
									  return false;
								  }  
							  }

						  else
						  {
							  System.out.println("Fail giftVoucher");
							  return false;
						  }  
					  }

					  else
					  {
						  System.out.println("Fail Member");
						  return false;
					  }  
				  }
			
			
			
	
			public boolean verifyPayrollSubMenus()
			{
				    getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
					
					homeMenu.click();
					
					getWebDriverWait().until(ExpectedConditions.elementToBeClickable(mastersMenu));
					
					mastersMenu.click();
					
					getWebDriverWait().until(ExpectedConditions.elementToBeClickable(payroll));
					
					payroll.click();
					
					getWebDriverWait().until(ExpectedConditions.elementToBeClickable(employeeMaster));
					  
					if(employeeMaster.isDisplayed())
					{
						System.out.println("Pass employeeMaster");
						
						 if(postionMaster.isDisplayed())
						 {
							 System.out.println("Pass postionMaster");
							 
							 if(qualification.isDisplayed())
							 {
								 System.out.println("Pass qualification");
								  
								 if(specialization.isDisplayed())
								   {
								     System.out.println("Pass specialization");
								     
									 if(nationality.isDisplayed())
								     {
									     System.out.println("Pass nationality");
								
									     if(skillType.isDisplayed())
										  {
										     System.out.println("Pass skillType");

										     if(skill.isDisplayed())
											 {
											     System.out.println("Pass skill");
											     
											     if(sourceType.isDisplayed())
												 {
												     System.out.println("Pass sourceType");
												  
												     if(sourceMaster.isDisplayed())
													 {
													     System.out.println("Pass sourceMaster");
													    
													     if(roundTypeMaster.isDisplayed())
														 {
														     System.out.println("Pass roundTypeMaster");
														     
														     if(gradeMaster.isDisplayed())
															 {
															     System.out.println("Pass gradeMaster");

															     if(scaleMaster.isDisplayed())
																 {
																     System.out.println("Pass scaleMaster");
													
																     if(courseType.isDisplayed())
																	 {
																	     System.out.println("Pass courseType");
																	     
																	     if(Trainer.isDisplayed())
																		 {																			 System.out.println("Pass insurance");
																		 System.out.println("Pass Trainer");
																	     
																				 if(airlineSector.isDisplayed())
																				 {
																					 System.out.println("Pass airlineSector");
																					 return true;
																				  }
																				 else
																				 {
																					 System.out.println("Fail airlineSector");
																					 return false;
																				 }
																			 }
																			 else
																			 {
																				 System.out.println("Fail Trainer");
																				 return false;
																			 }
																		 }
																		 else
																		 {
																			 System.out.println("Fail courseType");
																			 return false;
																		 }
																	  }
																	  else
																	  {
																		System.out.println("Fail scaleMaster");
																		return false;
																	  }
																	}
																	else
																	{
																	 System.out.println("Fail gradeMaster");
																		return false;
																	 }
															       } 
															     else
																 {
																	System.out.println("Fail roundTypeMaster");
																	return false;
																 }
														       }

													     else
														 {
															System.out.println("Fail sourceMaster");
															return false;
														 }
												       }
												     else
													 {
														System.out.println("Fail sourceType");
														return false;
													 }
											      }
											     else
												 {
													System.out.println("Fail skill");
													return false;
												 }
										     }
									     else
										 {
											System.out.println("Fail skillType");
											return false;
										 }
								     }
									 else
									 {
										System.out.println("Fail nationality");
										return false;
									 }
								   }
								 else
								 {
									System.out.println("Fail specialization");
									return false;
								 }
							 }

						 else
						 {
							System.out.println("Fail qualification");
							return false;
						 }
					}
					else
					 {
						System.out.println("Fail postionMaster");
						return false;
					 }
			      }
			     else
				 {
					System.out.println("Fail employeeMaster");
					return false;
				 }
									     												     
		    }
			
			
			
			
			
			
			
			
			
			//Opening the Screens
			
	        public void openOpenCompany() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	        {
                getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				homeMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(companyMenu));
				
				companyMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(openCompany));
				
				openCompany.click();
				

				
	        	
	        }
			
	        
	        public void verifyCancelOptionInOpenCompany()
	        {
	        	getWebDriverWait().until(ExpectedConditions.visibilityOf(cancelInLoginScreenOfOpenCompany));
	        	cancelInLoginScreenOfOpenCompany.click();
	        	
	        }
	        
	        
	        
			
			
			
			
			public void openCreateCompanyScreen()
			{
				getWebDriverWait().until(ExpectedConditions.visibilityOf(createCompany));
				createCompany.click();
				
			}
			
			
			
			public void openCreateCompanyFromOpenCompany()
			{
				getWebDriverWait().until(ExpectedConditions.visibilityOf(createCompanyScreenOfOpenCompany));
				createCompanyScreenOfOpenCompany.click();
			}
			
			
			
			
			public boolean getCompanyTitleAsCreateCompany()
			{
				
				getWebDriverWait().until(ExpectedConditions.visibilityOf(createCompany));
				createCompany.click();
				
				
				
				if(CreateCompanyTitle.getText().equalsIgnoreCase("Create Company"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
			
			
			
			public void clickonCancelButtonInCreateCompany()
			{
				getWebDriverWait().until(ExpectedConditions.visibilityOf(cancelButtonInCreateCompany));
				
				
				cancelButtonInCreateCompany.click();
			
				
				
			}
			
			
			
		
			//Edit Company
			public boolean clickOnEditCompany()
			{
                getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				homeMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(companyMenu));
				
				companyMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.visibilityOf(editCompany));
				
				editCompany.click();
				
				if(CreateCompanyTitle.getText().equalsIgnoreCase("Edit Company"))
				{
					return true;
				}
				else
				{
					return false;
				}
				
			}
			
			
			//Get The Company Name when user click on Edit Company
			public String getCompanyNameTextFromEditCompany()
			{
				getWebDriverWait().until(ExpectedConditions.visibilityOf(getCompanyNameTextInEditScreen));
				String getCompanyNameText=getCompanyNameTextInEditScreen.getText();
				return getCompanyNameText;
			}
			
			

			
			//In Edit Screen update the Company name
		    public void editCompanyScreenUpdateTheCompanyName() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		    {
		    	
		    	WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		    	getPatchDateTime=wlp.getReleasedate();
		    	
		    	
		    	wlp.clickOnAboutToClose();
		        
		    	getWebDriverWait().until(ExpectedConditions.visibilityOf(getCompanyNameTextInEditScreen));
		    	getCompanyNameTextInEditScreen.sendKeys(getPatchDateTime);
		    	
		    	getAction().moveToElement(getCompanyNameTextInEditScreen).sendKeys(Keys.TAB).perform();
		    	companyDateInEditCompany.sendKeys("0101");
		    	//wlp.clickOnAboutToClose();
		    	
		    	getWebDriverWait().until(ExpectedConditions.visibilityOf(okButtonInEditCompanyScreen));
		    	
		    	okButtonInEditCompanyScreen.click();
		    	

		    }
		    
		    
		    public void clickOnCancelInEditScreen()
		    {
		    	 getWebDriverWait().until(ExpectedConditions.visibilityOf(cancelButtonInEditCompanyScreen));
				 cancelButtonInEditCompanyScreen.click();
		    }
		    
		    
		    
		    
		    //Verify Alert Company Updating
		    public void checkUpdateTheCompanyAlert()
		    {
				
				
				 String getExpectedCompMsg="Company updated successfully";
							     
				 CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
			
			     cco.waitForAlert();
			     
			     String actCompanySaveMsg=cco.getAlert().getText();
			     
			     System.out.println("getExpectedCompMsg"+getExpectedCompMsg);
			     System.out.println("actCompanySaveMsg"+actCompanySaveMsg);
			     
			     Assert.assertEquals(actCompanySaveMsg,getExpectedCompMsg);
			
			     cco.getAlert().accept();
			     
			    getWebDriverWait().until(ExpectedConditions.visibilityOf(cancelButtonInEditCompanyScreen));
			    cancelButtonInEditCompanyScreen.click();
			    
			    
			    
		    }
		    
			
		    
		    public static void clickOnCloseTheEditCompany()
		    {
		     	getWebDriverWait().until(ExpectedConditions.visibilityOf(cancelButtonInEditCompanyScreen));
		    	cancelButtonInEditCompanyScreen.click();
		    }
		    
		    
		    public static String getCompanyNameChanges() throws InterruptedException
		    {
		    	WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		    	HomeMenuPage hmp=new HomeMenuPage(getDriver());
		    	
		        wlp.checkAboutIdQuickAccessMenu();
		    
		        wlp.clickOnAbout();
		    	
		    	String getPatchDateTime=wlp.getReleasedate();
		    	
				String getUpdatedCompanyDate=companyDateInEditCompany.getText();
				
				//String companyName="Automation Company"+ getPatchDateTime;
				
		    	wlp.clickOnAboutToClose();
		    	
		    	return getUpdatedCompanyDate;
		    	
		    }
		    
		    
		    
		   
		    //Check Edit Company Name and Date Modified
		    public String openEditCompanyScreenAfterSavingTheChanges() throws InterruptedException
		    {
		    	
		    
		    	
		    	
                getWebDriverWait().until(ExpectedConditions.elementToBeClickable(homeMenu));
				
				homeMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.elementToBeClickable(companyMenu));
				
				companyMenu.click();
				
				getWebDriverWait().until(ExpectedConditions.visibilityOf(editCompany));
				
				editCompany.click();
				
				getWebDriverWait().until(ExpectedConditions.visibilityOf(getCompanyNameTextInEditScreen));
				
				getCompanyNameTextInEditScreen.click();
				
				String getUpdatedCompany=getCompanyNameTextInEditScreen.getAttribute("value");

		     	//getWebDriverWait().until(ExpectedConditions.visibilityOf(cancelButtonInEditCompanyScreen));
		     	
		    	//cancelButtonInEditCompanyScreen.click();
		    	
		    	return getUpdatedCompany;
		    	
		    	
		    }
		    
		    
		    
		    
		    public boolean checkPatchDateAgainForComparsion() throws InterruptedException
		    {
		    
		    	WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		    	HomeMenuPage hmp=new HomeMenuPage(getDriver());
		    	
		        wlp.checkAboutIdQuickAccessMenu();
		    	
		  
		    	wlp.clickOnAbout();
		    	
		    	//String getPatchDateTime=wlp.getReleasedate();
		    	
				//String getUpdatedCompanyDate=companyDateInEditCompany.getText();
				String companyName="Automation Company"+ getPatchDateTime;
				
				String ChangeCompanyName=hmp.openEditCompanyScreenAfterSavingTheChanges();
				
				wlp.clickOnAboutToClose();
				
				System.out.println("the company name One "+ChangeCompanyName);
				
				System.out.println("the company name Two"+companyName);

				if(ChangeCompanyName.equalsIgnoreCase(companyName))
				{
					return true;
				}
				else
				{
					return false;
				}
				
				
		    }
		    
		    
		    	
		    
		    public void clickOnSaveAndUpdateLanguage()
		    {
		    	
		    	
		    	    getWebDriverWait().until(ExpectedConditions.visibilityOf(chkBoxPersianLanguage));
		    	
					chkBoxPersianLanguage.click();

			     	getWebDriverWait().until(ExpectedConditions.visibilityOf(btnUpdateLanguage));
			     	
			     	btnUpdateLanguage.click();
			     	  	
		    }
		    
		    
		    
		    //Verify Alert Company Updating
		    public void checkUpdateLanguageAlert()
		    {
						
				 String getExpectedCompMsg="Languages Updated Successfully";
							     
				 CreateCompanyLoginPage cco=new CreateCompanyLoginPage(getDriver());
			
			     cco.waitForAlert();
			     
			     String actCompanySaveMsg=cco.getAlert().getText();
			     
			     System.out.println("getExpectedCompMsg"+getExpectedCompMsg);
			     
			     System.out.println("actCompanySaveMsg"+actCompanySaveMsg);
			     
			     Assert.assertEquals(actCompanySaveMsg,getExpectedCompMsg);
			
			     cco.getAlert().accept();
			     
			     getWebDriverWait().until(ExpectedConditions.visibilityOf(cancelButtonInEditCompanyScreen));
			    
			     cancelButtonInEditCompanyScreen.click();
			    
			   
		    }
		    
		    
		    
		    
		    public static void clickOnLogoutLoginCompanyUpdate()
		    {
		    	 LoginPage lp=new LoginPage(getDriver());
			    	
			     lp.clickOnLogoutWithOptions();
			    	
			     lp.clickOnSignIn(); 
			    	
		    }
		    
		    
		    
		    
		    

		    
		        //To check the Patch date again after logout and login the company
			    public String clickAboutToGetPatchDate() throws InterruptedException
			    {
			    	
			    
			    	WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
			    	
			    	Assert.assertEquals(wlp.checkAboutIdQuickAccessMenu(), true);
			    	
			    	Assert.assertEquals(wlp.clickOnAbout(), true);
			        	
			    	String patchForCompanyUpdateLogoutLogin=wlp.getReleasedate();
			    	
			    	return patchForCompanyUpdateLogoutLogin;
			    	
			    }
			    
			    
			    public boolean getPatchAfterCompanyUpdateLogoutLogin() throws InterruptedException
		        {
		           	boolean avbFields=false;
		           	
		            HomeMenuPage hmp=new HomeMenuPage(getDriver());
		        
		        	String getgetPatchDateTime=hmp.clickAboutToGetPatchDate();
		        	
		            System.out.println("getgetPatchDateTime"+getgetPatchDateTime);
		        	
		        	String getCompanyNamePatch="Automation Company"+getgetPatchDateTime+" ";
		        	
		        	
		        	System.out.println("getCompanyNamePatch**********getCompanyNamePatch"+getCompanyNamePatch);
		        	
		        	WrapperLayoutPage wlp=new WrapperLayoutPage(getDriver());
		        	
		        	String getCompanyNameFromCompanyLogo=wlp.getCompanyNameUserClickOnCompanyLogo();
		        	
		        	if (getCompanyNamePatch.equalsIgnoreCase(getCompanyNameFromCompanyLogo))
		        	{
		        		return true;
		        	}
		        	
		        	else
		        	{
		        		return false;
		        	}
		        	
		  
		        	
		        }
			    
		
			    
			    
			    
		    
		    
		    
			
		    //Check the Title
		    public boolean editCompanyTitle()
		    {
				if(CreateCompanyTitle.getText().equalsIgnoreCase("Edit Company"))
				{
					return true;
				}
				else
				{
					return false;
				}
		    }
		    
		    
			   
		    public HomeMenuPage(WebDriver driver)
		    {
		    	
		    	PageFactory.initElements(driver, this);
		    	
		    }
			
     }


