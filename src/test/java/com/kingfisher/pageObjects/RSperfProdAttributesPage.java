package com.kingfisher.pageObjects;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import com.kingfisher.configuration.CommonFunctions;
import com.kingfisher.coreFramework.AbstractWebPage;

public class RSperfProdAttributesPage extends AbstractWebPage {
	
	CommonFunctions commonFunctions;
	private String MainWindow;
	private String PopupWindow;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:first-of-type span.rtIn")
	private WebElement commonAttrALL;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(2) span.rtIn")
	private WebElement commonAttrBullets;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(3) span.rtIn")
	private WebElement commonAttrCalcAttr;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(4) span.rtIn")
	private WebElement commonAttrClassification;
	
	@FindBy(how = How.CSS, using = ".rtMid.rtSelected [title='Copy']")
	private WebElement commonAttrCopy;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(6) span.rtIn")
	private WebElement commonAttrDesc;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(7) span.rtIn")
	private WebElement commonAttrDigiAssets;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(8) span.rtIn")
	private WebElement commonAttrFunctional;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(9) span.rtIn")
	private WebElement commonAttrMultiSKU;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(10) span.rtIn")
	private WebElement commonAttrOpCOMaintd;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(11) span.rtIn")
	private WebElement commonAttrRatings;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(12) span.rtIn")
	private WebElement commonAttrSAPopertnl;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(13) span.rtIn")
	private WebElement commonAttrShpMethod;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(14) span.rtIn")
	private WebElement commonAttrStatus;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(15) span.rtIn")
	private WebElement commonAttrTechSpecs;
	
	@FindBy(how = How.CSS, using = "#trvStandardView ul li:nth-child(2) ul li:nth-child(16) span.rtIn")
	private WebElement commonAttrUSPs;
	
	@FindBy(how = How.CSS, using = "#tblMain tbody tr:nth-child(6) td:nth-child(4) div input[type='text']")
	private WebElement BulletPointField05;
//#tblContainer #tblMain tbody tr:nth-child(6) td:nth-child(4) div input[type='text']	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(7) td:nth-child(4) input[type='text']")
	private WebElement BulletPointField06;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(8) td:nth-child(4) input[type='text']")
	private WebElement BulletPointField07;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(9) td:nth-child(4) input[type='text']")
	private WebElement BulletPointField08;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(10) td:nth-child(4) input[type='text']")
	private WebElement BulletPointField09;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(11) td:nth-child(4) input[type='text']")
	private WebElement BulletPointField10;
	
	@FindBy(how = How.CSS, using = "#tblMain tbody tr:nth-child(2) td:nth-child(4) .DisplayControl")
	private WebElement BodyCopyField;
	
	@FindBy(how = How.CSS, using = "#tblMain tbody tr:nth-child(3) td:nth-child(4) .DisplayControl")
	private WebElement OpcoSellingCopyField;
	
	@FindBy(how = How.CSS, using = "#tblMain tbody tr:nth-child(4) td:nth-child(4) .DisplayControl")
	private WebElement OverrideBodyCopyField;
	
