package com.focus.testcases;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.focus.Pages.FinancilaReportsXPage;
import com.focus.Pages.FinancilaReportsXPage;
import com.focus.Pages.FinancilaReportsXPage;

/*import com.focus.Pages.Focus10InventoryReportsPage;*/

import com.focus.base.BaseEngine;

public class FinancialReportsXTest extends BaseEngine{
	
	FinancilaReportsXPage FRP;
	

	 @Test(priority=1500)
		
		public void checkLoginTOAutomationCompany() throws InterruptedException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkLoginTOAutomationCompany(),true);
		}
	

	 //Ledger
	
	 @Test(priority=1501)
		private void checkFinancialLedgerReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFinancialLedgerReport(), true);
		}
	 
	 @Test(priority=1502)
		private void checkLedgerReportWithAllCheckBoxesEnable() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkLedgerReportWithAllCheckBoxesEnable(), true);
		}
	 
	  @Test(priority=1503)
		private void checkFinancialLedgerReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFinancialLedgerReportBackTrackOption(), true);
		}

	
	//Ledger Details
	 
	 
	 @Test(priority=1504)
			private void checkFinancialLedgerDetailsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkFinancialLedgerDetailsReport(), true);
			}
		 		 
		 @Test(priority=1505)
			private void checkLedgerDetailreportWithAllCheckBoxesEnable() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkLedgerDetailreportWithAllCheckBoxesEnable(), true);
			}
				  
		 @Test(priority=1506)
			private void checkFinancialLedgerDetailsReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkFinancialLedgerDetailsReportBackTrackOption(), true);
			}
		 
		 
			@Test(priority=1507)
			public void checkLedgerDetailReportPrintOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkLedgerDetailReportPrintOption(), true);
			}
	
	
	 
	//SubLedger 
	 
		 @Test(priority=1508)
			private void checkFinancialSubLedgerReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkFinancialSubLedgerReport(), true);
			}
		 
		 
		 @Test(priority=1509)
			private void checkCustomizationInSubLedgerReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkCustomizationInSubLedgerReport(), true);
			}
		 
		 
		 @Test(priority=1510)
			private void checkFinancialSubLedgerReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkFinancialSubLedgerReportBackTrackOption(), true);
			}
	
		
	
	 
	//Cash And Bank Book 
	 
		 @Test(priority=1511)
			private void checkCashBookReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkCashBookReport(), true);
			}
	 
		
	
	 
	 @Test(priority=1512)
		private void checkBankBookReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBankBookReport(), true);
		}

	
	 @Test(priority=1513)
		private void checkBankBookReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBankBookReportBackTrackOption(), true);
		}
	 
	 @Test(priority=1514)
		private void checkPrintOptionInBankReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPrintOptionInBankReport(), true);
		}
	
	 
	
	 
	 
	 @Test(priority=1515)
		private void checkPettyCashBookReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPettyCashBookReport(), true);
		}

	
	
	 
	 @Test(priority=1516)
		private void checkDayBookReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkDayBookReport(), true);
		}


	
	 
	 @Test(priority=1517)
		private void checkVirtualBankLedgerBookReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVirtualBankLedgerBookReport(), true);
		}

		 @Test(priority=1518)
		private void  checkVirtualBankLedgerPrintOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVirtualBankLedgerPrintOption(), true);
		}
	
		 
	
	 @Test(priority=1519)
			private void checkBankReconciliationReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkBankReconciliationReport(),true);
			}
	 
	 @Test(priority=1520)
		public void checkBankReconciliationImportOptions() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBankReconciliationImportOptions(), true);
		}
		
	 
	 
		 
		 @Test(priority=1521)
			private void checkCustomerReconciliationReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkCustomerVendorReconciliationReport(),true);
			}
	
		 
		 @Test(priority=1522)
			private void checkBankReconcilationStatementReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkBankReconcilationStatementReport(),true);
			}
		 
		 
		
		 
		 @Test(priority=1523)
			private void checkBankReconciliationStatementReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkBankReconciliationStatementReportBackTrackOption(),true);
			}
		 
		 
		 @Test(priority=1524)
			public void checkPrintOptionBankReconciliationStatementReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkPrintOptionBankReconciliationStatementReport(), true);
			}
			
		 
		 @Test(priority=1525)
			public void checkChequeDiscountingReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkChequeDiscountingReport(), true);
			}
			
	
	

	
	
	 
	 
	
	 //Sales Report
	 
	 @Test(priority=1526)
		private void checkSalesRegisterReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSalesRegisterReports(), true);
		}

	
	
	 @Test(priority=1527)//check it 
		private void checkSalesRegisterReportFilterOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSalesRegisterReportWithFilterOption(), true);
		}
	 
	
	
		 
	 @Test(priority=1528)
		private void checkSalesRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSalesRegisterReportBackTrackOption(), true);
		}
	 

	 
	 
	 @Test(priority=1529)
		private void checkSalesReturnRegisterReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSalesReturnsRegisterReports(), true);
		}

	
	 @Test(priority=1530)
		private void checkSalesReturnRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSalesReturnRegisterReportBackTrackOption(), true);
		}
	 
	
	
	 @Test(priority=1531)
		private void  checkSalesReturnRegisterPrintOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSalesReturnRegisterPrintOption(), true);
		}
	
		 
	
	
	 
	 
	 @Test(priority=1532)
		private void checkSummarySalesBookReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSummarySalesBookReports(), true);
		}

	
	
	
	
	
		 
	 @Test(priority=1533)
		private void checkSummarySalesBookReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSummarySalesBookReportBackTrackOption(), true);
		}
	 
	
	 
		@Test(priority=1534)
		public void checkPrintOptionSummarySalesBookReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPrintOptionSummarySalesBookReport(), true);
		}
			
		
		
	 
	 @Test(priority=1535)
		private void checkMonthlySalesBookReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkMonthlySalesBookReports(), true);
		}

	

	
	 
	 
	 @Test(priority=1536)
		private void checkTopCustomersListReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTopCustomersListReports(), true);
		}

	
	
		
		@Test(priority=1537)
		public void checkPrintOptionTopCustomerListReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPrintOptionTopCustomerListReport(), true);
		}
	
 
	//Purchase Report 
	 
	 @Test(priority=1538)
		private void checkPurchaseRegisterReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPurchaseRegisterReports(), true);
		}

	
		 
	 @Test(priority=1539)
			private void checkPurchaseRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkPurchaseRegisterReportBackTrackOption(), true);
			}
	@Test(priority=1540)
		private void  checkPurchaseRegisterPrintOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPurchaseRegisterPrintOption(), true);
		}
	
	
	 @Test(priority=1541)//no data
		private void checkPurchaseReturnRegisterReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPurchaseReturnRegisterReports(), true);
		}

	 
	 
	 @Test(priority=1542)
		private void checkSummaryPurchaseBookReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSummaryPurchaseBookReports(), true);
		}

	 @Test(priority=1543)
		private void checkSummaryPurchaseBookReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSummaryPurchaseBookReportBackTrackOption(), true);
		}
	 
	 @Test(priority=1544)
		public void checkPrintOptionSummaryPurchaseBookReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
		 FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPrintOptionSummaryPurchaseBookReport(), true);
		}
	
	
	
	
	 
	//VAT 
	 
	 @Test(priority=1545)
		private void checkVATPurchaseAccountReports() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVATPurchaseAccountReports(), true);
		}

	
	
	 @Test(priority=1546)
		public void checkCustomizeOptionInVatPurchaseAccountReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
		 FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomizeOptionInVatPurchaseAccountReport(), true);
		}
	 
				 
	 @Test(priority=1547)
		private void checkPurchaseAccountReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPurchaseAccountReportBackTrackOption(), true);
		}
	 
	

	 
	 
	 
	 @Test(priority=1548)
		private void checkVATDetailedReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVATDetailedReport(), true);
		}

	
	
	
	 @Test(priority=1549)
		private void checkVATDetailedReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVATDetailedReportBackTrackOption(), true);
		}
	 
	
	
	
	
	 
	 
	 @Test(priority=1550)
		private void checkVATSalesAccountReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVATSalesAccountReport(), true);
		}

	
	
	
				 
	 @Test(priority=1551)
		private void checkVATSalesAccountReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVATSalesAccountReportBackTrackOption(), true);
		}
	 

	
	
	 
	 
	 
	 @Test(priority=1552)
		private void checkVATSalesByCustomerReportwithVocherTypeSaleseandDelearsType() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVATSalesByCustomerReportwithVocherTypeSalesandDelearsType(), true);
		}

	
	
	 @Test(priority=1553)
		public void checkVatSummaryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
		 FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVatSummaryReport(), true);
		}
		
		
		
		
		
		@Test(priority=1554)
		public void checkVatAuditFileReportOptions() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVatAuditFileReportOptions(), true);
		}
		
		
		
		@Test(priority=1555)
		public void checkVatReturnReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVatReturnReport(), true);
		}
		
		
	 
	 
	 
	 @Test(priority=1556)
		private void checkSalesAdvanceVATReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSalesAdavanceVATReport(), true);
		}

	

				 
	 @Test(priority=1557)
		private void checkSalesAdvanceVATReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSalesAdvanceVATReportBackTrackOption(), true);
		}
	

	 
