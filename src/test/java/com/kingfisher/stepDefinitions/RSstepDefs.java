package com.kingfisher.stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.kingfisher.configuration.CommonFunctions;
import com.kingfisher.coreFramework.AbstractTestCase;
import com.kingfisher.coreFramework.WebDriverFactory;
import com.kingfisher.pageObjects.RSperfLandingPage;
import com.kingfisher.pageObjects.RSperfLoginPage;
import com.kingfisher.pageObjects.RSperfProdAttributesPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RSstepDefs extends AbstractTestCase{
	
	private RSperfLoginPage rsperfLoginPage = null;
	private RSperfLandingPage rsperfLandingPage = null;
	private RSperfProdAttributesPage rsperfProdAttributesPage = null;
	CommonFunctions commonFunctions;
	Actions action;
	private List<WebElement> loopedElement;
	private WebElement workFlowActionisSuccessful;
		
	protected void switchBackToParentWindow(){
	}
	
	@Given("^the user is able to login and navigate to stepersand container$")
	public void loginToStepersandContainer(DataTable userData) throws Throwable {
		rsperfLoginPage = openRSLoginPage();
		rsperfLoginPage.enterUserName(userData.asList(String.class).get(2));
		rsperfLoginPage.enterPassword(userData.asList(String.class).get(3));
		rsperfLandingPage = rsperfLoginPage.clickLogin();
	}
	@Given("^the user is able to login and navigate to stepersand container in RS SIT Env$")
	public void loginToStepersandContainer_rsSITenv(DataTable userData) throws Throwable {
		rsperfLoginPage = openRSLoginPage_RS_SIT_Env();
		rsperfLoginPage.enterUserName(userData.asList(String.class).get(2));
		rsperfLoginPage.enterPassword(userData.asList(String.class).get(3));
		rsperfLandingPage = rsperfLoginPage.clickLogin();
	}

	@When("^the user search a product \"([^\"]*)\" using the search criteria$")
	public void searchForaProductEan(String Ean) throws Throwable {
		rsperfLandingPage.enterProductEan(Ean);
		rsperfLandingPage.search();
		Thread.sleep(5000);
		//commonFunctions.waitTime(driver, driver.findElement(By.cssSelector(".rgRow td:nth-child(2) a")));
		
	}
	
	@Then("^the user should be able to see the product \"([^\"]*)\" is available$")
	public void verifyProductEanisAvbl(String Ean) throws Throwable {
		System.out.println("Get-EAN  "+Ean);
		System.out.println(driver.findElement(By.cssSelector(".rgRow td:nth-child(3)")).getText());
		
		String resultProductEan = driver.findElement(By.cssSelector(".rgRow td:nth-child(3)")).getText();
		if (resultProductEan == Ean) {
			Assert.assertEquals(resultProductEan, Ean);
			Assert.assertTrue(driver.findElement(By.cssSelector(".rgRow td:nth-child(3)")).getText().contains(Ean));	
			}else
				{
				Assert.assertFalse(false);
		 		}
		System.out.println("Asserted True :" +resultProductEan);
		}

	@When("^the user selects the required product ean$")
	public void selectProductEANandSearchRecord() throws Throwable {
		//commonFunctions.waitTime(driver, driver.findElement(By.cssSelector(".rgRow td:nth-child(2) a")));
		//Thread.sleep(1000);
		rsperfProdAttributesPage = rsperfLandingPage.clickonEanSearchRecord();
	}

	@Then("^the user will navigate to Attribute page in a new tab$")
	public void navigateToNewTab() throws Throwable {
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.selectWindow();
		System.out.println("New WINDOW Title: "+ driver.getTitle());
	}

	//private List<WebElement> loopedElement;
	@And("^the user updates Selling Content Attributes 'BulletPointsXX:' 'Copy:' 'Descriptions:' 'Functional:' 'ShippingMethod:' 'USPs:'$")
	public void sellingContentCommonAttributes(DataTable SellContAttrFeatureDataTable) throws Throwable {
		System.out.println("SellingContent CommonAttributes : " + "'BulletPointsXX:'" + "'Copy:'" + "'Descriptions:'" + "'Functional:'" + "'ShippingMethod:'" + "'USPs:'");
		List<List<String>> sellContfeaturedata = SellContAttrFeatureDataTable.raw();
		for (int i=0; i<sellContfeaturedata.size(); i++)
		{
		System.out.println(sellContfeaturedata.get(i).toString());
		}
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(4).findElement(By.xpath("//span[contains(@title,'Copy')]"))).click().build().perform();
		System.out.println(" COPY Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		rsperfProdAttributesPage
			.enterCopyFields(sellContfeaturedata.get(1).get(1).toString(), 
					         sellContfeaturedata.get(2).get(1).toString(),
					         sellContfeaturedata.get(3).get(1).toString(),
					         sellContfeaturedata.get(4).get(1).toString());
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
		
		
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(1).findElement(By.xpath("//span[contains(@title,'Bullets')]"))).click().build().perform();
		System.out.println(" BULLETS Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		rsperfProdAttributesPage
			.enterBulletFields(sellContfeaturedata.get(1).get(0).toString(), 
							   sellContfeaturedata.get(2).get(0).toString(), 
							   sellContfeaturedata.get(3).get(0).toString(), 
							   sellContfeaturedata.get(4).get(0).toString(), 
							   sellContfeaturedata.get(5).get(0).toString(), 
							   sellContfeaturedata.get(6).get(0).toString());
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
		
		
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(5).findElement(By.xpath("//span[contains(@title,'Descriptions')]"))).click().build().perform();
		System.out.println(" DESCRIPTIONS Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		rsperfProdAttributesPage
			.enterDescriptionFields(sellContfeaturedata.get(1).get(2).toString(), 
									sellContfeaturedata.get(2).get(2).toString());
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
		
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(7).findElement(By.xpath("//span[contains(@title,'Functional')]"))).click().build().perform();
		System.out.println(" FUNCTIONAL Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.enterFunctionalFields(sellContfeaturedata.get(1).get(3).toString(), 
								   sellContfeaturedata.get(2).get(3).toString(), 
								   sellContfeaturedata.get(3).get(3).toString(), 
								   sellContfeaturedata.get(5).get(3).toString());
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
		
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(7).findElement(By.xpath("//span[contains(@title,'Functional')]"))).click().build().perform();
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.projectTypeField(sellContfeaturedata.get(4).get(3).toString());
		System.out.println(" LTP - LIVE - LTP - LIVE :::::: Element Executed::::::::::::");
		rsperfProdAttributesPage.saveUpdate();
		Thread.sleep(10000);
		driver.navigate().refresh();
		
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(12).findElement(By.xpath("//span[contains(@title,'Shipping Method')]"))).click().build().perform();
		System.out.println(" SHPM-Methods Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.enterHmDelShpmBQField(sellContfeaturedata.get(1).get(4).toString());
		System.out.println(" HOME-DeliveryBQ Type ::::::::Executed::::::::::");
		rsperfProdAttributesPage.saveUpdate();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(12).findElement(By.xpath("//span[contains(@title,'Shipping Method')]"))).click().build().perform();
		System.out.println(" SHPM-Methods Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.enterOtherShpmBQField(sellContfeaturedata.get(2).get(4).toString());
		System.out.println(" OTHER-DeliveryBQ Type ::::::::Executed::::::::::");
		rsperfProdAttributesPage.saveUpdate();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(15).findElement(By.xpath("//span[contains(@title,'USPs')]"))).click().build().perform();
		System.out.println(" USPs Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.enterUSPFields(sellContfeaturedata.get(1).get(5).toString(),
							sellContfeaturedata.get(2).get(5).toString(),
							sellContfeaturedata.get(3).get(5).toString(),
							sellContfeaturedata.get(4).get(5).toString(),
							sellContfeaturedata.get(5).get(5).toString(),
							sellContfeaturedata.get(6).get(5).toString(),
							sellContfeaturedata.get(7).get(5).toString(),
							sellContfeaturedata.get(8).get(5).toString(),
							sellContfeaturedata.get(9).get(5).toString(),
							sellContfeaturedata.get(10).get(5).toString());
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
	}
	
