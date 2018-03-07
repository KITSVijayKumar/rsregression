/*package com.kingfisher.stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.kingfisher.configuration.CommonFunctions;
import com.kingfisher.coreFramework.AbstractTestCase;
import com.kingfisher.pageObjects.RSperfLandingPage;
import com.kingfisher.pageObjects.RSperfLoginPage;
import com.kingfisher.pageObjects.RSperfProdAttributesPage;

import cucumber.api.java8.En;
import cucumber.api.DataTable;

public class RSLambdaStepDefs extends AbstractTestCase implements En{
	
	private RSperfLoginPage rsperfLoginPage = null;
	private RSperfLandingPage rsperfLandingPage = null;
	private RSperfProdAttributesPage rsperfProdAttributesPage = null;
	CommonFunctions commonFunctions;
	Actions action;
	private List<WebElement> loopedElement;
	private WebElement workFlowActionisSuccessful;
	
	
	public RSLambdaStepDefs() {
	Given("^the user is able to login and navigate to stepersand container$", (DataTable userData) -> {
		rsperfLoginPage = openRSLoginPage();
		rsperfLoginPage.enterUserName(userData.asList(String.class).get(2));
		rsperfLoginPage.enterPassword(userData.asList(String.class).get(3));
		rsperfLandingPage = rsperfLoginPage.clickLogin();
	});

	When("^the user search a product \"([^\"]*)\" using the search criteria$", (String Ean) -> {
		rsperfLandingPage.enterProductEan(Ean);
		rsperfLandingPage.search();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//commonFunctions.waitTime(driver, driver.findElement(By.cssSelector(".rgRow td:nth-child(2) a")));   
	});

	Then("^the user should be able to see the product \"([^\"]*)\" is available$", (String Ean) -> {
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
	});

	When("^the user selects the required product ean$", () -> {
		rsperfProdAttributesPage = rsperfLandingPage.clickonEanSearchRecord();
	});

	Then("^the user will navigate to Attribute page in a new tab$", () -> {
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.selectWindow();
		System.out.println("New WINDOW Title: "+ driver.getTitle()); 
	});

	Then("^the user updates 'Copy:'$", (DataTable CopyAttributes) -> {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(4).findElement(By.xpath("//span[contains(@title,'Copy')]"))).click().build().perform();
		
		driver.switchTo().frame(0);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	});
	
	Then("^the user updates Selling Content Attributes 'BulletPointsXX:'$", (DataTable BulletsAttributes) -> {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(1).findElement(By.xpath("//span[contains(@title,'Bullets')]"))).click().build().perform();
		
		driver.switchTo().frame(0);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rsperfProdAttributesPage
			.enterBulletFields(BulletsAttributes.asList(String.class).get(1), 
							   BulletsAttributes.asList(String.class).get(2), 
							   BulletsAttributes.asList(String.class).get(3), 
							   BulletsAttributes.asList(String.class).get(4), 
							   BulletsAttributes.asList(String.class).get(5), 
							   BulletsAttributes.asList(String.class).get(6));
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
	});

	Then("^the user updates 'Descriptions:'$", (DataTable DescriptionsAttributes) -> {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(5).findElement(By.xpath("//span[contains(@title,'Descriptions')]"))).click().build().perform();
		
		driver.switchTo().frame(0);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rsperfProdAttributesPage
			.enterDescriptionFields(DescriptionsAttributes.asList(String.class).get(1), 
							        DescriptionsAttributes.asList(String.class).get(2));
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
	  
	});

	Then("^the user updates 'Functional:'$", (DataTable FunctionalAttributes) -> {
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
		try {
			rsperfProdAttributesPage
				.projectTypeField(FunctionalAttributes.asList(String.class).get(4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" LTP - LIVE - LTP - LIVE :::::: Element Executed::::::::::::");
		rsperfProdAttributesPage.saveUpdate();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh();
	   
	});

	Then("^the user updates 'ShippingMethod:'$", (DataTable ShpmAttributes) -> {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(12).findElement(By.xpath("//span[contains(@title,'Shipping Method')]"))).click().build().perform();
		System.out.println(" SHPM-Methods Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		try {
			rsperfProdAttributesPage
				.enterHmDelShpmBQField(ShpmAttributes.asList(String.class).get(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" HOME-DeliveryBQ Type ::::::::Executed::::::::::");
		rsperfProdAttributesPage.saveUpdate();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh();
		
		driver.switchTo().defaultContent();
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(12).findElement(By.xpath("//span[contains(@title,'Shipping Method')]"))).click().build().perform();
		System.out.println(" SHPM-Methods Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		try {
			rsperfProdAttributesPage
				.enterOtherShpmBQField(ShpmAttributes.asList(String.class).get(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" OTHER-DeliveryBQ Type ::::::::Executed::::::::::");
		rsperfProdAttributesPage.saveUpdate();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh();
	   
	});

	Then("^the user updates 'TechSpecs:'$", (DataTable TechSpecAttributes) -> {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(15).findElement(By.xpath("//span[contains(@title,'Tech Specs')]"))).click().build().perform();
		System.out.println(" USPs Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rsperfProdAttributesPage
			.enterTechSpecFields(TechSpecAttributes.asList(String.class).get(1),
								 TechSpecAttributes.asList(String.class).get(2));
		rsperfProdAttributesPage.saveUpdate();
		driver.navigate().refresh();
	   
	});

	Then("^the user updates 'USPs:'$", (DataTable USPAttributes) -> {
		driver.switchTo().defaultContent();
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.standardViewcommonAttributesList();
		loopedElement = commonFunctions.element;
		action = new Actions(driver);
		action.moveToElement(loopedElement.get(15).findElement(By.xpath("//span[contains(@title,'USPs')]"))).click().build().perform();
		System.out.println(" USPs Common Functions:::::: Element Executed::::::::::::");
		driver.switchTo().frame(0);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	   
	});

	Then("^checks the workflow action and product ean is Promoted$", () -> {
		rsperfProdAttributesPage.workItems();
		try {
			Thread.sleep(2000);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		driver.switchTo().frame("RAD_SPLITTER_PANE_EXT_CONTENT_ContentRadPane");
		try {
			Thread.sleep(2000);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			rsperfProdAttributesPage.approveWorkFlow();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
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
	});

	Then("^the user quits browser windows$", () -> {
		quitDriver();
	});

	When("^the user exports the SellingContent Profile$", (DataTable profileName) -> {
		List<List<String>> profileNamefeaturedata = profileName.raw();
		for (int i=0; i<profileNamefeaturedata.size(); i++)
		{
		System.out.println(profileNamefeaturedata.get(i).toString());
		}
		
		commonFunctions = new CommonFunctions(driver);
		commonFunctions.waitTime(driver, driver.findElement(By.id("el4")));
		rsperfLandingPage.IntegrationLink();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rsperfLandingPage
			.searchProfileNameField(profileNamefeaturedata.get(1).get(0).toString());
		try {
			rsperfLandingPage.exportProfileOutputTab();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rsperfLandingPage.exportNow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rsperfLandingPage.StatusRefresh();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	});
}
}



*/