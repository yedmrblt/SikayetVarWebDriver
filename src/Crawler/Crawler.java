package Crawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	FileWriter fw;
	File file = new File("complains.txt");
	
	public void getMessages() {
		try {
			fw = new FileWriter(file, true);
			List<WebElement> listOfElements = driver.findElements(By.xpath("//h5"));
			for (WebElement webElement: listOfElements) {
				fw.write(webElement.getText());
				fw.write(System.getProperty("line.separator"));
			}
			WebElement nextPageArrow = driver.findElement(By.xpath("//a[contains(@class, 'right-arrow')]"));
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			nextPageArrow.click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			fw.flush();
			fw.close();
			getMessages();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void launchBrowser() {
		
		 /*  Firefox Driver
		  *  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");
		  *  driver = new FirefoxDriver();
		  * */
		
		/* Google Chrome Driver */
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://www.sikayetvar.com/mng-kargo?page=1");
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
