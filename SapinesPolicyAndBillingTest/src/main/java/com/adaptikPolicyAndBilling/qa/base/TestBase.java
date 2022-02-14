package com.adaptikPolicyAndBilling.qa.base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.gargoylesoftware.htmlunit.BrowserVersion;


public class TestBase {
public static WebDriver  driver;
public static Properties prop;
	
	public TestBase(){
		
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Shaik.Ahmed\\git\\AdaptikApplications\\SapinesPolicyAndBillingTest\\src\\main\\java\\com\\adaptikPolicyAndBilling\\qa\\config\\config.properties");
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
		 
//		 driver = new ChromeDriver();

		 System.out.print("Initialized Chrome Browser");
	 }
	 
	 else if(browserName.equals("headless")) {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shaik.Ahmed\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		 driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("window-size=1400,800");
		 options.addArguments("headless");
		
		 driver = new ChromeDriver(options);
		 System.out.println("Running On HeadLessMode");
	 }
	 
	 else {
		 System.out.println("Invalid BrowserName in config file");
	 }
	 
//	 e_driver = new EventFiringWebDriver(driver);
//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 driver.get(prop.getProperty("url"));
	 
	 
	}
}

