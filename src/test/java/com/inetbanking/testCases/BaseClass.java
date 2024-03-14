package com.inetbanking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig=new ReadConfig();
	
	public String baseURL=readConfig.getAppliationURL();
	public String userName=readConfig.getUserName();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
	    logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equalsIgnoreCase("chrome")) {
	
		System.setProperty("webdriver.chrome.driver",readConfig.chromePath());
		driver=new ChromeDriver();	
		}
		else if(br.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.firefox.driver",readConfig.firefoxpath());
			driver=new FirefoxDriver();	
			
		}else if(br.equals("io")) {
			System.setProperty("webdriver.ie.driver", readConfig.ioxpath());
			driver=new InternetExplorerDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
		
		

}
