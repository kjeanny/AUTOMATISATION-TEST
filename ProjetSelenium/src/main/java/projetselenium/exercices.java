package projetselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class exercices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://www.netflix.com/ci/");
		//System.out.println(driver.getTitle());
		//driver.get("https://www.youtube.com/");
		//driver.getTitle();
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		
		
		driver.get("https://www.netflix.com/ci/");
		System.out.println(driver.getTitle());
		driver.navigate().to("https://pos1-recette-prosuma.retail.groupe-asten.fr/administration/#!/home");
		
		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.netflix.com/ci/");
		System.out.println(driver.getTitle());
		driver.get("https://www.youtube.com/");
		driver.getTitle();*/
		
		driver.close();
		driver.quit();
	}

}
