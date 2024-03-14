package com.inetbanking.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public  void loginTest() {
		
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickLogin();
		WebElement successmsg=driver.findElement(By.xpath("//h3[contains(text(),'Successfully Logged in...')]"));
		String actualsuccessmsg=successmsg.getText();
		
		if(actualsuccessmsg.equals("Successfully Logged in...")) {
			
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
		
	}
	
}
