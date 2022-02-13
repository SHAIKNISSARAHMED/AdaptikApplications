package com.adaptikPolicyAndBilling.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
public static WebDriver driver;
public static Properties prop;
	
	public TestBase(){
		
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Shaik.Ahmed\\eclipse-workspace\\JavaLearnings\\TeluskoLearnings\\SapinesPolicyAndBillingTest\\src\\main\\java\\com\\adaptikPolicyAndBilling\\qa\\config\\config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void Initilization() {
	 String browserName = prop.getProperty("browser");
	 System.out.print(browserName);
	 if(browserName.equals("Chrome")) {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shaik.Ahmed\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 
		 driver = new ChromeDriver();
		 System.out.print("Initialized webDriver");
	 }
	 
	 else {
		 System.out.println("Browser Not Supported for Current Code");
	 }
	 
//	 e_driver = new EventFiringWebDriver(driver);
//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
	 driver.manage().window().maximize();
	 //driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 driver.get(prop.getProperty("url"));
	 
	 
	}
}