	@FindBy(how = How.CSS, using = "#tblMain tbody tr:nth-child(5) td:nth-child(4) .DisplayControl")
	private WebElement SellingCopyField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(2) td:nth-child(4) input[type='text']")
	private WebElement LongDescField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(3) td:nth-child(4) input[type='text']")
	private WebElement MedDescField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(6) td:nth-child(4) input[type='text']")
	private WebElement ShortDescField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(4) td:nth-child(4) input[type='text']")
	private WebElement WedMedDescField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(5) td:nth-child(4) input[type='text']")
	private WebElement WebShortDescField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(10) td:nth-child(4) input[type='text']")
	private WebElement HelpandAdviceContGrpField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(19) td:nth-child(4) input[type='text']")
	private WebElement ProdFeaturesContGrpField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(17) td:nth-child(4) input[type='text']")
	private WebElement ProdFeaturesContGrpField_RS_SIT_ENV;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(20) td:nth-child(4) input[type='text']")
	private WebElement ProjectNameField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(18) td:nth-child(4) input[type='text']")
	private WebElement ProjectNameField_RS_SIT_ENV;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(21) [title='Show/Hide Options']")
	private WebElement ProjectTypeDropDown;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(14) td:nth-child(4) input[type='text']")
	private WebElement OLBReferenceField;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='tblMain']/tbody/tr[contains(td,'')]")
	private WebElement SelectProjectTypeFromDropDownTable;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(21) td:nth-child(4) input[type='text']")
	private List<WebElement> SendProjectTypeintotheField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(21) td:nth-child(4) [title='Find']")
	private WebElement FindandPickProjectTypeField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(19) td:nth-child(4) input[type='text']")
	private List<WebElement> SendProjectTypeintotheField_RS_SIT_ENV;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(19) td:nth-child(4) [title='Find']")
	private WebElement FindandPickProjectTypeField_RS_SIT_ENV;
	
	@FindBy(how = How.CSS, using = "#txtSearchValue")
	private WebElement projectTypeSelectioninPopupWindow;
	
	@FindBy(how = How.CSS, using = "#btnSearch")
	private WebElement projectTypeSelectionBtnSearch;
	
	@FindBy(how = How.CSS, using = ".rowhilite.simpleText td:first-of-type [alt='View']")
	private WebElement SelectandClickprojectType;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(21) td:nth-child(4) span")
	private WebElement ProjectTypeField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(25) td:nth-child(4) input[type='text']")
	private WebElement StoreStockToleranceField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(23) td:nth-child(4) input[type='text']")
	private WebElement StoreStockToleranceField_RS_SIT_ENV;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(2) [title='Show/Hide Options']")
	private WebElement HmDelShpmBQDropDownLink;
	
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(2) td:nth-child(4) input[type='text']")
	private List<WebElement> SendHmDelBQShpmIDField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(3) td:nth-child(4) [title='Find']")
	private WebElement FindandPickHmDelBQShpmIDField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(2) td:nth-child(4) input[type='text']")
	private List<WebElement> SendHmDelBQShpmIDField_RS_SIT_ENV;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(2) td:nth-child(4) [title='Find']")
	private WebElement FindandPickHmDelBQShpmIDField_RS_SIT_ENV;
	
	@FindBy(how = How.CSS, using = "#searchContainer [name='txtSearchValue']")
	private WebElement LookUpData;
	
	@FindBy(how = How.CSS, using = "#searchContainer [name='btnSearch']")
	private WebElement LookUpDataSearch;
	
	@FindBy(how = How.CSS, using = "#divGrid tbody td [title='Click to select']")
	private WebElement LookUpDataSelect;
	
	@FindBy(how = How.CSS, using = "#divGrid tbody tr:nth-child(2) input[type='checkbox']")
	private WebElement LookUpDataSelectCheckbox;
	
	@FindBy(how = How.CSS, using = "#buttonsContainer input[name='btnSave']")
	private WebElement LookUpDataButtonOK;
	
		
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(5) td:nth-child(4) input[type='text']")
	private List<WebElement> SendOtherDelBQShpmIDField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(5) td:nth-child(3) tr td:nth-child(1) input[type='radio']")
	private WebElement ClearOtherDelBQShpmIDField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(5) td:nth-child(4)  [title='Find']")
	private WebElement FindandPickOtherDelBQShpmIDField;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(3) td:nth-child(4) input[type='text']")
	private List<WebElement> SendOtherDelBQShpmIDField_RS_SIT_ENV;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(3) td:nth-child(3) tr td:nth-child(1) input[type='radio']")
	private WebElement ClearOtherDelBQShpmIDField_RS_SIT_ENV;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(3) td:nth-child(4)  [title='Find']")
	private WebElement FindandPickOtherDelBQShpmIDField_RS_SIT_ENV;
	
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(5) [title='Show/Hide Options']")
	private WebElement OtherDelShpmBQDropDown;
	
	@FindBy(how = How.CSS, using = "")
	private WebElement OtherDelShpmBQSelectALL;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(21) td:nth-child(4) input[type='text']")
	private WebElement TechSpecField20;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(22) td:nth-child(4) input[type='text']")
	private WebElement TechSpecField21;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(12) td:nth-child(4) input[type='text']")
	private WebElement USPField1;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(13) td:nth-child(4) input[type='text']")
	private WebElement USPField2;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(14) td:nth-child(4) input[type='text']")
	private WebElement USPField3;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(15) td:nth-child(4) input[type='text']")
	private WebElement USPField4;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(16) td:nth-child(4) input[type='text']")
	private WebElement USPField5;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(17) td:nth-child(4) input[type='text']")
	private WebElement USPField6;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(18) td:nth-child(4) input[type='text']")
	private WebElement USPField7;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(19) td:nth-child(4) input[type='text']")
	private WebElement USPField8;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(20) td:nth-child(4) input[type='text']")
	private WebElement USPField9;
	
	@FindBy(how = How.CSS, using = "#tblMain tr:nth-child(21) td:nth-child(4) input[type='text']")
	private WebElement USPField10;
	
	@FindBy(how = How.CSS, using = ".rtbInner ul li [title='Update']")
	private WebElement UpdateBtn;
	
	@FindBy(how = How.LINK_TEXT, using = "Work Items")
	private WebElement WorkItemsLink;
