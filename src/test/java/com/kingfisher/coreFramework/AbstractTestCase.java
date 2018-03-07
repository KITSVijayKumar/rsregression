package com.kingfisher.coreFramework;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import com.kingfisher.configuration.Context;
import com.kingfisher.pageObjects.RSperfLoginPage;

@ContextConfiguration(classes = Context.class, initializers = ConfigFileApplicationContextInitializer.class)
public abstract class AbstractTestCase {

protected WebDriver driver;
	
	
	@Value("${rsPerfEnv}")
	private String rsPerfEnv;
	
	public void printUrl(){
		System.out.println(rsPerfEnv);
	}
	public String navigateTorsPerfEnv(){
		return rsPerfEnv;
	}
	
	
	@Value("${rsSITEnv}")
	private String rsSITEnv;
	
	public void printUrl_rsSITEnv(){
		System.out.println(rsSITEnv);
	}
	public String navigateTorsSITEnv(){
		return rsSITEnv;
	}
	
	
	@Autowired
	protected RestTemplate restTemplate;
	
	public void printRestTemplate(){
		System.out.println(restTemplate);
	}
	
	
	@Autowired
	private WebDriverFactory webDriverFactory;
	
	public void printWebDriverFactory(){
		System.out.println(webDriverFactory);
	}
	
	
	protected RSperfLoginPage openRSLoginPage() {
		driver = webDriverFactory.initializeWebDriver();
		driver.get(navigateTorsPerfEnv());
		System.out.println(driver.getTitle());
		return new RSperfLoginPage(driver);
	}
	protected RSperfLoginPage openRSLoginPage_RS_SIT_Env() {
		driver = webDriverFactory.initializeWebDriver();
		driver.get(navigateTorsSITEnv());
		System.out.println(driver.getTitle());
		return new RSperfLoginPage(driver);
	}
	
	
	protected void switchBackToParentWindow(){
		String windowHandle = driver.getWindowHandle();
		driver.switchTo().window(windowHandle);
		
		Set<String> allwindowIds = driver.getWindowHandles();
		
		for (String currentWindow : allwindowIds) {
			driver.switchTo().window(currentWindow);
		}
	}
	
	
	protected void quitDriver(){
		if(driver != null)
			driver.quit();
	}
}

