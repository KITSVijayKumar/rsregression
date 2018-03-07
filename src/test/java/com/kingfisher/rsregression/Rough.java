package com.kingfisher.rsregression;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class Rough {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kumarv13\\workspace\\rsregression\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://kgfperf.riversand.com/KGFPERF/Login/login.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#login")).sendKeys("kumarv13");
		driver.findElement(By.cssSelector("#password")).sendKeys("Kfrs@2017");
		driver.findElement(By.cssSelector("#btnlogin")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='panelBarMiddleSearchPanels_i0_txtAttr_1_22']")).sendKeys("5060178977097");
		driver.findElement(By.cssSelector(".buttonSearch")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.cssSelector(".rgRow td:nth-child(2) a")).click();
		Thread.sleep(6000);
		
		selectWidnow();
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("#tblMain tr:nth-child(6) td:nth-child(4) input[type='text']")).sendKeys("vijaykumar");
		
		//driver.findElement(By.xpath("//span[contains(@id,'attribute_')]"));

		//driver.findElement(By.xpath("//span[@title='Common Attributes']/child::*"));
		
		//span[contains(@id,'attribute_')]//following::div[contains(@title,'')]

		//following::div[contains(@title,'')]
		
		/*driver.switchTo().activeElement().sendKeys(Keys.TAB, "2");
		Thread.sleep(6000);
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("Update")).click();*/
		
		driver.switchTo().defaultContent();
		Thread.sleep(12000);
		List<WebElement> element = driver.findElements(By.xpath(".//*[@id='trvStandardView']//ul/li/ul/li[contains(title,'')]"));
		
		//ul/li[contains(text(),'Apple Mobiles')]/following-sibling::li
		//List<WebElement> rows=  element.findElements(By.tagName("span")); 
		//span[contains(@title,'Copy')]
		for(int i=0;i<element.size();i++){
				System.out.println(element.get(i).getText());
			}
		System.out.println("FourthElement: "+element.get(4).getText());
		Actions action = new Actions(driver);
		action.moveToElement(element.get(4).findElement(By.xpath("//span[contains(@title,'Copy')]"))).click().build().perform();
		//element.get(4).findElement(By.xpath("//span[contains(@title,'Copy')]")).click();
		
			//driver.quit();
	}
	
	
	protected static void selectWidnow(){
		String nextwindow=null;			
		Set<String> allwindowIds = driver.getWindowHandles();
		java.util.Iterator<String> iter=allwindowIds.iterator();
		while(iter.hasNext()){
			nextwindow=iter.next();
		}
		driver.switchTo().window(nextwindow);
	}
	
	
	
	public List<WebElement> element;
	public void standardViewcommonAttributesList(){
		driver.switchTo().defaultContent();
		 element = driver.findElements(By.xpath(".//*[@id='trvStandardView']//ul/li/ul/li[contains(title,'')]"));
		
		 for(int i=0;i<element.size();i++){
			System.out.println(element.get(i).getText());
			
			}
			System.out.println("ElementIndexZero	 	: "+element.get(0).getText()
								
					
					
					);
			
			
			
			
			
			
			System.out.println("ElementIndexTwo		 	: "+element.get(2).getText());
			System.out.println("ElementIndexThree	 	: "+element.get(3).getText());
			System.out.println("ElementIndexFour	 	: "+element.get(4).getText());
			System.out.println("ElementIndexFive	 	: "+element.get(5).getText());
			System.out.println("ElementIndexSix		 	: "+element.get(6).getText());
			System.out.println("ElementIndexSeven	 	: "+element.get(7).getText());
			System.out.println("ElementIndexEight	 	: "+element.get(8).getText());
			System.out.println("ElementIndexNine	 	: "+element.get(9).getText());
			System.out.println("ElementIndexTen		 	: "+element.get(10).getText());
			System.out.println("ElementIndexEleven	 	: "+element.get(11).getText());
			System.out.println("ElementIndexTwelve	 	: "+element.get(12).getText());
			System.out.println("ElementIndexThirteen 	: "+element.get(13).getText());
			System.out.println("ElementIndexFourteen 	: "+element.get(14).getText());
			System.out.println("ElementIndexFifteen	 	: "+element.get(15).getText());
	}
}