//#NavigationTabStrip ul li [title='Work Items'] span.rtsIn
	
	@FindBy(how = How.CSS, using = "#trvMyWorkItems [title='Approve Update']")
	private WebElement ApproveUpdate;
	
	@FindBy(how = How.LINK_TEXT, using = "Approve")
	private WebElement Approvelink;
//#RSWWFActionToolBarEntityDetail [title='Approve']
	
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement SubmitWorkflow;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'statusbar')]//span[contains(.,'Workflow Action is successful')]")
	public WebElement WorkFlowActionisSuccessful;
	
	@FindBy(how = How.CSS, using = "#lblLifecycleStatusValue")
	private WebElement StatusPromoted;
	
	@FindBy(how = How.CSS, using = ".ui-search-toolbar th:nth-child(3) input[type='text']")
	private WebElement partialProfileNameInput;
	
	@FindBy(how = How.LINK_TEXT, using = "Integration")  
	private WebElement IntegrationLink;
	
	@FindBy(how = How.LINK_TEXT, using = "Export Profiles")
	private WebElement ExportProfileLink;
	
	@FindBy(how = How.LINK_TEXT, using = "JG TEMP Selling Content - STEPERSAND BandQ - Outbound NEW")
	private WebElement JGSellingContentProfileName;
	
	@FindBy(how = How.LINK_TEXT, using = "Selling Content - STEPERSAND BandQ Outbound - NEW")
	private WebElement SellingContentProfileName;
	
	@FindBy(how = How.CSS, using = "#ExportProfileTabs ul li:nth-child(4) [title='Output']")
	private WebElement ExportProfileOutputTab;
	
	@FindBy(how = How.CSS, using = ".toolbar-section div[title='Export Now (Alt+E)']")
	private WebElement ExportNow;
			

	public RSperfProdAttributesPage(WebDriver driver) {
		super(driver);
	}
	
	public void switchToNewTab(){
		driver.switchTo().activeElement().sendKeys(Keys.TAB, "2");
	}

	public void commonAttrALL(){
		commonAttrALL.click();
	}
	public void commonAttrBullets(){
		commonAttrBullets.click();
	}
	public void enterBulletFields(String Bullet05, String Bullet06, String Bullet07, String Bullet08, String Bullet09, String Bullet10){
		BulletPointField05.clear();
		BulletPointField05.sendKeys(Bullet05);
		BulletPointField06.clear();
		BulletPointField06.sendKeys(Bullet06);
		BulletPointField07.clear();
		BulletPointField07.sendKeys(Bullet07);
		BulletPointField08.clear();
		BulletPointField08.sendKeys(Bullet08);
		BulletPointField09.clear();
		BulletPointField09.sendKeys(Bullet09);
		BulletPointField10.clear();
		BulletPointField10.sendKeys(Bullet10);
	}
	
	public void commonAttrCalcAttr(){
		commonAttrCalcAttr.click();
	}
	public void commonAttrClassification(){
		commonAttrClassification.click();
	}
	
	public void commonAttrCopy(){
		commonAttrCopy.click();
	}
	public void enterCopyFields(String bodyCopy, String sellingCopy, String overrideBodyCopy, String opcoSellingCopy){
		BodyCopyField.clear();
		BodyCopyField.sendKeys(bodyCopy);
		SellingCopyField.clear();
		SellingCopyField.sendKeys(sellingCopy);
		OverrideBodyCopyField.clear();
		OverrideBodyCopyField.sendKeys(overrideBodyCopy);
		OpcoSellingCopyField.clear();
		OpcoSellingCopyField.sendKeys(opcoSellingCopy);
	}
	
	public void enterBodyCopyAndSellingCopyOnlyFields(String bodyCopy, String sellingCopy){
		BodyCopyField.clear();
		BodyCopyField.sendKeys(bodyCopy);
		SellingCopyField.clear();
		SellingCopyField.sendKeys(sellingCopy);
		OverrideBodyCopyField.clear();
		OpcoSellingCopyField.clear();
		
	}
	
	public void commonAttrDesc(){
		commonAttrDesc.click();
	}
	public void enterDescriptionFields(String medDescField, String shortDescField){
		MedDescField.clear();
		MedDescField.sendKeys(medDescField);
		ShortDescField.clear();
		ShortDescField.sendKeys(shortDescField);
	}
	
	public void commonAttrDigiAssets(){
		commonAttrDigiAssets.click();
	}
	
	public void commonAttrFunctional(){
		commonAttrFunctional.click();
	}
	public void enterFunctionalFields(String helpandAdviceField, String productFeaturesField, String projectNameField, String stockToleranceField){
		HelpandAdviceContGrpField.clear();
		HelpandAdviceContGrpField.sendKeys(helpandAdviceField);
		ProdFeaturesContGrpField.clear();
		ProdFeaturesContGrpField.sendKeys(productFeaturesField);
		ProjectNameField.clear();
		ProjectNameField.sendKeys(projectNameField);
		StoreStockToleranceField.clear();
		StoreStockToleranceField.sendKeys(stockToleranceField);
	}
	public void enterFunctionalFields_RS_SIT_Env(String helpandAdviceField, String productFeaturesField, String projectNameField, String stockToleranceField){
		HelpandAdviceContGrpField.clear();
		HelpandAdviceContGrpField.sendKeys(helpandAdviceField);
		ProdFeaturesContGrpField_RS_SIT_ENV.clear();
		ProdFeaturesContGrpField_RS_SIT_ENV.sendKeys(productFeaturesField);
		ProjectNameField_RS_SIT_ENV.clear();
		ProjectNameField_RS_SIT_ENV.sendKeys(projectNameField);
		StoreStockToleranceField_RS_SIT_ENV.clear();
		StoreStockToleranceField_RS_SIT_ENV.sendKeys(stockToleranceField);
	}
	public void projectTypeSearch(String projecttype){
		
		List<WebElement> SearchMagnifierImages= driver.findElements(By.xpath(".//*[@id='tblMain']//img[contains(alt,'')]"));
        for(int i=0; i<SearchMagnifierImages.size(); i++){
        	System.out.println("List of Magnifier-Image Elements : " +SearchMagnifierImages.get(i).getText());
        }
		//#tblMain tr:nth-child(19) .DropDownContainer img[alt='Find'][title='Find']
		//.//*[@id='tblMain']/tbody/tr/td/div/span/div/img[contains(alt,'')]
		Set <String> allwindowids=driver.getWindowHandles();
		Iterator<String> iter=allwindowids.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		String mainWindow=iter.next();
		String popupWindow=iter.next();
		driver.switchTo().window(popupWindow);
		projectTypeSelectioninPopupWindow.sendKeys(projecttype);
		projectTypeSelectionBtnSearch.click();
		SelectandClickprojectType.click();
		driver.switchTo().window(mainWindow);
	}
	
	public void projectTypeDropDownContainer(String projecttype) throws InterruptedException{
		SendProjectTypeintotheField.get(0).sendKeys(projecttype);
		SendProjectTypeintotheField.get(0).clear();
		
		Thread.sleep(4000);
		((JavascriptExecutor)driver).executeScript("arguments[0].value='"+projecttype+"'",SendProjectTypeintotheField.get(0));
	}
	public void projectTypeField(String projecttype) throws InterruptedException{
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.waitTime(driver, FindandPickProjectTypeField);
		FindandPickProjectTypeField.click();
		commonFunctions.multipleWindows();
		PopupWindow = commonFunctions.popupWindow;
		driver.switchTo().window(PopupWindow);
		LookUpData.sendKeys(projecttype);
		LookUpDataSearch.click();
		LookUpDataSelect.click();
		MainWindow = commonFunctions.mainWindow;
		driver.switchTo().window(MainWindow);
		driver.switchTo().frame(0);
		UpdateBtn.click();
		Thread.sleep(4000);
	}
	
	public void projectTypeDropDownContainer_RS_SIT_Env(String projecttype) throws InterruptedException{
		SendProjectTypeintotheField_RS_SIT_ENV.get(0).sendKeys(projecttype);
		SendProjectTypeintotheField_RS_SIT_ENV.get(0).clear();
		
		Thread.sleep(4000);
		((JavascriptExecutor)driver).executeScript("arguments[0].value='"+projecttype+"'",SendProjectTypeintotheField_RS_SIT_ENV.get(0));
	}
	public void projectTypeField_RS_SIT_Env(String projecttype) throws InterruptedException{
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.waitTime(driver, FindandPickProjectTypeField_RS_SIT_ENV);
		FindandPickProjectTypeField_RS_SIT_ENV.click();
		commonFunctions.multipleWindows();
		PopupWindow = commonFunctions.popupWindow;
		driver.switchTo().window(PopupWindow);
		LookUpData.sendKeys(projecttype);
		LookUpDataSearch.click();
		LookUpDataSelect.click();
		MainWindow = commonFunctions.mainWindow;
		driver.switchTo().window(MainWindow);
		driver.switchTo().frame(0);
		UpdateBtn.click();
		Thread.sleep(4000);
	}
	
	public void commonAttrMultiSKU(){
		commonAttrMultiSKU.click();
	}
	public void commonAttrOpCOMaintd(){
		commonAttrOpCOMaintd.click();
	}
	public void commonAttrRatings(){
		commonAttrRatings.click();
	}
	public void commonAttrSAPopertnl(){
		commonAttrSAPopertnl.click();
	}
	
	public void commonAttrShpMethod(){
		commonAttrShpMethod.click();
	}
	public void enterShpmBQFields(String shpmHmDelBQ, String shpmOtherDelBQ) throws InterruptedException{
		SendHmDelBQShpmIDField.get(0).sendKeys(shpmHmDelBQ);
		SendHmDelBQShpmIDField.get(0).clear();
		Thread.sleep(2000);
		SendHmDelBQShpmIDField.get(0).sendKeys(shpmHmDelBQ, Keys.ARROW_DOWN, Keys.ARROW_UP, Keys.ARROW_DOWN, Keys.ENTER);
		//SendHmDelBQShpmIDField.get(0).sendKeys(Keys.CLEAR, shpmHmDelBQ, Keys.ENTER);
		Thread.sleep(5000);
		UpdateBtn.click();
		
		SendOtherDelBQShpmIDField.get(0).sendKeys(shpmOtherDelBQ);
		SendOtherDelBQShpmIDField.get(0).clear();
		Thread.sleep(2000);
		//SendOtherDelBQShpmIDField.get(0).sendKeys(shpmOtherDelBQ, Keys.ARROW_DOWN, Keys.ARROW_UP, Keys.ARROW_DOWN, Keys.ENTER);
		SendOtherDelBQShpmIDField.get(0).sendKeys(shpmOtherDelBQ, Keys.ARROW_DOWN, Keys.ARROW_UP, Keys.ENTER);
		Thread.sleep(5000);
	}
	public void enterHmDelShpmBQField(String shpmHmDelBQ) throws InterruptedException{
		
		FindandPickHmDelBQShpmIDField.click();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.multipleWindows();
		PopupWindow = commonFunctions.popupWindow;
		driver.switchTo().window(PopupWindow);
		LookUpData.sendKeys(shpmHmDelBQ);
		LookUpDataSearch.click();
		LookUpDataSelect.click();
		MainWindow = commonFunctions.mainWindow;
		driver.switchTo().window(MainWindow);
		driver.switchTo().frame(0);
		UpdateBtn.click();
		Thread.sleep(4000);
	}
	public void enterOtherShpmBQField(String shpmOtherDelBQ) throws InterruptedException{
		ClearOtherDelBQShpmIDField.click();
		UpdateBtn.click();
		FindandPickOtherDelBQShpmIDField.click();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.multipleWindows();
		PopupWindow = commonFunctions.popupWindow;
		driver.switchTo().window(PopupWindow);
		LookUpData.sendKeys(shpmOtherDelBQ);
		LookUpDataSearch.click();
		LookUpDataSelectCheckbox.click();
		LookUpDataButtonOK.click();
		MainWindow = commonFunctions.mainWindow;
		driver.switchTo().window(MainWindow);
		driver.switchTo().frame(0);
		UpdateBtn.click();
		Thread.sleep(4000);
	}
	public void enterShpmBQFields_RS_SIT_Env(String shpmHmDelBQ, String shpmOtherDelBQ) throws InterruptedException{
		
		SendHmDelBQShpmIDField_RS_SIT_ENV.get(0).sendKeys(shpmHmDelBQ);
		SendHmDelBQShpmIDField_RS_SIT_ENV.get(0).clear();
		Thread.sleep(2000);
		SendHmDelBQShpmIDField_RS_SIT_ENV.get(0).sendKeys(shpmHmDelBQ, Keys.ARROW_DOWN, Keys.ARROW_UP, Keys.ARROW_DOWN, Keys.ENTER);
		//SendHmDelBQShpmIDField.get(0).sendKeys(Keys.CLEAR, shpmHmDelBQ, Keys.ENTER);
		Thread.sleep(5000);
		UpdateBtn.click();
		
		SendOtherDelBQShpmIDField_RS_SIT_ENV.get(0).sendKeys(shpmOtherDelBQ);
		SendOtherDelBQShpmIDField_RS_SIT_ENV.get(0).clear();
		Thread.sleep(2000);
		//SendOtherDelBQShpmIDField.get(0).sendKeys(shpmOtherDelBQ, Keys.ARROW_DOWN, Keys.ARROW_UP, Keys.ARROW_DOWN, Keys.ENTER);
		SendOtherDelBQShpmIDField_RS_SIT_ENV.get(0).sendKeys(shpmOtherDelBQ, Keys.ARROW_DOWN, Keys.ARROW_UP, Keys.ENTER);
		Thread.sleep(5000);
	}
	
	public void enterHmDelShpmBQField_RS_SIT_Env(String shpmHmDelBQ) throws InterruptedException{
		
		FindandPickHmDelBQShpmIDField_RS_SIT_ENV.click();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.multipleWindows();
		PopupWindow = commonFunctions.popupWindow;
		driver.switchTo().window(PopupWindow);
		LookUpData.sendKeys(shpmHmDelBQ);
		LookUpDataSearch.click();
		LookUpDataSelect.click();
		MainWindow = commonFunctions.mainWindow;
		driver.switchTo().window(MainWindow);
		driver.switchTo().frame(0);
		UpdateBtn.click();
		Thread.sleep(4000);
	}
	public void enterOtherShpmBQField__RS_SIT_Env(String shpmOtherDelBQ) throws InterruptedException{
		ClearOtherDelBQShpmIDField_RS_SIT_ENV.click();
		UpdateBtn.click();
		FindandPickOtherDelBQShpmIDField_RS_SIT_ENV.click();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.multipleWindows();
		PopupWindow = commonFunctions.popupWindow;
		driver.switchTo().window(PopupWindow);
		LookUpData.sendKeys(shpmOtherDelBQ);
		LookUpDataSearch.click();
		LookUpDataSelectCheckbox.click();
		LookUpDataButtonOK.click();
		MainWindow = commonFunctions.mainWindow;
		driver.switchTo().window(MainWindow);
		driver.switchTo().frame(0);
		UpdateBtn.click();
		Thread.sleep(4000);
	}
	
	public void commonAttrStatus(){
		commonAttrStatus.click();
	}
	public void commonAttrTechSpecs(){
		commonAttrTechSpecs.click();
	}
	public void enterTechSpecFields(String TechSpec20, String TechSpec21){
		TechSpecField20.clear();
		TechSpecField20.sendKeys(TechSpec20);
		
		TechSpecField21.clear();
		TechSpecField21.sendKeys(TechSpec21);
	}
	public void commonAttrUSPs(){
		commonAttrUSPs.click();
	}
	public void enterUSPFields(String USP01, String USP02, String USP03, String USP04, String USP05, String USP06, String USP07, String USP08, String USP09, String USP10){
		USPField1.clear();
		USPField1.sendKeys(USP01);
		
		USPField2.clear();
		USPField2.sendKeys(USP02);
		
		USPField3.clear();
		USPField3.sendKeys(USP03);
		
		USPField4.clear();
		USPField4.sendKeys(USP04);
		
		USPField5.clear();
		USPField5.sendKeys(USP05);
		
		USPField6.clear();
		USPField6.sendKeys(USP06);
		
		USPField7.clear();
		USPField7.sendKeys(USP07);
		
		USPField8.clear();
		USPField8.sendKeys(USP08);
		
		USPField9.clear();
		USPField9.sendKeys(USP09);
		
		USPField10.clear();
		USPField10.sendKeys(USP10);
	}
	public void saveUpdate(){
		UpdateBtn.click();
	}
	
	public void workItems(){
		WorkItemsLink.click();
		ApproveUpdate.click();
	}
	
	public void approveWorkFlow() throws InterruptedException{
		Approvelink.click();
		Thread.sleep(2000);
		driver.switchTo().frame("ui-id-1");
		SubmitWorkflow.click();
		
	}

	public void IntegrationLink(){
		
		Actions actions = new Actions(driver);
        actions.moveToElement(IntegrationLink).click().build().perform();
        
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", ExportProfileLink);
        
    }
	
	public void searchProfileNameField(String profileSearch){
		partialProfileNameInput.sendKeys(profileSearch);
		//JGSellingContentProfileName.click();
		SellingContentProfileName.click();
	}
	
	public void exportProfileOutputTab(){
		ExportProfileOutputTab.click();
	}
	
	public void exportNow(){
		ExportNow.click();
	}

	

