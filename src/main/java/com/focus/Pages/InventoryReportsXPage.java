package com.focus.Pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.impl.conn.LoggingSessionOutputBuffer;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.focus.base.BaseEngine;
import com.focus.supporters.ExcelReader;
import com.focus.utilities.POJOUtility;

public class InventoryReportsXPage extends BaseEngine
{
	private static String resPass="Pass";
    private static String resFail="Fail";
    private static ExcelReader excelReader;
    private static String xlfile=getBaseDir()+"\\src\\main\\resources\\testdata\\FocusTestData.xlsx";
    private static String xlSheetName = "Focus10InventoryReportsPage";
    
    
	@FindBy(xpath="//*[text()='SU']")
    private static WebElement userNameDisplay;
    
	public static String checkValidationMessage(String ExpMessage) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
	        try
	        {
	                getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(errorMessage));
	                String actErrorMessage=errorMessage.getText();
	                String expErrorMessage=ExpMessage;

	                try
	                {
	                
		                getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(errorMessageCloseBtn));
		                errorMessageCloseBtn.click();
	                	
		                System.out.println("ValidationMessage  :  "+actErrorMessage +" Value Expected : "+expErrorMessage);
		                
		                return actErrorMessage;
	                }
	                catch(Exception ee)
	                {
	                	
	                	System.out.println("ValidationMessage  :  "+actErrorMessage +" Value Expected : "+expErrorMessage);
	                	
	                	return actErrorMessage;
	                }
	        }
	        catch(Exception e)
	        {
	                System.err.println("Error Message NOT Found or NOT Clickable");
	                System.err.println(e.getMessage());
	                
	                String Exception=e.getMessage();
	            
	                return Exception;
	        }
	}
	

	public boolean checkLoginTOAutomationCompany() throws InterruptedException
	{

		 getDriver().navigate().refresh();
		 Thread.sleep(1999);
		 
		// getDriver().navigate().refresh();
		 //Thread.sleep(1999);

		LoginPage lp=new LoginPage(getDriver()); 

		String unamelt="su";
				      
		String pawslt="su";
				      
		LoginPage.enterUserName(unamelt);

		Thread.sleep(1000);
				
		LoginPage.enterPassword(pawslt);

		String compname="Automation Company : 08/10/2020(020)";

		 Select oSelect = new Select(companyDropDownList);
		 oSelect.selectByValue("36");
		 
		/* List <WebElement> elementCount = oSelect.getOptions();

		 int cqSize = elementCount.size();
		 
		 System.out.println("CompanyDropdownList Count :"+cqSize);

		    int i;
		  
			for(i=0; i<elementCount.size(); i++) 
			{
			
			  elementCount.get(i).getText();
			  
		      String optionName = elementCount.get(i).getText();
		      
		     if(optionName.toUpperCase().startsWith(compname.toUpperCase()))
		     {
			  System.out.println("q"+elementCount.get(i).getText());
				  elementCount.get(i).click();
			 }
		 
		    }*/
			
	        Thread.sleep(1000);
			
			LoginPage.clickOnSignInBtn();
				
			//checkRefershPopOnlogin();
			        
		//checkPopUpWindow();

		//Thread.sleep(2000);
				           	
		String userInfo=userNameDisplay.getText();
				    	
		System.out.println("User Info : "+userInfo);
				    	
		System.out.println("User Info Capture Text :"+userNameDisplay.getText());
				    	
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(companyLogo));
				    	
		companyLogo.click();
				    	
		if(homeMenu.isDisplayed()==true)
		{

			System.out.println("Test Pass :Logined to Automation Company");
			return true;
			
		}
		else
		{
			System.out.println("Test Fail :Logined to BRS Company");
				return false;

			}
		
	}
	
	
	@FindBy(xpath="//*[@id='135']")
	public static WebElement inventoryMenu;
	
	@FindBy(xpath="//*[@id='200']")
	public static WebElement inventoryReportsMenu;
	
	@FindBy(xpath="//*[@id='202']")
	public static WebElement itemQuery;
	
	@FindBy(xpath="//*[@id='productQuery']")
	public static WebElement iq_ItemTxt;
	
	@FindBy(xpath="//*[@id='dv_Panelbody']/div[1]/div[2]/div/input")
	public static WebElement iq_getStockBtn;
	
	@FindBy(xpath="//*[@id='openingStock']")
	private static WebElement iq_OpeningStocks;
	
	@FindBy(xpath="//*[@id='currentStock']")
	private static WebElement iq_CurrentStock;
	
	@FindBy(xpath="//*[@id='avgStockRate']")
	private static WebElement iq_AvgStockRate;
	
	@FindBy(xpath="//*[@id='value']")
	private static WebElement iq_Value;
	
	@FindBy(xpath="//*[@id='iBaseUnit']")
	private static WebElement iq_BaseUnit;
	
	@FindBy(xpath="//*[@id='purchaseOrdered']")
	private static WebElement iq_PendingPurchaseOrders;
	
	@FindBy(xpath="//*[@id='salesOrdered']")
	private static WebElement iq_PendingSalesOrders;
	
	@FindBy(xpath="//*[@id='quantityToBeOrdered']")
	private static WebElement iq_QtyToBeOrdered;
	
	@FindBy(xpath="//*[@id='Alternatequantity']")
	private static WebElement iq_AlternateQuantity;
	
	// Purchase Table
	
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[1]/td[1]")
			private static WebElement pur1strow_1stColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[1]/td[2]")
			private static WebElement pur1strow_2ndColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[1]/td[3]")
			private static WebElement pur1strow_3rdColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[1]/td[4]")
			private static WebElement pur1strow_4thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[1]/td[5]")
			private static WebElement pur1strow_5thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[1]/td[6]")
			private static WebElement pur1strow_6thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[1]/td[7]")
			private static WebElement pur1strow_7thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[1]/td[8]")
			private static WebElement pur1strow_8thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[1]/td[9]")
			private static WebElement pur1strow_9thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[1]/td[10]")
			private static WebElement pur1strow_10thColumn;
			
			
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[2]/td[1]")
			private static WebElement pur2ndrow_1stColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[2]/td[2]")
			private static WebElement pur2ndrow_2ndColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[2]/td[3]")
			private static WebElement pur2ndrow_3rdColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[2]/td[4]")
			private static WebElement pur2ndrow_4thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[2]/td[5]")
			private static WebElement pur2ndrow_5thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[2]/td[6]")
			private static WebElement pur2ndrow_6thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[2]/td[7]")
			private static WebElement pur2ndrow_7thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[2]/td[8]")
			private static WebElement pur2ndrow_8thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[2]/td[9]")
			private static WebElement pur2ndrow_9thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[2]/td[10]")
			private static WebElement pur2ndrow_10thColumn;
			
			
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[3]/td[1]")
			private static WebElement pur7thRow_1stColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[3]/td[2]")
			private static WebElement pur3rdrow_2ndColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[3]/td[3]")
			private static WebElement pur3rdrow_3rdColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[3]/td[4]")
			private static WebElement pur3rdrow_4thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[3]/td[5]")
			private static WebElement pur3rdrow_5thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[3]/td[6]")
			private static WebElement pur3rdrow_6thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[3]/td[7]")
			private static WebElement pur3rdrow_7thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[3]/td[8]")
			private static WebElement pur3rdrow_8thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[3]/td[9]")
			private static WebElement pur3rdrow_9thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[3]/td[10]")
			private static WebElement pur3rdrow_10thColumn;
			
			
			// 4TH
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[4]/td[1]")
			private static WebElement pur4throw_1stColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[4]/td[2]")
			private static WebElement pur4throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[4]/td[3]")
			private static WebElement pur4throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[4]/td[4]")
			private static WebElement pur4throw_4thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[4]/td[5]")
			private static WebElement pur4throw_5thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[4]/td[6]")
			private static WebElement pur4throw_6thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[4]/td[7]")
			private static WebElement pur4throw_7thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[4]/td[8]")
			private static WebElement pur4throw_8thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[4]/td[9]")
			private static WebElement pur4throw_9thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[4]/td[10]")
			private static WebElement pur4throw_10thColumn;
			
			// 5TH
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[5]/td[1]")
			private static WebElement pur5throw_1stColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[5]/td[2]")
			private static WebElement pur5throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[5]/td[3]")
			private static WebElement pur5throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[5]/td[4]")
			private static WebElement pur5throw_4thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[5]/td[5]")
			private static WebElement pur5throw_5thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[5]/td[6]")
			private static WebElement pur5throw_6thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[5]/td[7]")
			private static WebElement pur5throw_7thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[5]/td[8]")
			private static WebElement pur5throw_8thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[5]/td[9]")
			private static WebElement pur5throw_9thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[5]/td[10]")
			private static WebElement pur5throw_10thColumn;
			
			// 6TH
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[6]/td[1]")
			private static WebElement pur6throw_1stColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[6]/td[2]")
			private static WebElement pur6throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[6]/td[3]")
			private static WebElement pur6throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[6]/td[4]")
			private static WebElement pur6throw_4thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[6]/td[5]")
			private static WebElement pur6throw_5thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[6]/td[6]")
			private static WebElement pur6throw_6thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[6]/td[7]")
			private static WebElement pur6throw_7thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[6]/td[8]")
			private static WebElement pur6throw_8thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[6]/td[9]")
			private static WebElement pur6throw_9thColumn;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[6]/td[10]")
			private static WebElement pur6throw_10thColumn;
			
			
			@FindBy(xpath="//td[contains(text(),'Quantity Purchased Till Date:')]")
			private static WebElement qtyPurchasedTillDate;
			
			@FindBy(xpath="//*[@id='purchaseTable']/tbody/tr[3]/td[2]")
			private static WebElement purTotalWa;
					
					
			// Sales Table
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[1]/td[1]")
			private static WebElement sal1strow_1stColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[1]/td[2]")
			private static WebElement sal1strow_2ndColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[1]/td[3]")
			private static WebElement sal1strow_3rdColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[1]/td[4]")
			private static WebElement sal1strow_4thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[1]/td[5]")
			private static WebElement sal1strow_5thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[1]/td[6]")
			private static WebElement sal1strow_6thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[1]/td[7]")
			private static WebElement sal1strow_7thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[1]/td[8]")
			private static WebElement sal1strow_8thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[1]/td[9]")
			private static WebElement sal1strow_9thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[1]/td[10]")
			private static WebElement sal1strow_10thColumn;
			
			// 2nd
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[2]/td[1]")
			private static WebElement sal2ndrow_1stColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[2]/td[2]")
			private static WebElement sal2ndrow_2ndColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[2]/td[3]")
			private static WebElement sal2ndrow_3rdColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[2]/td[4]")
			private static WebElement sal2ndrow_4thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[2]/td[5]")
			private static WebElement sal2ndrow_5thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[2]/td[6]")
			private static WebElement sal2ndrow_6thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[2]/td[7]")
			private static WebElement sal2ndrow_7thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[2]/td[8]")
			private static WebElement sal2ndrow_8thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[2]/td[9]")
			private static WebElement sal2ndrow_9thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[2]/td[10]")
			private static WebElement sal2ndrow_10thColumn;
			
			// 3rd
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[3]/td[1]")
			private static WebElement sal3rdrow_1stColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[3]/td[2]")
			private static WebElement sal3rdrow_2ndColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[3]/td[3]")
			private static WebElement sal3rdrow_3rdColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[3]/td[4]")
			private static WebElement sal3rdrow_4thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[3]/td[5]")
			private static WebElement sal3rdrow_5thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[3]/td[6]")
			private static WebElement sal3rdrow_6thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[3]/td[7]")
			private static WebElement sal3rdrow_7thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[3]/td[8]")
			private static WebElement sal3rdrow_8thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[3]/td[9]")
			private static WebElement sal3rdrow_9thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[3]/td[10]")
			private static WebElement sal3rdrow_10thColumn;
			
			// 4th
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[4]/td[1]")
			private static WebElement sal4throw_1stColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[4]/td[2]")
			private static WebElement sal4throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[4]/td[3]")
			private static WebElement sal4throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[4]/td[4]")
			private static WebElement sal4throw_4thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[4]/td[5]")
			private static WebElement sal4throw_5thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[4]/td[6]")
			private static WebElement sal4throw_6thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[4]/td[7]")
			private static WebElement sal4throw_7thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[4]/td[8]")
			private static WebElement sal4throw_8thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[4]/td[9]")
			private static WebElement sal4throw_9thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[4]/td[10]")
			private static WebElement sal4throw_10thColumn;
			
			//5th
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[5]/td[1]")
			private static WebElement sal5throw_1stColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[5]/td[2]")
			private static WebElement sal5throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[5]/td[3]")
			private static WebElement sal5throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[5]/td[4]")
			private static WebElement sal5throw_4thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[5]/td[5]")
			private static WebElement sal5throw_5thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[5]/td[6]")
			private static WebElement sal5throw_6thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[5]/td[7]")
			private static WebElement sal5throw_7thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[5]/td[8]")
			private static WebElement sal5throw_8thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[5]/td[9]")
			private static WebElement sal5throw_9thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[5]/td[10]")
			private static WebElement sal5throw_10thColumn;
			
			//6th
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[6]/td[1]")
			private static WebElement sal6throw_1stColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[6]/td[2]")
			private static WebElement sal6throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[6]/td[3]")
			private static WebElement sal6throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[6]/td[4]")
			private static WebElement sal6throw_4thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[6]/td[5]")
			private static WebElement sal6throw_5thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[6]/td[6]")
			private static WebElement sal6throw_6thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[6]/td[7]")
			private static WebElement sal6throw_7thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[6]/td[8]")
			private static WebElement sal6throw_8thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[6]/td[9]")
			private static WebElement sal6throw_9thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[6]/td[10]")
			private static WebElement sal6throw_10thColumn;
			
			// 7th
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[7]/td[1]")
			private static WebElement sal7throw_1stColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[7]/td[2]")
			private static WebElement sal7throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[7]/td[3]")
			private static WebElement sal7throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[7]/td[4]")
			private static WebElement sal7throw_4thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[7]/td[5]")
			private static WebElement sal7throw_5thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[7]/td[6]")
			private static WebElement sal7throw_6thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[7]/td[7]")
			private static WebElement sal7throw_7thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[7]/td[8]")
			private static WebElement sal7throw_8thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[7]/td[9]")
			private static WebElement sal7throw_9thColumn;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[7]/td[10]")
			private static WebElement sal7throw_10thColumn;

			
			@FindBy(xpath="//td[contains(text(),'Quantity Sold Till Date:')]")
			private static WebElement qtySoldTillDate;
			
			@FindBy(xpath="//*[@id='salesTable']/tbody/tr[3]/td[2]")
			private static WebElement salTotalWa;
					
			
			
			// Warehouse Table
			
			@FindBy(xpath="//div[contains(text(),'Warehouse')]")
			private static WebElement BalancebyWareHouselable;
			
		//	@FindBy(xpath="(//*[@id='ProdQuery_ShowPopup'])[1]")
			@FindBy(xpath="//*[@id='panelsStayOpen-headingThree']")
			private static WebElement BalancebyWareHouseExpandBtn;
			
			@FindBy(xpath="//*[@id='tagWiseData']/tbody/tr[1]/td[2]")
			private static WebElement wh1strow_2ndColumn;
			
			@FindBy(xpath="//*[@id='tagWiseData']/tbody/tr[1]/td[3]")
			private static WebElement wh1strow_3rdColumn;
			
			@FindBy(xpath="//*[@id='tagWiseData']/tbody/tr[1]/td[4]")
			private static WebElement wh1strow_4thColumn;
			
			@FindBy(xpath="//*[@id='tagWiseData']/tbody/tr[1]/td[5]")
			private static WebElement wh1strow_5thColumn;
			
			@FindBy(xpath="//*[@id='tagWiseData']/tbody/tr[1]/td[6]")
			private static WebElement wh1strow_6thColumn;
			
			
			
			@FindBy(xpath="//*[@id='tagWiseData']/tbody/tr[2]/td[2]")
			private static WebElement wh2ndrow_2ndColumn;
			
			@FindBy(xpath="//*[@id='tagWiseData']/tbody/tr[2]/td[3]")
			private static WebElement wh2ndrow_3rdColumn;
			
			@FindBy(xpath="//*[@id='tagWiseData']/tbody/tr[2]/td[4]")
			private static WebElement wh2ndrow_4thColumn;
			
			@FindBy(xpath="//*[@id='tagWiseData']/tbody/tr[2]/td[5]")
			private static WebElement wh2ndrow_5thColumn;
			
			@FindBy(xpath="//*[@id='tagWiseData']/tbody/tr[2]/td[6]")
			private static WebElement wh2ndrow_6thColumn;
			
			
			@FindBy(xpath="//*[@id='tagWiseData']/tbody/tr[3]/td[2]")
			private static WebElement whStockTotal;
			
			@FindBy(xpath="//*[@id='tagWiseData']/tbody/tr[3]/td[4]")
			private static WebElement whValueTotal;
			
			
			// Selling rate and buying rates
			
			@FindBy(xpath="//div[contains(text(),'Selling rates and Buying rates')]")
			private static WebElement sellingAndBuyingRateslable;
			
			//@FindBy(xpath="//span[@id='ProdQuery_ShowSellandBuyRatesPopup']")
			@FindBy(xpath="//*[@id='panelsStayOpen-headingFive']")
			private static WebElement sellingAndBuyingRatesExpandBtn;
			
			// 1st 
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[1]/td[2]")
			private static WebElement sbr1strow_2ndColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[1]/td[3]")
			private static WebElement sbr1strow_3rdColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[1]/td[4]")
			private static WebElement sbr1strow_4thColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[1]/td[5]")
			private static WebElement sbr1strow_5thColumn;
			
			// 2nd 
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[2]/td[2]")
			private static WebElement sbr2ndrow_2ndColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[2]/td[3]")
			private static WebElement sbr2ndrow_3rdColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[2]/td[4]")
			private static WebElement sbr2ndrow_4thColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[2]/td[5]")
			private static WebElement sbr2ndrow_5thColumn;
			
			//3rd
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[3]/td[2]")
			private static WebElement sbr3rdrow_2ndColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[3]/td[3]")
			private static WebElement sbr3rdrow_3rdColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[3]/td[4]")
			private static WebElement sbr3rdrow_4thColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[3]/td[5]")
			private static WebElement sbr3rdrow_5thColumn;
			
			// 4th
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[4]/td[2]")
			private static WebElement sbr4throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[4]/td[3]")
			private static WebElement sbr4throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[4]/td[4]")
			private static WebElement sbr4throw_4thColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[4]/td[5]")
			private static WebElement sbr4throw_5thColumn;
			
			
			
			// 5th
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[5]/td[2]")
			private static WebElement sbr5throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[5]/td[3]")
			private static WebElement sbr5throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[5]/td[4]")
			private static WebElement sbr5throw_4thColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[5]/td[5]")
			private static WebElement sbr5throw_5thColumn;
				
				
			// 6th
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[6]/td[2]")
			private static WebElement sbr6throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[6]/td[3]")
			private static WebElement sbr6throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[6]/td[4]")
			private static WebElement sbr6throw_4thColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[6]/td[5]")				
			private static WebElement sbr6throw_5thColumn;
				
			
			
			// 7th

			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[7]/td[2]")
			private static WebElement sbr7throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[7]/td[3]")
			private static WebElement sbr7throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[7]/td[4]")
			private static WebElement sbr7throw_4thColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[7]/td[5]")
			private static WebElement sbr7throw_5thColumn;
				
				
			// 8th
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[8]/td[2]")
			private static WebElement sbr8throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[8]/td[3]")
			private static WebElement sbr8throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[8]/td[4]")
			private static WebElement sbr8throw_4thColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[8]/td[5]")
			private static WebElement sbr8throw_5thColumn;
				
				
			
			// 9th
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[9]/td[2]")
			private static WebElement sbr9throw_2ndColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[9]/td[3]")
			private static WebElement sbr9throw_3rdColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[9]/td[4]")
			private static WebElement sbr9throw_4thColumn;
			
			@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[9]/td[5]")
			private static WebElement sbr9throw_5thColumn;
				
				
			// 10th
			
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[10]/td[2]")
				private static WebElement sbr10throw_2ndColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[10]/td[3]")
				private static WebElement sbr10throw_3rdColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[10]/td[4]")
				private static WebElement sbr10throw_4thColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[10]/td[5]")
				private static WebElement sbr10throw_5thColumn;
				
			// 11th
			
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[11]/td[2]")
				private static WebElement sbr11throw_2ndColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[11]/td[3]")
				private static WebElement sbr11throw_3rdColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[11]/td[4]")
				private static WebElement sbr11throw_4thColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[11]/td[5]")
				private static WebElement sbr11throw_5thColumn;
				
			// 12th
			
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[12]/td[2]")
				private static WebElement sbr12throw_2ndColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[12]/td[3]")
				private static WebElement sbr12throw_3rdColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[12]/td[4]")
				private static WebElement sbr12throw_4thColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[12]/td[5]")
				private static WebElement sbr12throw_5thColumn;
				
			// 13th
			
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[13]/td[2]")
				private static WebElement sbr13throw_2ndColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[13]/td[3]")
				private static WebElement sbr13throw_3rdColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[13]/td[4]")
				private static WebElement sbr13throw_4thColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[13]/td[5]")
				private static WebElement sbr13throw_5thColumn;
			
			// 14th
			
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[14]/td[2]")
				private static WebElement sbr14throw_2ndColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[14]/td[3]")
				private static WebElement sbr14throw_3rdColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[14]/td[4]")
				private static WebElement sbr14throw_4thColumn;
				
				@FindBy(xpath="//*[@id='ratesWiseData']/tbody/tr[14]/td[5]")
				private static WebElement sbr14throw_5thColumn;
	       	
				@FindBy(xpath="//*[@id='navbarSupportedContent2']/ul/li[2]/a")
				private static WebElement iq_CloseBtn;
				
				@FindBy(xpath="//*[@id='navbarSupportedContent2']/ul/li[1]/a")
				private static WebElement iq_ClearBtn;
				
				@FindBy(xpath="//*[@id='panelsStayOpen-headingOne']")
				private static WebElement iq_PurchasesExpBtn;
				
				@FindBy(xpath="//*[@id='panelsStayOpen-headingTwo']")
				private static WebElement iq_SalesExpBtn;
				
				
				
				

	public boolean checkItemQueryReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(itemQuery));
		itemQuery.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(iq_ItemTxt));
		iq_ItemTxt.click();
		iq_ItemTxt.sendKeys("BR COGS ITEM");
		Thread.sleep(2000);
		iq_ItemTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(iq_getStockBtn));
		iq_getStockBtn.click();
		
		Thread.sleep(5000);
		
		String actiq_OpeningStocks				=iq_OpeningStocks.getText();
		String actiq_PendingPurchaseOrders		=iq_PendingPurchaseOrders.getText();
		String actiq_CurrentStock				=iq_CurrentStock.getText();
		String actiq_PendingSalesOrders			=iq_PendingSalesOrders.getText();
		String actiq_AvgStockRate				=iq_AvgStockRate.getText();
		String actiq_QtyToBeOrdered				=iq_QtyToBeOrdered.getText();
		String actiq_Value						=iq_Value.getText();
		String actiq_BaseUnit     				=iq_BaseUnit.getText();
		
		String expiq_OpeningStocks				="36.00";
		String expiq_PendingPurchaseOrders		="0.00";
		String expiq_CurrentStock				="62.00";
		String expiq_PendingSalesOrders			="0.00";
		String expiq_AvgStockRate				="0.69";
		String expiq_QtyToBeOrdered				="0.00";
		String expiq_Value						="42.75";
		String expiq_BaseUnit     				="Pcs";
		
		
		// Recent Stock Transaction -Purchases
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(iq_PurchasesExpBtn));
		iq_PurchasesExpBtn.click();
		Thread.sleep(3000);
		
		String actpurVoucherNoR1	=pur1strow_2ndColumn.getText();
		String actpurVendorR1		=pur1strow_3rdColumn.getText();
		String actpurQtyR1			=pur1strow_4thColumn.getText();
		String actpurUnitR1			=pur1strow_5thColumn.getText();
		String actpurRateR1			=pur1strow_6thColumn.getText();
		String actpurCurrencyR1		=pur1strow_7thColumn.getText();
		String actpurQtyInBaseR1	=pur1strow_8thColumn.getText();
		
		String actpurVoucherNoR2	=pur2ndrow_2ndColumn.getText();
		String actpurVendorR2		=pur2ndrow_3rdColumn.getText();
		String actpurQtyR2			=pur2ndrow_4thColumn.getText();
		String actpurUnitR2			=pur2ndrow_5thColumn.getText();
		String actpurRateR2			=pur2ndrow_6thColumn.getText();
		String actpurCurrencyR2		=pur2ndrow_7thColumn.getText();
		String actpurQtyInBaseR2	=pur2ndrow_8thColumn.getText();
		
		String actpurTotalWa		=purTotalWa.getText();
		
		// Expected
		
		String exppurVoucherNoR1	="NDT57:SU/IND/TEXT2";
		String exppurVendorR1		="Vendor B";
		String exppurQtyR1			="1.00";
		String exppurUnitR1			="Dozs";
		String exppurRateR1			="10.00";
		String exppurCurrencyR1		="Indian Rupees";
		String exppurQtyInBaseR1	="12.0000000000";
		
		String exppurVoucherNoR2	="NDT57:SU/IND/TEXT2";
		String exppurVendorR2		="Vendor B";
		String exppurQtyR2			="2.00";
		String exppurUnitR2			="Dozs";
		String exppurRateR2			="10.00";
		String exppurCurrencyR2		="Indian Rupees";
		String exppurQtyInBaseR2	="24.0000000000";
		
		String exppurTotalWa		="3.00";
		
		getAction().sendKeys(Keys.CONTROL,Keys.END).build().perform();
		
		
		// Recent Stock Transaction -Sales
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(iq_SalesExpBtn));
		iq_SalesExpBtn.click();
		Thread.sleep(2000);
		String actsalVoucherNoR1	=sal1strow_2ndColumn.getText();
		String actsalCustomerR1		=sal1strow_3rdColumn.getText();
		String actsalQtyR1			=sal1strow_4thColumn.getText();
		String actsalUnitR1			=sal1strow_5thColumn.getText();
		String actsalRateR1			=sal1strow_6thColumn.getText();
		String actsalCurrencyR1		=sal1strow_7thColumn.getText();
		String actsalQtyInBaseR1	=sal1strow_8thColumn.getText();
		
		String actsalVoucherNoR2	=sal2ndrow_2ndColumn.getText();
		String actsalCustomerR2		=sal2ndrow_3rdColumn.getText();
		String actsalQtyR2			=sal2ndrow_4thColumn.getText();
		String actsalUnitR2			=sal2ndrow_5thColumn.getText();
		String actsalRateR2			=sal2ndrow_6thColumn.getText();
		String actsalCurrencyR2		=sal2ndrow_7thColumn.getText();
		String actsalQtyInBaseR2	=sal2ndrow_8thColumn.getText();
		
		String actsalTotalWa		=salTotalWa.getText();

		// Expected
		String expsalVoucherNoR1	="NDT50:1";
		String expsalCustomerR1		="Customer A";
		String expsalQtyR1			="10.00";
		String expsalUnitR1			="Pcs";
		String expsalRateR1			="10.00";
		String expsalCurrencyR1		="Indian Rupees";
		String expsalQtyInBaseR1	="10.00000000";
		
		String expsalVoucherNoR2	="NDT50:7";
		String expsalCustomerR2 	="Customer A";
		String expsalQtyR2			="12.00";
		String expsalUnitR2			="Pcs";
		String expsalRateR2			="10.00";
		String expsalCurrencyR2		="Indian Rupees";
		String expsalQtyInBaseR2	="12.00000000";
		
		String expsalTotalWa		="22.00";
		
		
		// WareHouse Table
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BalancebyWareHouseExpandBtn));
		BalancebyWareHouseExpandBtn.click();
		
		Thread.sleep(3000);
		
		getAction().sendKeys(Keys.CONTROL,Keys.END).build().perform();
		
		
		String actwareHouseR1		=wh1strow_2ndColumn.getText();
		String actstockR1			=wh1strow_3rdColumn.getText();
		String actrateR1			=wh1strow_4thColumn.getText();
		String actvalueR1			=wh1strow_5thColumn.getText();
		
		//String acttotalStock		=wh2ndrow_2ndColumn.getText();
		String acttotalValue		=wh2ndrow_4thColumn.getText();
		
		// Expected
		String expwareHouseR1		="HYDERABAD";
		String expstockR1			="62.00";
		String exprateR1			="12.00";
		String expvalueR1			="50.00";
		
		//String exptotalStock		="50.00";
		String exptotalValue		="12.00";
		
		
		
		
		
		// Seller And Buying rates Table
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sellingAndBuyingRatesExpandBtn));
		sellingAndBuyingRatesExpandBtn.click();
		
		Thread.sleep(2000);
		
		getAction().sendKeys(Keys.CONTROL,Keys.END).build().perform();
		
		Thread.sleep(2000);
		
		String actsellingRateR1		=sbr1strow_2ndColumn.getText();
		String actsellingValueR1	=sbr1strow_3rdColumn.getText();
		String actbuyingRateR1		=sbr1strow_4thColumn.getText();
		String actbuyingValueR1		=sbr1strow_5thColumn.getText();
		
		String actsellingRateR2		=sbr2ndrow_2ndColumn.getText();
		String actsellingValueR2	=sbr2ndrow_3rdColumn.getText();
		String actbuyingRateR2		=sbr2ndrow_4thColumn.getText();
		String actbuyingValueR2		=sbr2ndrow_5thColumn.getText();
		
		String actsellingRateR3		=sbr3rdrow_2ndColumn.getText();
		String actsellingValueR3	=sbr3rdrow_3rdColumn.getText();
		String actbuyingRateR3		=sbr3rdrow_4thColumn.getText();
		String actbuyingValueR3		=sbr3rdrow_5thColumn.getText();
		
		String actsellingRateR4		=sbr4throw_2ndColumn.getText();
		String actsellingValueR4	=sbr4throw_3rdColumn.getText();
		String actbuyingRateR4		=sbr4throw_4thColumn.getText();
		String actbuyingValueR4		=sbr4throw_5thColumn.getText();
		
		String actsellingRateR5		=sbr5throw_2ndColumn.getText();
		String actsellingValueR5	=sbr5throw_3rdColumn.getText();
		String actbuyingRateR5		=sbr5throw_4thColumn.getText();
		String actbuyingValueR5		=sbr5throw_5thColumn.getText();
		
		String actsellingRateR6		=sbr6throw_2ndColumn.getText();
		String actsellingValueR6	=sbr6throw_3rdColumn.getText();
		String actbuyingRateR6		=sbr6throw_4thColumn.getText();
		String actbuyingValueR6		=sbr6throw_5thColumn.getText();
		
		String actsellingRateR7		=sbr7throw_2ndColumn.getText();
		String actsellingValueR7	=sbr7throw_3rdColumn.getText();
		String actbuyingRateR7		=sbr7throw_4thColumn.getText();
		String actbuyingValueR7		=sbr7throw_5thColumn.getText();
		
		String actsellingRateR8		=sbr8throw_2ndColumn.getText();
		String actsellingValueR8	=sbr8throw_3rdColumn.getText();
		String actbuyingRateR8		=sbr8throw_4thColumn.getText();
		String actbuyingValueR8		=sbr8throw_5thColumn.getText();
		
		String actsellingRateR9		=sbr9throw_2ndColumn.getText();
		String actsellingValueR9	=sbr9throw_3rdColumn.getText();
		String actbuyingRateR9		=sbr9throw_4thColumn.getText();
		String actbuyingValueR9		=sbr9throw_5thColumn.getText();
		
		String actsellingRateR10	=sbr10throw_2ndColumn.getText();
		String actsellingValueR10	=sbr10throw_3rdColumn.getText();
		String actbuyingRateR10		=sbr10throw_4thColumn.getText();
		String actbuyingValueR10	=sbr10throw_5thColumn.getText();
		
		String actsellingRateR11	=sbr11throw_2ndColumn.getText();
		String actsellingValueR11	=sbr11throw_3rdColumn.getText();
		String actbuyingRateR11		=sbr11throw_4thColumn.getText();
		String actbuyingValueR11	=sbr11throw_5thColumn.getText();
		
		String actsellingRateR12	=sbr12throw_2ndColumn.getText();
		String actsellingValueR12	=sbr12throw_3rdColumn.getText();
		String actbuyingRateR12		=sbr12throw_4thColumn.getText();
		String actbuyingValueR12	=sbr12throw_5thColumn.getText();
		
		String actsellingRateR13	=sbr13throw_2ndColumn.getText();
		String actsellingValueR13	=sbr13throw_3rdColumn.getText();
		String actbuyingRateR13		=sbr13throw_4thColumn.getText();
		String actbuyingValueR13	=sbr13throw_5thColumn.getText();
		
		String actsellingRateR14	=sbr14throw_2ndColumn.getText();
		String actsellingValueR14	=sbr14throw_3rdColumn.getText();
		String actbuyingRateR14		=sbr14throw_4thColumn.getText();
		String actbuyingValueR14	=sbr14throw_5thColumn.getText();
		
		
		// Expected
		
		String expsellingRateR1		="So";
		String expsellingValueR1	="10.00";
		String expbuyingRateR1		="Po";
		String expbuyingValueR1		="9.00";

		String expsellingRateR2		="St";
		String expsellingValueR2	="10.10";
		String expbuyingRateR2		="Pt";
		String expbuyingValueR2		="9.10";
		
		String expsellingRateR3		="Val 3";
		String expsellingValueR3	="10.20";
		String expbuyingRateR3		="Val 3";
		String expbuyingValueR3		="9.20";
		
		String expsellingRateR4		="Val 4";
		String expsellingValueR4	="0.00";
		String expbuyingRateR4		="Val 4";
		String expbuyingValueR4		="0.00";
		
		String expsellingRateR5		="Val 5";
		String expsellingValueR5	="0.00";
		String expbuyingRateR5		="Val 5";
		String expbuyingValueR5		="0.00";
		
		String expsellingRateR6		="Val 6";
		String expsellingValueR6	="0.00";
		String expbuyingRateR6		="Val 6";
		String expbuyingValueR6		="0.00";
		
		String expsellingRateR7		="Val 7";
		String expsellingValueR7	="0.00";
		String expbuyingRateR7		="Val 7";
		String expbuyingValueR7		="0.00";
		
		String expsellingRateR8		="Val 8";
		String expsellingValueR8	="0.00";
		String expbuyingRateR8		="Val 8";
		String expbuyingValueR8		="0.00";

		String expsellingRateR9		="Val 9";
		String expsellingValueR9	="0.00";
		String expbuyingRateR9		="Val 9";
		String expbuyingValueR9		="0.00";
		
		String expsellingRateR10	="Val 10";		String expsellingValueR10	="0.00";
		String expbuyingRateR10		="Val 10";
		String expbuyingValueR10	="0.00";
		
		String expsellingRateR11	="Val 11";
		String expsellingValueR11	="0.00";
		String expbuyingRateR11		="Val 11";
		String expbuyingValueR11	="0.00";
		
		String expsellingRateR12	="Val 12";
		String expsellingValueR12	="0.00";
		String expbuyingRateR12		="Val 12";
		String expbuyingValueR12	="0.00";
		
		String expsellingRateR13	="Val 13";
		String expsellingValueR13	="0.00";
		String expbuyingRateR13		="Val 13";
		String expbuyingValueR13	="0.00";
		
		String expsellingRateR14	="Val 14";
		String expsellingValueR14	="0.00";
		String expbuyingRateR14		="Val 14";
		String expbuyingValueR14	="0.00";
		
		
		System.out.println("************************************checkItemQueryOfBatchWAItem*************************************");
		
		System.out.println("iq_OpeningStocks     		 :   "+actiq_OpeningStocks					+" Value Expected : "+expiq_OpeningStocks);
		System.out.println("iq_PendingPurchaseOrders     :   "+actiq_PendingPurchaseOrders			+" Value Expected : "+expiq_PendingPurchaseOrders);
		System.out.println("iq_CurrentStock     		 :   "+actiq_CurrentStock					+" Value Expected : "+expiq_CurrentStock);
		System.out.println("iq_PendingSalesOrders     	 :   "+actiq_PendingSalesOrders				+" Value Expected : "+expiq_PendingSalesOrders);
		System.out.println("iq_AvgStockRate     		 :   "+actiq_AvgStockRate					+" Value Expected : "+expiq_AvgStockRate);
		System.out.println("iq_QtyToBeOrdered     		 :   "+actiq_QtyToBeOrdered					+" Value Expected : "+expiq_QtyToBeOrdered);
		System.out.println("iq_Value     				 :   "+actiq_Value							+" Value Expected : "+expiq_Value);
		System.out.println("iq_BaseUnit     			 :   "+actiq_BaseUnit						+" Value Expected : "+expiq_BaseUnit);
		
		System.out.println("********************* Purchase ******************");
		
		System.out.println("purVoucherNoR1     			 :   "+actpurVoucherNoR1					+" Value Expected : "+exppurVoucherNoR1);
		System.out.println("purVendorR1     			 :   "+actpurVendorR1						+" Value Expected : "+exppurVendorR1);
		System.out.println("purQtyR1     				 :   "+actpurQtyR1							+" Value Expected : "+exppurQtyR1);
		System.out.println("purUnitR1     				 :   "+actpurUnitR1							+" Value Expected : "+exppurUnitR1);
		System.out.println("purRateR1     				 :   "+actpurRateR1							+" Value Expected : "+exppurRateR1);
		System.out.println("purCurrencyR1     			 :   "+actpurCurrencyR1						+" Value Expected : "+exppurCurrencyR1);
		System.out.println("purQtyInBaseR1     			 :   "+actpurQtyInBaseR1					+" Value Expected : "+exppurQtyInBaseR1);
		
		System.out.println("purVoucherNoR2     			 :   "+actpurVoucherNoR2					+" Value Expected : "+exppurVoucherNoR2);
		System.out.println("purVendorR2     			 :   "+actpurVendorR2						+" Value Expected : "+exppurVendorR2);
		System.out.println("purQtyR2     				 :   "+actpurQtyR2							+" Value Expected : "+exppurQtyR2);
		System.out.println("purUnitR2     				 :   "+actpurUnitR2							+" Value Expected : "+exppurUnitR2);
		System.out.println("purRateR2     				 :   "+actpurRateR2							+" Value Expected : "+exppurRateR2);
		System.out.println("purCurrencyR2     			 :   "+actpurCurrencyR2						+" Value Expected : "+exppurCurrencyR2);
		System.out.println("purQtyInBaseR2     			 :   "+actpurQtyInBaseR2					+" Value Expected : "+exppurQtyInBaseR2);
		
		System.out.println("purTotalWa                   :   "+actpurTotalWa                        +" Value expected : "+exppurTotalWa);
		
		
		
		System.out.println("********************* Sales ******************");
		
		System.out.println("salVoucherNoR1     			 :   "+actsalVoucherNoR1					+" Value Expected : "+expsalVoucherNoR1);
		System.out.println("salCustomerR1     			 :   "+actsalCustomerR1						+" Value Expected : "+expsalCustomerR1);
		System.out.println("salQtyR1     				 :   "+actsalQtyR1							+" Value Expected : "+expsalQtyR1);
		System.out.println("salUnitR1     				 :   "+actsalUnitR1							+" Value Expected : "+expsalUnitR1);
		System.out.println("salRateR1     				 :   "+actsalRateR1							+" Value Expected : "+expsalRateR1);
		System.out.println("salCurrencyR1     			 :   "+actsalCurrencyR1						+" Value Expected : "+expsalCurrencyR1);
		System.out.println("salQtyInBaseR1     			 :   "+actsalQtyInBaseR1					+" Value Expected : "+expsalQtyInBaseR1);
		
		System.out.println("salVoucherNoR2     			 :   "+actsalVoucherNoR2					+" Value Expected : "+expsalVoucherNoR2);
		System.out.println("salCustomerR2     			 :   "+actsalCustomerR2						+" Value Expected : "+expsalCustomerR2);
		System.out.println("salQtyR2     				 :   "+actsalQtyR2							+" Value Expected : "+expsalQtyR2);
		System.out.println("salUnitR2     				 :   "+actsalUnitR2							+" Value Expected : "+expsalUnitR2);
		System.out.println("salRateR2     				 :   "+actsalRateR2							+" Value Expected : "+expsalRateR2);
		System.out.println("salCurrencyR2     			 :   "+actsalCurrencyR2						+" Value Expected : "+expsalCurrencyR2);
		System.out.println("salQtyInBaseR2     			 :   "+actsalQtyInBaseR2					+" Value Expected : "+expsalQtyInBaseR2);
		
		System.out.println("salTotalWa                   :   "+actsalTotalWa                        +" Value expected : "+expsalTotalWa);
		
		
		System.out.println("********************* WareHouse ******************");
		
		System.out.println("wareHouseR1     			 :   "+actwareHouseR1						+" Value Expected : "+expwareHouseR1);
		System.out.println("stockR1     				 :   "+actstockR1							+" Value Expected : "+expstockR1);
		System.out.println("rateR1     				 	 :   "+actrateR1							+" Value Expected : "+exprateR1);
		System.out.println("valueR1     				 :   "+actvalueR1							+" Value Expected : "+expvalueR1);
		/*
		System.out.println("wareHouseR2     			 :   "+actwareHouseR2						+" Value Expected : "+expwareHouseR2);
		System.out.println("stockR2     				 :   "+actstockR2							+" Value Expected : "+expstockR2);
		System.out.println("rateR2     				 	 :   "+actrateR2							+" Value Expected : "+exprateR2);
		System.out.println("valueR2     				 :   "+actvalueR2							+" Value Expected : "+expvalueR2);
		*/
	/*	System.out.println("totalStock     				 :   "+acttotalStock						+" Value Expected : "+exptotalStock);
		System.out.println("totalValue     				 :   "+acttotalValue						+" Value Expected : "+exptotalValue);
		
		*/
		System.out.println("*************************Selling and Buying rates********************");
		
		System.out.println("sellingRateR1     			 :   "+actsellingRateR1						+" Value Expected : "+expsellingRateR1);
		System.out.println("sellingValueR1  			 :   "+actsellingValueR1					+" Value Expected : "+expsellingValueR1);
		System.out.println("buyingRateR1     			 :   "+actbuyingRateR1						+" Value Expected : "+expbuyingRateR1);
		System.out.println("buyingValueR1     			 :   "+actbuyingValueR1						+" Value Expected : "+expbuyingValueR1);
		
		System.out.println("sellingRateR2     			 :   "+actsellingRateR2						+" Value Expected : "+expsellingRateR2);
		System.out.println("sellingValueR2  			 :   "+actsellingValueR2					+" Value Expected : "+expsellingValueR2);
		System.out.println("buyingRateR2     			 :   "+actbuyingRateR2						+" Value Expected : "+expbuyingRateR2);
		System.out.println("buyingValueR2     			 :   "+actbuyingValueR2						+" Value Expected : "+expbuyingValueR2);
		
		System.out.println("sellingRateR3     			 :   "+actsellingRateR3						+" Value Expected : "+expsellingRateR3);
		System.out.println("sellingValueR3  			 :   "+actsellingValueR3					+" Value Expected : "+expsellingValueR3);
		System.out.println("buyingRateR3     			 :   "+actbuyingRateR3						+" Value Expected : "+expbuyingRateR3);
		System.out.println("buyingValueR3     			 :   "+actbuyingValueR3						+" Value Expected : "+expbuyingValueR3);
		
		System.out.println("sellingRateR4     			 :   "+actsellingRateR4						+" Value Expected : "+expsellingRateR4);
		System.out.println("sellingValueR4  			 :   "+actsellingValueR4					+" Value Expected : "+expsellingValueR4);
		System.out.println("buyingRateR4     			 :   "+actbuyingRateR4						+" Value Expected : "+expbuyingRateR4);
		System.out.println("buyingValueR4     			 :   "+actbuyingValueR4						+" Value Expected : "+expbuyingValueR4);
		
		System.out.println("sellingRateR5     			 :   "+actsellingRateR5						+" Value Expected : "+expsellingRateR5);
		System.out.println("sellingValueR5  			 :   "+actsellingValueR5					+" Value Expected : "+expsellingValueR5);
		System.out.println("buyingRateR5     			 :   "+actbuyingRateR5						+" Value Expected : "+expbuyingRateR5);
		System.out.println("buyingValueR5     			 :   "+actbuyingValueR5						+" Value Expected : "+expbuyingValueR5);
		
		System.out.println("sellingRateR6     			 :   "+actsellingRateR6						+" Value Expected : "+expsellingRateR6);
		System.out.println("sellingValueR6  			 :   "+actsellingValueR6					+" Value Expected : "+expsellingValueR6);
		System.out.println("buyingRateR6     			 :   "+actbuyingRateR6						+" Value Expected : "+expbuyingRateR6);
		System.out.println("buyingValueR6     			 :   "+actbuyingValueR6						+" Value Expected : "+expbuyingValueR6);
		
		System.out.println("sellingRateR7     			 :   "+actsellingRateR7						+" Value Expected : "+expsellingRateR7);
		System.out.println("sellingValueR7  			 :   "+actsellingValueR7					+" Value Expected : "+expsellingValueR7);
		System.out.println("buyingRateR7     			 :   "+actbuyingRateR7						+" Value Expected : "+expbuyingRateR7);
		System.out.println("buyingValueR7     			 :   "+actbuyingValueR7						+" Value Expected : "+expbuyingValueR7);
		
		System.out.println("sellingRateR8     			 :   "+actsellingRateR8						+" Value Expected : "+expsellingRateR8);
		System.out.println("sellingValueR8  			 :   "+actsellingValueR8					+" Value Expected : "+expsellingValueR8);
		System.out.println("buyingRateR8     			 :   "+actbuyingRateR8						+" Value Expected : "+expbuyingRateR8);
		System.out.println("buyingValueR8     			 :   "+actbuyingValueR8						+" Value Expected : "+expbuyingValueR8);
		
		System.out.println("sellingRateR9     			 :   "+actsellingRateR9						+" Value Expected : "+expsellingRateR9);
		System.out.println("sellingValueR9  			 :   "+actsellingValueR9					+" Value Expected : "+expsellingValueR9);
		System.out.println("buyingRateR9     			 :   "+actbuyingRateR9						+" Value Expected : "+expbuyingRateR9);
		System.out.println("buyingValueR9     			 :   "+actbuyingValueR9						+" Value Expected : "+expbuyingValueR9);
		
		System.out.println("sellingRateR10     			 :   "+actsellingRateR10					+" Value Expected : "+expsellingRateR10);
		System.out.println("sellingValueR10  			 :   "+actsellingValueR10					+" Value Expected : "+expsellingValueR10);
		System.out.println("buyingRateR10     			 :   "+actbuyingRateR10						+" Value Expected : "+expbuyingRateR10);
		System.out.println("buyingValueR10     			 :   "+actbuyingValueR10					+" Value Expected : "+expbuyingValueR10);
		
		System.out.println("sellingRateR11     			 :   "+actsellingRateR11					+" Value Expected : "+expsellingRateR11);
		System.out.println("sellingValueR11  			 :   "+actsellingValueR11					+" Value Expected : "+expsellingValueR11);
		System.out.println("buyingRateR11     			 :   "+actbuyingRateR11						+" Value Expected : "+expbuyingRateR11);
		System.out.println("buyingValueR11     			 :   "+actbuyingValueR11					+" Value Expected : "+expbuyingValueR11);
		
		System.out.println("sellingRateR12     			 :   "+actsellingRateR12					+" Value Expected : "+expsellingRateR12);
		System.out.println("sellingValueR12  			 :   "+actsellingValueR12					+" Value Expected : "+expsellingValueR12);
		System.out.println("buyingRateR12     			 :   "+actbuyingRateR12						+" Value Expected : "+expbuyingRateR12);
		System.out.println("buyingValueR12     			 :   "+actbuyingValueR12					+" Value Expected : "+expbuyingValueR12);
		
		System.out.println("sellingRateR13     			 :   "+actsellingRateR13					+" Value Expected : "+expsellingRateR13);
		System.out.println("sellingValueR13  			 :   "+actsellingValueR13					+" Value Expected : "+expsellingValueR13);
		System.out.println("buyingRateR13     			 :   "+actbuyingRateR13						+" Value Expected : "+expbuyingRateR13);
		System.out.println("buyingValueR13     			 :   "+actbuyingValueR13					+" Value Expected : "+expbuyingValueR13);
		
		System.out.println("sellingRateR14     			 :   "+actsellingRateR14					+" Value Expected : "+expsellingRateR14);
		System.out.println("sellingValueR14  			 :   "+actsellingValueR14					+" Value Expected : "+expsellingValueR14);
		System.out.println("buyingRateR14     			 :   "+actbuyingRateR14						+" Value Expected : "+expbuyingRateR14);
		System.out.println("buyingValueR14     			 :   "+actbuyingValueR14					+" Value Expected : "+expbuyingValueR14);
		
		if(actiq_OpeningStocks.equalsIgnoreCase(expiq_OpeningStocks) && actiq_PendingPurchaseOrders.equalsIgnoreCase(expiq_PendingPurchaseOrders)
				&& actiq_CurrentStock.equalsIgnoreCase(expiq_CurrentStock) && actiq_PendingSalesOrders.equalsIgnoreCase(expiq_PendingSalesOrders)
				&& actiq_AvgStockRate.equalsIgnoreCase(expiq_AvgStockRate) && actiq_QtyToBeOrdered.equalsIgnoreCase(expiq_QtyToBeOrdered)
				&& actiq_Value.equalsIgnoreCase(expiq_Value) && actiq_BaseUnit.equalsIgnoreCase(expiq_BaseUnit)
				
				&& actpurVoucherNoR1.equalsIgnoreCase(exppurVoucherNoR1) && actpurVendorR1.equalsIgnoreCase(exppurVendorR1) && actpurQtyR1.equalsIgnoreCase(exppurQtyR1)
				&& actpurUnitR1.equalsIgnoreCase(exppurUnitR1) && actpurRateR1.equalsIgnoreCase(exppurRateR1) && actpurCurrencyR1.equalsIgnoreCase(exppurCurrencyR1)
				&& actpurQtyInBaseR1.equalsIgnoreCase(exppurQtyInBaseR1)
				
				&& actpurVoucherNoR2.equalsIgnoreCase(exppurVoucherNoR2) && actpurVendorR2.equalsIgnoreCase(exppurVendorR2) && actpurQtyR2.equalsIgnoreCase(exppurQtyR2)
				&& actpurUnitR2.equalsIgnoreCase(exppurUnitR2) && actpurRateR2.equalsIgnoreCase(exppurRateR2) && actpurCurrencyR2.equalsIgnoreCase(exppurCurrencyR2)
				&& actpurQtyInBaseR2.equalsIgnoreCase(exppurQtyInBaseR2)
				
				&& actpurTotalWa.equalsIgnoreCase(exppurTotalWa)
				
				&& actsalVoucherNoR1.equalsIgnoreCase(expsalVoucherNoR1) && actsalCustomerR1.equalsIgnoreCase(expsalCustomerR1) && actsalQtyR1.equalsIgnoreCase(expsalQtyR1)
				&& actsalUnitR1.equalsIgnoreCase(expsalUnitR1) && actsalRateR1.equalsIgnoreCase(expsalRateR1) && actsalCurrencyR1.equalsIgnoreCase(expsalCurrencyR1)
				&& actsalQtyInBaseR1.equalsIgnoreCase(expsalQtyInBaseR1)
				
				&& actsalVoucherNoR2.equalsIgnoreCase(expsalVoucherNoR2) && actsalCustomerR2.equalsIgnoreCase(expsalCustomerR2) && actsalQtyR2.equalsIgnoreCase(expsalQtyR2)
				&& actsalUnitR2.equalsIgnoreCase(expsalUnitR2) && actsalRateR2.equalsIgnoreCase(expsalRateR2) && actsalCurrencyR2.equalsIgnoreCase(expsalCurrencyR2)
				&& actsalQtyInBaseR2.equalsIgnoreCase(expsalQtyInBaseR2)
				
				&& actsalTotalWa.equalsIgnoreCase(expsalTotalWa)
				
				&& actwareHouseR1.equalsIgnoreCase(expwareHouseR1) && actstockR1.equalsIgnoreCase(expstockR1) 
				&& actrateR1.equalsIgnoreCase(exprateR1) && actvalueR1.equalsIgnoreCase(expvalueR1)
				
				/*&& actwareHouseR2.equalsIgnoreCase(expwareHouseR2) && actstockR2.equalsIgnoreCase(expstockR2) 
				&& actrateR2.equalsIgnoreCase(exprateR2) && actvalueR2.equalsIgnoreCase(expvalueR2)*/
				
				/*&& acttotalStock.equalsIgnoreCase(exptotalStock)*/ && acttotalValue.equalsIgnoreCase(exptotalValue)
				
				&& actsellingRateR1.equalsIgnoreCase(expsellingRateR1) && actsellingValueR1.equalsIgnoreCase(expsellingValueR1)
				&& actbuyingRateR1.equalsIgnoreCase(expbuyingRateR1) && actbuyingValueR1.equalsIgnoreCase(expbuyingValueR1)
				
				&& actsellingRateR2.equalsIgnoreCase(expsellingRateR2) && actsellingValueR2.equalsIgnoreCase(expsellingValueR2)
				&& actbuyingRateR2.equalsIgnoreCase(expbuyingRateR2) && actbuyingValueR2.equalsIgnoreCase(expbuyingValueR2)
				
				&& actsellingRateR3.equalsIgnoreCase(expsellingRateR3) && actsellingValueR3.equalsIgnoreCase(expsellingValueR3)
				&& actbuyingRateR3.equalsIgnoreCase(expbuyingRateR3) && actbuyingValueR3.equalsIgnoreCase(expbuyingValueR3)
				
				&& actsellingRateR4.equalsIgnoreCase(expsellingRateR4) && actsellingValueR4.equalsIgnoreCase(expsellingValueR4)
				&& actbuyingRateR4.equalsIgnoreCase(expbuyingRateR4) && actbuyingValueR4.equalsIgnoreCase(expbuyingValueR4)
				
				&& actsellingRateR5.equalsIgnoreCase(expsellingRateR5) && actsellingValueR4.equalsIgnoreCase(expsellingValueR5)
				&& actbuyingRateR5.equalsIgnoreCase(expbuyingRateR5) && actbuyingValueR5.equalsIgnoreCase(expbuyingValueR5)
				
				&& actsellingRateR6.equalsIgnoreCase(expsellingRateR6) && actsellingValueR6.equalsIgnoreCase(expsellingValueR6)
				&& actbuyingRateR6.equalsIgnoreCase(expbuyingRateR6) && actbuyingValueR6.equalsIgnoreCase(expbuyingValueR6)
				
				&& actsellingRateR7.equalsIgnoreCase(expsellingRateR7) && actsellingValueR7.equalsIgnoreCase(expsellingValueR7)
				&& actbuyingRateR7.equalsIgnoreCase(expbuyingRateR7) && actbuyingValueR7.equalsIgnoreCase(expbuyingValueR7)
				
				&& actsellingRateR8.equalsIgnoreCase(expsellingRateR8) && actsellingValueR8.equalsIgnoreCase(expsellingValueR8)
				&& actbuyingRateR8.equalsIgnoreCase(expbuyingRateR8) && actbuyingValueR8.equalsIgnoreCase(expbuyingValueR8)
				
				&& actsellingRateR9.equalsIgnoreCase(expsellingRateR9) && actsellingValueR9.equalsIgnoreCase(expsellingValueR9)
				&& actbuyingRateR9.equalsIgnoreCase(expbuyingRateR9) && actbuyingValueR9.equalsIgnoreCase(expbuyingValueR9)
				
				&& actsellingRateR10.equalsIgnoreCase(expsellingRateR10) && actsellingValueR10.equalsIgnoreCase(expsellingValueR10)
				&& actbuyingRateR10.equalsIgnoreCase(expbuyingRateR10) && actbuyingValueR10.equalsIgnoreCase(expbuyingValueR10)
				
				&& actsellingRateR11.equalsIgnoreCase(expsellingRateR11) && actsellingValueR11.equalsIgnoreCase(expsellingValueR11)
				&& actbuyingRateR11.equalsIgnoreCase(expbuyingRateR11) && actbuyingValueR11.equalsIgnoreCase(expbuyingValueR11)
				
				&& actsellingRateR12.equalsIgnoreCase(expsellingRateR12) && actsellingValueR12.equalsIgnoreCase(expsellingValueR12)
				&& actbuyingRateR12.equalsIgnoreCase(expbuyingRateR12) && actbuyingValueR12.equalsIgnoreCase(expbuyingValueR12)
				
				&& actsellingRateR13.equalsIgnoreCase(expsellingRateR13) && actsellingValueR13.equalsIgnoreCase(expsellingValueR13)
				&& actbuyingRateR13.equalsIgnoreCase(expbuyingRateR13) && actbuyingValueR13.equalsIgnoreCase(expbuyingValueR13)
				
				&& actsellingRateR14.equalsIgnoreCase(expsellingRateR14) && actsellingValueR14.equalsIgnoreCase(expsellingValueR14)
				&& actbuyingRateR14.equalsIgnoreCase(expbuyingRateR14) && actbuyingValueR14.equalsIgnoreCase(expbuyingValueR14))
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(iq_CloseBtn));
			iq_CloseBtn.click();
			return true;
		}
		else
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(iq_CloseBtn));
			iq_CloseBtn.click();
			return false;
		}
	}
	

	// Stock Ledger Elements 
	
			@FindBy(xpath="//*[@id='551']")
			private static WebElement stockLedger;
			
			@FindBy(xpath="//*[@id='dvReportInputs']/div[1]/div/label/span")
			private static WebElement sl_SelectAllChkBox;
			
			@FindBy(xpath="//div[@id='spnhiererchy']//select[@id='iTreeId']")
			private static WebElement sl_Dropdown1;
			
			@FindBy(xpath="//div[@id='spnhiererchy']//select[@id='iTreeViewId']")
			private static WebElement sl_Dropdown2;
			
			@FindBy(xpath="//label[@id='oncheckaccorderan']")
			private static WebElement sl_oncheckBtn;
			
			@FindBy(xpath="//input[@id='txtsrch-term']")
			private static WebElement sl_SearchItemTxt;
			
			@FindBy(xpath="//i[contains(@class,'icon-search theme_color-inverse')]")
			private static WebElement sl_SearchBtn;
			
			@FindBy(xpath="//input[@id='cmbUserTypeMaster']")
			private static WebElement sl_MasterTypeTxt;
			
			@FindBy(xpath="//span[contains(@class,'icon-font6 icon-external-module theme_icon-color')]")
			private static WebElement sl_AutoAdjustColumnsBtn;
			
			/*@FindBy(xpath="//a[contains(@class,'clsMasterName')][contains(text(),'ITEMS GROUP')]")
			private static WebElement sl_SearchItemTxt;*/
			
			@FindBy(xpath="//a[contains(@class,'clsMasterName')][contains(text(),'ITEMS GROUP')]")
			private static WebElement sl_ItemGroupsBtn;
			
			//@FindBy(xpath="//input[@id='liSelectAllMasters']")
			//private static WebElement sl_HeaderSelectChkBox;
			
			@FindBy(xpath="//*[@id='dvReportInputs']/div[1]/div/label/span")
			private static WebElement sl_HeaderSelectChkBox;
			
			@FindBy(xpath="//i[contains(@class,'icon-font6 icon-schedule')]")
			private static WebElement sl_ScheduleBtn;
			
			@FindBy(xpath="//i[contains(@class,'icon-font6 icon-custamize')]")
			private static WebElement sl_CustomizeBtn;
			
			@FindBy(xpath="//*[@id='id_reportmenudisplay']/ul/li[9]")
			private static WebElement sl_FilterExpandBtn;
			
			@FindBy(xpath="//*[@id='id_reportmenudisplay']/ul/li[9]/ul//li[1]")
			private static WebElement sl_FilterBtn;
			
			@FindBy(xpath="//*[@id='id_reportmenudisplay']/ul/li[9]/ul//li[3]")
			private static WebElement sl_RefineBtn;
			
			@FindBy(xpath="//*[@id='id_mainreportmenuheadings']/ul/li[9]")
			private static WebElement sl_OkBtn;
			
			@FindBy(xpath="//*[@id='id_mainreportmenuheadings']/ul/li[10]")
			private static WebElement sl_CloseBtn;
			
			@FindBy(xpath="//select[@id='DateOptions_']")
			private static WebElement sl_DateOptionDropdown;
			
			@FindBy(xpath="//input[@id='id_starting_date_']")
			private static WebElement sl_StartDateTxt;
			
			@FindBy(xpath="//td[@id='id_starting_date__input_image']//span[contains(@class,'icon-calender theme_color-inverse datecontrol_arrow_margin datecontrol_arrow')]")
			private static WebElement sl_StartDateCalanderBtn;
			
			@FindBy(xpath="//input[@id='id_ending_date_']")
			private static WebElement sl_EndDateTxt;
			
			@FindBy(xpath="//td[@id='id_ending_date__input_image']//span[contains(@class,'icon-calender theme_color-inverse datecontrol_arrow_margin datecontrol_arrow')]")
			private static WebElement sl_EndDateCalanderBtn;
			
			@FindBy(xpath="//*[@id='MasterSingle__101']")
			private static WebElement sl_WarehouseTxt;
			
			@FindBy(xpath="//*[@id='RITCheckbox__6']")
			private static WebElement sl_IgnoreInternalTransferForAgeingChkbox;
			
			@FindBy(xpath="//*[@id='RITCombobox__2']")
			private static WebElement sl_ReportingLevelDropdown;
			
			@FindBy(xpath="//*[@id='RITCheckbox__4']")
			private static WebElement sl_DisplayLinearReportChkbox;
			
			@FindBy(xpath="//*[@id='RITCombobox__1']")
			private static WebElement sl_StockValuationDropdown;
			
			//@FindBy(xpath="//input[@id='RITCheckbox__3']")
			@FindBy(xpath="//*[@id='RITCheckbox__3']/following-sibling::span")
			private static WebElement sl_IncludeServiceTypeItemChkBox;
			
			@FindBy(xpath="(//span[@class='checkmark'])[2]")
			private static WebElement sl_IncludeServiceTypeProductItemChkBox;
			
			@FindBy(xpath="(//span[@class='checkmark'])[4]")
			
			private static WebElement stockLedger_IncludeServiceTypeItemChkBox;

			
			//@FindBy(xpath="//*[@id='dvReportInputs']/div[6]/label/span")
			//private static WebElement sm_IncludeServiceTypeItemChkBox;
			
			@FindBy(xpath="//select[@id='RITLayout_']")
			private static WebElement sl_LayoutDropdown;
			
			@FindBy(xpath="//select[@id='RITOutput_']")
			private static WebElement sl_OutputDropdown;
			
			@FindBy(xpath="//*[@id='selectAllMasters_']/following-sibling::span")
			private static WebElement sl_SelectAllItemsChkBox;
			
			@FindBy(xpath="//div[contains(@class,'first')]//input[contains(@class,'btn btn-xs Fbutton')]")
			private static WebElement sl_FirstBtn;
			
			@FindBy(xpath="//div[contains(@class,'prev')]//input[contains(@class,'btn btn-xs Fbutton')]")
			private static WebElement sl_PreviousBtn;
			
			@FindBy(xpath="//input[@id='btn1']")
			private static WebElement sl_PageBtn;
			
			@FindBy(xpath="//div[contains(@class,'next')]//input[contains(@class,'btn btn-xs Fbutton')]")
			private static WebElement sl_NextBtn;
			
			@FindBy(xpath="//div[contains(@class,'End')]//input[contains(@class,'btn btn-xs Fbutton')]")
			private static WebElement sl_EndBtn;
			
			@FindBy(xpath="//tr[1]//td[8]//div[1]//label[1]//input")
			private static WebElement sl_1stRowChkBox;
			
			@FindBy(xpath="//tr[2]//td[8]//div[1]//label[1]//input")
			private static WebElement sl_2ndRowChkBox;
			
			@FindBy(xpath="//tr[3]//td[8]//div[1]//label[1]//input")
			private static WebElement sl_3rdRowChkBox;
			
			
			
			////////
			
			@FindBy(xpath="//span[@id='reportSort']")
			private static WebElement report_sortingBtn;
					
			@FindBy(xpath="//span[@id='reportRefresh']")
			private static WebElement report_RefreshBtn;
					
			@FindBy(xpath="//span[@id='print_report_']")
			private static WebElement report_PrintBtn;
					
			@FindBy(xpath="//*[@id='reportRenderControls']/ul/li/span[4]")
			private static WebElement report_ExportBtn;
			
			@FindBy(xpath="//a[@id='pdf_report_']")
			private static WebElement report_ExportPDFBtn;
			
			
					
			@FindBy(xpath="//span[@id='GraphIcon']")
			private static WebElement report_GraphBtn;
					
			/*@FindBy(xpath="//span[@id='BackTrackIcon']")
			private static WebElement report_BackTrackBtn;*/
			
			
					
			/*@FindBy(xpath="//span[@id='reportCustomize_']")
			private static WebElement report_ReportCustomizeBtn;*/
			
			@FindBy(xpath="//*[@id='id_reportmenudisplay']/ul/li[7]")
			private static WebElement report_ReportCustomizeBtn;	
				
			/*@FindBy(xpath="//span[@id='filterIcon_']")
			private static WebElement report_FilterBtn;*/
					
			@FindBy(xpath="//*[@id='id_reportmenudisplay']/ul/li[9]/ul//li[1]")
			private static WebElement report_FilterBtn;
			
			@FindBy(xpath="//*[@id='id_reportmenudisplay']/ul/li[10]/ul//li[1]")
			private static WebElement multireport_FilterBtn;
			
			
			@FindBy(xpath="//div[@id='dvfilter']//span[contains(@class,'icon-down-arrow icon-font8 dropdown-toggle theme_button_color')]")
			private static WebElement report_FilterDownBtn;
					
			@FindBy(xpath="//span[@id='analyzeIcon_']")
			private static WebElement report_AnalyzeBtn;
					
			@FindBy(xpath="//span[@id='CrossrefrenceIcon_']")
			private static WebElement report_CrossReferenceBtn;
					
			@FindBy(xpath="//span[contains(text(),'Options')]")
			private static WebElement report_OptionsBtn;
					
			@FindBy(xpath="//div[@id='dvoptions']//span[contains(@class,'icon-down-arrow icon-font8 dropdown-toggle theme_button_color')]")
			private static WebElement report_OptionsDownBtn;
					
			/*@FindBy(xpath="//span[@id='reportClose_']")
			private static WebElement report_CloseBtn;*/
			
			@FindBy(xpath="//*[@id='id_reportmenudisplay']/ul/li[13]")
			private static WebElement report_CloseBtn;
			
			@FindBy(xpath="//*[@id='id_reportmenudisplay']/ul/li[11]")
			private static WebElement report_CloseBtn1;
					
			@FindBy(xpath="//div[@id='tblFooterReportRender']/div[2]/button[1]")
			private static WebElement report_FirstBtn;
					
			@FindBy(xpath="//div[@id='tblFooterReportRender']/div[2]/button[2]")
			private static WebElement report_PreviousBtn;
					
			@FindBy(xpath="//div[@id='tblFooterReportRender']/div[2]/button[3]")
			private static WebElement report_PageNoBtn;
					
			@FindBy(xpath="//div[@id='tblFooterReportRender']/div[2]/button[4]")
			private static WebElement report_NextBtn;
					
			@FindBy(xpath="//div[@id='tblFooterReportRender']/div[2]/button[5]")
			private static WebElement report_LastBtn;
			
			@FindBy(xpath="//input[@id='txtSearchReport']")
			private static WebElement report_SearchTxt;
			
			
			@FindBy(xpath="//*[@id='trRender_0']/td[2]")
			private static WebElement sl_1stRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_0']/td[3]")
			private static WebElement sl_1stRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[4]")
			private static WebElement sl_1stRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[5]")
			private static WebElement sl_1stRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[6]")
			private static WebElement sl_1stRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[7]")
			private static WebElement sl_1stRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[8]")
			private static WebElement sl_1stRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[9]")
			private static WebElement sl_1stRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[10]")
			private static WebElement sl_1stRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[11]")
			private static WebElement sl_1stRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[12]")
			private static WebElement sl_1stRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[13]")
			private static WebElement sl_1stRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[14]")
			private static WebElement sl_1stRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[15]")
			private static WebElement sl_1stRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[16]")
			private static WebElement sl_1stRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[17]")
			private static WebElement sl_1stRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[18]")
			private static WebElement sl_1stRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[19]")
			private static WebElement sl_1stRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[20]")
			private static WebElement sl_1stRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[21]")
			private static WebElement sl_1stRow20thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[22]")
			private static WebElement sl_1stRow21thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[23]")
			private static WebElement sl_1stRow22thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[24]")
			private static WebElement sl_1stRow23thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[25]")
			private static WebElement sl_1stRow24thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[26]")
			private static WebElement sl_1stRow25thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[27]")
			private static WebElement sl_1stRow26thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[28]")
			private static WebElement sl_1stRow27thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[29]")
			private static WebElement sl_1stRow28thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[30]")
			private static WebElement sl_1stRow29thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[31]")
			private static WebElement sl_1stRow30thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[32]")
			private static WebElement sl_1stRow31thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[33]")
			private static WebElement sl_1stRow32thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[34]")
			private static WebElement sl_1stRow33thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[35]")
			private static WebElement sl_1stRow34thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[36]")
			private static WebElement sl_1stRow35thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[37]")
			private static WebElement sl_1stRow36thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[38]")
			private static WebElement sl_1stRow37thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[39]")
			private static WebElement sl_1stRow38thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[40]")
			private static WebElement sl_1stRow39thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[41]")
			private static WebElement sl_1stRow40thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[42]")
			private static WebElement sl_1stRow41thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[43]")
			private static WebElement sl_1stRow42thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[44]")
			private static WebElement sl_1stRow43thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[45]")
			private static WebElement sl_1stRow44thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[46]")
			private static WebElement sl_1stRow45thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[47]")
			private static WebElement sl_1stRow46thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[48]")
			private static WebElement sl_1stRow47thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[49]")
			private static WebElement sl_1stRow48thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[50]")
			private static WebElement sl_1stRow49thCol;
			
			@FindBy(xpath="//*[@id='trRender_0']/td[51]")
			private static WebElement sl_1stRow50thCol;
			
			
			@FindBy(xpath="//*[@id='trRender_1']/td[2]")
			private static WebElement sl_2ndRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_1']/td[3]")
			private static WebElement sl_2ndRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[4]")
			private static WebElement sl_2ndRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[5]")
			private static WebElement sl_2ndRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[6]")
			private static WebElement sl_2ndRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[7]")
			private static WebElement sl_2ndRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[8]")
			private static WebElement sl_2ndRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[9]")
			private static WebElement sl_2ndRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[10]")
			private static WebElement sl_2ndRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[11]")
			private static WebElement sl_2ndRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[12]")
			private static WebElement sl_2ndRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[13]")
			private static WebElement sl_2ndRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[14]")
			private static WebElement sl_2ndRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[15]")
			private static WebElement sl_2ndRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[16]")
			private static WebElement sl_2ndRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[17]")
			private static WebElement sl_2ndRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[18]")
			private static WebElement sl_2ndRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[19]")
			private static WebElement sl_2ndRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[20]")
			private static WebElement sl_2ndRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[21]")
			private static WebElement sl_2ndRow20thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[22]")
			private static WebElement sl_2ndRow21thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[23]")
			private static WebElement sl_2ndRow22thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[24]")
			private static WebElement sl_2ndRow23thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[25]")
			private static WebElement sl_2ndRow24thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[26]")
			private static WebElement sl_2ndRow25thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[27]")
			private static WebElement sl_2ndRow26thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[28]")
			private static WebElement sl_2ndRow27thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[29]")
			private static WebElement sl_2ndRow28thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[30]")
			private static WebElement sl_2ndRow29thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[31]")
			private static WebElement sl_2ndRow30thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[32]")
			private static WebElement sl_2ndRow31thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[33]")
			private static WebElement sl_2ndRow32thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[34]")
			private static WebElement sl_2ndRow33thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[35]")
			private static WebElement sl_2ndRow34thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[36]")
			private static WebElement sl_2ndRow35thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[37]")
			private static WebElement sl_2ndRow36thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[38]")
			private static WebElement sl_2ndRow37thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[39]")
			private static WebElement sl_2ndRow38thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[40]")
			private static WebElement sl_2ndRow39thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[41]")
			private static WebElement sl_2ndRow40thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[42]")
			private static WebElement sl_2ndRow41thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[43]")
			private static WebElement sl_2ndRow42thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[44]")
			private static WebElement sl_2ndRow43thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[45]")
			private static WebElement sl_2ndRow44thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[46]")
			private static WebElement sl_2ndRow45thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[47]")
			private static WebElement sl_2ndRow46thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[48]")
			private static WebElement sl_2ndRow47thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[49]")
			private static WebElement sl_2ndRow48thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[50]")
			private static WebElement sl_2ndRow49thCol;
			
			@FindBy(xpath="//*[@id='trRender_1']/td[51]")
			private static WebElement sl_2ndRow50thCol;
			
			
			
			
			
			@FindBy(xpath="//*[@id='trRender_2']/td[2]")
			private static WebElement sl_3rdRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_2']/td[3]")
			private static WebElement sl_3rdRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[4]")
			private static WebElement sl_3rdRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[5]")
			private static WebElement sl_3rdRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[6]")
			private static WebElement sl_3rdRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[7]")
			private static WebElement sl_3rdRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[8]")
			private static WebElement sl_3rdRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[9]")
			private static WebElement sl_3rdRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[10]")
			private static WebElement sl_3rdRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[11]")
			private static WebElement sl_3rdRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[12]")
			private static WebElement sl_3rdRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[13]")
			private static WebElement sl_3rdRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[14]")
			private static WebElement sl_3rdRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[15]")
			private static WebElement sl_3rdRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[16]")
			private static WebElement sl_3rdRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[17]")
			private static WebElement sl_3rdRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[18]")
			private static WebElement sl_3rdRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[19]")
			private static WebElement sl_3rdRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[20]")
			private static WebElement sl_3rdRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[21]")
			private static WebElement sl_3rdRow20thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[22]")
			private static WebElement sl_3rdRow21thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[23]")
			private static WebElement sl_3rdRow22thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[24]")
			private static WebElement sl_3rdRow23thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[25]")
			private static WebElement sl_3rdRow24thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[26]")
			private static WebElement sl_3rdRow25thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[27]")
			private static WebElement sl_3rdRow26thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[28]")
			private static WebElement sl_3rdRow27thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[29]")
			private static WebElement sl_3rdRow28thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[30]")
			private static WebElement sl_3rdRow29thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[31]")
			private static WebElement sl_3rdRow30thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[32]")
			private static WebElement sl_3rdRow31thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[33]")
			private static WebElement sl_3rdRow32thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[34]")
			private static WebElement sl_3rdRow33thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[35]")
			private static WebElement sl_3rdRow34thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[36]")
			private static WebElement sl_3rdRow35thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[37]")
			private static WebElement sl_3rdRow36thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[38]")
			private static WebElement sl_3rdRow37thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[39]")
			private static WebElement sl_3rdRow38thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[40]")
			private static WebElement sl_3rdRow39thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[41]")
			private static WebElement sl_3rdRow40thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[42]")
			private static WebElement sl_3rdRow41thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[43]")
			private static WebElement sl_3rdRow42thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[44]")
			private static WebElement sl_3rdRow43thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[45]")
			private static WebElement sl_3rdRow44thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[46]")
			private static WebElement sl_3rdRow45thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[47]")
			private static WebElement sl_3rdRow46thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[48]")
			private static WebElement sl_3rdRow47thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[49]")
			private static WebElement sl_3rdRow48thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[50]")
			private static WebElement sl_3rdRow49thCol;
			
			@FindBy(xpath="//*[@id='trRender_2']/td[51]")
			private static WebElement sl_3rdRow50thCol;
			
			
			
			
			
			@FindBy(xpath="//*[@id='trRender_3']/td[2]")
			private static WebElement sl_4thRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_3']/td[3]")
			private static WebElement sl_4thRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[4]")
			private static WebElement sl_4thRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[5]")
			private static WebElement sl_4thRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[6]")
			private static WebElement sl_4thRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[7]")
			private static WebElement sl_4thRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[8]")
			private static WebElement sl_4thRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[9]")
			private static WebElement sl_4thRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[10]")
			private static WebElement sl_4thRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[11]")
			private static WebElement sl_4thRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[12]")
			private static WebElement sl_4thRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[13]")
			private static WebElement sl_4thRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[14]")
			private static WebElement sl_4thRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[15]")
			private static WebElement sl_4thRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[16]")
			private static WebElement sl_4thRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[17]")
			private static WebElement sl_4thRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[18]")
			private static WebElement sl_4thRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[19]")
			private static WebElement sl_4thRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[20]")
			private static WebElement sl_4thRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[21]")
			private static WebElement sl_4thRow20thCol;
			

			@FindBy(xpath="//*[@id='trRender_3']/td[22]")
			private static WebElement sl_4thRow21thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[23]")
			private static WebElement sl_4thRow22thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[24]")
			private static WebElement sl_4thRow23thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[25]")
			private static WebElement sl_4thRow24thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[26]")
			private static WebElement sl_4thRow25thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[27]")
			private static WebElement sl_4thRow26thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[28]")
			private static WebElement sl_4thRow27thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[29]")
			private static WebElement sl_4thRow28thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[30]")
			private static WebElement sl_4thRow29thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[31]")
			private static WebElement sl_4thRow30thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[32]")
			private static WebElement sl_4thRow31thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[33]")
			private static WebElement sl_4thRow32thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[34]")
			private static WebElement sl_4thRow33thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[35]")
			private static WebElement sl_4thRow34thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[36]")
			private static WebElement sl_4thRow35thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[37]")
			private static WebElement sl_4thRow36thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[38]")
			private static WebElement sl_4thRow37thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[39]")
			private static WebElement sl_4thRow38thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[40]")
			private static WebElement sl_4thRow39thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[41]")
			private static WebElement sl_4thRow40thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[42]")
			private static WebElement sl_4thRow41thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[43]")
			private static WebElement sl_4thRow42thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[44]")
			private static WebElement sl_4thRow43thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[45]")
			private static WebElement sl_4thRow44thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[46]")
			private static WebElement sl_4thRow45thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[47]")
			private static WebElement sl_4thRow46thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[48]")
			private static WebElement sl_4thRow47thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[49]")
			private static WebElement sl_4thRow48thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[50]")
			private static WebElement sl_4thRow49thCol;
			
			@FindBy(xpath="//*[@id='trRender_3']/td[51]")
			private static WebElement sl_4thRow50thCol;
			
			

			
			
			
			
			
			@FindBy(xpath="//*[@id='trRender_4']/td[2]")
			private static WebElement sl_5thRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_4']/td[3]")
			private static WebElement sl_5thRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[4]")
			private static WebElement sl_5thRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[5]")
			private static WebElement sl_5thRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[6]")
			private static WebElement sl_5thRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[7]")
			private static WebElement sl_5thRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[8]")
			private static WebElement sl_5thRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[9]")
			private static WebElement sl_5thRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[10]")
			private static WebElement sl_5thRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[11]")
			private static WebElement sl_5thRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[12]")
			private static WebElement sl_5thRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[13]")
			private static WebElement sl_5thRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[14]")
			private static WebElement sl_5thRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[15]")
			private static WebElement sl_5thRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[16]")
			private static WebElement sl_5thRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[17]")
			private static WebElement sl_5thRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[18]")
			private static WebElement sl_5thRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[19]")
			private static WebElement sl_5thRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[20]")
			private static WebElement sl_5thRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[21]")
			private static WebElement sl_5thRow20thCol;
			

			@FindBy(xpath="//*[@id='trRender_4']/td[22]")
			private static WebElement sl_5thRow21thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[23]")
			private static WebElement sl_5thRow22thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[24]")
			private static WebElement sl_5thRow23thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[25]")
			private static WebElement sl_5thRow24thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[26]")
			private static WebElement sl_5thRow25thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[27]")
			private static WebElement sl_5thRow26thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[28]")
			private static WebElement sl_5thRow27thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[29]")
			private static WebElement sl_5thRow28thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[30]")
			private static WebElement sl_5thRow29thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[31]")
			private static WebElement sl_5thRow30thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[32]")
			private static WebElement sl_5thRow31thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[33]")
			private static WebElement sl_5thRow32thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[34]")
			private static WebElement sl_5thRow33thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[35]")
			private static WebElement sl_5thRow34thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[36]")
			private static WebElement sl_5thRow35thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[37]")
			private static WebElement sl_5thRow36thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[38]")
			private static WebElement sl_5thRow37thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[39]")
			private static WebElement sl_5thRow38thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[40]")
			private static WebElement sl_5thRow39thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[41]")
			private static WebElement sl_5thRow40thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[42]")
			private static WebElement sl_5thRow41thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[43]")
			private static WebElement sl_5thRow42thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[44]")
			private static WebElement sl_5thRow43thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[45]")
			private static WebElement sl_5thRow44thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[46]")
			private static WebElement sl_5thRow45thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[47]")
			private static WebElement sl_5thRow46thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[48]")
			private static WebElement sl_5thRow47thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[49]")
			private static WebElement sl_5thRow48thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[50]")
			private static WebElement sl_5thRow49thCol;
			
			@FindBy(xpath="//*[@id='trRender_4']/td[51]")
			private static WebElement sl_5thRow50thCol;
			
			
			
			

			
			@FindBy(xpath="//*[@id='trRender_5']/td[2]")
			private static WebElement sl_6thRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_5']/td[3]")
			private static WebElement sl_6thRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[4]")
			private static WebElement sl_6thRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[5]")
			private static WebElement sl_6thRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[6]")
			private static WebElement sl_6thRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[7]")
			private static WebElement sl_6thRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[8]")
			private static WebElement sl_6thRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[9]")
			private static WebElement sl_6thRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[10]")
			private static WebElement sl_6thRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[11]")
			private static WebElement sl_6thRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[12]")
			private static WebElement sl_6thRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[13]")
			private static WebElement sl_6thRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[14]")
			private static WebElement sl_6thRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[15]")
			private static WebElement sl_6thRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[16]")
			private static WebElement sl_6thRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[17]")
			private static WebElement sl_6thRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[18]")
			private static WebElement sl_6thRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[19]")
			private static WebElement sl_6thRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[20]")
			private static WebElement sl_6thRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[21]")
			private static WebElement sl_6thRow20thCol;
			

			@FindBy(xpath="//*[@id='trRender_5']/td[22]")
			private static WebElement sl_6thRow21thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[23]")
			private static WebElement sl_6thRow22thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[24]")
			private static WebElement sl_6thRow23thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[25]")
			private static WebElement sl_6thRow24thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[26]")
			private static WebElement sl_6thRow25thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[27]")
			private static WebElement sl_6thRow26thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[28]")
			private static WebElement sl_6thRow27thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[29]")
			private static WebElement sl_6thRow28thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[30]")
			private static WebElement sl_6thRow29thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[31]")
			private static WebElement sl_6thRow30thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[32]")
			private static WebElement sl_6thRow31thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[33]")
			private static WebElement sl_6thRow32thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[34]")
			private static WebElement sl_6thRow33thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[35]")
			private static WebElement sl_6thRow34thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[36]")
			private static WebElement sl_6thRow35thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[37]")
			private static WebElement sl_6thRow36thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[38]")
			private static WebElement sl_6thRow37thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[39]")
			private static WebElement sl_6thRow38thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[40]")
			private static WebElement sl_6thRow39thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[41]")
			private static WebElement sl_6thRow40thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[42]")
			private static WebElement sl_6thRow41thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[43]")
			private static WebElement sl_6thRow42thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[44]")
			private static WebElement sl_6thRow43thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[45]")
			private static WebElement sl_6thRow44thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[46]")
			private static WebElement sl_6thRow45thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[47]")
			private static WebElement sl_6thRow46thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[48]")
			private static WebElement sl_6thRow47thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[49]")
			private static WebElement sl_6thRow48thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[50]")
			private static WebElement sl_6thRow49thCol;
			
			@FindBy(xpath="//*[@id='trRender_5']/td[51]")
			private static WebElement sl_6thRow50thCol;
			
			
			
			
			
			
			
			
			@FindBy(xpath="//*[@id='trRender_6']/td[2]")
			private static WebElement sl_7thRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_6']/td[3]")
			private static WebElement sl_7thRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[4]")
			private static WebElement sl_7thRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[5]")
			private static WebElement sl_7thRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[6]")
			private static WebElement sl_7thRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[7]")
			private static WebElement sl_7thRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[8]")
			private static WebElement sl_7thRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[9]")
			private static WebElement sl_7thRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[10]")
			private static WebElement sl_7thRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[11]")
			private static WebElement sl_7thRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[12]")
			private static WebElement sl_7thRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[13]")
			private static WebElement sl_7thRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[14]")
			private static WebElement sl_7thRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[15]")
			private static WebElement sl_7thRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[16]")
			private static WebElement sl_7thRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[17]")
			private static WebElement sl_7thRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[18]")
			private static WebElement sl_7thRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[19]")
			private static WebElement sl_7thRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[20]")
			private static WebElement sl_7thRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_6']/td[21]")
			private static WebElement sl_7thRow20thCol;
			
			
			
			
			
			@FindBy(xpath="//*[@id='trRender_7']/td[2]")
			private static WebElement sl_8thRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_7']/td[3]")
			private static WebElement sl_8thRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[4]")
			private static WebElement sl_8thRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[5]")
			private static WebElement sl_8thRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[6]")
			private static WebElement sl_8thRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[7]")
			private static WebElement sl_8thRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[8]")
			private static WebElement sl_8thRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[9]")
			private static WebElement sl_8thRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[10]")
			private static WebElement sl_8thRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[11]")
			private static WebElement sl_8thRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[12]")
			private static WebElement sl_8thRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[13]")
			private static WebElement sl_8thRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[14]")
			private static WebElement sl_8thRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[15]")
			private static WebElement sl_8thRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[16]")
			private static WebElement sl_8thRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[17]")
			private static WebElement sl_8thRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[18]")
			private static WebElement sl_8thRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[19]")
			private static WebElement sl_8thRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[20]")
			private static WebElement sl_8thRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_7']/td[21]")
			private static WebElement sl_8thRow20thCol;
			
			
			
			@FindBy(xpath="//*[@id='trRender_8']/td[2]")
			private static WebElement sl_9thRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_8']/td[3]")
			private static WebElement sl_9thRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[4]")
			private static WebElement sl_9thRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[5]")
			private static WebElement sl_9thRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[6]")
			private static WebElement sl_9thRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[7]")
			private static WebElement sl_9thRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[8]")
			private static WebElement sl_9thRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[9]")
			private static WebElement sl_9thRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[10]")
			private static WebElement sl_9thRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[11]")
			private static WebElement sl_9thRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[12]")
			private static WebElement sl_9thRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[13]")
			private static WebElement sl_9thRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[14]")
			private static WebElement sl_9thRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[15]")
			private static WebElement sl_9thRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[16]")
			private static WebElement sl_9thRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[17]")
			private static WebElement sl_9thRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[18]")
			private static WebElement sl_9thRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[19]")
			private static WebElement sl_9thRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[20]")
			private static WebElement sl_9thRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_8']/td[21]")
			private static WebElement sl_9thRow20thCol;
			
			
			
			@FindBy(xpath="//*[@id='trRender_9']/td[2]")
			private static WebElement sl_10thRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_9']/td[3]")
			private static WebElement sl_10thRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[4]")
			private static WebElement sl_10thRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[5]")
			private static WebElement sl_10thRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[6]")
			private static WebElement sl_10thRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[7]")
			private static WebElement sl_10thRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[8]")
			private static WebElement sl_10thRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[9]")
			private static WebElement sl_10thRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[10]")
			private static WebElement sl_10thRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[11]")
			private static WebElement sl_10thRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[12]")
			private static WebElement sl_10thRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[13]")
			private static WebElement sl_10thRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[14]")
			private static WebElement sl_10thRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[15]")
			private static WebElement sl_10thRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[16]")
			private static WebElement sl_10thRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[17]")
			private static WebElement sl_10thRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[18]")
			private static WebElement sl_10thRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[19]")
			private static WebElement sl_10thRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[20]")
			private static WebElement sl_10thRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_9']/td[21]")
			private static WebElement sl_10thRow20thCol;
			
			
			@FindBy(xpath="//*[@id='trRender_10']/td[2]")
			private static WebElement sl_11thRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_10']/td[3]")
			private static WebElement sl_11thRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[4]")
			private static WebElement sl_11thRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[5]")
			private static WebElement sl_11thRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[6]")
			private static WebElement sl_11thRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[7]")
			private static WebElement sl_11thRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[8]")
			private static WebElement sl_11thRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[9]")
			private static WebElement sl_11thRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[10]")
			private static WebElement sl_11thRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[11]")
			private static WebElement sl_11thRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[12]")
			private static WebElement sl_11thRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[13]")
			private static WebElement sl_11thRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[14]")
			private static WebElement sl_11thRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[15]")
			private static WebElement sl_11thRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[16]")
			private static WebElement sl_11thRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[17]")
			private static WebElement sl_11thRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[18]")
			private static WebElement sl_11thRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[19]")
			private static WebElement sl_11thRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[20]")
			private static WebElement sl_11thRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_10']/td[21]")
			private static WebElement sl_11thRow20thCol;
			
			
			@FindBy(xpath="//*[@id='trRender_11']/td[2]")
			private static WebElement sl_12thRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_11']/td[3]")
			private static WebElement sl_12thRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[4]")
			private static WebElement sl_12thRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[5]")
			private static WebElement sl_12thRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[6]")
			private static WebElement sl_12thRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[7]")
			private static WebElement sl_12thRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[8]")
			private static WebElement sl_12thRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[9]")
			private static WebElement sl_12thRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[10]")
			private static WebElement sl_12thRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[11]")
			private static WebElement sl_12thRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[12]")
			private static WebElement sl_12thRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[13]")
			private static WebElement sl_12thRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[14]")
			private static WebElement sl_12thRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[15]")
			private static WebElement sl_12thRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[16]")
			private static WebElement sl_12thRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[17]")
			private static WebElement sl_12thRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[18]")
			private static WebElement sl_12thRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[19]")
			private static WebElement sl_12thRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[20]")
			private static WebElement sl_12thRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_11']/td[21]")
			private static WebElement sl_12thRow20thCol;
			
			
			
			@FindBy(xpath="//*[@id='trRender_12']/td[2]")
			private static WebElement sl_13thRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_12']/td[3]")
			private static WebElement sl_13thRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[4]")
			private static WebElement sl_13thRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[5]")
			private static WebElement sl_13thRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[6]")
			private static WebElement sl_13thRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[7]")
			private static WebElement sl_13thRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[8]")
			private static WebElement sl_13thRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[9]")
			private static WebElement sl_13thRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[10]")
			private static WebElement sl_13thRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[11]")
			private static WebElement sl_13thRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[12]")
			private static WebElement sl_13thRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[13]")
			private static WebElement sl_13thRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[14]")
			private static WebElement sl_13thRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[15]")
			private static WebElement sl_13thRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[16]")
			private static WebElement sl_13thRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[17]")
			private static WebElement sl_13thRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[18]")
			private static WebElement sl_13thRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[19]")
			private static WebElement sl_13thRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[20]")
			private static WebElement sl_13thRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_12']/td[21]")
			private static WebElement sl_13thRow20thCol;
			
			
			
			@FindBy(xpath="//*[@id='trRender_13']/td[2]")
			private static WebElement sl_14thRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_13']/td[3]")
			private static WebElement sl_14thRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[4]")
			private static WebElement sl_14thRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[5]")
			private static WebElement sl_14thRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[6]")
			private static WebElement sl_14thRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[7]")
			private static WebElement sl_14thRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[8]")
			private static WebElement sl_14thRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[9]")
			private static WebElement sl_14thRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[10]")
			private static WebElement sl_14thRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[11]")
			private static WebElement sl_14thRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[12]")
			private static WebElement sl_14thRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[13]")
			private static WebElement sl_14thRow12thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[14]")
			private static WebElement sl_14thRow13thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[15]")
			private static WebElement sl_14thRow14thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[16]")
			private static WebElement sl_14thRow15thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[17]")
			private static WebElement sl_14thRow16thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[18]")
			private static WebElement sl_14thRow17thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[19]")
			private static WebElement sl_14thRow18thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[20]")
			private static WebElement sl_14thRow19thCol;
			
			@FindBy(xpath="//*[@id='trRender_13']/td[21]")
			private static WebElement sl_14thRow20thCol;
			
			
			
			@FindBy(xpath="//*[@id='trRender_14']/td[2]")
			private static WebElement sl_15thRow1stCol;
					
			@FindBy(xpath="//*[@id='trRender_14']/td[3]")
			private static WebElement sl_15thRow2ndCol;
			
			@FindBy(xpath="//*[@id='trRender_14']/td[4]")
			private static WebElement sl_15thRow3rdCol;
			
			@FindBy(xpath="//*[@id='trRender_14']/td[5]")
			private static WebElement sl_15thRow4thCol;
			
			@FindBy(xpath="//*[@id='trRender_14']/td[6]")
			private static WebElement sl_15thRow5thCol;
			
			@FindBy(xpath="//*[@id='trRender_14']/td[7]")
			private static WebElement sl_15thRow6thCol;
			
			@FindBy(xpath="//*[@id='trRender_14']/td[8]")
			private static WebElement sl_15thRow7thCol;
			
			@FindBy(xpath="//*[@id='trRender_14']/td[9]")
			private static WebElement sl_15thRow8thCol;
			
			@FindBy(xpath="//*[@id='trRender_14']/td[10]")
			private static WebElement sl_15thRow9thCol;
			
			@FindBy(xpath="//*[@id='trRender_14']/td[11]")
			private static WebElement sl_15thRow10thCol;
			
			@FindBy(xpath="//*[@id='trRender_14']/td[12]")
			private static WebElement sl_15thRow11thCol;
			
			@FindBy(xpath="//*[@id='trRender_14']/td[13]")
			private static WebElement sl_15thRow12thCol;
			
			
			
			@FindBy(xpath="//tbody[@id='LandingGridBody']/tr")
			private static List<WebElement> stockLedgerHometableRowCount;
			
			
			 // Reports Table Row List  
		  	@FindBy(xpath="(//tr[@id='trRender_0'])[1]/td")
			private static List<WebElement> reportsRow1List;
			
			@FindBy(xpath="(//tr[@id='trRender_1'])[1]/td")
			private static List<WebElement> reportsRow2List;
			
			@FindBy(xpath="(//tr[@id='trRender_2'])[1]/td")
			private static List<WebElement> reportsRow3List;
			
			@FindBy(xpath="(//tr[@id='trRender_3'])[1]/td")
			private static List<WebElement> reportsRow4List;
			
			@FindBy(xpath="(//tr[@id='trRender_4'])[1]/td")
			private static List<WebElement> reportsRow5List;
			
			@FindBy(xpath="(//tr[@id='trRender_5'])[1]/td")
			private static List<WebElement> reportsRow6List;
			
			@FindBy(xpath="(//tr[@id='trRender_6'])[1]/td")
			private static List<WebElement> reportsRow7List;
			
			@FindBy(xpath="(//tr[@id='trRender_7'])[1]/td")
			private static List<WebElement> reportsRow8List;
			
			@FindBy(xpath="(//tr[@id='trRender_8'])[1]/td")
			private static List<WebElement> reportsRow9List;
			
			@FindBy(xpath="(//tr[@id='trRender_9'])[1]/td")
			private static List<WebElement> reportsRow10List;
			
			@FindBy(xpath="(//tr[@id='trRender_10'])[1]/td")
			private static List<WebElement> reportsRow11List;
			
			@FindBy(xpath="(//tr[@id='trRender_11'])[1]/td")
			private static List<WebElement> reportsRow12List;
			
			@FindBy(xpath="(//tr[@id='trRender_12'])[1]/td")
			private static List<WebElement> reportsRow13List;
			
			@FindBy(xpath="(//tr[@id='trRender_13'])[1]/td")
			private static List<WebElement> reportsRow14List;
			
			
			
			//@FindBy(xpath="//tbody[@id='LandingGridBody']/tr/td[12]")
			
			@FindBy(xpath="//*[@id='landgridData']/tbody/tr/td[12]")
			private static List<WebElement> stockLedgerHometableItemNamesList;
			
			@FindBy(xpath="//tbody[@id='LandingGridBody']/tr/td[8]/div/label/input")
			private static List<WebElement> stockLedgerHometableItemChkboxList;
			
			@FindBy(xpath="(//div[@id='dvReportDetails']/div/table/thead)[1]/tr/th")
			private static List<WebElement> reportsHeaderList;
			
			
			
	       	
			public boolean checkStockLedgerReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
				inventoryMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
				inventoryReportsMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockLedger));
				stockLedger.click();
				
				Thread.sleep(2000);
				
				int rowcount=stockLedgerHometableRowCount.size();
				
				System.out.println(rowcount);
				
				for (int i = 1; i <= rowcount; i++) 
				{
					String actName = stockLedgerHometableItemNamesList.get(i).getText();
					
					System.out.println(actName);
					
					if(actName.equalsIgnoreCase("WA COGS ITEM"))
					{
						stockLedgerHometableItemChkboxList.get(i).click();
						break;
					}
				}
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
				Select s=new Select(sl_DateOptionDropdown);
				s.selectByIndex(1);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
				sl_OkBtn.click();
				
				Thread.sleep(2000);
				
				int reportsRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsRow1ListArray.add(data);
				}
				String actRow1List = reportsRow1ListArray.toString();
				String expRow1List = "[WA COGS ITEM [WA COGS ITEM]]";
				
				

				int reportsRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsRow2ListArray.add(data);
				}
				String actRow2List = reportsRow2ListArray.toString();
				String expRow2List = "[Opening Balance, 24.00, , , , 24.00, , , 84.00, 3.50, , , ]";
				
				
				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[NDT57:SU/IND/TEXT5, 12.00, 10.50, , , 36.00, 126.00, , 210.00, 5.83, , , ]";
				
				
				
				int reportsRow4ListCount = reportsRow4List.size();
				ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow4ListCount;i++)
				{
					String data = reportsRow4List.get(i).getText();
					reportsRow4ListArray.add(data);
				}
				String actRow4List = reportsRow4ListArray.toString();
				String expRow4List = "[NDT57:SU/IND/TEXT5, 10.00, 10.50, , , 46.00, 105.00, , 315.00, 6.85, , , ]";
				
				
				
				int reportsRow5ListCount = reportsRow5List.size();
				ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow5ListCount;i++)
				{
					String data = reportsRow5List.get(i).getText();
					reportsRow5ListArray.add(data);
				}
				String actRow5List = reportsRow5ListArray.toString();
				String expRow5List = "[ExeStk:2, 10.00, 10.00, , , 56.00, 100.00, , 415.00, 7.41, , , ]";
				
				
				
				int reportsRow6ListCount = reportsRow6List.size();
				ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow6ListCount;i++)
				{
					String data = reportsRow6List.get(i).getText();
					reportsRow6ListArray.add(data);
				}
				String actRow6List = reportsRow6ListArray.toString();
				String expRow6List = "[StkTrf:2, , , 10.00, 7.41, 46.00, , 74.11, 340.89, 7.41, , , ]";
				
				
				
				int reportsRow7ListCount = reportsRow7List.size();
				ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow7ListCount;i++)
				{
					String data = reportsRow7List.get(i).getText();
					reportsRow7ListArray.add(data);
				}
				String actRow7List = reportsRow7ListArray.toString();
				String expRow7List = "[StkTrf:2, 10.00, 7.41, , , 56.00, 74.11, , 415.00, 7.41, , , ]";
				
				
				
				int reportsRow8ListCount = reportsRow8List.size();
				ArrayList<String> reportsRow8ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow8ListCount;i++)
				{
					String data = reportsRow8List.get(i).getText();
					reportsRow8ListArray.add(data);
				}
				String actRow8List = reportsRow8ListArray.toString();
				String expRow8List = "[NDT50:5, , , 3.00, 7.41, 53.00, , 22.23, 392.77, 7.41, , , ]";
				
				
				
				int reportsRow9ListCount = reportsRow9List.size();
				ArrayList<String> reportsRow9ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow9ListCount;i++)
				{
					String data = reportsRow9List.get(i).getText();
					reportsRow9ListArray.add(data);
				}
				String actRow9List = reportsRow9ListArray.toString();
				String expRow9List = "[NDT50:7, , , 10.00, 7.41, 43.00, , 74.11, 318.66, 7.41, , , ]";
				
				
				
				int reportsRow10ListCount = reportsRow10List.size();
				ArrayList<String> reportsRow10ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow10ListCount;i++)
				{
					String data = reportsRow10List.get(i).getText();
					reportsRow10ListArray.add(data);
				}
				String actRow10List = reportsRow10ListArray.toString();
				String expRow10List = "[Reserved stock, , , 43.00, , , , , , , , , ]";
				
				
				
				int reportsRow11ListCount = reportsRow11List.size();
				ArrayList<String> reportsRow11ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow11ListCount;i++)
				{
					String data = reportsRow11List.get(i).getText();
					reportsRow11ListArray.add(data);
				}
				String actRow11List = reportsRow11ListArray.toString();
				String expRow11List = "[Total, , 66.00, 38.41, 66.00, 22.23, , 405.11, 170.45, 318.66, 53.23, , , ]";
				
				
				
				/*int reportsRow12ListCount = reportsRow12List.size();
				ArrayList<String> reportsRow12ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow12ListCount;i++)
				{
					String data = reportsRow12List.get(i).getText();
					reportsRow12ListArray.add(data);
				}
				String actRow12List = reportsRow12ListArray.toString();
				String expRow12List = "[Grand Total, , 66.00, 38.41, 66.00, 22.23, , 405.11, 170.45, 318.66, 53.23, , , ]";
				
				*/
				
				
				System.out.println("************************************checkStockLedgerReport********************************************");
			
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				System.out.println(actRow4List);
				System.out.println(expRow4List);
				
				System.out.println(actRow5List);
				System.out.println(expRow5List);
				
				System.out.println(actRow6List);
				System.out.println(expRow6List);
				
				System.out.println(actRow7List);
				System.out.println(expRow7List);
				
				System.out.println(actRow8List);
				System.out.println(expRow8List);
				
				System.out.println(actRow9List);
				System.out.println(expRow9List);
				
				System.out.println(actRow10List);
				System.out.println(expRow10List);
				
				System.out.println(actRow11List);
				System.out.println(expRow11List);
				
				/*System.out.println(actRow12List);
				System.out.println(expRow12List);*/
				
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
					&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List) 
					&& actRow7List.equalsIgnoreCase(expRow7List) && actRow8List.equalsIgnoreCase(expRow8List) && actRow9List.equalsIgnoreCase(expRow9List) 
					&& actRow10List.equalsIgnoreCase(expRow10List) && actRow11List.equalsIgnoreCase(expRow11List) /*&& actRow12List.equalsIgnoreCase(expRow12List)*/)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
				
			
			// With Customizing Warehouse
			
			@FindBy(xpath="//*[@id='CustomizeTransTree']/ul/li/span")
			private static WebElement  osr_customizeFieldsTransactionExpansion; 
			
			@FindBy(xpath="//*[@id='rd_customization_tree2']/span")
			private static WebElement  osr_customizeFieldsTransExtraFieldsExpansion; 
			
			@FindBy(xpath="//*[@id='rd_customization_tree2_43']/span/span")
			private static WebElement  osr_customizeFieldsTransExtraFieldsWarehouseExpansion; 
			
			@FindBy(xpath="//*[@id='rd_customization_tree2_43_0']")
			private static WebElement  osr_customizeFieldsTransExtraFieldsWarehouseName; 
			
			@FindBy(xpath="//li[@id='rd_customization_tree2_15']")
			private static WebElement  osr_customizeFieldsTransExtraFieldsNarration;
			
			@FindBy(xpath="//*[@id='id_rc_columnheadertable']/thead/tr/th")
			private static List<WebElement> osr_customizeHeaderList;
			
			@FindBy(xpath="//table[@id='tblRDRender']/thead/tr/th")
			private static List<WebElement> osr_reportHeaderList;
			
			
			@FindBy(xpath="//ul[@id='id_Item_main']/li/span")
			private static WebElement  osr_customizeFieldsItemExpansion; 
			
			@FindBy(xpath="//li[@id='id_Item_main_0']")
			private static WebElement  osr_customizeFieldsItemName; 
			
			
			@FindBy(xpath="//input[@id='HidethisColumn']")
			private static WebElement osr_customizeTabHideThisColumnChkBox;
			
			@FindBy(xpath="//input[@id='ScrollTexttonextLine']")
			private static WebElement osr_customizeTabScrollTextToNextLineChkBox;
			
			@FindBy(xpath="//input[@id='Printunderpreviouscolumn']")
			private static WebElement osr_customizeTabPrintUnderPreviousColumnChkBox;
			
			@FindBy(xpath="//input[@id='Mandatorycolumn']")
			private static WebElement osr_customizeTabMandatoryColumnChkBox;
			
			@FindBy(xpath="//*[@id='plnCustomizecolumn']/div/span[4]/a")
			private static WebElement osr_customizeTabRemoveColumnBtn;
			
			//@FindBy(xpath="//*[@id='Save']")
			@FindBy(xpath="//*[@id='navbarSupportedContent2']/ul/li[7]")
			private static WebElement  osr_customizeSaveBtn;
			
			@FindBy(xpath="//*[@id='Deleteayout']/div[2]")
			private static WebElement  osr_customizeDeleteLayoutBtn;
			
			@FindBy(xpath="//div[@id='btnCustomizeClose']")
			private static WebElement  osr_customizeCloseBtn;
			
			@FindBy(xpath="//*[@id='navbarSupportedContent2']/ul/li[4]")
			private static WebElement report_CustomizationDeleteLayoutBtn;
			
			//delete column in layout
			@FindBy(xpath="//*[@id='id_rc_columnheadertable']//tr[1]/th")
			private static List<WebElement> Listcolumnnames;
		
			@FindBy(xpath="//*[@id='id_rc_columnheadertable']//tr[1]/th[11]")
			private static WebElement warehouseColumn;
			@FindBy(xpath="//*[@id='plnCustomizecolumn']/div/span[4]")
			private static WebElement removeColumn;
			
			public boolean checkStockLedgerCustomizationReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_ReportCustomizeBtn));
				report_ReportCustomizeBtn.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(osr_customizeFieldsTransactionExpansion));
				osr_customizeFieldsTransactionExpansion.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(osr_customizeFieldsTransExtraFieldsExpansion));
				osr_customizeFieldsTransExtraFieldsExpansion.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(osr_customizeFieldsTransExtraFieldsWarehouseExpansion));
				osr_customizeFieldsTransExtraFieldsWarehouseExpansion.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(osr_customizeFieldsTransExtraFieldsWarehouseName));
				getAction().doubleClick(osr_customizeFieldsTransExtraFieldsWarehouseName).build().perform();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(osr_customizeSaveBtn));
				osr_customizeSaveBtn.click();
				
				String expMessage = "Data saved successfully";
			    
			    String actMessage = checkValidationMessage(expMessage);
				
				Thread.sleep(4000);
				
				/*if (sl_OkBtn.isDisplayed()==true) 
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
					sl_OkBtn.click();
					
					Thread.sleep(4000);
				}
			    else
			    {
			    	if (osr_customizeCloseBtn.isDisplayed()==true) 
			    	{
						getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(osr_customizeCloseBtn));
						osr_customizeCloseBtn.click();
						
						Thread.sleep(4000);
					}
			    }*/
				
				/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
				report_CloseBtn.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
				sl_OkBtn.click();
				
				Thread.sleep(2000);*/
				
				int reportsRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsRow1ListArray.add(data);
				}
				String actRow1List = reportsRow1ListArray.toString();
				String expRow1List = "[WA COGS ITEM [WA COGS ITEM]]";
				
				

				int reportsRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsRow2ListArray.add(data);
				}
				String actRow2List = reportsRow2ListArray.toString();
				String expRow2List = "[Opening Balance, 24.00, , , , 24.00, , , 84.00, 3.50, , , , ]";
				
				
				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[NDT57:SU/IND/TEXT5, 12.00, 10.50, , , 36.00, 126.00, , 210.00, 5.83, , , , HYDERABAD]";
				
				
				
				int reportsRow4ListCount = reportsRow4List.size();
				ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow4ListCount;i++)
				{
					String data = reportsRow4List.get(i).getText();
					reportsRow4ListArray.add(data);
				}
				String actRow4List = reportsRow4ListArray.toString();
				String expRow4List = "[NDT57:SU/IND/TEXT5, 10.00, 10.50, , , 46.00, 105.00, , 315.00, 6.85, , , , HYDERABAD]";
				
				
				
				int reportsRow5ListCount = reportsRow5List.size();
				ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow5ListCount;i++)
				{
					String data = reportsRow5List.get(i).getText();
					reportsRow5ListArray.add(data);
				}
				String actRow5List = reportsRow5ListArray.toString();
				String expRow5List = "[ExeStk:2, 10.00, 10.00, , , 56.00, 100.00, , 415.00, 7.41, , , , HYDERABAD]";
				
				
				
				int reportsRow6ListCount = reportsRow6List.size();
				ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow6ListCount;i++)
				{
					String data = reportsRow6List.get(i).getText();
					reportsRow6ListArray.add(data);
				}
				String actRow6List = reportsRow6ListArray.toString();
				String expRow6List = "[StkTrf:2, , , 10.00, 7.41, 46.00, , 74.11, 340.89, 7.41, , , , HYDERABAD]";
				
				
				
				int reportsRow7ListCount = reportsRow7List.size();
				ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow7ListCount;i++)
				{
					String data = reportsRow7List.get(i).getText();
					reportsRow7ListArray.add(data);
				}
				String actRow7List = reportsRow7ListArray.toString();
				String expRow7List = "[StkTrf:2, 10.00, 7.41, , , 56.00, 74.11, , 415.00, 7.41, , , , SECUNDERABAD]";
				
				
				
				int reportsRow8ListCount = reportsRow8List.size();
				ArrayList<String> reportsRow8ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow8ListCount;i++)
				{
					String data = reportsRow8List.get(i).getText();
					reportsRow8ListArray.add(data);
				}
				String actRow8List = reportsRow8ListArray.toString();
				String expRow8List = "[NDT50:5, , , 3.00, 7.41, 53.00, , 22.23, 392.77, 7.41, , , , HYDERABAD]";
				
				
				
				int reportsRow9ListCount = reportsRow9List.size();
				ArrayList<String> reportsRow9ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow9ListCount;i++)
				{
					String data = reportsRow9List.get(i).getText();
					reportsRow9ListArray.add(data);
				}
				String actRow9List = reportsRow9ListArray.toString();
				String expRow9List = "[NDT50:7, , , 10.00, 7.41, 43.00, , 74.11, 318.66, 7.41, , , , SECUNDERABAD]";
				
				

				int reportsRow10ListCount = reportsRow10List.size();
				ArrayList<String> reportsRow10ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow10ListCount;i++)
				{
					String data = reportsRow10List.get(i).getText();
					reportsRow10ListArray.add(data);
				}
				String actRow10List = reportsRow10ListArray.toString();
				String expRow10List = "[Reserved stock, , , 43.00, , , , , , , , , , ]";
				
				
				
				int reportsRow11ListCount = reportsRow11List.size();
				ArrayList<String> reportsRow11ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow11ListCount;i++)
				{
					String data = reportsRow11List.get(i).getText();
					reportsRow11ListArray.add(data);
				}
				String actRow11List = reportsRow11ListArray.toString();
				String expRow11List = "[Total, , 66.00, 38.41, 66.00, 22.23, , 405.11, 170.45, 318.66, 53.23, , , , ]";
				
				
				/*int reportsRow12ListCount = reportsRow12List.size();
				ArrayList<String> reportsRow12ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow12ListCount;i++)
				{
					String data = reportsRow12List.get(i).getText();
					reportsRow12ListArray.add(data);
				}
				String actRow12List = reportsRow12ListArray.toString();
				String expRow12List = "[Grand Total, , 66.00, 38.41, 66.00, 22.23, , 405.11, 170.45, 318.66, 53.23, , , , ]";
				*/
				
				System.out.println("************************************checkStockLedgerCustomizationReport********************************************");
			
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				System.out.println(actRow4List);
				System.out.println(expRow4List);
				
				System.out.println(actRow5List);
				System.out.println(expRow5List);
				
				System.out.println(actRow6List);
				System.out.println(expRow6List);
				
				System.out.println(actRow7List);
				System.out.println(expRow7List);
				
				System.out.println(actRow8List);
				System.out.println(expRow8List);
				
				System.out.println(actRow9List);
				System.out.println(expRow9List);
				
				System.out.println(actRow10List);
				System.out.println(expRow10List);
				
				System.out.println(actRow11List);
				System.out.println(expRow11List);
				
				/*System.out.println(actRow12List);
				System.out.println(expRow12List);*/
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_ReportCustomizeBtn));
				report_ReportCustomizeBtn.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CustomizationDeleteLayoutBtn));
				report_CustomizationDeleteLayoutBtn.click();
			
				getWaitForAlert();
				getAlert().accept();
				
				String expDeleteMessage = "Layout Deleted Successfully";
			    
			    String actDeleteMessage = checkValidationMessage(expDeleteMessage);
			    
			    Thread.sleep(4000);
			    
			    getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
			    
			    int reportsHeaderListCount = reportsHeaderList.size();
				ArrayList<String> reportsHeaderListArray = new ArrayList<String>();
				for(int i=0;i<reportsHeaderListCount;i++)
				{
					String data = reportsHeaderList.get(i).getText();
					reportsHeaderListArray.add(data);
				}
				String actHeaderList = reportsHeaderListArray.toString();
				String expHeaderList = "[#, Date, Voucher, Received, Issued, Balance, Received, Issued, Balance, Avg Rate, Alternate, Received Quantity, Rate, "
										+ "Issued Quantity, Rate, Balance Quantity, Value, Value, Value, Received Quantity, Issued Quantity, Balance Quantity]";
			    
			    System.out.println(actHeaderList);
			    System.out.println(expHeaderList);
			    
				if(actMessage.equalsIgnoreCase(expMessage)
					&& actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
					&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List) 
					&& actRow7List.equalsIgnoreCase(expRow7List) && actRow8List.equalsIgnoreCase(expRow8List) && actRow9List.equalsIgnoreCase(expRow9List) 
					&& actRow10List.equalsIgnoreCase(expRow10List) && actRow11List.equalsIgnoreCase(expRow11List) /*&& actRow12List.equalsIgnoreCase(expRow12List)*/ 
					&& actDeleteMessage.equalsIgnoreCase(expDeleteMessage)
					&& actHeaderList.equalsIgnoreCase(expHeaderList))
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
					report_CloseBtn.click();
					return true;
				}
				else
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
					report_CloseBtn.click();
					return false;
				}
			}
				

			
			@FindBy(xpath="//*[@id='dvReportInputs']/div[6]/label/span")
			private static WebElement sl_MovedItemsOnlyChkBox;
			
			
			
			
			
			public boolean checkStockLedgerReportWithMovedItemsOnlyAndIncludeServiceTypeItemsCheckBoxs() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_MovedItemsOnlyChkBox));
				sl_MovedItemsOnlyChkBox.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_IncludeServiceTypeItemChkBox));
				sl_IncludeServiceTypeItemChkBox.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
				sl_OkBtn.click();
				
				Thread.sleep(3000);
				
				int reportsRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsRow1ListArray.add(data);
				}
				String actRow1List = reportsRow1ListArray.toString();
				String expRow1List = "[WA COGS ITEM [WA COGS ITEM]]";
				

				int reportsRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsRow2ListArray.add(data);
				}
				String actRow2List = reportsRow2ListArray.toString();
				String expRow2List = "[Opening Balance, 24.00, , , , 24.00, , , 84.00, 3.50, , , ]";
				
				
				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[NDT57:SU/IND/TEXT5, 12.00, 10.50, , , 36.00, 126.00, , 210.00, 5.83, , , ]";
				
				
				
				int reportsRow4ListCount = reportsRow4List.size();
				ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow4ListCount;i++)
				{
					String data = reportsRow4List.get(i).getText();
					reportsRow4ListArray.add(data);
				}
				String actRow4List = reportsRow4ListArray.toString();
				String expRow4List = "[NDT57:SU/IND/TEXT5, 10.00, 10.50, , , 46.00, 105.00, , 315.00, 6.85, , , ]";
				
				
				
				int reportsRow5ListCount = reportsRow5List.size();
				ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow5ListCount;i++)
				{
					String data = reportsRow5List.get(i).getText();
					reportsRow5ListArray.add(data);
				}
				String actRow5List = reportsRow5ListArray.toString();
				String expRow5List = "[ExeStk:2, 10.00, 10.00, , , 56.00, 100.00, , 415.00, 7.41, , , ]";
				
				
				
				int reportsRow6ListCount = reportsRow6List.size();
				ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow6ListCount;i++)
				{
					String data = reportsRow6List.get(i).getText();
					reportsRow6ListArray.add(data);
				}
				String actRow6List = reportsRow6ListArray.toString();
				String expRow6List = "[StkTrf:2, , , 10.00, 7.41, 46.00, , 74.11, 340.89, 7.41, , , ]";
				
				
				
				int reportsRow7ListCount = reportsRow7List.size();
				ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow7ListCount;i++)
				{
					String data = reportsRow7List.get(i).getText();
					reportsRow7ListArray.add(data);
				}
				String actRow7List = reportsRow7ListArray.toString();
				String expRow7List = "[StkTrf:2, 10.00, 7.41, , , 56.00, 74.11, , 415.00, 7.41, , , ]";
				
				
				
				int reportsRow8ListCount = reportsRow8List.size();
				ArrayList<String> reportsRow8ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow8ListCount;i++)
				{
					String data = reportsRow8List.get(i).getText();
					reportsRow8ListArray.add(data);
				}
				String actRow8List = reportsRow8ListArray.toString();
				String expRow8List = "[NDT50:5, , , 3.00, 7.41, 53.00, , 22.23, 392.77, 7.41, , , ]";
				
				
				
				int reportsRow9ListCount = reportsRow9List.size();
				ArrayList<String> reportsRow9ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow9ListCount;i++)
				{
					String data = reportsRow9List.get(i).getText();
					reportsRow9ListArray.add(data);
				}
				String actRow9List = reportsRow9ListArray.toString();
				String expRow9List = "[NDT50:7, , , 10.00, 7.41, 43.00, , 74.11, 318.66, 7.41, , , ]";
				
				

				int reportsRow10ListCount = reportsRow10List.size();
				ArrayList<String> reportsRow10ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow10ListCount;i++)
				{
					String data = reportsRow10List.get(i).getText();
					reportsRow10ListArray.add(data);
				}
				String actRow10List = reportsRow10ListArray.toString();
				String expRow10List = "[Reserved stock, , , 43.00, , , , , , , , , ]";
				
				
				
				int reportsRow11ListCount = reportsRow11List.size();
				ArrayList<String> reportsRow11ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow11ListCount;i++)
				{
					String data = reportsRow11List.get(i).getText();
					reportsRow11ListArray.add(data);
				}
				String actRow11List = reportsRow11ListArray.toString();
				String expRow11List = "[Total, , 66.00, 38.41, 66.00, 22.23, , 405.11, 170.45, 318.66, 53.23, , , ]";
				
				
				/*
				int reportsRow12ListCount = reportsRow12List.size();
				ArrayList<String> reportsRow12ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow12ListCount;i++)
				{
					String data = reportsRow12List.get(i).getText();
					reportsRow12ListArray.add(data);
				}
				String actRow12List = reportsRow12ListArray.toString();
				String expRow12List = "[Grand Total, , 66.00, 38.41, 66.00, 22.23, , 405.11, 170.45, 318.66, 53.23, , , ]";
				*/
				
				System.out.println("************************checkStockLedgerReportWithMovedItemsOnlyAndIncludeServiceTypeItemsCheckBoxs********************************");
			
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				System.out.println(actRow4List);
				System.out.println(expRow4List);
				
				System.out.println(actRow5List);
				System.out.println(expRow5List);
				
				System.out.println(actRow6List);
				System.out.println(expRow6List);
				
				System.out.println(actRow7List);
				System.out.println(expRow7List);
				
				System.out.println(actRow8List);
				System.out.println(expRow8List);
				
				System.out.println(actRow9List);
				System.out.println(expRow9List);
				
				System.out.println(actRow10List);
				System.out.println(expRow10List);
				
				System.out.println(actRow11List);
				System.out.println(expRow11List);
				
				/*System.out.println(actRow12List);
				System.out.println(expRow12List);*/
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
					&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List) 
					&& actRow7List.equalsIgnoreCase(expRow7List) && actRow8List.equalsIgnoreCase(expRow8List) && actRow9List.equalsIgnoreCase(expRow9List) 
					&& actRow10List.equalsIgnoreCase(expRow10List) && actRow11List.equalsIgnoreCase(expRow11List) /*&& actRow12List.equalsIgnoreCase(expRow12List)*/)
				{
					return true;
				}
				else
				{
					return false;
				}
			}

			
		/*	@FindBy (xpath="/html/body/section/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div/nav/div/div/ul/li[7]/a/i")
			private static WebElement sl_BackTrackBtn;*/
			
			@FindBy (xpath="//*[@id='id_reportmenudisplay']/ul/li[7]")
			private static WebElement sl_BackTrackBtn;
			
			@FindBy (xpath="//*[@id='id_reportmenudisplay']/ul/li[8]")
			private static WebElement ml_BackTrackBtn;
			
			
			@FindBy (xpath="(//*[@id='navbarSupportedContent2']/ul/li/a/i)[3]")
			private static WebElement BackTrackItemDetailsBackBtn;
			
			@FindBy (xpath="(//*[@id='navbarSupportedContent2']/ul/li/a/i)[2]")
			private static WebElement BackTrackMonthDetailsBackBtn;
			
			@FindBy (xpath="(//*[@id='navbarSupportedContent2']/ul/li/a/i)[1]")
			private static WebElement BackTrackDateDetailsBackBtn;
			
			
			
			@FindBy (xpath="//*[@id='dvReportDetails']/div/table/tbody/tr/td[3]")
			private static List<WebElement> reportTableColumn2RowsList;
			
			public boolean checkStockLedgerReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				int reportItemGridListCount=reportTableColumn2RowsList.size();
			    for (int i = 1; i < reportItemGridListCount; i++) 
			    {
		             String data=reportTableColumn2RowsList.get(i).getText();
		             
		             System.err.println(data);
		             
		             if (data.equalsIgnoreCase("NDT57:SU/IND/TEXT5"))
		             {
		            	 reportTableColumn2RowsList.get(i).click();
		            	 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            	 report_BackTrackBtn.click();
		            	 Thread.sleep(3000);
		            	 
		            	
		            	try{
		            		 String m="Please select a row in the grid to Backtrack";
		            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
		            		 {
		            			 reportTableColumn2RowsList.get(i).click();
		            			 Thread.sleep(2000);
		            			 
		            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            			 report_BackTrackBtn.click();
		            			 Thread.sleep(3000);
		            	
		            		 }
		            	}
		            	catch(Exception e){
		            		System.out.println("message not displaying");
		            		
		            	}
		            	break;
	                 }
			    }
				
				Thread.sleep(1000);
				
				/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
				sl_BackTrackBtn.click();
				*/
				Thread.sleep(2000);
				
				ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
				
				int actOpenWindowsCount = getDriver().getWindowHandles().size();
				int expOpenWindowsCount = 2;

			 	getDriver().switchTo().window(openTabs.get(1));
			 	
			 	Thread.sleep(2000);
			 	
			 	checkValidationMessage("");
			 	
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
				String actDocNo = documentNumberTxt.getAttribute("value");
				String expDocNo = "SU/IND/TEXT5";
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(vendorAccountTxt));
				String actVendor = vendorAccountTxt.getAttribute("value");
				String expVendor = "Vendor B";
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(voucherHeaderCurrency));
				String actCurrency = voucherHeaderCurrency.getAttribute("value");
				String expCurrency = "INR";
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(departmentTxt));
				String actDepartment = departmentTxt.getAttribute("value");
				String expDepartment = "INDIA";
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(placeOFSupplyTxt));
				String actPlaceOfSupply = placeOFSupplyTxt.getAttribute("value");
				String expPlaceOfSupply = "Abu Dhabi";

				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(jurisdictionTxt));
				String actJurisdiction = jurisdictionTxt.getAttribute("value");
				String expJurisdiction = "DUBAI";

				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
				String actR1Warehouse = select1stRow_1stColumn.getText();
				String expR1Warehouse = "HYDERABAD";
				
				String actR1Item = select1stRow_2ndColumn.getText();
				String expR1Item = "WA COGS ITEM";
				
				String actR1TaxCode = select1stRow_3rdColumn.getText();
				String expR1TaxCode = "Standard Rated Purchase - Recoverable";
				
				String actR1PurchaseAccount = select1stRow_4thColumn.getText();
				String expR1PurchaseAccount = "WA COGS ACC INV";
				
				String actR1Units = select1stRow_5thColumn.getText();
				String expR1Units = "Pcs";
				
				String actR1Quantity = select1stRow_9thColumn.getText();
				String expR1Quantity = "12.00";
				
				String actR1Rate = select1stRow_11thColumn.getText();
				String expR1Rate = "10.00";
				
				String actR1Gross = select1stRow_12thColumn.getText();
				String expR1Gross = "120.00";
				
				String actR1RMA = select1stRow_19thColumn.getText();
				String expR1RMA = "RMA#R1PVVAT1,RMA#R1PVVAT2,RMA#R1PVVAT3,RMA#R1PVVAT4,RMA#R1PVVAT5,RMA#R1PVVAT6,RMA#R1PVVAT7,RMA#R1PVVAT8,RMA#R1PVVAT9,RMA#R1PVVAT10,RMA#R1PVVAT11,RMA#R1PVVAT12";

				
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
				String actR2Warehouse = select2ndRow_1stColumn.getText();
				String expR2Warehouse = "HYDERABAD";
				
				String actR2Item = select2ndRow_2ndColumn.getText();
				String expR2Item = "WA COGS ITEM";
				
				String actR2TaxCode = select2ndRow_3rdColumn.getText();
				String expR2TaxCode = "Standard Rated Purchase - Recoverable";
				
				String actR2PurchaseAccount = select2ndRow_4thColumn.getText();
				String expR2PurchaseAccount = "WA COGS ACC INV";
				
				String actR2Units = select2ndRow_5thColumn.getText();
				String expR2Units = "Pcs";
				
				String actR2Quantity = select2ndRow_9thColumn.getText();
				String expR2Quantity = "10.00";
				
				String actR2Rate = select2ndRow_11thColumn.getText();
				String expR2Rate = "10.00";
				
				String actR2Gross = select2ndRow_12thColumn.getText();
				String expR2Gross = "100.00";
				
				String actR2RMA = select2ndRow_19thColumn.getText();
				String expR2RMA = "RMA#R2PVVAT1,RMA#R2PVVAT2,RMA#R2PVVAT3,RMA#R2PVVAT4,RMA#R2PVVAT5,RMA#R2PVVAT6,RMA#R2PVVAT7,RMA#R2PVVAT8,RMA#R2PVVAT9,RMA#R2PVVAT10";

				System.out.println("*******************************checkStockLedgerReportBackTrackOption*********************************");
				
				System.out.println("OpenWindowsCount: "+actOpenWindowsCount+"  Value Expected  "+expOpenWindowsCount);
				
				System.out.println("Document No     : "+actDocNo			+"  Value Expected  "+expDocNo);
				System.out.println("Vendor          : "+actVendor			+"  Value Expected  "+expVendor);
				System.out.println("Currency        : "+actCurrency			+"  Value Expected  "+expCurrency);
				System.out.println("Department      : "+actDepartment		+"  Value Expected  "+expDepartment);
				System.out.println("PlaceOfSupply   : "+actPlaceOfSupply	+"  Value Expected  "+expPlaceOfSupply);
				System.out.println("Jurisdiction    : "+actJurisdiction		+"  Value Expected  "+expJurisdiction);
				
				System.out.println("*******************************ROW1**********************************");
				
				System.out.println("Warehouse       : "+actR1Warehouse			+"  Value Expected  "+expR1Warehouse);
				System.out.println("Item            : "+actR1Item				+"  Value Expected  "+expR1Item);
				System.out.println("TaxCode         : "+actR1TaxCode			+"  Value Expected  "+expR1TaxCode);
				System.out.println("PurchaseAccount : "+actR1PurchaseAccount	+"  Value Expected  "+expR1PurchaseAccount);
				System.out.println("Units           : "+actR1Units				+"  Value Expected  "+expR1Units);
				System.out.println("Quantity        : "+actR1Quantity			+"  Value Expected  "+expR1Quantity);
				System.out.println("Rate            : "+actR1Rate				+"  Value Expected  "+expR1Rate);
				System.out.println("Gross           : "+actR1Gross				+"  Value Expected  "+expR1Gross);
				System.out.println("RMA             : "+actR1RMA				+"  Value Expected  "+expR1RMA);
				
				System.out.println("*******************************ROW2**********************************");
				
				System.out.println("Warehouse       : "+actR2Warehouse			+"  Value Expected  "+expR2Warehouse);
				System.out.println("Item            : "+actR2Item				+"  Value Expected  "+expR2Item);
				System.out.println("TaxCode         : "+actR2TaxCode			+"  Value Expected  "+expR2TaxCode);
				System.out.println("PurchaseAccount : "+actR2PurchaseAccount	+"  Value Expected  "+expR2PurchaseAccount);
				System.out.println("Units           : "+actR2Units				+"  Value Expected  "+expR2Units);
				System.out.println("Quantity        : "+actR2Quantity			+"  Value Expected  "+expR2Quantity);
				System.out.println("Rate            : "+actR2Rate				+"  Value Expected  "+expR2Rate);
				System.out.println("Gross           : "+actR2Gross				+"  Value Expected  "+expR2Gross);
				System.out.println("RMA             : "+actR2RMA				+"  Value Expected  "+expR2RMA);
				
				
				getDriver().switchTo().window(openTabs.get(1)).close();
				
				Thread.sleep(1000);
				
				getDriver().switchTo().window(openTabs.get(0));
				
				if(actOpenWindowsCount==expOpenWindowsCount 
					&& actDocNo.equalsIgnoreCase(expDocNo) && actVendor.equalsIgnoreCase(expVendor) && actCurrency.equalsIgnoreCase(expCurrency) 
					&& actDepartment.equalsIgnoreCase(expDepartment) && actPlaceOfSupply.equalsIgnoreCase(expPlaceOfSupply) 
					&& actJurisdiction.equalsIgnoreCase(expJurisdiction) && actR1Warehouse.equalsIgnoreCase(expR1Warehouse) 
					&& actR1Item.equalsIgnoreCase(expR1Item) && actR1TaxCode.equalsIgnoreCase(expR1TaxCode) && actR1PurchaseAccount.equalsIgnoreCase(expR1PurchaseAccount) 
					&& actR1Units.equalsIgnoreCase(expR1Units) && actR1Quantity.equalsIgnoreCase(expR1Quantity) && actR1Rate.equalsIgnoreCase(expR1Rate) 
					&& actR1Gross.equalsIgnoreCase(expR1Gross) && actR1RMA.equalsIgnoreCase(expR1RMA) 
					&& actR2Warehouse.equalsIgnoreCase(expR2Warehouse) 
					&& actR2Item.equalsIgnoreCase(expR2Item) && actR2TaxCode.equalsIgnoreCase(expR2TaxCode) && actR2PurchaseAccount.equalsIgnoreCase(expR2PurchaseAccount) 
					&& actR2Units.equalsIgnoreCase(expR2Units) && actR2Quantity.equalsIgnoreCase(expR2Quantity) && actR2Rate.equalsIgnoreCase(expR2Rate) 
					&& actR2Gross.equalsIgnoreCase(expR2Gross) && actR2RMA.equalsIgnoreCase(expR2RMA))
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
					report_CloseBtn.click();
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
					sl_CloseBtn.click();
					return true;
				}
				else
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
					report_CloseBtn.click();
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
					sl_CloseBtn.click();
					return false;
				}
			}
			
			
			@FindBy(xpath="//*[@id='552']")
			private static WebElement openingStocksRegister;
			

			@FindBy(xpath="//*[@id='id_reportmenudisplay']/ul/li[13]")
			private static WebElement osr_CloseBtn;
			public boolean checkOpeningStockRegisterReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
				inventoryMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
				inventoryReportsMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(openingStocksRegister));
				openingStocksRegister.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
				Select s=new Select(sl_DateOptionDropdown);
				s.selectByIndex(1);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
				sl_OkBtn.click();
				
				Thread.sleep(3000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
				
				int reportsRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsRow1ListArray.add(data);
				}
				String actRow1List = reportsRow1ListArray.toString();
				String expRow1List = "[BR COGS ITEM, 12.00, 10.00, 10.00]";
				
				

				int reportsRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsRow2ListArray.add(data);
				}
				String actRow2List = reportsRow2ListArray.toString();
				String expRow2List = "[BR COGS ITEM, 24.00, 5.00, 10.00]";
			

				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[STD RATE COGS ITEM, 12.00, 10.00, 10.00]";
				
				
				
				int reportsRow4ListCount = reportsRow4List.size();
				ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow4ListCount;i++)
				{
					String data = reportsRow4List.get(i).getText();
					reportsRow4ListArray.add(data);
				}
				String actRow4List = reportsRow4ListArray.toString();
				String expRow4List = "[STD RATE COGS ITEM, 24.00, 5.00, 10.00]";
				
				
				
				int reportsRow5ListCount = reportsRow5List.size();
				ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow5ListCount;i++)
				{
					String data = reportsRow5List.get(i).getText();
					reportsRow5ListArray.add(data);
				}
				String actRow5List = reportsRow5ListArray.toString();
				String expRow5List = "[FIFO COGS ITEM, 12.00, 10.00, 10.00]";
				
				
				
				int reportsRow6ListCount = reportsRow6List.size();
				ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow6ListCount;i++)
				{
					String data = reportsRow6List.get(i).getText();
					reportsRow6ListArray.add(data);
				}
				String actRow6List = reportsRow6ListArray.toString();
				String expRow6List = "[FIFO COGS ITEM, 12.00, 5.00, 5.00]";
				
				
				
				int reportsRow7ListCount = reportsRow7List.size();
				ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow7ListCount;i++)
				{
					String data = reportsRow7List.get(i).getText();
					reportsRow7ListArray.add(data);
				}
				String actRow7List = reportsRow7ListArray.toString();
				String expRow7List = "[FIFO COGS ITEM, 12.00, 5.00, 5.00]";
				
				
				
				int reportsRow8ListCount = reportsRow8List.size();
				ArrayList<String> reportsRow8ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow8ListCount;i++)
				{
					String data = reportsRow8List.get(i).getText();
					reportsRow8ListArray.add(data);
				}
				String actRow8List = reportsRow8ListArray.toString();
				String expRow8List = "[WA COGS ITEM, 12.00, 5.00, 60.00]";
				
				
				int reportsRow9ListCount = reportsRow9List.size();
				ArrayList<String> reportsRow9ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow9ListCount;i++)
				{
					String data = reportsRow9List.get(i).getText();
					reportsRow9ListArray.add(data);
				}
				String actRow9List = reportsRow9ListArray.toString();
				String expRow9List = "[WA COGS ITEM, 12.00, 2.00, 24.00]";
				
				
				int reportsRow10ListCount = reportsRow10List.size();
				ArrayList<String> reportsRow10ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow10ListCount;i++)
				{
					String data = reportsRow10List.get(i).getText();
					reportsRow10ListArray.add(data);
				}
				String actRow10List = reportsRow10ListArray.toString();
				String expRow10List = "[Grand Total, , 132.00, 57.00, 144.00]";
				
				
				System.out.println("***************************checkOpenigStockRegisterReport*********************************");
				
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				System.out.println(actRow4List);
				System.out.println(expRow4List);
				
				System.out.println(actRow5List);
				System.out.println(expRow5List);
				
				System.out.println(actRow6List);
				System.out.println(expRow6List);
				
				System.out.println(actRow7List);
				System.out.println(expRow7List);
				
				System.out.println(actRow8List);
				System.out.println(expRow8List);
				
				System.out.println(actRow9List);
				System.out.println(expRow9List);
				
				System.out.println(actRow10List);
				System.out.println(expRow10List);
				
				Thread.sleep(1000);
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
						&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List)
						&& actRow7List.equalsIgnoreCase(expRow7List) && actRow8List.equalsIgnoreCase(expRow8List) && actRow9List.equalsIgnoreCase(expRow9List)
						&& actRow10List.equalsIgnoreCase(expRow10List))
				{
					return true;
				}
				else
				{
					if (actRow10List.equalsIgnoreCase(expRow10List)) 
					{
						return true;
					}
					else 
					{
						return false;
					}
				}
			}


			
			@FindBy(xpath="//*[@id='idFilterCustomizeIcon']")
			private static WebElement  report_FilterCustomizeBtn;
			
			@FindBy(xpath="//a[contains(text(),'Item')]//i")
			private static WebElement  report_FilterItemExpansion;
			
			@FindBy(xpath="(//*[@id='5021'])[1]")
			private static WebElement  report_FilterItemNameChkbox;
			
			@FindBy(xpath="(//*[@id='5021'])[1]/following-sibling::span")
			private static WebElement  report_FilterItemNameChkboxSelected;
			
			@FindBy(xpath="(//input[@class='FButton-Primary'])[1]")
			private static WebElement  reports_Filter_Customize_OkBtn;
			
			@FindBy(xpath="//input[@id='FOption_552_0_DefaultFilter_0']")
			private static WebElement  osr_DefaultFilterTxt;
			
			@FindBy(xpath="//span[@id='filterRefresh']")
			private static WebElement  report_Filter_RefreshBtn;
			
			@FindBy(xpath="//*[@id='filterRefresh']")
			private static WebElement  report_Filter_RefreshConditionBtn;
			
			@FindBy(xpath = "//*[@id='id_reportmenudisplay']/ul/li[10]")
			public static WebElement multireport_FilterExpandBtn;
			
			@FindBy(xpath = "//*[@id='id_reportmenudisplay']/ul/li[9]")
			public static WebElement report_FilterExpandBtn;
			
			@FindBy(xpath="//*[@id='filter_Okbtn_']")
			private static WebElement  report_FilterOkBtn;
			
			@FindBy(xpath="//i[contains(@class,'icon icon-close')]")
			private static WebElement  report_FilterCancelBtn;
			
			
			@FindBy(xpath="(//table[@class='CommonReportTable']/tbody)[1]/tr")
			private static List<WebElement> reportsRowsCount;
			
			@FindBy(xpath="//*[@id='FilterFields_552_0']/ul[2]/li[1]/div/label/span")
			private static WebElement osr_report_FilterItemNameChkbox;
			
			@FindBy(xpath="//*[@id='FilterFieldCust_552_0']/div/div[3]/input[1]")
			private static WebElement osr_reports_Filter_Customize_OkBtn;
			
			
			public boolean checkOpeningStockRegisterReportFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
				report_FilterExpandBtn.click();
				Thread.sleep(1000);
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
				report_FilterBtn.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
				report_FilterCustomizeBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemExpansion));
				report_FilterItemExpansion.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
				
				if (report_FilterItemNameChkbox.isSelected()==false) 
				{
					report_FilterItemNameChkboxSelected.click();
				}

				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
				reports_Filter_Customize_OkBtn.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(osr_DefaultFilterTxt));
				osr_DefaultFilterTxt.click();
				osr_DefaultFilterTxt.sendKeys("FIFO COGS ITEM");
				
				Thread.sleep(2000);
				
				osr_DefaultFilterTxt.sendKeys(Keys.TAB);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
				report_FilterOkBtn.click();
				
				Thread.sleep(3000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
				
				int reportsRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsRow1ListArray.add(data);
				}
				String actRow1List = reportsRow1ListArray.toString();
				String expRow1List = "[FIFO COGS ITEM, 12.00, 10.00, 10.00]";
				
				

				int reportsRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsRow2ListArray.add(data);
				}
				String actRow2List = reportsRow2ListArray.toString();
				String expRow2List = "[FIFO COGS ITEM, 12.00, 5.00, 5.00]";
			

				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[FIFO COGS ITEM, 12.00, 5.00, 5.00]";
				
				
				
				int reportsRow4ListCount = reportsRow4List.size();
				ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow4ListCount;i++)
				{
					String data = reportsRow4List.get(i).getText();
					reportsRow4ListArray.add(data);
				}
				String actRow4List = reportsRow4ListArray.toString();
				String expRow4List = "[Grand Total, , 36.00, 20.00, 20.00]";
				
				
				System.out.println("***************************checkOpeningStockRegisterReportFilterOption*********************************");
				
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				System.out.println(actRow4List);
				System.out.println(expRow4List);
				
				Thread.sleep(2000);
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
				report_FilterExpandBtn.click();
				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
				report_FilterBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
				report_FilterCustomizeBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
				
				if (report_FilterItemNameChkbox.isSelected()==true) 
				{
					report_FilterItemNameChkboxSelected.click();
				}

				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
				reports_Filter_Customize_OkBtn.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
				report_Filter_RefreshConditionBtn.click();

				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
				report_FilterOkBtn.click();
				
				Thread.sleep(2000);
				
				int actRowCount = reportsRowsCount.size();
				int expRowCount = 10; 
				
				System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
						&& actRow4List.equalsIgnoreCase(expRow4List) && actRowCount==expRowCount)
				{
					return true;
				}
				else
				{
					return false;
				}
			}

	    	
			
			
			
			@FindBy (xpath="(//div[@id='dvReportDetails']/div/table/tbody)[1]/tr/td[4]")
			private static List<WebElement> reportTableColumn3RowsList;
			
			
			
			public boolean checkOpeningStockRegisterReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				Thread.sleep(2000);
				int reportItemGridListCount=reportTableColumn2RowsList.size();
			    for (int i = 0; i < reportItemGridListCount; i++) 
			    {
		             String data=reportTableColumn2RowsList.get(i).getText();
		             String data1=reportTableColumn3RowsList.get(i).getText();
		             
		             System.err.println(data+"  "+data1);
		             
		             if (data.equalsIgnoreCase("BR COGS ITEM")/* && data1.equalsIgnoreCase("12.00")*/)
		             {
		            	 reportTableColumn2RowsList.get(i).click();
		            	 
		            	 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            	 report_BackTrackBtn.click();
		            	 Thread.sleep(3000);
		            	 
		            	
		            	try{
		            		 String m="Please select a row in the grid to Backtrack";
		            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
		            		 {
		            			 reportTableColumn2RowsList.get(i).click();
		            			 Thread.sleep(2000);
		            			 
		            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            			 report_BackTrackBtn.click();
		            			 Thread.sleep(3000);
		            	
		            		 }
		            	}
		            	catch(Exception e){
		            		System.out.println("message not displaying");
		            		
		            	}
		            	break;
	            		
	                 }
			    }
				
				Thread.sleep(3000);
				
				/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
				sl_BackTrackBtn.click();
				Thread.sleep(2000);*/
				
				ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
				
				int actOpenWindowsCount = getDriver().getWindowHandles().size();
				int expOpenWindowsCount = 2;

			 	getDriver().switchTo().window(openTabs.get(1));
			 	
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
				String actDocNo=documentNumberTxt.getAttribute("value");
				String expDocNo="1";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(warehouseTxt));
				String actWarehouse=warehouseTxt.getAttribute("value");
				String expWarehouse="HYDERABAD";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
				String actItem=select1stRow_1stColumn.getText();
				String expItem="BR COGS ITEM";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
				String actUnits=select1stRow_2ndColumn.getText();
				String expUnits="Dozs";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
				String actQuantity=select1stRow_3rdColumn.getText();
				String expQuantity="2.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
				String actRate=select1stRow_4thColumn.getText();
				String expRate="5.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_5thColumn));
				String actGross=select1stRow_5thColumn.getText();
				String expGross="10.00";
				

				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_6thColumn));
				String actBatch=select1stRow_6thColumn.getText();
				String expBatch="Batch#OSVR1";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_8thColumn));
				String actExpiryDate=select1stRow_8thColumn.getText();
				
				/*DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal=Calendar.getInstance();
				cal.add(Calendar.DAY_OF_WEEK, 5); 
				String expExpiryDate=df.format(cal.getTime());*/
				
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat todayDate = new SimpleDateFormat("dd/MM/yyyy");
				String currentDate = todayDate.format(cal.getTime());
				String expExpiryDate=currentDate;
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
				String actItem2=select2ndRow_1stColumn.getText();
				String expItem2="BR COGS ITEM";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_2ndColumn));
				String actUnits2=select2ndRow_2ndColumn.getText();
				String expUnits2="Dozs";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_3rdColumn));
				String actQuantity2=select2ndRow_3rdColumn.getText();
				String expQuantity2="1.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_4thColumn));
				String actRate2=select2ndRow_4thColumn.getText();
				String expRate2="10.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_5thColumn));
				String actGross2=select2ndRow_5thColumn.getText();
				String expGross2="10.00";
				

				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_6thColumn));
				String actBatch2=select2ndRow_6thColumn.getText();
				String expBatch2="Batch#OSVR2";
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_8thColumn));
				String actExpiryDate2=select2ndRow_8thColumn.getText();
				
				Calendar cal2=Calendar.getInstance();
				cal2.add(Calendar.DAY_OF_WEEK, 7); 
				
				//String expExpiryDate2=df.format(cal2.getTime());
				String expExpiryDate2=currentDate;
				
				System.out.println("**********************checkOpeningStockRegisterReportBackTrackOption*********************");
				
				
				System.out.println("*********** OpenWindowsCount : "+actOpenWindowsCount+"  value expected  "+expOpenWindowsCount);
				System.out.println("*********** Voucher No : "+actDocNo      +"  value expected  "+expDocNo);
				System.out.println("*********** Warehouse  : "+actWarehouse  +"  value expected  "+expWarehouse);
				System.out.println("*********** Item       : "+actItem       +"  value expected  "+expItem);
				System.out.println("*********** Units      : "+actUnits      +"  value expected  "+expUnits);
				System.out.println("*********** Quantity   : "+actQuantity   +"  value expected  "+expQuantity);
				System.out.println("*********** Rate       : "+actRate       +"  value expected  "+expRate);
				System.out.println("*********** Gross      : "+actGross      +"  value expected  "+expGross);
				System.out.println("*********** Batch      : "+actBatch      +"  value expected  "+expBatch);
				System.out.println("*********** ExpiryDate : "+actExpiryDate +"  value expected  "+expExpiryDate);
				System.out.println("*********** Item2       : "+actItem2       +"  value expected  "+expItem2);
				System.out.println("*********** Units2      : "+actUnits2      +"  value expected  "+expUnits2);
				System.out.println("*********** Quantity2   : "+actQuantity2   +"  value expected  "+expQuantity2);
				System.out.println("*********** Rate2       : "+actRate2       +"  value expected  "+expRate2);
				System.out.println("*********** Gross2      : "+actGross2      +"  value expected  "+expGross2);
				System.out.println("*********** Batch2      : "+actBatch2      +"  value expected  "+expBatch2);
				System.out.println("*********** ExpiryDate2 : "+actExpiryDate2 +"  value expected  "+expExpiryDate2);
			 	
				getDriver().switchTo().window(openTabs.get(1)).close();
				
				Thread.sleep(1000);
				
				getDriver().switchTo().window(openTabs.get(0));
				
				if(actOpenWindowsCount==expOpenWindowsCount
					 && actDocNo.equalsIgnoreCase(expDocNo) && actWarehouse.equalsIgnoreCase(expWarehouse) && actItem.equalsIgnoreCase(expItem) 
					 && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actRate.equalsIgnoreCase(expRate)
					 && actGross.equalsIgnoreCase(expGross) && actBatch.equalsIgnoreCase(expBatch) && actExpiryDate.equalsIgnoreCase(expExpiryDate)
					 && actItem2.equalsIgnoreCase(expItem2) && actUnits2.equalsIgnoreCase(expUnits2) && actQuantity2.equalsIgnoreCase(expQuantity2) 
					 && actRate2.equalsIgnoreCase(expRate2) && actGross2.equalsIgnoreCase(expGross2) && actBatch2.equalsIgnoreCase(expBatch2) 
					 && actExpiryDate2.equalsIgnoreCase(expExpiryDate2))
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
					report_CloseBtn.click();
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
					sl_CloseBtn.click();
					return true;
				}
				else
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
					report_CloseBtn.click();
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
					sl_CloseBtn.click();
					return false;
				}
			}
			
			
			@FindBy(xpath="//*[@id='navigation_menu']/li[3]/ul/li[3]/ul/li[5]")
			private static WebElement stockStatement;
			
			public boolean checkStockStatementReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
				inventoryMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
				inventoryReportsMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockStatement));
				stockStatement.click();
				
				Thread.sleep(2000);
				
				int rowcount=stockLedgerHometableRowCount.size();
				
				System.out.println(rowcount);
				
				for (int i = 1; i <= rowcount; i++) 
				{
					String actName = stockLedgerHometableItemNamesList.get(i).getText();
					
					System.out.println(actName);
					
					if(actName.equalsIgnoreCase("BR COGS ITEM"))
					{
						stockLedgerHometableItemChkboxList.get(i).click();
						break;
					}
				}
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
				Select s=new Select(sl_DateOptionDropdown);
				s.selectByIndex(1);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
				sl_OkBtn.click();
				
				Thread.sleep(3000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));

				int reportsRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsRow1ListArray.add(data);
				}
				String actRow1List = reportsRow1ListArray.toString();
				String expRow1List = "[BR COGS ITEM [BR COGS ITEM]]";
				

				
				int reportsRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsRow2ListArray.add(data);
				}
				String actRow2List = reportsRow2ListArray.toString();
				String expRow2List = "[36.00, 60.00, 34.00, 62.00, 42.75, , , , ]";
			

				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[Total, 36.00, 60.00, 34.00, 62.00, 42.75, , , , ]";
				
				
				System.out.println("***************************checkStockStatementReport*********************************");
				
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				Thread.sleep(2000);
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List))
				{
					return true;
				}
				else
				{
					return false;
				}
			}

			@FindBy (xpath="(//*[@class='icon-print hiconright2'])[2]")
			private static WebElement sl_ReportPrintBtn;
			
			
			@FindBy (xpath="(//*[@class='icon-print hiconright2'])[2]")
			private static WebElement sr_ReportPrintBtn;
			
			
			@FindBy(xpath="(//*[@id='MCustomize_DeleteField_ModalLabel'])[1]")
			private static WebElement ss_ReportPrintLabel;
			
			@FindBy(xpath="//*[@id='lblConfirmMessage']")
			private static WebElement ss_ReportPrintMsg;
			
			@FindBy(xpath="//*[@id='dvConfirm']//div[3]//input[1]")
			private static WebElement ss_ReportPrintYesBtn;
			
			
			
			public boolean checkStockStatementReportPrintOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sr_ReportPrintBtn));
				sr_ReportPrintBtn.click();
				Thread.sleep(3000);
				
				/*getWaitForAlert();
				Thread.sleep(2000);
				getAlert().accept();
				*/
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintLabel));
				
				String actConfirmMsg=ss_ReportPrintMsg.getText();
				String expConfirmMsg="";
				Thread.sleep(2000);
				
				System.out.println("Actual Msg		:		"+	actConfirmMsg		+ "Expected		"	+	expConfirmMsg);
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintYesBtn));
				ss_ReportPrintYesBtn.click();
				
				Thread.sleep(3000);
				
				ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
				
				int actOpenWindowsCount = getDriver().getWindowHandles().size();
				int expOpenWindowsCount = 2;

			 	getDriver().switchTo().window(openTabs.get(0));
			 	
			 	Thread.sleep(1000);
			 	
			 	getDriver().switchTo().window(openTabs.get(1)).close();
			 	
			 	getDriver().switchTo().window(openTabs.get(0));
				
				System.out.println("***************************checkStockStatementReportPrintOption*********************************");
				
				System.out.println("openTabs"+openTabs);
				System.out.println("Open Tabs Count : "+actOpenWindowsCount+"  Value Expected  "+expOpenWindowsCount);
				
				Thread.sleep(1000);
				
				if(actOpenWindowsCount==expOpenWindowsCount)
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn1));
					report_CloseBtn1.click();
					return true;
				}
				else
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn1));
					report_CloseBtn1.click();
					return false;
				}
			}

			
			public boolean checkStockStatementReportWithIncludeServiceTypeItem() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				Thread.sleep(2000);
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_IncludeServiceTypeItemChkBox));
				sl_IncludeServiceTypeItemChkBox.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
				sl_OkBtn.click();
				
				Thread.sleep(3000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));

				int reportsRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsRow1ListArray.add(data);
				}
				String actRow1List = reportsRow1ListArray.toString();
				String expRow1List = "[BR COGS ITEM [BR COGS ITEM]]";
				

				
				int reportsRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
				for(int i=2;i<reportsRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsRow2ListArray.add(data);
				}
				String actRow2List = reportsRow2ListArray.toString();
				String expRow2List = "[36.00, 60.00, 34.00, 62.00, 42.75, , , , ]";
			

				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[Total, 36.00, 60.00, 34.00, 62.00, 42.75, , , , ]";
				
				
				System.out.println("***************************checkStockStatementReport*********************************");
				
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				Thread.sleep(2000);
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List))
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn1));
					report_CloseBtn1.click();
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
					sl_CloseBtn.click();
					return true;
				}
				else
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn1));
					report_CloseBtn1.click();
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
					sl_CloseBtn.click();
					return false;
				}
			}

			
			@FindBy(xpath="//*[@id='navigation_menu']/li[3]/ul/li[3]/ul/li[6]")
			private static WebElement stockMovement;

			public boolean checkStockMovementReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getDriver().navigate().refresh();
				Thread.sleep(2000);
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
				inventoryMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
				inventoryReportsMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockMovement));
				stockMovement.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_HeaderSelectChkBox));
				sl_HeaderSelectChkBox.click();
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
				Select s=new Select(sl_DateOptionDropdown);
				s.selectByIndex(1);
			
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
				sl_OkBtn.click();
				
				Thread.sleep(3000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
				
				int reportsByWarehouseRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsByWarehouseRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsByWarehouseRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsByWarehouseRow1ListArray.add(data);
				}
				String actRow1List = reportsByWarehouseRow1ListArray.toString();
				String expRow1List = "[WA COGS ITEM, 24.00, 84.00, 42.00, 405.11, 23.00, 170.45, 43.00, 318.66, 7.41, , , ]";
				
				

				int reportsByWarehouseRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsByWarehouseRow2ListArray = new ArrayList<String>();
				for(int i=1;i<reportsByWarehouseRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsByWarehouseRow2ListArray.add(data);
				}
				String actRow2List = reportsByWarehouseRow2ListArray.toString();
				String expRow2List = "[FIFO COGS ITEM, 36.00, 20.00, 57.00, 46.50, 24.00, 10.00, 69.00, 56.50, 0.82, , , ]";
				
				
				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[BR COGS ITEM, 36.00, 20.00, 60.00, 51.50, 34.00, 28.75, 62.00, 42.75, 0.69, , , ]";
				
				
				
				int reportsRow4ListCount = reportsRow4List.size();
				ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow4ListCount;i++)
				{
					String data = reportsRow4List.get(i).getText();
					reportsRow4ListArray.add(data);
				}
				String actRow4List = reportsRow4ListArray.toString();
				String expRow4List = "[STD RATE COGS ITEM, 36.00, 20.00, 96.00, 344.50, 36.00, 595.50, 96.00, 960.00, 10.00, , , ]";
				
				
				
				int reportsRow5ListCount = reportsRow5List.size();
				ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow5ListCount;i++)
				{
					String data = reportsRow5List.get(i).getText();
					reportsRow5ListArray.add(data);
				}
				String actRow5List = reportsRow5ListArray.toString();
				String expRow5List = "[Grand Total, 132.00, 144.00, 255.00, 847.61, 117.00, 386.30, 270.00, 1,377.91, 18.92, , , ]";
				
				System.out.println("*********************************checkStockMovementReport*****************************************");
				
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				System.out.println(actRow4List);
				System.out.println(expRow4List);
				
				System.out.println(actRow5List);
				System.out.println(expRow5List);
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
					&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
					report_CloseBtn.click();
					return true;
				}
				else
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
					report_CloseBtn.click();
					return false;
				}
			}
			
			
			
			
			
			@FindBy (xpath="//select[@id='RITCombobox__1']")
			private static WebElement stockMovementDropdown;
			
			
			
			public boolean checkStockMovementReportsWithStockMovementByWarehouseAndIncludeServiceTypeItemOptions() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
		        getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockMovementDropdown));
				
				Select sm=new Select(stockMovementDropdown);
				sm.selectByIndex(1);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_IncludeServiceTypeItemChkBox));
				sl_IncludeServiceTypeItemChkBox.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
				sl_OkBtn.click();
				
				Thread.sleep(3000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
				
				int reportsRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsRow1ListArray.add(data);
				}
				String actRow1List = reportsRow1ListArray.toString();
				String expRow1List = "[HYDERABAD]";
				
				

				int reportsRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsRow2ListArray.add(data);
				}
				String actRow2List = reportsRow2ListArray.toString();
				String expRow2List = "[WA COGS ITEM, 24.00, 84.00, 32.00, 331.00, 13.00, 96.34, 43.00, 318.66, 7.41, , , ]";
				
				
				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[FIFO COGS ITEM, 36.00, 20.00, 48.00, 41.50, 15.00, 6.25, 69.00, 55.25, 0.80, , , ]";
				
				
				
				int reportsRow4ListCount = reportsRow4List.size();
				ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow4ListCount;i++)
				{
					String data = reportsRow4List.get(i).getText();
					reportsRow4ListArray.add(data);
				}
				String actRow4List = reportsRow4ListArray.toString();
				String expRow4List = "[BR COGS ITEM, 36.00, 20.00, 48.00, 41.50, 22.00, 18.75, 62.00, 42.75, 0.69, , , ]";
				
				
				
				int reportsRow5ListCount = reportsRow5List.size();
				ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow5ListCount;i++)
				{
					String data = reportsRow5List.get(i).getText();
					reportsRow5ListArray.add(data);
				}
				String actRow5List = reportsRow5ListArray.toString();
				String expRow5List = "[STD RATE COGS ITEM, 36.00, 20.00, 84.00, 224.50, 24.00, 27.67, 96.00, 216.83, 2.26, , , ]";
				
				
				
				int reportsRow6ListCount = reportsRow6List.size();
				ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow6ListCount;i++)
				{
					String data = reportsRow6List.get(i).getText();
					reportsRow6ListArray.add(data);
				}
				String actRow6List = reportsRow6ListArray.toString();
				String expRow6List = "[Sub Total, 132.00, 144.00, 212.00, 638.50, 74.00, 149.01, 270.00, 633.49, 11.16, , , ]";
				
				
				
				int reportsRow7ListCount = reportsRow7List.size();
				ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow7ListCount;i++)
				{
					String data = reportsRow7List.get(i).getText();
					reportsRow7ListArray.add(data);
				}
				String actRow7List = reportsRow7ListArray.toString();
				String expRow7List = "[SECUNDERABAD]";
				
				
				
				int reportsRow8ListCount = reportsRow8List.size();
				ArrayList<String> reportsRow8ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow8ListCount;i++)
				{
					String data = reportsRow8List.get(i).getText();
					reportsRow8ListArray.add(data);
				}
				String actRow8List = reportsRow8ListArray.toString();
				String expRow8List = "[WA COGS ITEM, , , 10.00, 74.11, 10.00, 74.11, , , , , , ]";
				
				
				
				int reportsRow9ListCount = reportsRow9List.size();
				ArrayList<String> reportsRow9ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow9ListCount;i++)
				{
					String data = reportsRow9List.get(i).getText();
					reportsRow9ListArray.add(data);
				}
				String actRow9List = reportsRow9ListArray.toString();
				String expRow9List = "[FIFO COGS ITEM, , , 9.00, 5.00, 9.00, 5.00, , , , , , ]";
				
				
				
				int reportsRow10ListCount = reportsRow10List.size();
				ArrayList<String> reportsRow10ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow10ListCount;i++)
				{
					String data = reportsRow10List.get(i).getText();
					reportsRow10ListArray.add(data);
				}
				String actRow10List = reportsRow10ListArray.toString();
				String expRow10List = "[BR COGS ITEM, , , 12.00, 10.00, 12.00, 10.00, , , , , , ]";
				
				
				
				int reportsRow11ListCount = reportsRow11List.size();
				ArrayList<String> reportsRow11ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow11ListCount;i++)
				{
					String data = reportsRow11List.get(i).getText();
					reportsRow11ListArray.add(data);
				}
				String actRow11List = reportsRow11ListArray.toString();
				String expRow11List = "[STD RATE COGS ITEM, , , 12.00, 120.00, 12.00, 120.00, , , , , , ]";
				
				
				
				int reportsRow12ListCount = reportsRow12List.size();
				ArrayList<String> reportsRow12ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow12ListCount;i++)
				{
					String data = reportsRow12List.get(i).getText();
					reportsRow12ListArray.add(data);
				}
				String actRow12List = reportsRow12ListArray.toString();
				String expRow12List = "[Sub Total, , , 43.00, 209.11, 43.00, 209.11, , , , , , ]";
				
				
				
				int reportsRow13ListCount = reportsRow13List.size();
				ArrayList<String> reportsRow13ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow13ListCount;i++)
				{
					String data = reportsRow13List.get(i).getText();
					reportsRow13ListArray.add(data);
				}
				String actRow13List = reportsRow13ListArray.toString();
				String expRow13List = "[Grand Total, 132.00, 144.00, 255.00, 847.61, 117.00, 358.11, 270.00, 633.49, 11.16, , , ]";
				
				
				System.out.println("********************checkStockMovementReportsWithStockMovementByWarehouseAndIncludeServiceTypeItemOptions**********************");

				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				System.out.println(actRow4List);
				System.out.println(expRow4List);
				
				System.out.println(actRow5List);
				System.out.println(expRow5List);
				
				System.out.println(actRow6List);
				System.out.println(expRow6List);
				
				System.out.println(actRow7List);
				System.out.println(expRow7List);
				
				System.out.println(actRow8List);
				System.out.println(expRow8List);
				
				System.out.println(actRow9List);
				System.out.println(expRow9List);
				
				System.out.println(actRow10List);
				System.out.println(expRow10List);
				
				System.out.println(actRow11List);
				System.out.println(expRow11List);
				
				System.out.println(actRow12List);
				System.out.println(expRow12List);
				
				System.out.println(actRow13List);
				System.out.println(expRow13List);
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
					&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List) 
					&& actRow7List.equalsIgnoreCase(expRow7List) && actRow8List.equalsIgnoreCase(expRow8List) && actRow9List.equalsIgnoreCase(expRow9List) 
					&& actRow10List.equalsIgnoreCase(expRow10List) && actRow11List.equalsIgnoreCase(expRow11List) && actRow12List.equalsIgnoreCase(expRow12List) 
					&& actRow13List.equalsIgnoreCase(expRow13List))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
			
			
			
			@FindBy (xpath="//a[contains(text(),' Warehouse')]//i")
			private static WebElement report_FilterWarehouseExpandBtn;
			
			@FindBy(xpath="//input[@id='5058']")
			private static WebElement report_FilterWarehouseNameChkbox;

			@FindBy(xpath="//input[@id='5058']/following-sibling::span")
			private static WebElement report_FilterWarehouseNameChkboxSelected;
			
			
			@FindBy (xpath="//*[@id='FilterFields_582_0']/ul[5]/li[1]/div/label")
			private static WebElement sa_report_FilterWarehouseNameChkbox;
			
			@FindBy (xpath="//input[@id='FOption_575_0_DefaultFilter_0']")
			private static WebElement sMovement_DefaultFilterTxt;
			
			@FindBy (xpath="(//*[@id='FilterFields_575_0']/ul[5]/li[1]/div/label)[1]")
			private static WebElement smreport_FilterWarehouseNameChkbox;

			
			
			public boolean checkStockMovementReportWithFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				Thread.sleep(2000);
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
				report_FilterExpandBtn.click();
				Thread.sleep(2000);
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
				report_FilterBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
				report_FilterCustomizeBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseExpandBtn));
				report_FilterWarehouseExpandBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseNameChkboxSelected));
				
				if (report_FilterWarehouseNameChkbox.isSelected()==false) 
				{
					report_FilterWarehouseNameChkboxSelected.click();
				}

				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
				reports_Filter_Customize_OkBtn.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sMovement_DefaultFilterTxt));
				sMovement_DefaultFilterTxt.click();
				sMovement_DefaultFilterTxt.sendKeys("Hyderabad");
				
				Thread.sleep(2000);
				
				sMovement_DefaultFilterTxt.sendKeys(Keys.TAB);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
				report_FilterOkBtn.click();
				
				Thread.sleep(2000);
			
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));

				int reportsRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsRow1ListArray.add(data);
				}
				String actRow1List = reportsRow1ListArray.toString();
				String expRow1List = "[HYDERABAD]";
				
				

				int reportsRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsRow2ListArray.add(data);
				}
				String actRow2List = reportsRow2ListArray.toString();
				String expRow2List = "[WA COGS ITEM, 24.00, 84.00, 32.00, 331.00, 13.00, 96.34, 43.00, 318.66, 7.41, , , ]";
				
				
				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[FIFO COGS ITEM, 36.00, 20.00, 48.00, 41.50, 15.00, 6.25, 69.00, 55.25, 0.80, , , ]";
				
				
				
				int reportsRow4ListCount = reportsRow4List.size();
				ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow4ListCount;i++)
				{
					String data = reportsRow4List.get(i).getText();
					reportsRow4ListArray.add(data);
				}
				String actRow4List = reportsRow4ListArray.toString();
				String expRow4List = "[BR COGS ITEM, 36.00, 20.00, 48.00, 41.50, 22.00, 18.75, 62.00, 42.75, 0.69, , , ]";
				
				
				
				int reportsRow5ListCount = reportsRow5List.size();
				ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow5ListCount;i++)
				{
					String data = reportsRow5List.get(i).getText();
					reportsRow5ListArray.add(data);
				}
				String actRow5List = reportsRow5ListArray.toString();
				String expRow5List = "[STD RATE COGS ITEM, 36.00, 20.00, 84.00, 224.50, 24.00, 27.67, 96.00, 216.83, 2.26, , , ]";
				
				
				
				int reportsRow6ListCount = reportsRow6List.size();
				ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow6ListCount;i++)
				{
					String data = reportsRow6List.get(i).getText();
					reportsRow6ListArray.add(data);
				}
				String actRow6List = reportsRow6ListArray.toString();
				String expRow6List = "[Grand Total, 132.00, 144.00, 212.00, 638.50, 74.00, 149.01, 270.00, 633.49, 11.16, , , ]";
				
				System.out.println("****************************checkStockMovementReportWithFilterOption******************************");
				
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				System.out.println(actRow4List);
				System.out.println(expRow4List);
				
				System.out.println(actRow5List);
				System.out.println(expRow5List);
				
				System.out.println(actRow6List);
				System.out.println(expRow6List);
				
				Thread.sleep(1000);
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
				report_FilterExpandBtn.click();
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
				report_FilterBtn.click();
				
				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
				report_FilterCustomizeBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseNameChkboxSelected));
				
				if (report_FilterWarehouseNameChkbox.isSelected()==true) 
				{
					report_FilterWarehouseNameChkboxSelected.click();
				}

				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
				reports_Filter_Customize_OkBtn.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
				report_Filter_RefreshConditionBtn.click();

				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
				report_FilterOkBtn.click();
				
				Thread.sleep(2000);
				
				int actRowCount = reportsRowsCount.size();
				int expRowCount = 13; 
				
				System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
				
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
					&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List) 
					&& actRowCount==expRowCount)
				{
					return true;
				} 
				else 
				{
					return false;
				}
			}
			
			
			
		/*	
			@FindBy (xpath="//div[@id='dvReportRenderBacktracking']/div[1]/div[1]/div[2]/table/tbody/tr/td")
			private static List<WebElement> backTrackItemDetailsMonthsTableList;
			
			@FindBy (xpath="//div[@id='dvReportRenderBacktracking']/div[1]/div[1]/div[2]/table")
			private static WebElement backTrackItemDetailsMonthsTable;
			
			@FindBy (xpath="//div[@id='dvReportRenderBacktracking']/div[1]/div[1]/div[2]/table/tbody/tr[1]/td[1]")
			private static WebElement backTrackItemDetailsMonths1stRow1stCol;
			
			@FindBy (xpath="//div[@id='dvReportRenderBacktracking']/div[1]/div[1]/div[2]/table/tbody/tr[2]/td[1]")
			private static WebElement backTrackItemDetailsMonths2ndRow1stCol;
			
			
			@FindBy (xpath="//div[@id='dvReportRenderBacktracking']/div[2]/div[1]/div[2]/table/tbody/tr/td")
			private static List<WebElement> backTrackItemDetailsDaysTableList;
			
			@FindBy (xpath="//div[@id='dvReportRenderBacktracking']/div[2]/div[1]/div[2]/table")
			private static WebElement backTrackItemDetailsDaysTable;
		
			@FindBy (xpath="//div[@id='dvReportRenderBacktracking']/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]")
			private static WebElement backTrackItemDetailsDays1stRow1stCol;
			
			
			
			@FindBy (xpath="//div[@id='dvReportRenderBacktracking']/div[3]/div[1]/div[2]/table/tbody/tr/td")
			private static List<WebElement> backTrackItemDetailsVouchersTableList;
			
			@FindBy (xpath="//div[@id='dvReportRenderBacktracking']/div[3]/div[1]/div[2]/table")
			private static WebElement backTrackItemDetailsVouchersTable;
			
			@FindBy (xpath="//div[@id='dvReportRenderBacktracking']/div[3]/div[1]/div[2]/table/tbody/tr[1]/td[1]")
			private static WebElement backTrackItemDetailsVouchers1stRow1stCol;
			*/
			
			
			
			
			public boolean checkStockMovementReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				int reportItemGridListCount=reportTableColumn1RowsList.size();
			    for (int i = 0; i < reportItemGridListCount; i++) 
			    {
		             String data=reportTableColumn1RowsList.get(i).getText();
		             
		             if (data.equalsIgnoreCase("HYDERABAD"))
		             {
	                     int count =i+5;
	                     
	                     for (int j = i; j < count; j++) 
	         		     {
	                    	 String data1=reportTableColumn1RowsList.get(j).getText();
				             
	                    	 if (data1.equalsIgnoreCase("FIFO COGS ITEM"))
	                         {
	                    		 System.err.println("Item Name : "+data1);
	                    		 reportTableColumn1RowsList.get(j).click();
	                    		 Thread.sleep(2000);
	                    		 break;
	                         }
	         		     }
		             }
			      }

				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
				sl_BackTrackBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
				
				int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
				ArrayList<String> actMonthlyList = new ArrayList<String>();
				for(int i=0; i<backTrackMonthlyColumnsCount; i++)
				{
					String data = backTrackItemDetailsMonthsTableList.get(i).getText();
					actMonthlyList.add(data);
				}
				
				Calendar cal=Calendar.getInstance();
				DateFormat df = new SimpleDateFormat("MMMM yyyy");
				String Row2Month = df.format(cal.getTime());
				
				ArrayList<String> expMonthlyList = new ArrayList<String>();
				expMonthlyList.add("January 2020");
				expMonthlyList.add("");
				expMonthlyList.add("36.00");
				expMonthlyList.add("");
				expMonthlyList.add("36.00");
				expMonthlyList.add(Row2Month);
				expMonthlyList.add("36.00");
				expMonthlyList.add("57.00");
				expMonthlyList.add("24.00");
				expMonthlyList.add("69.00");
				expMonthlyList.add("");
				expMonthlyList.add("");
				expMonthlyList.add("93.00");
				expMonthlyList.add("24.00");
				expMonthlyList.add("");
				
				System.out.println(actMonthlyList);
				System.out.println(expMonthlyList);
				
				
				for(int i=0; i<backTrackMonthlyColumnsCount; i++)
				{
					String data = backTrackItemDetailsMonthsTableList.get(i).getText();
					
					if (data.equalsIgnoreCase("January 2020")) 
					{
						getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
						break;
					}
				}
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
				
				int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
				ArrayList<String> actDayList = new ArrayList<String>();
				for(int i=0; i<backTrackDayColumnsCount; i++)
				{
					String data = backTrackItemDetailsDaysTableList.get(i).getText();
					actDayList.add(data);
				}
				
				ArrayList<String> expDayList = new ArrayList<String>();
				expDayList.add("1");
				expDayList.add("");
				expDayList.add("36.00");
				expDayList.add("");
				expDayList.add("36.00");
				expDayList.add("");
				expDayList.add("");
				expDayList.add("36.00");
				expDayList.add("");
				expDayList.add("");
				
				System.out.println(actDayList);
				System.out.println(expDayList);
				
				for(int i=0; i<backTrackDayColumnsCount; i++)
				{
					String data = backTrackItemDetailsDaysTableList.get(i).getText();
					
					if (data.equalsIgnoreCase("1")) 
					{
						getAction().doubleClick().build().perform();
						break;
					}
				}
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
				
				int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
				ArrayList<String> actVouchersList = new ArrayList<String>();
				for(int i=0; i<backTrackVouchersColumnsCount; i++)
				{
					String data = backTrackItemDetailsVouchersTableList.get(i).getText();
					actVouchersList.add(data);
				}
				
				ArrayList<String> expVouchersList = new ArrayList<String>();
				expVouchersList.add("OpeStk:3");
				expVouchersList.add("");
				expVouchersList.add("36.00");
				expVouchersList.add("");
				expVouchersList.add("36.00");
				expVouchersList.add("");
				expVouchersList.add("");
				expVouchersList.add("36.00");
				expVouchersList.add("");
				expVouchersList.add("");
				
				System.out.println(actVouchersList);
				System.out.println(expVouchersList);
				
				for(int i=0; i<backTrackVouchersColumnsCount; i++)
				{
					String data = backTrackItemDetailsVouchersTableList.get(i).getText();

					if (data.equalsIgnoreCase("OpeStk:3")) 
					{
						getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
						break;
					}
				}
				
				Thread.sleep(2000);
				
				ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
				
				int actOpenWindowsCount = getDriver().getWindowHandles().size();
				int expOpenWindowsCount = 2;

			 	getDriver().switchTo().window(openTabs.get(1));
				
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
				String actDocNo=documentNumberTxt.getAttribute("value");
				String expDocNo="3";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(warehouseTxt));
				String actWarehouse=warehouseTxt.getAttribute("value");
				String expWarehouse="HYDERABAD";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
				String actR1Item=select1stRow_1stColumn.getText();
				String expR1Item="FIFO COGS ITEM";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
				String actR1Units=select1stRow_2ndColumn.getText();
				String expR1Units="Dozs";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
				String actR1Quantity=select1stRow_3rdColumn.getText();
				String expR1Quantity="1.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
				String actR1Rate=select1stRow_4thColumn.getText();
				String expR1Rate="5.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_5thColumn));
				String actR1Gross=select1stRow_5thColumn.getText();
				String expR1Gross="5.00";
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_7thColumn));
				String actR1Bin=select1stRow_7thColumn.getText();
				String expR1Bin="Bin4";
				
				
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
				String actR2Item=select2ndRow_1stColumn.getText();
				String expR2Item="FIFO COGS ITEM";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_2ndColumn));
				String actR2Units=select2ndRow_2ndColumn.getText();
				String expR2Units="Dozs";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_3rdColumn));
				String actR2Quantity=select2ndRow_3rdColumn.getText();
				String expR2Quantity="1.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_4thColumn));
				String actR2Rate=select2ndRow_4thColumn.getText();
				String expR2Rate="5.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_5thColumn));
				String actR2Gross=select2ndRow_5thColumn.getText();
				String expR2Gross="5.00";
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_7thColumn));
				String actR2Bin=select2ndRow_7thColumn.getText();
				String expR2Bin="Bin5";
				
				
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select3rdRow_1stColumn));
				String actR3Item=select3rdRow_1stColumn.getText();
				String expR3Item="FIFO COGS ITEM";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select3rdRow_2ndColumn));
				String actR3Units=select3rdRow_2ndColumn.getText();
				String expR3Units="Dozs";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select3rdRow_3rdColumn));
				String actR3Quantity=select3rdRow_3rdColumn.getText();
				String expR3Quantity="1.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select3rdRow_4thColumn));
				String actR3Rate=select3rdRow_4thColumn.getText();
				String expR3Rate="10.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select3rdRow_5thColumn));
				String actR3Gross=select3rdRow_5thColumn.getText();
				String expR3Gross="10.00";
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select3rdRow_7thColumn));
				String actR3Bin=select3rdRow_7thColumn.getText();
				String expR3Bin="Bin4";
				

				System.out.println("**********************checkStockMovementReportBackTrackOption*********************");
				
				System.out.println("*********** Voucher No : "+actDocNo        +"  value expected  "+expDocNo);
				System.out.println("*********** Warehouse  : "+actWarehouse    +"  value expected  "+expWarehouse);
				System.out.println("*********************************Row1******************************************");
				System.out.println("*********** Item       : "+actR1Item       +"  value expected  "+expR1Item);
				System.out.println("*********** Units      : "+actR1Units      +"  value expected  "+expR1Units);
				System.out.println("*********** Quantity   : "+actR1Quantity   +"  value expected  "+expR1Quantity);
				System.out.println("*********** Rate       : "+actR1Rate       +"  value expected  "+expR1Rate);
				System.out.println("*********** Gross      : "+actR1Gross      +"  value expected  "+expR1Gross);
				System.out.println("*********** Bin        : "+actR1Bin        +"  value expected  "+expR1Bin);
				System.out.println("*********************************Row2******************************************");
				System.out.println("*********** Item       : "+actR2Item       +"  value expected  "+expR2Item);
				System.out.println("*********** Units      : "+actR2Units      +"  value expected  "+expR2Units);
				System.out.println("*********** Quantity   : "+actR2Quantity   +"  value expected  "+expR2Quantity);
				System.out.println("*********** Rate       : "+actR2Rate       +"  value expected  "+expR2Rate);
				System.out.println("*********** Gross      : "+actR2Gross      +"  value expected  "+expR2Gross);
				System.out.println("*********** Bin        : "+actR2Bin        +"  value expected  "+expR2Bin);
				System.out.println("*********************************Row3******************************************");
				System.out.println("*********** Item       : "+actR3Item       +"  value expected  "+expR3Item);
				System.out.println("*********** Units      : "+actR3Units      +"  value expected  "+expR3Units);
				System.out.println("*********** Quantity   : "+actR3Quantity   +"  value expected  "+expR3Quantity);
				System.out.println("*********** Rate       : "+actR3Rate       +"  value expected  "+expR3Rate);
				System.out.println("*********** Gross      : "+actR3Gross      +"  value expected  "+expR3Gross);
				System.out.println("*********** Bin        : "+actR3Bin        +"  value expected  "+expR3Bin);
				
				getDriver().switchTo().window(openTabs.get(1)).close();
				
				Thread.sleep(1000);
				
				getDriver().switchTo().window(openTabs.get(0));
				
				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
				BackTrackItemDetailsBackBtn.click();
				
				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
				BackTrackMonthDetailsBackBtn.click();
				
				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
				BackTrackDateDetailsBackBtn.click();
				
				Thread.sleep(1000);
				
				if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
						&& actDocNo.equalsIgnoreCase(expDocNo) && actWarehouse.equalsIgnoreCase(expWarehouse) 
						&& actR1Item.equalsIgnoreCase(expR1Item) && actR1Units.equalsIgnoreCase(expR1Units) && actR1Quantity.equalsIgnoreCase(expR1Quantity) 
						&& actR1Rate.equalsIgnoreCase(expR1Rate) && actR1Gross.equalsIgnoreCase(expR1Gross) && actR1Bin.equalsIgnoreCase(expR1Bin) 
						
						&& actR2Item.equalsIgnoreCase(expR2Item) && actR2Units.equalsIgnoreCase(expR2Units) && actR2Quantity.equalsIgnoreCase(expR2Quantity) 
						&& actR2Rate.equalsIgnoreCase(expR2Rate) && actR2Gross.equalsIgnoreCase(expR2Gross) && actR2Bin.equalsIgnoreCase(expR2Bin) 
						
						&& actR3Item.equalsIgnoreCase(expR3Item) && actR3Units.equalsIgnoreCase(expR3Units) && actR3Quantity.equalsIgnoreCase(expR3Quantity) 
						&& actR3Rate.equalsIgnoreCase(expR3Rate) && actR3Gross.equalsIgnoreCase(expR3Gross) && actR3Bin.equalsIgnoreCase(expR3Bin))
				{
					
					return true;
				} 
				else 
				{
					
					return false;
				}
			}
			
			
			
			@FindBy(xpath="//*[@id='navigation_menu']/li[3]/ul/li[3]/ul/li[7]")
			private static WebElement multiLevelStockMovement;

			public boolean checkMultiLevelStockMovementReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
				inventoryMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
				inventoryReportsMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(multiLevelStockMovement));
				multiLevelStockMovement.click();
				
				Thread.sleep(2000);
				
				int rowcount=stockLedgerHometableRowCount.size();
				
				System.out.println(rowcount);
				
				for (int i = 0; i < rowcount; i++) 
				{
					String actName = stockLedgerHometableItemNamesList.get(i).getText();
					
					System.out.println(actName);
					
					if(actName.equalsIgnoreCase("FIFO COGS ITEM") || actName.equalsIgnoreCase("WA COGS ITEM") || actName.equalsIgnoreCase("STD RATE COGS ITEM") 
							|| actName.equalsIgnoreCase("BR COGS ITEM"))
					{
						stockLedgerHometableItemChkboxList.get(i).click();
					}
				}
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
				Select s=new Select(sl_DateOptionDropdown);
				s.selectByIndex(1);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
				sl_OkBtn.click();
				
				Thread.sleep(3000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
				
				int reportsRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsRow1ListArray.add(data);
				}
				String actRow1List = reportsRow1ListArray.toString();
				String expRow1List = "[WA COGS ITEM, 24.00, 84.00, 42.00, 405.11, 23.00, 170.45, 43.00, 318.66, 7.41]";
				
				

				int reportsRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsRow2ListArray.add(data);
				}
				String actRow2List = reportsRow2ListArray.toString();
				String expRow2List = "[FIFO COGS ITEM, 36.00, 20.00, 57.00, 46.50, 24.00, 13.33, 69.00, 56.50, 0.82]";
				
				
				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[BR COGS ITEM, 36.00, 20.00, 60.00, 51.50, 34.00, 28.75, 62.00, 42.75, 0.69]";
				
				
				
				int reportsRow4ListCount = reportsRow4List.size();
				ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow4ListCount;i++)
				{
					String data = reportsRow4List.get(i).getText();
					reportsRow4ListArray.add(data);
				}
				String actRow4List = reportsRow4ListArray.toString();
				String expRow4List = "[STD RATE COGS ITEM, 36.00, 20.00, 96.00, 344.50, 36.00, 360.00, 96.00, 960.00, 10.00]";
				
				
				
				int reportsRow5ListCount = reportsRow5List.size();
				ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow5ListCount;i++)
				{
					String data = reportsRow5List.get(i).getText();
					reportsRow5ListArray.add(data);
				}
				String actRow5List = reportsRow5ListArray.toString();
				String expRow5List = "[Grand Total, 132.00, 144.00, 255.00, 847.61, 117.00, 572.53, 270.00, 1,377.91, 18.92]";
				
				
				System.out.println("****************************checkMultiLevelStockMovementReports******************************");
				
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				System.out.println(actRow4List);
				System.out.println(expRow4List);
				
				System.out.println(actRow5List);
				System.out.println(expRow5List);
				
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
					&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
			
			
			
			
			
			@FindBy (xpath="//input[@id='FOption_576_0_DefaultFilter_0']")
			private static WebElement mlsm_DefaultFilterTxt;
			
			@FindBy (xpath="//*[@id='FilterFields_576_0']/ul[4]/li[1]/div/label/span")
			private static WebElement mlsm_report_FilterItemNameChkbox;
			
			
			public boolean checkMultiLevelStockMovementReportFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(multireport_FilterExpandBtn));
				multireport_FilterExpandBtn.click();
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(multireport_FilterBtn));
				multireport_FilterBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
				report_FilterCustomizeBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemExpansion));
				report_FilterItemExpansion.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
				
				if (report_FilterItemNameChkbox.isSelected()==false) 
				{
					report_FilterItemNameChkboxSelected.click();
				}

				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
				reports_Filter_Customize_OkBtn.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(mlsm_DefaultFilterTxt));
				mlsm_DefaultFilterTxt.click();
				mlsm_DefaultFilterTxt.sendKeys("STD RATE COGS ITEM");
				
				Thread.sleep(2000);
				
				mlsm_DefaultFilterTxt.sendKeys(Keys.TAB);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
				report_FilterOkBtn.click();
				
				Thread.sleep(3000);
				
				int reportsRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsRow1ListArray.add(data);
				}
				String actRow1List = reportsRow1ListArray.toString();
				String expRow1List = "[Grand Total, , , , , , , , , ]";
				
				
	/*
				int reportsRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsRow2ListArray.add(data);
				}
				String actRow2List = reportsRow2ListArray.toString();
				String expRow2List = "[FIFO COGS ITEM, 12.00, 5.00, 5.00]";
			

				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[FIFO COGS ITEM, 12.00, 5.00, 5.00]";
				*/
				
				System.out.println("***************************checkMultiLevelStockMovementReportFilterOption*********************************");
				
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				/*System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);*/
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(multireport_FilterExpandBtn));
				multireport_FilterExpandBtn.click();
				Thread.sleep(2000);
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(multireport_FilterBtn));
				multireport_FilterBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
				report_FilterCustomizeBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
				
				if (report_FilterItemNameChkbox.isSelected()==true) 
				{
					report_FilterItemNameChkboxSelected.click();
				}

				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
				reports_Filter_Customize_OkBtn.click();
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
				report_Filter_RefreshConditionBtn.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
				report_FilterOkBtn.click();
				
				int actRowCount = reportsRowsCount.size();
				int expRowCount = 1; 
				
				System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reportWithLevel_CloseBtn));
				reportWithLevel_CloseBtn.click();
				
				if(actRow1List.equalsIgnoreCase(expRow1List) /*&& actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) */
					&& actRowCount==expRowCount)
				{
					return true;
				}
				else
				{
					return false;
				}
			}

			
			
			
			
			
			
			
			public boolean checkMultiLevelStockMovementReportWithIncludeServiceTypeItemOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
				inventoryMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
				inventoryReportsMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(multiLevelStockMovement));
				multiLevelStockMovement.click();
				
				Thread.sleep(2000);
				
				int rowcount=stockLedgerHometableRowCount.size();
				
				System.out.println(rowcount);
				
				for (int i = 0; i < rowcount; i++) 
				{
					String actName = stockLedgerHometableItemNamesList.get(i).getText();
					
					System.out.println(actName);
					
					if(actName.equalsIgnoreCase("FIFO COGS ITEM") || actName.equalsIgnoreCase("WA COGS ITEM") || actName.equalsIgnoreCase("STD RATE COGS ITEM") 
							|| actName.equalsIgnoreCase("BR COGS ITEM"))
					{
						stockLedgerHometableItemChkboxList.get(i).click();
					}
				}
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
				Select s=new Select(sl_DateOptionDropdown);
				s.selectByIndex(1);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_IncludeServiceTypeItemChkBox));
				sl_IncludeServiceTypeItemChkBox.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
				sl_OkBtn.click();
				
				Thread.sleep(3000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
				
				int reportsRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsRow1ListArray.add(data);
				}
				String actRow1List = reportsRow1ListArray.toString();
				String expRow1List = "[WA COGS ITEM, 24.00, 84.00, 42.00, 405.11, 23.00, 170.45, 43.00, 318.66, 7.41]";
				
				

				int reportsRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsRow2ListArray.add(data);
				}
				String actRow2List = reportsRow2ListArray.toString();
				String expRow2List = "[FIFO COGS ITEM, 36.00, 20.00, 57.00, 46.50, 24.00, 13.33, 69.00, 56.50, 0.82]";
				
				
				
				int reportsRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsRow3ListArray.add(data);
				}
				String actRow3List = reportsRow3ListArray.toString();
				String expRow3List = "[BR COGS ITEM, 36.00, 20.00, 60.00, 51.50, 34.00, 28.75, 62.00, 42.75, 0.69]";
				
				
				
				int reportsRow4ListCount = reportsRow4List.size();
				ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow4ListCount;i++)
				{
					String data = reportsRow4List.get(i).getText();
					reportsRow4ListArray.add(data);
				}
				String actRow4List = reportsRow4ListArray.toString();
				String expRow4List = "[STD RATE COGS ITEM, 36.00, 20.00, 96.00, 344.50, 36.00, 360.00, 96.00, 960.00, 10.00]";
				
				
				
				int reportsRow5ListCount = reportsRow5List.size();
				ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
				for(int i=1;i<reportsRow5ListCount;i++)
				{
					String data = reportsRow5List.get(i).getText();
					reportsRow5ListArray.add(data);
				}
				String actRow5List = reportsRow5ListArray.toString();
				String expRow5List = "[Grand Total, 132.00, 144.00, 255.00, 847.61, 117.00, 572.53, 270.00, 1,377.91, 18.92]";
				
				
				System.out.println("********************checkMultiLevelStockMovementReportWithIncludeServiceTypeItemOption**********************");

				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				System.out.println(actRow4List);
				System.out.println(expRow4List);
				
				System.out.println(actRow5List);
				System.out.println(expRow5List);
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
					&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
			
			
			
			
			
			
			
			
			public boolean checkMultiLevelStockMovementReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				int reportItemGridListCount=reportTableColumn1RowsList.size();
			    for (int i = 0; i < reportItemGridListCount; i++) 
			    {
		             String data=reportTableColumn1RowsList.get(i).getText();
		             
		             if (data.equalsIgnoreCase("WA COGS ITEM"))
		             {
	            		 reportTableColumn1RowsList.get(i).click();
	            		 Thread.sleep(1000);
	            		 
	            		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            	 report_BackTrackBtn.click();
		            	 Thread.sleep(3000);
		            	 
		            	
		            	try{
		            		 String m="Please select a row in the grid to Backtrack";
		            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
		            		 {
		            			 reportTableColumn1RowsList.get(i).click();
		            			 Thread.sleep(2000);
		            			 
		            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            			 report_BackTrackBtn.click();
		            			 Thread.sleep(3000);
		            	
		            		 }
		            	}
		            	catch(Exception e){
		            		System.out.println("message not displaying");
		            		
		            	}
		            	break;
	                 }
	 		     }
				
				/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ml_BackTrackBtn));
				ml_BackTrackBtn.click();*/
				
				getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
				
				int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
				ArrayList<String> actMonthlyList = new ArrayList<String>();
				for(int i=0; i<backTrackMonthlyColumnsCount; i++)
				{
					String data = backTrackItemDetailsMonthsTableList.get(i).getText();
					actMonthlyList.add(data);
				}
				
				Calendar cal=Calendar.getInstance();
				DateFormat df = new SimpleDateFormat("MMMM yyyy");
				String Row2Month = df.format(cal.getTime());
				
				ArrayList<String> expMonthlyList = new ArrayList<String>();
				expMonthlyList.add("January 2020");
				expMonthlyList.add("");
				expMonthlyList.add("24.00");
				expMonthlyList.add("");
				expMonthlyList.add("24.00");
				expMonthlyList.add(Row2Month);

				//expMonthlyList.add(Row2Month);
				expMonthlyList.add("24.00");
				expMonthlyList.add("42.00");
				expMonthlyList.add("23.00");
				expMonthlyList.add("43.00");
				expMonthlyList.add("");
				expMonthlyList.add("");
				expMonthlyList.add("66.00");
				expMonthlyList.add("23.00");
				expMonthlyList.add("");
				
				System.out.println(actMonthlyList);
				System.out.println(expMonthlyList);
				
				for(int i=0; i<backTrackMonthlyColumnsCount; i++)
				{
					String data = backTrackItemDetailsMonthsTableList.get(i).getText();
					
					if (data.equalsIgnoreCase("January 2020")) 
					{
						getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
						break;
					}
				}
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
				
				int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
				ArrayList<String> actDayList = new ArrayList<String>();
				for(int i=0; i<backTrackDayColumnsCount; i++)
				{
					String data = backTrackItemDetailsDaysTableList.get(i).getText();
					actDayList.add(data);
				}
				
				ArrayList<String> expDayList = new ArrayList<String>();
				expDayList.add("1");
				expDayList.add("");
				expDayList.add("24.00");
				expDayList.add("");
				expDayList.add("24.00");
				expDayList.add("");
				expDayList.add("");
				expDayList.add("24.00");
				expDayList.add("");
				expDayList.add("");
				
				System.out.println(actDayList);
				System.out.println(expDayList);
				
				for(int i=0; i<backTrackDayColumnsCount; i++)
				{
					String data = backTrackItemDetailsDaysTableList.get(i).getText();

					if (data.equalsIgnoreCase("1")) 
					{
						getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
					}
				}
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
				
				int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
				ArrayList<String> actVouchersList = new ArrayList<String>();
				for(int i=0; i<backTrackVouchersColumnsCount; i++)
				{
					String data = backTrackItemDetailsVouchersTableList.get(i).getText();
					actVouchersList.add(data);
				}
				
				ArrayList<String> expVouchersList = new ArrayList<String>();
				expVouchersList.add("OpeStk:4");
				expVouchersList.add("");
				expVouchersList.add("24.00");
				expVouchersList.add("");
				expVouchersList.add("24.00");
				expVouchersList.add("");
				expVouchersList.add("");
				expVouchersList.add("24.00");
				expVouchersList.add("");
				expVouchersList.add("");
				
				System.out.println(actVouchersList);
				System.out.println(expVouchersList);
				
				for(int i=0; i<backTrackVouchersColumnsCount; i++)
				{
					String data = backTrackItemDetailsVouchersTableList.get(i).getText();

					if (data.equalsIgnoreCase("OpeStk:4")) 
					{
						getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
						break;
					}
				}
				
				Thread.sleep(2000);
				
				ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
				
				int actOpenWindowsCount = getDriver().getWindowHandles().size();
				int expOpenWindowsCount = 2;

			 	getDriver().switchTo().window(openTabs.get(1));
			 	
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
				String actDocNo=documentNumberTxt.getAttribute("value");
				String expDocNo="4";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(warehouseTxt));
				String actWarehouse=warehouseTxt.getAttribute("value");
				String expWarehouse="HYDERABAD";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
				String actItem=select1stRow_1stColumn.getText();
				String expItem="WA COGS ITEM";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
				String actUnits=select1stRow_2ndColumn.getText();
				String expUnits="Pcs";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
				String actQuantity=select1stRow_3rdColumn.getText();
				String expQuantity="12.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
				String actRate=select1stRow_4thColumn.getText();
				String expRate="2.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_5thColumn));
				String actGross=select1stRow_5thColumn.getText();
				String expGross="24.00";
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_9thColumn));
				String actRMA=select1stRow_9thColumn.getText();
				String expRMA="RMA#R1OSV1,RMA#R1OSV2,RMA#R1OSV3,RMA#R1OSV4,RMA#R1OSV5,RMA#R1OSV6,RMA#R1OSV7,RMA#R1OSV8,RMA#R1OSV9,RMA#R1OSV10,RMA#R1OSV11,RMA#R1OSV12";
				

				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
				String actItem2=select2ndRow_1stColumn.getText();
				String expItem2="WA COGS ITEM";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_2ndColumn));
				String actUnits2=select2ndRow_2ndColumn.getText();
				String expUnits2="Pcs";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_3rdColumn));
				String actQuantity2=select2ndRow_3rdColumn.getText();
				String expQuantity2="12.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_4thColumn));
				String actRate2=select2ndRow_4thColumn.getText();
				String expRate2="5.00";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_5thColumn));
				String actGross2=select2ndRow_5thColumn.getText();
				String expGross2="60.00";
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_9thColumn));
				String actRMA2=select2ndRow_9thColumn.getText();
				String expRMA2="RMA#R2OSV1,RMA#R2OSV2,RMA#R2OSV3,RMA#R2OSV4,RMA#R2OSV5,RMA#R2OSV6,RMA#R2OSV7,RMA#R2OSV8,RMA#R2OSV9,RMA#R2OSV10,RMA#R2OSV11,RMA#R2OSV12";
				
				System.out.println("**********************checkMultiLevelStockMovementReportBackTrackOption*********************");
				
				System.out.println("*********** Voucher No : "+actDocNo      +"  value expected  "+expDocNo);
				System.out.println("*********** Warehouse  : "+actWarehouse  +"  value expected  "+expWarehouse);
				System.out.println("*********** Item       : "+actItem       +"  value expected  "+expItem);
				System.out.println("*********** Units      : "+actUnits      +"  value expected  "+expUnits);
				System.out.println("*********** Quantity   : "+actQuantity   +"  value expected  "+expQuantity);
				System.out.println("*********** Rate       : "+actRate       +"  value expected  "+expRate);
				System.out.println("*********** Gross      : "+actGross      +"  value expected  "+expGross);
				System.out.println(actRMA);
				System.out.println(expRMA);
				System.out.println("*********** Item2       : "+actItem2       +"  value expected  "+expItem2);
				System.out.println("*********** Units2      : "+actUnits2      +"  value expected  "+expUnits2);
				System.out.println("*********** Quantity2   : "+actQuantity2   +"  value expected  "+expQuantity2);
				System.out.println("*********** Rate2       : "+actRate2       +"  value expected  "+expRate2);
				System.out.println("*********** Gross2      : "+actGross2      +"  value expected  "+expGross2);
				System.out.println(actRMA2);
				System.out.println(expRMA2);
				
				getDriver().switchTo().window(openTabs.get(1)).close();
				
				Thread.sleep(1000);
				
				getDriver().switchTo().window(openTabs.get(0));
				
				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
				BackTrackItemDetailsBackBtn.click();
				
				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
				BackTrackMonthDetailsBackBtn.click();
				
				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
				BackTrackDateDetailsBackBtn.click();
				
				Thread.sleep(1000);
				
				if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
					 && actDocNo.equalsIgnoreCase(expDocNo) && actWarehouse.equalsIgnoreCase(expWarehouse) && actItem.equalsIgnoreCase(expItem) 
					 && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actRate.equalsIgnoreCase(expRate)
					 && actGross.equalsIgnoreCase(expGross) && actRMA.equalsIgnoreCase(expRMA)
					 && actItem2.equalsIgnoreCase(expItem2) && actUnits2.equalsIgnoreCase(expUnits2) && actQuantity2.equalsIgnoreCase(expQuantity2) 
					 && actRate2.equalsIgnoreCase(expRate2) && actGross2.equalsIgnoreCase(expGross2) && actRMA2.equalsIgnoreCase(expRMA2)) 
				{
					
					return true;
				}
				else
				{
					
					return false;
				}
			}
			
			
			@FindBy(xpath="//*[@id='navigation_menu']/li[3]/ul/li[3]/ul/li[8]")
			private static WebElement virtualStockAnalysis;
			
			public boolean checkVirtualStockAnalysisReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
				inventoryMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
				inventoryReportsMenu.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(virtualStockAnalysis));
				virtualStockAnalysis.click();
				
				Thread.sleep(2000);
				
				int rowcount=stockLedgerHometableRowCount.size();
				
				System.out.println(rowcount);
				
				for (int i = 0; i < rowcount; i++) 
				{
					String actName = stockLedgerHometableItemNamesList.get(i).getText();
					
					System.out.println(actName);
					
					if(actName.equalsIgnoreCase("FIFO COGS ITEM") || actName.equalsIgnoreCase("WA COGS ITEM"))
					{
						stockLedgerHometableItemChkboxList.get(i).click();
					}
				}
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
				Select s=new Select(sl_DateOptionDropdown);
				s.selectByIndex(1);
				

				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
				sl_OkBtn.click();
				
				Thread.sleep(3000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
				
				int reportsByWarehouseRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsByWarehouseRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsByWarehouseRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsByWarehouseRow1ListArray.add(data);
				}
				String actRow1List = reportsByWarehouseRow1ListArray.toString();
				String expRow1List = "[FIFO COGS ITEM, 69.00, , , 6.00, 75.00]";
				

				int reportsByWarehouseRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsByWarehouseRow2ListArray = new ArrayList<String>();
				for(int i=1;i<reportsByWarehouseRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsByWarehouseRow2ListArray.add(data);
				}
				String actRow2List = reportsByWarehouseRow2ListArray.toString();
				String expRow2List = "[WA COGS ITEM, 43.00, , , 14.33, 57.33]";
				
				
				
				int reportsByWarehouseRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsByWarehouseRow3ListArray = new ArrayList<String>();
				for(int i=1;i<reportsByWarehouseRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsByWarehouseRow3ListArray.add(data);
				}
				String actRow3List = reportsByWarehouseRow3ListArray.toString();
				String expRow3List = "[Grand Total, 112.00, , , 20.33, 132.33]";
				
				
				System.out.println("*********************************checkVirtualStockAnalysisReport*****************************************");
				
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List))
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
					report_CloseBtn.click();
					return true;
				}
				else
				{
					getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
					report_CloseBtn.click();
					return false;
				}
			}
			
			
			
			
			
			
			
			
			public boolean checkVirtualStockAnalysisReportWithIncludeServiceTypeItemOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_IncludeServiceTypeItemChkBox));
				sl_IncludeServiceTypeItemChkBox.click();
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
				sl_OkBtn.click();
				
				Thread.sleep(3000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
				
				int reportsByWarehouseRow1ListCount = reportsRow1List.size();
				ArrayList<String> reportsByWarehouseRow1ListArray = new ArrayList<String>();
				for(int i=1;i<reportsByWarehouseRow1ListCount;i++)
				{
					String data = reportsRow1List.get(i).getText();
					reportsByWarehouseRow1ListArray.add(data);
				}
				String actRow1List = reportsByWarehouseRow1ListArray.toString();
				String expRow1List = "[FIFO COGS ITEM, 69.00, , , 6.00, 75.00]";
				

				int reportsByWarehouseRow2ListCount = reportsRow2List.size();
				ArrayList<String> reportsByWarehouseRow2ListArray = new ArrayList<String>();
				for(int i=1;i<reportsByWarehouseRow2ListCount;i++)
				{
					String data = reportsRow2List.get(i).getText();
					reportsByWarehouseRow2ListArray.add(data);
				}
				String actRow2List = reportsByWarehouseRow2ListArray.toString();
				String expRow2List = "[WA COGS ITEM, 43.00, , , 14.33, 57.33]";
				
				
				
				int reportsByWarehouseRow3ListCount = reportsRow3List.size();
				ArrayList<String> reportsByWarehouseRow3ListArray = new ArrayList<String>();
				for(int i=1;i<reportsByWarehouseRow3ListCount;i++)
				{
					String data = reportsRow3List.get(i).getText();
					reportsByWarehouseRow3ListArray.add(data);
				}
				String actRow3List = reportsByWarehouseRow3ListArray.toString();
				String expRow3List = "[Grand Total, 112.00, , , 20.33, 132.33]";
				
				
				System.out.println("*********************************checkVirtualStockAnalysisReportWithIncludeServiceTypeItemOption*****************************************");
				
				System.out.println(actRow1List);
				System.out.println(expRow1List);
				
				System.out.println(actRow2List);
				System.out.println(expRow2List);
				
				System.out.println(actRow3List);
				System.out.println(expRow3List);
				
				if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
			
			
			
			
			
			
			
			public boolean checkVirtualStockAnalysisReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
			{
				int reportItemGridListCount=reportTableColumn1RowsList.size();
			    for (int i = 0; i < reportItemGridListCount; i++) 
			    {
		             String data=reportTableColumn1RowsList.get(i).getText();
		             
		             if (data.equalsIgnoreCase("FIFO COGS ITEM"))
		             {
	            		 reportTableColumn1RowsList.get(i).click();
	            		 Thread.sleep(1000);
	            		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            	 report_BackTrackBtn.click();
		            	 Thread.sleep(3000);
		            	 
		            	
		            	try{
		            		 String m="Please select a row in the grid to Backtrack";
		            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
		            		 {
		            			 reportTableColumn1RowsList.get(i).click();
		            			 Thread.sleep(2000);
		            			 
		            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            			 report_BackTrackBtn.click();
		            			 Thread.sleep(3000);
		            	
		            		 }
		            	}
		            	catch(Exception e){
		            		System.out.println("message not displaying");
		            		
		            	}
		            	break;
	                 }
	 		     }
				
			/*	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
				sl_BackTrackBtn.click();*/
			    
			    Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
				
				int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
				ArrayList<String> actMonthlyList = new ArrayList<String>();
				for(int i=0; i<backTrackMonthlyColumnsCount; i++)
				{
					String data = backTrackItemDetailsMonthsTableList.get(i).getText();
					actMonthlyList.add(data);
				}
				
				Calendar cal=Calendar.getInstance();
				DateFormat df = new SimpleDateFormat("MMMM yyyy");
				String Row2Month = df.format(cal.getTime());
				
				ArrayList<String> expMonthlyList = new ArrayList<String>();
				expMonthlyList.add("January 2020");
				expMonthlyList.add("");
				expMonthlyList.add("36.00");
				expMonthlyList.add("");
				expMonthlyList.add("36.00");
				//expMonthlyList.add(Row2Month);
				expMonthlyList.add(Row2Month);

				expMonthlyList.add("36.00");
				expMonthlyList.add("57.00");
				expMonthlyList.add("24.00");
				expMonthlyList.add("69.00");
				expMonthlyList.add("");
				expMonthlyList.add("");
				expMonthlyList.add("93.00");
				expMonthlyList.add("24.00");
				expMonthlyList.add("");
				
				System.out.println(actMonthlyList);
				System.out.println(expMonthlyList);
				
				for(int i=0; i<backTrackMonthlyColumnsCount; i++)
				{
					String data = backTrackItemDetailsMonthsTableList.get(i).getText();
					
					if (data.equalsIgnoreCase(Row2Month)) 
					{
						getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
						break;
					}
				}
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
				
				int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
				ArrayList<String> actDayList = new ArrayList<String>();
				for(int i=0; i<backTrackDayColumnsCount; i++)
				{
					String data = backTrackItemDetailsDaysTableList.get(i).getText();
					actDayList.add(data);
				}
				
				DateFormat dt = new SimpleDateFormat("d");
				String Row1Date = dt.format(cal.getTime());
				
				ArrayList<String> expDayList = new ArrayList<String>();
				//expDayList.add(Row1Date);
				
				expDayList.add(Row1Date);
				expDayList.add("36.00");
				expDayList.add("57.00");
				expDayList.add("24.00");
				expDayList.add("69.00");
				expDayList.add("");
				expDayList.add("");
				expDayList.add("57.00");
				expDayList.add("24.00");
				expDayList.add("");
				
				System.out.println(actDayList);
				System.out.println(expDayList);
				
				for(int i=0; i<backTrackDayColumnsCount; i++)
				{
					String data = backTrackItemDetailsDaysTableList.get(i).getText();
					
					if (data.equalsIgnoreCase(Row1Date)) 
					{
						getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
						break;
					}
				}
				
				Thread.sleep(2000);
				
				getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
				
				int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
				ArrayList<String> actVouchersList = new ArrayList<String>();
				for(int i=0; i<backTrackVouchersColumnsCount; i++)
				{
					String data = backTrackItemDetailsVouchersTableList.get(i).getText();
					actVouchersList.add(data);
				}
				
				ArrayList<String> expVouchersList = new ArrayList<String>();
				expVouchersList.add("ExeStk:2");
				expVouchersList.add("36.00");
				expVouchersList.add("12.00");
				expVouchersList.add("");
				expVouchersList.add("48.00");
				expVouchersList.add("StkTrf:2");
				expVouchersList.add("48.00");
				expVouchersList.add("9.00");
				expVouchersList.add("9.00");
				expVouchersList.add("48.00");
				expVouchersList.add("NDT50:7");
				expVouchersList.add("48.00");
				expVouchersList.add("");
				expVouchersList.add("9.00");
				expVouchersList.add("39.00");
				expVouchersList.add("NDT50:4");
				expVouchersList.add("39.00");
				expVouchersList.add("");
				expVouchersList.add("6.00");
				expVouchersList.add("33.00");
				expVouchersList.add("NDT57:SU/IND/TEXT4");
				expVouchersList.add("33.00");
				expVouchersList.add("36.00");
				expVouchersList.add("");
				expVouchersList.add("69.00");
				expVouchersList.add("");
				expVouchersList.add("");
				expVouchersList.add("57.00");
				expVouchersList.add("24.00");
				expVouchersList.add("");
				
				System.out.println(actVouchersList);
				System.out.println(expVouchersList);
				
				
				for(int i=0; i<backTrackVouchersColumnsCount; i++)
				{
					String data = backTrackItemDetailsVouchersTableList.get(i).getText();
					
					if (data.equalsIgnoreCase("NDT50:4")) 
					{
						getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
					}
				}
				
				Thread.sleep(2000);
				
				ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
				
				int actOpenWindowsCount = getDriver().getWindowHandles().size();
				int expOpenWindowsCount = 2;

			 	getDriver().switchTo().window(openTabs.get(1));
			 	
			 	checkValidationMessage("");
			 	
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
				String actDocNo=documentNumberTxt.getAttribute("value");
				String expDocNo="4";
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customerAccountTxt));
				String actCustomer=customerAccountTxt.getAttribute("value");
				String expCustomer="Customer A";
				
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
			 	String actWarehouse = select1stRow_1stColumn.getText();
			 	String expWarehouse = "HYDERABAD";
			 	
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
			 	String actItem = select1stRow_2ndColumn.getText();
			 	String expItem = "FIFO COGS ITEM";
			 	
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
			 	String actTaxCode = select1stRow_3rdColumn.getText();
			 	String expTaxCode = "Std Rate";
			 	
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
			 	String actSalesAccount = select1stRow_4thColumn.getText();
			 	String expSalesAccount = "Sales - Computers";
			 	
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_5thColumn));
			 	String actUnits = select1stRow_5thColumn.getText();
			 	String expUnits = "Pcs";
			 	
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_11thColumn));
			 	String actQuantity = select1stRow_11thColumn.getText();
			 	String expQuantity = "6.00";
			 	
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_12thColumn));
			 	String actLSalesOrder = select1stRow_12thColumn.getText();
			 	String expLSalesOrder = "SalOrd:3";
			 	
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_14thColumn));
			 	String actRate = select1stRow_14thColumn.getText();
			 	String expRate = "10.00";
			 	
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_15thColumn));
			 	String actGross = select1stRow_15thColumn.getText();
			 	String expGross = "60.00";
			 	
			 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_20thColumn));
			 	String actBin = select1stRow_20thColumn.getText();
			 	String expBin = "Bin4";
			 	
				System.out.println("**********************checkVirtualStockAnalysisReportBackTrackOption*********************");
				 
				System.out.println("Open Tabs        : "+actOpenWindowsCount         +"  Value Expected  "+expOpenWindowsCount);
				
				System.out.println("Document No      : "+actDocNo         +"  Value Expected  "+expDocNo);
				System.out.println("Customer Account : "+actCustomer      +"  Value Expected  "+expCustomer);
				System.out.println("Warehouse        : "+actWarehouse     +"  Value Expected  "+expWarehouse);
				System.out.println("Item             : "+actItem          +"  Value Expected  "+expItem);
				System.out.println("Tax Code         : "+actTaxCode       +"  Value Expected  "+expTaxCode);
				System.out.println("Sales Account    : "+actSalesAccount  +"  Value Expected  "+expSalesAccount);
				System.out.println("Units            : "+actUnits         +"  Value Expected  "+expUnits);
				System.out.println("Quantity         : "+actQuantity      +"  Value Expected  "+expQuantity);
				System.out.println("L Sales Order    : "+actLSalesOrder   +"  Value Expected  "+expLSalesOrder);
				System.out.println("Rate             : "+actRate          +"  Value Expected  "+expRate);
				System.out.println("Gross            : "+actGross         +"  Value Expected  "+expGross);
				System.out.println("Bin              : "+actBin           +"  Value Expected  "+expBin);
				
				getDriver().switchTo().window(openTabs.get(1)).close();
				
				Thread.sleep(1000);
				
				getDriver().switchTo().window(openTabs.get(0));
				
				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
				BackTrackItemDetailsBackBtn.click();
				
				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
				BackTrackMonthDetailsBackBtn.click();
				
				Thread.sleep(1000);
				
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
				BackTrackDateDetailsBackBtn.click();
				
				Thread.sleep(1000);
				
				if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
					   && actDocNo.equalsIgnoreCase(expDocNo) && actCustomer.equalsIgnoreCase(expCustomer) && actWarehouse.equalsIgnoreCase(expWarehouse)
					   && actItem.equalsIgnoreCase(expItem) && actTaxCode.equalsIgnoreCase(expTaxCode) && actSalesAccount.equalsIgnoreCase(expSalesAccount)
					   && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actLSalesOrder.equalsIgnoreCase(expLSalesOrder)
					   && actRate.equalsIgnoreCase(expRate) && actGross.equalsIgnoreCase(expGross) && actBin.equalsIgnoreCase(expBin)) 
				{
					
					return true;
				}
				else
				{
					
					return false;
				}
			}
			
			
			
	@FindBy(xpath="//*[@id='navigation_menu']/li[3]/ul/li[3]/ul/li[9]")
	private static WebElement stockValuation;
	
	public boolean checkStockValuationReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getDriver().navigate().refresh();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockValuation));
		stockValuation.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("STD RATE COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsByWarehouseRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsByWarehouseRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsByWarehouseRow1ListArray.add(data);
		}
		String actRow1List = reportsByWarehouseRow1ListArray.toString();
		String expRow1List = "[STD RATE COGS ITEM, STD RATE COGS ITEM, STD RATE COGS ITEM, 96.00, 960.00, 10.00, , ]";
		

		int reportsByWarehouseRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsByWarehouseRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsByWarehouseRow2ListArray.add(data);
		}
		String actRow2List = reportsByWarehouseRow2ListArray.toString();
		String expRow2List = "[Total, , , 96.00, 960.00, 10.00, , ]";
		
		System.out.println("*********************************checkStockValuationReport*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	@FindBy (xpath="//span[@id='id_Item_spanplus']")
	private static WebElement sv_CustomizationFieldsItemExpansion;
	
	@FindBy (xpath="//*[@id='id_Item_main_40']/span/span/i")
	private static WebElement sv_CustomizationFieldsPurchaseVarianceExpansion;
	
	@FindBy (xpath="//li[@id='id_Item_main_40_0']")
	private static WebElement sv_CustomizationFieldsPurchaseVarianceName;
	
	
	public boolean checkStockValuationCustomizationReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_ReportCustomizeBtn));
		report_ReportCustomizeBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sv_CustomizationFieldsItemExpansion));
		sv_CustomizationFieldsItemExpansion.click();
		
		Thread.sleep(2000);
		
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sv_CustomizationFieldsPurchaseVarianceExpansion));
		getAction().moveToElement(sv_CustomizationFieldsPurchaseVarianceExpansion).click().build().perform();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sv_CustomizationFieldsPurchaseVarianceName));
		getAction().doubleClick(sv_CustomizationFieldsPurchaseVarianceName).build().perform();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(osr_customizeSaveBtn));
		osr_customizeSaveBtn.click();
		
		String expMessage = "Data saved successfully";
	    
	    String actMessage = checkValidationMessage(expMessage);
		
		Thread.sleep(4000);
		
		/*if (sl_OkBtn.isDisplayed()==true) 
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
			sl_OkBtn.click();
			
			Thread.sleep(4000);
		}
	    else
	    {
	    	if (osr_customizeCloseBtn.isDisplayed()==true) 
	    	{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(osr_customizeCloseBtn));
				osr_customizeCloseBtn.click();
				
				Thread.sleep(4000);
			}
	    }*/
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[STD RATE COGS ITEM, STD RATE COGS ITEM, STD RATE COGS ITEM, 96.00, 960.00, 10.00, , , PURCHASE VARIANCE]";
		
		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Total, , , 96.00, 960.00, 10.00, , , ]";
		
		
		System.out.println("************************************checkStockValuationCustomizationReport********************************************");
	
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_ReportCustomizeBtn));
		report_ReportCustomizeBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CustomizationDeleteLayoutBtn));
		report_CustomizationDeleteLayoutBtn.click();
	
		Thread.sleep(1000);
		
		getWaitForAlert();
		getAlert().accept();
		
		String expDeleteMessage = "Layout Deleted Successfully";
	    
	    String actDeleteMessage = checkValidationMessage(expDeleteMessage);
	    
	    Thread.sleep(4000);
	    
	    
	    int reportsHeaderListCount = reportsHeaderList.size();
		ArrayList<String> reportsHeaderListArray = new ArrayList<String>();
		for(int i=0;i<reportsHeaderListCount;i++)
		{
			String data = reportsHeaderList.get(i).getText();
			reportsHeaderListArray.add(data);
		}
		String actHeaderList = reportsHeaderListArray.toString();
		String expHeaderList = "[#, Item, Item Code, Item Alias, Quantity, Stock Value, Unit Price, Warehouse, Alternate Quantity]";
	    
	    System.out.println(actHeaderList);
	    System.out.println(expHeaderList);
	    
	    getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
	    report_CloseBtn.click();
		
		Thread.sleep(2000);
	    
		if(actMessage.equalsIgnoreCase(expMessage)
			&& actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List)
			&& actDeleteMessage.equalsIgnoreCase(expDeleteMessage)
			&& actHeaderList.equalsIgnoreCase(expHeaderList))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	@FindBy (xpath="//*[@id='id_reportmenudisplay']/ul//li//i[@class='icon-close hiconright2']")
	private static WebElement reportWithLevel_CloseBtn;

	
	
	@FindBy (xpath="//*[@id='RITCheckbox__4']/following-sibling::span")
	private static WebElement sl_DisplayLinearReportChkBox;
	
	
	
	
	public boolean checkStockValuationReportWithStockValuationDisplayLinearReportIncludeServiceTypeItemOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		Thread.sleep(2000);
		
		/*((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(sl_StockValuationDropdown).build().perform();
		*/
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_StockValuationDropdown));
		//sl_StockValuationDropdown.click();
		Select s = new Select(sl_StockValuationDropdown);
		
		s.selectByIndex(2);
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DisplayLinearReportChkBox));
		sl_DisplayLinearReportChkBox.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_IncludeServiceTypeItemChkBox));
		sl_IncludeServiceTypeItemChkBox.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsByWarehouseRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsByWarehouseRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsByWarehouseRow1ListArray.add(data);
		}
		String actRow1List = reportsByWarehouseRow1ListArray.toString();
		String expRow1List = "[HYDERABAD]";
		

		int reportsByWarehouseRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsByWarehouseRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsByWarehouseRow2ListArray.add(data);
		}
		String actRow2List = reportsByWarehouseRow2ListArray.toString();
		String expRow2List = "[STD RATE COGS ITEM, STD RATE COGS ITEM, STD RATE COGS ITEM, 96.00, 216.83, 2.26, HYDERABAD, ]";
		
		
		
		int reportsByWarehouseRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsByWarehouseRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsByWarehouseRow3ListArray.add(data);
		}
		String actRow3List = reportsByWarehouseRow3ListArray.toString();
		String expRow3List = "[Total, , , 96.00, 216.83, 2.26, , ]";
		
		
		System.out.println("************checkStockValuationReportWithStockValuationDisplayLinearReportIncludeServiceTypeItemOption***********");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	@FindBy (xpath="//*[@id='dvmainBacktracking']/div[2]/div/table/tbody/tr/td")
	private static List<WebElement> backTrackItemDetailsMonthsTableList;
	
	@FindBy (xpath="(//*[@id='dvmainBacktracking']/div[2]/div/table)[1]")
	private static WebElement backTrackItemDetailsMonthsTable;
	
				
	@FindBy (xpath="(//*[@id='dvmainBacktracking']/div[2]/div/table)[2]/tbody/tr/td")
	private static List<WebElement> backTrackItemDetailsDaysTableList;
	
	@FindBy (xpath="(//*[@id='dvmainBacktracking']/div[2]/div/table)[2]")
	private static WebElement backTrackItemDetailsDaysTable;
	
	/*@FindBy (xpath="//div[@id='dvReportRenderBacktracking']/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[1]")
	private static WebElement backTrackItemDetailsDays1stRow1stCol;*/
	
	
	
	@FindBy (xpath="(//*[@id='dvmainBacktracking']/div[2]/div/table)[3]/tbody/tr/td")
	private static List<WebElement> backTrackItemDetailsVouchersTableList;
	
	@FindBy (xpath="(//*[@id='dvmainBacktracking']/div[2]/div/table)[3]")
	private static WebElement backTrackItemDetailsVouchersTable;
	
	
	
	
	@FindBy (xpath="//*[@id='dvReportDetails']/div/table/tbody/tr/td[2]")
	private static List<WebElement> reportTableColumn1RowsList;
	
	


	
	public boolean checkStockValuationReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		int reportItemGridListCount=reportTableColumn1RowsList.size();
		   
		for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("HYDERABAD"))
             {
                 int count =i+2;
                 
                 for (int j = i; j < count; j++) 
     		     {
                	 String data1=reportTableColumn1RowsList.get(j).getText();
		             
                	 if (data1.equalsIgnoreCase("STD RATE COGS ITEM"))
                     {
                		 System.err.println("Item Name : "+data1);
                		 reportTableColumn1RowsList.get(j).click();
                		 Thread.sleep(1000);
                		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            	 report_BackTrackBtn.click();
		            	 Thread.sleep(3000);
		            	 
		            	
		            	try{
		            		 String m="Please select a row in the grid to Backtrack";
		            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
		            		 {
		            			 reportTableColumn1RowsList.get(i).click();
		            			 Thread.sleep(2000);
		            			 
		            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            			 report_BackTrackBtn.click();
		            			 Thread.sleep(3000);
		            	
		            		 }
		            	}
		            	catch(Exception e){
		            		System.out.println("message not displaying");
		            		
		            	}
		            	break;
                     }
     		     }
             }
	      }
	    
	    
	/*	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		Thread.sleep(3000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);

		//expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("96.00");
		expMonthlyList.add("36.00");
		expMonthlyList.add("96.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("132.00");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		//expDayList.add(Row1Date);
		expDayList.add(Row1Date);

		expDayList.add("36.00");
		expDayList.add("96.00");
		expDayList.add("36.00");
		expDayList.add("96.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("96.00");
		expDayList.add("36.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);

		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		expVouchersList.add("NDT57:SU/IND/TEXT1");
		expVouchersList.add("36.00");
		expVouchersList.add("24.00");
		expVouchersList.add("");
		expVouchersList.add("60.00");
		expVouchersList.add("NDT50:6");
		expVouchersList.add("60.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT57:SU/IND/TEXT3");
		expVouchersList.add("46.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("84.00");
		expVouchersList.add("SalRet:1");
		expVouchersList.add("84.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("96.00");
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("96.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("108.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("108.00");
		expVouchersList.add("12.00");
		expVouchersList.add("12.00");
		expVouchersList.add("108.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("108.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("96.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("96.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("NDT50:6")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo=documentNumberTxt.getAttribute("value");
		String expDocNo="6";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customerAccountTxt));
		String actCustomer=customerAccountTxt.getAttribute("value");
		String expCustomer="Customer A";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
	 	String actWarehouse = select1stRow_1stColumn.getText();
	 	String expWarehouse = "HYDERABAD";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
	 	String actItem = select1stRow_2ndColumn.getText();
	 	String expItem = "STD RATE COGS ITEM";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
	 	String actTaxCode = select1stRow_3rdColumn.getText();
	 	String expTaxCode = "Std Rate";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
	 	String actSalesAccount = select1stRow_4thColumn.getText();
	 	String expSalesAccount = "Sales - Computers";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_5thColumn));
	 	String actUnits = select1stRow_5thColumn.getText();
	 	String expUnits = "Pcs";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_11thColumn));
	 	String actQuantity = select1stRow_11thColumn.getText();
	 	String expQuantity = "12.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_12thColumn));
	 	String actLSalesOrder = select1stRow_12thColumn.getText();
	 	String expLSalesOrder = "SalOrd:2";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_14thColumn));
	 	String actRate = select1stRow_14thColumn.getText();
	 	String expRate = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_15thColumn));
	 	String actGross = select1stRow_15thColumn.getText();
	 	String expGross = "120.00";
	 	
		System.out.println("**********************checkStockValuationReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs        : "+actOpenWindowsCount         +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No      : "+actDocNo         +"  Value Expected  "+expDocNo);
		System.out.println("Customer Account : "+actCustomer      +"  Value Expected  "+expCustomer);
		System.out.println("Warehouse        : "+actWarehouse     +"  Value Expected  "+expWarehouse);
		System.out.println("Item             : "+actItem          +"  Value Expected  "+expItem);
		System.out.println("Tax Code         : "+actTaxCode       +"  Value Expected  "+expTaxCode);
		System.out.println("Sales Account    : "+actSalesAccount  +"  Value Expected  "+expSalesAccount);
		System.out.println("Units            : "+actUnits         +"  Value Expected  "+expUnits);
		System.out.println("Quantity         : "+actQuantity      +"  Value Expected  "+expQuantity);
		System.out.println("L Sales Order    : "+actLSalesOrder   +"  Value Expected  "+expLSalesOrder);
		System.out.println("Rate             : "+actRate          +"  Value Expected  "+expRate);
		System.out.println("Gross            : "+actGross         +"  Value Expected  "+expGross);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			   && actDocNo.equalsIgnoreCase(expDocNo) && actCustomer.equalsIgnoreCase(expCustomer) && actWarehouse.equalsIgnoreCase(expWarehouse)
			   && actItem.equalsIgnoreCase(expItem) && actTaxCode.equalsIgnoreCase(expTaxCode) && actSalesAccount.equalsIgnoreCase(expSalesAccount)
			   && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actLSalesOrder.equalsIgnoreCase(expLSalesOrder)
			   && actRate.equalsIgnoreCase(expRate) && actGross.equalsIgnoreCase(expGross)) 
		{
			/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
			sl_CloseBtn.click();*/
			return true;
		}
		else
		{
			/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
			sl_CloseBtn.click();*/
			return false;
		}
	}
	
	
	@FindBy(xpath="//*[@id='navigation_menu']/li[3]/ul/li[3]/ul/li[10]")
	private static WebElement stockReportByTag;
	
	public boolean checkStockReportbyTagReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockReportByTag));
		stockReportByTag.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM") || actName.equalsIgnoreCase("WA COGS ITEM") || actName.equalsIgnoreCase("STD RATE COGS ITEM") 
					|| actName.equalsIgnoreCase("BR COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
	
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM, WA COGS ITEM, 43.00, 7.41, 318.66, , , , , 7.41, , 43.00, 7.41, 318.66, , , , , , , , , ]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, FIFO COGS ITEM, 69.00, 0.82, 56.50, , , , , , , 69.00, 0.80, 55.25, , , , , , , , , ]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[BR COGS ITEM, BR COGS ITEM, 62.00, 0.69, 42.75, , , , , , , 62.00, 0.69, 42.75, , , , , , , , , ]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[STD RATE COGS ITEM, STD RATE COGS ITEM, 96.00, 10.00, 960.00, , , , , 10.00, , 96.00, 2.26, 216.83, , , , , , , , , ]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[Grand Total, , 270.00, 18.92, 1,377.91, , , , , 17.41, , 270.00, 11.16, 633.49, , , , , , , , , ]";

		
		System.out.println("************************************checkStockReportbyTagReports********************************************");
	
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
			&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	public boolean checkStockReportbyTagReportPrintOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sr_ReportPrintBtn));
		sr_ReportPrintBtn.click();
		
	/*	getWaitForAlert();
		getAlert().accept();
		*/
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintLabel));
		
		String actConfirmMsg=ss_ReportPrintMsg.getText();
		String expConfirmMsg="";
		Thread.sleep(2000);
		
		System.out.println("Actual Msg		:		"+	actConfirmMsg		+ "Expected		"	+	expConfirmMsg);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintYesBtn));
		ss_ReportPrintYesBtn.click();
		
		Thread.sleep(3000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(0));
	 	
	 	Thread.sleep(1000);
	 	
	 	getDriver().switchTo().window(openTabs.get(1)).close();
	 	
	 	getDriver().switchTo().window(openTabs.get(0));
		
		System.out.println("***************************checkStockReportbyTagReportPrintOption*********************************");
		
		System.out.println("openTabs"+openTabs);
		System.out.println("Open Tabs Count : "+actOpenWindowsCount+"  Value Expected  "+expOpenWindowsCount);
		
		Thread.sleep(1000);
		
		if(actOpenWindowsCount==expOpenWindowsCount)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	
	
	
	
	
	public boolean checkStockReportbyTagReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		Thread.sleep(2000);
		int reportItemGridListCount=reportTableColumn1RowsList.size();
	    for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("STD RATE COGS ITEM"))
             {
        		 reportTableColumn1RowsList.get(i).click();
        		 Thread.sleep(1000);
        		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            	 report_BackTrackBtn.click();
            	 Thread.sleep(3000);
            	 
            	
            	try{
            		 String m="Please select a row in the grid to Backtrack";
            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
            		 {
            			 reportTableColumn1RowsList.get(i).click();
            			 Thread.sleep(2000);
            			 
            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            			 report_BackTrackBtn.click();
            			 Thread.sleep(3000);
            	
            		 }
            	}
            	catch(Exception e){
            		System.out.println("message not displaying");
            		
            	}
            	break;
             }
		     }
	    
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ml_BackTrackBtn));
		ml_BackTrackBtn.click();*/
	    Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("96.00");
		expMonthlyList.add("36.00");
		expMonthlyList.add("96.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("132.00");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("96.00");
		expDayList.add("36.00");
		expDayList.add("96.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("96.00");
		expDayList.add("36.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		expVouchersList.add("NDT57:SU/IND/TEXT1");
		expVouchersList.add("36.00");
		expVouchersList.add("24.00");
		expVouchersList.add("");
		expVouchersList.add("60.00");
		expVouchersList.add("NDT50:6");
		expVouchersList.add("60.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT57:SU/IND/TEXT3");
		expVouchersList.add("48.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("84.00");
		expVouchersList.add("SalRet:1");
		expVouchersList.add("84.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("96.00");
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("96.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("108.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("108.00");
		expVouchersList.add("12.00");
		expVouchersList.add("12.00");
		expVouchersList.add("108.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("108.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("96.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("96.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("SalRet:1")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo=documentNumberTxt.getAttribute("value");
		String expDocNo="1";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customerAccountTxt));
		String actCustomer=customerAccountTxt.getAttribute("value");
		String expCustomer="Customer A";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
	 	String actWarehouse = select1stRow_1stColumn.getText();
	 	String expWarehouse = "HYDERABAD";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
	 	String actItem = select1stRow_2ndColumn.getText();
	 	String expItem = "STD RATE COGS ITEM";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
	 	String actSalesAccount = select1stRow_3rdColumn.getText();
	 	String expSalesAccount = "Sales - Computers";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
	 	String actUnits = select1stRow_4thColumn.getText();
	 	String expUnits = "Pcs";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_6thColumn));
	 	String actQuantity = select1stRow_6thColumn.getText();
	 	String expQuantity = "12.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_7thColumn));
	 	String actLSalesInvoice = select1stRow_7thColumn.getText();
	 	String expLSalesInvoice = "NDT50:6";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_8thColumn));
	 	String actRate = select1stRow_8thColumn.getText();
	 	String expRate = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_9thColumn));
	 	String actGross = select1stRow_9thColumn.getText();
	 	String expGross = "120.00";
	 	
		System.out.println("**********************checkStockReportbyTagReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs        : "+actOpenWindowsCount         +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No      : "+actDocNo         +"  Value Expected  "+expDocNo);
		System.out.println("Customer Account : "+actCustomer      +"  Value Expected  "+expCustomer);
		System.out.println("Warehouse        : "+actWarehouse     +"  Value Expected  "+expWarehouse);
		System.out.println("Item             : "+actItem          +"  Value Expected  "+expItem);
		System.out.println("Sales Account    : "+actSalesAccount  +"  Value Expected  "+expSalesAccount);
		System.out.println("Units            : "+actUnits         +"  Value Expected  "+expUnits);
		System.out.println("Quantity         : "+actQuantity      +"  Value Expected  "+expQuantity);
		System.out.println("L Sales Order    : "+actLSalesInvoice +"  Value Expected  "+expLSalesInvoice);
		System.out.println("Rate             : "+actRate          +"  Value Expected  "+expRate);
		System.out.println("Gross            : "+actGross         +"  Value Expected  "+expGross);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			   && actDocNo.equalsIgnoreCase(expDocNo) && actCustomer.equalsIgnoreCase(expCustomer) && actWarehouse.equalsIgnoreCase(expWarehouse)
			   && actItem.equalsIgnoreCase(expItem) && actSalesAccount.equalsIgnoreCase(expSalesAccount)
			   && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actLSalesInvoice.equalsIgnoreCase(expLSalesInvoice)
			   && actRate.equalsIgnoreCase(expRate) && actGross.equalsIgnoreCase(expGross)) 
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reportWithLevel_CloseBtn));
			reportWithLevel_CloseBtn.click();
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
			sl_CloseBtn.click();
			return true;
		}
		else
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reportWithLevel_CloseBtn));
			reportWithLevel_CloseBtn.click();
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
			sl_CloseBtn.click();
			return false;
		}
	}
	
	
	@FindBy(xpath="//*[@id='579']")
	private static WebElement abcAnalysis;
	
	public boolean checkABCAnalysisReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		Thread.sleep(2000);
		
		getAction().moveToElement(abcAnalysis).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(abcAnalysis));
		abcAnalysis.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM") || actName.equalsIgnoreCase("WA COGS ITEM") || actName.equalsIgnoreCase("STD RATE COGS ITEM") 
					|| actName.equalsIgnoreCase("BR COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[A Product]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, 69.00, 56.50]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[BR COGS ITEM, 62.00, 42.75]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[WA COGS ITEM, 43.00, 318.66]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[STD RATE COGS ITEM, 96.00, 960.00]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow6ListCount;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[Grand Total, 270.00, 1,377.91]";
		
		
		System.out.println("************************************checkABCAnalysisReports********************************************");
	
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
			&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List))
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return true;
		}
		else
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return false;
		}
	}
	
	
	
	
	
	@FindBy (xpath="//select[@id='RITCombobox__1']")
	private static WebElement ABCClassificationDropdown;
	
	@FindBy (xpath="//select[@id='RITCombobox__2']")
	private static WebElement ABCCriteriaDropdown;
	
	
	public boolean checkABCAnalysisReportWithClassificationAndCriteriaOptions() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		Select Classification = new Select(ABCClassificationDropdown);
		Classification.selectByIndex(1);
		
		Select Criteria = new Select(ABCCriteriaDropdown);
		Criteria.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM, , 170.45]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[BR COGS ITEM, , 28.75]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[FIFO COGS ITEM, , 13.33]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[Sub Total, , 212.53]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[A Product]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow6ListCount;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[STD RATE COGS ITEM, , 360.00]";
		
		
		
		
		int reportsRow7ListCount = reportsRow7List.size();
		ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow7ListCount;i++)
		{
			String data = reportsRow7List.get(i).getText();
			reportsRow7ListArray.add(data);
		}
		String actRow7List = reportsRow7ListArray.toString();
		String expRow7List = "[Sub Total, , 360.00]";
		
		
		
		
		int reportsRow8ListCount = reportsRow8List.size();
		ArrayList<String> reportsRow8ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow8ListCount;i++)
		{
			String data = reportsRow8List.get(i).getText();
			reportsRow8ListArray.add(data);
		}
		String actRow8List = reportsRow8ListArray.toString();
		String expRow8List = "[Grand Total, , 572.53]";
		
		
		System.out.println("**************************checkABCAnalysisReportWithClassificationAndCriteriaOptions**********************************");
	
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		System.out.println(actRow7List);
		System.out.println(expRow7List);
		
		System.out.println(actRow8List);
		System.out.println(expRow8List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
			&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List)
			&& actRow7List.equalsIgnoreCase(expRow7List) && actRow8List.equalsIgnoreCase(expRow8List))
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
			sl_CloseBtn.click();
			return true;
		}
		else
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
			sl_CloseBtn.click();
			return false;
		}
	}
	
	
	
	
	@FindBy(xpath="//*[@id='580']")
	private static WebElement stockAnalysisByBatch;
	
	public boolean checkStockAnalysisByBatchReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getDriver().navigate().refresh();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		Thread.sleep(2000);
		
		getAction().sendKeys(Keys.END).build().perform();
		
		/*((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", stockAnalysisByBatch);
		getAction().moveToElement(stockAnalysisByBatch).build().perform();*/
		
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(stockAnalysisByBatch).build().perform();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockAnalysisByBatch));
		stockAnalysisByBatch.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("BR COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsByWarehouseRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsByWarehouseRow1ListArray = new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsByWarehouseRow1ListArray.add(data);
		}
		String actRow1List = reportsByWarehouseRow1ListArray.toString();
		String expRow1List = "[PVATR1#V1, 12.00, 0.88, 10.50]";
		

		int reportsByWarehouseRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsByWarehouseRow2ListArray = new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsByWarehouseRow2ListArray.add(data);
		}
		String actRow2List = reportsByWarehouseRow2ListArray.toString();
		String expRow2List = "[PVATR2#V1, 14.00, 0.88, 12.25]";
		
		
		
		int reportsByWarehouseRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsByWarehouseRow3ListArray = new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsByWarehouseRow3ListArray.add(data);
		}
		String actRow3List = reportsByWarehouseRow3ListArray.toString();
		String expRow3List = "[BATCH#OSVR1, 24.00, 0.42, 10.00]";
		
		
		
		int reportsByWarehouseRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsByWarehouseRow4ListArray = new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsByWarehouseRow4ListArray.add(data);
		}
		String actRow4List = reportsByWarehouseRow4ListArray.toString();
		String expRow4List = "[EX BATCH UPDATE, 12.00, 0.83, 10.00]";
		
		
		
		int reportsByWarehouseRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsByWarehouseRow5ListArray = new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsByWarehouseRow5ListArray.add(data);
		}
		String actRow5List = reportsByWarehouseRow5ListArray.toString();
		String expRow5List = "[Grand Total, 62.00, 3.00, 42.75]";
		
		
		
		/*int reportsByWarehouseRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsByWarehouseRow6ListArray = new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsByWarehouseRow6ListArray.add(data);
		}
		String actRow6List = reportsByWarehouseRow6ListArray.toString();
		String expRow6List = "[Grand Total, 86.00, 3.77, 67.25]";*/
		
		
		System.out.println("*********************************checkStockAnalysisByBatchReport*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		/*System.out.println(actRow6List);
		System.out.println(expRow6List);*/
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List)
			&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) /*&& actRow6List.equalsIgnoreCase(expRow6List)*/)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	@FindBy (xpath="//input[@id='FOption_580_0_DefaultFilter_0']")
	private static WebElement sab_DefaultFilterTxt;
	
	@FindBy (xpath="//*[@id='FilterFields_580_0']/ul[5]/li[1]/div/label/span")
	private static WebElement sab_report_FilterWarehouseNameChkbox;

	
	public boolean checkStockAnalysisByBatchReportFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseExpandBtn));
		report_FilterWarehouseExpandBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseNameChkboxSelected));
		
		if (report_FilterWarehouseNameChkbox.isSelected()==false) 
		{
			report_FilterWarehouseNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sab_DefaultFilterTxt));
		sab_DefaultFilterTxt.click();
		sab_DefaultFilterTxt.sendKeys("SECUNDERABAD");
		
		Thread.sleep(2000);
		
		sab_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
		
		boolean actReportTable = reportsTable.getText().isEmpty();
		boolean expReportTable = true;
		
		System.out.println("*********************************checkStockAnalysisByBatchReportFilterOption*****************************************");
		
		System.out.println(actReportTable);
		System.out.println(expReportTable);
		
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseNameChkboxSelected));
		
		if (report_FilterWarehouseNameChkbox.isSelected()==true) 
		{
			report_FilterWarehouseNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
		
		int actRowCount = reportsRowsCount.size();
		int expRowCount = 5; 
		
		System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reportWithLevel_CloseBtn));
		reportWithLevel_CloseBtn.click();
		
		if(actReportTable==expReportTable && actRowCount==expRowCount)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	@FindBy (xpath="//select[@id='RITCombobox__1']")
	private static WebElement stockTypeDropdown;
	
	@FindBy(xpath="//div[@id='dvReportDetails']/div/table/tbody")
	private static WebElement reportsTable;
	
	
	public boolean checkStockAnalysisByBatchReportWithStockTypeExpiredBatches() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockTypeDropdown));
		Select s=new Select(stockTypeDropdown);
		s.selectByIndex(2);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		int reportsByWarehouseRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsByWarehouseRow1ListArray = new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsByWarehouseRow1ListArray.add(data);
		}
		String actRow1List = reportsByWarehouseRow1ListArray.toString();
		String expRow1List = "[PVATR1#V1, 12.00, 0.88, 10.50]";
		

		int reportsByWarehouseRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsByWarehouseRow2ListArray = new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsByWarehouseRow2ListArray.add(data);
		}
		String actRow2List = reportsByWarehouseRow2ListArray.toString();
		String expRow2List = "[PVATR2#V1, 14.00, 0.88, 12.25]";
		
		
		
		int reportsByWarehouseRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsByWarehouseRow3ListArray = new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsByWarehouseRow3ListArray.add(data);
		}
		String actRow3List = reportsByWarehouseRow3ListArray.toString();
		String expRow3List = "[BATCH#OSVR1, 24.00, 0.42, 10.00]";
		
		
		
		int reportsByWarehouseRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsByWarehouseRow4ListArray = new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsByWarehouseRow4ListArray.add(data);
		}
		String actRow4List = reportsByWarehouseRow4ListArray.toString();
		String expRow4List = "[EX BATCH UPDATE, 12.00, 0.83, 10.00]";
		
		
		
		int reportsByWarehouseRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsByWarehouseRow5ListArray = new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsByWarehouseRow5ListArray.add(data);
		}
		String actRow5List = reportsByWarehouseRow5ListArray.toString();
		String expRow5List = "[Grand Total, 62.00, 3.00, 42.75]";
		
		
		
		/* *int reportsByWarehouseRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsByWarehouseRow6ListArray = new ArrayList<String>();
		for(int i=1;i<5;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsByWarehouseRow6ListArray.add(data);
		}
		String actRow6List = reportsByWarehouseRow6ListArray.toString();
		String expRow6List = "[Grand Total, 86.00, 3.77, 67.25]";
		*/
		
		System.out.println("*********************************checkStockAnalysisByBatchReportWithStockTypeGoodBatches*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		/*System.out.println(actRow6List);
		System.out.println(expRow6List);*/
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List)
			&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) /*&& actRow6List.equalsIgnoreCase(expRow6List)*/)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	public boolean checkStockAnalysisByBatchReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		int reportItemGridListCount=reportTableColumn1RowsList.size();
	    for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             String data1=reportTableColumn2RowsList.get(i).getText();
             
             System.out.println(data+"  "+data1);
             
             if (data.equalsIgnoreCase("PVATR2#V1") /*&& data1.equalsIgnoreCase("28.00")*/)
             {
        		 reportTableColumn1RowsList.get(i).click();
        		 Thread.sleep(1000);
        		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            	 report_BackTrackBtn.click();
            	 Thread.sleep(3000);
            	 
            	
            	try{
            		 String m="Please select a row in the grid to Backtrack";
            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
            		 {
            			 reportTableColumn1RowsList.get(i).click();
            			 Thread.sleep(2000);
            			 
            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            			 report_BackTrackBtn.click();
            			 Thread.sleep(3000);
            	
            		 }
            	}
            	catch(Exception e){
            		System.out.println("message not displaying");
            		
            	}
            	break;
             }
		     }
	    
	/*	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);

		//expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("60.00");
		expMonthlyList.add("34.00");
		expMonthlyList.add("62.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("96.00");
		expMonthlyList.add("34.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}

		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("60.00");
		expDayList.add("34.00");
		expDayList.add("62.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("60.00");
		expDayList.add("34.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("36.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT57:SU/IND/TEXT2");
		expVouchersList.add("48.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("84.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("84.00");
		expVouchersList.add("12.00");
		expVouchersList.add("12.00");
		expVouchersList.add("84.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("84.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("72.00");
		expVouchersList.add("NDT50:1");
		expVouchersList.add("72.00");
		expVouchersList.add("");
		expVouchersList.add("10.00");
		expVouchersList.add("62.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("60.00");
		expVouchersList.add("34.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("NDT57:SU/IND/TEXT2")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo = documentNumberTxt.getAttribute("value");
		String expDocNo = "SU/IND/TEXT2";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(vendorAccountTxt));
		String actVendor = vendorAccountTxt.getAttribute("value");
		String expVendor = "Vendor B";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(voucherHeaderCurrency));
		String actCurrency = voucherHeaderCurrency.getAttribute("value");
		String expCurrency = "INR";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(departmentTxt));
		String actDepartment = departmentTxt.getAttribute("value");
		String expDepartment = "INDIA";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(placeOFSupplyTxt));
		String actPlaceOfSupply = placeOFSupplyTxt.getAttribute("value");
		String expPlaceOfSupply = "Abu Dhabi";

		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(jurisdictionTxt));
		String actJurisdiction = jurisdictionTxt.getAttribute("value");
		String expJurisdiction = "DUBAI";

		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
		String actR1Warehouse = select1stRow_1stColumn.getText();
		String expR1Warehouse = "HYDERABAD";
		
		String actR1Item = select1stRow_2ndColumn.getText();
		String expR1Item = "BR COGS ITEM";
		
		String actR1TaxCode = select1stRow_3rdColumn.getText();
		String expR1TaxCode = "Standard Rated Purchase - Recoverable";
		
		String actR1PurchaseAccount = select1stRow_4thColumn.getText();
		String expR1PurchaseAccount = "BR COGS ACC INV";
		
		String actR1Units = select1stRow_5thColumn.getText();
		String expR1Units = "Dozs";
		
		String actR1Quantity = select1stRow_9thColumn.getText();
		String expR1Quantity = "1.00";
		
		String actR1Rate = select1stRow_11thColumn.getText();
		String expR1Rate = "10.00";
		
		String actR1Gross = select1stRow_12thColumn.getText();
		String expR1Gross = "10.00";
		
		String actR1Batch = select1stRow_16thColumn.getText();
		String expR1Batch = "PVATR1#V1";

		String actR1Expiry = select1stRow_18thColumn.getText();
		DateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar R1cal=Calendar.getInstance();
		R1cal.add(Calendar.DATE, 2); 
		String expR1Expiry=dtf.format(R1cal.getTime());
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
		String actR2Warehouse = select2ndRow_1stColumn.getText();
		String expR2Warehouse = "HYDERABAD";
		
		String actR2Item = select2ndRow_2ndColumn.getText();
		String expR2Item = "BR COGS ITEM";
		
		String actR2TaxCode = select2ndRow_3rdColumn.getText();
		String expR2TaxCode = "Standard Rated Purchase - Recoverable";
		
		String actR2PurchaseAccount = select2ndRow_4thColumn.getText();
		String expR2PurchaseAccount = "BR COGS ACC INV";
		
		String actR2Units = select2ndRow_5thColumn.getText();
		String expR2Units = "Dozs";
		
		String actR2Quantity = select2ndRow_9thColumn.getText();
		String expR2Quantity = "2.00";
		
		String actR2Rate = select2ndRow_11thColumn.getText();
		String expR2Rate = "10.00";
		
		String actR2Gross = select2ndRow_12thColumn.getText();
		String expR2Gross = "20.00";
		
		String actR2Batch = select2ndRow_16thColumn.getText();
		String expR2Batch = "PVATR2#V1";

		String actR2Expiry = select2ndRow_18thColumn.getText();
		Calendar R2cal=Calendar.getInstance();
		R2cal.add(Calendar.DATE, 5); 
		String expR2Expiry=dtf.format(R2cal.getTime());
	 	
		System.out.println("**********************checkStockAnalysisByBatchReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs       : "+actOpenWindowsCount +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No     : "+actDocNo			+"  Value Expected  "+expDocNo);
		System.out.println("Vendor          : "+actVendor			+"  Value Expected  "+expVendor);
		System.out.println("Currency        : "+actCurrency			+"  Value Expected  "+expCurrency);
		System.out.println("Department      : "+actDepartment		+"  Value Expected  "+expDepartment);
		System.out.println("PlaceOfSupply   : "+actPlaceOfSupply	+"  Value Expected  "+expPlaceOfSupply);
		System.out.println("Jurisdiction    : "+actJurisdiction		+"  Value Expected  "+expJurisdiction);
		
		System.out.println("*******************************ROW1**********************************");
		
		System.out.println("Warehouse       : "+actR1Warehouse			+"  Value Expected  "+expR1Warehouse);
		System.out.println("Item            : "+actR1Item				+"  Value Expected  "+expR1Item);
		System.out.println("TaxCode         : "+actR1TaxCode			+"  Value Expected  "+expR1TaxCode);
		System.out.println("PurchaseAccount : "+actR1PurchaseAccount	+"  Value Expected  "+expR1PurchaseAccount);
		System.out.println("Units           : "+actR1Units				+"  Value Expected  "+expR1Units);
		System.out.println("Quantity        : "+actR1Quantity			+"  Value Expected  "+expR1Quantity);
		System.out.println("Rate            : "+actR1Rate				+"  Value Expected  "+expR1Rate);
		System.out.println("Gross           : "+actR1Gross				+"  Value Expected  "+expR1Gross);
		System.out.println("Batch           : "+actR1Batch				+"  Value Expected  "+expR1Batch);
		System.out.println("Expiry          : "+actR1Expiry				+"  Value Expected  "+expR1Expiry);
		
		System.out.println("*******************************ROW2**********************************");
		
		System.out.println("Warehouse       : "+actR2Warehouse			+"  Value Expected  "+expR2Warehouse);
		System.out.println("Item            : "+actR2Item				+"  Value Expected  "+expR2Item);
		System.out.println("TaxCode         : "+actR2TaxCode			+"  Value Expected  "+expR2TaxCode);
		System.out.println("PurchaseAccount : "+actR2PurchaseAccount	+"  Value Expected  "+expR2PurchaseAccount);
		System.out.println("Units           : "+actR2Units				+"  Value Expected  "+expR2Units);
		System.out.println("Quantity        : "+actR2Quantity			+"  Value Expected  "+expR2Quantity);
		System.out.println("Rate            : "+actR2Rate				+"  Value Expected  "+expR2Rate);
		System.out.println("Gross           : "+actR2Gross				+"  Value Expected  "+expR2Gross);
		System.out.println("Batch           : "+actR2Batch				+"  Value Expected  "+expR2Batch);
		System.out.println("Expiry          : "+actR2Expiry				+"  Value Expected  "+expR2Expiry);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			   && actDocNo.equalsIgnoreCase(expDocNo) && actVendor.equalsIgnoreCase(expVendor) && actCurrency.equalsIgnoreCase(expCurrency) 
			   && actDepartment.equalsIgnoreCase(expDepartment) && actPlaceOfSupply.equalsIgnoreCase(expPlaceOfSupply) 
			   && actJurisdiction.equalsIgnoreCase(expJurisdiction) && actR1Warehouse.equalsIgnoreCase(expR1Warehouse) 
			   && actR1Item.equalsIgnoreCase(expR1Item) && actR1TaxCode.equalsIgnoreCase(expR1TaxCode) && actR1PurchaseAccount.equalsIgnoreCase(expR1PurchaseAccount) 
			   && actR1Units.equalsIgnoreCase(expR1Units) && actR1Quantity.equalsIgnoreCase(expR1Quantity) && actR1Rate.equalsIgnoreCase(expR1Rate) 
			   && actR1Gross.equalsIgnoreCase(expR1Gross) && actR1Batch.equalsIgnoreCase(expR1Batch) && actR1Expiry.equalsIgnoreCase(expR1Expiry)
			   && actR2Warehouse.equalsIgnoreCase(expR2Warehouse) 
			   && actR2Item.equalsIgnoreCase(expR2Item) && actR2TaxCode.equalsIgnoreCase(expR2TaxCode) && actR2PurchaseAccount.equalsIgnoreCase(expR2PurchaseAccount) 
			   && actR2Units.equalsIgnoreCase(expR2Units) && actR2Quantity.equalsIgnoreCase(expR2Quantity) && actR2Rate.equalsIgnoreCase(expR2Rate) 
			   && actR2Gross.equalsIgnoreCase(expR2Gross) && actR2Batch.equalsIgnoreCase(expR2Batch) && actR2Expiry.equalsIgnoreCase(expR2Expiry)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	@FindBy(xpath="//*[@id='581']")
	private static WebElement stockAnalysisByRMA;
	
	@FindBy (xpath="(//div[@id='dvReportDetails']/div/table/tbody)[1]/tr/td")
	private static List<WebElement> reportTableCells;
	
	public boolean checkStockAnalysisByRmaReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		getAction().sendKeys(Keys.END).build().perform();
		
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", stockAnalysisByRMA);
		getAction().moveToElement(stockAnalysisByRMA).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockAnalysisByRMA));
		stockAnalysisByRMA.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("WA COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportPage1Count = reportTableCells.size();
		ArrayList<String> reportPage1ListArray = new ArrayList<String>();
		for(int i=0;i<reportPage1Count;i++)
		{
			String data = reportTableCells.get(i).getText();
			reportPage1ListArray.add(data);
		}
		String actPage1List = reportPage1ListArray.toString();
		String expPage1List = "[1, RMA#R2OSV2, 1.00, 5.00, 5.00, 2, RMA#R2OSV3, 1.00, 5.00, 5.00, 3, RMA#R2OSV4, 1.00, 5.00, 5.00, 4, RMA#R2OSV5, 1.00, 5.00, 5.00, 5, RMA#R2OSV6, 1.00, 5.00, 5.00, 6, RMA#R2OSV7, 1.00, 5.00, 5.00, 7, RMA#R1OSV11, 1.00, 2.00, 2.00, 8, RMA#R1OSV12, 1.00, 2.00, 2.00, 9, RMA#R2OSV10, 1.00, 5.00, 5.00, 10, RMA#R2OSV11, 1.00, 5.00, 5.00, 11, RMA#R2OSV12, 1.00, 5.00, 5.00, 12, RMA#R1PVVAT1, 1.00, 10.50, 10.50, 13, RMA#R1PVVAT2, 1.00, 10.50, 10.50, 14, RMA#R1PVVAT3, 1.00, 10.50, 10.50, 15, RMA#R1PVVAT4, 1.00, 10.50, 10.50, 16, RMA#R1PVVAT5, 1.00, 10.50, 10.50, 17, RMA#R1PVVAT6, 1.00, 10.50, 10.50]";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_NextBtn));
		report_NextBtn.click();
		
		Thread.sleep(2000);
		
		int reportPage2Count = reportTableCells.size();
		ArrayList<String> reportPage2ListArray = new ArrayList<String>();
		for(int i=0;i<reportPage2Count;i++)
		{
			String data = reportTableCells.get(i).getText();
			reportPage2ListArray.add(data);
		}
		String actPage2List = reportPage2ListArray.toString();
		String expPage2List = "[18, RMA#R1PVVAT7, 1.00, 10.50, 10.50, 19, RMA#R1PVVAT8, 1.00, 10.50, 10.50, 20, RMA#R1PVVAT9, 1.00, 10.50, 10.50, 21, RMA#R2PVVAT1, 1.00, 10.50, 10.50, 22, RMA#R2PVVAT2, 1.00, 10.50, 10.50, 23, RMA#R2PVVAT3, 1.00, 10.50, 10.50, 24, RMA#R2PVVAT4, 1.00, 10.50, 10.50, 25, RMA#R2PVVAT5, 1.00, 10.50, 10.50, 26, RMA#R2PVVAT6, 1.00, 10.50, 10.50, 27, RMA#R2PVVAT7, 1.00, 10.50, 10.50, 28, RMA#R2PVVAT8, 1.00, 10.50, 10.50, 29, RMA#R2PVVAT9, 1.00, 10.50, 10.50, 30, Ex Rma Update, 1.00, 10.00, 10.00, 31, RMA#R1PVVAT10, 1.00, 10.50, 10.50, 32, RMA#R1PVVAT11, 1.00, 10.50, 10.50, 33, RMA#R1PVVAT12, 1.00, 10.50, 10.50, 34, RMA#R2PVVAT10, 1.00, 10.50, 10.50]";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_NextBtn));
		report_NextBtn.click();
		
		Thread.sleep(2000);
		
		int reportPage3Count = reportTableCells.size();
		ArrayList<String> reportPage3ListArray = new ArrayList<String>();
		for(int i=0;i<reportPage3Count;i++)
		{
			String data = reportTableCells.get(i).getText();
			reportPage3ListArray.add(data);
		}
		String actPage3List = reportPage3ListArray.toString();
		String expPage3List = "[35, Ex Rma Update1, 1.00, 10.00, 10.00, 36, Ex Rma Update2, 1.00, 10.00, 10.00, 37, Ex Rma Update3, 1.00, 10.00, 10.00, 38, Ex Rma Update4, 1.00, 10.00, 10.00, 39, Ex Rma Update5, 1.00, 10.00, 10.00, 40, Ex Rma Update6, 1.00, 10.00, 10.00, 41, Ex Rma Update7, 1.00, 10.00, 10.00, 42, Ex Rma Update8, 1.00, 10.00, 10.00, 43, Ex Rma Update9, 1.00, 10.00, 10.00, 44, Grand Total, 43.00, 380.00, 380.00]";
		
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_NextBtn));
		report_NextBtn.click();
		
		Thread.sleep(2000);
		
		int reportPage4Count = reportTableCells.size();
		ArrayList<String> reportPage4ListArray = new ArrayList<String>();
		for(int i=0;i<reportPage4Count;i++)
		{
			String data = reportTableCells.get(i).getText();
			reportPage4ListArray.add(data);
		}
		String actPage4List = reportPage4ListArray.toString();
		String expPage4List = "[43, Ex Rma Update9, 1.00, 10.00, 10.00, 44, Grand Total, 43.00, 380.00, 380.00]";*/
		
		System.out.println("*****************************************checkStockAnalysisByRmaReports***************************************");
		
		System.out.println(actPage1List);
		System.out.println(expPage1List);
		
		System.out.println(actPage2List);
		System.out.println(expPage2List);
		
		System.out.println(actPage3List);
		System.out.println(expPage3List);
		
		/*System.out.println(actPage4List);
		System.out.println(expPage4List);*/
		
		if(actPage1List.equalsIgnoreCase(expPage1List) && actPage2List.equalsIgnoreCase(expPage2List) && actPage3List.equalsIgnoreCase(expPage3List) 
			/*&& actPage4List.equalsIgnoreCase(expPage4List)*/)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	public boolean checkStockAnalysisByRmaReportsPrintOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_ReportPrintBtn));
		sl_ReportPrintBtn.click();
		
	/*	getWaitForAlert();
		getAlert().accept();*/
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintLabel));
		
		String actConfirmMsg=ss_ReportPrintMsg.getText();
		String expConfirmMsg="";
		Thread.sleep(2000);
		
		System.out.println("Actual Msg		:		"+	actConfirmMsg		+ "Expected		"	+	expConfirmMsg);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintYesBtn));
		ss_ReportPrintYesBtn.click();
		
		Thread.sleep(3000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(0));
	 	
	 	Thread.sleep(1000);
	 	
	 	getDriver().switchTo().window(openTabs.get(1)).close();
	 	
	 	getDriver().switchTo().window(openTabs.get(0));
		
		System.out.println("***************************checkStockAnalysisByRmaReportsPrintOption*********************************");
		
		System.out.println("openTabs"+openTabs);
		System.out.println("Open Tabs Count : "+actOpenWindowsCount+"  Value Expected  "+expOpenWindowsCount);
		
		Thread.sleep(1000);
		
		if(actOpenWindowsCount==expOpenWindowsCount)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	@FindBy(xpath="//*[@id='540']")
	
	private static WebElement binsReportMenu;
	
	//@FindBy(xpath="//span[contains(text(),'Stock Details by Bins')]")
	@FindBy(xpath="//*[@id='587']")
	private static WebElement stockDetailsByBins;
	
	
	public boolean checkStockDetailsByBinsReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(binsReportMenu).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(binsReportMenu));
		binsReportMenu.click();
		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		
		Thread.sleep(2000);
		getAction().moveToElement(stockDetailsByBins).build().perform();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockDetailsByBins));
		stockDetailsByBins.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsByWarehouseRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsByWarehouseRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsByWarehouseRow1ListArray.add(data);
		}
		String actRow1List = reportsByWarehouseRow1ListArray.toString();
		String expRow1List = "[FIFO COGS ITEM [FIFO COGS ITEM]]";
		

		int reportsByWarehouseRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsByWarehouseRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsByWarehouseRow2ListArray.add(data);
		}
		String actRow2List = reportsByWarehouseRow2ListArray.toString();
		String expRow2List = "[Bin4, 0, 0, 45.00, 6.00, 39.00]";
		
		
		
		int reportsByWarehouseRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsByWarehouseRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsByWarehouseRow3ListArray.add(data);
		}
		String actRow3List = reportsByWarehouseRow3ListArray.toString();
		String expRow3List = "[Bin5, 0, 0, 24.00, , 24.00]";
		
		
		
		int reportsByWarehouseRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsByWarehouseRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsByWarehouseRow4ListArray.add(data);
		}
		String actRow4List = reportsByWarehouseRow4ListArray.toString();
		String expRow4List = "[Total, , , 69.00, 6.00, 63.00]";
		
		
		System.out.println("*********************************checkStockDetailsByBinsReports*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List)
			&& actRow4List.equalsIgnoreCase(expRow4List))
		
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	@FindBy (xpath="//a[contains(text(),'Bins')]//i")
	private static WebElement report_FilterBinExpansion;
	
	
	@FindBy (xpath="//input[@id='5188']")
	private static WebElement binsReport_report_FilterBinNameChkbox;
	
	@FindBy(xpath="(//*[@id='5188'])[1]")
	private static WebElement report_FilterBinNameChkbox;
	
	@FindBy(xpath="(//*[@id='5188'])[1]/following-sibling::span")
	private static WebElement report_FilterBinNameChkboxSelected;
	
	@FindBy (xpath="//input[@id='FOption_587_0_DefaultFilter_0']")
	private static WebElement sdb_DefaultFilterTxt;
	
	
	
	public boolean checkStockDetailsByBinsReportFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBinExpansion));
		report_FilterBinExpansion.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBinNameChkboxSelected));
		
		if (report_FilterBinNameChkbox.isSelected()==false) 
		{
			report_FilterBinNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sdb_DefaultFilterTxt));
		sdb_DefaultFilterTxt.click();
		sdb_DefaultFilterTxt.sendKeys("Bin4");
		
		Thread.sleep(2000);
		
		sdb_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(3000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsByWarehouseRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsByWarehouseRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsByWarehouseRow1ListArray.add(data);
		}
		String actRow1List = reportsByWarehouseRow1ListArray.toString();
		String expRow1List = "[FIFO COGS ITEM [FIFO COGS ITEM]]";
		

		int reportsByWarehouseRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsByWarehouseRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsByWarehouseRow2ListArray.add(data);
		}
		String actRow2List = reportsByWarehouseRow2ListArray.toString();
		String expRow2List = "[Bin4, 0, 0, 45.00, 6.00, 39.00]";
		
		
		
		int reportsByWarehouseRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsByWarehouseRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsByWarehouseRow3ListArray.add(data);
		}
		String actRow3List = reportsByWarehouseRow3ListArray.toString();
		String expRow3List = "[Total, , , 45.00, 6.00, 39.00]";
		
		
		System.out.println("*********************************checkStockDetailsByBinsReportFilterOption*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBinNameChkboxSelected));
		
		if (report_FilterBinNameChkbox.isSelected()==true) 
		{
			report_FilterBinNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
		
		int actRowCount = reportsRowsCount.size();
		int expRowCount = 4; 
		
		System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List)
				&& actRowCount==expRowCount)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	@FindBy(xpath="//input[@id='id_header_86']")
	private static WebElement  stockTransferheaderWarehouse1Txt;
	
	@FindBy(xpath="//tbody[@id='id_header_86_table_body']/tr/td[2]")
    private static List<WebElement> wareHouseHeaderListCount;
	
	@FindBy(xpath="//input[@id='id_body_87']")
	private static WebElement  enter_BodyWarehouse2Txt;
	
	@FindBy(xpath="//tbody[@id='id_body_87_table_body']/tr/td[2]")
    private static List<WebElement> wareHouseBodyListCount;
	
	@FindBy(xpath="//i[@id='id_transactionentry_workflow_popup_close']")
	private static WebElement  workFlowCloseBtn;
	
	@FindBy(xpath="//i[@class='icon-pick icon-font5']")
	private static WebElement batchPickOnFIFOIcon;
	
	@FindBy(xpath="//label[@id='div_Ok']")
	private static WebElement batchOkIcon;
	
	
	
	
	
	public boolean checkStockDetailsByBinsReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		int reportItemGridListCount=reportTableColumn1RowsList.size();
	    for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("Bin5"))
             {
        		 reportTableColumn1RowsList.get(i).click();
        		 Thread.sleep(1000);
        		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            	 report_BackTrackBtn.click();
            	 Thread.sleep(3000);
            	 
            	
            	try{
            		 String m="Please select a row in the grid to Backtrack";
            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
            		 {
            			 reportTableColumn1RowsList.get(i).click();
            			 Thread.sleep(2000);
            			 
            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            			 report_BackTrackBtn.click();
            			 Thread.sleep(3000);
            	
            		 }
            	}
            	catch(Exception e){
            		System.out.println("message not displaying");
            		
            	}
            	break;
             }
		     }
	    
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
	    Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("57.00");
		expMonthlyList.add("24.00");
		expMonthlyList.add("69.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("93.00");
		expMonthlyList.add("24.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("57.00");
		expDayList.add("24.00");
		expDayList.add("69.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("57.00");
		expDayList.add("24.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("36.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("48.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("48.00");
		expVouchersList.add("9.00");
		expVouchersList.add("9.00");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("48.00");
		expVouchersList.add("");
		expVouchersList.add("9.00");
		expVouchersList.add("39.00");
		expVouchersList.add("NDT50:4");
		expVouchersList.add("39.00");
		expVouchersList.add("");
		expVouchersList.add("6.00");
		expVouchersList.add("33.00");
		expVouchersList.add("NDT57:SU/IND/TEXT4");
		expVouchersList.add("33.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("69.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("57.00");
		expVouchersList.add("24.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("StkTrf:2")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo = documentNumberTxt.getAttribute("value");
		String expDocNo = "2";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockTransferheaderWarehouse1Txt));
		String actFromWarehouse = stockTransferheaderWarehouse1Txt.getAttribute("value");
		String expFromWarehouse = "HYDERABAD";
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
		String actR1Warehouse = select1stRow_1stColumn.getText();
		String expR1Warehouse = "SECUNDERABAD";
		
		String actR1Item = select1stRow_2ndColumn.getText();
		String expR1Item = "STD RATE COGS ITEM";
		
		String actR1Units = select1stRow_3rdColumn.getText();
		String expR1Units = "Pcs";
		
		String actR1Quantity = select1stRow_4thColumn.getText();
		String expR1Quantity = "12.00";
		
		String actR1Rate = select1stRow_6thColumn.getText();
		String expR1Rate = "10.00";
		
		String actR1Gross = select1stRow_7thColumn.getText();
		String expR1Gross = "120.00";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
		String actR2Warehouse = select2ndRow_1stColumn.getText();
		String expR2Warehouse = "SECUNDERABAD";
		
		String actR2Item = select2ndRow_2ndColumn.getText();
		String expR2Item = "BR COGS ITEM";
		
		String actR2Units = select2ndRow_3rdColumn.getText();
		String expR2Units = "Pcs";
		
		String actR2Quantity = select2ndRow_4thColumn.getText();
		String expR2Quantity = "12.00";
		
		String actR2Rate = select2ndRow_6thColumn.getText();
		String expR2Rate = "10.00";
		
		String actR2Gross = select2ndRow_7thColumn.getText();
		String expR2Gross = "120.00";
		
		String actR2Batch = select2ndRow_8thColumn.getText();
		String expR2Batch = "BATCH#OSVR2";

		

		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select3rdRow_1stColumn));
		String actR3Warehouse = select3rdRow_1stColumn.getText();
		String expR3Warehouse = "SECUNDERABAD";
		
		String actR3Item = select3rdRow_2ndColumn.getText();
		String expR3Item = "FIFO COGS ITEM";
		
		String actR3Units = select3rdRow_3rdColumn.getText();
		String expR3Units = "Pcs";
		
		String actR3Quantity = select3rdRow_4thColumn.getText();
		String expR3Quantity = "9.00";
		
		String actR3Rate = select3rdRow_6thColumn.getText();
		String expR3Rate = "10.00";
		
		String actR3Gross = select3rdRow_7thColumn.getText();
		String expR3Gross = "90.00";
		
		String actR3Bins = select3rdRow_9thColumn.getText();
		String expR3Bins = "Bin4";
		
		String actR3Bins2 = select3rdRow_10thColumn.getText();
		String expR3Bins2 = "Bin Update";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select4thRow_1stColumn));
		String actR4Warehouse = select4thRow_1stColumn.getText();
		String expR4Warehouse = "SECUNDERABAD";
		
		String actR4Item = select4thRow_2ndColumn.getText();
		String expR4Item = "WA COGS ITEM";
		
		String actR4Units = select4thRow_3rdColumn.getText();
		String expR4Units = "Pcs";
		
		String actR4Quantity = select4thRow_4thColumn.getText();
		String expR4Quantity = "10.00";
		
		String actR4Rate = select4thRow_6thColumn.getText();
		String expR4Rate = "10.00";
		
		String actR4Gross = select4thRow_7thColumn.getText();
		String expR4Gross = "100.00";
		
		String actR4RMA = select4thRow_11thColumn.getText();
		String expR4RMA = "RMA#R1OSV1,RMA#R1OSV2,RMA#R1OSV3,RMA#R1OSV4,RMA#R1OSV5,RMA#R1OSV6,RMA#R1OSV7,RMA#R1OSV8,RMA#R1OSV9,RMA#R2OSV1";
		
		
		System.out.println("**********************checkStockDetailsByBinsReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs       : "+actOpenWindowsCount +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No     : "+actDocNo			+"  Value Expected  "+expDocNo);
		System.out.println("From Warehouse  : "+actFromWarehouse	+"  Value Expected  "+expFromWarehouse);
		
		System.out.println("*******************************ROW1**********************************");
		
		System.out.println("Warehouse       : "+actR1Warehouse			+"  Value Expected  "+expR1Warehouse);
		System.out.println("Item            : "+actR1Item				+"  Value Expected  "+expR1Item);
		System.out.println("Units           : "+actR1Units				+"  Value Expected  "+expR1Units);
		System.out.println("Quantity        : "+actR1Quantity			+"  Value Expected  "+expR1Quantity);
		System.out.println("Rate            : "+actR1Rate				+"  Value Expected  "+expR1Rate);
		System.out.println("Gross           : "+actR1Gross				+"  Value Expected  "+expR1Gross);
		
		
		System.out.println("*******************************ROW2**********************************");
		
		System.out.println("Warehouse       : "+actR2Warehouse			+"  Value Expected  "+expR2Warehouse);
		System.out.println("Item            : "+actR2Item				+"  Value Expected  "+expR2Item);
		System.out.println("Units           : "+actR2Units				+"  Value Expected  "+expR2Units);
		System.out.println("Quantity        : "+actR2Quantity			+"  Value Expected  "+expR2Quantity);
		System.out.println("Rate            : "+actR2Rate				+"  Value Expected  "+expR2Rate);
		System.out.println("Gross           : "+actR2Gross				+"  Value Expected  "+expR2Gross);
		System.out.println("Bins            : "+actR2Batch				+"  Value Expected  "+expR2Batch);
		
		System.out.println("*******************************ROW3**********************************");
		
		System.out.println("Warehouse       : "+actR3Warehouse			+"  Value Expected  "+expR3Warehouse);
		System.out.println("Item            : "+actR3Item				+"  Value Expected  "+expR3Item);
		System.out.println("Units           : "+actR3Units				+"  Value Expected  "+expR3Units);
		System.out.println("Quantity        : "+actR3Quantity			+"  Value Expected  "+expR3Quantity);
		System.out.println("Rate            : "+actR3Rate				+"  Value Expected  "+expR3Rate);
		System.out.println("Gross           : "+actR3Gross				+"  Value Expected  "+expR3Gross);
		System.out.println("Bins            : "+actR3Bins				+"  Value Expected  "+expR3Bins);
		System.out.println("Bins2           : "+actR3Bins2				+"  Value Expected  "+expR3Bins2);
		
		System.out.println("*******************************ROW4**********************************");
		
		System.out.println("Warehouse       : "+actR4Warehouse			+"  Value Expected  "+expR4Warehouse);
		System.out.println("Item            : "+actR4Item				+"  Value Expected  "+expR4Item);
		System.out.println("Units           : "+actR4Units				+"  Value Expected  "+expR4Units);
		System.out.println("Quantity        : "+actR4Quantity			+"  Value Expected  "+expR4Quantity);
		System.out.println("Rate            : "+actR4Rate				+"  Value Expected  "+expR4Rate);
		System.out.println("Gross           : "+actR4Gross				+"  Value Expected  "+expR4Gross);
		System.out.println("RMA             : "+actR4RMA				+"  Value Expected  "+expR4RMA);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			   && actDocNo.equalsIgnoreCase(expDocNo) && actFromWarehouse.equalsIgnoreCase(expFromWarehouse)
			   
			   
			   && actR1Warehouse.equalsIgnoreCase(expR1Warehouse) && actR1Item.equalsIgnoreCase(expR1Item) && actR1Units.equalsIgnoreCase(expR1Units) 
			   && actR1Quantity.equalsIgnoreCase(expR1Quantity) && actR1Rate.equalsIgnoreCase(expR1Rate) && actR1Gross.equalsIgnoreCase(expR1Gross) 
			   
			   && actR2Warehouse.equalsIgnoreCase(expR2Warehouse) && actR2Item.equalsIgnoreCase(expR2Item) && actR2Units.equalsIgnoreCase(expR2Units) 
			   && actR2Quantity.equalsIgnoreCase(expR2Quantity) && actR2Rate.equalsIgnoreCase(expR2Rate) && actR2Gross.equalsIgnoreCase(expR2Gross) && actR2Batch.equalsIgnoreCase(expR2Batch) 
			   
			   && actR3Warehouse.equalsIgnoreCase(expR3Warehouse) && actR3Item.equalsIgnoreCase(expR3Item) && actR3Units.equalsIgnoreCase(expR3Units) 
			   && actR3Quantity.equalsIgnoreCase(expR3Quantity) && actR3Rate.equalsIgnoreCase(expR3Rate) && actR3Gross.equalsIgnoreCase(expR3Gross) 
			   && actR3Bins.equalsIgnoreCase(expR3Bins) && actR3Bins2.equalsIgnoreCase(expR3Bins2)
			   
			   && actR4Warehouse.equalsIgnoreCase(expR4Warehouse) && actR4Item.equalsIgnoreCase(expR4Item) && actR4Units.equalsIgnoreCase(expR4Units) 
			   && actR4Quantity.equalsIgnoreCase(expR4Quantity) && actR4Rate.equalsIgnoreCase(expR4Rate) && actR4Gross.equalsIgnoreCase(expR4Gross) 
			   && actR4RMA.equalsIgnoreCase(expR4RMA)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Stock Balances by Bins')]")
	private static WebElement stockBalancesByBins;
	
	public boolean checkStockBalanaceByBinsReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		Thread.sleep(2000);

		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(binsReportMenu).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(binsReportMenu));
		binsReportMenu.click();
		Thread.sleep(2000);
		

		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(stockBalancesByBins).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockBalancesByBins));
		stockBalancesByBins.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_SelectAllItemsChkBox));
		sl_SelectAllItemsChkBox.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[Bin5 [Bin5]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, 0, 0, 24.00, , 24.00]";
	

		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Sub Total, , , 24.00, , 24.00]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[Bin4 [Bin4]]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[FIFO COGS ITEM, 0, 0, 45.00, 6.00, 39.00]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow6ListCount;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[Sub Total, , , 45.00, 6.00, 39.00]";
		
		
		
		int reportsRow7ListCount = reportsRow7List.size();
		ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow7ListCount;i++)
		{
			String data = reportsRow7List.get(i).getText();
			reportsRow7ListArray.add(data);
		}
		String actRow7List = reportsRow7ListArray.toString();
		String expRow7List = "[Grand Total, , , 69.00, 6.00, 63.00]";
		
		
		
		System.out.println("***************************checkStockBalanaceByBinsReports*********************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		System.out.println(actRow7List);
		System.out.println(expRow7List);
		
		Thread.sleep(1000);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List)
				&& actRow7List.equalsIgnoreCase(expRow7List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	@FindBy (xpath="//input[@id='FOption_588_0_DefaultFilter_0']")
	private static WebElement sbb_DefaultFilterTxt;
	
	@FindBy (xpath="//*[@id='FilterFields_588_0']/ul[23]/li[1]/div/label/span")
	private static WebElement sbb_report_FilterBinNameChkbox;
	
	public boolean checkStockBalanaceByBinsReportFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		Thread.sleep(2000);
		
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", report_FilterBinExpansion);
		
		Thread.sleep(2000); 
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBinExpansion));
		report_FilterBinExpansion.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBinNameChkboxSelected));
		
		if (report_FilterBinNameChkbox.isSelected()==false) 
		{
			report_FilterBinNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sbb_DefaultFilterTxt));
		sbb_DefaultFilterTxt.click();
		sbb_DefaultFilterTxt.sendKeys("Bin4");
		
		Thread.sleep(2000);
		
		sbb_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsByWarehouseRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsByWarehouseRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsByWarehouseRow1ListArray.add(data);
		}
		String actRow1List = reportsByWarehouseRow1ListArray.toString();
		String expRow1List = "[Bin4 [Bin4]]";
		

		int reportsByWarehouseRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsByWarehouseRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsByWarehouseRow2ListArray.add(data);
		}
		String actRow2List = reportsByWarehouseRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, 0, 0, 45.00, 6.00, 39.00]";
		
		
		
		int reportsByWarehouseRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsByWarehouseRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsByWarehouseRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsByWarehouseRow3ListArray.add(data);
		}
		String actRow3List = reportsByWarehouseRow3ListArray.toString();
		String expRow3List = "[Grand Total, , , 45.00, 6.00, 39.00]";
		
		
		System.out.println("*********************************checkStockBalanaceByBinsReportFilterOption*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBinNameChkboxSelected));
		
		if (report_FilterBinNameChkbox.isSelected()==true) 
		{
			report_FilterBinNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
		
		int actRowCount = reportsRowsCount.size();
		int expRowCount = 7; 
		
		System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List)
				&& actRowCount==expRowCount)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	public boolean checkStockBalanaceByBinsReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		int reportItemGridListCount=reportTableColumn1RowsList.size();
	    for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("FIFO COGS ITEM"))
             {
        		 reportTableColumn1RowsList.get(i).click();
        		 Thread.sleep(1000);
        		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            	 report_BackTrackBtn.click();
            	 Thread.sleep(3000);
            	 
            	
            	try{
            		 String m="Please select a row in the grid to Backtrack";
            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
            		 {
            			 reportTableColumn1RowsList.get(i).click();
            			 Thread.sleep(2000);
            			 
            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            			 report_BackTrackBtn.click();
            			 Thread.sleep(3000);
            	
            		 }
            	}
            	catch(Exception e){
            		System.out.println("message not displaying");
            		
            	}
            	break;
             }
		     }
	    
	/*	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
	    Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("57.00");
		expMonthlyList.add("24.00");
		expMonthlyList.add("69.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("93.00");
		expMonthlyList.add("24.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("57.00");
		expDayList.add("24.00");
		expDayList.add("69.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("57.00");
		expDayList.add("24.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("36.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("48.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("48.00");
		expVouchersList.add("9.00");
		expVouchersList.add("9.00");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("48.00");
		expVouchersList.add("");
		expVouchersList.add("9.00");
		expVouchersList.add("39.00");
		expVouchersList.add("NDT50:4");
		expVouchersList.add("39.00");
		expVouchersList.add("");
		expVouchersList.add("6.00");
		expVouchersList.add("33.00");
		expVouchersList.add("NDT57:SU/IND/TEXT4");
		expVouchersList.add("33.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("69.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("57.00");
		expVouchersList.add("24.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("StkTrf:2")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo = documentNumberTxt.getAttribute("value");
		String expDocNo = "2";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockTransferheaderWarehouse1Txt));
		String actFromWarehouse = stockTransferheaderWarehouse1Txt.getAttribute("value");
		String expFromWarehouse = "HYDERABAD";
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
		String actR1Warehouse = select1stRow_1stColumn.getText();
		String expR1Warehouse = "SECUNDERABAD";
		
		String actR1Item = select1stRow_2ndColumn.getText();
		String expR1Item = "STD RATE COGS ITEM";
		
		String actR1Units = select1stRow_3rdColumn.getText();
		String expR1Units = "Pcs";
		
		String actR1Quantity = select1stRow_4thColumn.getText();
		String expR1Quantity = "12.00";
		
		String actR1Rate = select1stRow_6thColumn.getText();
		String expR1Rate = "10.00";
		
		String actR1Gross = select1stRow_7thColumn.getText();
		String expR1Gross = "120.00";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
		String actR2Warehouse = select2ndRow_1stColumn.getText();
		String expR2Warehouse = "SECUNDERABAD";
		
		String actR2Item = select2ndRow_2ndColumn.getText();
		String expR2Item = "BR COGS ITEM";
		
		String actR2Units = select2ndRow_3rdColumn.getText();
		String expR2Units = "Pcs";
		
		String actR2Quantity = select2ndRow_4thColumn.getText();
		String expR2Quantity = "12.00";
		
		String actR2Rate = select2ndRow_6thColumn.getText();
		String expR2Rate = "10.00";
		
		String actR2Gross = select2ndRow_7thColumn.getText();
		String expR2Gross = "120.00";
		
		String actR2Batch = select2ndRow_8thColumn.getText();
		String expR2Batch = "BATCH#OSVR2";

		

		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select3rdRow_1stColumn));
		String actR3Warehouse = select3rdRow_1stColumn.getText();
		String expR3Warehouse = "SECUNDERABAD";
		
		String actR3Item = select3rdRow_2ndColumn.getText();
		String expR3Item = "FIFO COGS ITEM";
		
		String actR3Units = select3rdRow_3rdColumn.getText();
		String expR3Units = "Pcs";
		
		String actR3Quantity = select3rdRow_4thColumn.getText();
		String expR3Quantity = "9.00";
		
		String actR3Rate = select3rdRow_6thColumn.getText();
		String expR3Rate = "10.00";
		
		String actR3Gross = select3rdRow_7thColumn.getText();
		String expR3Gross = "90.00";
		
		String actR3Bins = select3rdRow_9thColumn.getText();
		String expR3Bins = "Bin4";
		
		String actR3Bins2 = select3rdRow_10thColumn.getText();
		String expR3Bins2 = "Bin Update";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select4thRow_1stColumn));
		String actR4Warehouse = select4thRow_1stColumn.getText();
		String expR4Warehouse = "SECUNDERABAD";
		
		String actR4Item = select4thRow_2ndColumn.getText();
		String expR4Item = "WA COGS ITEM";
		
		String actR4Units = select4thRow_3rdColumn.getText();
		String expR4Units = "Pcs";
		
		String actR4Quantity = select4thRow_4thColumn.getText();
		String expR4Quantity = "10.00";
		
		String actR4Rate = select4thRow_6thColumn.getText();
		String expR4Rate = "10.00";
		
		String actR4Gross = select4thRow_7thColumn.getText();
		String expR4Gross = "100.00";
		
		String actR4RMA = select4thRow_11thColumn.getText();
		String expR4RMA = "RMA#R1OSV1,RMA#R1OSV2,RMA#R1OSV3,RMA#R1OSV4,RMA#R1OSV5,RMA#R1OSV6,RMA#R1OSV7,RMA#R1OSV8,RMA#R1OSV9,RMA#R2OSV1";
		
		
		System.out.println("**********************checkStockDetailsByBinsReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs       : "+actOpenWindowsCount +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No     : "+actDocNo			+"  Value Expected  "+expDocNo);
		System.out.println("From Warehouse  : "+actFromWarehouse	+"  Value Expected  "+expFromWarehouse);
		
		System.out.println("*******************************ROW1**********************************");
		
		System.out.println("Warehouse       : "+actR1Warehouse			+"  Value Expected  "+expR1Warehouse);
		System.out.println("Item            : "+actR1Item				+"  Value Expected  "+expR1Item);
		System.out.println("Units           : "+actR1Units				+"  Value Expected  "+expR1Units);
		System.out.println("Quantity        : "+actR1Quantity			+"  Value Expected  "+expR1Quantity);
		System.out.println("Rate            : "+actR1Rate				+"  Value Expected  "+expR1Rate);
		System.out.println("Gross           : "+actR1Gross				+"  Value Expected  "+expR1Gross);
		
		
		System.out.println("*******************************ROW2**********************************");
		
		System.out.println("Warehouse       : "+actR2Warehouse			+"  Value Expected  "+expR2Warehouse);
		System.out.println("Item            : "+actR2Item				+"  Value Expected  "+expR2Item);
		System.out.println("Units           : "+actR2Units				+"  Value Expected  "+expR2Units);
		System.out.println("Quantity        : "+actR2Quantity			+"  Value Expected  "+expR2Quantity);
		System.out.println("Rate            : "+actR2Rate				+"  Value Expected  "+expR2Rate);
		System.out.println("Gross           : "+actR2Gross				+"  Value Expected  "+expR2Gross);
		System.out.println("Bins            : "+actR2Batch				+"  Value Expected  "+expR2Batch);
		
		System.out.println("*******************************ROW3**********************************");
		
		System.out.println("Warehouse       : "+actR3Warehouse			+"  Value Expected  "+expR3Warehouse);
		System.out.println("Item            : "+actR3Item				+"  Value Expected  "+expR3Item);
		System.out.println("Units           : "+actR3Units				+"  Value Expected  "+expR3Units);
		System.out.println("Quantity        : "+actR3Quantity			+"  Value Expected  "+expR3Quantity);
		System.out.println("Rate            : "+actR3Rate				+"  Value Expected  "+expR3Rate);
		System.out.println("Gross           : "+actR3Gross				+"  Value Expected  "+expR3Gross);
		System.out.println("Bins            : "+actR3Bins				+"  Value Expected  "+expR3Bins);
		System.out.println("Bins2           : "+actR3Bins2				+"  Value Expected  "+expR3Bins2);
		
		System.out.println("*******************************ROW4**********************************");
		
		System.out.println("Warehouse       : "+actR4Warehouse			+"  Value Expected  "+expR4Warehouse);
		System.out.println("Item            : "+actR4Item				+"  Value Expected  "+expR4Item);
		System.out.println("Units           : "+actR4Units				+"  Value Expected  "+expR4Units);
		System.out.println("Quantity        : "+actR4Quantity			+"  Value Expected  "+expR4Quantity);
		System.out.println("Rate            : "+actR4Rate				+"  Value Expected  "+expR4Rate);
		System.out.println("Gross           : "+actR4Gross				+"  Value Expected  "+expR4Gross);
		System.out.println("RMA             : "+actR4RMA				+"  Value Expected  "+expR4RMA);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			   && actDocNo.equalsIgnoreCase(expDocNo) && actFromWarehouse.equalsIgnoreCase(expFromWarehouse)
			   
			   
			   && actR1Warehouse.equalsIgnoreCase(expR1Warehouse) && actR1Item.equalsIgnoreCase(expR1Item) && actR1Units.equalsIgnoreCase(expR1Units) 
			   && actR1Quantity.equalsIgnoreCase(expR1Quantity) && actR1Rate.equalsIgnoreCase(expR1Rate) && actR1Gross.equalsIgnoreCase(expR1Gross) 
			   
			   && actR2Warehouse.equalsIgnoreCase(expR2Warehouse) && actR2Item.equalsIgnoreCase(expR2Item) && actR2Units.equalsIgnoreCase(expR2Units) 
			   && actR2Quantity.equalsIgnoreCase(expR2Quantity) && actR2Rate.equalsIgnoreCase(expR2Rate) && actR2Gross.equalsIgnoreCase(expR2Gross) && actR2Batch.equalsIgnoreCase(expR2Batch) 
			   
			   && actR3Warehouse.equalsIgnoreCase(expR3Warehouse) && actR3Item.equalsIgnoreCase(expR3Item) && actR3Units.equalsIgnoreCase(expR3Units) 
			   && actR3Quantity.equalsIgnoreCase(expR3Quantity) && actR3Rate.equalsIgnoreCase(expR3Rate) && actR3Gross.equalsIgnoreCase(expR3Gross) 
			   && actR3Bins.equalsIgnoreCase(expR3Bins) && actR3Bins2.equalsIgnoreCase(expR3Bins2)
			   
			   && actR4Warehouse.equalsIgnoreCase(expR4Warehouse) && actR4Item.equalsIgnoreCase(expR4Item) && actR4Units.equalsIgnoreCase(expR4Units) 
			   && actR4Quantity.equalsIgnoreCase(expR4Quantity) && actR4Rate.equalsIgnoreCase(expR4Rate) && actR4Gross.equalsIgnoreCase(expR4Gross) 
			   && actR4RMA.equalsIgnoreCase(expR4RMA)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Stock Balances by Item by Bins')]")
	
	private static WebElement stockBalancesByItemByBins;
	
	public boolean checkStockBalancesByItemByBinsReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		Thread.sleep(2000);

		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(binsReportMenu).build().perform();
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(binsReportMenu));
		binsReportMenu.click();
		
		Thread.sleep(2000);

		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(stockBalancesByItemByBins).build().perform();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockBalancesByItemByBins));
		stockBalancesByItemByBins.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List ="[FIFO COGS ITEM [FIFO COGS ITEM]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Bin4, 0, 0, 45.00, 6.00, , 39.00]";
	

		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Bin5, 0, 0, 24.00, , , 24.00]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[Total, , , 69.00, 6.00, , 63.00]";
		
		
		System.out.println("***************************checkStockBalanaceByBinsReports*********************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		Thread.sleep(1000);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List))			
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	public boolean checkStockBalancesByItemByBinsReportPrintOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_ReportPrintBtn));
		sl_ReportPrintBtn.click();
		/*getWaitForAlert();
		getAlert().accept();
		*/
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintLabel));
		
		String actConfirmMsg=ss_ReportPrintMsg.getText();
		String expConfirmMsg="";
		Thread.sleep(2000);
		
		System.out.println("Actual Msg		:		"+	actConfirmMsg		+ "Expected		"	+	expConfirmMsg);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintYesBtn));
		ss_ReportPrintYesBtn.click();
		
		Thread.sleep(3000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(0));
	 	
	 	Thread.sleep(1000);
	 	
	 	getDriver().switchTo().window(openTabs.get(1)).close();
	 	
	 	getDriver().switchTo().window(openTabs.get(0));
		
		System.out.println("***************************checkStockBalancesByItemByBinsReportPrintOption*********************************");
		
		System.out.println("openTabs"+openTabs);
		System.out.println("Open Tabs Count : "+actOpenWindowsCount+"  Value Expected  "+expOpenWindowsCount);
		
		Thread.sleep(1000);
		
		if(actOpenWindowsCount==expOpenWindowsCount)
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn1));
			report_CloseBtn1.click();
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
			sl_CloseBtn.click();
			return true;
		}
		else
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
			sl_CloseBtn.click();
			return false;
		}
	}

	
	
	
	
	
	@FindBy(xpath="//span[contains(text(),'Expired Stock by Bins')]")
	
	private static WebElement expiredStockByBins;
	
	
	public boolean checkExpiredStockByBinsReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		Thread.sleep(2000);

		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(binsReportMenu).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(binsReportMenu));
		binsReportMenu.click();
		
		Thread.sleep(2000);

		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(expiredStockByBins).build().perform();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(expiredStockByBins));
		expiredStockByBins.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);	
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);
		
		boolean actReportsTable = reportsTable.getText().isEmpty();
		boolean expReportsTable = true;

		System.out.println("report_Body : "+actReportsTable+" Value Expected : "+expReportsTable);
		
		if(actReportsTable==expReportsTable)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	@FindBy (xpath="//span[@id='id_prog_spanPlus']")
	private static WebElement customizationFieldsProgrammableFieldExpansion;
	
	@FindBy (xpath="//li[@id='TColProg-2']/span")
	private static WebElement customizationFieldsProgrammableField;
	
	
	public boolean checkExpiredStockByBinsReportCustomizationOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_ReportCustomizeBtn));
		report_ReportCustomizeBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customizationFieldsProgrammableFieldExpansion));
		customizationFieldsProgrammableFieldExpansion.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customizationFieldsProgrammableField));
		getAction().doubleClick(customizationFieldsProgrammableField).build().perform();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(osr_customizeSaveBtn));
		osr_customizeSaveBtn.click();
		
		String expMessage = "Data saved successfully";
	    
	    String actMessage = checkValidationMessage(expMessage);
	    
	    Thread.sleep(4000);
	    
	    /*if (sl_OkBtn.isDisplayed()==true) 
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
			sl_OkBtn.click();
			
			Thread.sleep(4000);
		}
	    else
	    {
	    	if (osr_customizeCloseBtn.isDisplayed()==true) 
	    	{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(osr_customizeCloseBtn));
				osr_customizeCloseBtn.click();
				
				Thread.sleep(4000);
			}
	    }*/
		
	    int reportsHeaderListCount1 = reportsHeaderList.size();
		ArrayList<String> reportsHeaderListArray1 = new ArrayList<String>();
		for(int i=0;i<reportsHeaderListCount1;i++)
		{
			String data = reportsHeaderList.get(i).getText();
			reportsHeaderListArray1.add(data);
		}
		String actHeaderList1 = reportsHeaderListArray1.toString();
		String expHeaderList1= "[#, Bin, Expiry Date, Manufacturing Date, Quantity, Reserved Quantity, On-Hold Quantity, Net Quantity, Programmable Field]";
	    
	    System.out.println(actHeaderList1);
	    System.out.println(expHeaderList1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_ReportCustomizeBtn));
		report_ReportCustomizeBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CustomizationDeleteLayoutBtn));
		report_CustomizationDeleteLayoutBtn.click();
	
		getWaitForAlert();
		getAlert().accept();
		
		String expDeleteMessage = "Layout Deleted Successfully";
	    
	    String actDeleteMessage = checkValidationMessage(expDeleteMessage);
	    
	    Thread.sleep(4000);
	    
	    /*if (sl_OkBtn.isDisplayed()==true) 
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
			sl_OkBtn.click();
			
			Thread.sleep(4000);
		}
	    else
	    {
	    	if (osr_customizeCloseBtn.isDisplayed()==true) 
	    	{
				getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(osr_customizeCloseBtn));
				osr_customizeCloseBtn.click();
				
				Thread.sleep(4000);
			}
	    }*/
	    
	    int reportsHeaderListCount = reportsHeaderList.size();
		ArrayList<String> reportsHeaderListArray = new ArrayList<String>();
		for(int i=0;i<reportsHeaderListCount;i++)
		{
			String data = reportsHeaderList.get(i).getText();
			reportsHeaderListArray.add(data);
		}
		String actHeaderList = reportsHeaderListArray.toString();
		String expHeaderList = "[#, Bin, Expiry Date, Manufacturing Date, Quantity, Reserved Quantity, On-Hold Quantity, Net Quantity]";
	    
	    System.out.println(actHeaderList);
	    System.out.println(expHeaderList);
	    
		if(actMessage.equalsIgnoreCase(expMessage) && actHeaderList1.equalsIgnoreCase(expHeaderList1) && actDeleteMessage.equalsIgnoreCase(expDeleteMessage)
				&& actHeaderList.equalsIgnoreCase(expHeaderList))
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
			sl_CloseBtn.click();
			return true;
		}
		else
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
			sl_CloseBtn.click();
			return false;
		}
	}
	

	
	@FindBy(xpath="//*[@id='645']")
	private static WebElement stockBalanceByWarehouse;

	public boolean checkStockBalanceByWarehouseReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getDriver().navigate().refresh();
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(stockBalanceByWarehouse).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockBalanceByWarehouse));
		stockBalanceByWarehouse.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_SelectAllItemsChkBox));
		sl_SelectAllItemsChkBox.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(4000);
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[HYDERABAD [HYDERABAD]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[WA COGS ITEM, 43.00, 43.00, ]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[FIFO COGS ITEM, 69.00, 6.00, 63.00]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			if (i!=2) 
			{
				String data = reportsRow4List.get(i).getText();
				reportsRow4ListArray.add(data);
			}
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[BR COGS ITEM, 12.00, 50.00]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[STD RATE COGS ITEM, 96.00, 10.00, 86.00]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow6ListCount;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[Grand Total, 270.00, 71.00, 199.00]";
		
		
		System.out.println("************************************checkStockBalanceByWarehouseReports********************************************");
	
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
			&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List))
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return true;
		}
		else
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return false;
		}
	}


	
	
	
	
	
	
	
	public boolean checkStockBalanceByWarehouseReportIncludeServiceTypeItemOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_IncludeServiceTypeItemChkBox));
		sl_IncludeServiceTypeItemChkBox.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[HYDERABAD [HYDERABAD]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[WA COGS ITEM, 43.00, 43.00, ]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[FIFO COGS ITEM, 69.00, 6.00, 63.00]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			if (i!=2) 
			{
				String data = reportsRow4List.get(i).getText();
				reportsRow4ListArray.add(data);
			}
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[BR COGS ITEM, 12.00, 50.00]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[STD RATE COGS ITEM, 96.00, 10.00, 86.00]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow6ListCount;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[Grand Total, 270.00, 71.00, 199.00]";
		
		
		System.out.println("************************************checkStockBalanceByWarehouseReportIncludeServiceTypeItemOption********************************************");
	
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
			&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	
	
	
	
	
	
	public boolean checkStockBalanceByWarehouseReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		int reportItemGridListCount=reportTableColumn1RowsList.size();
		   
		for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("HYDERABAD [HYDERABAD]"))
             {
                 int count =i+5;
                 
                 for (int j = i; j < count; j++) 
     		     {
                	 String data1=reportTableColumn1RowsList.get(j).getText();
		             
                	 if (data1.equalsIgnoreCase("STD RATE COGS ITEM"))
                     {
                		 System.err.println("Item Name : "+data1);
                		 reportTableColumn1RowsList.get(j).click();
                		 Thread.sleep(1000);
                		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            	 report_BackTrackBtn.click();
		            	 Thread.sleep(3000);
		            	 
		            	
		            	try{
		            		 String m="Please select a row in the grid to Backtrack";
		            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
		            		 {
		            			 reportTableColumn1RowsList.get(i).click();
		            			 Thread.sleep(2000);
		            			 
		            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            			 report_BackTrackBtn.click();
		            			 Thread.sleep(3000);
		            	
		            		 }
		            	}
		            	catch(Exception e){
		            		System.out.println("message not displaying");
		            		
		            	}
		            	break;
                     }
     		     }
             }
	      }
	    
	    
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("96.00");
		expMonthlyList.add("36.00");
		expMonthlyList.add("96.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("132.00");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("96.00");
		expDayList.add("36.00");
		expDayList.add("96.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("96.00");
		expDayList.add("36.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		
		expVouchersList.add("NDT57:SU/IND/TEXT1");
		expVouchersList.add("36.00");
		expVouchersList.add("24.00");
		expVouchersList.add("");
		expVouchersList.add("60.00");
		expVouchersList.add("NDT50:6");
		expVouchersList.add("60.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT57:SU/IND/TEXT3");
		expVouchersList.add("48.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("84.00");
		expVouchersList.add("SalRet:1");
		expVouchersList.add("84.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("96.00");
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("96.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("108.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("108.00");
		expVouchersList.add("12.00");
		expVouchersList.add("12.00");
		expVouchersList.add("108.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("108.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("96.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("96.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("NDT57:SU/IND/TEXT3")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo = documentNumberTxt.getAttribute("value");
		String expDocNo = "SU/IND/TEXT3";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(vendorAccountTxt));
		String actVendor = vendorAccountTxt.getAttribute("value");
		String expVendor = "Vendor B";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(voucherHeaderCurrency));
		String actCurrency = voucherHeaderCurrency.getAttribute("value");
		String expCurrency = "INR";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(departmentTxt));
		String actDepartment = departmentTxt.getAttribute("value");
		String expDepartment = "INDIA";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(placeOFSupplyTxt));
		String actPlaceOfSupply = placeOFSupplyTxt.getAttribute("value");
		String expPlaceOfSupply = "Abu Dhabi";

		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(jurisdictionTxt));
		String actJurisdiction = jurisdictionTxt.getAttribute("value");
		String expJurisdiction = "DUBAI";

		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
		String actR1Warehouse = select1stRow_1stColumn.getText();
		String expR1Warehouse = "HYDERABAD";
		
		String actR1Item = select1stRow_2ndColumn.getText();
		String expR1Item = "STD RATE COGS ITEM";
		
		String actR1TaxCode = select1stRow_3rdColumn.getText();
		String expR1TaxCode = "Standard Rated Purchase - Recoverable";
		
		String actR1PurchaseAccount = select1stRow_4thColumn.getText();
		String expR1PurchaseAccount = "STD RATE COGS ACC INV";
		
		String actR1Units = select1stRow_5thColumn.getText();
		String expR1Units = "Dozs";
		
		String actR1Quantity = select1stRow_9thColumn.getText();
		String expR1Quantity = "1.00";
		
		String actR1Rate = select1stRow_11thColumn.getText();
		String expR1Rate = "10.00";
		
		String actR1Gross = select1stRow_12thColumn.getText();
		String expR1Gross = "10.00";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
		String actR2Warehouse = select2ndRow_1stColumn.getText();
		String expR2Warehouse = "HYDERABAD";
		
		String actR2Item = select2ndRow_2ndColumn.getText();
		String expR2Item = "STD RATE COGS ITEM";
		
		String actR2TaxCode = select2ndRow_3rdColumn.getText();
		String expR2TaxCode = "Standard Rated Purchase - Recoverable";
		
		String actR2PurchaseAccount = select2ndRow_4thColumn.getText();
		String expR2PurchaseAccount = "STD RATE COGS ACC INV";
		
		String actR2Units = select2ndRow_5thColumn.getText();
		String expR2Units = "Dozs";
		
		String actR2Quantity = select2ndRow_9thColumn.getText();
		String expR2Quantity = "2.00";
		
		String actR2Rate = select2ndRow_11thColumn.getText();
		String expR2Rate = "10.00";
		
		String actR2Gross = select2ndRow_12thColumn.getText();
		String expR2Gross = "20.00";
	 	
		System.out.println("**********************checkStockValuationReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs        : "+actOpenWindowsCount         +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No     : "+actDocNo			+"  Value Expected  "+expDocNo);
		System.out.println("Vendor          : "+actVendor			+"  Value Expected  "+expVendor);
		System.out.println("Currency        : "+actCurrency			+"  Value Expected  "+expCurrency);
		System.out.println("Department      : "+actDepartment		+"  Value Expected  "+expDepartment);
		System.out.println("PlaceOfSupply   : "+actPlaceOfSupply	+"  Value Expected  "+expPlaceOfSupply);
		System.out.println("Jurisdiction    : "+actJurisdiction		+"  Value Expected  "+expJurisdiction);
		
		System.out.println("*******************************ROW1**********************************");
		
		System.out.println("Warehouse       : "+actR1Warehouse			+"  Value Expected  "+expR1Warehouse);
		System.out.println("Item            : "+actR1Item				+"  Value Expected  "+expR1Item);
		System.out.println("TaxCode         : "+actR1TaxCode			+"  Value Expected  "+expR1TaxCode);
		System.out.println("PurchaseAccount : "+actR1PurchaseAccount	+"  Value Expected  "+expR1PurchaseAccount);
		System.out.println("Units           : "+actR1Units				+"  Value Expected  "+expR1Units);
		System.out.println("Quantity        : "+actR1Quantity			+"  Value Expected  "+expR1Quantity);
		System.out.println("Rate            : "+actR1Rate				+"  Value Expected  "+expR1Rate);
		System.out.println("Gross           : "+actR1Gross				+"  Value Expected  "+expR1Gross);
		
		System.out.println("*******************************ROW2**********************************");
		
		System.out.println("Warehouse       : "+actR2Warehouse			+"  Value Expected  "+expR2Warehouse);
		System.out.println("Item            : "+actR2Item				+"  Value Expected  "+expR2Item);
		System.out.println("TaxCode         : "+actR2TaxCode			+"  Value Expected  "+expR2TaxCode);
		System.out.println("PurchaseAccount : "+actR2PurchaseAccount	+"  Value Expected  "+expR2PurchaseAccount);
		System.out.println("Units           : "+actR2Units				+"  Value Expected  "+expR2Units);
		System.out.println("Quantity        : "+actR2Quantity			+"  Value Expected  "+expR2Quantity);
		System.out.println("Rate            : "+actR2Rate				+"  Value Expected  "+expR2Rate);
		System.out.println("Gross           : "+actR2Gross				+"  Value Expected  "+expR2Gross);
		
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			   && actDocNo.equalsIgnoreCase(expDocNo) && actVendor.equalsIgnoreCase(expVendor) && actCurrency.equalsIgnoreCase(expCurrency) 
			   && actDepartment.equalsIgnoreCase(expDepartment) && actPlaceOfSupply.equalsIgnoreCase(expPlaceOfSupply) 
			   && actJurisdiction.equalsIgnoreCase(expJurisdiction) && actR1Warehouse.equalsIgnoreCase(expR1Warehouse) 
			   && actR1Item.equalsIgnoreCase(expR1Item) && actR1TaxCode.equalsIgnoreCase(expR1TaxCode) && actR1PurchaseAccount.equalsIgnoreCase(expR1PurchaseAccount) 
			   && actR1Units.equalsIgnoreCase(expR1Units) && actR1Quantity.equalsIgnoreCase(expR1Quantity) && actR1Rate.equalsIgnoreCase(expR1Rate) 
			   && actR1Gross.equalsIgnoreCase(expR1Gross) && actR1Warehouse.equalsIgnoreCase(expR1Warehouse) 
			   && actR2Item.equalsIgnoreCase(expR2Item) && actR2TaxCode.equalsIgnoreCase(expR2TaxCode) && actR2PurchaseAccount.equalsIgnoreCase(expR2PurchaseAccount) 
			   && actR2Units.equalsIgnoreCase(expR2Units) && actR2Quantity.equalsIgnoreCase(expR2Quantity) && actR2Rate.equalsIgnoreCase(expR2Rate) 
			   && actR2Gross.equalsIgnoreCase(expR2Gross)) 
		{
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	@FindBy(xpath="//*[@id='621']")
	private static WebElement stockAgeingAnalysisMenu;
	
	
	@FindBy(xpath="//span[contains(text(),'Ageing Analysis')]")
	private static WebElement ageingAnalysis;
	
	
	public boolean checkStockAgeingAnalysisReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(stockAgeingAnalysisMenu).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockAgeingAnalysisMenu));
		stockAgeingAnalysisMenu.click();
		
		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(ageingAnalysis).build().perform();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ageingAnalysis));
		ageingAnalysis.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_SelectAllItemsChkBox));
		sl_SelectAllItemsChkBox.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM, 43.00, 318.66, 32.00, 237.14, , , , , , , , , , , , , 11.00, 81.52, ]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, 69.00, 56.50, 48.00, 39.30, , , , , , , , , , , , , 21.00, 17.20, ]";
	

		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[BR COGS ITEM, 62.00, 42.75, 48.00, 33.10, , , , , , , , , , , , , 14.00, 9.65, ]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[STD RATE COGS ITEM, 96.00, 960.00, 84.00, 840.00, , , , , , , , , , , , , 12.00, 120.00, ]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[Grand Total, 270.00, 1,377.91, 212.00, 1,149.54, , , , , , , , , , , , , 58.00, 228.37, ]";
		
		
		System.out.println("***************************checkStockAgeingAnalysisReports*********************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		Thread.sleep(1000);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))	
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	@FindBy (xpath="//input[@id='FOption_582_0_DefaultFilter_0']")
	private static WebElement saa_DefaultFilterTxt;
	
	
	public boolean checkStockAgeingAnalysisReportFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseExpandBtn));
		report_FilterWarehouseExpandBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseNameChkboxSelected));
		
		if (report_FilterWarehouseNameChkbox.isSelected()==false) 
		{
			report_FilterWarehouseNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(saa_DefaultFilterTxt));
		saa_DefaultFilterTxt.click();
		saa_DefaultFilterTxt.sendKeys("Hyderabad");
		
		Thread.sleep(2000);
		
		saa_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM, 53.00, 318.66, 32.00, 237.14, , , , , , , , , , , , , 21.00, 155.63, ]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, 78.00, 55.25, 48.00, 38.43, , , , , , , , , , , , , 30.00, 24.02, ]";
	

		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[BR COGS ITEM, 74.00, 42.75, 48.00, 33.10, , , , , , , , , , , , , 26.00, 17.93, ]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[STD RATE COGS ITEM, 108.00, 960.00, 84.00, 840.00, , , , , , , , , , , , , 24.00, 240.00, ]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[Grand Total, 313.00, 1,376.66, 212.00, 1,148.67, , , , , , , , , , , , , 101.00, 437.57, ]";
		
		
		System.out.println("***************************checkStockAgeingAnalysisReportFilterOption*********************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		Thread.sleep(1000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseNameChkboxSelected));
		
		if (report_FilterWarehouseNameChkbox.isSelected()==true) 
		{
			report_FilterWarehouseNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))	
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reportWithLevel_CloseBtn));
			reportWithLevel_CloseBtn.click();
			
			return true;
		}
		else
		{	
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reportWithLevel_CloseBtn));
			reportWithLevel_CloseBtn.click();
			
			return false;
		}
	}
	
	
	
	
	
	
	@FindBy (xpath="//input[@id='MasterGroup__101']")
	private static WebElement stockAgeingAnalysisWarehouseTxt;
	
	@FindBy (xpath="//select[@id='RITCombobox__1']")
	private static WebElement stockAgeingDropdown;
	
	@FindBy (xpath="(//*[@id='dvReportInputs']//label/span)[2]")
	private static WebElement ignoreInternalTransferForAgeingChkbox;
	
	@FindBy(xpath="//*[@id='dvReportInputs']/div[12]/label/span")
	private static WebElement saa_IncludeServiceTypeItemChkBox;
	
	
	
	public boolean checkStockAgeingAnalysisReportWithOptions() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockAgeingAnalysisWarehouseTxt));
		stockAgeingAnalysisWarehouseTxt.sendKeys("Hyderabad");
		Thread.sleep(2000);
		stockAgeingAnalysisWarehouseTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockAgeingDropdown));
		Select stockAgeing = new Select(stockAgeingDropdown);
		stockAgeing.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ignoreInternalTransferForAgeingChkbox));
		ignoreInternalTransferForAgeingChkbox.click();
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockTypeDropdown));
		Select stockType = new Select(stockTypeDropdown);
		stockType.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(saa_IncludeServiceTypeItemChkBox));
		saa_IncludeServiceTypeItemChkBox.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[HYDERABAD]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[WA COGS ITEM, 43.00, 318.66, 32.00, 237.14, , , , , , , , , , , , , 11.00, 81.52, HYDERABAD]";
	

		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[FIFO COGS ITEM, 69.00, 55.25, 48.00, 38.43, , , , , , , , , , , , , 21.00, 16.82, HYDERABAD]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[BR COGS ITEM, 62.00, 42.75, 48.00, 33.10, , , , , , , , , , , , , 14.00, 9.65, HYDERABAD]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[STD RATE COGS ITEM, 96.00, 216.83, 84.00, 189.73, , , , , , , , , , , , , 12.00, 27.10, HYDERABAD]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[Grand Total, 270.00, 633.49, 212.00, 498.40, , , , , , , , , , , , , 58.00, 135.09, ]";
		
		
		System.out.println("***************************checkStockAgeingAnalysisReportWithOptions*********************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List))	
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	public boolean checkStockAgeingAnalysisReportWithBackTrackOptions() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		int reportItemGridListCount=reportTableColumn1RowsList.size();
		   
		for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("HYDERABAD"))
             {
                 int count =i+5;
                 
                 for (int j = i; j < count; j++) 
     		     {
                	 String data1=reportTableColumn1RowsList.get(j).getText();
		             
                	 if (data1.equalsIgnoreCase("WA COGS ITEM"))
                     {
                		 System.err.println("Item Name : "+data1);
                		 reportTableColumn1RowsList.get(j).click();
                		 Thread.sleep(1000);
                		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            	 report_BackTrackBtn.click();
		            	 Thread.sleep(3000);
		            	 
		            	
		            	try{
		            		 String m="Please select a row in the grid to Backtrack";
		            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
		            		 {
		            			 reportTableColumn1RowsList.get(j).click();
		            			 Thread.sleep(2000);
		            			 
		            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            			 report_BackTrackBtn.click();
		            			 Thread.sleep(3000);
		            	
		            		 }
		            	}
		            	catch(Exception e){
		            		System.out.println("message not displaying");
		            		
		            	}
		            	break;
                     }
     		     }
             }
	      }
	    
	    
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		Thread.sleep(2500);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("24.00");
		expMonthlyList.add("");
		expMonthlyList.add("24.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("24.00");
		expMonthlyList.add("42.00");
		expMonthlyList.add("23.00");
		expMonthlyList.add("43.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("66.00");
		expMonthlyList.add("23.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("24.00");
		expDayList.add("42.00");
		expDayList.add("23.00");
		expDayList.add("43.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("42.00");
		expDayList.add("23.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();

		expVouchersList.add("ExeStk:2");
		expVouchersList.add("24.00");
		expVouchersList.add("10.00");
		expVouchersList.add("");
		expVouchersList.add("34.00");
		expVouchersList.add("NDT57:SU/IND/TEXT5");
		expVouchersList.add("34.00");
		expVouchersList.add("22.00");
		expVouchersList.add("");
		expVouchersList.add("56.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("56.00");
		expVouchersList.add("10.00");
		expVouchersList.add("10.00");
		expVouchersList.add("56.00");
		expVouchersList.add("NDT50:5");
		expVouchersList.add("56.00");
		expVouchersList.add("");
		expVouchersList.add("3.00");
		expVouchersList.add("53.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("53.00");
		expVouchersList.add("");
		expVouchersList.add("10.00");
		expVouchersList.add("43.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("42.00");
		expVouchersList.add("23.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);

		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("NDT50:5")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo=documentNumberTxt.getAttribute("value");
		String expDocNo="5";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customerAccountTxt));
		String actCustomer=customerAccountTxt.getAttribute("value");
		String expCustomer="Customer A";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
	 	String actWarehouse = select1stRow_1stColumn.getText();
	 	String expWarehouse = "HYDERABAD";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
	 	String actItem = select1stRow_2ndColumn.getText();
	 	String expItem = "WA COGS ITEM";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
	 	String actTaxCode = select1stRow_3rdColumn.getText();
	 	String expTaxCode = "Std Rate";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
	 	String actSalesAccount = select1stRow_4thColumn.getText();
	 	String expSalesAccount = "Sales - Computers";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_5thColumn));
	 	String actUnits = select1stRow_5thColumn.getText();
	 	String expUnits = "Pcs";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_11thColumn));
	 	String actQuantity = select1stRow_11thColumn.getText();
	 	String expQuantity = "3.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_12thColumn));
	 	String actLSalesOrder = select1stRow_12thColumn.getText();
	 	String expLSalesOrder = "SalOrd:4";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_14thColumn));
	 	String actRate = select1stRow_14thColumn.getText();
	 	String expRate = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_15thColumn));
	 	String actGross = select1stRow_15thColumn.getText();
	 	String expGross = "30.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_21stColumn));
	 	String actRMA = select1stRow_21stColumn.getText();
	 	String expRMA = "RMA#R2OSV8,RMA#R2OSV9,RMA#R1OSV10";
	 	
		System.out.println("**********************checkStockAgeingAnalysisReportWithBackTrackOptions*********************");
		 
		System.out.println("Open Tabs        : "+actOpenWindowsCount         +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No      : "+actDocNo         +"  Value Expected  "+expDocNo);
		System.out.println("Customer Account : "+actCustomer      +"  Value Expected  "+expCustomer);
		System.out.println("Warehouse        : "+actWarehouse     +"  Value Expected  "+expWarehouse);
		System.out.println("Item             : "+actItem          +"  Value Expected  "+expItem);
		System.out.println("Tax Code         : "+actTaxCode       +"  Value Expected  "+expTaxCode);
		System.out.println("Sales Account    : "+actSalesAccount  +"  Value Expected  "+expSalesAccount);
		System.out.println("Units            : "+actUnits         +"  Value Expected  "+expUnits);
		System.out.println("Quantity         : "+actQuantity      +"  Value Expected  "+expQuantity);
		System.out.println("L Sales Order    : "+actLSalesOrder   +"  Value Expected  "+expLSalesOrder);
		System.out.println("Rate             : "+actRate          +"  Value Expected  "+expRate);
		System.out.println("Gross            : "+actGross         +"  Value Expected  "+expGross);
		System.out.println("RMA              : "+actRMA           +"  Value Expected  "+expRMA);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
				&& actDocNo.equalsIgnoreCase(expDocNo) && actCustomer.equalsIgnoreCase(expCustomer) && actWarehouse.equalsIgnoreCase(expWarehouse)
				   && actItem.equalsIgnoreCase(expItem) && actTaxCode.equalsIgnoreCase(expTaxCode) && actSalesAccount.equalsIgnoreCase(expSalesAccount)
				   && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actLSalesOrder.equalsIgnoreCase(expLSalesOrder)
				   && actRate.equalsIgnoreCase(expRate) && actGross.equalsIgnoreCase(expGross) && actRMA.equalsIgnoreCase(expRMA)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	
	
	
	
	@FindBy(xpath="//span[contains(text(),'Ageing analysis by batch')]")
	
	private static WebElement ageingAnalysisByBatch;
	
	
	public boolean checkAgeingAnalysisByBatchReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();

		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(stockAgeingAnalysisMenu).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockAgeingAnalysisMenu));
		stockAgeingAnalysisMenu.click();
		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(ageingAnalysisByBatch).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ageingAnalysisByBatch));
		ageingAnalysisByBatch.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("BR COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[BR COGS ITEM [BR COGS ITEM]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount-1;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[BATCH#OSVR1, 24.00, 10.00, , , , , , , , , , , , , , , 24.00, 10.00, 0]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount-1;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[EX BATCH UPDATE, 12.00, 10.00, 12.00, 10.00, , , , , , , , , , , , , , , 0]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount-1;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[PVATR1#V1, 12.00, 10.50, 12.00, 10.50, , , , , , , , , , , , , , , 0]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount-1;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[PVATR2#V1, 14.00, 12.25, 14.00, 12.25, , , , , , , , , , , , , , , 0]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow6ListCount-1;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[Total, 62.00, 42.75, 38.00, 32.75, , , , , , , , , , , , , 24.00, 10.00, ]";
		
		
		
		/*int reportsRow7ListCount = reportsRow7List.size();
		ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow7ListCount;i++)
		{
			String data = reportsRow7List.get(i).getText();
			reportsRow7ListArray.add(data);
		}
		String actRow7List = reportsRow7ListArray.toString();
		String expRow7List = "[Total, 62.00, 42.75, 38.00, 32.75, , , , , , , , , , , 24.00, 15.00, , , , ]";*/
		
		
		System.out.println("*****************************************checkAgeingAnalysisByBatchReports***************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		/*System.out.println(actRow7List);
		System.out.println(expRow7List);*/
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List) 
				/*&& actRow7List.equalsIgnoreCase(expRow7List)*/)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	@FindBy (xpath="//ul[@id='FilterFields_622_0']/li[5]/a/i")
	private static WebElement stockAnalysisByBatch_Filter_Customize_WarehouseExpandBtn;
	
	@FindBy (xpath="//*[@id='FilterFields_622_0']/ul[5]/li[1]/div/label/input")
	private static WebElement stockAnalysisByBatch_Filter_Customize_WarehouseNameChkBox;
	
	@FindBy (xpath="//input[@id='FOption_622_0_DefaultFilter_0']")
	private static WebElement stockAnalysisByBatch_DefaultFilterTxt;
	
	
	public boolean checkStockAnalysisByBatchReportPrintOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_ReportPrintBtn));
		sl_ReportPrintBtn.click();
		/*getWaitForAlert();
		getAlert().accept();*/
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintLabel));
		
		String actConfirmMsg=ss_ReportPrintMsg.getText();
		String expConfirmMsg="";
		Thread.sleep(2000);
		
		System.out.println("Actual Msg		:		"+	actConfirmMsg		+ "Expected		"	+	expConfirmMsg);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintYesBtn));
		ss_ReportPrintYesBtn.click();
		
		
		Thread.sleep(3000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(0));
	 	
	 	Thread.sleep(1000);
	 	
	 	getDriver().switchTo().window(openTabs.get(1)).close();
	 	
	 	getDriver().switchTo().window(openTabs.get(0));
		
		System.out.println("***************************checkStockAnalysisByBatchReportPrintOption*********************************");
		
		System.out.println("openTabs"+openTabs);
		System.out.println("Open Tabs Count : "+actOpenWindowsCount+"  Value Expected  "+expOpenWindowsCount);
		
		Thread.sleep(1000);
		
		if(actOpenWindowsCount==expOpenWindowsCount)
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return true;
		} 
		else 
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	public boolean checkAgeingAnalysisByBatchReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_WarehouseTxt));
		sl_WarehouseTxt.click();
		sl_WarehouseTxt.sendKeys("Hyderabad");
		Thread.sleep(2000);
		sl_WarehouseTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ignoreInternalTransferForAgeingChkbox));
		ignoreInternalTransferForAgeingChkbox.click();

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[BR COGS ITEM [BR COGS ITEM]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount-1;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[BATCH#OSVR1, 24.00, 10.00, , , , , , , , , , , , , , , 24.00, 10.00, 0]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount-1;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[EX BATCH UPDATE, 12.00, 10.00, 12.00, 10.00, , , , , , , , , , , , , , , 0]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount-1;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[PVATR1#V1, 12.00, 10.50, 12.00, 10.50, , , , , , , , , , , , , , , 0]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount-1;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[PVATR2#V1, 14.00, 12.25, 14.00, 12.25, , , , , , , , , , , , , , , 0]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow6ListCount-1;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[Total, 62.00, 42.75, 38.00, 32.75, , , , , , , , , , , , , 24.00, 10.00, ]";
		
		
		
		/*int reportsRow7ListCount = reportsRow7List.size();
		ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow7ListCount;i++)
		{
			String data = reportsRow7List.get(i).getText();
			reportsRow7ListArray.add(data);
		}
		String actRow7List = reportsRow7ListArray.toString();
		String expRow7List = "[Total, 62.00, 42.75, 38.00, 32.75, , , , , , , , , , , 24.00, 15.00, , , , ]";*/
		
		
		System.out.println("*****************************************checkAgeingAnalysisByBatchReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions***************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		/*System.out.println(actRow7List);
		System.out.println(expRow7List);*/
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List) 
				/*&& actRow7List.equalsIgnoreCase(expRow7List)*/)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	public boolean checkAgeingAnalysisByBatchReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		int reportItemGridListCount=reportTableColumn1RowsList.size();
		   
		for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("BR COGS ITEM [BR COGS ITEM]"))
             {
                 int count =i+5;
                 
                 for (int j = i; j < count; j++) 
     		     {
                	 String data1=reportTableColumn1RowsList.get(j).getText();
		             
                	 if (data1.equalsIgnoreCase("PVATR1#V1"))
                     {
                		 System.err.println("Item Name : "+data1);
                		 reportTableColumn1RowsList.get(j).click();
                		 Thread.sleep(1000);
                		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            	 report_BackTrackBtn.click();
		            	 Thread.sleep(3000);
		            	 
		            	
		            	try{
		            		 String m="Please select a row in the grid to Backtrack";
		            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
		            		 {
		            			 reportTableColumn1RowsList.get(i).click();
		            			 Thread.sleep(2000);
		            			 
		            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            			 report_BackTrackBtn.click();
		            			 Thread.sleep(3000);
		            	
		            		 }
		            	}
		            	catch(Exception e){
		            		System.out.println("message not displaying");
		            		
		            	}
		            	break;
                     }
     		     }
             }
	      }
	    
	    
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("60.00");
		expMonthlyList.add("34.00");
		expMonthlyList.add("62.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("96.00");
		expMonthlyList.add("34.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("60.00");
		expDayList.add("34.00");
		expDayList.add("62.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("60.00");
		expDayList.add("34.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);

		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("36.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT57:SU/IND/TEXT2");
		expVouchersList.add("48.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("84.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("84.00");
		expVouchersList.add("12.00");
		expVouchersList.add("12.00");
		expVouchersList.add("84.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("84.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("72.00");
		expVouchersList.add("NDT50:1");
		expVouchersList.add("72.00");
		expVouchersList.add("");
		expVouchersList.add("10.00");
		expVouchersList.add("62.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("60.00");
		expVouchersList.add("34.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("NDT50:1")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo=documentNumberTxt.getAttribute("value");
		String expDocNo="1";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customerAccountTxt));
		String actCustomer=customerAccountTxt.getAttribute("value");
		String expCustomer="Customer A";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
	 	String actWarehouse = select1stRow_1stColumn.getText();
	 	String expWarehouse = "HYDERABAD";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
	 	String actItem = select1stRow_2ndColumn.getText();
	 	String expItem = "BR COGS ITEM";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
	 	String actTaxCode = select1stRow_3rdColumn.getText();
	 	String expTaxCode = "Std Rate";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
	 	String actSalesAccount = select1stRow_4thColumn.getText();
	 	String expSalesAccount = "Sales - Computers";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_5thColumn));
	 	String actUnits = select1stRow_5thColumn.getText();
	 	String expUnits = "Pcs";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_11thColumn));
	 	String actQuantity = select1stRow_11thColumn.getText();
	 	String expQuantity = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_12thColumn));
	 	String actLSalesOrder = select1stRow_12thColumn.getText();
	 	String expLSalesOrder = "SalOrd:1";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_14thColumn));
	 	String actRate = select1stRow_14thColumn.getText();
	 	String expRate = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_15thColumn));
	 	String actGross = select1stRow_15thColumn.getText();
	 	String expGross = "100.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_19thColumn));
	 	String actBatch = select1stRow_19thColumn.getText();
	 	String expBatch = "PVATR2#V1";
	 	
		System.out.println("**********************checkStockAgeingAnalysisReportWithBackTrackOptions*********************");
		 
		System.out.println("Open Tabs        : "+actOpenWindowsCount         +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No      : "+actDocNo         +"  Value Expected  "+expDocNo);
		System.out.println("Customer Account : "+actCustomer      +"  Value Expected  "+expCustomer);
		System.out.println("Warehouse        : "+actWarehouse     +"  Value Expected  "+expWarehouse);
		System.out.println("Item             : "+actItem          +"  Value Expected  "+expItem);
		System.out.println("Tax Code         : "+actTaxCode       +"  Value Expected  "+expTaxCode);
		System.out.println("Sales Account    : "+actSalesAccount  +"  Value Expected  "+expSalesAccount);
		System.out.println("Units            : "+actUnits         +"  Value Expected  "+expUnits);
		System.out.println("Quantity         : "+actQuantity      +"  Value Expected  "+expQuantity);
		System.out.println("L Sales Order    : "+actLSalesOrder   +"  Value Expected  "+expLSalesOrder);
		System.out.println("Rate             : "+actRate          +"  Value Expected  "+expRate);
		System.out.println("Gross            : "+actGross         +"  Value Expected  "+expGross);
		System.out.println("Batch            : "+actBatch         +"  Value Expected  "+expBatch);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
				&& actDocNo.equalsIgnoreCase(expDocNo) && actCustomer.equalsIgnoreCase(expCustomer) && actWarehouse.equalsIgnoreCase(expWarehouse)
				   && actItem.equalsIgnoreCase(expItem) && actTaxCode.equalsIgnoreCase(expTaxCode) && actSalesAccount.equalsIgnoreCase(expSalesAccount)
				   && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actLSalesOrder.equalsIgnoreCase(expLSalesOrder)
				   && actRate.equalsIgnoreCase(expRate) && actGross.equalsIgnoreCase(expGross) && actBatch.equalsIgnoreCase(expBatch)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	
	
	
	
	
	
/*	@FindBy (xpath="(//div[@id='dvReportDetails']/div/table/tbody)[1]/tr/td")
	private static List<WebElement> reportTableCells;
	*/
	@FindBy(xpath="//*[@id='623']")
	private static WebElement ageingAnalysisByRMA;
	
	
	
	public boolean checkAgeingAnalysisByRMAReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();

		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(stockAgeingAnalysisMenu).build().perform();
		Thread.sleep(2000);
		

		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockAgeingAnalysisMenu));
		stockAgeingAnalysisMenu.click();
		
		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(ageingAnalysisByRMA).build().perform();
		Thread.sleep(2000);
		

		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ageingAnalysisByRMA));
		ageingAnalysisByRMA.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("WA COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportPage1Count = reportTableCells.size();
		ArrayList<String> reportPage1ListArray = new ArrayList<String>();
		for(int i=0;i<reportPage1Count;i++)
		{
			String data = reportTableCells.get(i).getText();
			reportPage1ListArray.add(data);
		}
		String actPage1List = reportPage1ListArray.toString();
		String expPage1List = "[1, WA COGS ITEM [WA COGS ITEM], 2, Ex Rma Update, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 3, Ex Rma Update1, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 4, Ex Rma Update2, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 5, Ex Rma Update3, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 6, Ex Rma Update4, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 7, Ex Rma Update5, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 8, Ex Rma Update6, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 9, Ex Rma Update7, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 10, Ex Rma Update8, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 11, Ex Rma Update9, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 12, RMA#R1OSV11, 1.00, 7.41, , , , , , , , , , , , , , , 1.00, 7.41, 13, RMA#R1OSV12, 1.00, 7.41, , , , , , , , , , , , , , , 1.00, 7.41, 14, RMA#R1PVVAT1, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 15, RMA#R1PVVAT10, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 16, RMA#R1PVVAT11, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 17, RMA#R1PVVAT12, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , ]";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_NextBtn));
		report_NextBtn.click();
		
		Thread.sleep(2000);
		
		if (report_PageNoBtn.getText().equalsIgnoreCase("3")) 
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_PreviousBtn));
			report_PreviousBtn.click();
			Thread.sleep(2000);
		}
		
		int reportPage2Count = reportTableCells.size();
		ArrayList<String> reportPage2ListArray = new ArrayList<String>();
		for(int i=0;i<reportPage2Count;i++)
		{
			String data = reportTableCells.get(i).getText();
			reportPage2ListArray.add(data);
		}
		String actPage2List = reportPage2ListArray.toString();
		String expPage2List = "[18, RMA#R1PVVAT2, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 19, RMA#R1PVVAT3, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 20, RMA#R1PVVAT4, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 21, RMA#R1PVVAT5, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 22, RMA#R1PVVAT6, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 23, RMA#R1PVVAT7, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 24, RMA#R1PVVAT8, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 25, RMA#R1PVVAT9, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 26, RMA#R2OSV10, 1.00, 7.41, , , , , , , , , , , , , , , 1.00, 7.41, 27, RMA#R2OSV11, 1.00, 7.41, , , , , , , , , , , , , , , 1.00, 7.41, 28, RMA#R2OSV12, 1.00, 7.41, , , , , , , , , , , , , , , 1.00, 7.41, 29, RMA#R2OSV2, 1.00, 7.41, , , , , , , , , , , , , , , 1.00, 7.41, 30, RMA#R2OSV3, 1.00, 7.41, , , , , , , , , , , , , , , 1.00, 7.41, 31, RMA#R2OSV4, 1.00, 7.41, , , , , , , , , , , , , , , 1.00, 7.41, 32, RMA#R2OSV5, 1.00, 7.41, , , , , , , , , , , , , , , 1.00, 7.41, 33, RMA#R2OSV6, 1.00, 7.41, , , , , , , , , , , , , , , 1.00, 7.41, 34, RMA#R2OSV7, 1.00, 7.41, , , , , , , , , , , , , , , 1.00, 7.41]";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_NextBtn));
		report_NextBtn.click();
		
		Thread.sleep(2000);
		
		int reportPage3Count = reportTableCells.size();
		ArrayList<String> reportPage3ListArray = new ArrayList<String>();
		for(int i=0;i<reportPage3Count;i++)
		{
			String data = reportTableCells.get(i).getText();
			reportPage3ListArray.add(data);
		}
		String actPage3List = reportPage3ListArray.toString();
		String expPage3List = "[35, RMA#R2PVVAT1, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 36, RMA#R2PVVAT10, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 37, RMA#R2PVVAT2, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 38, RMA#R2PVVAT3, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 39, RMA#R2PVVAT4, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 40, RMA#R2PVVAT5, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 41, RMA#R2PVVAT6, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 42, RMA#R2PVVAT7, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 43, RMA#R2PVVAT8, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 44, RMA#R2PVVAT9, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 45, Total, 43.00, 318.66, 32.00, 237.14, , , , , , , , , , , , , 11.00, 81.52]";
		
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_NextBtn));
		report_NextBtn.click();
		
		Thread.sleep(2000);
		
		int reportPage4Count = reportTableCells.size();
		ArrayList<String> reportPage4ListArray = new ArrayList<String>();
		for(int i=0;i<reportPage4Count;i++)
		{
			String data = reportTableCells.get(i).getText();
			reportPage4ListArray.add(data);
		}
		String actPage4List = reportPage4ListArray.toString();
		String expPage4List = "[43, RMA#R2PVVAT8, 1.00, 7.41, , , , , , , , , , , , , , , 1.00, 7.41, 44, RMA#R2PVVAT9, 1.00, 7.41, 1.00, 7.41, , , , , , , , , , , , , , , 45, Total, 43.00, 318.66, 32.00, 237.14, , , , , , , , , , , 11.00, 81.52, , ]";*/
		
		System.out.println("*****************************************checkAgeingAnalysisByRMAReports***************************************");
		
		System.out.println(actPage1List);
		System.out.println(expPage1List);
		
		System.out.println(actPage2List);
		System.out.println(expPage2List);
		
		System.out.println(actPage3List);
		System.out.println(expPage3List);
		
		/*System.out.println(actPage4List);
		System.out.println(expPage4List);*/
		
		if(actPage1List.equalsIgnoreCase(expPage1List) && actPage2List.equalsIgnoreCase(expPage2List) && actPage3List.equalsIgnoreCase(expPage3List) 
			/*&& actPage4List.equalsIgnoreCase(expPage4List)*/)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	@FindBy (xpath="//input[@id='FOption_623_0_DefaultFilter_0']")
	private static WebElement stockAnalysisByRMA_DefaultFilterTxt;
	
	@FindBy (xpath="//*[@id='FilterFields_623_0']/ul[5]/li[1]/div/label/span")
	private static WebElement ageingAnalysis_report_FilterWarehouseNameChkbox;
	
	
	public boolean checkAgeingAnalysisByRMAReportWithFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseExpandBtn));
		report_FilterWarehouseExpandBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseNameChkboxSelected));
		
		if (report_FilterWarehouseNameChkbox.isSelected()==false) 
		{
			report_FilterWarehouseNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockAnalysisByRMA_DefaultFilterTxt));
		stockAnalysisByRMA_DefaultFilterTxt.click();
		stockAnalysisByRMA_DefaultFilterTxt.sendKeys("SECUNDERABAD");
		
		Thread.sleep(2000);
		
		stockAnalysisByRMA_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
	
		boolean actReportTable = reportsTable.getText().isEmpty();
		boolean expReportTable = true;
		
		System.out.println("****************************checkStockAnalysisByRMAReportWithFilterOption******************************");
		
		System.out.println(actReportTable);
		System.out.println(expReportTable);
		
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseNameChkboxSelected));
		
		if (report_FilterWarehouseNameChkbox.isSelected()==true) 
		{
			report_FilterWarehouseNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
			
		Thread.sleep(2000);
		
		int actRowCount = reportsRowsCount.size();
		int expRowCount = 17; 
		
		System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
		
		if(actReportTable==expReportTable && actRowCount==expRowCount)
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reportWithLevel_CloseBtn));
			reportWithLevel_CloseBtn.click();
			
			Thread.sleep(2000);
			
			return true;
		} 
		else 
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reportWithLevel_CloseBtn));
			reportWithLevel_CloseBtn.click();
			
			Thread.sleep(2000);
			
			return false;
		}
	}
	
	
	
	
	
	
	
	
	public boolean checkAgeingAnalysisByRMAReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_WarehouseTxt));
		sl_WarehouseTxt.click();
		sl_WarehouseTxt.sendKeys("Secunderabad");
		Thread.sleep(2000);
		sl_WarehouseTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ignoreInternalTransferForAgeingChkbox));
		ignoreInternalTransferForAgeingChkbox.click();

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		boolean actReportTable = reportsTable.getText().isEmpty();
		boolean expReportTable = true;
		
		
		System.out.println("*****************************************checkAgeingAnalysisByRMAReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions***************************************");
		
		System.out.println(actReportTable);
		System.out.println(expReportTable);
		
		if(actReportTable==expReportTable)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	public boolean checkAgeingAnalysisByRMAReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
		report_CloseBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_WarehouseTxt));
		sl_WarehouseTxt.click();
		sl_WarehouseTxt.sendKeys(Keys.END, Keys.SHIFT, Keys.HOME);
		sl_WarehouseTxt.sendKeys("Hyderabad");
		Thread.sleep(2000);
		sl_WarehouseTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		int reportItemGridListCount=reportTableColumn1RowsList.size();
		   
		for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("WA COGS ITEM [WA COGS ITEM]"))
             {
                 int count =i+7;
                 
                 for (int j = i; j < count; j++) 
     		     {
                	 String data1=reportTableColumn1RowsList.get(j).getText();
		             
                	 if (data1.equalsIgnoreCase("Ex Rma Update"))
                     {
                		 System.err.println("Item Name : "+data1);
                		 reportTableColumn1RowsList.get(j).click();
                		 Thread.sleep(1000);
                		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            	 report_BackTrackBtn.click();
		            	 Thread.sleep(3000);
		            	 
		            	
		            	try{
		            		 String m="Please select a row in the grid to Backtrack";
		            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
		            		 {
		            			 reportTableColumn1RowsList.get(i).click();
		            			 Thread.sleep(2000);
		            			 
		            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            			 report_BackTrackBtn.click();
		            			 Thread.sleep(3000);
		            	
		            		 }
		            	}
		            	catch(Exception e){
		            		System.out.println("message not displaying");
		            		
		            	}
		            	break;
                     }
     		     }
             }
	      }
	    
	    
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("24.00");
		expMonthlyList.add("");
		expMonthlyList.add("24.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("24.00");
		expMonthlyList.add("42.00");
		expMonthlyList.add("23.00");
		expMonthlyList.add("43.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("66.00");
		expMonthlyList.add("23.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("24.00");
		expDayList.add("42.00");
		expDayList.add("23.00");
		expDayList.add("43.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("42.00");
		expDayList.add("23.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);

		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("24.00");
		expVouchersList.add("10.00");
		expVouchersList.add("");
		expVouchersList.add("34.00");
		expVouchersList.add("NDT57:SU/IND/TEXT5");
		expVouchersList.add("34.00");
		expVouchersList.add("22.00");
		expVouchersList.add("");
		expVouchersList.add("56.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("56.00");
		expVouchersList.add("10.00");
		expVouchersList.add("10.00");
		expVouchersList.add("56.00");
		expVouchersList.add("NDT50:5");
		expVouchersList.add("56.00");
		expVouchersList.add("");
		expVouchersList.add("3.00");
		expVouchersList.add("53.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("53.00");
		expVouchersList.add("");
		expVouchersList.add("10.00");
		expVouchersList.add("43.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("42.00");
		expVouchersList.add("23.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("StkTrf:2")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo = documentNumberTxt.getAttribute("value");
		String expDocNo = "2";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockTransferheaderWarehouse1Txt));
		String actFromWarehouse = stockTransferheaderWarehouse1Txt.getAttribute("value");
		String expFromWarehouse = "HYDERABAD";
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
		String actR1Warehouse = select1stRow_1stColumn.getText();
		String expR1Warehouse = "SECUNDERABAD";
		
		String actR1Item = select1stRow_2ndColumn.getText();
		String expR1Item = "STD RATE COGS ITEM";
		
		String actR1Units = select1stRow_3rdColumn.getText();
		String expR1Units = "Pcs";
		
		String actR1Quantity = select1stRow_4thColumn.getText();
		String expR1Quantity = "12.00";
		
		String actR1Rate = select1stRow_6thColumn.getText();
		String expR1Rate = "10.00";
		
		String actR1Gross = select1stRow_7thColumn.getText();
		String expR1Gross = "120.00";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
		String actR2Warehouse = select2ndRow_1stColumn.getText();
		String expR2Warehouse = "SECUNDERABAD";
		
		String actR2Item = select2ndRow_2ndColumn.getText();
		String expR2Item = "BR COGS ITEM";
		
		String actR2Units = select2ndRow_3rdColumn.getText();
		String expR2Units = "Pcs";
		
		String actR2Quantity = select2ndRow_4thColumn.getText();
		String expR2Quantity = "12.00";
		
		String actR2Rate = select2ndRow_6thColumn.getText();
		String expR2Rate = "10.00";
		
		String actR2Gross = select2ndRow_7thColumn.getText();
		String expR2Gross = "120.00";
		
		String actR2Batch = select2ndRow_8thColumn.getText();
		String expR2Batch = "BATCH#OSVR2";

		

		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select3rdRow_1stColumn));
		String actR3Warehouse = select3rdRow_1stColumn.getText();
		String expR3Warehouse = "SECUNDERABAD";
		
		String actR3Item = select3rdRow_2ndColumn.getText();
		String expR3Item = "FIFO COGS ITEM";
		
		String actR3Units = select3rdRow_3rdColumn.getText();
		String expR3Units = "Pcs";
		
		String actR3Quantity = select3rdRow_4thColumn.getText();
		String expR3Quantity = "9.00";
		
		String actR3Rate = select3rdRow_6thColumn.getText();
		String expR3Rate = "10.00";
		
		String actR3Gross = select3rdRow_7thColumn.getText();
		String expR3Gross = "90.00";
		
		String actR3Bins = select3rdRow_9thColumn.getText();
		String expR3Bins = "Bin4";
		
		String actR3Bins2 = select3rdRow_10thColumn.getText();
		String expR3Bins2 = "Bin Update";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select4thRow_1stColumn));
		String actR4Warehouse = select4thRow_1stColumn.getText();
		String expR4Warehouse = "SECUNDERABAD";
		
		String actR4Item = select4thRow_2ndColumn.getText();
		String expR4Item = "WA COGS ITEM";
		
		String actR4Units = select4thRow_3rdColumn.getText();
		String expR4Units = "Pcs";
		
		String actR4Quantity = select4thRow_4thColumn.getText();
		String expR4Quantity = "10.00";
		
		String actR4Rate = select4thRow_6thColumn.getText();
		String expR4Rate = "10.00";
		
		String actR4Gross = select4thRow_7thColumn.getText();
		String expR4Gross = "100.00";
		
		String actR4RMA = select4thRow_11thColumn.getText();
		String expR4RMA = "RMA#R1OSV1,RMA#R1OSV2,RMA#R1OSV3,RMA#R1OSV4,RMA#R1OSV5,RMA#R1OSV6,RMA#R1OSV7,RMA#R1OSV8,RMA#R1OSV9,RMA#R2OSV1";
		
		
		System.out.println("**********************checkAgeingAnalysisByRMAReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs       : "+actOpenWindowsCount +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No     : "+actDocNo			+"  Value Expected  "+expDocNo);
		System.out.println("From Warehouse  : "+actFromWarehouse	+"  Value Expected  "+expFromWarehouse);
		
		System.out.println("*******************************ROW1**********************************");
		
		System.out.println("Warehouse       : "+actR1Warehouse			+"  Value Expected  "+expR1Warehouse);
		System.out.println("Item            : "+actR1Item				+"  Value Expected  "+expR1Item);
		System.out.println("Units           : "+actR1Units				+"  Value Expected  "+expR1Units);
		System.out.println("Quantity        : "+actR1Quantity			+"  Value Expected  "+expR1Quantity);
		System.out.println("Rate            : "+actR1Rate				+"  Value Expected  "+expR1Rate);
		System.out.println("Gross           : "+actR1Gross				+"  Value Expected  "+expR1Gross);
		
		
		System.out.println("*******************************ROW2**********************************");
		
		System.out.println("Warehouse       : "+actR2Warehouse			+"  Value Expected  "+expR2Warehouse);
		System.out.println("Item            : "+actR2Item				+"  Value Expected  "+expR2Item);
		System.out.println("Units           : "+actR2Units				+"  Value Expected  "+expR2Units);
		System.out.println("Quantity        : "+actR2Quantity			+"  Value Expected  "+expR2Quantity);
		System.out.println("Rate            : "+actR2Rate				+"  Value Expected  "+expR2Rate);
		System.out.println("Gross           : "+actR2Gross				+"  Value Expected  "+expR2Gross);
		System.out.println("Bins            : "+actR2Batch				+"  Value Expected  "+expR2Batch);
		
		System.out.println("*******************************ROW3**********************************");
		
		System.out.println("Warehouse       : "+actR3Warehouse			+"  Value Expected  "+expR3Warehouse);
		System.out.println("Item            : "+actR3Item				+"  Value Expected  "+expR3Item);
		System.out.println("Units           : "+actR3Units				+"  Value Expected  "+expR3Units);
		System.out.println("Quantity        : "+actR3Quantity			+"  Value Expected  "+expR3Quantity);
		System.out.println("Rate            : "+actR3Rate				+"  Value Expected  "+expR3Rate);
		System.out.println("Gross           : "+actR3Gross				+"  Value Expected  "+expR3Gross);
		System.out.println("Bins            : "+actR3Bins				+"  Value Expected  "+expR3Bins);
		System.out.println("Bins2           : "+actR3Bins2				+"  Value Expected  "+expR3Bins2);
		
		System.out.println("*******************************ROW4**********************************");
		
		System.out.println("Warehouse       : "+actR4Warehouse			+"  Value Expected  "+expR4Warehouse);
		System.out.println("Item            : "+actR4Item				+"  Value Expected  "+expR4Item);
		System.out.println("Units           : "+actR4Units				+"  Value Expected  "+expR4Units);
		System.out.println("Quantity        : "+actR4Quantity			+"  Value Expected  "+expR4Quantity);
		System.out.println("Rate            : "+actR4Rate				+"  Value Expected  "+expR4Rate);
		System.out.println("Gross           : "+actR4Gross				+"  Value Expected  "+expR4Gross);
		System.out.println("RMA             : "+actR4RMA				+"  Value Expected  "+expR4RMA);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			   && actDocNo.equalsIgnoreCase(expDocNo) && actFromWarehouse.equalsIgnoreCase(expFromWarehouse)
			   
			   
			   && actR1Warehouse.equalsIgnoreCase(expR1Warehouse) && actR1Item.equalsIgnoreCase(expR1Item) && actR1Units.equalsIgnoreCase(expR1Units) 
			   && actR1Quantity.equalsIgnoreCase(expR1Quantity) && actR1Rate.equalsIgnoreCase(expR1Rate) && actR1Gross.equalsIgnoreCase(expR1Gross) 
			   
			   && actR2Warehouse.equalsIgnoreCase(expR2Warehouse) && actR2Item.equalsIgnoreCase(expR2Item) && actR2Units.equalsIgnoreCase(expR2Units) 
			   && actR2Quantity.equalsIgnoreCase(expR2Quantity) && actR2Rate.equalsIgnoreCase(expR2Rate) && actR2Gross.equalsIgnoreCase(expR2Gross) && actR2Batch.equalsIgnoreCase(expR2Batch) 
			   
			   && actR3Warehouse.equalsIgnoreCase(expR3Warehouse) && actR3Item.equalsIgnoreCase(expR3Item) && actR3Units.equalsIgnoreCase(expR3Units) 
			   && actR3Quantity.equalsIgnoreCase(expR3Quantity) && actR3Rate.equalsIgnoreCase(expR3Rate) && actR3Gross.equalsIgnoreCase(expR3Gross) 
			   && actR3Bins.equalsIgnoreCase(expR3Bins) && actR3Bins2.equalsIgnoreCase(expR3Bins2)
			   
			   && actR4Warehouse.equalsIgnoreCase(expR4Warehouse) && actR4Item.equalsIgnoreCase(expR4Item) && actR4Units.equalsIgnoreCase(expR4Units) 
			   && actR4Quantity.equalsIgnoreCase(expR4Quantity) && actR4Rate.equalsIgnoreCase(expR4Rate) && actR4Gross.equalsIgnoreCase(expR4Gross) 
			   && actR4RMA.equalsIgnoreCase(expR4RMA)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	
	
	
	
	
	@FindBy (xpath="//tbody[@id='LandingGridBody']/tr/td[10]")
	private static List<WebElement> ageingAnalysisByBinHomeTableItemNamesList;
	
	@FindBy(xpath="//*[@id='591']")
	private static WebElement ageingStockByBins;
	
	public boolean checkAgeingStockByBinsReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(stockAgeingAnalysisMenu).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockAgeingAnalysisMenu));
		stockAgeingAnalysisMenu.click();
		
		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(ageingStockByBins).build().perform();
		Thread.sleep(2000);

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ageingStockByBins));
		ageingStockByBins.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = ageingAnalysisByBinHomeTableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("BSTB") || actName.equalsIgnoreCase("Bin3") || actName.equalsIgnoreCase("BG1") || actName.equalsIgnoreCase("BG2"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[Bin4 [Bin4]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, 54.00, 44.22, 36.00, 29.48, , , , , , , , , , , , , 18.00, 14.74]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Sub Total, 54.00, 44.22, 36.00, 29.48, , , , , , , , , , , , , 18.00, 14.74]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[Bin5 [Bin5]]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[FIFO COGS ITEM, 24.00, 19.65, 12.00, 9.83, , , , , , , , , , , , , 12.00, 9.83]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow6ListCount;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[Sub Total, 24.00, 19.65, 12.00, 9.83, , , , , , , , , , , , , 12.00, 9.83]";
		
		
		
		int reportsRow7ListCount = reportsRow7List.size();
		ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow7ListCount;i++)
		{
			String data = reportsRow7List.get(i).getText();
			reportsRow7ListArray.add(data);
		}
		String actRow7List = reportsRow7ListArray.toString();
		String expRow7List = "[Grand Total, 78.00, 63.87, 48.00, 39.30, , , , , , , , , , , , , 30.00, 24.57]";
		
		
		System.out.println("*****************************************checkAgeingStockByBinsReports***************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		System.out.println(actRow7List);
		System.out.println(expRow7List);
		
			
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List) 
				&& actRow7List.equalsIgnoreCase(expRow7List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	@FindBy (xpath="//input[@id='FOption_591_0_DefaultFilter_0']")
	private static WebElement stockAnalysisByBin_DefaultFilterTxt;
	
	@FindBy(xpath="//*[@id='FilterFields_591_0']/ul[5]/li[1]/div/label/span")
	private static WebElement sabins_report_FilterWarehouseNameChkbox;
	
	public boolean checkStockAnalysisByBinReportWithFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseExpandBtn));
		report_FilterWarehouseExpandBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseNameChkboxSelected));
		
		if (report_FilterWarehouseNameChkbox.isSelected()==false) 
		{
			report_FilterWarehouseNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockAnalysisByBin_DefaultFilterTxt));
		stockAnalysisByBin_DefaultFilterTxt.click();
		stockAnalysisByBin_DefaultFilterTxt.sendKeys("Secunderabad");
		
		Thread.sleep(2000);
		
		stockAnalysisByBin_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(4000);
	
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[Bin Update Bin Update]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, , , , , , , , , , , , , , , , , , ]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Grand Total, , , , , , , , , , , , , , , , , , ]";*/
		
		boolean actReportsTable = reportsTable.getText().isEmpty();
		boolean expReportsTable = true;
		
		System.out.println("****************************checkStockAnalysisByBinReportWithFilterOption******************************");
		
		System.out.println("Reports Table isEmpty : "+actReportsTable+"  Value Expected  "+expReportsTable);
		
		/*System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);*/
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseNameChkboxSelected));
		
		if (report_FilterWarehouseNameChkbox.isSelected()==true) 
		{
			report_FilterWarehouseNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
			
		Thread.sleep(2000);
		
		int actRowCount = reportsRowsCount.size();
		int expRowCount = 7; 
		
		System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
		
		if(actReportsTable==expReportsTable	&& actRowCount==expRowCount)
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return true;
		} 
		else 
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	public boolean checkAgeingAnalysisByBinReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_WarehouseTxt));
		sl_WarehouseTxt.click();
		sl_WarehouseTxt.sendKeys("Secunderabad");
		Thread.sleep(2000);
		sl_WarehouseTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ignoreInternalTransferForAgeingChkbox));
		ignoreInternalTransferForAgeingChkbox.click();

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[Bin Update [Bin Update]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, , , , , , , , , , , , , , , , , , ]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Grand Total, , , , , , , , , , , , , , , , , , ]";
		
		
		System.out.println("*****************************************checkAgeingAnalysisByBinReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions***************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	public boolean checkAgeingAnalysisByBinReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
		report_CloseBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_WarehouseTxt));
		sl_WarehouseTxt.click();
		sl_WarehouseTxt.sendKeys(Keys.END, Keys.SHIFT, Keys.HOME);
		sl_WarehouseTxt.sendKeys("Hyderabad");
		Thread.sleep(2000);
		sl_WarehouseTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		int reportItemGridListCount=reportTableColumn1RowsList.size();
		   
		for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("Bin5 [Bin5]"))
             {
                 int count =i+2;
                 
                 for (int j = i; j < count; j++) 
     		     {
                	 String data1=reportTableColumn1RowsList.get(j).getText();
		             
                	 if (data1.equalsIgnoreCase("FIFO COGS ITEM"))
                     {
                		 System.err.println("Item Name : "+data1);
                		 reportTableColumn1RowsList.get(j).click();
                		 Thread.sleep(1000);
                		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            	 report_BackTrackBtn.click();
		            	 Thread.sleep(3000);
		            	 
		            	
		            	try{
		            		 String m="Please select a row in the grid to Backtrack";
		            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
		            		 {
		            			 reportTableColumn1RowsList.get(j).click();
		            			 Thread.sleep(2000);
		            			 
		            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            			 report_BackTrackBtn.click();
		            			 Thread.sleep(3000);
		            	
		            		 }
		            	}
		            	catch(Exception e){
		            		System.out.println("message not displaying");
		            		
		            	}
		            	break;
                     }
     		     }
             }
	      }
	    
	    
	/*	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("57.00");
		expMonthlyList.add("24.00");
		expMonthlyList.add("69.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("93.00");
		expMonthlyList.add("24.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("57.00");
		expDayList.add("24.00");
		expDayList.add("69.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("57.00");
		expDayList.add("24.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);

		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("36.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("48.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("48.00");
		expVouchersList.add("9.00");
		expVouchersList.add("9.00");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("48.00");
		expVouchersList.add("");
		expVouchersList.add("9.00");
		expVouchersList.add("39.00");
		expVouchersList.add("NDT50:4");
		expVouchersList.add("39.00");
		expVouchersList.add("");
		expVouchersList.add("6.00");
		expVouchersList.add("33.00");
		expVouchersList.add("NDT57:SU/IND/TEXT4");
		expVouchersList.add("33.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("69.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("57.00");
		expVouchersList.add("24.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("StkTrf:2")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo = documentNumberTxt.getAttribute("value");
		String expDocNo = "2";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockTransferheaderWarehouse1Txt));
		String actFromWarehouse = stockTransferheaderWarehouse1Txt.getAttribute("value");
		String expFromWarehouse = "HYDERABAD";
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
		String actR1Warehouse = select1stRow_1stColumn.getText();
		String expR1Warehouse = "SECUNDERABAD";
		
		String actR1Item = select1stRow_2ndColumn.getText();
		String expR1Item = "STD RATE COGS ITEM";
		
		String actR1Units = select1stRow_3rdColumn.getText();
		String expR1Units = "Pcs";
		
		String actR1Quantity = select1stRow_4thColumn.getText();
		String expR1Quantity = "12.00";
		
		String actR1Rate = select1stRow_6thColumn.getText();
		String expR1Rate = "10.00";
		
		String actR1Gross = select1stRow_7thColumn.getText();
		String expR1Gross = "120.00";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
		String actR2Warehouse = select2ndRow_1stColumn.getText();
		String expR2Warehouse = "SECUNDERABAD";
		
		String actR2Item = select2ndRow_2ndColumn.getText();
		String expR2Item = "BR COGS ITEM";
		
		String actR2Units = select2ndRow_3rdColumn.getText();
		String expR2Units = "Pcs";
		
		String actR2Quantity = select2ndRow_4thColumn.getText();
		String expR2Quantity = "12.00";
		
		String actR2Rate = select2ndRow_6thColumn.getText();
		String expR2Rate = "10.00";
		
		String actR2Gross = select2ndRow_7thColumn.getText();
		String expR2Gross = "120.00";
		
		String actR2Batch = select2ndRow_8thColumn.getText();
		String expR2Batch = "BATCH#OSVR2";

		

		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select3rdRow_1stColumn));
		String actR3Warehouse = select3rdRow_1stColumn.getText();
		String expR3Warehouse = "SECUNDERABAD";
		
		String actR3Item = select3rdRow_2ndColumn.getText();
		String expR3Item = "FIFO COGS ITEM";
		
		String actR3Units = select3rdRow_3rdColumn.getText();
		String expR3Units = "Pcs";
		
		String actR3Quantity = select3rdRow_4thColumn.getText();
		String expR3Quantity = "9.00";
		
		String actR3Rate = select3rdRow_6thColumn.getText();
		String expR3Rate = "10.00";
		
		String actR3Gross = select3rdRow_7thColumn.getText();
		String expR3Gross = "90.00";
		
		String actR3Bins = select3rdRow_9thColumn.getText();
		String expR3Bins = "Bin4";
		
		String actR3Bins2 = select3rdRow_10thColumn.getText();
		String expR3Bins2 = "Bin Update";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select4thRow_1stColumn));
		String actR4Warehouse = select4thRow_1stColumn.getText();
		String expR4Warehouse = "SECUNDERABAD";
		
		String actR4Item = select4thRow_2ndColumn.getText();
		String expR4Item = "WA COGS ITEM";
		
		String actR4Units = select4thRow_3rdColumn.getText();
		String expR4Units = "Pcs";
		
		String actR4Quantity = select4thRow_4thColumn.getText();
		String expR4Quantity = "10.00";
		
		String actR4Rate = select4thRow_6thColumn.getText();
		String expR4Rate = "10.00";
		
		String actR4Gross = select4thRow_7thColumn.getText();
		String expR4Gross = "100.00";
		
		String actR4RMA = select4thRow_11thColumn.getText();
		String expR4RMA = "RMA#R1OSV1,RMA#R1OSV2,RMA#R1OSV3,RMA#R1OSV4,RMA#R1OSV5,RMA#R1OSV6,RMA#R1OSV7,RMA#R1OSV8,RMA#R1OSV9,RMA#R2OSV1";
		
		
		System.out.println("**********************checkAgeingAnalysisByBinReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs       : "+actOpenWindowsCount +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No     : "+actDocNo			+"  Value Expected  "+expDocNo);
		System.out.println("From Warehouse  : "+actFromWarehouse	+"  Value Expected  "+expFromWarehouse);
		
		System.out.println("*******************************ROW1**********************************");
		
		System.out.println("Warehouse       : "+actR1Warehouse			+"  Value Expected  "+expR1Warehouse);
		System.out.println("Item            : "+actR1Item				+"  Value Expected  "+expR1Item);
		System.out.println("Units           : "+actR1Units				+"  Value Expected  "+expR1Units);
		System.out.println("Quantity        : "+actR1Quantity			+"  Value Expected  "+expR1Quantity);
		System.out.println("Rate            : "+actR1Rate				+"  Value Expected  "+expR1Rate);
		System.out.println("Gross           : "+actR1Gross				+"  Value Expected  "+expR1Gross);
		
		
		System.out.println("*******************************ROW2**********************************");
		
		System.out.println("Warehouse       : "+actR2Warehouse			+"  Value Expected  "+expR2Warehouse);
		System.out.println("Item            : "+actR2Item				+"  Value Expected  "+expR2Item);
		System.out.println("Units           : "+actR2Units				+"  Value Expected  "+expR2Units);
		System.out.println("Quantity        : "+actR2Quantity			+"  Value Expected  "+expR2Quantity);
		System.out.println("Rate            : "+actR2Rate				+"  Value Expected  "+expR2Rate);
		System.out.println("Gross           : "+actR2Gross				+"  Value Expected  "+expR2Gross);
		System.out.println("Bins            : "+actR2Batch				+"  Value Expected  "+expR2Batch);
		
		System.out.println("*******************************ROW3**********************************");
		
		System.out.println("Warehouse       : "+actR3Warehouse			+"  Value Expected  "+expR3Warehouse);
		System.out.println("Item            : "+actR3Item				+"  Value Expected  "+expR3Item);
		System.out.println("Units           : "+actR3Units				+"  Value Expected  "+expR3Units);
		System.out.println("Quantity        : "+actR3Quantity			+"  Value Expected  "+expR3Quantity);
		System.out.println("Rate            : "+actR3Rate				+"  Value Expected  "+expR3Rate);
		System.out.println("Gross           : "+actR3Gross				+"  Value Expected  "+expR3Gross);
		System.out.println("Bins            : "+actR3Bins				+"  Value Expected  "+expR3Bins);
		System.out.println("Bins2           : "+actR3Bins2				+"  Value Expected  "+expR3Bins2);
		
		System.out.println("*******************************ROW4**********************************");
		
		System.out.println("Warehouse       : "+actR4Warehouse			+"  Value Expected  "+expR4Warehouse);
		System.out.println("Item            : "+actR4Item				+"  Value Expected  "+expR4Item);
		System.out.println("Units           : "+actR4Units				+"  Value Expected  "+expR4Units);
		System.out.println("Quantity        : "+actR4Quantity			+"  Value Expected  "+expR4Quantity);
		System.out.println("Rate            : "+actR4Rate				+"  Value Expected  "+expR4Rate);
		System.out.println("Gross           : "+actR4Gross				+"  Value Expected  "+expR4Gross);
		System.out.println("RMA             : "+actR4RMA				+"  Value Expected  "+expR4RMA);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			   && actDocNo.equalsIgnoreCase(expDocNo) && actFromWarehouse.equalsIgnoreCase(expFromWarehouse)
			   
			   
			   && actR1Warehouse.equalsIgnoreCase(expR1Warehouse) && actR1Item.equalsIgnoreCase(expR1Item) && actR1Units.equalsIgnoreCase(expR1Units) 
			   && actR1Quantity.equalsIgnoreCase(expR1Quantity) && actR1Rate.equalsIgnoreCase(expR1Rate) && actR1Gross.equalsIgnoreCase(expR1Gross) 
			   
			   && actR2Warehouse.equalsIgnoreCase(expR2Warehouse) && actR2Item.equalsIgnoreCase(expR2Item) && actR2Units.equalsIgnoreCase(expR2Units) 
			   && actR2Quantity.equalsIgnoreCase(expR2Quantity) && actR2Rate.equalsIgnoreCase(expR2Rate) && actR2Gross.equalsIgnoreCase(expR2Gross) && actR2Batch.equalsIgnoreCase(expR2Batch) 
			   
			   && actR3Warehouse.equalsIgnoreCase(expR3Warehouse) && actR3Item.equalsIgnoreCase(expR3Item) && actR3Units.equalsIgnoreCase(expR3Units) 
			   && actR3Quantity.equalsIgnoreCase(expR3Quantity) && actR3Rate.equalsIgnoreCase(expR3Rate) && actR3Gross.equalsIgnoreCase(expR3Gross) 
			   && actR3Bins.equalsIgnoreCase(expR3Bins) && actR3Bins2.equalsIgnoreCase(expR3Bins2)
			   
			   && actR4Warehouse.equalsIgnoreCase(expR4Warehouse) && actR4Item.equalsIgnoreCase(expR4Item) && actR4Units.equalsIgnoreCase(expR4Units) 
			   && actR4Quantity.equalsIgnoreCase(expR4Quantity) && actR4Rate.equalsIgnoreCase(expR4Rate) && actR4Gross.equalsIgnoreCase(expR4Gross) 
			   && actR4RMA.equalsIgnoreCase(expR4RMA)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	
	
	@FindBy(xpath="//*[@id='646']")
	private static WebElement ageingByItemByBins;
	
	
	
	
	public boolean checkAgeingByItemByBinsReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();

		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(stockAgeingAnalysisMenu).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockAgeingAnalysisMenu));
		stockAgeingAnalysisMenu.click();
		
		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(ageingByItemByBins).build().perform();
		Thread.sleep(2000);
		
		

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ageingByItemByBins));
		ageingByItemByBins.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[FIFO COGS ITEM [FIFO COGS ITEM]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Bin4, 54.00, 44.22, 36.00, 29.48, , , , , , , , , , , , , 18.00, 14.74]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Bin5, 24.00, 19.65, 12.00, 9.83, , , , , , , , , , , , , 12.00, 9.83]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[Total, 78.00, 63.87, 48.00, 39.30, , , , , , , , , , , , , 30.00, 24.57]";
		
		
		
		System.out.println("*****************************************checkAgeingByItemByBinsReports***************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
			
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	@FindBy (xpath="//input[@id='FOption_646_0_DefaultFilter_0']")
	private static WebElement stockByItemByBin_DefaultFilterTxt;
	
	@FindBy(xpath="//*[@id='FilterFields_646_0']/ul[5]/li[1]/div/label/span")
	private static WebElement stockByItem_report_FilterWarehouseNameChkbox;
	
	public boolean checkStockByItemByBinReportWithFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseExpandBtn));
		report_FilterWarehouseExpandBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseNameChkboxSelected));
		
		if (report_FilterWarehouseNameChkbox.isSelected()==false) 
		{
			report_FilterWarehouseNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockByItemByBin_DefaultFilterTxt));
		stockByItemByBin_DefaultFilterTxt.click();
		stockByItemByBin_DefaultFilterTxt.sendKeys("Secunderabad");
		
		Thread.sleep(2000);
		
		stockByItemByBin_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(4000);
	
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[FIFO COGS ITEM FIFO COGS ITEM]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Bin Update, , , , , , , , , , , , , , , , , , ]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Total, , , , , , , , , , , , , , , , , , ]";*/
		
		boolean actReportsTable = reportsTable.getText().isEmpty();
		boolean expReportsTable = true;
		
		System.out.println("****************************checkStockByItemByBinReportWithFilterOption******************************");
		
		System.out.println("Reports Table isEmpty : "+actReportsTable+"  Value Expected  "+expReportsTable);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterWarehouseNameChkboxSelected));
		
		if (report_FilterWarehouseNameChkbox.isSelected()==true) 
		{
			report_FilterWarehouseNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
			
		Thread.sleep(2000);
		
		int actRowCount = reportsRowsCount.size();
		int expRowCount = 4; 
		
		System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
		
		if(actReportsTable==expReportsTable && actRowCount==expRowCount)
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return true;
		} 
		else 
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	public boolean checkAgeingByItemByBinReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_WarehouseTxt));
		sl_WarehouseTxt.click();
		sl_WarehouseTxt.sendKeys("Secunderabad");
		Thread.sleep(2000);
		sl_WarehouseTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ignoreInternalTransferForAgeingChkbox));
		ignoreInternalTransferForAgeingChkbox.click();

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[FIFO COGS ITEM [FIFO COGS ITEM]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Bin Update, , , , , , , , , , , , , , , , , , ]";
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Total, , , , , , , , , , , , , , , , , , ]";
		
		
		System.out.println("*****************************************checkAgeingByItemByBinReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions***************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	public boolean checkAgeingByItemByBinReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
		report_CloseBtn.click();
		
		Thread.sleep(2000);

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_WarehouseTxt));
		sl_WarehouseTxt.click();
		sl_WarehouseTxt.sendKeys(Keys.END,Keys.SHIFT,Keys.HOME);
		sl_WarehouseTxt.sendKeys("Hyderabad");
		Thread.sleep(2000);
		sl_WarehouseTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
		
		int reportItemGridListCount=reportTableColumn1RowsList.size();
		   
		for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("FIFO COGS ITEM [FIFO COGS ITEM]"))
             {
                 int count =i+2;
                 
                 for (int j = i; j < count; j++) 
     		     {
                	 String data1=reportTableColumn1RowsList.get(j).getText();
		             
                	 if (data1.equalsIgnoreCase("Bin4"))
                     {
                		 System.err.println("Item Name : "+data1);
                		 reportTableColumn1RowsList.get(j).click();
                		 Thread.sleep(1000);
                		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            	 report_BackTrackBtn.click();
		            	 Thread.sleep(3000);
		            	 
		            	
		            	try{
		            		 String m="Please select a row in the grid to Backtrack";
		            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
		            		 {
		            			 reportTableColumn1RowsList.get(i).click();
		            			 Thread.sleep(2000);
		            			 
		            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
		            			 report_BackTrackBtn.click();
		            			 Thread.sleep(3000);
		            	
		            		 }
		            	}
		            	catch(Exception e){
		            		System.out.println("message not displaying");
		            		
		            	}
		            	break;
                     }
     		     }
             }
	      }
	    
	    
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("57.00");
		expMonthlyList.add("24.00");
		expMonthlyList.add("69.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("93.00");
		expMonthlyList.add("24.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("57.00");
		expDayList.add("24.00");
		expDayList.add("69.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("57.00");
		expDayList.add("24.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);

		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("36.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("48.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("48.00");
		expVouchersList.add("9.00");
		expVouchersList.add("9.00");
		expVouchersList.add("48.00");
		
		expVouchersList.add("NDT50:7");
		expVouchersList.add("48.00");
		expVouchersList.add("");
		expVouchersList.add("9.00");
		expVouchersList.add("39.00");
		expVouchersList.add("NDT50:4");
		expVouchersList.add("39.00");
		expVouchersList.add("");
		expVouchersList.add("6.00");
		expVouchersList.add("33.00");
		expVouchersList.add("NDT57:SU/IND/TEXT4");
		expVouchersList.add("33.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("69.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("57.00");
		expVouchersList.add("24.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);

		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("StkTrf:2")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo = documentNumberTxt.getAttribute("value");
		String expDocNo = "2";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockTransferheaderWarehouse1Txt));
		String actFromWarehouse = stockTransferheaderWarehouse1Txt.getAttribute("value");
		String expFromWarehouse = "HYDERABAD";
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
		String actR1Warehouse = select1stRow_1stColumn.getText();
		String expR1Warehouse = "SECUNDERABAD";
		
		String actR1Item = select1stRow_2ndColumn.getText();
		String expR1Item = "STD RATE COGS ITEM";
		
		String actR1Units = select1stRow_3rdColumn.getText();
		String expR1Units = "Pcs";
		
		String actR1Quantity = select1stRow_4thColumn.getText();
		String expR1Quantity = "12.00";
		
		String actR1Rate = select1stRow_6thColumn.getText();
		String expR1Rate = "10.00";
		
		String actR1Gross = select1stRow_7thColumn.getText();
		String expR1Gross = "120.00";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
		String actR2Warehouse = select2ndRow_1stColumn.getText();
		String expR2Warehouse = "SECUNDERABAD";
		
		String actR2Item = select2ndRow_2ndColumn.getText();
		String expR2Item = "BR COGS ITEM";
		
		String actR2Units = select2ndRow_3rdColumn.getText();
		String expR2Units = "Pcs";
		
		String actR2Quantity = select2ndRow_4thColumn.getText();
		String expR2Quantity = "12.00";
		
		String actR2Rate = select2ndRow_6thColumn.getText();
		String expR2Rate = "10.00";
		
		String actR2Gross = select2ndRow_7thColumn.getText();
		String expR2Gross = "120.00";
		
		String actR2Batch = select2ndRow_8thColumn.getText();
		String expR2Batch = "BATCH#OSVR2";

		

		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select3rdRow_1stColumn));
		String actR3Warehouse = select3rdRow_1stColumn.getText();
		String expR3Warehouse = "SECUNDERABAD";
		
		String actR3Item = select3rdRow_2ndColumn.getText();
		String expR3Item = "FIFO COGS ITEM";
		
		String actR3Units = select3rdRow_3rdColumn.getText();
		String expR3Units = "Pcs";
		
		String actR3Quantity = select3rdRow_4thColumn.getText();
		String expR3Quantity = "9.00";
		
		String actR3Rate = select3rdRow_6thColumn.getText();
		String expR3Rate = "10.00";
		
		String actR3Gross = select3rdRow_7thColumn.getText();
		String expR3Gross = "90.00";
		
		String actR3Bins = select3rdRow_9thColumn.getText();
		String expR3Bins = "Bin4";
		
		String actR3Bins2 = select3rdRow_10thColumn.getText();
		String expR3Bins2 = "Bin Update";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select4thRow_1stColumn));
		String actR4Warehouse = select4thRow_1stColumn.getText();
		String expR4Warehouse = "SECUNDERABAD";
		
		String actR4Item = select4thRow_2ndColumn.getText();
		String expR4Item = "WA COGS ITEM";
		
		String actR4Units = select4thRow_3rdColumn.getText();
		String expR4Units = "Pcs";
		
		String actR4Quantity = select4thRow_4thColumn.getText();
		String expR4Quantity = "10.00";
		
		String actR4Rate = select4thRow_6thColumn.getText();
		String expR4Rate = "10.00";
		
		String actR4Gross = select4thRow_7thColumn.getText();
		String expR4Gross = "100.00";
		
		String actR4RMA = select4thRow_11thColumn.getText();
		String expR4RMA = "RMA#R1OSV1,RMA#R1OSV2,RMA#R1OSV3,RMA#R1OSV4,RMA#R1OSV5,RMA#R1OSV6,RMA#R1OSV7,RMA#R1OSV8,RMA#R1OSV9,RMA#R2OSV1";
		
		
		System.out.println("**********************checkAgeingByItemByBinReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs       : "+actOpenWindowsCount +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No     : "+actDocNo			+"  Value Expected  "+expDocNo);
		System.out.println("From Warehouse  : "+actFromWarehouse	+"  Value Expected  "+expFromWarehouse);
		
		System.out.println("*******************************ROW1**********************************");
		
		System.out.println("Warehouse       : "+actR1Warehouse			+"  Value Expected  "+expR1Warehouse);
		System.out.println("Item            : "+actR1Item				+"  Value Expected  "+expR1Item);
		System.out.println("Units           : "+actR1Units				+"  Value Expected  "+expR1Units);
		System.out.println("Quantity        : "+actR1Quantity			+"  Value Expected  "+expR1Quantity);
		System.out.println("Rate            : "+actR1Rate				+"  Value Expected  "+expR1Rate);
		System.out.println("Gross           : "+actR1Gross				+"  Value Expected  "+expR1Gross);
		
		
		System.out.println("*******************************ROW2**********************************");
		
		System.out.println("Warehouse       : "+actR2Warehouse			+"  Value Expected  "+expR2Warehouse);
		System.out.println("Item            : "+actR2Item				+"  Value Expected  "+expR2Item);
		System.out.println("Units           : "+actR2Units				+"  Value Expected  "+expR2Units);
		System.out.println("Quantity        : "+actR2Quantity			+"  Value Expected  "+expR2Quantity);
		System.out.println("Rate            : "+actR2Rate				+"  Value Expected  "+expR2Rate);
		System.out.println("Gross           : "+actR2Gross				+"  Value Expected  "+expR2Gross);
		System.out.println("Bins            : "+actR2Batch				+"  Value Expected  "+expR2Batch);
		
		System.out.println("*******************************ROW3**********************************");
		
		System.out.println("Warehouse       : "+actR3Warehouse			+"  Value Expected  "+expR3Warehouse);
		System.out.println("Item            : "+actR3Item				+"  Value Expected  "+expR3Item);
		System.out.println("Units           : "+actR3Units				+"  Value Expected  "+expR3Units);
		System.out.println("Quantity        : "+actR3Quantity			+"  Value Expected  "+expR3Quantity);
		System.out.println("Rate            : "+actR3Rate				+"  Value Expected  "+expR3Rate);
		System.out.println("Gross           : "+actR3Gross				+"  Value Expected  "+expR3Gross);
		System.out.println("Bins            : "+actR3Bins				+"  Value Expected  "+expR3Bins);
		System.out.println("Bins2           : "+actR3Bins2				+"  Value Expected  "+expR3Bins2);
		
		System.out.println("*******************************ROW4**********************************");
		
		System.out.println("Warehouse       : "+actR4Warehouse			+"  Value Expected  "+expR4Warehouse);
		System.out.println("Item            : "+actR4Item				+"  Value Expected  "+expR4Item);
		System.out.println("Units           : "+actR4Units				+"  Value Expected  "+expR4Units);
		System.out.println("Quantity        : "+actR4Quantity			+"  Value Expected  "+expR4Quantity);
		System.out.println("Rate            : "+actR4Rate				+"  Value Expected  "+expR4Rate);
		System.out.println("Gross           : "+actR4Gross				+"  Value Expected  "+expR4Gross);
		System.out.println("RMA             : "+actR4RMA				+"  Value Expected  "+expR4RMA);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			   && actDocNo.equalsIgnoreCase(expDocNo) && actFromWarehouse.equalsIgnoreCase(expFromWarehouse)
			   
			   
			   && actR1Warehouse.equalsIgnoreCase(expR1Warehouse) && actR1Item.equalsIgnoreCase(expR1Item) && actR1Units.equalsIgnoreCase(expR1Units) 
			   && actR1Quantity.equalsIgnoreCase(expR1Quantity) && actR1Rate.equalsIgnoreCase(expR1Rate) && actR1Gross.equalsIgnoreCase(expR1Gross) 
			   
			   && actR2Warehouse.equalsIgnoreCase(expR2Warehouse) && actR2Item.equalsIgnoreCase(expR2Item) && actR2Units.equalsIgnoreCase(expR2Units) 
			   && actR2Quantity.equalsIgnoreCase(expR2Quantity) && actR2Rate.equalsIgnoreCase(expR2Rate) && actR2Gross.equalsIgnoreCase(expR2Gross) && actR2Batch.equalsIgnoreCase(expR2Batch) 
			   
			   && actR3Warehouse.equalsIgnoreCase(expR3Warehouse) && actR3Item.equalsIgnoreCase(expR3Item) && actR3Units.equalsIgnoreCase(expR3Units) 
			   && actR3Quantity.equalsIgnoreCase(expR3Quantity) && actR3Rate.equalsIgnoreCase(expR3Rate) && actR3Gross.equalsIgnoreCase(expR3Gross) 
			   && actR3Bins.equalsIgnoreCase(expR3Bins) && actR3Bins2.equalsIgnoreCase(expR3Bins2)
			   
			   && actR4Warehouse.equalsIgnoreCase(expR4Warehouse) && actR4Item.equalsIgnoreCase(expR4Item) && actR4Units.equalsIgnoreCase(expR4Units) 
			   && actR4Quantity.equalsIgnoreCase(expR4Quantity) && actR4Rate.equalsIgnoreCase(expR4Rate) && actR4Gross.equalsIgnoreCase(expR4Gross) 
			   && actR4RMA.equalsIgnoreCase(expR4RMA)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	

	
	
	
	
	

	@FindBy(xpath="//*[@id='583']")
	private static WebElement reorderReport;
	
	public boolean checkReorderReports() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(reorderReport).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reorderReport));
		reorderReport.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_SelectAllItemsChkBox));
		sl_SelectAllItemsChkBox.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		boolean actReportsTable = reportsTable.getText().isEmpty();
		boolean expReportsTable = true;
		
		System.out.println("*********************************checkReorderReportReport*****************************************");
		
		System.out.println("Reports Table isEmpty : "+actReportsTable+"  Value Expected  "+expReportsTable);
		
		if(actReportsTable==expReportsTable)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	public boolean checkReorderReportPrintOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_ReportPrintBtn));
		sl_ReportPrintBtn.click();
		
		/*getWaitForAlert();
		getAlert().accept();*/
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintLabel));
		
		String actConfirmMsg=ss_ReportPrintMsg.getText();
		String expConfirmMsg="";
		Thread.sleep(2000);
		
		System.out.println("Actual Msg		:		"+	actConfirmMsg		+ "Expected		"	+	expConfirmMsg);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintYesBtn));
		ss_ReportPrintYesBtn.click();
		
		
		Thread.sleep(2000);
		
		String expMessage = "Nothing to print."; 
		String actMessage = checkValidationMessage(expMessage);
		
		System.out.println("*********************************checkReorderReportPrintOption*****************************************");
		
		System.out.println("Error Message : "+actMessage+"  Value Expected  "+expMessage);
		
		if(actMessage.equalsIgnoreCase(expMessage))
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
			sl_CloseBtn.click();
			return true;
		}
		else
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
			sl_CloseBtn.click();
			return false;
		}
	}
	
	
	@FindBy(xpath="//*[@id='584']")
	private static WebElement fastMovingItem;
	
	
	
	public boolean checkFastMovingItemsReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();

		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(fastMovingItem).build().perform();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(fastMovingItem));
		fastMovingItem.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM") || actName.equalsIgnoreCase("BR COGS ITEM") || actName.equalsIgnoreCase("WA COGS ITEM") || 
					actName.equalsIgnoreCase("STD RATE COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);
		
		getFluentWebDriverWait().equals(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[STD RATE COGS ITEM, STD RATE COGS ITEM, STD RATE COGS ITEM, 12.00, 216.83, 2.26, HYDERABAD, 96.00]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[BR COGS ITEM, BR COGS ITEM, BR COGS ITEM, 10.00, 42.75, 0.69, HYDERABAD, 62.00]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[FIFO COGS ITEM, FIFO COGS ITEM, FIFO COGS ITEM, 6.00, 55.25, 0.80, HYDERABAD, 69.00]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[WA COGS ITEM, WA COGS ITEM, WA COGS ITEM, 3.00, 318.66, 7.41, HYDERABAD, 43.00]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[Grand Total, , , 31.00, 633.49, 11.16, , 270.00]";
		
		
		System.out.println("*********************************checkFastMovingItemsReport*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	@FindBy (xpath="//input[@id='FOption_584_0_DefaultFilter_0']")
	private static WebElement fastMovingItems_DefaultFilterTxt;
	
	
	@FindBy(xpath="//*[@id='FilterFields_584_0']/ul[4]/li[1]/div/label/span")
	private static WebElement fastMoving_report_FilterItemNameChkbox;
	
	public boolean checkFastMovingItemsReportWithFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemExpansion));
		report_FilterItemExpansion.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
		
		if (report_FilterItemNameChkbox.isSelected()==false) 
		{
			report_FilterItemNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(fastMovingItems_DefaultFilterTxt));
		fastMovingItems_DefaultFilterTxt.click();
		fastMovingItems_DefaultFilterTxt.sendKeys("WA COGS ITEM");
		
		Thread.sleep(2000);
		
		fastMovingItems_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
	
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM, WA COGS ITEM, WA COGS ITEM, 3.00, 318.66, 7.41, HYDERABAD, 43.00]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Grand Total, , , 3.00, 318.66, 7.41, , 43.00]";
		
		System.out.println("****************************checkFastMovingItemsReportWithFilterOption******************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
		
		if (report_FilterItemNameChkbox.isSelected()==true) 
		{
			report_FilterItemNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
			
		Thread.sleep(4000);
		
		int actRowCount = reportsRowsCount.size();
		int expRowCount = 5; 
		
		System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
		
		Thread.sleep(2000);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRowCount==expRowCount)
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	public boolean checkFastMovingItemsReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		int reportItemGridListCount=reportTableColumn1RowsList.size();
		   
		for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("BR COGS ITEM"))
             {
         		 System.err.println("Item Name : "+data);
         		 reportTableColumn1RowsList.get(i).click();
         		 Thread.sleep(1000);
         		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            	 report_BackTrackBtn.click();
            	 Thread.sleep(3000);
            	 
            	
            	try{
            		 String m="Please select a row in the grid to Backtrack";
            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
            		 {
            			 reportTableColumn1RowsList.get(i).click();
            			 Thread.sleep(2000);
            			 
            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            			 report_BackTrackBtn.click();
            			 Thread.sleep(3000);
            	
            		 }
            	}
            	catch(Exception e){
            		System.out.println("message not displaying");
            		
            	}
            	break;
              }
  		}
	    
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("60.00");
		expMonthlyList.add("34.00");
		expMonthlyList.add("62.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("96.00");
		expMonthlyList.add("34.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("60.00");
		expDayList.add("34.00");
		expDayList.add("62.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("60.00");
		expDayList.add("34.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);

		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("36.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT57:SU/IND/TEXT2");
		expVouchersList.add("48.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("84.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("84.00");
		expVouchersList.add("12.00");
		expVouchersList.add("12.00");
		expVouchersList.add("84.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("84.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("72.00");
		expVouchersList.add("NDT50:1");
		expVouchersList.add("72.00");
		expVouchersList.add("");
		expVouchersList.add("10.00");
		expVouchersList.add("62.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("60.00");
		expVouchersList.add("34.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);

		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("NDT50:1")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo=documentNumberTxt.getAttribute("value");
		String expDocNo="1";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customerAccountTxt));
		String actCustomer=customerAccountTxt.getAttribute("value");
		String expCustomer="Customer A";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
	 	String actWarehouse = select1stRow_1stColumn.getText();
	 	String expWarehouse = "HYDERABAD";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
	 	String actItem = select1stRow_2ndColumn.getText();
	 	String expItem = "BR COGS ITEM";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
	 	String actTaxCode = select1stRow_3rdColumn.getText();
	 	String expTaxCode = "Std Rate";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
	 	String actSalesAccount = select1stRow_4thColumn.getText();
	 	String expSalesAccount = "Sales - Computers";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_5thColumn));
	 	String actUnits = select1stRow_5thColumn.getText();
	 	String expUnits = "Pcs";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_11thColumn));
	 	String actQuantity = select1stRow_11thColumn.getText();
	 	String expQuantity = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_12thColumn));
	 	String actLSalesOrder = select1stRow_12thColumn.getText();
	 	String expLSalesOrder = "SalOrd:1";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_14thColumn));
	 	String actRate = select1stRow_14thColumn.getText();
	 	String expRate = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_15thColumn));
	 	String actGross = select1stRow_15thColumn.getText();
	 	String expGross = "100.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_19thColumn));
	 	String actBatch = select1stRow_19thColumn.getText();
	 	String expBatch = "PVATR2#V1";
	 	
		System.out.println("**********************checkFastMovingItemsReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs        : "+actOpenWindowsCount         +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No      : "+actDocNo         +"  Value Expected  "+expDocNo);
		System.out.println("Customer Account : "+actCustomer      +"  Value Expected  "+expCustomer);
		System.out.println("Warehouse        : "+actWarehouse     +"  Value Expected  "+expWarehouse);
		System.out.println("Item             : "+actItem          +"  Value Expected  "+expItem);
		System.out.println("Tax Code         : "+actTaxCode       +"  Value Expected  "+expTaxCode);
		System.out.println("Sales Account    : "+actSalesAccount  +"  Value Expected  "+expSalesAccount);
		System.out.println("Units            : "+actUnits         +"  Value Expected  "+expUnits);
		System.out.println("Quantity         : "+actQuantity      +"  Value Expected  "+expQuantity);
		System.out.println("L Sales Order    : "+actLSalesOrder   +"  Value Expected  "+expLSalesOrder);
		System.out.println("Rate             : "+actRate          +"  Value Expected  "+expRate);
		System.out.println("Gross            : "+actGross         +"  Value Expected  "+expGross);
		System.out.println("Batch            : "+actBatch         +"  Value Expected  "+expBatch);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
				&& actDocNo.equalsIgnoreCase(expDocNo) && actCustomer.equalsIgnoreCase(expCustomer) && actWarehouse.equalsIgnoreCase(expWarehouse)
				   && actItem.equalsIgnoreCase(expItem) && actTaxCode.equalsIgnoreCase(expTaxCode) && actSalesAccount.equalsIgnoreCase(expSalesAccount)
				   && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actLSalesOrder.equalsIgnoreCase(expLSalesOrder)
				   && actRate.equalsIgnoreCase(expRate) && actGross.equalsIgnoreCase(expGross) && actBatch.equalsIgnoreCase(expBatch)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	
	
	@FindBy(xpath="//*[@id='585']")
	private static WebElement slowMovingItem;
	
	
	public boolean checkSlowMovingItemsReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();

		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,300)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(slowMovingItem).build().perform();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(slowMovingItem));
		slowMovingItem.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM") || actName.equalsIgnoreCase("BR COGS ITEM") || actName.equalsIgnoreCase("WA COGS ITEM") || 
					actName.equalsIgnoreCase("STD RATE COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);
		
		getFluentWebDriverWait().equals(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM, WA COGS ITEM, WA COGS ITEM, 3.00, 318.66, 7.41, HYDERABAD, 43.00]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, FIFO COGS ITEM, FIFO COGS ITEM, 6.00, 55.25, 0.80, HYDERABAD, 69.00]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[BR COGS ITEM, BR COGS ITEM, BR COGS ITEM, 10.00, 42.75, 0.69, HYDERABAD, 62.00]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[STD RATE COGS ITEM, STD RATE COGS ITEM, STD RATE COGS ITEM, 12.00, 216.83, 2.26, HYDERABAD, 96.00]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[Grand Total, , , 31.00, 633.49, 11.16, , 270.00]";
		
		
		System.out.println("*********************************checkSlowMovingItemsReport*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	@FindBy (xpath="//input[@id='FOption_585_0_DefaultFilter_0']")
	private static WebElement slowMovingItems_DefaultFilterTxt;
	
	@FindBy(xpath="//*[@id='FilterFields_585_0']/ul[4]/li[1]/div/label/span")
	
	private static WebElement slm_report_FilterItemNameChkbox;
	
	public boolean checkSlowMovingItemsReportWithFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemExpansion));
		report_FilterItemExpansion.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
		
		if (report_FilterItemNameChkbox.isSelected()==false) 
		{
			report_FilterItemNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(slowMovingItems_DefaultFilterTxt));
		slowMovingItems_DefaultFilterTxt.click();
		slowMovingItems_DefaultFilterTxt.sendKeys("BR COGS ITEM");
		
		Thread.sleep(2000);
		
		slowMovingItems_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
	
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[BR COGS ITEM, BR COGS ITEM, BR COGS ITEM, 10.00, 42.75, 0.69, HYDERABAD, 62.00]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Grand Total, , , 10.00, 42.75, 0.69, , 62.00]";
		
		System.out.println("****************************checkSlowMovingItemsReportWithFilterOption******************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
		
		if (report_FilterItemNameChkbox.isSelected()==true) 
		{
			report_FilterItemNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
			
		Thread.sleep(2000);
		
		int actRowCount = reportsRowsCount.size();
		int expRowCount = 5; 
		
		System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRowCount==expRowCount)
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	public boolean checkSlowMovingItemsReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		int reportItemGridListCount=reportTableColumn1RowsList.size();
		   
		for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("BR COGS ITEM"))
             {
         		 System.err.println("Item Name : "+data);
         		 reportTableColumn1RowsList.get(i).click();
         		 Thread.sleep(1000);
         		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            	 report_BackTrackBtn.click();
            	 Thread.sleep(3000);
            	 
            	
            	try{
            		 String m="Please select a row in the grid to Backtrack";
            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
            		 {
            			 reportTableColumn1RowsList.get(i).click();
            			 Thread.sleep(2000);
            			 
            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            			 report_BackTrackBtn.click();
            			 Thread.sleep(3000);
            	
            		 }
            	}
            	catch(Exception e){
            		System.out.println("message not displaying");
            		
            	}
            	break;
              }
  		}
	    
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();
		*/
		
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("60.00");
		expMonthlyList.add("34.00");
		expMonthlyList.add("62.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("96.00");
		expMonthlyList.add("34.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("60.00");
		expDayList.add("34.00");
		expDayList.add("62.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("60.00");
		expDayList.add("34.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("36.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT57:SU/IND/TEXT2");
		expVouchersList.add("48.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("84.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("84.00");
		expVouchersList.add("12.00");
		expVouchersList.add("12.00");
		expVouchersList.add("84.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("84.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("72.00");
		expVouchersList.add("NDT50:1");
		expVouchersList.add("72.00");
		expVouchersList.add("");
		expVouchersList.add("10.00");
		expVouchersList.add("62.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("60.00");
		expVouchersList.add("34.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("NDT50:1")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo=documentNumberTxt.getAttribute("value");
		String expDocNo="1";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customerAccountTxt));
		String actCustomer=customerAccountTxt.getAttribute("value");
		String expCustomer="Customer A";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
	 	String actWarehouse = select1stRow_1stColumn.getText();
	 	String expWarehouse = "HYDERABAD";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
	 	String actItem = select1stRow_2ndColumn.getText();
	 	String expItem = "BR COGS ITEM";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
	 	String actTaxCode = select1stRow_3rdColumn.getText();
	 	String expTaxCode = "Std Rate";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
	 	String actSalesAccount = select1stRow_4thColumn.getText();
	 	String expSalesAccount = "Sales - Computers";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_5thColumn));
	 	String actUnits = select1stRow_5thColumn.getText();
	 	String expUnits = "Pcs";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_11thColumn));
	 	String actQuantity = select1stRow_11thColumn.getText();
	 	String expQuantity = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_12thColumn));
	 	String actLSalesOrder = select1stRow_12thColumn.getText();
	 	String expLSalesOrder = "SalOrd:1";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_14thColumn));
	 	String actRate = select1stRow_14thColumn.getText();
	 	String expRate = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_15thColumn));
	 	String actGross = select1stRow_15thColumn.getText();
	 	String expGross = "100.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_19thColumn));
	 	String actBatch = select1stRow_19thColumn.getText();
	 	String expBatch = "PVATR2#V1";
	 	
		System.out.println("**********************checkSlowMovingItemsReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs        : "+actOpenWindowsCount         +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No      : "+actDocNo         +"  Value Expected  "+expDocNo);
		System.out.println("Customer Account : "+actCustomer      +"  Value Expected  "+expCustomer);
		System.out.println("Warehouse        : "+actWarehouse     +"  Value Expected  "+expWarehouse);
		System.out.println("Item             : "+actItem          +"  Value Expected  "+expItem);
		System.out.println("Tax Code         : "+actTaxCode       +"  Value Expected  "+expTaxCode);
		System.out.println("Sales Account    : "+actSalesAccount  +"  Value Expected  "+expSalesAccount);
		System.out.println("Units            : "+actUnits         +"  Value Expected  "+expUnits);
		System.out.println("Quantity         : "+actQuantity      +"  Value Expected  "+expQuantity);
		System.out.println("L Sales Order    : "+actLSalesOrder   +"  Value Expected  "+expLSalesOrder);
		System.out.println("Rate             : "+actRate          +"  Value Expected  "+expRate);
		System.out.println("Gross            : "+actGross         +"  Value Expected  "+expGross);
		System.out.println("Batch            : "+actBatch         +"  Value Expected  "+expBatch);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);

		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
				&& actDocNo.equalsIgnoreCase(expDocNo) && actCustomer.equalsIgnoreCase(expCustomer) && actWarehouse.equalsIgnoreCase(expWarehouse)
				   && actItem.equalsIgnoreCase(expItem) && actTaxCode.equalsIgnoreCase(expTaxCode) && actSalesAccount.equalsIgnoreCase(expSalesAccount)
				   && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actLSalesOrder.equalsIgnoreCase(expLSalesOrder)
				   && actRate.equalsIgnoreCase(expRate) && actGross.equalsIgnoreCase(expGross) && actBatch.equalsIgnoreCase(expBatch)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	@FindBy(xpath="//*[@id='586']")
	private static WebElement peakORLowBalances;
	
	
	public boolean checkPeakAndLowBalancesReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getDriver().navigate().refresh();
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();

		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,400)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(peakORLowBalances).build().perform();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(peakORLowBalances));
		peakORLowBalances.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM") || actName.equalsIgnoreCase("BR COGS ITEM") || actName.equalsIgnoreCase("WA COGS ITEM") || 
					actName.equalsIgnoreCase("STD RATE COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().equals(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			if (i!=4 && i!=6) 
			{
				String data = reportsRow1List.get(i).getText();
				reportsRow1ListArray.add(data);
			}
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM, 0, , 12.00, 56.00]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			if (i!=4 && i!=6) 
			{
				String data = reportsRow2List.get(i).getText();
				reportsRow2ListArray.add(data);
			}
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, 0, , 12.00, 84.00]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			if (i!=4 && i!=6) 
			{
				String data = reportsRow3List.get(i).getText();
				reportsRow3ListArray.add(data);
			}
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[BR COGS ITEM, 0, , 24.00, 84.00]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			if (i!=4 && i!=6) 
			{
				String data = reportsRow4List.get(i).getText();
				reportsRow4ListArray.add(data);
			}
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[STD RATE COGS ITEM, 0, , 24.00, 108.00]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[Grand Total, , , , 72.00, , 332.00]";
		
		System.out.println("*********************************checkPeakAndLowBalancesReport*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	@FindBy (xpath="//input[@id='FOption_586_0_DefaultFilter_0']")
	private static WebElement peakAndLowBalance_DefaultFilterTxt;
	
	@FindBy (xpath="//*[@id='5021']/following-sibling::span")
	private static WebElement palb_report_FilterItemNameChkbox;
	
	
	public boolean checkPeakAndLowBalancesReportWithFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemExpansion));
		report_FilterItemExpansion.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
		
		if (report_FilterItemNameChkbox.isSelected()==false) 
		{
			report_FilterItemNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(peakAndLowBalance_DefaultFilterTxt));
		peakAndLowBalance_DefaultFilterTxt.click();
		peakAndLowBalance_DefaultFilterTxt.sendKeys("FIFO COGS ITEM");
		
		Thread.sleep(2000);
		
		peakAndLowBalance_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
	
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			if (i!=4 && i!=6) 
			{
				String data = reportsRow1List.get(i).getText();
				reportsRow1ListArray.add(data);
			}
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[FIFO COGS ITEM, , , 12.00, 87.00]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Grand Total, , , , 12.00, , 87.00]";
		
		System.out.println("****************************checkPeakAndLowBalancesReportWithFilterOption******************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
		
		if (report_FilterItemNameChkbox.isSelected()==true) 
		{
			report_FilterItemNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
			
		Thread.sleep(2000);
		
		int actRowCount = reportsRowsCount.size();
		int expRowCount = 5; 
		
		System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRowCount==expRowCount)
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
	
	
	
	
	
	public boolean checkPeakAndLowBalancesReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		Thread.sleep(1000);
		int reportItemGridListCount=reportTableColumn1RowsList.size();
		   
		for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("BR COGS ITEM"))
             {
        		 reportTableColumn1RowsList.get(i).click();
        		 Thread.sleep(1000);
        		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            	 report_BackTrackBtn.click();
            	 Thread.sleep(3000);
            	 
            	
            	try{
            		 String m="Please select a row in the grid to Backtrack";
            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
            		 {
            			 reportTableColumn1RowsList.get(i).click();
            			 Thread.sleep(2000);
            			 
            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            			 report_BackTrackBtn.click();
            			 Thread.sleep(3000);
            	
            		 }
            	}
            	catch(Exception e){
            		System.out.println("message not displaying");
            		
            	}
            	break;
             }
		     }
	    
	    
	/*	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("60.00");
		expMonthlyList.add("34.00");
		expMonthlyList.add("62.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("96.00");
		expMonthlyList.add("34.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("60.00");
		expDayList.add("34.00");
		expDayList.add("62.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("60.00");
		expDayList.add("34.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("36.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT57:SU/IND/TEXT2");
		expVouchersList.add("48.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("84.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("84.00");
		expVouchersList.add("12.00");
		expVouchersList.add("12.00");
		expVouchersList.add("84.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("84.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("72.00");
		expVouchersList.add("NDT50:1");
		expVouchersList.add("72.00");
		expVouchersList.add("");
		expVouchersList.add("10.00");
		expVouchersList.add("62.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("60.00");
		expVouchersList.add("34.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("NDT50:1")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo=documentNumberTxt.getAttribute("value");
		String expDocNo="1";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customerAccountTxt));
		String actCustomer=customerAccountTxt.getAttribute("value");
		String expCustomer="Customer A";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
	 	String actWarehouse = select1stRow_1stColumn.getText();
	 	String expWarehouse = "HYDERABAD";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
	 	String actItem = select1stRow_2ndColumn.getText();
	 	String expItem = "BR COGS ITEM";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
	 	String actTaxCode = select1stRow_3rdColumn.getText();
	 	String expTaxCode = "Std Rate";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
	 	String actSalesAccount = select1stRow_4thColumn.getText();
	 	String expSalesAccount = "Sales - Computers";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_5thColumn));
	 	String actUnits = select1stRow_5thColumn.getText();
	 	String expUnits = "Pcs";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_11thColumn));
	 	String actQuantity = select1stRow_11thColumn.getText();
	 	String expQuantity = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_12thColumn));
	 	String actLSalesOrder = select1stRow_12thColumn.getText();
	 	String expLSalesOrder = "SalOrd:1";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_14thColumn));
	 	String actRate = select1stRow_14thColumn.getText();
	 	String expRate = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_15thColumn));
	 	String actGross = select1stRow_15thColumn.getText();
	 	String expGross = "100.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_19thColumn));
	 	String actBatch = select1stRow_19thColumn.getText();
	 	String expBatch = "PVATR2#V1";
	 	
		System.out.println("**********************checkPeakAndLowBalancesReportWithBackTrackOption*********************");
		 
		System.out.println("Open Tabs        : "+actOpenWindowsCount         +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No      : "+actDocNo         +"  Value Expected  "+expDocNo);
		System.out.println("Customer Account : "+actCustomer      +"  Value Expected  "+expCustomer);
		System.out.println("Warehouse        : "+actWarehouse     +"  Value Expected  "+expWarehouse);
		System.out.println("Item             : "+actItem          +"  Value Expected  "+expItem);
		System.out.println("Tax Code         : "+actTaxCode       +"  Value Expected  "+expTaxCode);
		System.out.println("Sales Account    : "+actSalesAccount  +"  Value Expected  "+expSalesAccount);
		System.out.println("Units            : "+actUnits         +"  Value Expected  "+expUnits);
		System.out.println("Quantity         : "+actQuantity      +"  Value Expected  "+expQuantity);
		System.out.println("L Sales Order    : "+actLSalesOrder   +"  Value Expected  "+expLSalesOrder);
		System.out.println("Rate             : "+actRate          +"  Value Expected  "+expRate);
		System.out.println("Gross            : "+actGross         +"  Value Expected  "+expGross);
		System.out.println("Batch            : "+actBatch         +"  Value Expected  "+expBatch);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);

		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
				&& actDocNo.equalsIgnoreCase(expDocNo) && actCustomer.equalsIgnoreCase(expCustomer) && actWarehouse.equalsIgnoreCase(expWarehouse)
				   && actItem.equalsIgnoreCase(expItem) && actTaxCode.equalsIgnoreCase(expTaxCode) && actSalesAccount.equalsIgnoreCase(expSalesAccount)
				   && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actLSalesOrder.equalsIgnoreCase(expLSalesOrder)
				   && actRate.equalsIgnoreCase(expRate) && actGross.equalsIgnoreCase(expGross) && actBatch.equalsIgnoreCase(expBatch)) 
		{
			return true;
		}
		else
		{
			
			return false;
		}
	}
	

	@FindBy(xpath="//*[@id='631']")
	private static WebElement bestSellingItem;
	
	public boolean checkBestSellingItemReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getDriver().navigate().refresh();
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();

		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,400)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(bestSellingItem).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(bestSellingItem));
		bestSellingItem.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[BR COGS ITEM, 22.00, 220.00]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, 15.00, 150.00]";
		

		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[WA COGS ITEM, 13.00, 130.00]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[STD RATE COGS ITEM, 12.00, 120.00]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[Grand Total, 62.00, 620.00]";
		
		
		System.out.println("*********************************checkBestSellingItemReport*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return true;
		}
		else
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return false;
		}
	}
	
	
	
	
	
	
	@FindBy (xpath="//select[@id='RITCombobox__2']")
	private static WebElement bestSellingItemsSortingOnDrpdwn;
	
	@FindBy (xpath="//*[@id='dvReportInputs']/div[6]//span")
	private static WebElement includeAllVoucherChkBox;
	
	
	
	public boolean checkBestSellingItemReportWithSortingOnAndIncludeAllVouchersChkBox() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(bestSellingItemsSortingOnDrpdwn));
		Select s=new Select(bestSellingItemsSortingOnDrpdwn);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(includeAllVoucherChkBox));
		includeAllVoucherChkBox.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[BR COGS ITEM, 34.00, 168.50]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[STD RATE COGS ITEM, 24.00, 124.50]";
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[FIFO COGS ITEM, 24.00, 98.50]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[WA COGS ITEM, 23.00, 185.00]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[Grand Total, 105.00, 42.50]";
		
		
		System.out.println("*********************************checkBestSellingItemReportWithSortingOnAndIncludeAllVouchersChkBox*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	public boolean checkBestSellingItemReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{	
		Thread.sleep(1000);
		int reportItemGridListCount=reportTableColumn1RowsList.size();
	    for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("WA COGS ITEM"))
             {
        		 reportTableColumn1RowsList.get(i).click();
        		 Thread.sleep(1000);
        		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            	 report_BackTrackBtn.click();
            	 Thread.sleep(3000);
            	 
            	
            	try{
            		 String m="Please select a row in the grid to Backtrack";
            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
            		 {
            			 reportTableColumn1RowsList.get(i).click();
            			 Thread.sleep(2000);
            			 
            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            			 report_BackTrackBtn.click();
            			 Thread.sleep(3000);
            	
            		 }
            	}
            	catch(Exception e){
            		System.out.println("message not displaying");
            		
            	}
            	break;
             }
		     }
		
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		
	    Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("24.00");
		expMonthlyList.add("");
		expMonthlyList.add("24.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("24.00");
		expMonthlyList.add("42.00");
		expMonthlyList.add("23.00");
		expMonthlyList.add("43.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("66.00");
		expMonthlyList.add("23.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("January 2020")) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add("1");
		expDayList.add("");
		expDayList.add("24.00");
		expDayList.add("");
		expDayList.add("24.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("24.00");
		expDayList.add("");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("1")) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		expVouchersList.add("OpeStk:4");
		expVouchersList.add("");
		expVouchersList.add("24.00");
		expVouchersList.add("");
		expVouchersList.add("24.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("24.00");
		expVouchersList.add("");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("OpeStk:4")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo=documentNumberTxt.getAttribute("value");
		String expDocNo="4";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(warehouseTxt));
		String actWarehouse=warehouseTxt.getAttribute("value");
		String expWarehouse="HYDERABAD";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
		String actItem=select1stRow_1stColumn.getText();
		String expItem="WA COGS ITEM";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
		String actUnits=select1stRow_2ndColumn.getText();
		String expUnits="Pcs";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
		String actQuantity=select1stRow_3rdColumn.getText();
		String expQuantity="12.00";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
		String actRate=select1stRow_4thColumn.getText();
		String expRate="2.00";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_5thColumn));
		String actGross=select1stRow_5thColumn.getText();
		String expGross="24.00";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_9thColumn));
		String actRMA=select1stRow_9thColumn.getText();
		String expRMA="RMA#R1OSV1,RMA#R1OSV2,RMA#R1OSV3,RMA#R1OSV4,RMA#R1OSV5,RMA#R1OSV6,RMA#R1OSV7,RMA#R1OSV8,RMA#R1OSV9,RMA#R1OSV10,RMA#R1OSV11,RMA#R1OSV12";
		

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
		String actItem2=select2ndRow_1stColumn.getText();
		String expItem2="WA COGS ITEM";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_2ndColumn));
		String actUnits2=select2ndRow_2ndColumn.getText();
		String expUnits2="Pcs";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_3rdColumn));
		String actQuantity2=select2ndRow_3rdColumn.getText();
		String expQuantity2="12.00";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_4thColumn));
		String actRate2=select2ndRow_4thColumn.getText();
		String expRate2="5.00";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_5thColumn));
		String actGross2=select2ndRow_5thColumn.getText();
		String expGross2="60.00";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_9thColumn));
		String actRMA2=select2ndRow_9thColumn.getText();
		String expRMA2="RMA#R2OSV1,RMA#R2OSV2,RMA#R2OSV3,RMA#R2OSV4,RMA#R2OSV5,RMA#R2OSV6,RMA#R2OSV7,RMA#R2OSV8,RMA#R2OSV9,RMA#R2OSV10,RMA#R2OSV11,RMA#R2OSV12";
		
		System.out.println("**********************checkMultiLevelStockMovementReportBackTrackOption*********************");
		
		System.out.println("*********** Voucher No : "+actDocNo      +"  value expected  "+expDocNo);
		System.out.println("*********** Warehouse  : "+actWarehouse  +"  value expected  "+expWarehouse);
		System.out.println("*********** Item       : "+actItem       +"  value expected  "+expItem);
		System.out.println("*********** Units      : "+actUnits      +"  value expected  "+expUnits);
		System.out.println("*********** Quantity   : "+actQuantity   +"  value expected  "+expQuantity);
		System.out.println("*********** Rate       : "+actRate       +"  value expected  "+expRate);
		System.out.println("*********** Gross      : "+actGross      +"  value expected  "+expGross);
		System.out.println(actRMA);
		System.out.println(expRMA);
		System.out.println("*********** Item2       : "+actItem2       +"  value expected  "+expItem2);
		System.out.println("*********** Units2      : "+actUnits2      +"  value expected  "+expUnits2);
		System.out.println("*********** Quantity2   : "+actQuantity2   +"  value expected  "+expQuantity2);
		System.out.println("*********** Rate2       : "+actRate2       +"  value expected  "+expRate2);
		System.out.println("*********** Gross2      : "+actGross2      +"  value expected  "+expGross2);
		System.out.println(actRMA2);
		System.out.println(expRMA2);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			 && actDocNo.equalsIgnoreCase(expDocNo) && actWarehouse.equalsIgnoreCase(expWarehouse) && actItem.equalsIgnoreCase(expItem) 
			 && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actRate.equalsIgnoreCase(expRate)
			 && actGross.equalsIgnoreCase(expGross) && actRMA.equalsIgnoreCase(expRMA)
			 && actItem2.equalsIgnoreCase(expItem2) && actUnits2.equalsIgnoreCase(expUnits2) && actQuantity2.equalsIgnoreCase(expQuantity2) 
			 && actRate2.equalsIgnoreCase(expRate2) && actGross2.equalsIgnoreCase(expGross2) && actRMA2.equalsIgnoreCase(expRMA2)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	
	
	@FindBy(xpath="//*[@id='649']")
	private static WebElement stockTransferReport;
	

	public boolean checkStockTransferRegisterReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getDriver().navigate().refresh();
		Thread.sleep(1000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();

		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,500)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(stockTransferReport).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockTransferReport));
		stockTransferReport.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM") || actName.equalsIgnoreCase("BR COGS ITEM") || actName.equalsIgnoreCase("WA COGS ITEM") || 
					actName.equalsIgnoreCase("STD RATE COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(3000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM [WA COGS ITEM]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[, HYDERABAD, , 10.00, , , , , ]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Sub Total, , , , 10.00, , , , , ]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[FIFO COGS ITEM [FIFO COGS ITEM]]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[, HYDERABAD, , 9.00, , , , , ]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow6ListCount;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[Sub Total, , , , 9.00, , , , , ]";
		
		
		
		int reportsRow7ListCount = reportsRow7List.size();
		ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow7ListCount;i++)
		{
			String data = reportsRow7List.get(i).getText();
			reportsRow7ListArray.add(data);
		}
		String actRow7List = reportsRow7ListArray.toString();
		String expRow7List = "[BR COGS ITEM [BR COGS ITEM]]";
		
		
		
		int reportsRow8ListCount = reportsRow8List.size();
		ArrayList<String> reportsRow8ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow8ListCount;i++)
		{
			String data = reportsRow8List.get(i).getText();
			reportsRow8ListArray.add(data);
		}
		String actRow8List = reportsRow8ListArray.toString();
		String expRow8List = "[, HYDERABAD, , 12.00, , , , , ]";
		
		
		
		int reportsRow9ListCount = reportsRow9List.size();
		ArrayList<String> reportsRow9ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow9ListCount;i++)
		{
			String data = reportsRow9List.get(i).getText();
			reportsRow9ListArray.add(data);
		}
		String actRow9List = reportsRow9ListArray.toString();
		String expRow9List = "[Sub Total, , , , 12.00, , , , , ]";
		
		
		
		int reportsRow10ListCount = reportsRow10List.size();
		ArrayList<String> reportsRow10ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow10ListCount;i++)
		{
			String data = reportsRow10List.get(i).getText();
			reportsRow10ListArray.add(data);
		}
		String actRow10List = reportsRow10ListArray.toString();
		String expRow10List = "[STD RATE COGS ITEM [STD RATE COGS ITEM]]";
		
		
		
		int reportsRow11ListCount = reportsRow11List.size();
		ArrayList<String> reportsRow11ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow11ListCount;i++)
		{
			String data = reportsRow11List.get(i).getText();
			reportsRow11ListArray.add(data);
		}
		String actRow11List = reportsRow11ListArray.toString();
		String expRow11List = "[, HYDERABAD, , 12.00, , , , , ]";
		
		
		
		int reportsRow12ListCount = reportsRow12List.size();
		ArrayList<String> reportsRow12ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow12ListCount;i++)
		{
			String data = reportsRow12List.get(i).getText();
			reportsRow12ListArray.add(data);
		}
		String actRow12List = reportsRow12ListArray.toString();
		String expRow12List = "[Sub Total, , , , 12.00, , , , , ]";
		
		
		
		int reportsRow13ListCount = reportsRow13List.size();
		ArrayList<String> reportsRow13ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow13ListCount;i++)
		{
			String data = reportsRow13List.get(i).getText();
			reportsRow13ListArray.add(data);
		}
		String actRow13List = reportsRow13ListArray.toString();
		String expRow13List = "[Grand Total, , , , 43.00, , , , , ]";
		
		
		System.out.println("****************************************checkStockTransferRegisterReport******************************************");

		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		System.out.println(actRow7List);
		System.out.println(expRow7List);
		
		System.out.println(actRow8List);
		System.out.println(expRow8List);
		
		System.out.println(actRow9List);
		System.out.println(expRow9List);
		
		System.out.println(actRow10List);
		System.out.println(expRow10List);
		
		System.out.println(actRow11List);
		System.out.println(expRow11List);
		
		System.out.println(actRow12List);
		System.out.println(expRow12List);
		
		System.out.println(actRow13List);
		System.out.println(expRow13List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
			&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List) 
			&& actRow7List.equalsIgnoreCase(expRow7List) && actRow8List.equalsIgnoreCase(expRow8List) && actRow9List.equalsIgnoreCase(expRow9List) 
			&& actRow10List.equalsIgnoreCase(expRow10List) && actRow11List.equalsIgnoreCase(expRow11List) && actRow12List.equalsIgnoreCase(expRow12List) 
			&& actRow13List.equalsIgnoreCase(expRow13List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	public boolean checkStockTransferRegisterReportPrintOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_ReportPrintBtn));
		sl_ReportPrintBtn.click();
		Thread.sleep(2000);

		/*getWaitForAlert();
		getAlert().accept();*/
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintLabel));
		
		String actConfirmMsg=ss_ReportPrintMsg.getText();
		String expConfirmMsg="";
		Thread.sleep(2000);
		
		System.out.println("Actual Msg		:		"+	actConfirmMsg		+ "Expected		"	+	expConfirmMsg);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ss_ReportPrintYesBtn));
		ss_ReportPrintYesBtn.click();
		
		Thread.sleep(3000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(0));
	 	
	 	Thread.sleep(1000);
	 	
	 	getDriver().switchTo().window(openTabs.get(1)).close();
	 	
	 	getDriver().switchTo().window(openTabs.get(0));
		
		System.out.println("***************************checkStockTransferRegisterReportPrintOption*********************************");
		
		System.out.println("openTabs"+openTabs);
		System.out.println("Open Tabs Count : "+actOpenWindowsCount+"  Value Expected  "+expOpenWindowsCount);
		
		Thread.sleep(1000);
		
		if(actOpenWindowsCount==expOpenWindowsCount)
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return true;
		} 
		else 
		{
			getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_CloseBtn));
			report_CloseBtn.click();
			return false;
		}
	}
	
	@FindBy (xpath="//input[@id='MasterSingle__1']")
	private static WebElement fromWarehouseTxt;
	
	@FindBy (xpath="//input[@id='MasterSingle__2']")
	private static WebElement toWarehouseTxt;

	@FindBy (xpath="//select[@id='RITCombobox__3']")
	private static WebElement summaryOrDetailsDrpdwn;
	
	
	public boolean checkStockTransferRegisterReportWithFromAndToWarehouseAndDetailsOptions() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		Thread.sleep(1000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(fromWarehouseTxt));
		fromWarehouseTxt.sendKeys("Hyderabad");
		Thread.sleep(2000);
		fromWarehouseTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(toWarehouseTxt));
		toWarehouseTxt.sendKeys("Secunderabad");
		Thread.sleep(2000);
		toWarehouseTxt.sendKeys(Keys.TAB);
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(summaryOrDetailsDrpdwn));
		Select s=new Select(summaryOrDetailsDrpdwn);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM [WA COGS ITEM]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[StkTrf:2, HYDERABAD, , 10.00, , , , , ]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Sub Total, , , , 10.00, , , , , ]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[FIFO COGS ITEM [FIFO COGS ITEM]]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[StkTrf:2, HYDERABAD, , 9.00, , , , , ]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow6ListCount;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[Sub Total, , , , 9.00, , , , , ]";
		
		
		
		int reportsRow7ListCount = reportsRow7List.size();
		ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow7ListCount;i++)
		{
			String data = reportsRow7List.get(i).getText();
			reportsRow7ListArray.add(data);
		}
		String actRow7List = reportsRow7ListArray.toString();
		String expRow7List = "[BR COGS ITEM [BR COGS ITEM]]";
		
		
		
		int reportsRow8ListCount = reportsRow8List.size();
		ArrayList<String> reportsRow8ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow8ListCount;i++)
		{
			String data = reportsRow8List.get(i).getText();
			reportsRow8ListArray.add(data);
		}
		String actRow8List = reportsRow8ListArray.toString();
		String expRow8List = "[StkTrf:2, HYDERABAD, , 12.00, , , , , ]";
		
		
		
		int reportsRow9ListCount = reportsRow9List.size();
		ArrayList<String> reportsRow9ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow9ListCount;i++)
		{
			String data = reportsRow9List.get(i).getText();
			reportsRow9ListArray.add(data);
		}
		String actRow9List = reportsRow9ListArray.toString();
		String expRow9List = "[Sub Total, , , , 12.00, , , , , ]";
		
		
		
		int reportsRow10ListCount = reportsRow10List.size();
		ArrayList<String> reportsRow10ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow10ListCount;i++)
		{
			String data = reportsRow10List.get(i).getText();
			reportsRow10ListArray.add(data);
		}
		String actRow10List = reportsRow10ListArray.toString();
		String expRow10List = "[STD RATE COGS ITEM [STD RATE COGS ITEM]]";
		
		
		
		int reportsRow11ListCount = reportsRow11List.size();
		ArrayList<String> reportsRow11ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow11ListCount;i++)
		{
			String data = reportsRow11List.get(i).getText();
			reportsRow11ListArray.add(data);
		}
		String actRow11List = reportsRow11ListArray.toString();
		String expRow11List = "[StkTrf:2, HYDERABAD, , 12.00, , , , , ]";
		
		
		
		int reportsRow12ListCount = reportsRow12List.size();
		ArrayList<String> reportsRow12ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow12ListCount;i++)
		{
			String data = reportsRow12List.get(i).getText();
			reportsRow12ListArray.add(data);
		}
		String actRow12List = reportsRow12ListArray.toString();
		String expRow12List = "[Sub Total, , , , 12.00, , , , , ]";
		
		
		
		int reportsRow13ListCount = reportsRow13List.size();
		ArrayList<String> reportsRow13ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow13ListCount;i++)
		{
			String data = reportsRow13List.get(i).getText();
			reportsRow13ListArray.add(data);
		}
		String actRow13List = reportsRow13ListArray.toString();
		String expRow13List = "[Grand Total, , , , 43.00, , , , , ]";
		
		
		System.out.println("****************************************checkStockTransferRegisterReportWithFromAndToWarehouseAndDetailsOptions******************************************");

		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		System.out.println(actRow7List);
		System.out.println(expRow7List);
		
		System.out.println(actRow8List);
		System.out.println(expRow8List);
		
		System.out.println(actRow9List);
		System.out.println(expRow9List);
		
		System.out.println(actRow10List);
		System.out.println(expRow10List);
		
		System.out.println(actRow11List);
		System.out.println(expRow11List);
		
		System.out.println(actRow12List);
		System.out.println(expRow12List);
		
		System.out.println(actRow13List);
		System.out.println(expRow13List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
			&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List) 
			&& actRow7List.equalsIgnoreCase(expRow7List) && actRow8List.equalsIgnoreCase(expRow8List) && actRow9List.equalsIgnoreCase(expRow9List) 
			&& actRow10List.equalsIgnoreCase(expRow10List) && actRow11List.equalsIgnoreCase(expRow11List) && actRow12List.equalsIgnoreCase(expRow12List) 
			&& actRow13List.equalsIgnoreCase(expRow13List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	public boolean checkStockTransferRegisterReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		int Count=reportTableColumn1RowsList.size();
		   
		for (int i = 0; i < Count; i++) 
	    {
             String data=reportTableColumn2RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("StkTrf:2"))
             {
            	 reportTableColumn2RowsList.get(i).click();
        		 Thread.sleep(1000);
        		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            	 report_BackTrackBtn.click();
            	 Thread.sleep(3000);
            	 
            	
            	try{
            		 String m="Please select a row in the grid to Backtrack";
            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
            		 {
            			 reportTableColumn2RowsList.get(i).click();
            			 Thread.sleep(2000);
            			 
            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            			 report_BackTrackBtn.click();
            			 Thread.sleep(3000);
            	
            		 }
            	}
            	catch(Exception e){
            		System.out.println("message not displaying");
            		
            	}
            	break;
             }
		     }
		
		
	 /*   getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("60.00");
		expMonthlyList.add("34.00");
		expMonthlyList.add("62.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("96.00");
		expMonthlyList.add("34.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("60.00");
		expDayList.add("34.00");
		expDayList.add("62.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("60.00");
		expDayList.add("34.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);

		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("36.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT57:SU/IND/TEXT2");
		expVouchersList.add("48.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("84.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("84.00");
		expVouchersList.add("12.00");
		expVouchersList.add("12.00");
		expVouchersList.add("84.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("84.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("72.00");
		expVouchersList.add("NDT50:1");
		expVouchersList.add("72.00");
		expVouchersList.add("");
		expVouchersList.add("10.00");
		expVouchersList.add("62.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("60.00");
		expVouchersList.add("34.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);

		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("StkTrf:2")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo = documentNumberTxt.getAttribute("value");
		String expDocNo = "2";
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockTransferheaderWarehouse1Txt));
		String actFromWarehouse = stockTransferheaderWarehouse1Txt.getAttribute("value");
		String expFromWarehouse = "HYDERABAD";
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
		String actR1Warehouse = select1stRow_1stColumn.getText();
		String expR1Warehouse = "SECUNDERABAD";
		
		String actR1Item = select1stRow_2ndColumn.getText();
		String expR1Item = "STD RATE COGS ITEM";
		
		String actR1Units = select1stRow_3rdColumn.getText();
		String expR1Units = "Pcs";
		
		String actR1Quantity = select1stRow_4thColumn.getText();
		String expR1Quantity = "12.00";
		
		String actR1Rate = select1stRow_6thColumn.getText();
		String expR1Rate = "10.00";
		
		String actR1Gross = select1stRow_7thColumn.getText();
		String expR1Gross = "120.00";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select2ndRow_1stColumn));
		String actR2Warehouse = select2ndRow_1stColumn.getText();
		String expR2Warehouse = "SECUNDERABAD";
		
		String actR2Item = select2ndRow_2ndColumn.getText();
		String expR2Item = "BR COGS ITEM";
		
		String actR2Units = select2ndRow_3rdColumn.getText();
		String expR2Units = "Pcs";
		
		String actR2Quantity = select2ndRow_4thColumn.getText();
		String expR2Quantity = "12.00";
		
		String actR2Rate = select2ndRow_6thColumn.getText();
		String expR2Rate = "10.00";
		
		String actR2Gross = select2ndRow_7thColumn.getText();
		String expR2Gross = "120.00";
		
		String actR2Batch = select2ndRow_8thColumn.getText();
		String expR2Batch = "BATCH#OSVR2";

		

		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select3rdRow_1stColumn));
		String actR3Warehouse = select3rdRow_1stColumn.getText();
		String expR3Warehouse = "SECUNDERABAD";
		
		String actR3Item = select3rdRow_2ndColumn.getText();
		String expR3Item = "FIFO COGS ITEM";
		
		String actR3Units = select3rdRow_3rdColumn.getText();
		String expR3Units = "Pcs";
		
		String actR3Quantity = select3rdRow_4thColumn.getText();
		String expR3Quantity = "9.00";
		
		String actR3Rate = select3rdRow_6thColumn.getText();
		String expR3Rate = "10.00";
		
		String actR3Gross = select3rdRow_7thColumn.getText();
		String expR3Gross = "90.00";
		
		String actR3Bins = select3rdRow_9thColumn.getText();
		String expR3Bins = "Bin4";
		
		String actR3Bins2 = select3rdRow_10thColumn.getText();
		String expR3Bins2 = "Bin Update";
		
		
		
		getWebDriverWait().until(ExpectedConditions.elementToBeClickable(select4thRow_1stColumn));
		String actR4Warehouse = select4thRow_1stColumn.getText();
		String expR4Warehouse = "SECUNDERABAD";
		
		String actR4Item = select4thRow_2ndColumn.getText();
		String expR4Item = "WA COGS ITEM";
		
		String actR4Units = select4thRow_3rdColumn.getText();
		String expR4Units = "Pcs";
		
		String actR4Quantity = select4thRow_4thColumn.getText();
		String expR4Quantity = "10.00";
		
		String actR4Rate = select4thRow_6thColumn.getText();
		String expR4Rate = "10.00";
		
		String actR4Gross = select4thRow_7thColumn.getText();
		String expR4Gross = "100.00";
		
		String actR4RMA = select4thRow_11thColumn.getText();
		String expR4RMA = "RMA#R1OSV1,RMA#R1OSV2,RMA#R1OSV3,RMA#R1OSV4,RMA#R1OSV5,RMA#R1OSV6,RMA#R1OSV7,RMA#R1OSV8,RMA#R1OSV9,RMA#R2OSV1";
		
		
		System.out.println("**********************checkStockTransferRegisterReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs       : "+actOpenWindowsCount +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No     : "+actDocNo			+"  Value Expected  "+expDocNo);
		System.out.println("From Warehouse  : "+actFromWarehouse	+"  Value Expected  "+expFromWarehouse);
		
		System.out.println("*******************************ROW1**********************************");
		
		System.out.println("Warehouse       : "+actR1Warehouse			+"  Value Expected  "+expR1Warehouse);
		System.out.println("Item            : "+actR1Item				+"  Value Expected  "+expR1Item);
		System.out.println("Units           : "+actR1Units				+"  Value Expected  "+expR1Units);
		System.out.println("Quantity        : "+actR1Quantity			+"  Value Expected  "+expR1Quantity);
		System.out.println("Rate            : "+actR1Rate				+"  Value Expected  "+expR1Rate);
		System.out.println("Gross           : "+actR1Gross				+"  Value Expected  "+expR1Gross);
		
		
		System.out.println("*******************************ROW2**********************************");
		
		System.out.println("Warehouse       : "+actR2Warehouse			+"  Value Expected  "+expR2Warehouse);
		System.out.println("Item            : "+actR2Item				+"  Value Expected  "+expR2Item);
		System.out.println("Units           : "+actR2Units				+"  Value Expected  "+expR2Units);
		System.out.println("Quantity        : "+actR2Quantity			+"  Value Expected  "+expR2Quantity);
		System.out.println("Rate            : "+actR2Rate				+"  Value Expected  "+expR2Rate);
		System.out.println("Gross           : "+actR2Gross				+"  Value Expected  "+expR2Gross);
		System.out.println("Bins            : "+actR2Batch				+"  Value Expected  "+expR2Batch);
		
		System.out.println("*******************************ROW3**********************************");
		
		System.out.println("Warehouse       : "+actR3Warehouse			+"  Value Expected  "+expR3Warehouse);
		System.out.println("Item            : "+actR3Item				+"  Value Expected  "+expR3Item);
		System.out.println("Units           : "+actR3Units				+"  Value Expected  "+expR3Units);
		System.out.println("Quantity        : "+actR3Quantity			+"  Value Expected  "+expR3Quantity);
		System.out.println("Rate            : "+actR3Rate				+"  Value Expected  "+expR3Rate);
		System.out.println("Gross           : "+actR3Gross				+"  Value Expected  "+expR3Gross);
		System.out.println("Bins            : "+actR3Bins				+"  Value Expected  "+expR3Bins);
		System.out.println("Bins2           : "+actR3Bins2				+"  Value Expected  "+expR3Bins2);
		
		System.out.println("*******************************ROW4**********************************");
		
		System.out.println("Warehouse       : "+actR4Warehouse			+"  Value Expected  "+expR4Warehouse);
		System.out.println("Item            : "+actR4Item				+"  Value Expected  "+expR4Item);
		System.out.println("Units           : "+actR4Units				+"  Value Expected  "+expR4Units);
		System.out.println("Quantity        : "+actR4Quantity			+"  Value Expected  "+expR4Quantity);
		System.out.println("Rate            : "+actR4Rate				+"  Value Expected  "+expR4Rate);
		System.out.println("Gross           : "+actR4Gross				+"  Value Expected  "+expR4Gross);
		System.out.println("RMA             : "+actR4RMA				+"  Value Expected  "+expR4RMA);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			   && actDocNo.equalsIgnoreCase(expDocNo) && actFromWarehouse.equalsIgnoreCase(expFromWarehouse)
			   
			   
			   && actR1Warehouse.equalsIgnoreCase(expR1Warehouse) && actR1Item.equalsIgnoreCase(expR1Item) && actR1Units.equalsIgnoreCase(expR1Units) 
			   && actR1Quantity.equalsIgnoreCase(expR1Quantity) && actR1Rate.equalsIgnoreCase(expR1Rate) && actR1Gross.equalsIgnoreCase(expR1Gross) 
			   
			   && actR2Warehouse.equalsIgnoreCase(expR2Warehouse) && actR2Item.equalsIgnoreCase(expR2Item) && actR2Units.equalsIgnoreCase(expR2Units) 
			   && actR2Quantity.equalsIgnoreCase(expR2Quantity) && actR2Rate.equalsIgnoreCase(expR2Rate) && actR2Gross.equalsIgnoreCase(expR2Gross) && actR2Batch.equalsIgnoreCase(expR2Batch) 
			   
			   && actR3Warehouse.equalsIgnoreCase(expR3Warehouse) && actR3Item.equalsIgnoreCase(expR3Item) && actR3Units.equalsIgnoreCase(expR3Units) 
			   && actR3Quantity.equalsIgnoreCase(expR3Quantity) && actR3Rate.equalsIgnoreCase(expR3Rate) && actR3Gross.equalsIgnoreCase(expR3Gross) 
			   && actR3Bins.equalsIgnoreCase(expR3Bins) && actR3Bins2.equalsIgnoreCase(expR3Bins2)
			   
			   && actR4Warehouse.equalsIgnoreCase(expR4Warehouse) && actR4Item.equalsIgnoreCase(expR4Item) && actR4Units.equalsIgnoreCase(expR4Units) 
			   && actR4Quantity.equalsIgnoreCase(expR4Quantity) && actR4Rate.equalsIgnoreCase(expR4Rate) && actR4Gross.equalsIgnoreCase(expR4Gross) 
			   && actR4RMA.equalsIgnoreCase(expR4RMA)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}

	
	@FindBy(xpath="//*[@id='665']")
	private static WebElement stockReservationReport;
	
	public boolean checkStockReservationRegisterReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getDriver().navigate().refresh();
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();

		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,500)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(stockReservationReport).build().perform();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockReservationReport));
		stockReservationReport.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM") || actName.equalsIgnoreCase("WA COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM [WA COGS ITEM]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Sales Orders, 4, WA COGS ITEM, 40.00, 10.00, Customer A]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Sales invoice VAT, 5, WA COGS ITEM, 3.00, 10.00, Customer A]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[Sales Orders, 4, WA COGS ITEM, 6.00, 10.00, Customer A]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[Sub Total, , , , 43.00, 30.00, ]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow6ListCount;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[FIFO COGS ITEM [FIFO COGS ITEM]]";
		
		
		
		int reportsRow7ListCount = reportsRow7List.size();
		ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow7ListCount;i++)
		{
			String data = reportsRow7List.get(i).getText();
			reportsRow7ListArray.add(data);
		}
		String actRow7List = reportsRow7ListArray.toString();
		String expRow7List = "[Sales Orders, 3, FIFO COGS ITEM, 6.00, 10.00, Customer A]";
		
		
		
		int reportsRow8ListCount = reportsRow8List.size();
		ArrayList<String> reportsRow8ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow8ListCount;i++)
		{
			String data = reportsRow8List.get(i).getText();
			reportsRow8ListArray.add(data);
		}
		String actRow8List = reportsRow8ListArray.toString();
		String expRow8List = "[Sub Total, , , , 6.00, 10.00, ]";
		
		
		
		int reportsRow9ListCount = reportsRow9List.size();
		ArrayList<String> reportsRow9ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow9ListCount;i++)
		{
			String data = reportsRow9List.get(i).getText();
			reportsRow9ListArray.add(data);
		}
		String actRow9List = reportsRow9ListArray.toString();
		String expRow9List = "[Grand Total, , , , 49.00, 40.00, ]";
		
		
		System.out.println("*********************************checkStockReservationRegisterReport*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		System.out.println(actRow7List);
		System.out.println(expRow7List);
		
		System.out.println(actRow8List);
		System.out.println(expRow8List);
		
		System.out.println(actRow9List);
		System.out.println(expRow9List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List) 
				&& actRow7List.equalsIgnoreCase(expRow7List) && actRow8List.equalsIgnoreCase(expRow8List) && actRow9List.equalsIgnoreCase(expRow9List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	@FindBy (xpath="//input[@id='FOption_665_0_DefaultFilter_0']")
	private static WebElement stockReservationRegister_DefaultFilterTxt;
	
	
	
	@FindBy (xpath="//*[@id='FilterFields_665_0']/ul[4]/li[1]/div/label/span")
	private static WebElement sr_report_FilterItemNameChkbox;
	
	public boolean checkStockReservationRegisterReportWithFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemExpansion));
		report_FilterItemExpansion.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
		
		if (report_FilterItemNameChkbox.isSelected()==false) 
		{
			report_FilterItemNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockReservationRegister_DefaultFilterTxt));
		stockReservationRegister_DefaultFilterTxt.click();
		stockReservationRegister_DefaultFilterTxt.sendKeys("FIFO COGS ITEM");
		
		Thread.sleep(2000);
		
		stockReservationRegister_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(3000);
	
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[FIFO COGS ITEM [FIFO COGS ITEM]]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Sales Orders, 3, FIFO COGS ITEM, 6.00, 10.00, Customer A]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Total, , , , 6.00, 10.00, ]";
		
		System.out.println("****************************checkStockReservationRegisterReportWithFilterOption******************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
		
		if (report_FilterItemNameChkbox.isSelected()==true) 
		{
			report_FilterItemNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
			
		Thread.sleep(3000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int actRowCount = reportsRowsCount.size();
		int expRowCount = 9; 
		
		System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRowCount==expRowCount)
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	public boolean checkStockReservationRegisterReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
	    int Count=reportTableColumn1RowsList.size();
		   
		for (int i = 0; i < Count; i++) 
	    {
             String data=reportTableColumn2RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("Sales invoice VAT"))
             {
            	 reportTableColumn2RowsList.get(i).click();
        		 Thread.sleep(1000);
        		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            	 report_BackTrackBtn.click();
            	 Thread.sleep(3000);
            	 
            	
            	try{
            		 String m="Please select a row in the grid to Backtrack";
            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
            		 {
            			 reportTableColumn2RowsList.get(i).click();
            			 Thread.sleep(2000);
            			 
            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            			 report_BackTrackBtn.click();
            			 Thread.sleep(3000);
            	
            		 }
            	}
            	catch(Exception e){
            		System.out.println("message not displaying");
            		
            	}
            	break;
             }
		     }
		
	/*	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
		
		Thread.sleep(3000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
		
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo=documentNumberTxt.getAttribute("value");
		String expDocNo="5";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customerAccountTxt));
		String actCustomer=customerAccountTxt.getAttribute("value");
		String expCustomer="Customer A";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
	 	String actWarehouse = select1stRow_1stColumn.getText();
	 	String expWarehouse = "HYDERABAD";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
	 	String actItem = select1stRow_2ndColumn.getText();
	 	String expItem = "WA COGS ITEM";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
	 	String actTaxCode = select1stRow_3rdColumn.getText();
	 	String expTaxCode = "Std Rate";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
	 	String actSalesAccount = select1stRow_4thColumn.getText();
	 	String expSalesAccount = "Sales - Computers";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_5thColumn));
	 	String actUnits = select1stRow_5thColumn.getText();
	 	String expUnits = "Pcs";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_11thColumn));
	 	String actQuantity = select1stRow_11thColumn.getText();
	 	String expQuantity = "3.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_12thColumn));
	 	String actLSalesOrder = select1stRow_12thColumn.getText();
	 	String expLSalesOrder = "SalOrd:4";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_14thColumn));
	 	String actRate = select1stRow_14thColumn.getText();
	 	String expRate = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_15thColumn));
	 	String actGross = select1stRow_15thColumn.getText();
	 	String expGross = "30.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_21stColumn));
	 	String actRMA = select1stRow_21stColumn.getText();
	 	String expRMA = "RMA#R2OSV8,RMA#R2OSV9,RMA#R1OSV10";
	 	
		System.out.println("**********************checkStockReservationRegisterReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs        : "+actOpenWindowsCount         +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No      : "+actDocNo         +"  Value Expected  "+expDocNo);
		System.out.println("Customer Account : "+actCustomer      +"  Value Expected  "+expCustomer);
		System.out.println("Warehouse        : "+actWarehouse     +"  Value Expected  "+expWarehouse);
		System.out.println("Item             : "+actItem          +"  Value Expected  "+expItem);
		System.out.println("Tax Code         : "+actTaxCode       +"  Value Expected  "+expTaxCode);
		System.out.println("Sales Account    : "+actSalesAccount  +"  Value Expected  "+expSalesAccount);
		System.out.println("Units            : "+actUnits         +"  Value Expected  "+expUnits);
		System.out.println("Quantity         : "+actQuantity      +"  Value Expected  "+expQuantity);
		System.out.println("L Sales Order    : "+actLSalesOrder   +"  Value Expected  "+expLSalesOrder);
		System.out.println("Rate             : "+actRate          +"  Value Expected  "+expRate);
		System.out.println("Gross            : "+actGross         +"  Value Expected  "+expGross);
		System.out.println("RMA              : "+actRMA           +"  Value Expected  "+expRMA);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		if (actDocNo.equalsIgnoreCase(expDocNo) && actCustomer.equalsIgnoreCase(expCustomer) && actWarehouse.equalsIgnoreCase(expWarehouse)
			   && actItem.equalsIgnoreCase(expItem) && actTaxCode.equalsIgnoreCase(expTaxCode) && actSalesAccount.equalsIgnoreCase(expSalesAccount)
			   && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actLSalesOrder.equalsIgnoreCase(expLSalesOrder)
			   && actRate.equalsIgnoreCase(expRate) && actGross.equalsIgnoreCase(expGross) && actRMA.equalsIgnoreCase(expRMA))
		{
			
			return true;
		} 
		else 
		{
			
			return false;
		}
	}
	

	@FindBy(xpath="//*[@id='670']")
	private static WebElement transactionTypeWiseStockReport;

	public boolean checkTransactionTypeWiseStockReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getDriver().navigate().refresh();
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();

		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,700)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(transactionTypeWiseStockReport).build().perform();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(transactionTypeWiseStockReport));
		transactionTypeWiseStockReport.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM") || actName.equalsIgnoreCase("WA COGS ITEM") || actName.equalsIgnoreCase("BR COGS ITEM")
					|| actName.equalsIgnoreCase("STD RATE COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM, 43.00, 318.66, 7.41, 24.00, 84.00, 22.00, 231.00, , , , , , , , , , , , , , , 10.00, 100.00, , , , , , , , , , , , , 13.00, 96.34, , , , , , , , ]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, 69.00, 56.50, 0.82, 36.00, 20.00, 36.00, 31.50, , , , , , , , , , , , , , , 12.00, 10.00, , , , , , , , , , , , , 15.00, 8.33, , , , , , , , ]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[BR COGS ITEM, 62.00, 42.75, 0.69, 36.00, 20.00, 36.00, 31.50, , , , , , , , , , , , , , , 12.00, 10.00, , , , , , , , , , , , , 22.00, 18.75, , , , , , , , ]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[STD RATE COGS ITEM, 96.00, 960.00, 10.00, 36.00, 20.00, 60.00, 94.50, , , , , , , , , , , , , 12.00, 120.00, 12.00, 10.00, , , , , , , , , , , , , 24.00, 240.00, , , , , , , , ]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[Grand Total, 270.00, 1,377.91, 18.92, 132.00, 144.00, 154.00, 388.50, , , , , , , , , , , , , 12.00, 120.00, 46.00, 130.00, , , , , , , , , , , , , 74.00, 363.42, , , , , , , , ]";
		
		
		System.out.println("*********************************checkTransactionTypeWiseStockReport*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	@FindBy (xpath="//input[@id='FOption_670_0_DefaultFilter_0']")
	private static WebElement tranTypeWiseStock_DefaultFilterTxt;
	
	@FindBy(xpath="//*[@id='FilterFields_670_0']/ul[4]/li[1]/div/label/span")
	private static WebElement tranTypeWise_report_FilterItemNameChkbox;
	
	
	public boolean checkTransactionTypeWiseStockReportWithFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemExpansion));
		report_FilterItemExpansion.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
		
		if (report_FilterItemNameChkbox.isSelected()==false) 
		{
			report_FilterItemNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(tranTypeWiseStock_DefaultFilterTxt));
		tranTypeWiseStock_DefaultFilterTxt.click();
		tranTypeWiseStock_DefaultFilterTxt.sendKeys("STD RATE COGS ITEM");
		
		Thread.sleep(2000);
		
		tranTypeWiseStock_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
	
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[STD RATE COGS ITEM, 96.00, 960.00, 10.00, 36.00, 20.00, 60.00, 94.50, , , , , , , , , , , , , 12.00, 120.00, 12.00, 10.00, , , , , , , , , , , , , 24.00, 240.00, , , , , , , , ]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Grand Total, 96.00, 960.00, 10.00, 36.00, 20.00, 60.00, 94.50, , , , , , , , , , , , , 12.00, 120.00, 12.00, 10.00, , , , , , , , , , , , , 24.00, 240.00, , , , , , , , ]";
		
		System.out.println("****************************checkTransactionTypeWiseStockReportWithFilterOption******************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		Thread.sleep(200);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
		
		if (report_FilterItemNameChkbox.isSelected()==true) 
		{
			report_FilterItemNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
			
		Thread.sleep(4000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int actRowCount = reportsRowsCount.size();
		int expRowCount = 5; 
		
		System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRowCount==expRowCount)
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
	
	
	
	
	
	
	
	public boolean checkTransactionTypeWiseStockReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		int reportItemGridListCount=reportTableColumn1RowsList.size();
	    for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("STD RATE COGS ITEM"))
             {
        		 reportTableColumn1RowsList.get(i).click();
        		 Thread.sleep(1000);
        		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            	 report_BackTrackBtn.click();
            	 Thread.sleep(3000);
            	 
            	
            	try{
            		 String m="Please select a row in the grid to Backtrack";
            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
            		 {
            			 reportTableColumn1RowsList.get(i).click();
            			 Thread.sleep(2000);
            			 
            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            			 report_BackTrackBtn.click();
            			 Thread.sleep(3000);
            	
            		 }
            	}
            	catch(Exception e){
            		System.out.println("message not displaying");
            		
            	}
            	break;
             }
		     }
	    
	/*	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();
		*/
	    
	    Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("96.00");
		expMonthlyList.add("36.00");
		expMonthlyList.add("96.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("132.00");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("96.00");
		expDayList.add("36.00");
		expDayList.add("96.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("96.00");
		expDayList.add("36.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);

		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		
		expVouchersList.add("NDT57:SU/IND/TEXT1");
		expVouchersList.add("36.00");
		expVouchersList.add("24.00");
		expVouchersList.add("");
		expVouchersList.add("60.00");
		expVouchersList.add("NDT50:6");
		expVouchersList.add("60.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT57:SU/IND/TEXT3");
		expVouchersList.add("48.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("84.00");
		expVouchersList.add("SalRet:1");
		expVouchersList.add("84.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("96.00");
		
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("96.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("108.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("108.00");
		expVouchersList.add("12.00");
		expVouchersList.add("12.00");
		expVouchersList.add("108.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("108.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("96.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("96.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("SalRet:1")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo=documentNumberTxt.getAttribute("value");
		String expDocNo="1";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customerAccountTxt));
		String actCustomer=customerAccountTxt.getAttribute("value");
		String expCustomer="Customer A";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
	 	String actWarehouse = select1stRow_1stColumn.getText();
	 	String expWarehouse = "HYDERABAD";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
	 	String actItem = select1stRow_2ndColumn.getText();
	 	String expItem = "STD RATE COGS ITEM";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
	 	String actSalesAccount = select1stRow_3rdColumn.getText();
	 	String expSalesAccount = "Sales - Computers";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
	 	String actUnits = select1stRow_4thColumn.getText();
	 	String expUnits = "Pcs";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_6thColumn));
	 	String actQuantity = select1stRow_6thColumn.getText();
	 	String expQuantity = "12.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_7thColumn));
	 	String actLSalesInvoice = select1stRow_7thColumn.getText();
	 	String expLSalesInvoice = "NDT50:6";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_8thColumn));
	 	String actRate = select1stRow_8thColumn.getText();
	 	String expRate = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_9thColumn));
	 	String actGross = select1stRow_9thColumn.getText();
	 	String expGross = "120.00";
	 	
		System.out.println("**********************checkStockReportbyTagReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs        : "+actOpenWindowsCount         +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No      : "+actDocNo         +"  Value Expected  "+expDocNo);
		System.out.println("Customer Account : "+actCustomer      +"  Value Expected  "+expCustomer);
		System.out.println("Warehouse        : "+actWarehouse     +"  Value Expected  "+expWarehouse);
		System.out.println("Item             : "+actItem          +"  Value Expected  "+expItem);
		System.out.println("Sales Account    : "+actSalesAccount  +"  Value Expected  "+expSalesAccount);
		System.out.println("Units            : "+actUnits         +"  Value Expected  "+expUnits);
		System.out.println("Quantity         : "+actQuantity      +"  Value Expected  "+expQuantity);
		System.out.println("L Sales Order    : "+actLSalesInvoice +"  Value Expected  "+expLSalesInvoice);
		System.out.println("Rate             : "+actRate          +"  Value Expected  "+expRate);
		System.out.println("Gross            : "+actGross         +"  Value Expected  "+expGross);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			   && actDocNo.equalsIgnoreCase(expDocNo) && actCustomer.equalsIgnoreCase(expCustomer) && actWarehouse.equalsIgnoreCase(expWarehouse)
			   && actItem.equalsIgnoreCase(expItem) && actSalesAccount.equalsIgnoreCase(expSalesAccount)
			   && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actLSalesInvoice.equalsIgnoreCase(expLSalesInvoice)
			   && actRate.equalsIgnoreCase(expRate) && actGross.equalsIgnoreCase(expGross)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	
	
	@FindBy(xpath="//*[@id='680']")
	private static WebElement actualConsumptionReport;
	

	public boolean checkActualConsumptionReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();

		
		Thread.sleep(2000);
		
		((JavascriptExecutor)getDriver()).executeScript("window.scrollBy(0,900)","");
		Thread.sleep(2000);
		
		getAction().moveToElement(actualConsumptionReport).build().perform();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(actualConsumptionReport));
		actualConsumptionReport.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 0; i < rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("FIFO COGS ITEM") || actName.equalsIgnoreCase("WA COGS ITEM") || actName.equalsIgnoreCase("BR COGS ITEM")
					|| actName.equalsIgnoreCase("STD RATE COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM, 24.00, 84.00, , , 22.00, 231.00, 10.00, 100.00, , , , , 13.00, 1,252.41, , , , , , , 43.00, 19.47, 837.41]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[FIFO COGS ITEM, 36.00, 20.00, , , 36.00, 31.50, 12.00, 10.00, , , , , 15.00, 125.00, , , , , , , 69.00, 0.92, 63.50]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[BR COGS ITEM, 36.00, 20.00, , , 36.00, 31.50, 12.00, 10.00, , , , , 22.00, 412.50, , , , , , , 62.00, 5.66, 351.00]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[STD RATE COGS ITEM, 36.00, 20.00, , , 60.00, 94.50, 12.00, 10.00, 12.00, 120.00, , , 24.00, 5,760.00, , , , , , , 96.00, 57.45, 5,515.50]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[Grand Total, 132.00, 144.00, , , 154.00, 388.50, 46.00, 130.00, 12.00, 120.00, , , 74.00, 7,549.91, , , , , , , 270.00, 83.51, 6,767.41]";
		
		
		System.out.println("*********************************checkActualConsumptionReport*****************************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
				&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
	
	
	@FindBy (xpath="//input[@id='FOption_680_0_DefaultFilter_0']")
	private static WebElement actualConsumption_DefaultFilterTxt;
	
	@FindBy(xpath="//*[@id='FilterFields_680_0']/ul[4]/li[1]/div/label/span")
	private static WebElement actualCons_report_FilterItemNameChkbox;
	
	public boolean checkActualConsumptionReportWithFilterOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemExpansion));
		report_FilterItemExpansion.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
		
		if (report_FilterItemNameChkbox.isSelected()==false) 
		{
			report_FilterItemNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(actualConsumption_DefaultFilterTxt));
		actualConsumption_DefaultFilterTxt.click();
		actualConsumption_DefaultFilterTxt.sendKeys("BR COGS ITEM");
		
		Thread.sleep(2000);
		
		actualConsumption_DefaultFilterTxt.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
		
		Thread.sleep(2000);
	
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[BR COGS ITEM, 36.00, 20.00, , , 36.00, 31.50, 12.00, 10.00, , , , , 22.00, 412.50, , , , , , , 62.00, 5.66, 351.00]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Grand Total, 36.00, 20.00, , , 36.00, 31.50, 12.00, 10.00, , , , , 22.00, 412.50, , , , , , , 62.00, 5.66, 351.00]";
		
		System.out.println("****************************checkTransactionTypeWiseStockReportWithFilterOption******************************");
		
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterExpandBtn));
		report_FilterExpandBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterBtn));
		report_FilterBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterCustomizeBtn));
		report_FilterCustomizeBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterItemNameChkboxSelected));
		
		if (report_FilterItemNameChkbox.isSelected()==true) 
		{
			report_FilterItemNameChkboxSelected.click();
		}

		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reports_Filter_Customize_OkBtn));
		reports_Filter_Customize_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_Filter_RefreshConditionBtn));
		report_Filter_RefreshConditionBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_FilterOkBtn));
		report_FilterOkBtn.click();
			
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
		
		int actRowCount = reportsRowsCount.size();
		int expRowCount = 5; 
		
		System.out.println("Reports Row Count : "+actRowCount+"  Value Expected  "+expRowCount);
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRowCount==expRowCount)
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
    
                  
    
    
    
  
	public boolean checkActualConsumptionReportBackTrackOption() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		int reportItemGridListCount=reportTableColumn1RowsList.size();
	    for (int i = 0; i < reportItemGridListCount; i++) 
	    {
             String data=reportTableColumn1RowsList.get(i).getText();
             
             if (data.equalsIgnoreCase("STD RATE COGS ITEM"))
             {
        		 reportTableColumn1RowsList.get(i).click();
        		 Thread.sleep(1000);
        		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            	 report_BackTrackBtn.click();
            	 Thread.sleep(3000);
            	 
            	
            	try{
            		 String m="Please select a row in the grid to Backtrack";
            		 if(m.equalsIgnoreCase("Please select a row in the grid to Backtrack"))
            		 {
            			 reportTableColumn1RowsList.get(i).click();
            			 Thread.sleep(2000);
            			 
            			 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(report_BackTrackBtn));
            			 report_BackTrackBtn.click();
            			 Thread.sleep(3000);
            	
            		 }
            	}
            	catch(Exception e){
            		System.out.println("message not displaying");
            		
            	}
            	break;
             }
		     }
	    
		/*getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_BackTrackBtn));
		sl_BackTrackBtn.click();*/
	    
	    Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsMonthsTable));
		
		int backTrackMonthlyColumnsCount = backTrackItemDetailsMonthsTableList.size();
		ArrayList<String> actMonthlyList = new ArrayList<String>();
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			actMonthlyList.add(data);
		}
		
		Calendar cal=Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("MMMM yyyy");
		String Row2Month = df.format(cal.getTime());
		
		ArrayList<String> expMonthlyList = new ArrayList<String>();
		expMonthlyList.add("January 2020");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		expMonthlyList.add("36.00");
		expMonthlyList.add(Row2Month);
		expMonthlyList.add("36.00");
		expMonthlyList.add("96.00");
		expMonthlyList.add("36.00");
		expMonthlyList.add("96.00");
		expMonthlyList.add("");
		expMonthlyList.add("");
		expMonthlyList.add("132.00");
		expMonthlyList.add("36.00");
		expMonthlyList.add("");
		
		System.out.println(actMonthlyList);
		System.out.println(expMonthlyList);
		
		for(int i=0; i<backTrackMonthlyColumnsCount; i++)
		{
			String data = backTrackItemDetailsMonthsTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row2Month)) 
			{
				getAction().doubleClick(backTrackItemDetailsMonthsTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsDaysTable));
		
		int backTrackDayColumnsCount = backTrackItemDetailsDaysTableList.size();
		ArrayList<String> actDayList = new ArrayList<String>();
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			actDayList.add(data);
		}
		
		DateFormat dt = new SimpleDateFormat("d");
		String Row1Date = dt.format(cal.getTime());
		
		ArrayList<String> expDayList = new ArrayList<String>();
		expDayList.add(Row1Date);
		expDayList.add("36.00");
		expDayList.add("96.00");
		expDayList.add("36.00");
		expDayList.add("96.00");
		expDayList.add("");
		expDayList.add("");
		expDayList.add("96.00");
		expDayList.add("36.00");
		expDayList.add("");
		
		System.out.println(actDayList);
		System.out.println(expDayList);
		
		for(int i=0; i<backTrackDayColumnsCount; i++)
		{
			String data = backTrackItemDetailsDaysTableList.get(i).getText();
			
			if (data.equalsIgnoreCase(Row1Date)) 
			{
				getAction().doubleClick(backTrackItemDetailsDaysTableList.get(i)).build().perform();
				break;
			}
		}
		
		Thread.sleep(2000);

		getFluentWebDriverWait().until(ExpectedConditions.visibilityOf(backTrackItemDetailsVouchersTable));
		
		int backTrackVouchersColumnsCount = backTrackItemDetailsVouchersTableList.size();
		ArrayList<String> actVouchersList = new ArrayList<String>();
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			actVouchersList.add(data);
		}
		
		ArrayList<String> expVouchersList = new ArrayList<String>();
		expVouchersList.add("NDT57:SU/IND/TEXT1");
		expVouchersList.add("36.00");
		expVouchersList.add("24.00");
		expVouchersList.add("");
		expVouchersList.add("60.00");
		expVouchersList.add("NDT50:6");
		expVouchersList.add("60.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("48.00");
		expVouchersList.add("NDT57:SU/IND/TEXT3");
		expVouchersList.add("48.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		expVouchersList.add("84.00");
		expVouchersList.add("SalRet:1");
		expVouchersList.add("84.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("96.00");
		expVouchersList.add("ExeStk:2");
		expVouchersList.add("96.00");
		expVouchersList.add("12.00");
		expVouchersList.add("");
		expVouchersList.add("108.00");
		expVouchersList.add("StkTrf:2");
		expVouchersList.add("108.00");
		expVouchersList.add("12.00");
		expVouchersList.add("12.00");
		expVouchersList.add("108.00");
		expVouchersList.add("NDT50:7");
		expVouchersList.add("108.00");
		expVouchersList.add("");
		expVouchersList.add("12.00");
		expVouchersList.add("96.00");
		expVouchersList.add("");
		expVouchersList.add("");
		expVouchersList.add("96.00");
		expVouchersList.add("36.00");
		expVouchersList.add("");
		
		System.out.println(actVouchersList);
		System.out.println(expVouchersList);
		
		for(int i=0; i<backTrackVouchersColumnsCount; i++)
		{
			String data = backTrackItemDetailsVouchersTableList.get(i).getText();
			
			if (data.equalsIgnoreCase("SalRet:1")) 
			{
				getAction().doubleClick(backTrackItemDetailsVouchersTableList.get(i)).build().perform();
			}
		}
		
		Thread.sleep(2000);
		
		ArrayList<String> openTabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		int actOpenWindowsCount = getDriver().getWindowHandles().size();
		int expOpenWindowsCount = 2;

	 	getDriver().switchTo().window(openTabs.get(1));
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(documentNumberTxt));
		String actDocNo=documentNumberTxt.getAttribute("value");
		String expDocNo="1";
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(customerAccountTxt));
		String actCustomer=customerAccountTxt.getAttribute("value");
		String expCustomer="Customer A";
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_1stColumn));
	 	String actWarehouse = select1stRow_1stColumn.getText();
	 	String expWarehouse = "HYDERABAD";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_2ndColumn));
	 	String actItem = select1stRow_2ndColumn.getText();
	 	String expItem = "STD RATE COGS ITEM";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_3rdColumn));
	 	String actSalesAccount = select1stRow_3rdColumn.getText();
	 	String expSalesAccount = "Sales - Computers";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_4thColumn));
	 	String actUnits = select1stRow_4thColumn.getText();
	 	String expUnits = "Pcs";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_6thColumn));
	 	String actQuantity = select1stRow_6thColumn.getText();
	 	String expQuantity = "12.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_7thColumn));
	 	String actLSalesInvoice = select1stRow_7thColumn.getText();
	 	String expLSalesInvoice = "NDT50:6";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_8thColumn));
	 	String actRate = select1stRow_8thColumn.getText();
	 	String expRate = "10.00";
	 	
	 	getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(select1stRow_9thColumn));
	 	String actGross = select1stRow_9thColumn.getText();
	 	String expGross = "120.00";
	 	
		System.out.println("**********************checkActualConsumptionReportBackTrackOption*********************");
		 
		System.out.println("Open Tabs        : "+actOpenWindowsCount         +"  Value Expected  "+expOpenWindowsCount);
		
		System.out.println("Document No      : "+actDocNo         +"  Value Expected  "+expDocNo);
		System.out.println("Customer Account : "+actCustomer      +"  Value Expected  "+expCustomer);
		System.out.println("Warehouse        : "+actWarehouse     +"  Value Expected  "+expWarehouse);
		System.out.println("Item             : "+actItem          +"  Value Expected  "+expItem);
		System.out.println("Sales Account    : "+actSalesAccount  +"  Value Expected  "+expSalesAccount);
		System.out.println("Units            : "+actUnits         +"  Value Expected  "+expUnits);
		System.out.println("Quantity         : "+actQuantity      +"  Value Expected  "+expQuantity);
		System.out.println("L Sales Order    : "+actLSalesInvoice +"  Value Expected  "+expLSalesInvoice);
		System.out.println("Rate             : "+actRate          +"  Value Expected  "+expRate);
		System.out.println("Gross            : "+actGross         +"  Value Expected  "+expGross);
		
		getDriver().switchTo().window(openTabs.get(1)).close();
		
		Thread.sleep(1000);
		
		getDriver().switchTo().window(openTabs.get(0));
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackItemDetailsBackBtn));
		BackTrackItemDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackMonthDetailsBackBtn));
		BackTrackMonthDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(BackTrackDateDetailsBackBtn));
		BackTrackDateDetailsBackBtn.click();
		
		Thread.sleep(1000);
		
		if (/*actMonthlyList.equals(expMonthlyList) && actDayList.equals(expDayList) && actVouchersList.equals(expVouchersList) &&*/ actOpenWindowsCount==expOpenWindowsCount
			   && actDocNo.equalsIgnoreCase(expDocNo) && actCustomer.equalsIgnoreCase(expCustomer) && actWarehouse.equalsIgnoreCase(expWarehouse)
			   && actItem.equalsIgnoreCase(expItem) && actSalesAccount.equalsIgnoreCase(expSalesAccount)
			   && actUnits.equalsIgnoreCase(expUnits) && actQuantity.equalsIgnoreCase(expQuantity) && actLSalesInvoice.equalsIgnoreCase(expLSalesInvoice)
			   && actRate.equalsIgnoreCase(expRate) && actGross.equalsIgnoreCase(expGross)) 
		{
			
			return true;
		}
		else
		{
			
			return false;
		}
	}
    
    
	@FindBy(xpath="//*[@id='Dashboard_ddlList']/li/a")
    private static WebElement labelDashboard ;
	
	@FindBy(xpath="//*[@class='icon-arrow hiconright']")
	public static WebElement userNameImageDisplay;
    
	public boolean checkLoginWithUserForItemRestriction() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(userNameDisplayLogo));
		 userNameDisplayLogo.click();
			
		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(logoutOption));
		 logoutOption.click();
		 
		 Thread.sleep(3000);
		 
		 String unamelt="UserForItemRestriction";
			
		 String pawslt="12345";
     
		 LoginPage.enterUserName(unamelt);
    
		 LoginPage.enterPassword(pawslt);
 
		 LoginPage.clickOnSignInBtn();  
       
		 Thread.sleep(5000);
		 
		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(labelDashboard));
		 String actDashboardLabel                = labelDashboard.getText();
		 String expDashboardLabel                = "Dashboard";	
		 
		if(actDashboardLabel.equalsIgnoreCase(expDashboardLabel))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean checkStockReportbyTagReportsWithUserForItemRestriction() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getDriver().navigate().refresh();
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockReportByTag));
		stockReportByTag.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_SelectAllItemsChkBox));
		sl_SelectAllItemsChkBox.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_1stRow1stCol));
	
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[FIFO COGS ITEM, FIFO COGS ITEM, 69.00, 0.82, 56.50, , , , , , , 69.00, 0.80, 55.25, , , , , , , , , ]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[BR COGS ITEM, BR COGS ITEM, 62.00, 0.69, 42.75, , , , , , , 62.00, 0.69, 42.75, , , , , , , , , ]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[Grand Total, , 131.00, 1.51, 99.25, , , , , , , 131.00, 1.49, 98.00, , , , , , , , , ]";
		
		System.out.println("************************checkStockReportbyTagReportsWithUserForItemRestriction********************************");
	
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(reportWithLevel_CloseBtn));
		reportWithLevel_CloseBtn.click();

		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CloseBtn));
		sl_CloseBtn.click();
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean checkLoginWithSU() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(userNameDisplayLogo));
		 userNameDisplayLogo.click();
		 Thread.sleep(2000);
			
		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(logoutOption));
		 logoutOption.click();
		 
		 Thread.sleep(3000);
		 
		 String unamelt="su";
			
		 String pawslt="su";
     
		 LoginPage.enterUserName(unamelt);
    
		 LoginPage.enterPassword(pawslt);
 
		 LoginPage.clickOnSignInBtn();  
       
		 Thread.sleep(5000);
		 
		 getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(labelDashboard));
		 boolean actDashboardLabel                = labelDashboard.isDisplayed();
		 boolean expDashboardLabel                = true;	
		 
		if(actDashboardLabel==expDashboardLabel)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@FindBy(xpath="//*[@id='cmbColumn']")
	public static WebElement ld_RefineLookinDropdown;

	@FindBy(xpath="//*[@id='SelectOperator']")
	public static WebElement ld_RefineOperatorDropdown;

	@FindBy(xpath="//*[@id='idDisplay']//option")
	public static List<WebElement> ld_RefineData;

	
////
	public boolean checkStockLedgerReportwithFilterOptionasRefineforVouchers() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		getDriver().navigate().refresh();
		Thread.sleep(2000);
		 
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockLedger));
		stockLedger.click();
		
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_SelectAllChkBox));
		sl_SelectAllChkBox.click();
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		Thread.sleep(2000);
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_SelectAllChkBox));
		sl_SelectAllChkBox.click();
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_FilterExpandBtn));
		sl_FilterExpandBtn.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_RefineBtn));
		sl_RefineBtn.click();
		Thread.sleep(1000);
		
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ld_RefineLookinDropdown));
		ld_RefineLookinDropdown.click();
		
		Select s2=new Select(ld_RefineLookinDropdown);
		s2.selectByValue("2");
		
		Thread.sleep(1000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(ld_RefineOperatorDropdown));
		ld_RefineOperatorDropdown.click();
		
		Select s3=new Select(ld_RefineOperatorDropdown);
		s3.selectByValue("0");
		Thread.sleep(2000);
				
		
		
		int reportsByWarehouseRow1ListCount = ld_RefineData.size();
		System.out.println(reportsByWarehouseRow1ListCount);
		
		ArrayList<String> reportsByWarehouseRow1ListArray = new ArrayList<String>();
		for(int i=0;i<reportsByWarehouseRow1ListCount;i++)
		{
			
			String data = ld_RefineData.get(i).getText();
			reportsByWarehouseRow1ListArray.add(data);
			
			
			
			
		}
		String actList = reportsByWarehouseRow1ListArray.toString();
		String expList = "[NDT57:SU/IND/TEXT2, ExeStk:2, StkTrf:2, NDT50:1, NDT50:7, Reserved stock, NDT57:SU/IND/TEXT4, NDT50:4]";
		
		System.out.println(actList);
		
		System.out.println(expList);
		
		if(actList.equalsIgnoreCase(expList))
		{
		return true;
		}
		else
		{
			return false;
		}
	}

	
	////
	
	
	


	
	
	
	

	

	
	

	
	

	
	
	

	

	
	public void LogoutandLoginwithSU() throws InterruptedException
	{
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(userNameDisplayLogo));
		userNameDisplayLogo.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(logoutOption));
		logoutOption.click();
		
		Thread.sleep(3000);
		
		 getDriver().navigate().refresh();
		 Thread.sleep(1999);
		 
		// getDriver().navigate().refresh();
		 //Thread.sleep(1999);

		LoginPage lp=new LoginPage(getDriver()); 

		String unamelt="su";
				      
		String pawslt="su";
				      
		LoginPage.enterUserName(unamelt);

		Thread.sleep(1000);
				
		LoginPage.enterPassword(pawslt);
	
		 Select oSelect = new Select(companyDropDownList);
		 //oSelect.selectByVisibleText(Compname); 
		 oSelect.selectByValue("36");
		
		 LoginPage.clickOnSignInBtn();
		 
		 Thread.sleep(2000);
		 LoginPage.reLogin("su", "su", "Automation Company");
		 
		
		 
		
		
	}
	
	
	
	
////Formatting Row in Stock Ledger///////////////
	
	
	@FindBy(xpath="//*[@class='icon-custamize hiconright2']")
	private static WebElement sl_CustomizeBtn1;
	
	
	@FindBy(xpath="//*[@id='FormattingbyRow']")
	private static WebElement sl_CustomizeFormattingRowBtn;
	
	@FindBy(xpath="//*[@id='rfNew']")
	private static WebElement sl_CustomizeFormattingRowNewBtn;
	
	@FindBy(xpath="//*[@id='rfdelete']")
	private static WebElement sl_CustomizeFormattingRowDeleteBtn;
	
	@FindBy(xpath="//*[@id='a']")
	private static WebElement sl_CustomizeFormattingRowFilterBtn;
	
	
	@FindBy(xpath="//*[@id='id_rc_rowformatting_1']")
	private static WebElement sl_CustomizeFormattingRowNew;
	
	@FindBy(xpath="//*[@id='551_10_AdvanceFilter_Customize']/table/tbody/tr/td[1]/select")
	private static WebElement sl_CustomizeFormattingRowConjunction;
	
	@FindBy(xpath="(//*[@placeholder='Select Field'])[2]")
	private static WebElement sl_CustomizeFormattingRowTextField;
	
	@FindBy(xpath="(//a[contains(text(),'Rate')])[1]")
	private static WebElement sl_CustomizeFormattingRowTextRateField;
	
	
	@FindBy(xpath="//*[@id='551_10_AdvanceFilter_Customize']/table/tbody/tr/td[3]/select")
	private static WebElement sl_CustomizeFormattingRowOperator;
	
	@FindBy(xpath="//*[@id='551_10_AdvanceFilter_Customize']/table/tbody/tr/td[4]/select")
	private static WebElement sl_CustomizeFormattingRowCompare;
	
	@FindBy(xpath="(//*[@placeholder='Value'])[2]")
	private static WebElement sl_CustomizeFormattingRowValueField;
	
	@FindBy(xpath="//*[@id='advancefilter_date_551_10_Customize_input_image']/span")
	private static WebElement sl_CustomizeFormattingRowValueCal;
	
	@FindBy(xpath="//select[@id='id_set_on_column']")
	private static WebElement sl_CustomizeFormattingRowSetonColumn;
	
	
	@FindBy(xpath="//input[@id='id_rf_font']")
	private static WebElement sl_CustomizeFormattingRowFontBtn;

	
	
	@FindBy(xpath="//select[@id='fontForeColor_id_rc_rowformatting_fontcontrol7']")
	private static WebElement sl_CustomizeFormattingRowForeColour;

	@FindBy(xpath="//select[@id='fontStyle_id_rc_rowformatting_fontcontrol7']")
	private static WebElement sl_CustomizeFormattingRowFontStyle;
	
	
	
	
	@FindBy(xpath="//select[@id='fontSizes_id_rc_rowformatting_fontcontrol7']")
	private static WebElement sl_CustomizeFormattingRowFontSize;
	
	@FindBy(xpath="//select[@id='fontWeight_id_rc_rowformatting_fontcontrol7']")
	private static WebElement sl_CustomizeFormattingRowFontWeight;
	
	@FindBy(xpath="//select[@id='fontBackColor_id_rc_rowformatting_fontcontrol7']")
	private static WebElement sl_CustomizeFormattingRowBackColor;
	
	
	
	@FindBy(xpath="//*[@id='chkBaseline_id_rc_rowformatting_fontcontrol7']/following-sibling::span")
	private static WebElement sl_CustomizeFormattingRowBaselineChkBox;
	
	@FindBy(xpath="//*[@id='chkOverLine_id_rc_rowformatting_fontcontrol7']/following-sibling::span")
	private static WebElement sl_CustomizeFormattingRowOverlineChkBox;
	
	
	
	@FindBy(xpath="//*[@id='chkStrikeThrough_id_rc_rowformatting_fontcontrol7']/following-sibling::span")
	private static WebElement sl_CustomizeFormattingRowStrikeThroughChkBox;
	
	
	@FindBy(xpath="//*[@id='chkUnderline_id_rc_rowformatting_fontcontrol7']/following-sibling::span")
	private static WebElement sl_CustomizeFormattingRowUnderlineChkBox;
	
	
	
	
	
	
	
	
	
	
	@FindBy(xpath="(//*[@id='id_customize_rearrange_Okbtn'])[1]")
	private static WebElement sl_CustomizeFormattingRowFontOkBtn;

	
	
	@FindBy(xpath="//*[@id='id_ApplyOnColumn']/following-sibling::span")
	private static WebElement sl_CustomizeFormattingRowApplyonColChkBox;
	
		
	@FindBy(xpath="//*[@id='rfok']")
	private static WebElement sl_CustomizeFormattingRowOkBtn;

	
	@FindBy(xpath="(//*[@class='icon-save hiconright2'])[1]")
	private static WebElement sl_CustomizationSaveBtn;
	
	
	public boolean checkStockLedgerReportwithCustomizationFormattingRow() throws InterruptedException
	{
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryMenu));
		inventoryMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(inventoryReportsMenu));
		inventoryReportsMenu.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(stockLedger));
		stockLedger.click();
		
		Thread.sleep(2000);
		
		int rowcount=stockLedgerHometableRowCount.size();
		
		System.out.println(rowcount);
		
		for (int i = 1; i <= rowcount; i++) 
		{
			String actName = stockLedgerHometableItemNamesList.get(i).getText();
			
			System.out.println(actName);
			
			if(actName.equalsIgnoreCase("WA COGS ITEM"))
			{
				stockLedgerHometableItemChkboxList.get(i).click();
				break;
			}
		}
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_DateOptionDropdown));
		Select s=new Select(sl_DateOptionDropdown);
		s.selectByIndex(1);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_OkBtn));
		sl_OkBtn.click();
		
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeBtn1));
		sl_CustomizeBtn1.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowBtn));
		sl_CustomizeFormattingRowBtn.click();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowNewBtn));
		sl_CustomizeFormattingRowNewBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowNew));
		sl_CustomizeFormattingRowNew.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowFilterBtn));
		sl_CustomizeFormattingRowFilterBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowConjunction));
		sl_CustomizeFormattingRowConjunction.click();
		Select s1=new Select(sl_CustomizeFormattingRowConjunction);
		s1.selectByValue("1");
		Thread.sleep(2000);
		sl_CustomizeFormattingRowConjunction.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowTextField));
		sl_CustomizeFormattingRowTextField.click();
		getAction().moveToElement(sl_CustomizeFormattingRowTextRateField).build().perform();
		//getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowTextRateField));
		sl_CustomizeFormattingRowTextRateField.click();
		/*sl_CustomizeFormattingRowTextField.clear();
		sl_CustomizeFormattingRowTextField.sendKeys("Rate");*/
		Thread.sleep(2000);
		//sl_CustomizeFormattingRowTextField.sendKeys(Keys.TAB);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowOperator));
		sl_CustomizeFormattingRowOperator.click();
		Select s2=new Select(sl_CustomizeFormattingRowOperator);
		s2.selectByValue("3");
		Thread.sleep(2000);
		//sl_CustomizeFormattingRowOperator.sendKeys(Keys.TAB);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowCompare));
		sl_CustomizeFormattingRowCompare.click();
		Select s3=new Select(sl_CustomizeFormattingRowCompare);
		s3.selectByValue("0");
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowCompare));
		sl_CustomizeFormattingRowCompare.click();
		sl_CustomizeFormattingRowCompare.sendKeys(Keys.TAB);
		
		
	
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowValueField));
		sl_CustomizeFormattingRowValueField.sendKeys("10.00");
		Thread.sleep(2000);
		sl_CustomizeFormattingRowValueField.sendKeys(Keys.TAB);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowSetonColumn));
		Select s4=new Select(sl_CustomizeFormattingRowSetonColumn);
		s4.selectByValue("4");
		Thread.sleep(2000);
		sl_CustomizeFormattingRowSetonColumn.sendKeys(Keys.TAB);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowFontBtn));
		sl_CustomizeFormattingRowFontBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowFontSize));
		
		sl_CustomizeFormattingRowFontSize.click();
		Select s10=new Select(sl_CustomizeFormattingRowFontSize);
		s10.selectByVisibleText("12.5");
		Thread.sleep(2000);
		/*sl_CustomizeFormattingRowFontSize.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		*/
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowFontStyle));
		sl_CustomizeFormattingRowFontStyle.click();
		Select s5=new Select(sl_CustomizeFormattingRowFontStyle);
		s5.selectByVisibleText("Oblique");
		Thread.sleep(2000);
		/*sl_CustomizeFormattingRowFontStyle.sendKeys(Keys.TAB);
		Thread.sleep(2000);*/
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowForeColour));
		sl_CustomizeFormattingRowForeColour.click();
		Select s6=new Select(sl_CustomizeFormattingRowForeColour);
		s6.selectByVisibleText("Brown");
		Thread.sleep(2000);
		/*sl_CustomizeFormattingRowForeColour.sendKeys(Keys.TAB);
		Thread.sleep(2000);*/
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowFontWeight));
		sl_CustomizeFormattingRowFontWeight.click();
		Select s7=new Select(sl_CustomizeFormattingRowFontWeight);
		s7.selectByVisibleText("Bold");
		Thread.sleep(2000);
		/*sl_CustomizeFormattingRowFontWeight.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		*/
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowBackColor));
		sl_CustomizeFormattingRowBackColor.click();
		Select s8=new Select(sl_CustomizeFormattingRowBackColor);
		s8.selectByVisibleText("Thistle");
		Thread.sleep(2000);
	/*	sl_CustomizeFormattingRowBackColor.sendKeys(Keys.TAB);
		*/
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowBaselineChkBox));
		sl_CustomizeFormattingRowBaselineChkBox.click();
	
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowOverlineChkBox));
		sl_CustomizeFormattingRowOverlineChkBox.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowStrikeThroughChkBox));
		sl_CustomizeFormattingRowStrikeThroughChkBox.click();
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowUnderlineChkBox));
		sl_CustomizeFormattingRowUnderlineChkBox.click();
		
		
		
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowFontOkBtn));
		sl_CustomizeFormattingRowFontOkBtn.click();
		Thread.sleep(2000);
		
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowApplyonColChkBox));
		sl_CustomizeFormattingRowApplyonColChkBox.click();
		Thread.sleep(2000);
		
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowOkBtn));
		sl_CustomizeFormattingRowOkBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizationSaveBtn));		
		sl_CustomizationSaveBtn.click();
		Thread.sleep(2000);		
				
		int reportsRow1ListCount = reportsRow1List.size();
		ArrayList<String> reportsRow1ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow1ListCount;i++)
		{
			String data = reportsRow1List.get(i).getText();
			reportsRow1ListArray.add(data);
		}
		String actRow1List = reportsRow1ListArray.toString();
		String expRow1List = "[WA COGS ITEM WA COGS ITEM]";
		
		

		int reportsRow2ListCount = reportsRow2List.size();
		ArrayList<String> reportsRow2ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow2ListCount;i++)
		{
			String data = reportsRow2List.get(i).getText();
			reportsRow2ListArray.add(data);
		}
		String actRow2List = reportsRow2ListArray.toString();
		String expRow2List = "[Opening Balance, 24.00, , , , 24.00, , , 84.00, 3.50, , , ]";
		
		
		
		int reportsRow3ListCount = reportsRow3List.size();
		ArrayList<String> reportsRow3ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow3ListCount;i++)
		{
			String data = reportsRow3List.get(i).getText();
			reportsRow3ListArray.add(data);
		}
		String actRow3List = reportsRow3ListArray.toString();
		String expRow3List = "[NDT57:SU/IND/TEXT5, 12.00, 10.50, , , 36.00, 126.00, , 210.00, 5.83, , , ]";
		
		
		
		int reportsRow4ListCount = reportsRow4List.size();
		ArrayList<String> reportsRow4ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow4ListCount;i++)
		{
			String data = reportsRow4List.get(i).getText();
			reportsRow4ListArray.add(data);
		}
		String actRow4List = reportsRow4ListArray.toString();
		String expRow4List = "[NDT57:SU/IND/TEXT5, 10.00, 10.50, , , 46.00, 105.00, , 315.00, 6.85, , , ]";
		
		
		
		int reportsRow5ListCount = reportsRow5List.size();
		ArrayList<String> reportsRow5ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow5ListCount;i++)
		{
			String data = reportsRow5List.get(i).getText();
			reportsRow5ListArray.add(data);
		}
		String actRow5List = reportsRow5ListArray.toString();
		String expRow5List = "[ExeStk:2, 10.00, 10.00, , , 56.00, 100.00, , 415.00, 7.41, , , ]";
		
		
		
		int reportsRow6ListCount = reportsRow6List.size();
		ArrayList<String> reportsRow6ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow6ListCount;i++)
		{
			String data = reportsRow6List.get(i).getText();
			reportsRow6ListArray.add(data);
		}
		String actRow6List = reportsRow6ListArray.toString();
		String expRow6List = "[StkTrf:2, , , 10.00, 7.41, 46.00, , 74.11, 340.89, 7.41, , , ]";
		
		
		
		int reportsRow7ListCount = reportsRow7List.size();
		ArrayList<String> reportsRow7ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow7ListCount;i++)
		{
			String data = reportsRow7List.get(i).getText();
			reportsRow7ListArray.add(data);
		}
		String actRow7List = reportsRow7ListArray.toString();
		String expRow7List = "[StkTrf:2, 10.00, 7.41, , , 56.00, 74.11, , 415.00, 7.41, , , ]";
		
		
		
		int reportsRow8ListCount = reportsRow8List.size();
		ArrayList<String> reportsRow8ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow8ListCount;i++)
		{
			String data = reportsRow8List.get(i).getText();
			reportsRow8ListArray.add(data);
		}
		String actRow8List = reportsRow8ListArray.toString();
		String expRow8List = "[NDT50:5, , , 3.00, 7.41, 53.00, , 22.23, 392.77, 7.41, , , ]";
		
		
		
		int reportsRow9ListCount = reportsRow9List.size();
		ArrayList<String> reportsRow9ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow9ListCount;i++)
		{
			String data = reportsRow9List.get(i).getText();
			reportsRow9ListArray.add(data);
		}
		String actRow9List = reportsRow9ListArray.toString();
		String expRow9List = "[NDT50:7, , , 10.00, 7.41, 43.00, , 74.11, 318.66, 7.41, , , ]";
		
		
		
		int reportsRow10ListCount = reportsRow10List.size();
		ArrayList<String> reportsRow10ListArray = new ArrayList<String>();
		for(int i=2;i<reportsRow10ListCount;i++)
		{
			String data = reportsRow10List.get(i).getText();
			reportsRow10ListArray.add(data);
		}
		String actRow10List = reportsRow10ListArray.toString();
		String expRow10List = "[Reserved stock, , , 43.00, , , , , , , , , ]";
		
		
		
		int reportsRow11ListCount = reportsRow11List.size();
		ArrayList<String> reportsRow11ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow11ListCount;i++)
		{
			String data = reportsRow11List.get(i).getText();
			reportsRow11ListArray.add(data);
		}
		String actRow11List = reportsRow11ListArray.toString();
		String expRow11List = "[Total, , 66.00, 38.41, 66.00, 22.23, , 405.11, 170.45, 318.66, 53.23, , , ]";
		
		
		
		/*int reportsRow12ListCount = reportsRow12List.size();
		ArrayList<String> reportsRow12ListArray = new ArrayList<String>();
		for(int i=1;i<reportsRow12ListCount;i++)
		{
			String data = reportsRow12List.get(i).getText();
			reportsRow12ListArray.add(data);
		}
		String actRow12List = reportsRow12ListArray.toString();
		String expRow12List = "[Grand Total, , 66.00, 38.41, 66.00, 22.23, , 405.11, 170.45, 318.66, 53.23, , , ]";
		
		*/
		
		
		System.out.println("************************************checkStockLedgerReport********************************************");
	
		System.out.println(actRow1List);
		System.out.println(expRow1List);
		
		System.out.println(actRow2List);
		System.out.println(expRow2List);
		
		System.out.println(actRow3List);
		System.out.println(expRow3List);
		
		System.out.println(actRow4List);
		System.out.println(expRow4List);
		
		System.out.println(actRow5List);
		System.out.println(expRow5List);
		
		System.out.println(actRow6List);
		System.out.println(expRow6List);
		
		System.out.println(actRow7List);
		System.out.println(expRow7List);
		
		System.out.println(actRow8List);
		System.out.println(expRow8List);
		
		System.out.println(actRow9List);
		System.out.println(expRow9List);
		
		System.out.println(actRow10List);
		System.out.println(expRow10List);
		
		System.out.println(actRow11List);
		System.out.println(expRow11List);
		
		/*System.out.println(actRow12List);
		System.out.println(expRow12List);*/
		
		
		if(actRow1List.equalsIgnoreCase(expRow1List) && actRow2List.equalsIgnoreCase(expRow2List) && actRow3List.equalsIgnoreCase(expRow3List) 
			&& actRow4List.equalsIgnoreCase(expRow4List) && actRow5List.equalsIgnoreCase(expRow5List) && actRow6List.equalsIgnoreCase(expRow6List) 
			&& actRow7List.equalsIgnoreCase(expRow7List) && actRow8List.equalsIgnoreCase(expRow8List) && actRow9List.equalsIgnoreCase(expRow9List) 
			&& actRow10List.equalsIgnoreCase(expRow10List) && actRow11List.equalsIgnoreCase(expRow11List) /*&& actRow12List.equalsIgnoreCase(expRow12List)*/)
		{
			return true;
		}
		else
		{
			return false;
		}
	
		
		
		
	}
	
	
	@FindBy(xpath="//table[@class='CommonReportTable']//tr//td[5]")
	public static List<WebElement> sl_RateColList;
	
	public boolean checkStockLedgerReportRateValuesAfterApplyingFormattingRow() throws InterruptedException
	{
		int reportsRateColListCount = sl_RateColList.size();
		ArrayList<String> reportsRateColListArray = new ArrayList<String>();
		
		//ArrayList<String> reportsRateColListArray1 = new ArrayList<String>();
		//String style;
		String[] s=null;
		
		for(int i=1;i<reportsRateColListCount;i++)
		{
			String data = sl_RateColList.get(i).getText();
			
			
			if(data.isEmpty()==false)
			{
				
				String style =sl_RateColList.get(i).getCssValue("color");
				
				String data1=Color.fromString(style).asHex();
				System.out.println("Actual foreColor:"+data1);
				
				
				String style1 =sl_RateColList.get(i).getCssValue("background-color");
				
				String data2=Color.fromString(style1).asHex();
				System.out.println("Actual Back ground Color:"+data2);
				
				reportsRateColListArray.add(data1);
				
				reportsRateColListArray.add(data2);
				
				
			}
			
		}	
			String actData  =reportsRateColListArray.toString();
			String expData  ="";
			
			System.out.println(" actData     :"+actData);
			System.out.println(" expData     :"+expData);
			
			
			
			
		/*	
			
		
			
			if(data.equalsIgnoreCase("10.50"))
			{
				style =sl_RateColList.get(i).getCssValue("color");
				
				String e=Color.fromString(style).asHex();
				System.out.println("dafhjdhfjdhfjdj:"+e);
				
			}
			
			
			if(data.equalsIgnoreCase("10.50"))
			{
				String style1 =sl_RateColList.get(i).getCssValue("background-color");
				
				String e=Color.fromString(style1).asHex();
				System.out.println("style atrrjkdjfkl:"+e);
				
			}
			
			
			if(data.isEmpty()==false)
			{
				 style =sl_RateColList.get(i).getAttribute("style");
				//System.err.println(style);
				s=style.split(";");
				for(int j=0;j<s.length;j++)
				{
				System.err.println(s[j]);
				}
				
			}
			
		}
			
		
		
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeBtn1));
		sl_CustomizeBtn1.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowBtn));
		sl_CustomizeFormattingRowBtn.click();
		Thread.sleep(2000);
		
		
	
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowNew));
		sl_CustomizeFormattingRowNew.click();
		Thread.sleep(2000);
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowFontBtn));
		sl_CustomizeFormattingRowFontBtn.click();
		Thread.sleep(2000);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowFontSize));
		Select s1=new Select(sl_CustomizeFormattingRowFontSize);
		String actFontSize=s1.getFirstSelectedOption().getText();
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowFontStyle));
		Select s5=new Select(sl_CustomizeFormattingRowFontStyle);
		String actFontStyle=s5.getFirstSelectedOption().getText();
		
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowForeColour));
		Select s6=new Select(sl_CustomizeFormattingRowForeColour);
		String actForeColour=s6.getFirstSelectedOption().getCssValue("color");
		
		//System.out.println(sl_CustomizeFormattingRowForeColour.getCssValue("Brown"));
		
		
		String c = Color.fromString(actForeColour).asHex();
		
		System.out.println("colorsadhgsdjshdjshdj  : "+c);
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowFontWeight));
		
		Select s7=new Select(sl_CustomizeFormattingRowFontWeight);
		String actFontWeight=s7.getFirstSelectedOption().getText();
		
		
		getFluentWebDriverWait().until(ExpectedConditions.elementToBeClickable(sl_CustomizeFormattingRowBackColor));
		
		Select s8=new Select(sl_CustomizeFormattingRowBackColor);
		String actBackColour=s8.getFirstSelectedOption().getCssValue("background-color");
		
		String D = Color.fromString(actBackColour).asHex();
		
		System.out.println("colorsadhgsdjshdjshdj  : "+D);
		
		
		
		
		System.err.println(actFontSize);
		System.err.println(actFontStyle);
		System.err.println(actForeColour);
		System.err.println(actFontWeight);
		System.err.println(actBackColour);*/
	
		
		return true;
		}
	
	
	
	

	
	
	



	
	
	
	

	
	
				
			

	public InventoryReportsXPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


}