//Register Menu
	 
	 @Test(priority=1558)
		private void checkOpeningBalanceRegisterReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkOpeningBalanceRegisterReport(), true);
		}

 
	@Test(priority=1559)
		private void checkOpeningBalanceRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkOpeningBalanceRegisterReportBackTrackOption(), true);
		}
	 
	
	 
	 @Test(priority=1560)
		private void checkJournalEntriesRegisterReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkJournalEntriesRegisterReport(), true);
		}

	@Test(priority=1561)
		private void checkJournalEntriesRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkJournalEntriesRegisterReportBackTrackOption(), true);
		}
	
	
	 
	 @Test(priority=1562)
		private void checkCreditNoteRegisterReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCreditNoteRegisterReport(), true);
		}


	@Test(priority=1563)
		private void checkCreditNoteRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCreditNoteRegisterReportBackTrackOption(), true);
		}
	 
	
	
	
	 @Test(priority=1564)
		private void checkDebitNoteRegisterReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkDebitNoteRegisterReport(), true);
		}

	
	
	@Test(priority=1565)
		private void checkDebitNoteRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkDebitNoteRegisterReportBackTrackOption(), true);
		}
	
	 @Test(priority=1566)
		private void checkReceiptRegisterReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkReceiptRegisterReport(), true);
		}

	
	@Test(priority=1567)
		private void checkReceiptRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkReceiptRegisterReportBackTrackOption(), true);
		}
	
	
	
	 @Test(priority=1568)
		private void checkPaymentRegisterReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPaymentRegisterReport(), true);
		}

	
	
	
	 
				 
	@Test(priority=1569)
		private void checkPaymentRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPaymentRegisterReportBackTrackOption(), true);
		}
		
	
	 
	 @Test(priority=1570)
		private void checkPDCReceiptsRegisterReportwithAllIncludePDC() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPDCReceiptsRegisterReportwithAllIncludePDC(), true);
		}
	 
	
				 
	@Test(priority=1571)
		private void checkPDCReceiptsRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPDCReceiptsRegisterReportBackTrackOption(), true);
		}
	
	 @Test(priority=1572)
		private void checkPDCPaymentRegisterReportwithAllIncludePDC() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPDCPaymentRegisterReportwithAllIncludePDC(), true);
		}
	 
	
				 
	 @Test(priority=1573)
		private void checkPDCPaymentRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPDCPaymentRegisterReportBackTrackOption(), true);
		}

	 @Test(priority=1574)
		private void checkEntryJournalRegisterReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkEntryJournalRegisterReport(), true);
		}
	 
	
				 
	@Test(priority=1575)
		private void checkEntryJournalRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkEntryJournalRegisterReportBackTrackOption(), true);
		}
	
	 
	 @Test(priority=1576)
		private void checkEntryJournalDetailReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkEntryJournalDetailReport(), true);
		}
	 
	
	 
				 
	@Test(priority=1577)
		private void checkEntryJournalDetailsReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkEntryJournalDetailsReportBackTrackOption(), true);
		}
		
		
	
	
	//Sales And Purchases Analysis 
	 
	 
	 @Test(priority=1578)
		private void checkSalesGroupedByCustomerReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSalesGroupedByCustomerReport(), true);
		}

	@Test(priority=1579)
		private void checkSalesGroupedByCustomersReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSalesGroupedByCustomerReportBackTrackOption(), true);
		}
	

	 @Test(priority=1580)
		private void checkSalesGroupedByItemReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSalesGroupedByItemReport(), true);
		}
	 
	
	 @Test(priority=1581)
		private void checkSalesGroupedByDepartmentReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSalesGroupedByDepartmentReport(), true);
		}
	
	 @Test(priority=1582)
		private void checkPurchasesGroupedByVendorReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPurchasesGroupedByVendorReport(), true);
		}
	 
	
				 
	@Test(priority=1583)
		private void checkPurchasesGroupedByVendorsReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPurchasesGroupedByVendorReportBackTrackOption(), true);
		}

	 @Test(priority=1584)
		private void checkPurchasesGroupedByItemReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPurchasesGroupedByItemReport(), true);
		}
	 
	
	 @Test(priority=1585)
		private void checkPurchasesGroupedByDepartmentReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPurchasesGroupedByDepartmentReport(), true);
		}
	 
	 @Test(priority=1586)
		public void checkCustomisationOptionINPurchasesGroupedByDepartmentReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
		 FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomisationOptionINPurchasesGroupedByDepartmentReport(), true);
		}
		


	 
	//Miscellaneous Analysis 
	 
	 @Test(priority=1587)
		private void checkPeakAndLowBalancesAmountReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPeakAndLowBalancesAmountReport(), true);
		}
	 
	
			 
	@Test(priority=1588)
		private void checkPeakAndLowBalancesReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPeakAndLowBalancesReportBackTrackOption(), true);
		}
	
	
	 
 
	
	 @Test(priority=1589)
			private void checkComparitiveAnalysisReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkComparitiveAnalysisReport(), true);
			}
		 
		
					 
		@Test(priority=1590)
			private void checkComparitiveAnalysisReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkComparitiveAnalysisReportBackTrackOption(), true);
			}
		
		
	 
	 
	 @Test(priority=1591)
		private void checkTransactionsTypeAnalysisReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTransactionsTypeAnalysisReport(), true);
		}
	 

				 
	@Test(priority=1592)
		private void checkTransactionsTypeAnalysisReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTransactionsTypeAnalysisReportBackTrackOption(), true);
		}
	
	
		 
	
	 @Test(priority=1593)
		private void checkABCAnalysiswithReportBasedonBalance() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkABCAnalysiswithReportBasedonBalance(), true);
		}
		
		@Test(priority=1594)
		public void checkSortingOptionInAbcAnalysisReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSortingOptionInAbcAnalysisReport(), true);
		}
	 
	
				 
	@Test(priority=1595)
		private void checkABCAnalysisReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkABCAnalysisReportBackTrackOption(), true);
		}
	
	
		 
	 
	 
	 
	 @Test(priority=1596)
		private void checkInterestCalculationReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkInterestCalculationReport(), true);
		}
	
	 
				 
	@Test(priority=1597)
		private void checkInterestCalculationReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkInterestCalculationReportBackTrackOption(), true);
		}
	
	
	
	//Master Information
	
	
	@Test(priority=1598)
	public void checkMastersInformationMenuReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{
		FRP=new FinancilaReportsXPage(getDriver());
		Assert.assertEquals(FRP.checkMastersInformationMenuReport(), true);
	}

	
	
	@Test(priority=1599)
	public void checkProductLabelReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{
		FRP=new FinancilaReportsXPage(getDriver());
		Assert.assertEquals(FRP.checkProductLabelReport(), true);
	}
	
	
	
	
	@Test(priority=1600)
	public void checkUnitConversionReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{
		FRP=new FinancilaReportsXPage(getDriver());
		Assert.assertEquals(FRP.checkUnitConversionReport(), true);
	}
	
	
	
	
	@Test(priority=1601)
	public void checkSkidDefinitionReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{
		FRP=new FinancilaReportsXPage(getDriver());
		Assert.assertEquals(FRP.checkSkidDefinitionReport(), true);
	}
	

	
	 
	 //Audit Trail
	 
	 @Test(priority=1602)
		private void checkAuditTrailTransactionsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkAuditTrailTransactionsReport(), true);
		}
	
	
	 @Test(priority=1603)
		private void checkAuditTrailLoginsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkAuditTrailLoginsReport(), true);
		}
	 
	
	
	
	 //Account Query
	 
	 @Test(priority=1604)
		private void checkAccountQueryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkAccountQueryReport(),true);
		}
	 
	
	 
	//Transaction Authorization Report 
	 
	 @Test(priority=1605)
		private void checkTransactionAuthorizationReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTransactionAuthorizationReport(), true);
		}
	 
	//Master Authorization
	 
	 @Test(priority=1606)
		public void checkMasterAuthorizationReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
		 FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkMasterAuthorizationReport(), true);
		}
		
	
	
