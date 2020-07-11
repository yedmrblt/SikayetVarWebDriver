package Crawler;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Crawler {
	WebDriver driver;
	
	public void getMessages() {
		List<WebElement> listOfElements = driver.findElements(By.xpath("//h5"));
		for (WebElement webElement: listOfElements) {
			System.out.println(webElement.getText());
		}
		System.out.println("-------------------------------");
		WebElement nextPageArrow = driver.findElement(By.xpath("//a[contains(@class, 'right-arrow')]"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		nextPageArrow.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		getMessages();
	}
	
	public void launchBrowser() {
		
		 /*  Firefox Driver
		  *  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");
		  *  driver = new FirefoxDriver();
		  * */
		
		/* Google Chrome Driver */
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://www.sikayetvar.com/mng-kargo");
		// cerez politikasi
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(@class, 'btn-complain') and contains(., 'Kabul')]")).click();
		getMessages();
	}
	
	public static void main(String[] args) {
		
		Crawler obj = new Crawler();
		obj.launchBrowser();

	}

}
