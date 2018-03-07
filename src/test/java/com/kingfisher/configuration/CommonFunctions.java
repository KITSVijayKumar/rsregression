package com.kingfisher.configuration;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.kingfisher.coreFramework.AbstractWebPage;

public class CommonFunctions extends AbstractWebPage {
	
	public CommonFunctions(WebDriver driver) {
		super(driver);	
	}
	
	public void waitTime(WebDriver driver, WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	public void fluentWait(WebDriver driver, WebElement element){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement innerelement = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.id("innerelement"));
			     }
			   });
			   System.out.println("****************FLUENT WAIT**********************" + innerelement);
	}
	
	
	public void switchTab(){
		driver.switchTo().activeElement().sendKeys(Keys.TAB, "2");
	}
	
	public void selectWindow(){
		String nextwindow=null;			
		Set<String> allwindowIds = driver.getWindowHandles();
		java.util.Iterator<String> iter=allwindowIds.iterator();
		while(iter.hasNext()){
			nextwindow=iter.next();
		}
		driver.switchTo().window(nextwindow);
	}
	
	public String mainWindow;
	public String popupWindow;
	public void multipleWindows(){
		Set <String> allwindowids=driver.getWindowHandles();
		Iterator<String> iter=allwindowids.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
			mainWindow=iter.next();
			popupWindow=iter.next();
		}
	}

	public void commonAttributesList(){
		driver.switchTo().defaultContent();
		
		List<WebElement> element = driver.findElements(By.xpath(".//*[@id='trvStandardView']//ul/li/ul/li[contains(title,'')]"));
		for(int i=0;i<element.size();i++){
			System.out.println(element.get(i).getText());
			}
			System.out.println("FourthElement: "+element.get(4).getText());
		Actions action = new Actions(driver);
		action.moveToElement(element.get(4).findElement(By.xpath("//span[contains(@title,'Copy')]"))).click().build().perform();
	}
	
	public List<WebElement> element;
	public void standardViewcommonAttributesList(){
		driver.switchTo().defaultContent();
		 element = driver.findElements(By.xpath(".//*[@id='trvStandardView']//ul/li/ul/li[contains(title,'')]"));
		
		 for(int i=0;i<element.size();i++){
			System.out.println(element.get(i).getText());
			
			}
			System.out.println(" ElementIndexZero		: "+element.get(0).getText() +
								"\n ElementIndexOne		: "+element.get(1).getText() +
								"\n ElementIndexTwo		: "+element.get(2).getText() +
								"\n ElementIndexThree	: "+element.get(3).getText() +
								"\n ElementIndexFour	: "+element.get(4).getText() +
								"\n ElementIndexFive	: "+element.get(5).getText() +
								"\n ElementIndexSix		: "+element.get(6).getText() +
								"\n ElementIndexSeven	: "+element.get(7).getText() +
								"\n ElementIndexEight	: "+element.get(8).getText() +
								"\n ElementIndexNine	: "+element.get(9).getText() +
								"\n ElementIndexTen		: "+element.get(10).getText() +
								"\n ElementIndexEleven	: "+element.get(11).getText() +
								"\n ElementIndexTwelve	: "+element.get(12).getText() +
								"\n ElementIndexThirteen: "+element.get(13).getText() +
								"\n ElementIndexFourteen: "+element.get(14).getText() +
								"\n ElementIndexFifteen	: "+element.get(15).getText()); 
	}
	
	public void moveToElement(WebDriver driver, WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}
}


