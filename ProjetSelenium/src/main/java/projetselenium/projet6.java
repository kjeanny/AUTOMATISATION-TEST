package projetselenium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class projet6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-gpu");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--no-sandbox");
	        
	        
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.get("https://pos1-demo-prosuma.retail.groupe-asten.fr/");
		/*driver.findElement(By.name("q")).sendKeys("Voiture 2022") ;
		driver.findElement(By.name("q")).submit();*/
		/*WebElement Recherche = driver.findElement(By.name("q"));
		Recherche.sendKeys("Voiture 2022");
		Recherche.submit();*/
		
		//Administrateur : 123456789www
		
		//Connexion à "https://pos1-demo-prosuma.retail.groupe-asten.fr/"
		
		WebElement login= driver.findElement(By.id("username"));
		WebElement pwd= driver.findElement(By.id("password"));
		login.sendKeys("Administrateur");
		pwd.sendKeys("123456789www");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		System.out.println("Page title: " + driver.getTitle());
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(
			    ExpectedConditions.urlContains("https://pos1-demo-prosuma.retail.groupe-asten.fr/"));
	//driver.quit();
		
	}

}
