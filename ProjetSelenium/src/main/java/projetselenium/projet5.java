package projetselenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class projet5 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 	// Assurez-vous que le chemin vers ChromeDriver est correct
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			
			WebDriverManager.chromedriver().setup();
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			/*driver.get("https://www.udemy.com/");
			
			Point position = driver.manage().window().getPosition();
			System.out.println(position.getX());
			System.out.println(position.getY());
			
			driver.manage().window().setPosition(new Point(300,350));
			
			File scrFile = (File) (((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
			FileUtils.copyFile(scrFile, new File("./image4.jpeg"));
			*/
			 // Aller sur Wikipedia
			driver.get("https://www.wikipedia.org/");
			
			   // Entrer le mot clé dans la barre de recherche
			//driver.findElement(By.name("search")).sendKeys("leadership");
			//driver.findElement(By.id("searchInput")).sendKeys("leadership");
			 WebElement searchBox = driver.findElement(By.name("search"));
		     searchBox.sendKeys("leadership");
			
			// Cliquer sur le bouton "Rechercher"
			/*WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
	        searchButton.click();*/
	        
	        WebElement searchButton = driver.findElement(By.cssSelector("button.pure-button"));
	        searchButton.click();
	        
	        
	        driver.get("https://www.google.com/");
			/*driver.findElement(By.name("q")).sendKeys("Voiture 2022") ;
			driver.findElement(By.name("q")).submit();*/
			WebElement Recherche = driver.findElement(By.name("q"));
			Recherche.sendKeys("Je suisexperte");
			Recherche.submit();

	        
	        try {
	            Thread.sleep(3000); // attendre 3 secondes
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        driver.quit();     
	}
	   
}