//=================================================================================================	
	public void dropDownsROUGH(){
	//<div id=“dvDetailattribute_17_4142_4030” class=“DropDownLayer”
    //<iframe id=“ifDetailattribute_17_4142_4030” name=“iftableDataattribute_17_4142_4030"     
    /*String frameID = "ifDetailattribute_17_4142_4030"; 
    try 
        {
        driver.switchTo().frame(frameID);
        System.out.println("Navigated to frame with name  "+ frameID);
        } 
    catch (NoSuchFrameException e) 
        {
        System.out.println("Unable to locate frame with id " + frameID + e.getStackTrace());
        } 
    catch (Exception e) 
        {
        System.out.println("Unable to navigate to frame with id " + frameID + e.getStackTrace());
        }
    //driver.switchTo().frame(frameID); //dropdown frame
    List<WebElement> FrameElements_ProjectType= driver.findElements(By.xpath(".//*[@id='tblMain']/tbody/tr[contains(td,'')]"));
        for(int i=0; i<FrameElements_ProjectType.size(); i++){
        System.out.println("FrameID-ifDetailattribute_17_4142_4030 ELEMENTS : " +FrameElements_ProjectType.get(i).getText());
		}
        Actions action = new Actions(driver);
        action.moveToElement(FrameElements_ProjectType.get(2)).doubleClick().build().perform();
        ProjectTypeDropDown.click();
        
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        driver.switchTo().activeElement().sendKeys(Keys.ARROW_RIGHT);
        driver.findElement(By.cssSelector("#tblMain tr:nth-child(19) td:nth-child(3) tr td:nth-child(2) input[type='radio']")).click();*/
        /*for (int i=0; i<=3; i++){
        	driver.switchTo().activeElement().sendKeys(Keys.TAB);
        }*/
        //SelectProjectTypeFromDropDownTable 
        // Select dropdown = new Select(FrameElements_ProjectType);
        //boolean option = dropdown.getAllSelectedOptions().contains(projectype);
	}
}
/*
Bulletpoint 1 field: #tblMain tr:nth-child(2) td:nth-child(4) div:first-of-type 
Bulletpoint 1 field: #tblMain tr:nth-child(5) td:nth-child(4) div:first-of-type [type=‘text’]
#tblMain tr:nth-child(6) td:nth-child(4) input[type='text']
*/