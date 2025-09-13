package Seleniumintro;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test

public class FirstSeleniumTest {

	public void OpenSiteInChrome() {
		
		// Set the path to the ChromeDriver executable
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\jkouadio\\java_selenium\\SeleniumDemoProject\\drivers\\chromedriver.exe");
		
		// Create a new instance of the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