//==============================================================================================================================================================//	
	@And("^the user updates Selling Content Attributes in SIT ENV 'BulletPointsXX:' 'Copy:' 'Descriptions:' 'Functional:' 'ShippingMethod:' 'USPs:'$")
	public void sellingContentCommonAttributesRS_SIT_ENV(DataTable SellContAttrFeatureDataTable) throws Throwable {
		System.out.println("SellingContent CommonAttributes : " + "'BulletPointsXX:'" + "'Copy:'" + "'Descriptions:'" + "'Functional:'" + "'ShippingMethod:'" + "'USPs:'");
		List<List<String>> sellContfeaturedata = SellContAttrFeatureDataTable.raw();
		for (int i=0; i<sellContfeaturedata.size(); i++)
		{
		System.out.println(sellContfeaturedata.get(i).toString());
		}
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(4).findElement(By.xpath("//span[contains(@title,'Copy')]"))).click().build().perform();
		System.out.println(" COPY Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		rsperfProdAttributesPage
			.enterCopyFields(sellContfeaturedata.get(1).get(1).toString(), 
					         sellContfeaturedata.get(2).get(1).toString(),
					         sellContfeaturedata.get(3).get(1).toString(),
					         sellContfeaturedata.get(4).get(1).toString());
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
		
		
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(1).findElement(By.xpath("//span[contains(@title,'Bullets')]"))).click().build().perform();
		System.out.println(" BULLETS Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		rsperfProdAttributesPage
			.enterBulletFields(sellContfeaturedata.get(1).get(0).toString(), 
							   sellContfeaturedata.get(2).get(0).toString(), 
							   sellContfeaturedata.get(3).get(0).toString(), 
							   sellContfeaturedata.get(4).get(0).toString(), 
							   sellContfeaturedata.get(5).get(0).toString(), 
							   sellContfeaturedata.get(6).get(0).toString());
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
		
		
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(5).findElement(By.xpath("//span[contains(@title,'Descriptions')]"))).click().build().perform();
		System.out.println(" DESCRIPTIONS Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		rsperfProdAttributesPage
			.enterDescriptionFields(sellContfeaturedata.get(1).get(2).toString(), 
									sellContfeaturedata.get(2).get(2).toString());
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
		
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(7).findElement(By.xpath("//span[contains(@title,'Functional')]"))).click().build().perform();
		System.out.println(" FUNCTIONAL Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.enterFunctionalFields_RS_SIT_Env(sellContfeaturedata.get(1).get(3).toString(), 
								   			  sellContfeaturedata.get(2).get(3).toString(), 
								   			  sellContfeaturedata.get(3).get(3).toString(), 
								   			  sellContfeaturedata.get(5).get(3).toString());
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
		
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(7).findElement(By.xpath("//span[contains(@title,'Functional')]"))).click().build().perform();
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.projectTypeField_RS_SIT_Env(sellContfeaturedata.get(4).get(3).toString());
		System.out.println(" LTP - LIVE - LTP - LIVE :::::: Element Executed::::::::::::");
		rsperfProdAttributesPage.saveUpdate();
		Thread.sleep(10000);
		driver.navigate().refresh();
		
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(12).findElement(By.xpath("//span[contains(@title,'Shipping Method')]"))).click().build().perform();
		System.out.println(" SHPM-Methods Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.enterHmDelShpmBQField_RS_SIT_Env(sellContfeaturedata.get(1).get(4).toString());
		System.out.println(" HOME-DeliveryBQ Type ::::::::Executed::::::::::");
		rsperfProdAttributesPage.saveUpdate();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(12).findElement(By.xpath("//span[contains(@title,'Shipping Method')]"))).click().build().perform();
		System.out.println(" SHPM-Methods Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.enterOtherShpmBQField__RS_SIT_Env(sellContfeaturedata.get(2).get(4).toString());
		System.out.println(" OTHER-DeliveryBQ Type ::::::::Executed::::::::::");
		rsperfProdAttributesPage.saveUpdate();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(15).findElement(By.xpath("//span[contains(@title,'USPs')]"))).click().build().perform();
		System.out.println(" USPs Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.enterUSPFields(sellContfeaturedata.get(1).get(5).toString(),
							sellContfeaturedata.get(2).get(5).toString(),
							sellContfeaturedata.get(3).get(5).toString(),
							sellContfeaturedata.get(4).get(5).toString(),
							sellContfeaturedata.get(5).get(5).toString(),
							sellContfeaturedata.get(6).get(5).toString(),
							sellContfeaturedata.get(7).get(5).toString(),
							sellContfeaturedata.get(8).get(5).toString(),
							sellContfeaturedata.get(9).get(5).toString(),
							sellContfeaturedata.get(10).get(5).toString());
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
	}
	
