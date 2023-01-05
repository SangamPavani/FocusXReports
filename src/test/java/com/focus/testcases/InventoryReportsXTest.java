package com.focus.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.focus.Pages.InventoryReportsXPage;
import com.focus.base.BaseEngine;

public class InventoryReportsXTest extends BaseEngine {
	
	static InventoryReportsXPage IRP;
	
	
@Test(priority=501)
	
	public void checkLoginTOAutomationCompany() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		IRP=new InventoryReportsXPage(getDriver());
		Assert.assertEquals(IRP.checkLoginTOAutomationCompany(),true);
	}


//Item Query
	
	@Test(priority=502)
	public void checkItemQueryReport() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		IRP=new InventoryReportsXPage(getDriver());
		Assert.assertEquals(IRP.checkItemQueryReport(),true);
	}
	
	
//Stock Ledger
	 @Test(priority=503)
	 public void checkStockLedgerReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockLedgerReport(), true);
	 }
	
	
	 @Test(priority=504)
	 public void checkStockLedgerCustomizationReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockLedgerCustomizationReport(), true);
	 }
	 
	 @Test(priority=505)
	 public void checkStockLedgerReportWithMovedItemsOnlyAndIncludeServiceTypeItemsCheckBoxs() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockLedgerReportWithMovedItemsOnlyAndIncludeServiceTypeItemsCheckBoxs(), true);
	 }
	
	 @Test(priority=506)
	 public void checkStockLedgerReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockLedgerReportBackTrackOption(), true);
	 }

	
	
	

	 
	@Test(priority=507)
	 public void checkOpeningStockRegisterReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkOpeningStockRegisterReport(), true);
	 }
	 

	 @Test(priority=508)
	 public void checkOpeningStockRegisterReportFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkOpeningStockRegisterReportFilterOption(), true);
	 } 
	
	 @Test(priority=509)
	 public void checkOpeningStockRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkOpeningStockRegisterReportBackTrackOption(), true);
	 }
	 
	

	
	
	 
	 @Test(priority=510)
	 public void checkStockStatementReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockStatementReport(), true);
	 } 
	 
	
	 @Test(priority=511)
	 public void checkStockStatementReportPrintOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockStatementReportPrintOption(), true);
	 } 
	 
	@Test(priority=512)
	 public void checkStockStatementReportWithIncludeServiceTypeItem() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockStatementReportWithIncludeServiceTypeItem(), true);
	 } 
	 
	 
	 
	
	
	
	
	 
	@Test(priority=513)
	 public void checkStockMovementReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockMovementReports(), true);
	 } 
	 
	 @Test(priority=514)//stock Movement Dropdown Missing
	 public void checkStockMovementReportsWithStockMovementByWarehouseAndIncludeServiceTypeItemOptions() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockMovementReportsWithStockMovementByWarehouseAndIncludeServiceTypeItemOptions(), true);
	 } 
	 
	@Test(priority=515)
	 public void checkStockMovementReportWithFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockMovementReportWithFilterOption(), true);
	 } 
	 
	 @Test(priority=516)
	 public void checkStockMovementReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockMovementReportBackTrackOption(), true);
	 } 
	 
	 


	
	 
	@Test(priority=517)
	 public void checkMultiLevelStockMovementReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 
		 Assert.assertEquals(IRP.checkMultiLevelStockMovementReports(), true);
	 } 
	
	@Test(priority=518) // Filter option is not working as expected
	 public void checkMultiLevelStockMovementReportFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkMultiLevelStockMovementReportFilterOption(), true);
	 } 
	 
	 @Test(priority=519)
	 public void checkMultiLevelStockMovementReportWithIncludeServiceTypeItemOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkMultiLevelStockMovementReportWithIncludeServiceTypeItemOption(), true);
	 } 
	     
	 @Test(priority=520)
	 public void checkMultiLevelStockMovementReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkMultiLevelStockMovementReportBackTrackOption(), true);
	 } 
	 
	
	 
	
	 @Test(priority=521)
	 public void checkVirtualStockAnalysisReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkVirtualStockAnalysisReports(), true);
	 } 
	 
	 @Test(priority=522)
	 public void checkVirtualStockAnalysisReportWithIncludeServiceTypeItemOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkVirtualStockAnalysisReportWithIncludeServiceTypeItemOption(), true);
	 } 
	 
	
	 @Test(priority=523)
	 public void checkVirtualStockAnalysisReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkVirtualStockAnalysisReportBackTrackOption(), true);
	 }
	 
	 
	 
	
	 	 
	 
	@Test(priority=524)
	 public void checkStockValuationReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockValuationReports(), true);
	 }
	 
	@Test(priority=525)
	 public void checkStockValuationCustomizationReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockValuationCustomizationReport(), true);
	 }
	
	 
	 @Test(priority=526)
	 public void checkStockValuationReportWithStockValuationDisplayLinearReportIncludeServiceTypeItemOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockValuationReportWithStockValuationDisplayLinearReportIncludeServiceTypeItemOption(), true);
	 }
	
	 @Test(priority=527)
	 public void checkStockValuationReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockValuationReportBackTrackOption(), true);
	 }
	 
	 
	
	
	
	
	 @Test(priority=528)
	 public void checkStockReportbyTagReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockReportbyTagReports(), true);
	 }
	 
	 @Test(priority=529)
	 public void checkStockReportbyTagReportPrintOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockReportbyTagReportPrintOption(), true);
	 }
	 
	 @Test(priority=530)
	 public void checkStockReportbyTagReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockReportbyTagReportBackTrackOption(), true);
	 }
	 
	 
	 
	
	 
	 
	 
	 @Test(priority=531)
	 public void checkABCAnalysisReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkABCAnalysisReports(), true);
	 }
	 
	 @Test(priority=532)
	 public void checkABCAnalysisReportWithClassificationAndCriteriaOptions() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkABCAnalysisReportWithClassificationAndCriteriaOptions(), true);
	 }
	 
	 
	
	 
	
	
	 @Test(priority=533)
	 public void checkStockAnalysisByBatchReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockAnalysisByBatchReport(), true);
	 }
	 
	 @Test(priority=534)
	 public void checkStockAnalysisByBatchReportFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockAnalysisByBatchReportFilterOption(), true);
	 }
	 
		 
	 @Test(priority=535)
	 public void checkStockAnalysisByBatchReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockAnalysisByBatchReportBackTrackOption(), true);
	 }
	 
	 @Test(priority=536)
		 public void checkStockAnalysisByBatchReportWithStockTypeExpiredBatches() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
		 {
			 IRP=new InventoryReportsXPage(getDriver());
			 Assert.assertEquals(IRP.checkStockAnalysisByBatchReportWithStockTypeExpiredBatches(), true);
		 }
	 
	

	
	
	 
	 @Test(priority=537)
	 public void checkStockAnalysisByRmaReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockAnalysisByRmaReports(), true);
	 }
	 
	 @Test(priority=538)
	 public void checkStockAnalysisByRmaReportsPrintOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockAnalysisByRmaReportsPrintOption(), true);
	 }
	 
	
	

	
	@Test(priority=539)
	 public void checkStockDetailsByBinsReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockDetailsByBinsReports(), true);
	 }
	 
	 @Test(priority=540)
	 public void checkStockDetailsByBinsReportFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockDetailsByBinsReportFilterOption(), true);
	 }
	 
	 
	 @Test(priority=541)
	 public void checkStockDetailsByBinsReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockDetailsByBinsReportBackTrackOption(), true);
	 }
	
	
	
	
	 
	 
	 @Test(priority=542)
	 public void checkStockBalanaceByBinsReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockBalanaceByBinsReports(), true);
	 }
	 
	@Test(priority=543)
	 public void checkStockBalanaceByBinsReportFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockBalanaceByBinsReportFilterOption(), true);
	 }
	 
	 
	 @Test(priority=544)
	 public void checkStockBalanaceByBinsReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockBalanaceByBinsReportBackTrackOption(), true);
	 }
	
	
	 
	
	
	 
	 
	 @Test(priority=545)
	 public void checkStockBalancesByItemByBinsReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockBalancesByItemByBinsReports(), true);
	 }
	 
	 @Test(priority=546)
	 public void checkStockBalancesByItemByBinsReportPrintOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockBalancesByItemByBinsReportPrintOption(), true);
	 }
	 
	 
	 
	 
	
	 
	 
	 @Test(priority=547)
	 public void checkExpiredStockByBinsReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkExpiredStockByBinsReports(), true);
	 }
	 
	 @Test(priority=548)
	 public void checkExpiredStockByBinsReportCustomizationOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkExpiredStockByBinsReportCustomizationOption(), true);
	 }
	 
	 
	
	 
	 
	 
	 @Test(priority=549)
	 public void checkStockBalanceByWarehouseReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockBalanceByWarehouseReports(), true);
	 }
	 
	 @Test(priority=550)
	 public void checkStockBalanceByWarehouseReportIncludeServiceTypeItemOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockBalanceByWarehouseReportIncludeServiceTypeItemOption(), true);
	 }
	 
	 @Test(priority=551)
	 public void checkStockBalanceByWarehouseReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockBalanceByWarehouseReportBackTrackOption(), true);
	 }
	 
	 
	
	 
	 
	
	 @Test(priority=552)
	 public void checkStockAgeingAnalysisReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockAgeingAnalysisReports(), true);
	 }
	 
	 @Test(priority=553)
	 public void checkStockAgeingAnalysisReportFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockAgeingAnalysisReportFilterOption(), true);
	 }
	 
	 @Test(priority=554)
	 public void checkStockAgeingAnalysisReportWithOptions() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockAgeingAnalysisReportWithOptions(), true);
	 }
	 
	 @Test(priority=555)
	 public void checkStockAgeingAnalysisReportWithBackTrackOptions() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockAgeingAnalysisReportWithBackTrackOptions(), true);
	 }
	 
	 
	 
	
	 
	 @Test(priority=556)
	 public void checkAgeingAnalysisByBatchReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingAnalysisByBatchReports(), true);
	 }
	 
	 @Test(priority=557)
	 public void checkStockAnalysisByBatchReportPrintOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockAnalysisByBatchReportPrintOption(), true);
	 }
	
	 @Test(priority=558)
	 public void checkAgeingAnalysisByBatchReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingAnalysisByBatchReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions(), true);
	 }
	 
	 @Test(priority=559)
	 public void checkAgeingAnalysisByBatchReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingAnalysisByBatchReportBackTrackOption(), true);
	 }
	 
	 
	 
	 
	 
	 
	 
	 @Test(priority=560)
	 public void checkAgeingAnalysisByRMAReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingAnalysisByRMAReport(), true);
	 }
	 
	 @Test(priority=561)
	 public void checkAgeingAnalysisByRMAReportWithFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingAnalysisByRMAReportWithFilterOption(), true);
	 }
	 
	 @Test(priority=562)
	 public void checkAgeingAnalysisByRMAReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingAnalysisByRMAReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions(), true);
	 }
	 
	 @Test(priority=563)
	 public void checkAgeingAnalysisByRMAReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingAnalysisByRMAReportBackTrackOption(), true);
	 }
	 
	 
	
	 
	
	 
	 
	 @Test(priority=564)
	 public void checkAgeingStockByBinsReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingStockByBinsReports(), true);
	 }
	 
	 @Test(priority=565)
	 public void checkStockAnalysisByBinReportWithFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockAnalysisByBinReportWithFilterOption(), true);
	 }
	 
	 @Test(priority=566)
	 public void checkAgeingAnalysisByBinReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingAnalysisByBinReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions(), true);
	 }
	 
	 @Test(priority=567)
	 public void checkAgeingAnalysisByBinReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingAnalysisByBinReportBackTrackOption(), true);
	 }
	 
	 
	 
	 
	
	 @Test(priority=568)
	 public void checkAgeingByItemByBinsReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingByItemByBinsReports(), true);
	 }
	 
	 @Test(priority=569)
	 public void checkStockByItemByBinReportWithFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockByItemByBinReportWithFilterOption(), true);
	 }
	 
	 @Test(priority=570)
	 public void checkAgeingByItemByBinReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingByItemByBinReportWithWarehouseAndIgnoreInternalTransferForAgeingOptions(), true);
	 }
	 
	 @Test(priority=571)
	 public void checkAgeingByItemByBinReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkAgeingByItemByBinReportBackTrackOption(), true);
	 }
	 
	 
	
	
	
	 
	// @Test(priority=572) //not working
	 public void checkReorderReports() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkReorderReports(), true);
	 }
	 
	// @Test(priority=573)
	 public void checkReorderReportPrintOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkReorderReportPrintOption(), true);
	 }

	 
	
	 
	 
	 @Test(priority=574)
	 public void checkFastMovingItemsReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkFastMovingItemsReport(), true);
	 }
	 
	 @Test(priority=575)//expected
	 public void checkFastMovingItemsReportWithFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkFastMovingItemsReportWithFilterOption(), true);
	 }
	 
	 @Test(priority=576)
	 public void checkFastMovingItemsReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkFastMovingItemsReportBackTrackOption(), true);
	 }
	 
	
	 
	 
	 
	 
	 @Test(priority=577)
	 public void checkSlowMovingItemsReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkSlowMovingItemsReport(), true);
	 }
	 
	 @Test(priority=578)
	 public void checkSlowMovingItemsReportWithFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkSlowMovingItemsReportWithFilterOption(), true);
	 }
	 
	 @Test(priority=579)
	 public void checkSlowMovingItemsReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkSlowMovingItemsReportBackTrackOption(), true);
	 }
	 
	 
	
	
	
	 
	 
	 @Test(priority=580)
	 public void checkPeakAndLowBalancesReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkPeakAndLowBalancesReport(), true);
	 }
	 
	// @Test(priority=581) // Filter is not working
	 public void checkPeakAndLowBalancesReportWithFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkPeakAndLowBalancesReportWithFilterOption(), true);
	 }
	 
	 @Test(priority=582) 
	 public void checkPeakAndLowBalancesReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkPeakAndLowBalancesReportBackTrackOption(), true);
	 }
	 
	
	 
	
	
	
	 
	 @Test(priority=583)
	 public void checkBestSellingItemReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkBestSellingItemReport(), true);
	 }
	 
	 @Test(priority=584)
	 public void checkBestSellingItemReportWithSortingOnAndIncludeAllVouchersChkBox() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkBestSellingItemReportWithSortingOnAndIncludeAllVouchersChkBox(), true);
	 }
	 
	 @Test(priority=585)
	 public void checkBestSellingItemReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkBestSellingItemReportBackTrackOption(), true);
	 }
	 
	
	 
	

	 
	 @Test(priority=586)
	 public void checkStockTransferRegisterReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockTransferRegisterReport(), true);
	 }
	 
	 @Test(priority=587)
	 public void checkStockTransferRegisterReportPrintOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockTransferRegisterReportPrintOption(), true);
	 }
	 
	 @Test(priority=588)
	 public void checkStockTransferRegisterReportWithFromAndToWarehouseAndDetailsOptions() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockTransferRegisterReportWithFromAndToWarehouseAndDetailsOptions(), true);
	 }
	 
	 @Test(priority=589)
	 public void checkStockTransferRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockTransferRegisterReportBackTrackOption(), true);
	 }
	 
	
	
	
	 @Test(priority=590)
	 public void checkStockReservationRegisterReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockReservationRegisterReport(), true);
	 }
	 
	 @Test(priority=591)
	 public void checkStockReservationRegisterReportWithFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockReservationRegisterReportWithFilterOption(), true);
	 }
	 
	 @Test(priority=592)
	 public void checkStockReservationRegisterReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockReservationRegisterReportBackTrackOption(), true);
	 }
	 
	
	 
	
	
	 @Test(priority=593)
	 public void checkTransactionTypeWiseStockReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkTransactionTypeWiseStockReport(), true);
	 }
	 
	 @Test(priority=594)
	 public void checkTransactionTypeWiseStockReportWithFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkTransactionTypeWiseStockReportWithFilterOption(), true);
	 }
	 
	  @Test(priority=595)
	 public void checkTransactionTypeWiseStockReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkTransactionTypeWiseStockReportBackTrackOption(), true);
	 }
	 
	 
	
	  
	  
	 @Test(priority=596)
	 public void checkActualConsumptionReport() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkActualConsumptionReport(), true);
	 }
	 
	 @Test(priority=597)
	 public void checkActualConsumptionReportWithFilterOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkActualConsumptionReportWithFilterOption(), true);
	 }
	 
	 @Test(priority=598)
	 public void checkActualConsumptionReportBackTrackOption() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkActualConsumptionReportBackTrackOption(), true);
	 }
	
	

	 
	 @Test(priority=599)
	 public void checkLoginWithUserForItemRestriction() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkLoginWithUserForItemRestriction(), true);
	 }
	 
	 @Test(priority=600) 
	 public void checkStockReportbyTagReportsWithUserForItemRestriction() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockReportbyTagReportsWithUserForItemRestriction(), true);
	 }
	 
	 @Test(priority=601)
	 public void checkLoginWithSU() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkLoginWithSU(), true);
	 }
	
	
	 @Test(priority=602)
	 public void checkStockLedgerReportwithFilterOptionasRefineforVouchers() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockLedgerReportwithFilterOptionasRefineforVouchers(), true);
	 }
	 
	 
	////////Formating Row in Stock Ledger///////////////////
	 
	 
	 
	 
	 //@Test(priority=603)
	 public void checkStockLedgerReportwithCustomizationFormattingRow() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockLedgerReportwithCustomizationFormattingRow(), true);
	 }
	 
	 
	 
	// @Test(priority=604)
	 public void checkStockLedgerReportRateValuesAfterApplyingFormattingRow() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException
	 {
		 IRP=new InventoryReportsXPage(getDriver());
		 Assert.assertEquals(IRP.checkStockLedgerReportRateValuesAfterApplyingFormattingRow(), true);
	 }
	 
	 
}
