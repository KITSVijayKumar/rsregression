package com.kingfisher.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import com.kingfisher.coreFramework.AbstractWebPage;

public class RSperfLandingPage extends AbstractWebPage {

	@FindBy(how = How.CSS, using = "#panelBarMiddleSearchPanels_i0_tblHeaderAttributeRules tbody tr:first-of-type td:nth-child(2) input[type='text'] ")
	private WebElement eanSearchField;
	
	@FindBy(how = How.CSS, using = ".buttonSearch")
	private WebElement clickOnSearch;
	
	@FindBy(how = How.CSS, using = ".rgRow td:nth-child(2) a")
	private WebElement clickOnEanRecord;
	//a[contains(@title,'5010212479568')]
	
	@FindBy(how = How.CSS, using = ".menuPad td:nth-child(9)")  
	private WebElement IntegrationLink;
	
	@FindBy(how = How.XPATH, using = "//td[contains(.,' Export Profiles')]")
	private List<WebElement> ExportProfileLink;
	
	@FindBy(how = How.CSS, using = ".ui-search-toolbar th:nth-child(3) input[type='text']")
	private WebElement partialProfileNameInput;
	
	@FindBy(how = How.LINK_TEXT, using = "JG TEMP Selling Content - STEPERSAND BandQ - Outbound NEW")
	private WebElement JGSellingContentProfileName;
	
	@FindBy(how = How.LINK_TEXT, using = "Selling Content - STEPERSAND BandQ Outbound - NEW")
	private WebElement SellingContentProfileName;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Output']")
	private WebElement ExportProfileOutputTab;
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Export N')]")
	private WebElement ExportNow;
	
	@FindBy(how = How.XPATH, using = "//*[@id='btnRefresh']")
	private WebElement RefreshButton;
	
	@FindBy(how = How.XPATH, using = "//*[@aria-describedby='jobStatusesTable_Status']")
	private List<WebElement> JobStatusCompleted;
	
	
	public RSperfLandingPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterProductEan(String ean){
		eanSearchField.sendKeys(ean);
	}
	
	public void search(){
		clickOnSearch.click();
	}
	
	public RSperfProdAttributesPage clickonEanSearchRecord(){
		clickOnEanRecord.click();
		return new RSperfProdAttributesPage(driver);
	}

	
	public void IntegrationLink() {
		WebElement Menu = IntegrationLink;
		Actions action = new Actions(driver);
        action.moveToElement(Menu).build().perform(); 
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", ExportProfileLink.get(1)); 
    }
	public void searchProfileNameField(String profileSearch){
		partialProfileNameInput.sendKeys(profileSearch);
		//JGSellingContentProfileName.click();
		SellingContentProfileName.click();
	}
	public void exportProfileOutputTab() throws InterruptedException{
		Thread.sleep(3000);
		ExportProfileOutputTab.click();
	}
	public void exportNow() throws InterruptedException{
		Thread.sleep(3000);
		ExportNow.click();
	}
	public void StatusRefresh() throws InterruptedException {		  
		   while (!JobStatusCompleted.get(0).getText().contains("Completed"))
		   {			  		      
		       RefreshButton.click(); // click the Refresh Status button 
		       Thread.sleep(10000);			   
		   } 
		   System.out.println("Status is now showing |Completed:| "+ JobStatusCompleted.get(0).getText()); 
		} 
}

 