//==============================================================================================================================================================//
	
	@And("^checks the workflow action and product ean is Promoted$")
	public void isWorkflowActionPromoted() throws Throwable {
		rsperfProdAttributesPage.workItems();
		Thread.sleep(2000);
		driver.switchTo().frame("RAD_SPLITTER_PANE_EXT_CONTENT_ContentRadPane");
		Thread.sleep(2000);
		rsperfProdAttributesPage.approveWorkFlow();
		
		workFlowActionisSuccessful=rsperfProdAttributesPage.WorkFlowActionisSuccessful;
		driver.switchTo().frame("RAD_SPLITTER_PANE_EXT_CONTENT_ContentRadPane");
		
		try {
			commonFunctions.waitTime(driver, workFlowActionisSuccessful);
			System.out.println("::::::WorkFlowAction Status is::::::: " +workFlowActionisSuccessful.getText());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			Assert.assertEquals(workFlowActionisSuccessful.getText(), "Workflow Action is successful");
			System.out.println("Assert Condition is Successful :"+workFlowActionisSuccessful.getText());
			} 
			catch (Exception e1) 
				{
					e1.printStackTrace();
				}
	}

	@When("^the user exports the SellingContent Profile$")
	public void exportSellingContentProfile(DataTable profileName) throws Throwable {
		
		List<List<String>> profileNamefeaturedata = profileName.raw();
		for (int i=0; i<profileNamefeaturedata.size(); i++)
		{
		System.out.println(profileNamefeaturedata.get(i).toString());
		}
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.waitTime(driver, driver.findElement(By.id("el4")));
		rsperfLandingPage.IntegrationLink();
		Thread.sleep(2000);
		rsperfLandingPage
			.searchProfileNameField(profileNamefeaturedata.get(1).get(0).toString());
		rsperfLandingPage.exportProfileOutputTab();
		rsperfLandingPage.exportNow();
		rsperfLandingPage.StatusRefresh();
	}
		
	@Then("^the user quits browser windows$")
	public void closeBrowsers(){
		quitDriver();
	}

