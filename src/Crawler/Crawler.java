package Crawler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Crawler {
	WebDriver driver;
	
	public void launchBrowser() {
		
		 /*  Firefox Driver
		  *  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");
		  *  driver = new FirefoxDriver();
		  * */
		
		/* Google Chrome Driver */
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://www.sikayetvar.com");
	}
	
	public static void main(String[] args) {
		
		Crawler obj = new Crawler();
		obj.launchBrowser();

	}

}