///////////////////////////Final Accounts//////////////////////////////
	 

		@Test(priority=1607)
		public void checkTrailBalanceReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTrailBalanceReport(), true);
		}
		
		@Test(priority=1608)
		public void checkTrailBalanceReportPrintOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTrailBalanceReportPrintOption(), true);
		}
		
		@Test(priority=1609)
		public void checkBackTrackInTrailBalance() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBackTrackInTrailBalance(), true);
		}
		
		
		
		
		
		
		@Test(priority=1610)
		public void checkProfitAndLossReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkProfitAndLossReport(), true);
		}
		
		@Test(priority=1611)
		public void checkProfitAndLossPrintOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkProfitAndLossPrintOption(), true);
		}

		@Test(priority=1612)
		public void checkBackTrackInProfitAndLossReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBackTrackInProfitAndLossReport(), true);
		}
		
		
		
		
		
		@Test(priority=1613)
		public void checkTradingAccountOptions() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTradingAccountOptions(), true);
		}
		
		@Test(priority=1614)
		public void checkBackTrackInTradingAccount() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBackTrackInTradingAccount(), true);
		}
		
		
		
		
		
		@Test(priority=1615)
		public void checkTradingAndProfitAndLossReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTradingAndProfitAndLossReport(), true);
		}
		
		@Test(priority=1616)
		public void checkPrintOptionInTradingAndProfitAndLossReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkPrintOptionInTradingAndProfitAndLossReport(), true);
		}
		
		@Test(priority=1617)
		public void checkBackTrackInTradingAndProfitAndLoss() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBackTrackInTradingAndProfitAndLoss(), true);
		}
		
		
		
		
		
		@Test(priority=1618)
		public void checkBalanceSheetOptions() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBalanceSheetOptions(), true);
		}
		
		@Test(priority=1619)
		public void checkCustomizationAndPrintOptionInBalanceSheetReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomizationAndPrintOptionInBalanceSheetReport(), true);
		}
		
		@Test(priority=1620)
		public void checkBackTrackInBalanceSheet() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBackTrackInBalanceSheet(), true);
		}
		
		
		
		
		
		@Test(priority=1621)//Expected 
		public void checkFinalAccountsSchedulesReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFinalAccountsSchedulesReport(), true);
		}
		
		@Test(priority=1622)
		public void checkCustomizationAndPrintOptionInFinalAccSchedule() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomizationAndPrintOptionInFinalAccSchedule(), true);
		}
		
		@Test(priority=1623)
		public void checkBackTrackInSchedules() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBackTrackInSchedules(), true);
		}
		
		
		
		
		
		@Test(priority=1624)
		public void checkFundFlowReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFundFlowReport(), true);
		}
		
		@Test(priority=1625)
		public void checkCustomizationAndPrintOptionInunfFlowReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomizationAndPrintOptionInunfFlowReport(), true);
		}
		
		@Test(priority=1626)
		public void checkBackTrackInFundFlow() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBackTrackInFundFlow(), true);
		}
		
		
		
		

		@Test(priority=1627)
		public void checkCashFlowReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCashFlowReport(), true);
		}
		
		@Test(priority=1628)
		public void checkCustomizationAndPrintOptionInCashFlowReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomizationAndPrintOptionInCashFlowReport(), true);
		}
		
		
		
		
		
	    @Test(priority=1629)
		public void checkCashFLowAnalysisReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCashFLowAnalysisReport(), true);
		}
		@Test(priority=1630)
		public void checkCustomizationAndPrintOptionInCashFlowAnalysis() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomizationAndPrintOptionInCashFlowAnalysis(), true);
		}
		
		@Test(priority=1631)
		public void checkBackTrackInCashFlowAnalysis() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBackTrackInCashFlowAnalysis(), true);
		}
		
		
		
		
		
		@Test(priority=1632)
		public void checkAdvanceCashFLowReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkAdvanceCashFLowReport(), true);
		}
		
		
		
		
		
		//@Test(priority=1633)// not there
		public void checkBudgetPlanningReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBudgetPlanningReport(), true);
		}
		
		
		
		
		
		@Test(priority=1634)
		public void checkIncomeExpenseTrendReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkIncomeExpenseTrendReport(), true);
		}
		
		
		
		
		
		@Test(priority=1635)
		public void checkReceavibleAndPayableReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkReceavibleAndPayableReport(), true);
		}
		
		@Test(priority=1636)
		public void checkCustomizationAndPrintOptionInRecevibleAndPayableReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomizationAndPrintOptionInRecevibleAndPayableReport(), true);
		}
		
		@Test(priority=1637)
		public void checkBackTrackInReceavibleAndPayable() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBackTrackInReceavibleAndPayable(), true);
		}
		
		
		
		
		
		// Receivable and Payable Analysis Reports Starts from Here
		
		@Test(priority=1638)
		public void checkCustomerListingOfOutstandingBillsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerListingOfOutstandingBillsReport(), true);
		}
		
		///@Test(priority=1639)
		public void CheckFilterAndPrintOptionnInCustomerListingOfOutstandingBillsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckFilterAndPrintOptionnInCustomerListingOfOutstandingBillsReport(), true);
		}
		
		@Test(priority=1640)
		public void CheckCustomerListingOfOutstandingBillsReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckCustomerListingOfOutstandingBillsReportBackTrackOption(), true);
		}
		
		
		
		
		
		
		@Test(priority=1641)
		public void checkCustomerStatementReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerStatementReport(), true);
		}
		
		@Test(priority=1642)
		public void CheckFilterAndPrintOptionnInCustomerStatements() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckFilterAndPrintOptionnInCustomerStatements(), true);
		}
		
		@Test(priority=1643)
		public void checkCustomerStatementReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerStatementReportBackTrackOption(), true);
		}
		
		
		
		
		
		@Test(priority=1644)
		public void checkCustomerDueDateAnalysisReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerDueDateAnalysisReport(), true);
		}
		
		@Test(priority=1645)
		public void CheckFilterAndPrintOptionnInCustomerDueDateAnalysis() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckFilterAndPrintOptionnInCustomerDueDateAnalysis(), true);
		}
		
		@Test(priority=1646)
		public void checkCustomerDueDateAnalysisBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerDueDateAnalysisBackTrackOption(), true);
		}
		
		
		
		
		
		@Test(priority=1647)
		public void checkCustomerAgeingDetailsAnalysisReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerAgeingDetailsAnalysisReport(), true);
		}
		
		@Test(priority=1648)
		public void CheckFilterAndPrintOptionnInCustomerAgeingDetailsAnalysis() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckFilterAndPrintOptionnInCustomerAgeingDetailsAnalysis(), true);
		}
		
		@Test(priority=1649)
		public void CheckCustomerAgeingDetailsAnalysisBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckCustomerAgeingDetailsAnalysisBackTrackOption(), true);
		}
		
		
		
		
		
		@Test(priority=1650)
		public void checkCustomerAgeingDetailsByDueDateReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerAgeingDetailsByDueDateReport(), true);
		}
		
		@Test(priority=1651)
		public void CheckFilterAndPrintOptionnInCustomerAgeingDetailsDueDate() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckFilterAndPrintOptionnInCustomerAgeingDetailsDueDate(), true);
		}
		
		@Test(priority=1652)
		public void CheckCustomerAgeingDetailsDueDateBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckCustomerAgeingDetailsDueDateBackTrackOption(), true);
		}


		
		
		
		@Test(priority=1653)
		public void checkCustomerOverDueAnalysisReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerOverDueAnalysisReport(), true);
		}
		
		@Test(priority=1654)
		public void CheckFilterAndPrintOptionnInCustomerOverDueAnalysis() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckFilterAndPrintOptionnInCustomerOverDueAnalysis(), true);
		}
		
		@Test(priority=1655)
		public void CheckCustomerOverDueAnalysisBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckCustomerOverDueAnalysisBackTrackOption(), true);
		}
			
		
		
		
		
		@Test(priority=1656)
		public void checkcustomerSummaryCustomerAgeingSummaryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkcustomerSummaryCustomerAgeingSummaryReport(), true);
		}
		
		@Test(priority=1657)
		public void CheckPrintAndCustomiseOptionnIncustomerSummaryCustomerAgeingSummaryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnIncustomerSummaryCustomerAgeingSummaryReport(), true);
		}
		
		@Test(priority=1658)
		public void checkCustomerSummaryCustomerAgeingSummaryReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerSummaryCustomerAgeingSummaryReportBackTrackOption(), true);
		}
		
		
		
		
		
		@Test(priority=1659)
		public void checkcustomerSummaryAgeingByDueDateReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkcustomerSummaryAgeingByDueDateReport(), true);
		}
		
		@Test(priority=1660)
		public void CheckPrintAndCustomiseOptionnIncustomerSummaryAgeingByDueDateReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnIncustomerSummaryAgeingByDueDateReport(), true);
		}
		
		@Test(priority=1661)
		public void checkCustomerSummaryAgeingByDueDateReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerSummaryAgeingByDueDateReportBackTrackOption(), true);
		}
		
		
		
		
			
		@Test(priority=1662)
		public void checkcustomerSummaryCustomerOverDueSummeryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkcustomerSummaryCustomerOverDueSummeryReport(), true);
		}
		
		@Test(priority=1663)
		public void CheckPrintAndCustomiseOptionnIncustomerSummaryCustomerOverDueSummeryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnIncustomerSummaryCustomerOverDueSummeryReport(), true);
		}
		
		@Test(priority=1664)
		public void checkCustomerSummaryCustomerOverDueSummeryReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerSummaryCustomerOverDueSummeryReportBackTrackOption(), true);
		}
		
		
		
		
		@Test(priority=1665)
		public void checkcustomerSummaryCustomerBillWiseSummeryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkcustomerSummaryCustomerBillWiseSummeryReport(), true);
		}
		
		@Test(priority=1666)
		public void CheckPrintAndCustomiseOptionnIncustomerSummaryCustomerBillWiseSummeryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnIncustomerSummaryCustomerBillWiseSummeryReport(), true);
		}
		
		@Test(priority=1667)
		public void checkCustomerSummaryCustomerBillWiseSummeryReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerSummaryCustomerBillWiseSummeryReportBackTrackOption(), true);
		}
		
		
		
		
		
		
		//Vendor Details 
		
		@Test(priority=1668)
		public void checkVendorListingOfOutstandingBillsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, ParseException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorListingOfOutstandingBillsReport(), true);
		}
		
		@Test(priority=1669)
		public void CheckPrintAndCustomiseOptionnInVendorListingOfOutstandingBillsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnInVendorListingOfOutstandingBillsReport(), true);
		}
		
		@Test(priority=1670)
		public void checkFilterOptionInVendorListingOfOutstandingBillsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, ParseException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFilterOptionInVendorListingOfOutstandingBillsReport(), true);
		}
		
		@Test(priority=1671)
		public void checkVendorListingOfOutstandingBillsReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorListingOfOutstandingBillsReportBackTrackOption(), true);
		}
		
		
		
		
		
		
		@Test(priority=1672)
		public void checkvendorDetailsVendorStatementsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, ParseException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkvendorDetailsVendorStatementsReport(), true);
		}

		@Test(priority=1673)
		public void CheckPrintAndCustomiseOptionnInvendorDetailsVendorStatementsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnInvendorDetailsVendorStatementsReport(), true);
		}
		
		@Test(priority=1674)
		public void checkVendorDetailsVendorStatementsReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorDetailsVendorStatementsReportBackTrackOption(), true);
		}
		
		
		
		
		@Test(priority=1675)
		public void checkvendorDetailsVendorDueDateAnalysisReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, ParseException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkvendorDetailsVendorDueDateAnalysisReport(), true);
		}
		
		@Test(priority=1676)
		public void CheckPrintAndCustomiseOptionnInvendorDetailsVendorDueDateAnalysisReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnInvendorDetailsVendorDueDateAnalysisReport(), true);
		}
		
		@Test(priority=1677)
		public void checkVendorDetailsVendorDueDateAnalysisReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorDetailsVendorDueDateAnalysisReportBackTrackOption(), true);
		}
		
		
		
		
		@Test(priority=1678)
		public void checkVendorDetailsVendorAgeingDetailsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, ParseException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorDetailsVendorAgeingDetailsReport(), true);
		}
		
		@Test(priority=1679)
		public void CheckPrintAndCustomiseOptionnInVendorDetailsVendorAgeingDetailsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnInVendorDetailsVendorAgeingDetailsReport(), true);
		}
		
		@Test(priority=1680)
		public void checkVendorDetailsVendorAgeingReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorDetailsVendorAgeingReportBackTrackOption(), true);
		}
		
		
		
		@Test(priority=1681)
		public void checkVendorDetailsVendorDetailsAgeingByDueDateReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, ParseException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorDetailsVendorDetailsAgeingByDueDateReport(), true);
		}
		
		@Test(priority=1682)
		public void CheckPrintAndCustomiseOptionnInvendorDetailsVendorDetailsAgeingByDueDateReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnInvendorDetailsVendorDetailsAgeingByDueDateReport(), true);
		}
		
		@Test(priority=1683)
		public void checkVendorDetailsAgeingByDueDateReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorDetailsAgeingByDueDateReportBackTrackOption(), true);
		}
		
		
		

		
		@Test(priority=1684)
		public void checkVendorDetailsVendorOverdueAnalysisReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, ParseException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorDetailsVendorOverdueAnalysisReport(), true);
		}
		
		
		@Test(priority=1685)
		public void CheckPrintAndCustomiseOptionnInVendorDetailsVendorOverdueAnalysisReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnInVendorDetailsVendorOverdueAnalysisReport(), true);
		}
		
		
		@Test(priority=1686)
		public void checkVendorOverdueAnalysisReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorOverdueAnalysisReportBackTrackOption(), true);
		}
		
		
		
		
		@Test(priority=1687)
		public void checkVendorSummeryVendorAgeingSummaryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorSummeryVendorAgeingSummaryReport(), true);
		}
		
		@Test(priority=1688)
		public void CheckPrintAndCustomiseOptionnInVendorSummeryVendorAgeingSummaryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnInVendorSummeryVendorAgeingSummaryReport(), true);
		}
		
		@Test(priority=1689)
		public void checkSummeryVendorAgeingSummaryReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkSummeryVendorAgeingSummaryReportBackTrackOption(), true);
		}
		
		
		
		
		@Test(priority=1690)
		public void checkVendorSummeryVendorSummaryAgeingByDueDateReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorSummeryVendorSummaryAgeingByDueDateReport(), true);
		}
		
		@Test(priority=1691)
		public void CheckPrintAndCustomiseOptionnInVendorSummeryVendorSummaryAgeingByDueDateReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnInVendorSummeryVendorSummaryAgeingByDueDateReport(), true);
		}
		
		@Test(priority=1692)
		public void checkVendorSummeryVendorSummaryAgeingByDueDateReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorSummeryVendorSummaryAgeingByDueDateReportBackTrackOption(), true);
		}
		
		
		
		
		@Test(priority=1693)
		public void checkVendorSummeryVendorOverdueSummaryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorSummeryVendorOverdueSummaryReport(), true);
		}
		
		@Test(priority=1694)
		public void CheckPrintAndCustomiseOptionnInVendorSummeryVendorOverdueSummaryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnInVendorSummeryVendorOverdueSummaryReport(), true);
		}
		
		@Test(priority=1695)
		public void checkVendorVendorSummeryVendorOverdueSummaryReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorVendorSummeryVendorOverdueSummaryReportBackTrackOption(), true);
		}
		
		
		
		
		@Test(priority=1696)
		public void checkVendorSummeryVendorBillWiseSummaryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorSummeryVendorBillWiseSummaryReport(), true);
		}
		
		@Test(priority=1697)
		public void CheckPrintAndCustomiseOptionnInVendorSummeryVendorBillwiseSummaryReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.CheckPrintAndCustomiseOptionnInVendorSummeryVendorBillwiseSummaryReport(), true);
		}
		

		@Test(priority=1698)
		public void checkVendorSummeryVendorBillwiseSummaryReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVendorSummeryVendorBillwiseSummaryReportBackTrackOption(), true);
		}


	 /*
	 
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		//Trail Balance
		
		@Test(priority=1699)
		public void checkTrailBalanceReportwithFilterOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTrailBalanceReportwithFilterOption(), true);
		}
		
		
		
		@Test(priority=1701)
		public void checkTrailBalanceExportPDFOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTrailBalanceExportPDFOption(), true);
		}
		
		@Test(priority=1700)
		public void checkTrailBalanceExportExcelSheetOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTrailBalanceExportExcelSheetOption(), true);
		}
		
		
		@Test(priority=1702)
		public void checkTrailBalanceAnalyzeOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTrailBalanceAnalyzeOption(), true);
		}
		
		
		@Test(priority=1703)
		public void checkTrailBalanceAnalyzeReportExportExcelOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTrailBalanceAnalyzeReportExportExcelOption(), true);
		}
		
		
		@Test(priority=1704)
		public void checkTrailBalanceAnalyzeReportExportPDFOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTrailBalanceAnalyzeReportExportPDFOption(), true);
		}
		
		
		//@Test(priority=1705)
		public void checkTrailBalanceAnalyzeReportExportCSVOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTrailBalanceAnalyzeReportExportCSVOption(), true);
		}
		
		@Test(priority=1706)
		public void checkTrailBalanceAnalyzeReportPrintOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTrailBalanceAnalyzeReportPrintOption(), true);
		}
		
		
		
		@Test(priority=1707)
		public void checkTrailBalanceAnalyzeReportSaveOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkTrailBalanceAnalyzeReportSaveOption(), true);
		}
		
		 @Test(priority=1708)
			public void checkTrailBalanceAnalyzeOptionwithoutFilter() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkTrailBalanceAnalyzeOptionwithoutFilter(), true);
			}
		
	
		
		//Trail Balance at User Level
		
		 @Test(priority=1709)
		 public void checkLoginWithUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
		 {
			 FRP=new FinancilaReportsXPage(getDriver());
			 Assert.assertEquals(FRP.checkLoginWithUserAllOptionsST(), true);
		 }
		 
		 @Test(priority=1710)
		 public void checkTrailBalanceReportwithFilterOptionWithUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
		 {
			 FRP=new FinancilaReportsXPage(getDriver());
			 Assert.assertEquals(FRP.checkTrailBalanceReportwithFilterOptionWithUserAllOptionsST(), true);
		 }
		 
		 @Test(priority=1711)
			public void checkTrailBalanceAnalyzeOptionWithUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkTrailBalanceAnalyzeOptionWithUserAllOptionsST(), true);
			}
			
			
			@Test(priority=1712)
			public void checkTrailBalanceAnalyzeReportExportExcelOptionWithUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkTrailBalanceAnalyzeReportExportExcelOptionWithUserAllOptionsST(), true);
			}
			
			
			@Test(priority=1713)
			public void checkTrailBalanceAnalyzeReportExportPDFOptionWithUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkTrailBalanceAnalyzeReportExportPDFOptionWithUserAllOptionsST(), true);
			}
			
			
			@Test(priority=1714)
			public void checkTrailBalanceAnalyzeReportPrintOptionWithUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkTrailBalanceAnalyzeReportPrintOptionWithUserAllOptionsST(), true);
			}
			
			
			
			@Test(priority=1715)
			public void checkTrailBalanceAnalyzeReportSaveOptionWithUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkTrailBalanceAnalyzeReportSaveOptionWithUserAllOptionsST(), true);
			}
			
			@Test(priority=1716)
			public void checkSavedReportatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkSavedReportatUserAllOptionsST(), true);
			}
		 
		 
		
		 @Test(priority=1717)
		 public void checkLoginWithSU() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
		 {
			 FRP=new FinancilaReportsXPage(getDriver());
			 Assert.assertEquals(FRP.checkLoginWithSU(), true);
		 }
		
		///Profit and Loss
		
		@Test(priority=1718)
		public void checkProfitAndLossReportwithFilterOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkProfitAndLossReportwithFilterOption(), true);
		}
		
		
		
		
		@Test(priority=1719)
		public void checkProfitLossAnalyzeOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkProfitLossAnalyzeOption(), true);
		}
		
		
		@Test(priority=1720)
		public void checkProfitLossAnalyzeReportExportExcelOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkProfitLossAnalyzeReportExportExcelOption(), true);
		}
		
		
		@Test(priority=1721)
		public void checkProfitLossAnalyzeReportExportPDFOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkProfitLossAnalyzeReportExportPDFOption(), true);
		}
		
		
//		@Test(priority=1722)
		public void checkProfitLossAnalyzeReportExportCSVOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkProfitLossAnalyzeReportExportCSVOption(), true);
		}
		
		@Test(priority=1723)
		public void checkProfitLossAnalyzeReportPrintOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkProfitLossAnalyzeReportPrintOption(), true);
		}
		
		
		@Test(priority=1724)
		public void checkProfitLossAnalyzeReportSaveOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkProfitLossAnalyzeReportSaveOption(), true);
		}
		
		@Test(priority=1725)
		public void checkProfitLossReportwithtakingfilterOptionasNotEqualTo() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkProfitLossReportwithtakingfilterOptionasNotEqualTo(), true);
		}
		
		 
		 
		//Balance Sheet
		
		
		
		 @Test(priority=1726)
		public void checkBalanceSheetReportwithFilterOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkBalanceSheetReportwithFilterOption(), true);
		}
		
		 
		 @Test(priority=1727)
			public void checkBalanceSheetAnalyzeOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkBalanceSheetAnalyzeOption(), true);
			}
			
			
			@Test(priority=1728)
			public void checkBalanceSheetAnalyzeReportExportExcelOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkBalanceSheetAnalyzeReportExportExcelOption(), true);
			}
			
			
			@Test(priority=1729)
			public void checkBalanceSheetAnalyzeReportExportPDFOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkBalanceSheetAnalyzeReportExportPDFOption(), true);
			}
			
			
			
			@Test(priority=1730)
			public void checkBalanceSheetAnalyzeReportPrintOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkBalanceSheetAnalyzeReportPrintOption(), true);
			}
			
			
			@Test(priority=1731)
			public void checkBalanceSheetAnalyzeReportSaveOption() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkBalanceSheetAnalyzeReportSaveOption(), true);
			}
			
			
			
		 //Customer Summary
		 
		 @Test(priority=1732)
			public void checkCustomerAgeingSummaryReportwithFilterOptionincludeMontlyAgeingChkBox() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkCustomerAgeingSummaryReportwithFilterOptionincludeMontlyAgeingChkBox(), true);
			}
		 
		 
		 @Test(priority=1733)
			public void checkCustomerAgeingSummaryReportwithFilterOptionasAccountWithoutIncludeMothlyAgeingChkBox() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkCustomerAgeingSummaryReportwithFilterOptionasAccountWithoutIncludeMothlyAgeingChkBox(), true);
			}
		 
		 
		 
		 
		 
		 @Test(priority=1734)
			public void checkCustomerSummaryByDueDatewithFilterOptionincludeMonthlyAgeingChkBox() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkCustomerSummaryByDueDatewithFilterOptionincludeMonthlyAgeingChkBox(), true);
			}
		 
		 //Customer Summary at User Level
		 
		 @Test(priority=1735)
		 public void checkLoginWithUserAllOptionsSTforCustomer() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
		 {
			 FRP=new FinancilaReportsXPage(getDriver());
			 Assert.assertEquals(FRP.checkLoginWithUserAllOptionsST(), true);
		 }
		 
		 @Test(priority=1736)
			public void checkCustomerAgeingSummaryReportwithFilterOptionincludeMontlyAgeingChkBoxWithUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkCustomerAgeingSummaryReportwithFilterOptionincludeMontlyAgeingChkBox(), true);
			}
		 
		 
		 @Test(priority=1737)
			public void checkCustomerAgeingSummaryReportwithFilterOptionasAccountWithoutIncludeMothlyAgeingChkBoxWithUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkCustomerAgeingSummaryReportwithFilterOptionasAccountWithoutIncludeMothlyAgeingChkBoxWithUserAllOptionsST(), true);
			}
		  
		 
		 
		 @Test(priority=1738)
			public void checkCustomerSummaryByDueDatewithFilterOptionincludeMonthlyAgeingChkBoxWithUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkCustomerSummaryByDueDatewithFilterOptionincludeMonthlyAgeingChkBoxWithUserAllOptionsST(), true);
			}
		 
		 
		 
		 ///customer statement adding levels at customization
		 
		 
		
		
		 @Test(priority=1739)
		public void checkCustomerStatementHeaderFieldsBeforeCustomization() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
		{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkCustomerStatementHeaderFieldsBeforeCustomization(), true);
		}
	 
		
		
		 @Test(priority=1740)
			public void checkCustomerStatementwithCustomizationLevelFieldsReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkCustomerStatementwithCustomizationLevelFieldsReport(), true);
			}
		 
		 
		 @Test(priority=1741)
			public void checkAddingLevelFieldsunderCustomization() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkAddingLevelFieldsunderCustomization(), true);
			}
		
		 
		 
		 @Test(priority=1742)
			public void checkCustomerStatementHeaderDetailsAfterCustomization() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkCustomerStatementHeaderDetailsAfterCustomization(), true);
			}

		//Balance sheet and Profit/Loss at UserLevel
		 
		 @Test(priority=1743)
			public void checkProfitAndLossReportwithFilterOptionatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkProfitAndLossReportwithFilterOption(), true);
			}
			
			
			
			
			@Test(priority=1744)
			public void checkProfitLossAnalyzeOptionatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkProfitLossAnalyzeOption(), true);
			}
			
			
			@Test(priority=1745)
			public void checkProfitLossAnalyzeReportExportExcelOptionatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkProfitLossAnalyzeReportExportExcelOption(), true);
			}
			
			
			@Test(priority=1746)
			public void checkProfitLossAnalyzeReportExportPDFOptionatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkProfitLossAnalyzeReportExportPDFOption(), true);
			}
			
			
//		
			@Test(priority=1747)
			public void checkProfitLossAnalyzeReportPrintOptionatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkProfitLossAnalyzeReportPrintOption(), true);
			}
			
			
			@Test(priority=1748)
			public void checkProfitLossAnalyzeReportSaveOptionatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkProfitLossAnalyzeReportSaveOption(), true);
			}
			
			@Test(priority=1749)
			public void checkProfitLossReportwithtakingfilterOptionasNotEqualToatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkProfitLossReportwithtakingfilterOptionasNotEqualTo(), true);
			}
			
			 
			 
			//Balance Sheet
			
			
			
			 @Test(priority=1750)
			public void checkBalanceSheetReportwithFilterOptionatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
				FRP=new FinancilaReportsXPage(getDriver());
				Assert.assertEquals(FRP.checkBalanceSheetReportwithFilterOption(), true);
			}
			
			 
			 @Test(priority=1751)
				public void checkBalanceSheetAnalyzeOptionatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkBalanceSheetAnalyzeOption(), true);
				}
				
				
				@Test(priority=1752)
				public void checkBalanceSheetAnalyzeReportExportExcelOptionatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkBalanceSheetAnalyzeReportExportExcelOption(), true);
				}
				
				
				@Test(priority=1753)
				public void checkBalanceSheetAnalyzeReportExportPDFOptionatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkBalanceSheetAnalyzeReportExportPDFOption(), true);
				}
				
				
				
				@Test(priority=1754)
				public void checkBalanceSheetAnalyzeReportPrintOptionatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkBalanceSheetAnalyzeReportPrintOption(), true);
				}
				
				
				@Test(priority=1755)
				public void checkBalanceSheetAnalyzeReportSaveOptionatUserAllOptionsST() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkBalanceSheetAnalyzeReportSaveOption(), true);
				}

		 ///////Checking Date Range Options in Financial Reports
				
				
				 @Test(priority=1757)
				 public void checkLoginWithSUAgain() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
				 {
					 FRP=new FinancilaReportsXPage(getDriver());
					 Assert.assertEquals(FRP.checkLoginWithSU(), true);
				 }
				
				
				@Test(priority=1760)
				public void checkFinanacialLedgerReportwithDateRangeasCurrentMonth() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkFinanacialLedgerReportwithDateRangeasCurrentMonth(), true);
				}
				
				@Test(priority=1761)
				public void checkFinanacialLedgerReportwithDateRangeasPreviousMonth() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkFinanacialLedgerReportwithDateRangeasPreviousMonth(), true);
				}
				
				@Test(priority=1762)
				public void checkFinanacialLedgerReportwithDateRangeasCurrentWeek() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkFinanacialLedgerReportwithDateRangeasCurrentWeek(), true);
				}
				
				@Test(priority=1763)
				public void checkFinanacialLedgerReportwithDateRangeasPreviousWeek() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkFinanacialLedgerReportwithDateRangeasPreviousWeek(), true);
				}
		
				
				@Test(priority=1764)
				public void checkFinanacialLedgerReportwithDateRangeasToday() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkFinanacialLedgerReportwithDateRangeasToday(), true);
				}
				
				
				@Test(priority=1765)
				public void checkFinanacialLedgerReportwithDateRangeasCurrentYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkFinanacialLedgerReportwithDateRangeasCurrentYear(), true);
				}
				
				@Test(priority=1766)
				public void checkFinanacialLedgerReportwithDateRangeasPreviousYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkFinanacialLedgerReportwithDateRangeasPreviousYear(), true);
				}
		
				@Test(priority=1767)
				public void checkFinanacialLedgerReportwithDateRangeasCurrentFinancialYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkFinanacialLedgerReportwithDateRangeasCurrentFinancialYear(), true);
				}
				
				@Test(priority=1768)
				public void checkFinanacialLedgerReportwithDateRangeasYesterDay() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkFinanacialLedgerReportwithDateRangeasYesterDay(), true);
				}
				
				
				
				@Test(priority=1769)
				public void checkFinanacialLedgerReportwithDateRangeasCurrentQuarterYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkFinanacialLedgerReportwithDateRangeasCurrentQuarterYear(), true);
				}
				
				@Test(priority=1770)
				public void checkFinanacialLedgerReportwithDateRangeasPreviousQuarterYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkFinanacialLedgerReportwithDateRangeasPreviousQuarterYear(), true);
				}

				
		//Trail Balance		
				
				@Test(priority=1771)
				public void checkTrailBalanceReportwithDateRangeasCurrentMonth() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkTrailBalanceReportwithDateRangeasCurrentMonth(), true);
				}

				@Test(priority=1772)
				public void checkTrailBalanceReportwithDateRangeasPreviousMonth() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkTrailBalanceReportwithDateRangeasPreviousMonth(), true);
				}

				@Test(priority=1773)
				public void checkTrailBalanceReportwithDateRangeasCurrentWeek() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkTrailBalanceReportwithDateRangeasCurrentWeek(), true);
				}

				@Test(priority=1774)
				public void checkTrailBalanceReportwithDateRangeasPreviousWeek() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkTrailBalanceReportwithDateRangeasPreviousWeek(), true);
				}

				@Test(priority=1775)
				public void checkTrailBalanceReportwithDateRangeasToday() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkTrailBalanceReportwithDateRangeasToday(), true);
				}

				@Test(priority=1776)
				public void checkTrailBalanceReportwithDateRangeasCurrentYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkTrailBalanceReportwithDateRangeasCurrentYear(), true);
				}

				@Test(priority=1777)
				public void checkTrailBalanceReportwithDateRangeasPreviousYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkTrailBalanceReportwithDateRangeasPreviousYear(), true);
				}

				@Test(priority=1778)
				public void checkTrailBalanceReportwithDateRangeasCurrentFinancialYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkTrailBalanceReportwithDateRangeasCurrentFinancialYear(), true);
				}

				
				
				
				@Test(priority=1779)
				public void checkTrailBalanceReportwithDateRangeasYesterDay() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkTrailBalanceReportwithDateRangeasYesterDay(), true);
				}

				
				
				@Test(priority=1780)
				public void checkTrailBalanceReportwithDateRangeasCurrentQuarterYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkTrailBalanceReportwithDateRangeasCurrentQuarterYear(), true);
				}

				
				@Test(priority=1781)
				public void checkTrailBalanceReportwithDateRangeasPreviousQuarterYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkTrailBalanceReportwithDateRangeasPreviousQuarterYear(), true);
				}

		//Customer statement		
				
				
				@Test(priority=1782)
				public void checkCustomerStatementReportDateRangeasCurrentMonth() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkCustomerStatementReportDateRangeasCurrentMonth(), true);
				}
				
				@Test(priority=1783)
				public void checkCustomerStatementReportDateRangeasPreviousMonth() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkCustomerStatementReportDateRangeasPreviousMonth(), true);
				}
				@Test(priority=1784)
				public void checkCustomerStatementReportDateRangeasCurrentWeek() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkCustomerStatementReportDateRangeasCurrentWeek(), true);
				}
				@Test(priority=1785)
				public void checkCustomerStatementReportDateRangeasPreviousWeek() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkCustomerStatementReportDateRangeasPreviousWeek(), true);
				}
				@Test(priority=1786)
				public void checkCustomerStatementReportDateRangeasToday() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkCustomerStatementReportDateRangeasToday(), true);
				}
				@Test(priority=1787)
				public void checkCustomerStatementReportDateRangeasCurrentYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkCustomerStatementReportDateRangeasCurrentYear(), true);
				}
				@Test(priority=1788)
				public void checkCustomerStatementReportDateRangeasPreviousYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkCustomerStatementReportDateRangeasPreviousYear(), true);
				}
				@Test(priority=1789)
				public void checkCustomerStatementReportDateRangeasCurrentFinancialYear() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkCustomerStatementReportDateRangeasCurrentFinancialYear(), true);
				}
				
				@Test(priority=1790)
				public void checkCustomerStatementReportDateRangeasYesterDay() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkCustomerStatementReportDateRangeasYesterDay(), true);
				}
				
				
				@Test(priority=1791)
				public void checkCustomerStatementReportDateRangeasCurrentQuarter() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkCustomerStatementReportDateRangeasCurrentQuarter(), true);
				}
				
				
				@Test(priority=1792)
				public void checkCustomerStatementReportDateRangeasPreviousQuarter() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
				{
					FRP=new FinancilaReportsXPage(getDriver());
					Assert.assertEquals(FRP.checkCustomerStatementReportDateRangeasPreviousQuarter(), true);
				}
				
			
	 
/////////////////////Checking all checkboxes in Ledger/////////////////	
		
		
			@Test(priority=1793)
			public void checkFinancialLedgerWithMovedAccountOnlyChkBox() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFinancialLedgerWithMovedAccountOnlyChkBox(), true);
			}
			
			
			@Test(priority=1794)
			public void checkFinancialLedgerWithPrintAccountIndexChkBox() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFinancialLedgerWithPrintAccountIndexChkBox(), true);
			}
			
			
			@Test(priority=1795)//getting error
			public void checkFinancialLedgerFreshPageforEachAccountChkBox() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFinancialLedgerFreshPageforEachAccountChkBox(), true);
			}
			
			@Test(priority=1796)
			public void checkFinancialLedgerPrintasStatementofAccountChkBox() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFinancialLedgerPrintasStatementofAccountChkBox(), true);
			}
			
			
			
			@Test(priority=1798)
			public void checkFinancialLedgerDisplayUnrelizedProfitLossChkBox() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFinancialLedgerDisplayUnrelizedProfitLossChkBox(), true);
			}
			
			
			
			
			@Test(priority=1799)
			public void checkFinancialLedgerIgnoreConvertedPDCChkBox() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFinancialLedgerIgnoreConvertedPDCChkBox(), true);
			}
			
			
			
			
			@Test(priority=1800)
			public void checkFinancialLedgerDisplayMaturedPDCChkBox() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFinancialLedgerDisplayMaturedPDCChkBox(), true);
			}
			
			
		////////////////////Info Btn in Ledger////////////
			
			

			@Test(priority=1801)
			public void checkFinancialLedgerReportforInfoBtnatHomePage() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFinancialLedgerReportforInfoBtnatHomePage(), true);
			}
			
			
			@Test(priority=1802)
			public void checkFinancialLedgerReportforInfoBtnatEntryPage() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkFinancialLedgerReportforInfoBtnatEntryPage(), true);
			}
			

			
			
			@Test(priority=1803)
			public void checkVoucherHeaderDetailsByDoubleClickinLedgerReport() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, AWTException
			{
			FRP=new FinancilaReportsXPage(getDriver());
			Assert.assertEquals(FRP.checkVoucherHeaderDetailsByDoubleClickinLedgerReport(), true);
			}
			*/
}




