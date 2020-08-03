package com.ohrm.qa.hybrid.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("D:\\java programms in eclipse\\OHRM\\src\\main\\"
					+ "java\\com\\ohrm\\qa\\hybrid\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void initialiazation(){
		
		String BrowserName=prop.getProperty("Browser");
		if(BrowserName.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(BrowserName.equals("FF")){
			
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
		
		
	}

}