//======================================================================================================================
	@And("^the user updates 'Copy:'$")
	public void commonAttributesCopy(DataTable CopyAttributes) throws Throwable {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(4).findElement(By.xpath("//span[contains(@title,'Copy')]"))).click().build().perform();
		
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		rsperfProdAttributesPage
			.enterCopyFields(CopyAttributes.asList(String.class).get(1), 
						 	 CopyAttributes.asList(String.class).get(2),
						 	 CopyAttributes.asList(String.class).get(3),
						 	 CopyAttributes.asList(String.class).get(4));
		rsperfProdAttributesPage
			.enterBodyCopyAndSellingCopyOnlyFields(CopyAttributes.asList(String.class).get(1),
												   CopyAttributes.asList(String.class).get(4));
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
		
	}
	
	@And("^the user updates Selling Content Attributes 'BulletPointsXX:'$")
	public void commonAttributesBullets(DataTable BulletsAttributes) throws Throwable {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(1).findElement(By.xpath("//span[contains(@title,'Bullets')]"))).click().build().perform();
		
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		rsperfProdAttributesPage
			.enterBulletFields(BulletsAttributes.asList(String.class).get(1), 
							   BulletsAttributes.asList(String.class).get(2), 
							   BulletsAttributes.asList(String.class).get(3), 
							   BulletsAttributes.asList(String.class).get(4), 
							   BulletsAttributes.asList(String.class).get(5), 
							   BulletsAttributes.asList(String.class).get(6));
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
	}

	@And("^the user updates 'Descriptions:'$")
	public void commonAttributesDescriptions(DataTable DescriptionsAttributes) throws Throwable {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(5).findElement(By.xpath("//span[contains(@title,'Descriptions')]"))).click().build().perform();
		
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		rsperfProdAttributesPage
			.enterDescriptionFields(DescriptionsAttributes.asList(String.class).get(1), 
							        DescriptionsAttributes.asList(String.class).get(2));
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
	}

	@And("^the user updates 'Functional:'$")
	public void commonAttributesFunctional(DataTable FunctionalAttributes) throws Throwable {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(7).findElement(By.xpath("//span[contains(@title,'Functional')]"))).click().build().perform();
		System.out.println(" FUNCTIONAL Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.enterFunctionalFields(FunctionalAttributes.asList(String.class).get(1),
								   FunctionalAttributes.asList(String.class).get(2),
					               FunctionalAttributes.asList(String.class).get(3),
					               FunctionalAttributes.asList(String.class).get(5));
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
		
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(7).findElement(By.xpath("//span[contains(@title,'Functional')]"))).click().build().perform();
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.projectTypeField(FunctionalAttributes.asList(String.class).get(4));
		System.out.println(" LTP - LIVE - LTP - LIVE :::::: Element Executed::::::::::::");
		rsperfProdAttributesPage.saveUpdate();
		Thread.sleep(10000);
		driver.navigate().refresh();
	}

	@And("^the user updates 'ShippingMethod:'$")
	public void commonAttributesShippingMethod(DataTable ShpmAttributes) throws Throwable {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(12).findElement(By.xpath("//span[contains(@title,'Shipping Method')]"))).click().build().perform();
		System.out.println(" SHPM-Methods Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.enterHmDelShpmBQField(ShpmAttributes.asList(String.class).get(1));
		System.out.println(" HOME-DeliveryBQ Type ::::::::Executed::::::::::");
		rsperfProdAttributesPage.saveUpdate();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(12).findElement(By.xpath("//span[contains(@title,'Shipping Method')]"))).click().build().perform();
		System.out.println(" SHPM-Methods Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		rsperfProdAttributesPage
			.enterOtherShpmBQField(ShpmAttributes.asList(String.class).get(2));
		System.out.println(" OTHER-DeliveryBQ Type ::::::::Executed::::::::::");
		rsperfProdAttributesPage.saveUpdate();
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
	@And("^the user updates 'TechSpecs:'$")
	public void commonAttributesTechSpecs(DataTable TechSpecAttributes) throws Throwable {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(15).findElement(By.xpath("//span[contains(@title,'Tech Specs')]"))).click().build().perform();
		System.out.println(" USPs Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		rsperfProdAttributesPage
			.enterTechSpecFields(TechSpecAttributes.asList(String.class).get(1),
								 TechSpecAttributes.asList(String.class).get(2));
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
	}
	
	@And("^the user updates 'USPs:'$")
	public void commonAttributesUSPs(DataTable USPAttributes) throws Throwable {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(15).findElement(By.xpath("//span[contains(@title,'USPs')]"))).click().build().perform();
		System.out.println(" USPs Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		rsperfProdAttributesPage
			.enterUSPFields(USPAttributes.asList(String.class).get(1),
							USPAttributes.asList(String.class).get(2),
							USPAttributes.asList(String.class).get(3),
							USPAttributes.asList(String.class).get(4),
							USPAttributes.asList(String.class).get(5),
							USPAttributes.asList(String.class).get(6),
							USPAttributes.asList(String.class).get(7),
							USPAttributes.asList(String.class).get(8),
							USPAttributes.asList(String.class).get(9),
							USPAttributes.asList(String.class).get(10));
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
	}
}
